package com.cgb.service;


import com.cgb.pojo.UserPojo;

import java.util.List;

public interface UserService {
    List<UserPojo> findUser();
}
