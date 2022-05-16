package com.api.restaurant.restaurantTest;

import com.api.restaurant.dao.RestaurantRepository;
import com.api.restaurant.model.Menu;
import com.api.restaurant.model.Restaurant;
import com.api.restaurant.rest.RestaurantController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
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
public class CreateRestaurantTest {

    @MockBean
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantController restaurantController;


    @Test
    public void createRestaurant() {

        Set<Menu> menuSetTest = new HashSet<Menu>();
        Menu menuTest= new Menu("starterTest", "dishTest", "dessertTest");
        menuSetTest.add(menuTest);
        Restaurant restaurant = new Restaurant("IdRestaurant", "RestaurantTest","MonAddressTest", menuSetTest);
        Mockito.when(restaurantRepository.save(restaurant)).thenReturn(restaurant);

        String restaurantId = restaurantController.create(restaurant);

        assertEquals(restaurant.getId(), restaurantId);
    }
}
