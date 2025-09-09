package com.app.hexagonal.application.port.out;

import com.app.hexagonal.domain.model.ProductModel;

public interface IProductRepositoryPort {

  public ProductModel findById();
 
  public void guardarProducto(ProductModel productModel);
  
}
