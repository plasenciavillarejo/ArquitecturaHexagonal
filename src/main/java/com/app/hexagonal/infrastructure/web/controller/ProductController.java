package com.app.hexagonal.infrastructure.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hexagonal.application.service.IProductService;

@RestController
@RequestMapping(value = "/productos")
public class ProductController {

  // 1.- El controlador inyecta el caso de uso ubicado dnetro de application.service
  private final IProductService productService;
  
  public ProductController(IProductService productService) {
    this.productService = productService;
  }
  
  @GetMapping(value = "/listar")
  public ResponseEntity<Object> listarProductos() {
    return new ResponseEntity<>(productService.logicaNegocioControlador(), HttpStatus.OK);
  }
  
}
