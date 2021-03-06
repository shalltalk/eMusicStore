package com.emusicstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

/**
 * Created by zhy on 2016/8/30.
 */

@Entity
public class Product implements Serializable{
    //This is value is generated by GenerateSerialVersionUID plugin.
    private static final long serialVersionUID = -4162422389639514472L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productID;

    @NotEmpty (message = "The produt name must not be null.")
    private String productName;
    private String productCategory;
    private String productDescription;

    @Min(value = 0, message = "The product price must not be less than zero.")
    private double productPrice;
    private String productCondition;
    private String productStatus;

    @Min(value = 0, message = "The product unit must not be less than zero.")
    private int unitInStock;
    private String productManufacturer;

    // hibernate will ignore it when persist it. it will be stored in the webapp/WEB-INF/resources folder
    @Transient
    private MultipartFile productImage;

    // One product can be added as a cartItem to many carts
    // parent side is the one, child side is the many
    // mappedBy indicates that there is a product field in the CartItem class.
    // CascadeType.ALL: when the parent class instance is deleted, the child class instance(s) will be deleted by hibernate automatically
    // FetchType.EAGER: before the class instance is used, it will be fetched from database.
    // JsonIgnore: when Spring convert this instance to JSON, this field will be omitted, so that infinite loop can be broken.
    // e.g. Cart.java refers to CartItem.java, but CartItem.java refers to Cart as well.
    @OneToMany(mappedBy = "product", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> cartItemList;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }
}
