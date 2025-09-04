package com.app.hexagonal.domain.facade.service;

import com.app.hexagonal.domain.model.ProductModel;

public interface IProductFacadeService {

  public ProductModel findById();
  
}
