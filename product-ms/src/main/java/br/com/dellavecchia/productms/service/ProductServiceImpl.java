package br.com.dellavecchia.productms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.dellavecchia.productms.dto.ProductDTO;
import br.com.dellavecchia.productms.model.Product;
import br.com.dellavecchia.productms.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ModelMapper mapper;


    //Create method
    @Override
    public Optional<ProductDTO> create(ProductDTO request) {
        Product product = mapper.map(request, Product.class);
        repository.saveAndFlush(product);

        ProductDTO response = mapper.map(product, ProductDTO.class);


        return Optional.of(response);

    }

    //Getall method
    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = repository.findAll();
        List<ProductDTO> responses = new ArrayList<>();


        // for (Product product : products) {
        //     ProductDTO response = mapper.map(product, ProductDTO.class);
        //     responses.add(response);

        // }

        products.forEach(product -> {
            ProductDTO response = mapper.map(product, ProductDTO.class);
            responses.add(response);
        });


        return responses;


    }

    @Override
    public Optional<ProductDTO> getById(Long id) {
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            return Optional.of(mapper.map(product.get(), ProductDTO.class));
        }
        return Optional.empty();

    }

    @Override
    public Optional<ProductDTO> update(Long id, ProductDTO request) {
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            product.get().setDescription(request.getDescription());
            product.get().setPrice(request.getPrice());
            repository.save(product.get());
            return Optional.of(mapper.map(product.get(), ProductDTO.class));
        }
        return Optional.empty();
    }


    @Override
    public boolean inactive(Long id) {
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            product.get().setAvailable(false);
            repository.save(product.get());
            return true;
        }
        return false;

    }

}

