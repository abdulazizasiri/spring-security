package aziz.springsecurity.practice.Spring.Security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
  @GetMapping("/")
  public String getMessage(){
    return ("<h1>Hello All</h1>");
  }

  @GetMapping("/admin")
  public String getAdmin(){
    return ("<h1>Hello Admin</h1>");
  }
  @GetMapping("/user")
  public String getUsers(){
    return ("<h1>Hello Admin and User</h1>");
  }
}
