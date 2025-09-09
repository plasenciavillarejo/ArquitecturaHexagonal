package com.app.hexagonal.application.service.facade;

import com.app.hexagonal.domain.model.ProductModel;

public interface IProductFacadeService {

  public ProductModel findById();
 
  public void guardarProducto(ProductModel productModel);
  
}
