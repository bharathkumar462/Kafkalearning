package com.example.demo.controller;


import com.example.demo.model.Customer;
import com.example.demo.service.StrudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloWorld {
    final String CREATE_CUSTOMER="insert";
    final String UPDATE_CUSTOMER="update";
    final String DELETE_CUSTOMER="delete";
    static int i=0;
    @Autowired
    StrudentService strudentService;


    @GetMapping("/")
    public String create(Model model){
            model.addAttribute("customer", new Customer());
            return "insert";
    }

    @PostMapping("/customer")
    @ResponseBody
    public String greetingSubmit(@ModelAttribute Customer customer) {
        customer.setEventType(CREATE_CUSTOMER);
        strudentService.produceMessage(""+i,customer);
        i++;
        return customer.toString();
    }

    @GetMapping("/update")
    public String update(Model model){
        model.addAttribute("customer", new Customer());
        return "update";
    }

    @PostMapping("/updated")
    @ResponseBody
    public String updated(@ModelAttribute Customer customer){
        customer.setEventType(UPDATE_CUSTOMER);
        strudentService.produceMessage(""+customer.getId(),customer);
        return customer.toString1();
    }

    @GetMapping("/delete")
    public String delete(Model model){
        model.addAttribute("customer", new Customer());
        return "delete";
    }

    @PostMapping("/deleted")
    @ResponseBody
    public String deleted(@ModelAttribute Customer customer){
        customer.setEventType(DELETE_CUSTOMER);
        strudentService.produceMessage(""+customer.getId(),customer);
        return customer.getId()+"";
    }
}
