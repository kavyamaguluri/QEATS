
/*
 *
 * * Copyright (c) Crio.Do 2019. All rights reserved * Copyright (c) Crio.Do 2019. All rights
 * reserved
 *
 */

package com.crio.qeats.services;

import com.crio.qeats.dto.Menu;
import com.crio.qeats.dto.Restaurant;
import com.crio.qeats.exchanges.GetMenuResponse;
import com.crio.qeats.exchanges.GetRestaurantsRequest;
import com.crio.qeats.exchanges.GetRestaurantsResponse;
import com.crio.qeats.repositoryservices.RestaurantRepositoryService;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class RestaurantServiceImpl implements RestaurantService {

  private final Double peakHoursServingRadiusInKms = 3.0;
  private final Double normalHoursServingRadiusInKms = 5.0;

  @Autowired
  private RestaurantRepositoryService restaurantRepositoryService;

  // @Override
  // public GetMenuResponse findMenuByRestaurantId(String restaurantId) {
  //   log.info("Finding menu for restaurantId: {}", restaurantId);

  //   Menu menu = restaurantRepositoryService.findMenuByRestaurantId(restaurantId);

  //   if (menu == null) {
  //     log.error("Menu not found for restaurantId: {}", restaurantId);
  //     return null;
  //   }

    // return new GetMenuResponse(menu);
  // }

  @Override
  public GetRestaurantsResponse findAllRestaurantsCloseBy(
      GetRestaurantsRequest getRestaurantsRequest, LocalTime currentTime) {

    double latitude = getRestaurantsRequest.getLatitude();
    double longitude = getRestaurantsRequest.getLongitude();
    double servingRadiusInKms;

    if ((currentTime.isAfter(LocalTime.of(7, 59)) 
        && currentTime.isBefore(LocalTime.of(10, 1)))
        || (currentTime.isAfter(LocalTime.of(12, 59)) 
        && currentTime.isBefore(LocalTime.of(14, 1)))
        || (currentTime.isAfter(LocalTime.of(18, 59))
            && currentTime.isBefore(LocalTime.of(21, 1)))) {
      servingRadiusInKms = peakHoursServingRadiusInKms;
    } else {
      servingRadiusInKms = normalHoursServingRadiusInKms;
    }

    List<Restaurant> restaurants = restaurantRepositoryService
        .findAllRestaurantsCloseBy(latitude, longitude, currentTime, servingRadiusInKms);

    return new GetRestaurantsResponse(restaurants);
  }
}


