# spring-security

Main concepts in Spring Security


- Why Spring Security? 

Spring Security help us do Application level security. 


It has the following:


1- Login and Logout funtionallity.


2- Allow/Block access to URLs to loggedd in users.


3- Allow/Block access to URLs to loggede in users AND with certain roles.


4- Widely adopted


5- Results in few vulnerabilities long-term



- Spring Security handles common vulnerabilities such as


1- Session fixation

2- Clickjacking

3- click site request forgery



- Things we can do in Spring security


1- Username and passoword authentication

2- SSO/ OOkta/LDAP 

3- It adds App level authorization

4- Intra App Authorization like OAuth 

5- It allows to create microserevice security (using token and JWT)

6- It adds method level security (this is a way to secure methods , objects in my code)



### Video 2 Application Security key words


1- Authentication: this is asking who are you? This requires providing some identification that proves who you are. 

- In the application level, this maybe something like: username and password which get checked by the system that proves ur identity. 


This is called "Konweledge Based authentication"

Addvanteges: It is simple


Dis: Not very safe. 


Solution: We incoporate a possession based authentication


Which test if you are in possession of something that receives a token or a code that test if you  really have it. 


This is called Multi-factor auth


2- Authorization

Authrization asks, Can this user do this? Yes/No 



3- Principal 


The principal is the currentlyy logged in user. 


4- Granted Authorities: 



5- Roles 


A role is a group of authorities 



### Filters 



### 4 Authentication and Configuration of AuthenticationManager


### 5: Authorizattion

By default all API endpoints need authentication in a Spring Security App.

- Content taken from Java Brains: https://www.youtube.com/watch?v=sm-8qfMWEV8&list=PLqq-6Pq4lTTYTEooakHchTGglSvkZAjnE


git merge --abort
