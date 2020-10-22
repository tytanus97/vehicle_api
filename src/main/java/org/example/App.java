package org.example;

import com.fasterxml.classmate.TypeResolver;
import org.example.dto.CarDTO;
import org.example.dto.OwnerDTO;
import org.example.dto.RocketDTO;
import org.example.dto.VehicleDTO;
import org.example.entity.Car;
import org.example.entity.Owner;
import org.example.entity.Vehicle;
import org.example.repository.OwnerRepository;
import org.example.repository.VehicleRepository;
import org.example.service.OwnerService;
import org.example.service.VehicleService;
import org.example.utils.enums.EngineType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@EnableSwagger2
@SpringBootApplication
public class App{

    private ConfigurableApplicationContext context;
    public static void main( String[] args )
    {
        ConfigurableApplicationContext context = SpringApplication.run(App.class,args);

        OwnerRepository ownerRepository = context.getBean(OwnerRepository.class);
        VehicleRepository vehicleRepository = context.getBean(VehicleRepository.class);
        VehicleService vehicleService = context.getBean(VehicleService.class);
        OwnerService ownerService = context.getBean(OwnerService.class);



        Vehicle car = new Car("Model X","Tesla",100000,2019,
                5,"red", EngineType.ELECTRIC, 0,200);
        Vehicle persistedCar = vehicleRepository.save(car);
        HashSet<Vehicle> ownedVehicles = new HashSet<>();
        ownedVehicles.add(persistedCar);
        Owner owner1 = new Owner("Elon","Musk",ownedVehicles);
        Owner persistedOwner = ownerRepository.save(owner1);
        VehicleDTO vehicleDTO = vehicleService.mapToVehicleDTO(persistedCar);
        OwnerDTO ownerDTO = ownerService.mapToOwnerDTO(persistedOwner);
        List<OwnerDTO> ownerList = ownerService.findAllOwners();

        try {
            List<VehicleDTO> vehicleList = vehicleService.findByType("Car");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(vehicleDTO.toString());

        vehicleRepository.flush();
        ownerRepository.flush();
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