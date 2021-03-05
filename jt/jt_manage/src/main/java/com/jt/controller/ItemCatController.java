package com.jt.controller;

import com.jt.pojo.ItemCat;
import com.jt.service.ItemCatService;
import com.jt.vo.EasyUITree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/itemCat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    /**
     * 业务需求: 根据商品分类Id查询商品分类对象
     * URL地址: /itemCat/findItemCatById?id=497
     * 类型: Request Method: GET
     * 参数: id
     * 返回值: ItemCat对象
     */
    @RequestMapping("/itemCat/findItemCatById")
    public ItemCat findItemCatById(Long id) {

        return itemCatService.findItemCatById(id);
    }

    @RequestMapping("/item/cat/list")
    public List<EasyUITree> findItemCatList(Long id) {
        //查询商品分类信息
        long parentId = 0;
        if (id != null) {
            parentId = id;
        }

        return itemCatService.findItemCatList(parentId);
    }


}
