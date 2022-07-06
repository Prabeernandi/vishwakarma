package com.burwasolution.vishwakarma.reprository.users;

import com.burwasolution.vishwakarma.domains.entity.basic.GovtSchemes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GovtSchemesRepository extends MongoRepository<GovtSchemes, String> {
    GovtSchemes findBySchemeCode(String schemeCode);
}
