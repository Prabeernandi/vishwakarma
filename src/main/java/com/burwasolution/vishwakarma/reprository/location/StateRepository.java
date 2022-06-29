package com.burwasolution.vishwakarma.reprository.location;

import com.burwasolution.vishwakarma.domains.entity.location.States;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends MongoRepository<States, String> {
    States findByStateCode(String stateId);
}
