package com.app.hexagonal.infrastructure.web.request.dto;

import java.io.Serializable;

public class ProductModelRequestDto implements Serializable {

  private Long idProduct;

  private String name;

  public Long getIdProduct() {
    return idProduct;
  }

  public void setIdProduct(Long idProduct) {
    this.idProduct = idProduct;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  private static final long serialVersionUID = -2768182399756449925L;

}
