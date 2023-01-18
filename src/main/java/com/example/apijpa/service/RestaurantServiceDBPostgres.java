package com.example.apijpa.service;

import com.example.apijpa.domain.Restaurant;
import com.example.apijpa.persistance.entities.RestaurantEntity;
import com.example.apijpa.persistance.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceDBPostgres implements RestaurantService{

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceDBPostgres(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getRestaurants() {
        List<RestaurantEntity> restaurantEntityList = this.restaurantRepository.findAll();

        ArrayList<Restaurant> restaurantsList;

        restaurantsList = restaurantEntityList
                .stream()
                .map(restaurantEntity -> Restaurant.builder()
                        .id(restaurantEntity.getId())
                        .name(restaurantEntity.getName())
                        .address(restaurantEntity.getAddress())
                        .numberPhone(restaurantEntity.getNumberPhone())
                        .build())
                .collect(Collectors.toCollection(ArrayList::new));

        return restaurantsList;
    }

}
