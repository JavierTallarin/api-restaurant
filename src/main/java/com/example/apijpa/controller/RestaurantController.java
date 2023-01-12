package com.example.apijpa.controller;

import com.example.apijpa.domain.Restaurant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @GetMapping("")
    public ResponseEntity<List<Restaurant>> getRestaurants(){
        Restaurant a = new Restaurant();

        //List<Restaurant> list = List.of()
        return null;
    }


}
