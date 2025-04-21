
/*
 *
 * * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.services;

import com.crio.qeats.dto.Restaurant;
import com.crio.qeats.exchanges.GetMenuResponse;
import com.crio.qeats.exchanges.GetRestaurantsRequest;
import com.crio.qeats.exchanges.GetRestaurantsResponse;
import java.time.LocalTime;
import java.util.List;

public interface RestaurantService {

  /**
   * Get all the restaurants that are open now within a specific service radius.
   *
   * @param getRestaurantsRequest valid lat/long
   * @param currentTime current time
   * @return GetRestaurantsResponse object containing a list of open restaurants or an empty list
   *         if none fits the criteria - For peak hours: 8AM - 10AM, 1PM-2PM, 7PM-9PM - service
   *         radius is 3KMs. - All other times, serving radius is 5KMs. - If there are no
   *         restaurants, return empty list of restaurants.
   */
  GetRestaurantsResponse findAllRestaurantsCloseBy(GetRestaurantsRequest getRestaurantsRequest,
      LocalTime currentTime);

  /**
   * Get the menu for the given restaurantId.
   *
   * @param restaurantId ID of the restaurant
   * @return GetMenuResponse containing the menu
   */
  // GetMenuResponse findMenuByRestaurantId(String restaurantId);
}