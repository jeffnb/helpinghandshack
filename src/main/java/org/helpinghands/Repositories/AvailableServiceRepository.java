package org.helpinghands.Repositories;

import org.helpinghands.models.AvailableService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ocx on 5/31/14.
 */
public interface AvailableServiceRepository extends MongoRepository<AvailableService, String> {


}
