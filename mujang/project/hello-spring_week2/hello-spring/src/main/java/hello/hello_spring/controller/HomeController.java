package hello.hello_spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") //그냥 들어오면 home 호출
    public String home() {
        return "home";
    }
}