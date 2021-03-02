package com.cgb.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("user")
public class UserPojo implements Serializable {

    @TableId(type = IdType.AUTO)//标识主键
    private Integer id;
    private Integer age;
    private String name;
    private String sex;

}
