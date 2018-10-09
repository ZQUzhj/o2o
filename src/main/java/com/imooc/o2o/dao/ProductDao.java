package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Product;

public interface ProductDao {
	
	/**
	 * 插入商品
	 * @param proudct
	 * @return
	 */
	int insertProduct(Product prouduct);
	/**
	 * 通过producId查询唯一的商品
	 * @param productId
	 * @return
	 */
	Product queryProductById(long productId);
	/**
	 * 更新商品信息
	 * @param product
	 * @return
	 */
	int updateProduct(Product product);

}
