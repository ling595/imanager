package com.three.imanager.service;


import com.three.imanager.dao.UserDao;
import com.three.imanager.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    //插入用户信息
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    public User getByName(String username){
        return userDao.getByName(username);
    }


}
