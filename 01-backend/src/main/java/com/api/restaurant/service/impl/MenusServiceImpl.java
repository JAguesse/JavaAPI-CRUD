package com.api.restaurant.service.impl;

import com.api.restaurant.dao.MenuRepository;
import com.api.restaurant.dao.RestaurantRepository;
import com.api.restaurant.model.Menu;
import com.api.restaurant.model.Restaurant;
import com.api.restaurant.service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class MenusServiceImpl implements MenusService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Set<Menu> findAllFromIdRestaurant(String idRestaurant) {
        return restaurantRepository.findById(idRestaurant).get().getMenus();
    }

    @Override
    public Menu findById(String idMenu) {
        if(menuRepository.findById(idMenu).isPresent())
            return menuRepository.findById(idMenu).get();
        else
            return null;
    }

    @Override
    public String create(String idRestaurant, Menu menu) {
       Restaurant restaurantEntity = restaurantRepository.findById(idRestaurant).get();
       restaurantEntity.getMenus().add(menu);
       restaurantRepository.save(restaurantEntity);
       Menu menuEntity = restaurantEntity.getMenus().stream().filter(m -> m.equals(menu)).findFirst().get();
       return menuEntity.getIdMenu();
    }

    @Override
    public void update(String idMenu, Menu menu) {
        menu.setIdMenu(idMenu);
        menuRepository.save(menu);
    }

    @Override
    public void partialUpdate(String idMenu, Map<String, Object> updates) {
        Menu menuUpdate = menuRepository.findById(idMenu).get();
        for(String key : updates.keySet()){
            switch (key){
                case "starter" :
                    menuUpdate.setStarter((String) updates.get(key));
                    break;
                case "dish" :
                    menuUpdate.setDish((String) updates.get(key));
                    break;
                case "dessert" :
                    menuUpdate.setDessert((String) updates.get(key));
                    break;
            }
        }
        menuRepository.save(menuUpdate);
    }

    @Override
    public void deleteById(String idResto, String idMenu) {
        Restaurant restoToUpdate = restaurantRepository.findById(idResto).get();
        Set<Menu> menus = restoToUpdate.getMenus();
        Menu menu = menus.stream().filter(m -> m.getIdMenu().equals(idMenu)).findFirst().get();
        menus.remove(menu);
        restoToUpdate.setMenus(menus);
        restaurantRepository.save(restoToUpdate);
    }
}
