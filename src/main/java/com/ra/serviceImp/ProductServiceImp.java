package com.ra.serviceImp;

import com.ra.model.Product;
import com.ra.repository.ProductRepository;
import com.ra.service.ProductService;
import com.ra.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> displayProducts(String productName, int page, int size, String direction, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, direction.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC,
                sortBy);
        return productRepository.findProductName(productName, pageable).getContent();
    }

    @Override
    public List<Integer> getListPage(String productName, int size) {
        int totalProducts = productRepository.countByProductNameContains(productName);
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i < Math.ceil((float) totalProducts / size); i++) {
            listPage.add(i + 1);
        }
        return listPage;
    }

    @Override
    public Product getProductById(String productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public Product save(Product product) {
        try {
            return productRepository.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(String productId) {
        try {
            productRepository.delete(getProductById(productId));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
