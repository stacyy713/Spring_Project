package com.cleaning.webproject.controllers;

import com.cleaning.webproject.models.CleanService;
import com.cleaning.webproject.repo.CleanServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    @Autowired
    private CleanServiceRepository serviceRepository;

    //Вивід списку послуг на сторінці "Послуги"
    @GetMapping("/service_list")
    public String serviceList(Model model) {
        Iterable<CleanService> services = serviceRepository.findAll();
        model.addAttribute("services", services);
        return "service-list";
    }

    @GetMapping("/service_add")
    public String serviceAdd(Model model) {
        return "service-add";
    }

    //Реалізація додавання послуги з форми на сайті
    @PostMapping("/service_add")
    public String servicePostAdd(@RequestParam String name, @RequestParam int price, Model model) {
        CleanService cleanService = new CleanService(name, price);
        serviceRepository.save(cleanService);
        //Після додавання відбувається переадресація на головну сторінку сайту
        return "redirect:/";
    }

    //Реалізація редагування послуг на сайті
    @GetMapping("/service/{id}/edit")
    public String serviceEdit(@PathVariable(value = "id") long id, Model model) {
        if(!serviceRepository.existsById(id)) {
            return "redirect:/service_list";
        }

        Optional<CleanService> cs = serviceRepository.findById(id);
        ArrayList<CleanService> res = new ArrayList<>();
        cs.ifPresent(res::add);
        model.addAttribute("cs", res);
        return "service-edit";
    }

    //Реалізація редагування інформації про послуги з форми на сайті
    @PostMapping("/service/{id}/edit")
    public String servicePostEdit(@PathVariable(value = "id") long id, @RequestParam String name,
                                  @RequestParam int price, Model model) {
        CleanService cleanService = serviceRepository.findById(id).orElseThrow(() -> new IllegalStateException("Такої " +
                "послуги не існує"));
        cleanService.setName_service(name);
        cleanService.setPrice_service(price);
        serviceRepository.save(cleanService);
        //Після редагування відбувається переадресація на головну сторінку сайту
        return "redirect:/";
    }

    //Реалізація видалення послуги з форми на сайті
    @PostMapping("/service/{id}/remove")
    public String servicePostDelete(@PathVariable(value = "id") long id, Model model) {
        CleanService cleanService = serviceRepository.findById(id).orElseThrow(() -> new IllegalStateException("Такої " +
                "послуги не існує"));
        serviceRepository.delete(cleanService);
        //Після видалення відбувається переадресація на головну сторінку сайту
        return "redirect:/";
    }
}
