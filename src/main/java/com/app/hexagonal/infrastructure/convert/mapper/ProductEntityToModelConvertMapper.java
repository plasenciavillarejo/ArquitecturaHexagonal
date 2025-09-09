package com.app.hexagonal.infrastructure.convert.mapper;

import org.springframework.stereotype.Component;

import com.app.hexagonal.domain.model.ProductModel;
import com.app.hexagonal.infrastructure.entity.ProductEntity;

@Component
public class ProductEntityToModelConvertMapper {

  public ProductModel convertEntityToModel(ProductEntity productEntity) {
    ProductModel pm = new ProductModel();
    pm.setIdProductModel(productEntity.getIdEntity());
    pm.setNameProductModel(productEntity.getNameEntity());
    return pm;
  }
  
  public ProductEntity convertModelToEntity(ProductModel pm) {
    ProductEntity pe = new ProductEntity(); 
    pe.setIdEntity(pm.getIdProductModel());
    pe.setNameEntity(pm.getNameProductModel());    
    return pe;
  }

}
