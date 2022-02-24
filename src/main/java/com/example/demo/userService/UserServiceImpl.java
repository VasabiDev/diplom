package com.example.demo.userService;

import com.example.demo.model.User;
import com.example.demo.userDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

@Override
        public List<User> allUsers() {
             return userDao.findAll();
        }

    @Override
        public User add(User user) {
          return userDao.save(user);
        }

    @Override
        public void delete(int id) {
            userDao.deleteById(id);
        }

    @Override
        public void edit(User user) {
            userDao.save(user);
        }

    @Override
        public User getById(int id) {
          return userDao.getOne(id);
        }



}
