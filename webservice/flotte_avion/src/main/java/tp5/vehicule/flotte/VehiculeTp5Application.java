package tp5.vehicule.flotte;

import controller.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import retour.DataRetour;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@RestController

@ComponentScan(basePackageClasses = AvionImgController.class)
@ComponentScan(basePackageClasses = AvionController.class)
@ComponentScan(basePackageClasses = AssuranceControllerAvion.class)
@ComponentScan(basePackageClasses = UtilisateurController.class)
@ComponentScan(basePackageClasses = AssuranceController.class)
@ComponentScan(basePackageClasses = V_EntretienController.class)
@ComponentScan(basePackageClasses = KilometrageController.class)

public class VehiculeTp5Application {

    public static void main(String[] args) {
        SpringApplication.run(VehiculeTp5Application.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }

}
