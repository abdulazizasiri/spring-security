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