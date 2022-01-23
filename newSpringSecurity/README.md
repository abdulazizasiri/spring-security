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

