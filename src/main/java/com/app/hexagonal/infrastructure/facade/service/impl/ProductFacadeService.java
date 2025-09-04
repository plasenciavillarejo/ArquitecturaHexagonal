package com.app.hexagonal.infrastructure.facade.service.impl;

import org.springframework.stereotype.Service;

import com.app.hexagonal.domain.facade.service.IProductFacadeService;
import com.app.hexagonal.domain.model.ProductModel;
import com.app.hexagonal.infrastructure.convert.mapper.ProductEntityToModelConvertMapper;
import com.app.hexagonal.infrastructure.dao.IProductDao;

@Service
public class ProductFacadeService implements IProductFacadeService {

  private final IProductDao productDao;
  private final ProductEntityToModelConvertMapper productEntityToModelConvertMapper;

  public ProductFacadeService(IProductDao productDao,
      ProductEntityToModelConvertMapper productEntityToModelConvertMapper) {
    this.productDao = productDao;
    this.productEntityToModelConvertMapper = productEntityToModelConvertMapper;
  }

  @Override
  public ProductModel findById() {
    return productEntityToModelConvertMapper.convertEntityToModel(productDao.findById());
  }

}
