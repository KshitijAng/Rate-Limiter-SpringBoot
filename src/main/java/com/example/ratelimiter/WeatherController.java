package com.example.ratelimiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    // Dependency Injection via Constructor
    private final WeatherService weatherService;

    @Autowired // Tells Spring to perform dependency injection.
    public WeatherController(final WeatherService weatherService){ this.weatherService = weatherService;}
    
    @GetMapping("/weather")
    public String getWeather(@RequestParam String city) {
        return weatherService.getWeather(city);
    }

    @GetMapping("/moreWeather")
    public String getMoreWeather(@RequestParam String city) {
        return weatherService.getMoreWeather(city);
    }
}
