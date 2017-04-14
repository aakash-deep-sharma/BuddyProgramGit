package org.onlineshoppingportal.dao;

import org.onlineshoppingportal.entity.Product;
import org.onlineshoppingportal.model.PaginationResult;
import org.onlineshoppingportal.model.ProductInfo;

public interface ProductDao {

	public Product findProduct(String code);
      
    public PaginationResult<ProductInfo> queryProducts(int page,
                       int maxResult, int maxNavigationPage  );
    
    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult,
                       int maxNavigationPage, String likeName);
}
