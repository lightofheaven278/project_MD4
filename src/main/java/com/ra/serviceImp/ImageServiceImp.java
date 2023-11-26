package com.ra.serviceImp;

import com.ra.model.Image;
import com.ra.model.Product;
import com.ra.repository.ImageRepository;
import com.ra.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImp implements ImageService {
    @Autowired
    private ImageRepository imageRepository;
    @Override
    public boolean save(Image image) {
        try {
            imageRepository.save(image);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
