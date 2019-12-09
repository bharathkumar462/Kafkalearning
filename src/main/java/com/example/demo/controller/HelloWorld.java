package com.example.demo.controller;

import com.example.demo.service.StrudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloWorld {
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
}
