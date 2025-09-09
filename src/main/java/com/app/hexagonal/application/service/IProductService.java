package com.app.hexagonal.application.service;

import com.app.hexagonal.domain.model.ProductModel;

public interface IProductService {

  public ProductModel logicaNegocioControlador();

  public void actualizarProducto(ProductModel productModel); 
  
}
