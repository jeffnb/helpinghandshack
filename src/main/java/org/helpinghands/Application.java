package org.helpinghands;

import org.bson.util.annotations.Immutable;
import com.sun.javafx.font.FontStrike;
import org.helpinghands.Repositories.AvailableServiceRepository;
import org.helpinghands.Repositories.OrganizationRepository;
import org.helpinghands.models.AvailableService;
import org.helpinghands.models.Organization;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ocx on 5/31/14.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);

        //Set up services seed
        AvailableServiceRepository asRepository = context.getBean(AvailableServiceRepository.class);
        asRepository.deleteAll();
        List<String> services = Arrays.asList("Food", "Shelter", "Health", "Education", "Child Care");

        for(String service : services){
            AvailableService as = new AvailableService(service);
            asRepository.save(as);
        }

        //Set up Organizations
        OrganizationRepository organizationRepository = context.getBean(OrganizationRepository.class);
        organizationRepository.deleteAll();
        Organization o1 = new Organization();
        o1.setAddress("1 New Place,\nLas Vegas, nv 89111");
        o1.setEmail("organization1@test.com");
        o1.setHours("Monday - Friday 8am - 5pm\nSaturday 5am-8am");
        o1.setLocation(36.062339, -115.215490);
        o1.setName("Helping Hands - 1");
        o1.setPhone("(702) 555-1212");
        o1.setWebsite("http://disney.com");
        organizationRepository.save(o1);


        Organization o2 = new Organization();
        o2.setAddress("2 New Place,\nLas Vegas, nv 89111");
        o2.setEmail("organization2@test.com");
        o2.setHours("Monday - Friday 8am - 5pm\nSaturday 5am-8am");
        o2.setLocation(36.066433, -115.212743);
        o2.setName("Catholic Charities - 2");
        o2.setPhone("(702) 555-1212");
        o2.setWebsite("http://disney.com");
        organizationRepository.save(o2);

        Organization o3 = new Organization();
        o3.setAddress("3 New Place,\nLas Vegas, nv 89111");
        o3.setEmail("organization3@test.com");
        o3.setHours("Monday - Friday 8am - 5pm\nSaturday 5am-8am");
        o3.setLocation(36.064837, -115.210683);
        o3.setName("Goodwill - 3");
        o3.setPhone("(702) 555-1212");
        o3.setWebsite("http://disney.com");
        organizationRepository.save(o3);

        Organization o4 = new Organization();
        o4.setAddress("4 New Place,\nLas Vegas, nv 89111");
        o4.setEmail("organization4@test.com");
        o4.setHours("Monday - Friday 8am - 5pm\nSaturday 5am-8am");
        o4.setLocation(36.062964, -115.223687);
        o4.setName("Helping Hands - 4");
        o4.setPhone("(702) 555-1212");
        o4.setWebsite("http://disney.com");
        organizationRepository.save(o4);

        Organization o5 = new Organization();
        o5.setAddress("5 New Place,\nLas Vegas, nv 89111");
        o5.setEmail("organization5@test.com");
        o5.setHours("Monday - Friday 8am - 5pm\nSaturday 5am-8am");
        o5.setLocation(37.060986, -116.218558);
        o5.setName("Helping Hands - 5");
        o5.setPhone("(702) 555-1212");
        o5.setWebsite("http://disney.com");
        organizationRepository.save(o5);

        //Let's play with data
        Iterable<AvailableService> s = asRepository.findAll();
        System.out.println("Services Findall");
        for(AvailableService service : s){
            System.out.println(service);
        }

        System.out.println();

        Iterable<Organization> o = organizationRepository.findByLocationNear(new Point(-115.213341,36.066634),
                new Distance(1, Metrics.MILES));
        System.out.println("Organizations within a mile");
        for(Organization org : o){
            System.out.println(org);
        }

    }

}
