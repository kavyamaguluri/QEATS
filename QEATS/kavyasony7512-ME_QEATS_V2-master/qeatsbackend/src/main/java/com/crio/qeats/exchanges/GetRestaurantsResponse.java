/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.exchanges;

import com.crio.qeats.dto.Restaurant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRestaurantsResponse {
  private String restaurantId;
  private String name;
  private String city;
  private String imageUrl;
  private double latitude;
  private double longitude;
  private String opensAt;
  private String closesAt;
  private List<String> attributes;
  private List<Restaurant> restaurants;

  public GetRestaurantsResponse(List<Restaurant> restaurants) {
    this.restaurants = restaurants;
  }

  public List<Restaurant> getRestaurants() {
    return restaurants;
  }
}

// TODO: CRIO_TASK_MODULE_RESTAURANTSAPI
//  Implement GetRestaurantsResponse.
// Complete the class such that it produces the following JSON during serialization.
// {
//  "restaurants": [
//    {
//      "restaurantId": "10",
//      "name": "A2B",
//      "city": "Hsr Layout",
//      "imageUrl": "www.google.com",
//      "latitude": 20.027,
//      "longitude": 30.0,
//      "opensAt": "18:00",
//      "closesAt": "23:00",
//      "attributes": [
//        "Tamil",
//        "South Indian"
//      ]
//    },
//    {
//      "restaurantId": "11",
//      "name": "Shanti Sagar",
//      "city": "Btm Layout",
//      "imageUrl": "www.google.com",
//      "latitude": 20.0269,
//      "longitude": 30.00,
//      "opensAt": "18:00",
//      "closesAt": "23:00",
//      "attributes": [
//        "Udupi",
//        "South Indian"
//      ]
//    }
//  ]


