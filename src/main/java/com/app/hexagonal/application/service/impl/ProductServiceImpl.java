package com.app.hexagonal.application.service.impl;

import org.springframework.stereotype.Service;

import com.app.hexagonal.application.service.IProductService;
import com.app.hexagonal.application.service.facade.IProductFacadeService;
import com.app.hexagonal.domain.model.ProductModel;

// Lógica de negocio exclusiva del controlador
@Service
public class ProductServiceImpl implements IProductService {

  private final IProductFacadeService productFacadeService;

  public ProductServiceImpl(IProductFacadeService productFacadeService) {
    this.productFacadeService = productFacadeService;
  }

  @Override
  public ProductModel logicaNegocioControlador() {
    // Puede realizar diferentes lógicas de negocio
    return productFacadeService.findById();
  }

  @Override
  public void actualizarProducto(ProductModel productModel) {
    // Puede realizar diferentes lógicas de negocio
    productFacadeService.guardarProducto(productModel);
    
  }

}
