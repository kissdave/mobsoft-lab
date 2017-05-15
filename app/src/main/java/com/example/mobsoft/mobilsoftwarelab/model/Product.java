package com.example.mobsoft.mobilsoftwarelab.model;

import com.orm.SugarRecord;

/**
 * Created by mobsoft on 2017. 04. 10..
 */


public class Product extends SugarRecord {

    private String name;
    private String description;
    private Integer price;

    public Product() {

    }

    public Product(Long id, String name, String description, Integer price) {
       // this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

   /* public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
