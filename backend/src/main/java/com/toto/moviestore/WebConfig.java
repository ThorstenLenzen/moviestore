package com.toto.moviestore;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200") // Erlaubte Ursprünge (Domains)
                //.allowedMethods("GET", "POST", "PUT", "DELETE") // Erlaubte HTTP-Methoden
                .allowedMethods("*") // Erlaubte HTTP-Methoden
                .allowedHeaders("*") // Erlaubte Header
                //.allowedHeaders("Origin", "Content-Type", "Accept", "Authorization") // Erlaubte Header
                .allowCredentials(true); // Erlaubt Cookies und Authentifizierung
    }
}