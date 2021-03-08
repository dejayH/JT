package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("tb_item_desc")
public class ItemDesc extends BasePojo{
    @TableId
    private Integer id;

    private String itemDesc;
}
