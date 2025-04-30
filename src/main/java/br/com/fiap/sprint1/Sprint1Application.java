package br.com.fiap.sprint1;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//http://localhost:8080/swagger-ui/index.html#/

@OpenAPIDefinition(
        info = @Info(
                title = "Sprint1 - API DE JAVA",
                version = "1.0",
                description = "Documentação da API para gerenciamento e monitoramento de motos"
        )
)


@SpringBootApplication
public class Sprint1Application {

    public static void main(String[] args) {
        SpringApplication.run(Sprint1Application.class, args);
    }

    @Configuration
    public class ModelMapperConfig {
        @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();
        }
    }


}
