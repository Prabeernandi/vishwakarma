package com.burwasolution.vishwakarma.reprository.foundationDataSources;

import com.burwasolution.vishwakarma.domains.entity.primary.foundationDataSources.AadharCard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AadharRepository extends MongoRepository<AadharCard, String> {
}
