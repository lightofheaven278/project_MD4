package com.ra.controller;

import com.ra.model.Category;
import com.ra.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/categoriesController")
public class CategoriesController {
    @Autowired
    CategoriesService categoriesService;
    private static final int SIZE = 3;
    private static int pageDefault = 1;
    private static String sortByDefault = "catalogName";
    private static String directionDefault = "ASC";
    private static String catalogNameDefault = "";

    @GetMapping(value = "/getAll")
    public ModelAndView displayCategories(Optional<String> catalogName, Optional<Integer> page,
                                          Optional<String> direction, Optional<String> sortBy) {
        ModelAndView modelAndView = new ModelAndView("categories");
        pageDefault = page.orElse(pageDefault);
        sortByDefault = sortBy.orElse(sortByDefault);
        directionDefault = direction.orElse(directionDefault);
        catalogNameDefault = catalogName.orElse(catalogNameDefault);
        List<Category> categoriesList = categoriesService.displayCategories(catalogNameDefault, pageDefault - 1, SIZE,
                directionDefault, sortByDefault);
        List<Integer> listPage = categoriesService.getListPages(catalogNameDefault, SIZE);
        modelAndView.addObject("listPage", listPage);
        modelAndView.addObject("direction", directionDefault);
        modelAndView.addObject("sortBy", sortByDefault);
        modelAndView.addObject("catalogName", catalogNameDefault);
        modelAndView.addObject("categoriesList", categoriesList);
        return modelAndView;
    }

    @GetMapping(value = "/searchCatalog")
    public String searchCatalog(@RequestParam(name = "categoriesSearch") String catalogName) {
        catalogNameDefault = catalogName;
        return "redirect:getAll";
    }

    @GetMapping(value = "/initAddCatalog")
    public String initAddCatalog(ModelMap modelMap) {
        Category newCatalog = new Category();
        modelMap.addAttribute("newCatalog", newCatalog);
        return "catalogInit";
    }

    @PostMapping(value = "/addNewCatalog")
    public String addNewCatalog(Category catalog) {
        boolean addResult = categoriesService.save(catalog);
        if (addResult) {
            return "redirect:getAll";
        } else {
            return "error";
        }
    }

    @GetMapping(value = "/initUpdateCatalog")
    public String initUpdateCatalog(ModelMap modelMap, @RequestParam int catalogId) {
        Category updateCatalog = categoriesService.getCatalogById(catalogId);
        modelMap.addAttribute("updateCatalog", updateCatalog);
        return "catalogUpdate";
    }

    @PostMapping(value = "/updateCatalog")
    public String updateCatalog(Category catalog) {
        boolean updateResult = categoriesService.save(catalog);
        if (updateResult) {
            return "redirect:getAll";
        } else {
            return "error";
        }
    }

    @GetMapping(value = "/deleteCatalog")
    public String deleteCatalog(@RequestParam int catalogId) {
        Category deleteCatalog = categoriesService.getCatalogById(catalogId);
        if (deleteCatalog.getProductList().size() == 0) {
            boolean deleteResult = categoriesService.deleteCatalog(catalogId);
            if (deleteResult) {
                return "redirect:getAll";
            } else {
                return "error";
            }
        } else {
            System.out.println("This catalog already had product(s)!!!");
            return "error";
        }

    }
}
