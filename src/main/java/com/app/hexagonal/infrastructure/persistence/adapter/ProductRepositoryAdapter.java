package com.app.hexagonal.infrastructure.persistence.adapter;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.hexagonal.application.port.out.IProductRepositoryPort;
import com.app.hexagonal.domain.model.ProductModel;
import com.app.hexagonal.infrastructure.persistence.convert.mapper.ProductEntityToModelConvertMapper;
import com.app.hexagonal.infrastructure.persistence.dao.IProductDao;

@Service
public class ProductRepositoryAdapter implements IProductRepositoryPort {

  private final IProductDao productDao;
  private final ProductEntityToModelConvertMapper productEntityToModelConvertMapper;

  public ProductRepositoryAdapter(IProductDao productDao,
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
