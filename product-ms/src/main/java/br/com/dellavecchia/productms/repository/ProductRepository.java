package br.com.dellavecchia.productms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dellavecchia.productms.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
