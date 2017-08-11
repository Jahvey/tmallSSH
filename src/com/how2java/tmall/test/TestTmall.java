/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.how2java.tmall.test;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.how2java.tmall.dao.impl.DAOImpl;
import com.how2java.tmall.pojo.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestTmall {
	@Autowired
	DAOImpl dao;

	@Test
	public void delete() {
		DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
		List<Category> cs = dao.findByCriteria(dc);
		for (Category c : cs) {
			dao.delete(c);
		}
	}

	@Test
	public void test() {
		DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
		List<Category> cs = dao.findByCriteria(dc);
		if (cs.isEmpty()) {
			for (int i = 0; i < 10; i++) {
				Category c = new Category();
				c.setName("���Է���" + (i + 1));
				Integer x =(Integer) dao.save(c);
				System.out.println(x);
			}
			System.out.println("�ɹ����10�����Է���");
		}
	}
}
/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
