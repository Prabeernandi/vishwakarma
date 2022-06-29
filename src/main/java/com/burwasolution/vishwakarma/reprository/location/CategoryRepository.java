package com.burwasolution.vishwakarma.reprository.location;

import com.burwasolution.vishwakarma.domains.entity.location.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    List<Category> findByVillageCode(String id);

    Category findByCategoryCode(String categoryId);
}
