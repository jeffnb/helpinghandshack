package org.helpinghands.Repositories;

import org.helpinghands.models.Organization;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ocx on 5/31/14.
 */
public interface OrganizationRepository extends MongoRepository<Organization, String>{

}
