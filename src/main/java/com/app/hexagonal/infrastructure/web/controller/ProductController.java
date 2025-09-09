package com.app.hexagonal.infrastructure.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hexagonal.application.service.IProductService;
import com.app.hexagonal.infrastructure.web.convert.mapper.ProductModelDtoConvertMapper;
import com.app.hexagonal.infrastructure.web.request.dto.ProductModelRequestDto;

@RestController
@RequestMapping(value = "/productos")
public class ProductController {

  // 1.- El controlador inyecta el caso de uso ubicado dnetro de application.service
  private final IProductService productService;
  private final ProductModelDtoConvertMapper productModelDtoConvertMapper;
  
  
  public ProductController(IProductService productService,
      ProductModelDtoConvertMapper productModelDtoConvertMapper) {
    this.productService = productService;
    this.productModelDtoConvertMapper = productModelDtoConvertMapper;
  }
  
  @GetMapping(value = "/listar")
  public ResponseEntity<Object> listarProductos() {
    return new ResponseEntity<>(productService.logicaNegocioControlador(), HttpStatus.OK);
  }
  
  @PutMapping(value = "/actualizar")
  public ResponseEntity<Object> actualizarProductos(@RequestBody ProductModelRequestDto 
      productModelDto) {
    // 1. El controlador recibe el DTO web (infra/web/request/dto)
    // 2. Lo convierte a Domain Model usando un mapper (infra/web/mapper)
    // 3. Llama al caso de uso (application/service), que ya trabaja con modelos de dominio
    productService.actualizarProducto(productModelDtoConvertMapper.convertRequestToDomain(productModelDto));
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
  
  /**
   * Nota: en el caso de tener que devolver un response/dto se haría de igual modo que el anterior
   * 
   * 
   @GetMapping("/productos/{idPrueba}")
   public ResponseEntity<ProductResponseDto> obtenerProducto(@PathVariable Long idPrueba) {
    // 1. Caso de uso devuelve un ProductModel (dominio)
    ProductModel model = productService.devolverDtoEjemplo(idPrueba);

    // 2. Mapper transforma Domain → ResponseDto
    ProductResponseDto dto = productModelDtoConvertMapper.convertModelToResponse(model);

    return new ResponseEntity<>(dto, HttpStatus.OK);
  } 
   * 
   */
  
  
}
