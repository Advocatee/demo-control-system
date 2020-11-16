package course.project.demo.controller;

import course.project.demo.model.User;
import course.project.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

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

    @PostMapping("/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        userService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/allUsers")
    public String getAllUsers(Model model) {
        model.addAttribute("allUsers", userService.getAll());
        return "allUsers";
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("newUser", new User());
        return "createUser";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("newUser") User user) {
        userService.saveUser(user);
        return "redirect:/users/allUsers";
    }


}
