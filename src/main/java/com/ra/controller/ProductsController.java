package com.ra.controller;

import com.ra.model.Category;
import com.ra.model.Image;
import com.ra.model.Product;
import com.ra.repository.ProductRepository;
import com.ra.service.CategoriesService;
import com.ra.service.ImageService;
import com.ra.service.ProductService;
import com.ra.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/productsController")
public class ProductsController {
    @Autowired
    private ProductService productService;
    @Autowired
    private UploadFileService uploadFileService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private CategoriesService categoriesService;
    private static final int SIZE = 3;
    private static int pageDefault = 1;
    private static String directionDefault = "ASC";
    private static String sortByDefault = "productName";
    private static String productNameDefault = "";


    @GetMapping(value = "/getAll")
    public ModelAndView displayProducts(Optional<String> productName, Optional<Integer> page,
                                        Optional<String> direction, Optional<String> sortBy) {
        ModelAndView modelAndView = new ModelAndView("products");
        pageDefault = page.orElse(pageDefault);

        productNameDefault = productName.orElse(productNameDefault);
        directionDefault = direction.orElse(directionDefault);
        sortByDefault = sortBy.orElse(sortByDefault);
        List<Product> productList = productService.displayProducts(productNameDefault, pageDefault - 1, SIZE,
                directionDefault, sortByDefault);
        List<Integer> listPage = productService.getListPage(productNameDefault, SIZE);
        modelAndView.addObject("page", pageDefault);
        modelAndView.addObject("direction", directionDefault);
        modelAndView.addObject("sortBy", sortByDefault);
        modelAndView.addObject("productName", productNameDefault);
        modelAndView.addObject("productList", productList);
        modelAndView.addObject("listPage", listPage);
        return modelAndView;
    }

    @GetMapping(value = "/searchProduct")
    public String searchProduct(@RequestParam(name = "productSearch") String productName) {
        productNameDefault = productName;
        return "redirect:getAll";
    }

    @GetMapping(value = "/initAddProduct")
    public String initAddProduct(ModelMap modelMap) {
        Product newProduct = new Product();
        List<Category> categoryListTotal = categoriesService.getAllCategories();
        modelMap.addAttribute("categoriesList", categoryListTotal);
        modelMap.addAttribute("newProduct", newProduct);
        return "productInit";
    }

    @PostMapping(value = "/addNewProduct")
    public String addNewProduct(Product product, MultipartFile productImage, MultipartFile[] otherImages) {
        String urlImage = uploadFileService.uploadFile(productImage);
        product.setImage(urlImage);
        Product proNew = productService.save(product);
        if (proNew != null) {
            //Input sub images of product
            Arrays.asList(otherImages).forEach(image -> {
                String imageLink = uploadFileService.uploadFile(image);
                Image images = new Image();
                images.setProduct(proNew);
                images.setUrl(imageLink);
                //add new images to Image
                boolean result = imageService.save(images);
            });
            return "redirect:getAll";
        } else {
            return "redirect:error";
        }
    }

    @GetMapping(value = "/initUpdateProduct")
    public String initUpdateProduct(ModelMap modelMap, @RequestParam String productId) {
        Product updateProduct = productService.getProductById(productId);
        List<Category> categoryListTotal = categoriesService.getAllCategories();
        modelMap.addAttribute("categoriesList", categoryListTotal);
        modelMap.addAttribute("updateProduct", updateProduct);
        return "productUpdate";
    }

    @PostMapping(value = "/updateProduct")
    public String updateProduct(Product product, MultipartFile productImage, MultipartFile[] otherImages) {
        String urlImage = uploadFileService.uploadFile(productImage);
        product.setImage(urlImage);
        Product proUpdate = productService.save(product);
        if (proUpdate != null) {
            //Input sub images of product
            Arrays.asList(otherImages).forEach(image -> {
                String imageLink = uploadFileService.uploadFile(image);
                Image images = new Image();
                images.setProduct(proUpdate);
                images.setUrl(imageLink);
                //add new images to Image
                boolean result = imageService.save(images);
            });
            return "redirect:getAll";
        } else {
            return "redirect:error";
        }
    }

    @GetMapping(value = "/deleteProduct")
    public String deleteProduct(String productId) {
        Product deleteProduct = productService.getProductById(productId);
        if (deleteProduct.getImageList().size() == 0) {
            boolean deleteResult = productService.delete(productId);
            if (deleteResult) {
                return "redirect:products";
            } else {
                return "redirect:error";
            }
        } else {
            return "redirect:error";
        }
    }
}
