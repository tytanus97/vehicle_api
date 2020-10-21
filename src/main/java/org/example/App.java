package org.example;

import com.fasterxml.classmate.TypeResolver;
import org.example.dto.CarDTO;
import org.example.dto.RocketDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
public class App{

    public static void main( String[] args )
    {
      SpringApplication.run(App.class,args);
    }

    @Bean
    public Docket swaggerConfiguration() {

        TypeResolver typeResolver = new TypeResolver();
        return new Docket(DocumentationType.SWAGGER_2)
                .additionalModels(
                        typeResolver.resolve(CarDTO.class),
                        typeResolver.resolve(RocketDTO.class)
                )
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .build();
    }

}