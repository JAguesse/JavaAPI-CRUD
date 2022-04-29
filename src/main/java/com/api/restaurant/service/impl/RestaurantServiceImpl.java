package com.api.restaurant.service.impl;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.api.restaurant.dao.RestaurantRepository;
import com.api.restaurant.model.Restaurant;
import com.api.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> findAll() {
        List<Restaurant> myList = new ArrayList<Restaurant>();
        restaurantRepository.findAll().forEach(myList::add);
        for(Restaurant tempRestau : myList){
            System.out.println(tempRestau.toString());
        }

        return myList;
    }

    public Restaurant findById(String id){
        if(restaurantRepository.findById(id).isPresent())
            return restaurantRepository.findById(id).get();
        else
            return null;

    }

    @Override
    public String create(Restaurant restaurant) {
       return restaurantRepository.save(restaurant).getId();
    }

    @Override
    public void update(String id, Restaurant restaurant) {
        restaurant.setId(id);
        restaurantRepository.save(restaurant);
    }

    @Override
    public void partialUpdate(String idRestaurant, Map<String, Object> updates) {
        Restaurant restaurantUpdate = restaurantRepository.findById(idRestaurant).get();
        for(String key : updates.keySet()){
            switch (key){
                case "name" :
                    restaurantUpdate.setName((String) updates.get(key));
                    break;
                case "address" :
                    restaurantUpdate.setAddress((String) updates.get(key));
                    break;
            }
        }
        restaurantRepository.save(restaurantUpdate);
    }

    @Override
    public void deleteById(String idRestaurant) {
        restaurantRepository.deleteById(idRestaurant);
    }
}
