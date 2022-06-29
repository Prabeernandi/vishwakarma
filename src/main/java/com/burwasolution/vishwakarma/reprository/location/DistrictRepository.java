package com.burwasolution.vishwakarma.reprository.location;

import com.burwasolution.vishwakarma.domains.entity.location.District;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends MongoRepository<District, String> {
    List<District> findByStateCode(String id);


    List<District> findAllByStateCode(String id);
}
