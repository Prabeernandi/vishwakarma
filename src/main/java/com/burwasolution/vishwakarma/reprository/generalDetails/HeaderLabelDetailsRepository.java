package com.burwasolution.vishwakarma.reprository.generalDetails;

import com.burwasolution.vishwakarma.domains.dto.response.headerFilter.Age;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaderLabelDetailsRepository extends MongoRepository<Age, String> {

}
