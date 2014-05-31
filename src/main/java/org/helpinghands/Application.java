package org.helpinghands;

import org.helpinghands.Repositories.AvailableServiceRepository;
import org.helpinghands.models.AvailableService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ocx on 5/31/14.
 */
@Configuration
@EnableAutoConfiguration
public class Application {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        AvailableServiceRepository asRepository = context.getBean(AvailableServiceRepository.class);

        //Create a few service tags
        AvailableService as = new AvailableService();
        as.setService("Food");
        asRepository.save(as);

        AvailableService as2 = new AvailableService();
        as2.setService("Shelter");
        asRepository.save(as2);

        AvailableService as3 = new AvailableService();
        as3.setService("Health");
        asRepository.save(as3);

        //Let's play with data
        Iterable<AvailableService> services = asRepository.findAll();
        System.out.println("Services Findall");
        for(AvailableService service : services){
            System.out.println(service);
        }
    }

}
