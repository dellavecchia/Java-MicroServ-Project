package br.com.dellavecchia.productms.service;

import java.util.List;
import java.util.Optional;

import br.com.dellavecchia.productms.dto.ProductDTO;

public interface ProductService {

    Optional<ProductDTO> create(ProductDTO request);

    List<ProductDTO> getAll();

    Optional<ProductDTO> getById(Long id);

    Optional<ProductDTO> update(Long id, ProductDTO request);

    boolean inactive(Long id);
}
