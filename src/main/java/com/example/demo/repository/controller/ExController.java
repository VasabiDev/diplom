package com.example.demo.repository.controller;

import com.example.demo.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ExController {

    // дофолтное отображение
    @GetMapping(value = "/")
    public String welcome() {
        return "index";
    }

   // первое входное задание
    @GetMapping("/ex1")
    public String EX1(Model model) {
        return "ex1";
    }

    @GetMapping("/sjdkfrhvEX2")
    public String EX2(Model model) {
        return "ex2";
    }

    @GetMapping("/sjefihsfEX3")
    public String EX3 (Model model) {
        return "ex3";
    }

    @GetMapping("/sljviheiuEX4")
    public String EX4(Model model) {
        return "ex4";
    }


    @PostMapping("jf8u3fuhsEX5")
    public String EX5() {
        return "ex5";
    }


}