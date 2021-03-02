package com.cgb;

import com.cgb.dao.UserDao;
import com.cgb.pojo.UserPojo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootDemo2ApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        System.out.println(userDao.findUser());
    }

    @Test
    public void testMP(){
        List<UserPojo> user= userDao.selectList(null);
        System.out.println(user);

    }

}
