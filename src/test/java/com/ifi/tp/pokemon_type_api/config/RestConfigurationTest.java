package com.ifi.tp.pokemon_type_api.config;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
class RestConfigurationTest {
    @Test
    void restTemplate_shouldExist() {
        var restTemplate = new RestConfiguration().restTemplate();

        assertNotNull(restTemplate);
    }

    @Test
    void trainerApiRestTemplate_shouldHaveBasicAuth() {
        RestConfiguration restConfiguration = new RestConfiguration();
        restConfiguration.setUsername("user");
        restConfiguration.setPassword("7fab308f-2310-4f7e-b5e3-ffcb3ff556c7");

        var restTemplate = restConfiguration.trainerApiRestTemplate();

        assertNotNull(restTemplate);

        var interceptors = restTemplate.getInterceptors();
        assertNotNull(interceptors);
        assertEquals(1, interceptors.size());

        var interceptor = interceptors.get(0);
        assertNotNull(interceptor);

        assertEquals(BasicAuthenticationInterceptor.class, interceptor.getClass());
    }
}