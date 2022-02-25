package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    // дофолтное отображение
    @GetMapping(value = "/")
    public String welcome() {
        return "test";
    }


    // показать всех пользователей
    @GetMapping("/users")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }


    // вызвать форму добавления пользователя
    @GetMapping("/users/add")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "createUserForm";
    }

    // добавить пользователя в базу из формы
    @PostMapping("users/add")
    public String userAddProcess(@RequestParam String name, @RequestParam String email,
                                 @RequestParam String pass, Model model) {
        userService.userAdd(name, email, pass);
        return "redirect:/users";
    }

    // вызвать форму рездактирования пользователя
    @GetMapping("users/edit/{id}")
    public String showUserEditForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }

    // обработать данные из формы редактирования пользователя
    @PostMapping("users/edit/{id}")
    public String userEditProcess(@PathVariable(value = "id") int id,
                                  @RequestParam String name, @RequestParam String email,
                                  @RequestParam String pass, Model model) {
        userService.userEdit(id, name, email, pass);
        return "redirect:/users";
    }

    // удаление пользователя из базы
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {

        userService.delete(userService.getById(id));
        return "redirect:/users";
    }
}