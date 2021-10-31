package aziz.springsecurity.practice.Spring.Security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
  @GetMapping
  public String getMessage(){
    return "Hello, Welcome";
  }
}
