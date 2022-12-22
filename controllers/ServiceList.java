package com.cleaning.webproject.controllers;

import com.cleaning.webproject.models.CleanService;
import com.cleaning.webproject.models.OrderService;
import com.cleaning.webproject.models.User;
import com.cleaning.webproject.repo.CleanServiceRepository;
import com.cleaning.webproject.repo.OrderRepository;
import com.cleaning.webproject.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ServiceList {

    @Autowired
    private CleanServiceRepository serviceRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepo userRepo;
    private User user;
    private CleanService cleanService;
    private Object NullPointerException;


    @GetMapping("/service_list_unreg")
    public String serviceListUnreg(Model model) {
        Iterable<CleanService> services = serviceRepository.findAll();
        model.addAttribute("services", services);
        return "service-list-unreg";
    }

    @GetMapping("/form_order")
    public String serviceOr(Model model) {
        return "formOrder";
    }

    @PostMapping("/form_order")
    public String serviceOrder(@RequestParam Long user_id, @RequestParam Long service_id, @RequestParam String date_service,
                               @RequestParam String time_service, @RequestParam String add_info, Model model) {
        OrderService orderService = new OrderService(user_id, service_id, date_service, time_service, add_info);
        orderRepository.save(orderService);
        return "redirect:/";
    }
}
