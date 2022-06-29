package com.burwasolution.vishwakarma.reprository.location;

import com.burwasolution.vishwakarma.domains.entity.location.Village;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VillageRepository extends MongoRepository<Village, String> {

    @Query("{'blockCode':?0}")
    List<Village> findByBlockCode(String id);

    Village findByVillageCode(String villageId);
}
