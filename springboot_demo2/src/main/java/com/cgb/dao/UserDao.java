package com.cgb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cgb.pojo.UserPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface UserDao extends BaseMapper<UserPojo> {
    List<UserPojo> findUser();
}
