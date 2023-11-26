package com.ra.repository;

import com.ra.model.Category;
import com.ra.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriesRepository extends JpaRepository<Category, Integer> {
    @Query("select c from Category as c where c.catalogName like %?1%")
    Page<Category> findCatalogName(String catalogName, Pageable page);

    int countByCatalogNameContains(String catalogName);

}
