package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.ItemCatMapper;
import com.jt.pojo.ItemCat;
import com.jt.vo.EasyUITree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements  ItemCatService{

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public ItemCat findItemCatById(Long id) {

        return itemCatMapper.selectById(id);
    }

    /**
     * 1.根据parentId查询商品分类列表信息  一级商品分类信息
     * 2.将商品分类列表转化为List<VO>对象
     * 3.返回vo的list集合
     * @param parentId
     * @return
     */
    @Override
    public List<EasyUITree> findItemCatList(long parentId) {
        //1.根据父级id查询子级的信息
        QueryWrapper<ItemCat> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", parentId);
        List<ItemCat> itemCatList = itemCatMapper.selectList(queryWrapper);

        //2.将itemCat对象 转化为VO对象
        List<EasyUITree> voList = new ArrayList<>(itemCatList.size());
        for (ItemCat itemCat : itemCatList){
            long id = itemCat.getId();
            String text = itemCat.getName();
            //如果是父级则闭合,否则打开
            String state = itemCat.getIsParent() ? "closed" : "open";
            EasyUITree tree = new EasyUITree(id,text, state);
            voList.add(tree);
        }
        return voList;
    }
}
