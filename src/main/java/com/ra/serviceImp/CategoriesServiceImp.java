package com.ra.serviceImp;

import com.ra.model.Category;
import com.ra.model.Product;
import com.ra.repository.CategoriesRepository;
import com.ra.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesServiceImp implements CategoriesService {
    @Autowired
    CategoriesRepository categoriesRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoriesRepository.findAll();
    }

    @Override
    public List<Category> displayCategories(String catalogName, int page, int size, String direction, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, direction.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        return categoriesRepository.findCatalogName(catalogName, pageable).getContent();
    }

    @Override
    public List<Integer> getListPages(String productName, int size) {
        int totalCatalogs = categoriesRepository.countByCatalogNameContains(productName);
        List<Integer> listPages = new ArrayList<>();
        for (int i = 0; i < Math.ceil((float) totalCatalogs / size); i++) {
            listPages.add(i + 1);
        }
        return listPages;
    }

    @Override
    public Category getCatalogById(int catalogId) {
        return categoriesRepository.findById(catalogId).get();
    }

    @Override
    public boolean save(Category catalog) {
        try {
            categoriesRepository.save(catalog);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCatalog(int catalogId) {
        try {
            Category catalog = getCatalogById(catalogId);
            List<Product> productList = catalog.getProductList();
            if (productList.size() == 0) {
                categoriesRepository.delete(getCatalogById(catalogId));
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
