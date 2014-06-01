package org.helpinghands.Repositories;

import org.helpinghands.models.Organization;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by ocx on 5/31/14.
 */
public interface OrganizationRepository extends MongoRepository<Organization, String>{

    List<Organization> findByLocationNear(Point location, Distance distance);
}
