package com.app.hexagonal.infrastructure.web.convert.mapper;

import com.app.hexagonal.domain.model.ProductModel;
import com.app.hexagonal.infrastructure.web.request.dto.ProductModelRequestDto;

// Conviertes el domain/model a web/request-response dto
public class ProductModelDtoConvertMapper {

  public ProductModel convertRequestToDomain(ProductModelRequestDto requestDto) {
    
    ProductModel pr = new ProductModel();
    pr.setIdProductModel(requestDto.getIdProduct());
    pr.setNameProductModel(requestDto.getName());
    
    return pr;
  }
  
}
