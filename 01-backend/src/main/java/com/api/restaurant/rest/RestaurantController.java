package com.api.restaurant.rest;


import com.api.restaurant.model.Restaurant;
import com.api.restaurant.service.RestaurantService;
import com.api.restaurant.util.CrudPrecondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> findAll(){

        return restaurantService.findAll();
    }

    @GetMapping("/{id}")
    public Restaurant findById(@PathVariable("id") String idRestaurant){
        Restaurant restaurant = restaurantService.findById(idRestaurant);
        CrudPrecondition.checkfound(restaurant);
        return restaurant;
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public String create(@RequestBody Restaurant restaurant){
        return restaurantService.create(restaurant);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@PathVariable("id") String idRestaurant, @RequestBody Restaurant restaurant){
        CrudPrecondition.checkfound(restaurantService.findById(idRestaurant));
        restaurantService.update(idRestaurant, restaurant);


    }

    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void partialUpdate(@PathVariable("id") String idRestaurant, @RequestBody Map<String, Object> updates){
        CrudPrecondition.checkfound(restaurantService.findById(idRestaurant));
        restaurantService.partialUpdate(idRestaurant, updates);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteById(@PathVariable("id") String idRestaurant){
        CrudPrecondition.checkfound(restaurantService.findById(idRestaurant));
        restaurantService.deleteById(idRestaurant);

    }
}
