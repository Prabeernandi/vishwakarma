package com.burwasolution.vishwakarma.reprository.location;

import com.burwasolution.vishwakarma.domains.entity.location.Blocks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockRepository extends MongoRepository<Blocks, String> {

    @Query("{'tehsilCode':?0}")
    List<Blocks> findyByTehsilCode(String id);

    Blocks findByBlockCode(String blockId);
}
