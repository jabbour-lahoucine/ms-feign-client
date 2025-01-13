package com.example.client.feignClient;

import com.example.client.entities.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "car-service", url = "http://localhost:8888/SERVICE-CAR")
public interface CarClient {

    @GetMapping("/api/car/client/{clientId}")
    List<Car> getCarsByClientId(@PathVariable("clientId") Long clientId);
}
