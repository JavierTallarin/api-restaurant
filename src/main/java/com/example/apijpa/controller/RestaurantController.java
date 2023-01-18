package com.example.apijpa.controller;

import com.example.apijpa.domain.Restaurant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @GetMapping({"", "/"})
    public ResponseEntity<List<Restaurant>> getRestaurants(){
        Restaurant a = Restaurant.builder().id("1").name("mcd").address("hola").numberPhone("sddsd").build();
        Restaurant b = Restaurant.builder().id("2").name("mcd2").address("hola").numberPhone("sddsd").build();
        Restaurant c = Restaurant.builder().id("3").name("mcd2").address("hola").numberPhone("sddsd").build();

        List<Restaurant> list = List.of(a, b, c);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantsById(@PathVariable String id) throws IOException {
        Restaurant a = Restaurant.builder().id("1").name("mcd").address("hola").numberPhone("sddsd").build();
        Restaurant b = Restaurant.builder().id("2").name("mcd2").address("hola").numberPhone("sddsd").build();
        Restaurant c = Restaurant.builder().id("3").name("mcd2").address("hola").numberPhone("sddsd").build();

        List<Restaurant> list = List.of(a, b, c);
        Restaurant found;

        try{
            found = list.stream().filter(restaurant -> restaurant.getId().equalsIgnoreCase(id)).collect(Collectors.toList()).get(0);

        }catch(IndexOutOfBoundsException ex){
            found = null;
        }


        return ResponseEntity.ok(found);
    }
    @PostMapping("")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant){
        Restaurant a = Restaurant.builder().id("1").name("mcd").address("hola").numberPhone("sddsd").build();
        Restaurant b = Restaurant.builder().id("2").name("mcd2").address("hola").numberPhone("sddsd").build();
        Restaurant c = Restaurant.builder().id("3").name("mcd2").address("hola").numberPhone("sddsd").build();

        List<Restaurant> list = List.of(a, b, c);
        System.out.println(restaurant.getName());

        return  new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }
    @PutMapping("")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant){
        Restaurant a = Restaurant.builder().id("1").name("mcd").address("hola").numberPhone("sddsd").build();
        Restaurant b = Restaurant.builder().id("2").name("mcd2").address("hola").numberPhone("sddsd").build();
        Restaurant c = Restaurant.builder().id("3").name("mcd2").address("hola").numberPhone("sddsd").build();

        List<Restaurant> list = List.of(a, b, c);
        Restaurant found = list.stream().filter(restaurantI -> restaurantI.getId().equalsIgnoreCase(restaurant.getId())).findFirst().orElseThrow();

        System.out.println(found.getName());
        found.setName(restaurant.getName());
        System.out.println(found.getName());

        return  new ResponseEntity<>(restaurant, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteRestaurant(@PathVariable String id){
        Restaurant a = Restaurant.builder().id("1").name("mcd").address("hola").numberPhone("sddsd").build();
        Restaurant b = Restaurant.builder().id("2").name("mcd2").address("hola").numberPhone("sddsd").build();
        Restaurant c = Restaurant.builder().id("3").name("mcd2").address("hola").numberPhone("sddsd").build();

        List<Restaurant> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);

        Restaurant found = list.stream().filter(restaurant -> restaurant.getId().equalsIgnoreCase(id)).findFirst().orElseThrow();

        System.out.println("se eliminara "+found.getId()+" "+found.getName());
        list.remove(found);
        System.out.println(list.size());

        return ResponseEntity.noContent().build();

    }




}
