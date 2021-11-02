### Spring Boot + Spring Security with JPA authentication and MySQL from scratch


- First create a project that uses JPA and security

- Create the database model for users. with username, password, roles, and active

- Add the datsource in the property file for the database with url, username, password and active and the dialct

- Create the security package with a class <code> SecurityConfiguration </code> and implment the configure builder and the configure <code> httpSecurity</code>

The  <code> httpSecurity</code> code for adding authorities is like the following code:

```java
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("I AM HTTPSEC");
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("ADMIN", "USER")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }

```

The  <code> configure: Builder </code> method accessing the database is as follows:

```java

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("I AM ABUILDER");
        auth.userDetailsService(userDetailsService);
    }

```


Notice that we are using the <code> UserDetailsService </code> class which is going to be responsible for aaaccess the database. 


- We <code> @Autowire UserDetailsService </code> aasa follows:

```java

   @Autowired
    UserDetailsService userDetailsService;

```

## 3 We create two classes 

1- <code> MyUserDetails</code>

2- <code> MyUserDetailsService</code>

- The first one is a model

- The second one is responsible for access the databse


- Code for the <code> MyUserDetails</code>

```java


public class MyUserDetails implements UserDetails {
    private String  userName;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;

    public MyUserDetails(User user) {
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.active = user.isActive();
        this.authorities = Arrays.stream(user.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

    }
    public MyUserDetails(){

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}

```

- Code for <code>MyUserDetailsService</code>

```java
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

//        System.out.println("user passed is "+userName);
        Optional<User> user = this.userRepository.findByUserName(userName); // The username we used to authenticate
        user.orElseThrow(() -> new UsernameNotFoundException("User not Found "+userName));
        return user.map(MyUserDetails::new).get();
    }
}

```



### LDAP

- What is <code> LDAP </code>? 

LDAP is a Lightweight Directory Access Protocol. 

It is used to access and maintain distributed directory information services over an internet protocol.

- LDAP can be used for anytype of hierarchical directoy information, but it is very common to use is to store<code> organizational information </code> a typical organization has  departments, managers, people reporting to other people, 


- Creating LDAP server


We can include <code>unblundid </code> to create a simple server.



### Number 4: JWT

- JWT: JSON WEB TOKEN. JWt is also has become very popular in the microservices architecture. 

- JWT is used to manage authorization.

- There is a standarezation that tells how JWT should be structurued which is called <code> RFC 7519</code>


- JWT focus on authorization. 

## Are there are options tha thandles JWT?

- JWT

- Session tokens

-
### Session Tokens 


The server created a session table for every user and then the clinet sends the session saved in the cookie and the the server verifies it. 


### JWT

JWT is not a token, it is a JSON object that has the data and something veryy important which is the  <code> signature</code>

- what are the difference between <code>Session token</code><code>JWT</code>

- Session tokens are reference tokens. 

- JWT  tokens are value tokens. 

- Get it from my PC. 


