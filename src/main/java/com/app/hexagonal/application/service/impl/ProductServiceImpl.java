package com.app.hexagonal.application.service.impl;

import org.springframework.stereotype.Service;

import com.app.hexagonal.application.service.IProductService;
import com.app.hexagonal.domain.facade.service.IProductFacadeService;
import com.app.hexagonal.domain.model.ProductModel;

@Service
public class ProductServiceImpl implements IProductService {

  private final IProductFacadeService productFacadeService;

  public ProductServiceImpl(IProductFacadeService productFacadeService) {
    this.productFacadeService = productFacadeService;
  }

  @Override
  public ProductModel logicaNegocioControlador() {
    return productFacadeService.findById();
  }

}
