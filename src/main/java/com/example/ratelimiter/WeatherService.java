package com.example.ratelimiter;

import org.springframework.stereotype.Service;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@Service
public class WeatherService {

    @RateLimiter(name="rateLimiter", fallbackMethod = "fallbackGetWeather")
    public String getWeather(final String city) {
        // Simulate a call to a weather API
        return String.format("Sunny in %s", city);
    }

    @RateLimiter(name="rateLimiter1", fallbackMethod = "fallbackGetWeather")
    public String getMoreWeather(final String city) {
        // Simulate a call to a weather API
        return String.format("Sunny in %s", city);
    }

    public String fallbackGetWeather(Throwable throwable) {
        return "Too many requests. Please try again later.";
    }
    
}
