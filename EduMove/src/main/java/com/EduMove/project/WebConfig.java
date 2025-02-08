package com.EduMove.project;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permite CORS pe toate rutele
                        .allowedOrigins("Server is running on http://192.168.1.12:3000","http://localhost:3000","http://127.0.0.1:5500") // Adaugă URL-ul frontend-ului (ex.: http://localhost:3000 pentru Node.js)
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Specifică metodele HTTP permise
                        .allowedHeaders("*") // Permite toate antetele
                        .allowCredentials(true); // Permite trimiterea cookie-urilor dacă este necesar
            }
        };
    }
}
