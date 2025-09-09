package com.app.hexagonal.infrastructure.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.hexagonal.infrastructure.persistence.entity.ProductEntity;

public interface IProductDao extends JpaRepository<ProductEntity, Long>{

  public ProductEntity findById();
  
}
