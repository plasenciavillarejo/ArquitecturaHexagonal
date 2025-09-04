package com.app.hexagonal.domain.model;

import java.io.Serializable;

/* Está clase sería lo que nosotros conocemos como DTO, contiene los mismo campos o no (Según lo requerido) 
 * de las clases entidad. Son los que entran y salen dentro de nuestro controlador
 */
public class ProductModel implements Serializable {

  private static final long serialVersionUID = 962097465789832528L;

  private Long idProductModel;

  private String nameProductModel;

  public Long getIdProductModel() {
    return idProductModel;
  }

  public String getNameProductModel() {
    return nameProductModel;
  }

  public void setIdProductModel(Long idProductModel) {
    this.idProductModel = idProductModel;
  }

  public void setNameProductModel(String nameProductModel) {
    this.nameProductModel = nameProductModel;
  }

}
