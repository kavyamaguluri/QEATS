/*
 *
 * * Copyright (c) Crio.Do 2019. All rights reserved * Copyright (c) Crio.Do 2019. All rights
 * reserved
 *
 */

package com.crio.qeats.controller;

import com.crio.qeats.exchanges.GetMenuResponse;
import com.crio.qeats.exchanges.GetRestaurantsRequest;
import com.crio.qeats.exchanges.GetRestaurantsResponse;
import com.crio.qeats.services.RestaurantService;
import java.time.LocalTime;
import javax.validation.Valid;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// TODO: CRIO_TASK_MODULE_RESTAURANTSAPI
// Implement Controller using Spring annotations.
// Remember, annotations have various "targets". They can be class level, method level or others.

@RestController
@RequestMapping(RestaurantController.RESTAURANT_API_ENDPOINT)
@Slf4j
public class RestaurantController {

  public static final String RESTAURANT_API_ENDPOINT = "/qeats/v1";
  public static final String RESTAURANTS_API = "/restaurants";
  public static final String MENU_API = "/menu";
  public static final String CART_API = "/cart";
  public static final String CART_ITEM_API = "/cart/item";
  public static final String CART_CLEAR_API = "/cart/clear";
  public static final String POST_ORDER_API = "/order";
  public static final String GET_ORDERS_API = "/orders";

  @Autowired
  private RestaurantService restaurantService;

  @GetMapping(RESTAURANTS_API)
  public ResponseEntity<GetRestaurantsResponse> getRestaurants(
      @RequestParam(required = false) Double latitude,
      @RequestParam(required = false) Double longitude) {
    log.info("getRestaurants called with latitude: {}, longitude: {}", latitude, longitude);
    if (latitude == null || longitude == null) {
      log.error("Latitude or longitude is missing");
      return ResponseEntity.badRequest().build();
    }

    if (latitude < -90 || latitude > 90) {
      log.error("Invalid latitude: {}", latitude);
      return ResponseEntity.badRequest().build();
    }

    if (longitude < -180 || longitude > 180) {
      log.error("Invalid longitude: {}", longitude);
      return ResponseEntity.badRequest().build();
    }

    GetRestaurantsRequest request = new GetRestaurantsRequest(latitude, longitude);

    GetRestaurantsResponse response =
        restaurantService.findAllRestaurantsCloseBy(request, LocalTime.now());
    log.info("getRestaurants returned {} restaurants", response.getRestaurants().size());

    return ResponseEntity.ok(response);
  }

  // @GetMapping(MENU_API)
  // public ResponseEntity<GetMenuResponse> getMenu(@RequestParam String restaurantId) {
  //   log.info("getMenu called with restaurantId: {}", restaurantId);

  //   if (restaurantId == null || restaurantId.trim().isEmpty()) {
  //     log.error("RestaurantId is missing or invalid");
  //     return ResponseEntity.badRequest().build();
  //   }

  //   GetMenuResponse response = restaurantService.findMenuByRestaurantId(restaurantId);

  //   if (response == null || response.getMenu() == null) {
  //     log.error("Menu not found for restaurantId: {}", restaurantId);
  //     return ResponseEntity.notFound().build();
  //   }

  //   log.info("getMenu returned successfully for restaurantId: {}", restaurantId);
  //   return ResponseEntity.ok(response);
  // }
}


