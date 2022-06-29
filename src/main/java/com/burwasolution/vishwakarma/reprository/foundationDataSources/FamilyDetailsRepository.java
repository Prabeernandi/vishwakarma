package com.burwasolution.vishwakarma.reprository.foundationDataSources;

import com.burwasolution.vishwakarma.domains.entity.primary.foundationDataSources.FamilyDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyDetailsRepository extends MongoRepository<FamilyDetails, String> {
}
