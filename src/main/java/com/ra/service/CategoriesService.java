package com.ra.service;

import com.ra.model.Category;

import java.util.List;

public interface CategoriesService {
    List<Category> getAllCategories();
    List<Category> displayCategories(String catalogName, int page, int size, String direction, String sortBy);

    List<Integer> getListPages(String catalogName, int size);

    Category getCatalogById(int catalogId);

    boolean save(Category catalog);

    boolean deleteCatalog(int catalogId);
}
