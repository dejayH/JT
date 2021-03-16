package com.jt.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.pojo.ItemDesc;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class TestJson {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Test
    public void object2JSON() throws JsonProcessingException {
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(100L).setItemDesc("json测试").setCreated(new Date())
                .setUpdated(itemDesc.getCreated());
        //将对象转化为JSON  调用对象的get方法  形成属性/属性值
        String json = MAPPER.writeValueAsString(itemDesc);
        System.out.println(json);
        //将JSON串,转化为对象 反射机制 实例化对象  调用对象的set方法为属性赋值
        ItemDesc itemDesc2 = MAPPER.readValue(json, ItemDesc.class);
        System.out.println(itemDesc2.toString());

    }

    public List<ItemDesc> getList(){
        List<ItemDesc> list = new ArrayList<ItemDesc>();
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(100L).setItemDesc("json测试").setCreated(new Date())
                .setUpdated(itemDesc.getCreated());
        ItemDesc itemDesc2 = new ItemDesc();
        itemDesc2.setItemId(100L).setItemDesc("json测试").setCreated(new Date())
                .setUpdated(itemDesc.getCreated());
        list.add(itemDesc);
        list.add(itemDesc2);

        return list;
    }

    @Test
    public void List2JSON() throws JsonProcessingException {
        List<ItemDesc> list = getList();
        //将对象转化为JSON  调用对象的get方法  形成属性/属性值
        String json = MAPPER.writeValueAsString(list);
        System.out.println(json);
        //将JSON串,转化为对象 反射机制 实例化对象  调用对象的set方法为属性赋值
        List<ItemDesc> list2 = MAPPER.readValue(json, List.class);
        System.out.println(list2);

    }
}
