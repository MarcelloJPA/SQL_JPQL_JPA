package com.devsuperior.aula.services;

import com.devsuperior.aula.dto.CategoryDTO;
import com.devsuperior.aula.dto.ProductDTO;
import com.devsuperior.aula.entities.Category;
import com.devsuperior.aula.entities.Product;
import com.devsuperior.aula.repositories.CategoryRepository;
import com.devsuperior.aula.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductDTO insert(ProductDTO productDTO){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());

        for(CategoryDTO catDTO : productDTO.getCategories()){

            Category cat = categoryRepository.getReferenceById(catDTO.getId());
            //Category cat = new Category();
            //cat.setId(catDTO.getId());

            product.getCategories().add(cat);
        }

        product = productRepository.save(product);

        return new ProductDTO(product);
    }
}
