### Spring Security Again 

This concept helps us create application level security. things like

- Login and logout functionallity 

- Allow/block access to URLs to logged in users. 

- Allow/block access to URLs to logged in users AND with certains roles. 


- Handes commoon vulnerability such as 

    1- Session fixation
    2- Clickjacking
    3- Click sote request forgery 

- Widely adopted

- Things we can do with Spring securty

    1- Username and password auth
    2- SSO/ Okta LDAP 
    3- App level authorization
    4-  Intra app authorization like OAuth
    5- Micsoservicews security
    6- Method level securty

### Spring Security video 2 


Authentication and Authorization 

Authentication - Who you are? 

Authorization: Can you do what you asked to be doing? 

- What is a principal in Spring? 

A person a system idetified in the process of authentication in other words is the "currently logged in user" 

- Authority vs Priviliges vs Role? 

- Role: It is a group of authority that are assigned together

#### Filters  Video 3

Filters in Spring is a layer inside the web app that intercept every http request that goes into the controller or back to the client. 

Spring security by defaulta adds the following 

- Adds mandatory authentication for URLs


- Adds a login form

- Handles login error

## Spring Security Configuration Video 4


- The way we configure spring security is by affecting the <code> AuthenticationManager</code>


- You can imagain an <code> AuthenticationManager</code> setting inside a spring security app. 


- Note: We do not work with the  <code> AuthenticationManager</code> directly, instead,  <code> AuthenticationManagerBuilder</code>


- What do we use  <code> AuthenticationManagerBuilder</code> for?


    1- Get aa hold of AuthenticationManagerBuider

    2- Set the configuration on it. 

    3- The AuthenticationManagerBuider start asking us few quesstions. 

        A- AMB: What type of authentication do you need? 
        - Me: in memory for example
        B- AMB: What is the username, password and the role of the user? 
        - Me: username: , pass: , and role: 

        Then,  an AuthenticationManager gets created :)

    
- How do we get a hold of the AuthenticationMAnagerBuilder? 

    In spring security app, there is a class that sets there which has a method called <code>configure (AuthenticationManagerBuilder) </code>

    - Note: We need to extend this class and override the configure method. 



### Steps 

1- Create a configuration package 

2- Create a configuration class for security. You can name it anything you wish

3- <code> extends WebSecurityConfigurerAdapter</code>  class

4- Override some methods to create an  AuthenticationManager. 

5- We need to override: 

    1- configure (AuthenticationManager auth)


6- We need to make this class annotated with 
<code>@EnableSecurity </code>

## Configure Authorization Video 5

### API                         ROLES allows to access it

1- /                             Accessible by everyone 


2- /user                        USER and ADMIN roles


3- /admin                       ADMIN role


- Implement the configure (HttpSecurity name) method


NOTE: 

1- configure (AuthenticationManagerBuilder name)  used for authentication. 

2- configure (HttpSecurity name)  used for authorization


### How Spring Security works? 

- AuthenticationProviders: It is the thing that does the authentication. 



### Spring JDBC authentication 


-  We need to create the datasource

- Let spring access it and use the default schema



## Mysql + JPA authentication 

Will fill it out later

## LDAP 

Skipped 


### What is JWT authorization really about? 

There are multiple ways to do authorizations (Authorization strategies)

- Session token - Reference token (check the session id in the server)

- JSON Web Token (JWT) value token

The idea is that when we get authenticated, the server creates a session id. In the client side, this session id gets stored in a cookie. 


This approach has been working fine for quit some time, but it has some issues. 


1- We might have more than one server (load balancer distrbuting the routes), in this case, we need to stored our session id in all of them. it is tedious 

2- 

### JWT Structure 

There are three parts in the JWT token ordered as follows: 

1- Header

2- Payload: holds information. 

3- Signature

- When someone gets authenticated to  a system (userName, Password), then the server checks these info, and if the user exist,  the server

1- Create a JWT with the name of the user

2- The server then sends back the JWT to the user. 

3- The user then saves it to some sort of a storage 

    - Client side localstorage 
    - Cookie


4- the user has to use it in every subsequent request.
This happens in the HTTP header. 

- Note: HTTP header is a key value pair. 
    
    Authorization:
                    Bearer: JWT

5- The server then validatees this value in the header

- How it does that is by: it does base64 for the header + payload
then, compute the  signature after that it compares it with the original signature. 


        






