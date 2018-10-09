package com.imooc.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ImageHolder;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.enums.ShopStateEnum;
import com.imooc.o2o.exceptions.ShopOperationException;

public class ShopServiceTest extends BaseTest{
	@Autowired
	private ShopService shopService;
	
	private static String separator=System.getProperty("file.separator");
	
	@Test
	public void testGetShopList() {
		Shop shopCondition=new Shop();
		ShopCategory sc=new ShopCategory();
		sc.setShopCategoryId(1L);
		shopCondition.setShopCategory(sc);
		ShopExecution se=shopService.getShopList(shopCondition, 1, 5);
	
		System.out.println("店铺列表数："+se.getShopList().size());
		System.out.println("店铺总数："+se.getCount());
	}
	
	
	@Test
	public void testModifyShop() throws ShopOperationException,FileNotFoundException {
		Shop shop=new Shop();
		shop.setShopId(31L);
		shop.setShopName("修改后的店铺名称");
		File shopImg=new File("C:/Users/Administrator/Desktop/1.jpg");
		InputStream is=new FileInputStream(shopImg);
		ImageHolder  imageHolder=new ImageHolder("1.jpg", is);
		ShopExecution shopExecution=shopService.modifyShop(shop, imageHolder);
		System.out.println("新的图片地址为:"+shopExecution.getShop().getShopImg());
	}
	
	@Test
	public void testAddShop() throws FileNotFoundException {
		Shop shop=new Shop();
		PersonInfo owner=new PersonInfo();
		Area area=new Area();
		ShopCategory shopCategory=new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(2);
		shopCategory.setShopCategoryId(1L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("test店铺3");
		shop.setShopDesc("test3");
		shop.setShopAddr("test3");
		shop.setPhone("test3");
		//shop.setShopImg("test");
		shop.setCreateTime(new Date());

		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("审核中");
		File shopImg=new File("C:/Users/Administrator/Desktop/2.jpg");
		FileInputStream is=new FileInputStream(shopImg);
		ImageHolder  imageHolder=new ImageHolder(shopImg.getName(), is);
		ShopExecution se=shopService.addShop(shop, imageHolder);
		assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
	}
	
	@Test
	public void testFileExist() {
		/*File shopImg=new File("C:/Users/Administrator/Desktop/2.jpg");
		System.out.println(shopImg.exists());*/
		String imagePath=new String("/abc/"); 
		System.out.println(separator);
		//imagePath=imagePath.replace("/", seperator);
		System.out.println(imagePath);
	}
}
