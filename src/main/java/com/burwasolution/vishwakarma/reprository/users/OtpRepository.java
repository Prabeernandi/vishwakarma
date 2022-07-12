package com.burwasolution.vishwakarma.reprository.users;

import com.burwasolution.vishwakarma.domains.entity.basic.Otp;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OtpRepository extends MongoRepository<Otp, String> {


    List<Otp> findTopOneByMobileNumberAndOtp(String mobileNumber, String otp);
}
