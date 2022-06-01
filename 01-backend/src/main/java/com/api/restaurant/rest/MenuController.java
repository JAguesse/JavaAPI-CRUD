package com.api.restaurant.rest;

import com.api.restaurant.model.Menu;
import com.api.restaurant.service.MenusService;
import com.api.restaurant.service.RestaurantService;
import com.api.restaurant.util.CrudPrecondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@CrossOrigin("http://localhost:4200")
public class MenuController {

    @Autowired
    private MenusService menusService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants/{idResto}/menus")
    public Set<Menu> findAllFromIdRestaurant(@PathVariable("idResto") String idRestaurant){
        CrudPrecondition.checkfound(restaurantService.findById(idRestaurant));
        return menusService.findAllFromIdRestaurant(idRestaurant);
    }

    @GetMapping("/menus/{idMenu}")
    public Menu findById(@PathVariable("idMenu") String idMenu){
        Menu menu = menusService.findById(idMenu);
        CrudPrecondition.checkfound(menu);
        return menu;
    }

    @PostMapping("restaurants/{idResto}/menus")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@PathVariable("idResto") String idRestaurant, @RequestBody Menu menu){
        CrudPrecondition.checkfound(restaurantService.findById(idRestaurant));
        return menusService.create(idRestaurant, menu);
    }

    @PutMapping("menus/{idMenu}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("idMenu") String idMenu, @RequestBody Menu menu){
        CrudPrecondition.checkfound(menusService.findById(idMenu));
        menusService.update(idMenu, menu);
    }

    @PatchMapping("menus/{idMenu}")
    @ResponseStatus(HttpStatus.OK)
    public void partialUpdate(@PathVariable("idMenu") String idMenu, @RequestBody Map<String, Object> updates){
        CrudPrecondition.checkfound(menusService.findById(idMenu));
        menusService.partialUpdate(idMenu, updates);
    }

    @DeleteMapping("restaurants/{idResto}/menus/{idMenu}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("idResto") String idResto, @PathVariable("idMenu") String idMenu){

        CrudPrecondition.checkfound(menusService.findById(idMenu));
        CrudPrecondition.checkfound(restaurantService.findById(idResto));
        menusService.deleteById(idResto, idMenu);
    }

}
