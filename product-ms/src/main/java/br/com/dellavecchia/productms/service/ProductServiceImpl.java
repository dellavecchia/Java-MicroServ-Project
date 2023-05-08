package br.com.dellavecchia.productms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.dellavecchia.productms.dto.ProductDTO;
import br.com.dellavecchia.productms.model.Product;
import br.com.dellavecchia.productms.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Optional<ProductDTO> create(ProductDTO request) {
            ModelMapper mapper = new ModelMapper();
            Product product = mapper.map(request, Product.class);
            repository.saveAndFlush(product);

            ProductDTO response = mapper.map(product, ProductDTO.class);


            return Optional.of(response);
       
    }

    @Override
    public List<ProductDTO> getAll() {
        ModelMapper mapper = new ModelMapper();
        List<Product> products = repository.findAll();
        List<ProductDTO> responses = new ArrayList<>();
        

    // for (Product product : products) {
    //     ProductDTO response = mapper.map(product, ProductDTO.class);
    //     responses.add(response);

    // }
    
    products.forEach(product -> {ProductDTO response = mapper.map(product, ProductDTO.class);
        responses.add(response);
    });




    return responses;
        

        

    }

}

