package com.burwasolution.vishwakarma.reprository.users;

import com.burwasolution.vishwakarma.domains.entity.basic.Serveyor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServeyorRepository extends MongoRepository<Serveyor, String> {
    Serveyor findByUsername(String username);

    Serveyor findByMobileNumber(long mobileNumber);
}
