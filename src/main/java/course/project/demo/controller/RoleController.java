package course.project.demo.controller;

import course.project.demo.model.Role;
import course.project.demo.service.impl.RoleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("role")
public class RoleController {

    private final RoleServiceImpl roleService;

    public RoleController(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/createRole")
    public String createRole(Model model) {
        model.addAttribute("newRole", new Role());
        return "createRole";
    }

    @PostMapping
    public String saveRole(@ModelAttribute("newRole") Role role) {
        roleService.save(role);
        return "redirect:/role/allRoles";
    }

    @GetMapping("/allRoles")
    public String getAllRoles(Model model) {
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "allRoles";
    }

    @PostMapping("/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        roleService.remove(id);
        return "redirect:/role/allRoles";
    }

}
