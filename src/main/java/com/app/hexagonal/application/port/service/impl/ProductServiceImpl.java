package com.app.hexagonal.application.port.service.impl;

import org.springframework.stereotype.Service;

import com.app.hexagonal.application.port.in.IProductService;
import com.app.hexagonal.application.port.out.IProductRepositoryPort;
import com.app.hexagonal.domain.model.ProductModel;

// Lógica de negocio exclusiva del controlador
@Service
public class ProductServiceImpl implements IProductService {

  private final IProductRepositoryPort productFacadeService;

  public ProductServiceImpl(IProductRepositoryPort productFacadeService) {
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
