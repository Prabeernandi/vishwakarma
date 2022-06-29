package com.burwasolution.vishwakarma.reprository.foundationDataSources;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterCardDetails extends MongoRepository<VoterCardDetails, String> {
}
