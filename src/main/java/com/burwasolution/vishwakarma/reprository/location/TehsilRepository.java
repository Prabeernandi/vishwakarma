package com.burwasolution.vishwakarma.reprository.location;

import com.burwasolution.vishwakarma.domains.entity.location.Tehsil;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TehsilRepository extends MongoRepository<Tehsil, String> {


    List<Tehsil> findByDistrictCode(String districtId);

    Tehsil findByTehsilCode(String tehsilId);
}
