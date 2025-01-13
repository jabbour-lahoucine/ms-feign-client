package com.example.client.services;



import com.example.client.feignClient.CarClient;
import com.example.client.entities.Car;
import com.example.client.entities.Client;
import com.example.client.modeles.ClientResponse;
import com.example.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceFeignClient {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CarClient carClient;

    public ClientResponse getClientById(Long id) throws Exception {
        Client client = clientRepository.findById(id).orElseThrow(() -> new Exception("Invalid Client ID"));
        List<Car> cars = carClient.getCarsByClientId(id);
        client.setCars(cars);
        return new ClientResponse(client);
    }
}