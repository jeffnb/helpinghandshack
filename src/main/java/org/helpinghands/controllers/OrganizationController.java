package org.helpinghands.controllers;

import org.helpinghands.Repositories.OrganizationRepository;
import org.helpinghands.models.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kelly on 5/31/14.
 */
@RestController
@RequestMapping("/organizations")
public class OrganizationController { //--->   /organizations/{service}?lat=x&long=y&dist=z

    @Autowired
    OrganizationRepository organizationRepository;

    @RequestMapping("/service/{service}")
    public Iterable<Organization> getOrganizations(@PathVariable String service,
                                               @RequestParam(value = "lat", required = true) double latitude,
                                               @RequestParam(value = "long", required = true) double longitude,
                                               @RequestParam(value = "dist", required = true) double miles){

        Point point = new Point(longitude, latitude);
        Distance distance = new Distance(miles);

        List<Organization> rval= new ArrayList<Organization>();

        Iterable<Organization> o = organizationRepository.findByLocationNear(point, distance);
//        for(Organization org : o){
//            if(org.getServices().contains(service)){
//                rval.add(org);
//            }
//        }

        return o;
    }
}

