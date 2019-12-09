package com.ifi.tp.pokemon_type_api.service;

import org.springframework.web.client.RestTemplate;

public interface TrainerService {
    void setRestTemplate(RestTemplate restTemplate);
}