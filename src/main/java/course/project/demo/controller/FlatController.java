package course.project.demo.controller;

import course.project.demo.model.Flat;
import course.project.demo.model.Orders;
import course.project.demo.model.User;
import course.project.demo.model.Year;
import course.project.demo.security.MyUserDetails;
import course.project.demo.service.impl.FlatServiceImpl;
import course.project.demo.service.impl.OrdersServiceImpl;
import course.project.demo.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("flat")
public class FlatController {

    private final FlatServiceImpl flatService;

    private final OrdersServiceImpl ordersService;

    private final UserServiceImpl userService;

    public FlatController(FlatServiceImpl flatService, OrdersServiceImpl ordersService, UserServiceImpl userService) {
        this.flatService = flatService;
        this.ordersService = ordersService;
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public String getAllFlats(Model model, Flat flat) {
        model.addAttribute("flat", new Flat());
        model.addAttribute("allFlats", flatService.getAll());
        return "allFlats";
    }

    @PostMapping("/saveReserveFlat")
    public String getFlatIdAndUserIdAndSaveItOnIdInTable(@ModelAttribute("flat") Flat flatFromThymeleaf) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long usersId = userDetails.getId();
        Long flatId = flatFromThymeleaf.getId();
        try {
            User user = userService.findById(usersId).orElseThrow(RuntimeException::new);
            Flat flat = flatService.findById(flatId).orElseThrow(RuntimeException::new);
            Orders orders = new Orders(user, flat);
            ordersService.saveById(orders);
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
        return "redirect:/";
    }

    @GetMapping("/allOrders")
    public String getAllOrdersForAuthenticationUser(Model model) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = userDetails.getId();
        model.addAttribute("orders", ordersService.getAllOrdersForAuthenticatedUser(userId));
        return "myOrders";
    }

    @GetMapping("/createFlat")
    public String createFlat(Model model) {
        model.addAttribute("newFlat", new Flat());
        return "createFlat";
    }

    @PostMapping("/saveFlat")
    public String saveFlat(@ModelAttribute("newFlat") Flat flat) {
        List<Year> list = List.of(new Year(2010, 2012, null));
        flat.setYears(list);
        flatService.saveFlat(flat);
        return "redirect:/flat/getAll";
    }

    @PostMapping("/deleteFlat")
    public String deleteFlat(@ModelAttribute("flat") Flat flat) {
        flatService.deleteFlatById(flat.getId());
        return "redirect:/flat/getAll";
    }

    @PostMapping("/{id}")
    public String deleteOrders(@PathVariable("id") Long id) {
        ordersService.remove(id);
        return "redirect:/flat/allOrders";
    }

    @GetMapping("/sortFlat")
    public String sortFlat(Model model) {
        model.addAttribute("sortList", flatService.getSortedFlatByPrice());
        return "sortedFlatByPrice";
    }

    @GetMapping("/getPageByStreet")
    public String getPageFindByStreet(Model model) {
        model.addAttribute("str", new Flat(""));
        return "getByStreet";
    }

    @PostMapping("/getListOfStreet")
    public String getByStreet(@ModelAttribute("str") Flat flat, Model model) {
        model.addAttribute("listFlatByStreet",flatService.findAllBtStreet(flat.getStreet()));
        return "getAllFlatByStreet";
    }

}
