package com.burwasolution.vishwakarma.reprository.users;

import com.burwasolution.vishwakarma.domains.dto.response.CountAll;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountAllRepository extends MongoRepository<CountAll, String> {

}
