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
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public ItemCat findItemCatById(Long id) {

        return itemCatMapper.selectById(id);
    }

    /**
     * 查询商品分类列表信息
     *
     * @param parentId
     * @return
     */
    @Override
    public List<EasyUITree> findItemCatList(long parentId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("parent_id", parentId);
        List<ItemCat> list = itemCatMapper.selectList(queryWrapper);

        List<EasyUITree> li = new ArrayList<>(list.size());
        for (ItemCat itemCat : list) {
            long id = itemCat.getId();
            String text = itemCat.getName();
            String state = itemCat.getIsParent() ? "closed" : "open";
            EasyUITree tree = new EasyUITree(id, text, state);
            li.add(tree);
        }

        return li;
    }
}
