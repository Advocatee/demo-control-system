package course.project.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    
    @GetMapping("/")
    public String moveToMainPage() {
        return "index";
    }

    @GetMapping("/all")
    public String moveForAllPage() {
        return "all";
    }

    @GetMapping("/user")
    public String moveToUserPage() {
        return "user";
    }

    @GetMapping("/admin")
    public String moveToAdminPage() {
        return "admin";
    }

}
