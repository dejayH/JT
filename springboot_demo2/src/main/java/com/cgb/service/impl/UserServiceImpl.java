package com.cgb.service.impl;

import com.cgb.dao.UserDao;
import com.cgb.pojo.UserPojo;
import com.cgb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserPojo> findUser() {

        return userDao.findUser();
    }
}
