package org.helpinghands;

import org.helpinghands.Repositories.AvailableServiceRepository;
import org.helpinghands.Repositories.OrganizationRepository;
import org.helpinghands.models.AvailableService;
import org.helpinghands.models.Organization;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;

import java.util.ArrayList;
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
        o1.setName("Action RED Health");
        o1.setAddress("1110 Fremont Street, Las Vegas, Nevada 89101");
        o1.setWebsite("http://www.actionred.org");
        o1.setEmail("info@actionred.org");
        o1.setHours("Mon-Fri 7:30am-3:30pm");
        o1.setLocation(36.0775030, -115.2206659);
        o1.setPhone("(702) 366-0175");
        o1.addService("Health");
        organizationRepository.save(o1);

        Organization o2 = new Organization();
        o2.setName("Clark County Department of Family Services");
        o2.setAddress("701 N. Pecos Rd., Bldg. K Las Vegas, NV 89101");
        o2.setWebsite("http://voc.nv.gov/VOC/HelpVictims/");
        o2.setEmail("info@actionred.org");
        o2.setHours("Mon-Fri 7:30am-3:30pm");
        o2.setLocation(36.1788990, -115.1076510);
        o2.setPhone("(702) 455-5371");
        o2.addService("Shelter");
        o2.addService("Food");
        o2.addService("Child Care");
        o2.addService("Health");
        organizationRepository.save(o2);

        Organization o3 = new Organization();
        o3.setName("Salvation Army");
        o3.setAddress("35 W Owens Ave, North Las Vegas, NV 89030");
        o3.setWebsite("http://www.salvationarmyusa.org");
        o3.setEmail("info@salvationarmyusa.org");
        o3.setHours("Mon-Fri 7:30am-3:30pm");
        o3.setLocation(36.1882654, -115.1408676);
        o3.setPhone("(702) 649-1469");
        o3.addService("Shelter");
        o3.addService("Food");
        o3.addService("Child Care");
        o3.addService("Health");
        organizationRepository.save(o3);

        Organization o4 = new Organization();
        o4.setName("Neighborhood Housing Service Of Nevada");
        o4.setAddress("1849 Civic Center Dr, North Las Vegas, NV 89030");
        o4.setWebsite("http://nwsn.org/");
        o4.setEmail("info@nhssn.org");
        o4.setHours("Mon–Fri 8am–4:30pm");
        o4.setLocation(36.1938327, -115.1166873);
        o4.setPhone("(702) 649-0998");
        o4.addService("Shelter");
        o4.addService("Food");
        organizationRepository.save(o4);

        Organization o5 = new Organization();
        o5.setName("Meals-On-Wheels");
        o5.setAddress("531 N 30th St, Las Vegas, NV 89101");
        o5.setWebsite("http://www.catholiccharities.com/");
        o5.setEmail("info@catholiccharities.com");
        o5.setHours("Mon-Fri 9am-7pm, Sat-Sun 10am-5pm");
        o5.setLocation(36.1712002, -115.1072423);
        o5.setPhone("(702) 693-6761");
        o5.addService("Food");
        organizationRepository.save(o5);


        Organization o6 = new Organization();
        o6.setName("Shade Tree Shelter for Women");
        o6.setAddress("1 West Owens North Las Vegas, NV 89030");
        o6.setWebsite("http://www.theshadetree.org/");
        o6.setEmail("info@theshadetree.org");
        o6.setHours("Mon-Sun 10:30am-7pm");
        o6.setLocation(36.1884233, -115.1407748);
        o6.setPhone("(702) 385-0072");
        o6.addService("Shelter");
        o6.addService("Food");
        o6.addService("Health");
        organizationRepository.save(o6);

        Organization o7 = new Organization();
        o7.setName("Catholic Charities of Southern Nevada");
        o7.setAddress("1250 S Burnham Ave, Las Vegas, NV 89104");
        o7.setWebsite("http://www.catholiccharities.com/");
        o7.setEmail("info@catholiccharities.com");
        o7.setHours("Mon-Sun 10:30am-7pm");
        o7.setLocation(36.1655870, -115.1028395);
        o7.setPhone("(702) 693-6761");
        o7.addService("Shelter");
        o7.addService("Food");
        o7.addService("Child Care");
        organizationRepository.save(o7);

        Organization o8 = new Organization();
        o8.setName("Helping Hand Of Vegas Valley");
        o8.setAddress("2225 Civic Center Dr, North Las Vegas, NV 89030");
        o8.setWebsite("http://www.hhovv.org/");
        o8.setEmail("info@hhovv.org");
        o8.setHours("Mon-Sat 8am-4pm");
        o8.setLocation(36.1996748, -115.1192281);
        o8.setPhone("(702) 649-6529");
        o8.addService("Shelter");
        o8.addService("Food");
        o8.addService("Health");
        organizationRepository.save(o8);


        Organization o9 = new Organization();
        o9.setName("Dream Center of Las Vegas");
        o9.setAddress("639 E Brooks Ave, North Las Vegas, NV 89030");
        o9.setWebsite("http://www.lasvegasdreamcenter.org/");
        o9.setEmail("info@lasvegasdreamcenter.org");
        o9.setHours("Tue-Fri 9am-4pm");
        o9.setLocation(36.2135046, -115.1321252);
        o9.setPhone("(02) 636-0023");
        o9.addService("Shelter");
        o9.addService("Food");
        o9.addService("Child Care");
        organizationRepository.save(o9);


        Organization o10 = new Organization();
        o10.setName("Elks Lodge");
        o10.setAddress("2939 Van Der Meer St, North Las Vegas, NV 89030");
        o10.setWebsite("http://www.elks.org/");
        o10.setEmail("info@elks.org");
        o10.setHours("Mon-Sun 10am-7pm");
        o10.setLocation(36.2131245, -115.1069307);
        o10.setPhone("(702) 642-9431");
        o10.addService("Food");
        o10.addService("Child Care");
        organizationRepository.save(o10);


        Organization o11 = new Organization();
        o11.setName("Project Real");
        o11.setAddress("310 S 4th St, Las Vegas, NV 89101");
        o11.setWebsite("http://www.projectreal.com/");
        o11.setEmail("info@projectrealnv.org");
        o11.setHours("Mon-Fri 12pm-7pm");
        o11.setLocation(36.1667248, -115.1439713);
        o11.setPhone("(702) 388-7527");
        o11.addService("Child Care");
        organizationRepository.save(o11);

        Organization o12 = new Organization();
        o12.setName("Serenity Community Care");
        o12.setAddress("2039 E Lake Mead Blvd, North Las Vegas, NV 89030");
        o12.setWebsite("http://www.serenitylasvegas.com");
        o12.setEmail("info@serenitylasvegas.com");
        o12.setHours("Mon-Sat 8am-8pm");
        o12.setLocation(36.1957394, -115.1199399);
        o12.setPhone("(702) 724-9300");
        o12.addService("Health");
        organizationRepository.save(o12);


        Organization o13 = new Organization();
        o13.setName("Safe Nest");
        o13.setAddress("2915 W Charleston Blvd, Ste 12, Las Vegas, NV 89102");
        o13.setWebsite("http://www.safenest.org/");
        o13.setEmail("info@safenest.org");
        o13.setHours("Mon-Sun 9am-6pm");
        o13.setLocation(36.158537, -115.181153);
        o13.setPhone("(702) 646-4981");
        o13.addService("Shelter");
        o13.addService("Food");
        o13.addService("Child Care");
        o13.addService("Health");
        organizationRepository.save(o13);

        Organization o14 = new Organization();
        o14.setAddress("1 New Place,\nLas Vegas, nv 89111");
        o14.setEmail("organization1@test.com");
        o14.setHours("Monday - Friday 8am - 5pm\nSaturday 5am-8am");
        o14.setLocation(36.062339, -115.215490);
        o14.setName("Helping Hands - 1");
        o14.setPhone("(702) 555-1212");
        o14.setWebsite("http://disney.com");
        o14.addService("Food");
        organizationRepository.save(o14);

        Organization o15 = new Organization();
        o15.setAddress("2 New Place,\nLas Vegas, nv 89111");
        o15.setEmail("organization2@test.com");
        o15.setHours("Monday - Friday 8am - 5pm\nSaturday 5am-8am");
        o15.setLocation(36.066433, -115.212743);
        o15.setName("Catholic Charities - 2");
        o15.setPhone("(702) 555-1212");
        o15.setWebsite("http://disney.com");
        o15.addService("Education");
        organizationRepository.save(o15);

        Organization o16 = new Organization();
        o16.setAddress("3 New Place,\nLas Vegas, nv 89111");
        o16.setEmail("organization3@test.com");
        o16.setHours("Monday - Friday 8am - 5pm\nSaturday 5am-8am");
        o16.setLocation(36.064837, -115.210683);
        o16.setName("Goodwill - 3");
        o16.setPhone("(702) 555-1212");
        o16.setWebsite("http://disney.com");
        o16.addService("Health");
        organizationRepository.save(o16);

        Organization o17 = new Organization();
        o17.setAddress("4 New Place,\nLas Vegas, nv 89111");
        o17.setEmail("organization4@test.com");
        o17.setHours("Monday - Friday 8am - 5pm\nSaturday 5am-8am");
        o17.setLocation(36.062964, -115.223687);
        o17.setName("Helping Hands - 4");
        o17.setPhone("(702) 555-1212");
        o17.setWebsite("http://disney.com");
        o17.addService("Child Care");
        organizationRepository.save(o17);

        Organization o18 = new Organization();
        o18.setAddress("5 New Place,\nLas Vegas, nv 89111");
        o18.setEmail("organization5@test.com");
        o18.setHours("Monday - Friday 8am - 5pm\nSaturday 5am-8am");
        o18.setLocation(37.060986, -116.218558);
        o18.setName("Helping Hands - 5");
        o18.setPhone("(702) 555-1212");
        o18.setWebsite("http://disney.com");
        o18.addService("Health");
        organizationRepository.save(o18);

        //Let's play with data
        Iterable<AvailableService> s = asRepository.findAll();
        System.out.println("Services Findall");
        for(AvailableService service : s){
            System.out.println(service);
        }

        System.out.println();

        Iterable<Organization> o = organizationRepository.findByLocationNear(new Point(-115.213341,36.066634),
                new Distance(10, Metrics.MILES));

        System.out.println("Organizations within 10 miles");
        for(Organization org : o){
            System.out.println(org);
        }

        List<Organization> rval= new ArrayList<Organization>();

        for(Organization org : o){
            if(org.getServices().contains("Health")){
                rval.add(org);
            }
        }

        System.out.println("Organizations within 10 miles of service Health");
        for(Organization org : rval){
            System.out.println(org);
        }

    }

}
