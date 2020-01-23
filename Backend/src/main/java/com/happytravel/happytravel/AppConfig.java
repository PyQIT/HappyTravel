package com.happytravel.happytravel;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@PropertySource("file:${user.home}/Desktop/HappyTravel-master/Backend/src/main/resources/application.properties")
@EnableWebMvc
@Configuration
public class AppConfig {

}
