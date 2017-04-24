package com.example.mobsoft.mobilsoftwarelab.network;

import com.example.mobsoft.mobilsoftwarelab.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductApi {
  
  /**
   * 
   * 
   * @return Call<List<Product>>
   */
  
  @GET("products")
  Call<List<Product>> productsGet();
    

  
}
