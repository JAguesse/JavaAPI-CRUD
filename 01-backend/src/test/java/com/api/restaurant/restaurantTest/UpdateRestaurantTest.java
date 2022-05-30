package com.api.restaurant.restaurantTest;

import com.api.restaurant.dao.RestaurantRepository;
import com.api.restaurant.model.Menu;
import com.api.restaurant.model.Restaurant;
import com.api.restaurant.rest.RestaurantController;
import com.api.restaurant.service.RestaurantService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateRestaurantTest {

    @MockBean
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantController restaurantController;

    @Before
    public void init() {

        Set<Menu> menuSetTest = new HashSet<Menu>();
        Menu menuTest= new Menu("starterTest", "dishTest", "dessertTest");
        menuSetTest.add(menuTest);
        Restaurant restaurant = new Restaurant("IdRestaurant", "RestaurantTest","MonAddressTest", menuSetTest);
        Mockito.when(restaurantRepository.save(restaurant)).thenReturn(restaurant);
        Mockito.when(restaurantRepository.findById("IdRestaurant")).thenReturn(Optional.of(restaurant));

        String idRestaurant = restaurantController.create(restaurant);

        System.out.println(idRestaurant);
    }


    @Test
    public void updateRestaurant() {
        //Todo: Still not working...
        Set<Menu> menuSetTest = new HashSet<Menu>();
        Menu menuTest= new Menu("starterTest", "dishTest", "dessertTest");
        menuSetTest.add(menuTest);
        Restaurant restaurant = new Restaurant("IdRestaurant", "RestaurantUpdate","MonAddressTest", menuSetTest);
        //Mockito.doNothing().when(restaurantRepository).update("IdRestaurant", restaurant);
        restaurantController.update("IdRestaurant", restaurant);

        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        restaurants.add(restaurantController.findById("IdRestaurant"));
        assertEquals(restaurants.get(0).getName(), "RestaurantUpdate");


    }
}
