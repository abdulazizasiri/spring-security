- Web Application Security 

IT is a branch of information security. Some of the common security concerns

1- Cross ssite scripting 

2- SQL Injection

3- Denail of service attack

4- cross-site request forgery

### JWT

What is it? 

- It is a secure way to transmit info from one app to another. 


- It consists of: 

1- Header : it has the algorithm and the type

    - type: JWT
    - alg: WHATEVER

2- Payload: The user information going to be

    - name: 
    - claims: 

3- Singature

    - 256-bit-secret 

## Security with Json Web Token (JWT) how are we going to use it?

- We have: 

    1- Client who will send a request
        - POSt/login, username, password

    2- Application/server/backend: then the application will send back a JWT with other information. 

    3- Then, the application has to send the JWT token with any other request. 

    