package com.burwasolution.vishwakarma.reprository.users;

import com.burwasolution.vishwakarma.domains.entity.basic.Otp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OtpRepository extends MongoRepository<Otp, String> {

    @Query(value = "{$and: [{'mobileNumber':?0},{'otp':?1}]}).limit(1).sort({ _id:-1 }")
    List<Otp> findByMobileNumberAndOtp(String mobileNumber, String otp);
}
