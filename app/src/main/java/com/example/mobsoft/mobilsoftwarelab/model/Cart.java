package com.example.mobsoft.mobilsoftwarelab.model;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.util.List;

/**
 * Created by dkiss on 2017. 04. 24..
 */

@Table
public class Cart extends SugarRecord {
    private Long id = null;
    private List<Product> products;

    public Cart() {
    }

    public Cart(Long id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
