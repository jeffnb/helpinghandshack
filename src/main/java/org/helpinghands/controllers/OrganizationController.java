package org.helpinghands.controllers;

import org.helpinghands.Repositories.OrganizationRepository;
import org.helpinghands.models.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Kelly on 5/31/14.
 */
@RestController
@RequestMapping("/organizations")
public class OrganizationController { //--->   /organizations/{service}?lat=x&long=y&dist=z

    @Autowired
    OrganizationRepository organizationRepository;

    @RequestMapping("/{service}")
    public List<Organization> getOrganizations(@PathVariable String service,
                                               @RequestParam(value = "lat", required = true) double latitude,
                                               @RequestParam(value = "long", required = true) double longitude,
                                               @RequestParam(value = "dist", required = true) double miles){

        Point point = new Point(latitude, longitude);
        Distance distance = new Distance(miles);

        return organizationRepository.findByLocationNear(point, distance);
    }
}

