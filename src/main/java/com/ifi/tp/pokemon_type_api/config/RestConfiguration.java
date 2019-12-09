package com.ifi.tp.pokemon_type_api.config;

import com.ifi.tp.pokemon_type_api.bo.Trainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestConfiguration extends WebSecurityConfigurerAdapter {
    private RestTemplate restTemplate;

    private String username;
    private String password;

    @Bean
    public RestTemplate restTemplate(){
        if (restTemplate == null)
            restTemplate = new RestTemplate();
        return restTemplate;
    }

    public RestTemplate trainerApiRestTemplate() {
        restTemplate().getInterceptors().add(new BasicAuthenticationInterceptor(username, password));
        this.restTemplate.getForEntity("https://trainer-api-atr.herokuapp.com/trainers/Ash", Trainer.class);
        return this.restTemplate;
    }

    public void setUsername(@Value("${spring.security.user.name}") String username) {
        this.username = username;
    }

    public void setPassword(@Value("${spring.security.user.password}") String password) {
        this.password = password;
    }
}
