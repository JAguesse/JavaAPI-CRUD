package com.api.restaurant.service;

import com.api.restaurant.model.Menu;

import java.util.Map;
import java.util.Set;

public interface MenusService {

    public Set<Menu> findAllFromIdRestaurant(String idRestaurant);

    Menu findById(String idMenu);

    String create(String idRestaurant, Menu menu);

    void update(String idMenu, Menu menu);

    void partialUpdate(String idMenu, Map<String, Object> updates);

    void deleteById(String idResto, String idMenu);
}
