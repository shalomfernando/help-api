package com.example.helpapi.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Home")
public class HomeController {

    @RequestMapping("/")
    @ResponseBody
    public String get(){
        return "Shalomito!";
    }
}
