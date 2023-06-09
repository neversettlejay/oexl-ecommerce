package com.oex.ecommerce.service.definition;


import com.oex.ecommerce.dto.ProductData;
import com.oex.ecommerce.enums.ProductType;
import com.oex.ecommerce.model.Product;

import java.util.List;


public interface ProductService {
    public String addProduct(ProductData productData);

    public void reduceProduct(ProductData product, int quantity);

    public List<Product> listProductByProductType(ProductType productType);
    public List<Product> listAllProducts(ProductType productType);


}
