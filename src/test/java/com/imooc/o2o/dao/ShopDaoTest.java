package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;

public class ShopDaoTest extends BaseTest{
	
	@Autowired
	private ShopDao shopDao;
	
	@Test
	public void testQueryShopListAndCount() {
		Shop shopCondition=new Shop();
		PersonInfo owner=new PersonInfo();
		owner.setUserId(1L);
		shopCondition.setOwner(owner);
		List<Shop> shopList=shopDao.queryShopList(shopCondition, 0, 5);
		int count=shopDao.queryShopCount(shopCondition);
		System.out.println("店铺列表的大小"+shopList.size());
		System.out.println("店铺总数"+count);
		
		ShopCategory sc=new ShopCategory();
		sc.setShopCategoryId(2L);
		shopCondition.setShopCategory(sc);
		shopList=shopDao.queryShopList(shopCondition, 0, 5);
		count=shopDao.queryShopCount(shopCondition);
		System.out.println("xin店铺列表的大小"+shopList.size());
		System.out.println("xin店铺总数"+count);
	}
	
	
	@Test
	public void testInsertShop() {
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
		shop.setShopName("test店铺");
		shop.setShopDesc("test");
		shop.setShopAddr("test");
		shop.setPhone("test");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());

		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		
		int effectdNum=shopDao.insertShop(shop);
		assertEquals(1, effectdNum);

	}

	@Test
	public void testUpdateShop() {
		Shop shop=new Shop();
		shop.setShopId(1L);
		shop.setLastEditTime(new Date());
	
		shop.setShopDesc("测试描述");
		shop.setShopAddr("测试地址");
	
		
		int effectdNum=shopDao.updateShop(shop);
		assertEquals(1, effectdNum);

	}

	@Test
	public void testQueryShop() {
		Long shopId=1L;
		Shop shop=shopDao.queryByShop(shopId);
		System.out.println("areaId:"+shop.getArea().getAreaId());
		System.out.println("areaName:"+shop.getArea().getAreaName());

	}

}
