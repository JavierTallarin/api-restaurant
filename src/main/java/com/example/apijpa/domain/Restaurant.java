package com.example.apijpa.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {
    String id;
    String name;
    String address;
    String numberPhone;

}
