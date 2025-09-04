package com.app.hexagonal.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.hexagonal.infrastructure.entity.ProductEntity;

public interface IProductDao extends JpaRepository<ProductEntity, Long>{

  public ProductEntity findById();
  
}
