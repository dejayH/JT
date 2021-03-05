package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jt.pojo.Item;
import com.jt.vo.EasyUITable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.mapper.ItemMapper;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemMapper itemMapper;


	@Override
	public EasyUITable findItemByPage(Integer page, Integer rows) {
		//1.通过分页对象 将page rows 进行参数封装
		IPage iPage = new Page(page,rows);
		QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderByDesc("updated");
		//通过iPage对象封装其他的分页数据
		iPage = itemMapper.selectPage(iPage,queryWrapper);
		long total = iPage.getTotal();
		List<Item> itemList = iPage.getRecords();	//获取当前页的记录
		return new EasyUITable(total,itemList);
	}







	/*@Override
	public EasyUITable findItemByPage(Integer page, Integer rows) {

		//1.获取记录总数
		long total = itemMapper.selectCount(null);

		//2.分页查询
		//sql: select * from tb_item limit 起始位置,查询记录数
		//第一页: select * from tb_item limit 0,20   0-19
		//第二页: select * from tb_item limit 20,20  20-39
		//第三页: select * from tb_item limit 40,20  40-59
		int startIndex = (page-1) * rows;
		List<Item> pageList = itemMapper.findItemByPage(startIndex,rows);
		return new EasyUITable(total,pageList);
	}*/
}
