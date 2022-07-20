package com.burwasolution.vishwakarma.reprository.users;

import com.burwasolution.vishwakarma.domains.entity.basic.Serveyor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServeyorRepository extends MongoRepository<Serveyor, String> {
    Serveyor findByUsername(String username);

    Serveyor findByMobileNumber(String  mobileNumber);

    Serveyor findByEmailId(String emailId);
}
