package io.azizasiri.spring_angualr.Angular.and.Spring.JWT.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import io.azizasiri.spring_angualr.Angular.and.Spring.JWT.constants.SecurityConstanse;
import io.azizasiri.spring_angualr.Angular.and.Spring.JWT.domain.UserPrincipal;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JWTTokenProvider {
    @Value("${jwt.secret}")
    private String secret ; // This should be stored in a proprty file

    public String generateJwtToken(UserPrincipal userPrincipal){
        // Get all claims for this user.

        String [] claims = getClaimsFromUser(userPrincipal);

        return JWT.create().withIssuer(SecurityConstanse.HET_ARRAYS_LLC).withAudience(SecurityConstanse.GET_ARRAYS_ADMINSTRATION)
                .withIssuedAt(new Date()).withSubject(userPrincipal.getUsername()).
                withArrayClaim(SecurityConstanse.AUTHORITIES, claims).withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstanse.EXOIRATION_TIME))
                .sign(Algorithm.HMAC512(secret.getBytes()));
    }

    public List<GrantedAuthority> getAuthorities(String token) {
        String [] claims = getClaimsFromToken(token);
        return Arrays.stream(claims).map(SimpleGrantedAuthority::new).collect(Collectors.toList());

    }

    public boolean isTokenValid(String username, String token) {
        JWTVerifier verifier = getjwtVerifier();

        return StringUtils.isNotEmpty(username) && !isTokenExpired(verifier, token);
    }

    private boolean isTokenExpired(JWTVerifier verifier, String token) {

        Date expiration = verifier.verify(token).getExpiresAt(); // We need to check if it does not pass the 5 time window
        System.out.println("Get Expiration At: "+expiration);
        return expiration.before(new Date());
    }
    public String getSubject(String token) {
        JWTVerifier verifier = getjwtVerifier();
        return verifier.verify(token).getSubject();
    }

    public Authentication getAuthentication(String username, List<GrantedAuthority> authorities, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                username, null, authorities);
        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));// setting up information about this user, in the spring security context
        return usernamePasswordAuthenticationToken;
    }

    private String[] getClaimsFromToken(String token) {
        JWTVerifier jwtVerifier = getjwtVerifier();
        return jwtVerifier.verify(token).getClaim(SecurityConstanse.AUTHORITIES).asArray(String.class);
    }

    private JWTVerifier getjwtVerifier() {
        JWTVerifier jwtVerifier;
        try {
            Algorithm algorithm = Algorithm.HMAC512(secret);
            jwtVerifier = JWT.require(algorithm).withIssuer(SecurityConstanse.HET_ARRAYS_LLC).build();

        }catch(JWTVerificationException jwtVerificationException) {
            throw new JWTVerificationException(SecurityConstanse.TOKEN_CANNOT_BE_VERIFIED);
        }
        return jwtVerifier;
    }

    private String[] getClaimsFromUser(UserPrincipal userPrincipal) {
        List<String> authorities = new ArrayList<>();
        for (GrantedAuthority grantedAuthority : userPrincipal.getAuthorities()) {
            authorities.add(grantedAuthority.getAuthority());
        }
        return authorities.toArray(new String[0]);
    }
}
