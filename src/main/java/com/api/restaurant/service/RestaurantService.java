package com.api.restaurant.service;

import com.api.restaurant.model.Restaurant;

import java.util.List;
import java.util.Map;

public interface RestaurantService {

    public List<Restaurant> findAll();


    public Restaurant findById(String id);

    String create(Restaurant restaurant);

    void update(String id, Restaurant restaurant);

    void partialUpdate(String idRestaurant, Map<String, Object> updates);

    void deleteById(String idRestaurant);
}
