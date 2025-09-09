Descripción del proyecto

Este proyecto es un ejemplo de implementación de arquitectura hexagonal (Ports & Adapters / Clean Architecture) en Java con Spring Boot, que muestra cómo estructurar un backend de manera desacoplada y mantenible.

Se incluyen:

Capa de dominio: modelos y excepciones.

Capa de aplicación: casos de uso (services), puertos de entrada (in) y salida (out).

Capa de infraestructura: controladores REST, persistencia con JPA/Hibernate, mappers y adaptadores.

Gestión de DTOs para separar modelos internos de las entidades expuestas en la API.

Ejemplo funcional completo con flujo end-to-end:
HTTP Request → Controller → Use Case → Repository Port → Adapter JPA → DB

El objetivo principal es servir como ejemplo de buenas prácticas para proyectos basados en DDD + arquitectura hexagonal, asegurando un código modular, testeable y escalable.

# 🏗️ Arquitectura Hexagonal - Ejemplo

Este proyecto implementa una arquitectura **Clean/Hexagonal** en Java con **Spring Boot**, separando claramente los distintos niveles de la aplicación: 

- **Domain** → Modelos puros y excepciones.  
- **Application** → Casos de uso (Use Cases), definidos a través de **puertos IN/OUT**.  
- **Infrastructure** → Adaptadores (Web, Persistencia, Seguridad, etc.).  

---

## 🔄 Flujo general de la aplicación

HTTP Request
│
▼
[Controller + DTOs + Mappers] → [Port IN] → [Use Case]
│
▼
[Port OUT] → [Adapter Persistencia] → [Base de datos]


---

<details>
  <summary>📂 Ver detalle con namespaces</summary>

```text

HTTP Request
   │
   ▼
┌─────────────────────────────────────────────────────────────────────────────────────┐
│ Adapter de entrada (Infra / Web)                                                    │
│ com.app.hexagonal.infrastructure.web.controller.ProductController                   │
│   - Recibe DTO: ProductModelRequestDto                                              │
│   - Usa mapper web:                                                                 │
│     com.app.hexagonal.infrastructure.web.convert.mapper.ProductModelDtoConvertMapper│
│     (RequestDto → Domain Model / ResponseDto ← Domain Model)                        │
└───────────────┬─────────────────────────────────────────────────────────────────────┘
                │ llama a puerto de entrada (IN)
                ▼
┌─────────────────────────────────────────────────────────────┐
│ Puerto de entrada (Application / Port IN)                   │
│ com.app.hexagonal.application.port.in.IProductService       │
│   - Define los casos de uso expuestos                       │
└───────────────┬─────────────────────────────────────────────┘
                │ implementado por
                ▼
┌────────────────────────────────────────────────────────────────────┐
│ Caso de uso (Application / Service Impl)                           │
│ com.app.hexagonal.application.port.service.impl.ProductServiceImpl │
│   - Lógica de negocio                                              │
│   - Depende de puerto de salida (OUT)                              │
└───────────────┬────────────────────────────────────────────────────┘
                │ llama a puerto de salida (OUT)
                ▼
┌──────────────────────────────────────────────────────────────┐
│ Puerto de salida (Application / Port OUT)                    │
│ com.app.hexagonal.application.port.out.IProductRepositoryPort│
│   - Abstracción de persistencia (opera con Domain Model)     │
└───────────────┬──────────────────────────────────────────────┘
                │ implementado por
                ▼
┌───────────────────────────────────────────────────────────────────────────────────────────────────┐
│ Adapter de salida (Infra / Persistence / Adapter)                                                 │
│ com.app.hexagonal.infrastructure.persistence.adapter.ProductRepositoryAdapter                     │
│   - Implementa IProductRepositoryPort                                                             │
│   - Usa mapper de persistencia:                                                                   │
│     com.app.hexagonal.infrastructure.persistence.convert.mapper.ProductEntityToModelConvertMapper │
│     (Domain Model ↔ JPA Entity)                                                                   │
│   - Usa DAO JPA:                                                                                  │
│     com.app.hexagonal.infrastructure.persistence.dao.IProductDao                                  │
│   - Entidad JPA:                                                                                  │
│     com.app.hexagonal.infrastructure.persistence.entity.ProductEntity                             │
└───────────────────────────────────────────────────────────────────────────────────────────────────┘
                │
                ▼
             Base de datos
</details> ```






