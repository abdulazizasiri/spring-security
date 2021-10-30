### This is spring Security 

It is very important to understand security for the application.

## Shy Spring Security

Application security frameworks

- Login and logout functionallity

- Allow/block access ti URLs ti logged in users

- Allow/block access ti URLs to logged in users and with certain roles.

- Handles common vulnerability such as
    - Session fixation

    - Clickjacking

    - Click site request forgery (CSRF)

    - Spring security is very widely adopted 


### What can we do with spring security

- User name / password authentication

- SSO / Okta / LDAP

- App level authorization

- Intra PP authorization like OAuth

- We can do Microservice Security (using tokens, JWT)

- Method level security


## The 5 Core concepts in Spring security

### One Authentication and Authorization

- Authentication is answeting "Who you are"? 

The security guard will not let anyone in the system until we provide who we are

Usually we need to provide something like an Id to let him trust us and let us in.

- This is called <code> Knowledge based authentication </code>, example, 

    - Password

    - Pin code 

    - Answer to a secret / personal question

- Another example of authentication is something called <code> Possession based authentication </code> example, 

    - Phone number

    - Key cards and badges

    - Access token device


- Another example of authentication is something called <code>Multi factor authentication </code> which is a mix of the two above


### Number 2  Authorization

authorization is asking "Can this user do this"? 

What are users allowed to do? 


### Number 3 Principal


The principal is a person that we have identified through authentication.

It is the currently logged in user. 

### Number 4 Graanted Authority 

This is responsible for grant a user the permission to do what they are allowed to do.

###  Number 5 Role 

Roles are a group of authroties/ granted authorities



## Adding Spring security

IF you want to add spring security first we need to add a dependency 

<code> spring-boot-starter-security </code>


- Filters: 

- After adding it, we would have to configure our application manually

There few classes that we have to implement 