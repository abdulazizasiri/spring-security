package io.azizasiri.spring_angualr.Angular.and.Spring.JWT.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.azizasiri.spring_angualr.Angular.and.Spring.JWT.constants.SecurityConstanse;
import io.azizasiri.spring_angualr.Angular.and.Spring.JWT.domain.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


// This class overwrite the default error message when something goes wrong when authenticating a user.

public class JwtAuthenticationEntryPoint extends Http403ForbiddenEntryPoint {

    // This is for forbidden request
    // This is for not authentication users handler
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2)
            throws IOException {
        HttpResponse httpResponse = new HttpResponse(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN,HttpStatus.FORBIDDEN.getReasonPhrase().toUpperCase(), SecurityConstanse.FORBIDDEN_MESSAGE );
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
        response.setContentType(APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.FORBIDDEN.value());
        OutputStream outputStream = response.getOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();
         objectMapper.writeValue(outputStream, httpResponse);
         outputStream.flush();
    }

}
