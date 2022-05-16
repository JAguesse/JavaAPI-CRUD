package com.api.restaurant.dao;

import com.api.restaurant.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, String> {


    //void update(String idRestaurant, Restaurant restaurant);
}
