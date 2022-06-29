package com.burwasolution.vishwakarma.reprository.users;

import com.burwasolution.vishwakarma.domains.entity.basic.Otp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OtpRepository extends MongoRepository<Otp, String> {

    @Query(value = "db.otp.find({})" +
            "   .projection({})" +
            "   .sort({_id:-1})" +
            "   .limit(1)")
    List<Otp> findByMobileNumber(long mobileNumber);
}
