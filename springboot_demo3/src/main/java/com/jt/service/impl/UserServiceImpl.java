package com.jt.service.impl;

import com.jt.dao.UserDao;
import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectUser() {
        List<User> users = userDao.selectList(null);
        return users;
    }
}
