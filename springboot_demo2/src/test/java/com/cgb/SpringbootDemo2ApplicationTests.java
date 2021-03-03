package com.cgb;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cgb.dao.UserDao;
import com.cgb.pojo.UserPojo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Test
    public void insert(){
        UserPojo user = new UserPojo();
        user.setName("猴子").setAge(800).setSex("女");
        userDao.insert(user);

    }

    @Test
    public void select(){
        UserPojo user = userDao.selectById(5);
        System.out.println(user);

        UserPojo u = new UserPojo();
        u.setName("唐僧").setAge(30);
        QueryWrapper queryWrapper = new QueryWrapper(u);
        UserPojo u3 = userDao.selectOne(queryWrapper);
        System.out.println(u3);

    }

    /**
     * = < >
     */
    @Test
    public void select2(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.gt("age", 18);
        queryWrapper.eq("sex", "女");
        List list = userDao.selectList(queryWrapper);
        System.out.println(list);
    }

    /**
     * LIKE
     */
    @Test
    public void select3(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("name", "精");
        queryWrapper.eq("sex", "女");


    }

    /**
     * not null   排序
     */
    @Test
    public void select4(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.gt("age", 18);
        queryWrapper.isNotNull("name");
        queryWrapper.orderByDesc("age");
        List list = userDao.selectList(queryWrapper);
        System.out.println(list);
    }

    @Test
    public void select5(){
        UserPojo user = new UserPojo();
        user.setAge(18);
        user.setSex("");
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.gt(user.getAge() != null && user.getAge() >0, "age", user.getAge());
        queryWrapper.eq(user.getSex() != null && !user.getSex().equals(""),"sex",user.getSex());
        List list = userDao.selectList(queryWrapper);
        System.out.println(list);
    }

    @Test
    public void s(){
        Integer[] ids = {1,3,5,7,9};
        List<Integer> id = Arrays.asList(ids);
//        List i = new ArrayList();
//        for (int idt : ids) {
//            i.add(idt);
//        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.in("id", id);
        List list = userDao.selectList(queryWrapper);
        System.out.println(list);

        //方法2
        List<UserPojo> userPojos = userDao.selectBatchIds(id);
        System.out.println(userPojos);
    }

    @Test
    public void delete(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.isNull("name");
        userDao.delete(queryWrapper);
    }

    @Test
    public void update(){
        UserPojo user = new UserPojo();
        user.setId(54).setName("speed").setAge(9524).setSex("未知");
        userDao.updateById(user);

        UserPojo user1 = new UserPojo();
        user1.setAge(7643).setSex("男");
        UpdateWrapper up = new UpdateWrapper<>();
        up.eq("name", "speed");
        userDao.update(user1,up);
    }

}
