package com.example.demo.controller;


import com.example.demo.model.Customer;
import com.example.demo.service.StrudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloWorld {
static int i=0;
    @Autowired
    StrudentService strudentService;

    @GetMapping("/students")
    @ResponseBody
    public String students() {
        strudentService.produceMessages();
        return "true";
    }

    @GetMapping("/produce")
    @ResponseBody
    public String produce(@RequestParam String msg) {
        strudentService.produceMessage(msg);
        return "true";
    }

    @GetMapping("/listenable")
    @ResponseBody
    public String studentsFuture() {
        strudentService.sendMessage("listenable future");

        return "true";
    }


    @GetMapping("/")
    public String create(Model model){
            model.addAttribute("customer", new Customer());
            return "insert";
    }

    @PostMapping("/customer")
    @ResponseBody
    public String greetingSubmit(@ModelAttribute Customer customer) {
        strudentService.produceMessage(""+i,customer.toString());
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
        strudentService.produceMessage(""+customer.getId(),customer.toString1());
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
        strudentService.produceMessage(""+customer.getId(),customer.getId()+"");
        return customer.getId()+"";
    }
}
