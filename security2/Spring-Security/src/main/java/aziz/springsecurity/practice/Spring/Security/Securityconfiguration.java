package aziz.springsecurity.practice.Spring.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class Securityconfiguration  extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    super.configure(auth);

    auth.inMemoryAuthentication()
      .withUser("blah")
      .password("blah")
      .roles("USER")
      .and()
      .withUser("foo")
      .password("foo")
      .roles("ADMIN");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
//    super.configure(http);
    http.authorizeRequests()
      .antMatchers("/admin").hasRole("ADMIN")
      .antMatchers("/user").hasAnyRole("USER", "ADMIN")
      .antMatchers("/").hasAnyRole()
      .and().formLogin();

  }

  @Bean
  public PasswordEncoder getPasswordEncoder() {
    System.out.println("Passsword encoder");
    return NoOpPasswordEncoder.getInstance();
  }
}
