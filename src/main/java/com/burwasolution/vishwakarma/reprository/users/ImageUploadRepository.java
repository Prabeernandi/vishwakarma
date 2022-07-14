package com.burwasolution.vishwakarma.reprository.users;

import com.burwasolution.vishwakarma.domains.entity.basic.ImageUpload;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageUploadRepository extends MongoRepository<ImageUpload,String > {
}
