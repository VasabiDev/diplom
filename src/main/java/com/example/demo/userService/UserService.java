package com.example.demo.userService;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    public List<User> allUsers();
    public User add(User user);
    public void delete(int id);
    public void edit(User user);
    public User getById(int id) ;
}
