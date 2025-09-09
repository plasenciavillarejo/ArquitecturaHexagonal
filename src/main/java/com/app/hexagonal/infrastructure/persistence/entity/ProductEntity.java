package com.app.hexagonal.infrastructure.persistence.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;

@Entity
public class ProductEntity implements Serializable {

  private Long idEntity;

  private String nameEntity;

  public Long getIdEntity() {
    return idEntity;
  }

  public String getNameEntity() {
    return nameEntity;
  }

  public void setIdEntity(Long idEntity) {
    this.idEntity = idEntity;
  }

  public void setNameEntity(String nameEntity) {
    this.nameEntity = nameEntity;
  }

  private static final long serialVersionUID = 2621464196147446958L;

}
