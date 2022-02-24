package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.example.demo.userService.UserService;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

import static java.lang.String.valueOf;


@Controller
public class UserController {
    @Autowired
    private UserService userService;







    // дофолтное отображение
    @GetMapping(value = "/")
    public String welcome() {
        return "test";
    }

//    // показать всех пользователей
//    @GetMapping(value = "/users")
//    public String allUsers(ModelMap model) {
//        List<User> userList = userService.allUsers();
//        model.addAttribute("users", userList);
//        return "users";
//    }

    // показать всех пользователей
    @GetMapping( "/users")
    public String allUsers(ModelMap model) {
        List<User> userList = userService.allUsers();
        model.addAttribute("users", userList);
        return "users";
    }







    // вызвать форму добавления пользователя
    @GetMapping( "/users/add")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "createUserForm";
    }

    // добавление пользователя в базу и редирект на главную страницу
    @PostMapping("/users/add")
    public String createUser(User user) {
        userService.add(user);
        return "redirect:/users";
    }









    @PostMapping("users/edit{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }

    @PostMapping( "users/edit")
    public String edit(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/";
    }

        @GetMapping("users/delete")
        public String deleteUserById ( @PathVariable(value = "id") int id){
            userService.delete(id);
            return "redirect:/users";
        }
    @RequestMapping(value="/users/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteTeam(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("users");
        userService.delete(id);

        return modelAndView;
    }
        @GetMapping("users/{id}")
        public String show ( @PathVariable("id") int id, ModelMap modelMap){
            modelMap.addAttribute("user", userService.getById(id));
            return "show";
        }


}