package com.imooc.o2o.service;

import java.util.List;

import com.imooc.o2o.dto.ProductCategoryExecution;
import com.imooc.o2o.entity.ProductCategory;
import com.imooc.o2o.exceptions.ProductCategoryOperationException;


public interface ProductCategoryService {
	
	/**
	 * 查询指定某个店铺下的所有商品类别信息
	 * @param shopCategoryCondition
	 * @return
	 */
	List<ProductCategory> getProductCategoryList(long shopId);
	/**
	 * 批量增加商品分类
	 * @param productCategoryList
	 * @return
	 * @throws ProductCategoryOperationException
	 */
	ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)throws ProductCategoryOperationException;
	/**
	 * 将此类别下的商品里的类别id置为空，再删除商品类别
	 * @param productCategoryId
	 * @param shopId
	 * @return
	 * @throws ProductCategoryOperationException
	 */
	ProductCategoryExecution deleteProductCategory(long productCategoryId,long shopId)throws ProductCategoryOperationException;
		
	
}
