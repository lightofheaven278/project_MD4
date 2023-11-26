package com.ra.service;

import com.ra.model.Image;
import com.ra.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

public interface ImageService {
    boolean save(Image image);
}
