package io.azizasiri.spring_angualr.Angular.and.Spring.JWT.constants;

public class SecurityConstanse {
    public static final long EXOIRATION_TIME = 432_000_000; // 5 days long
     public static final String TOKEN_PREFIX = "Bearer ";
     public static final String JWT_TOKEN_HEADER = "Jwt-Token";
     public static final String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified";
     public static final String HET_ARRAYS_LLC = "Get Arrays, LLC";
     public static final String  GET_ARRAYS_ADMINSTRATION = "USerMAnagement portal";
     public static final String AUTHORITIES = "Authorities";
     public static final String FORBIDDEN_MESSAGE = "You need to log in to access this page";
     public static final String ACCESS_DENIED_MESSAGE = "You Don't Have Permission to access this page";
     public static final String OPTIONS_HTTP_METHOD = "OPTIONS";
     public static final String[] PUBLIC_URLS = {"/user/login", "/user/register", "/user/resetpassword/**" , "/user/image/**" };
}
