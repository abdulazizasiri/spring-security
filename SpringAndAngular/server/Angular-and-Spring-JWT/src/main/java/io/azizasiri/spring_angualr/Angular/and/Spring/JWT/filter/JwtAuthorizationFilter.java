package io.azizasiri.spring_angualr.Angular.and.Spring.JWT.filter;
import io.azizasiri.spring_angualr.Angular.and.Spring.JWT.constants.SecurityConstanse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.azizasiri.spring_angualr.Angular.and.Spring.JWT.utility.JWTTokenProvider;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


// This io.azizasiri.spring_angualr.Angular.and.Spring.JWT.filter is going to fire once per request.
@Component
public class JwtAuthorizationFilter  extends OncePerRequestFilter{
    // This class is responisble for filtering the request.
    // Its main purpose is to get the header information
    // What we do in this code is the following starting from the doFilterInternal method:
            // 1- First the coming request was of type "Options" then we need to pass.
                    // OPTIONS is sent before any request to check the status of the server
            // 2- we get the header of the request which contains "Authorization"
            // 3- If it is null or does have the "Bearer", then we are done
            // 4- If passes, then we need to get the token
            // 5- After getting the token we need to the subject || username
            // 6- Verify if it is valid && there is no the Security getContext is null
            // 7- we get all authorities of this user and
            // 8- We get an authentication and store it in the Security context
            // Else , we need to clear the context

    private JWTTokenProvider jwtTokenProvider;

    public JwtAuthorizationFilter(JWTTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // This gets sent before every request: Options
        if(request.getMethod().equalsIgnoreCase(SecurityConstanse.OPTIONS_HTTP_METHOD)) {
            response.setStatus(HttpStatus.OK.value());
        } else {
            String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (authorizationHeader == null || !authorizationHeader.startsWith(SecurityConstanse.TOKEN_PREFIX)) {
                filterChain.doFilter(request, response);
                return ;
            }
            String token = authorizationHeader.substring(SecurityConstanse.TOKEN_PREFIX.length());
            String userename = jwtTokenProvider.getSubject(token);
            if(jwtTokenProvider.isTokenValid(userename, token) && SecurityContextHolder.getContext().getAuthentication() == null) {
                List<GrantedAuthority> authorities = jwtTokenProvider.getAuthorities(token);
                Authentication authentication = jwtTokenProvider.getAuthentication(userename,authorities, request );
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                SecurityContextHolder.clearContext();
            }
        }
        filterChain.doFilter(request, response);
    }
}
