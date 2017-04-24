package com.example.mobsoft.mobilsoftwarelab.network;

import com.example.mobsoft.mobilsoftwarelab.model.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface OrderApi {
  
  /**
   * Submits an order
   * Submits and order to server
   * @param order Submitted order
   * @return Call<Void>
   */
  
  @POST("order")
  Call<Void> orderPost(
    @Body Order order
  );

  
  /**
   * Gets the orders of a user
   * 
   * @param userId 
   * @return Call<List<Order>>
   */
  
  @GET("order/{userId}")
  Call<List<Order>> orderUserIdGet(
    @Path("userId") Integer userId
  );

  
}
