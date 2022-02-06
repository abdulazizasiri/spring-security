package io.azizasiri.spring_angualr.Angular.and.Spring.JWT.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.azizasiri.spring_angualr.Angular.and.Spring.JWT.constants.SecurityConstanse;
import io.azizasiri.spring_angualr.Angular.and.Spring.JWT.domain.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


// This class is for handling things regarding authorization.
// IF the user has not enough authorities to do something.
@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        HttpResponse httpResponse = new HttpResponse(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED,HttpStatus.UNAUTHORIZED.getReasonPhrase().toUpperCase(), SecurityConstanse.FORBIDDEN_MESSAGE );
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
        response.setContentType(APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        OutputStream outputStream = response.getOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(outputStream, httpResponse);
        outputStream.flush();
    }
}
