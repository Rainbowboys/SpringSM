package com.bigdata.ssm.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bigdata.ssm.mapper.ItemsMapperCustom;
import com.bigdata.ssm.po.ItemCustom;
import com.bigdata.ssm.po.QueryItemsVo;

public class ItemsMapperCustomTest {
	private ApplicationContext applicationContext;

	@Before
	public void initConfig() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
//		String[] names = applicationContext.getBeanDefinitionNames();
//		for (String name : names) {
//			System.out.println(name);
//			
//		}
	}

	@Test
	public void testFindItemsByName() {
		ItemsMapperCustom itemsMapperCustom = (ItemsMapperCustom) applicationContext.getBean("itemsMapperCustom");
		QueryItemsVo queryItemsVo = new QueryItemsVo();
		ItemCustom itemCustom = new ItemCustom();
		itemCustom.setName("ÊÖ»ú");
		queryItemsVo.setItemCustom(itemCustom);
		itemsMapperCustom.findItemsByName(queryItemsVo);
	}

}
