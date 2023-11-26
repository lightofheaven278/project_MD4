package com.ra.model;

import javax.persistence.*;

@Entity
@Table(name = "ProductImage")
public class Image {
    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String image;
    @Column(name = "image_url")
    private String url;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    public Image() {
    }

    public Image(String image, String url, Product product) {
        this.image = image;
        this.url = url;
        this.product = product;
    }

    public String getImage() {
        return image;
    }

    public String getUrl() {
        return url;
    }

    public Product getProduct() {
        return product;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
