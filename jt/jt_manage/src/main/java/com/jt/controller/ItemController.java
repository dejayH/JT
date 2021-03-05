package com.jt.controller;

import com.jt.pojo.Item;
import com.jt.vo.EasyUITable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.service.ItemService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	/*
	//在bean对象实例化之后执行  一般都是为属性赋值用的

	@PostConstruct
	public void aa(){

	}

	//spring容器对象销毁之前 会执行关闭操作  一般用来释放链接/资源
	@PreDestroy
	public void bb(){

	}*/

	/**
	 * 业务说明: 根据分页实现商品查询
	 * URL地址:	http://localhost:8091/item/query?page=1&rows=20
	 * 参数:	page/rows
	 * 返回值:  EasyUITable
	 */
	@RequestMapping("/query")
	public EasyUITable findItemByPage(Integer page, Integer rows){

		return itemService.findItemByPage(page,rows);
	}

	
}
