package com.api.restaurant.restaurantTest;

import com.api.restaurant.dao.RestaurantRepository;
import com.api.restaurant.model.Menu;
import com.api.restaurant.model.Restaurant;
import com.api.restaurant.rest.RestaurantController;
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
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ListRestaurantTest {

    @MockBean
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantController restaurantController;

    @Before
    public void init() {

        Set<Menu> menuSetTest = new HashSet<Menu>();
        Menu menuTest= new Menu("starterTest", "dishTest", "dessertTest");
        menuSetTest.add(menuTest);
        Restaurant restaurant = new Restaurant("RestaurantTest","MonAddressTest", menuSetTest);
        List<Restaurant> result  = new ArrayList<Restaurant>();
        result.add(restaurant);
        Mockito.when(restaurantRepository.findAll()).thenReturn(result);
    }

    @Test
    public void getRestaurant() {

        String restaurantName = "RestaurantTest";
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        restaurantController.findAll().forEach(restaurants::add);
        assertEquals(restaurants.get(0).getName(), restaurantName);
    }



}
