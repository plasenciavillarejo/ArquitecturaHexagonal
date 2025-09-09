package com.app.hexagonal.infrastructure.facade.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.hexagonal.application.service.facade.IProductFacadeService;
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
  @Transactional(readOnly = true)
  public ProductModel findById() {
    return productEntityToModelConvertMapper.convertEntityToModel(productDao.findById());
  }

  @Override
  @Transactional
  public void guardarProducto(ProductModel productModel) {
    productDao.save(productEntityToModelConvertMapper.convertModelToEntity(productModel));
  }

}
