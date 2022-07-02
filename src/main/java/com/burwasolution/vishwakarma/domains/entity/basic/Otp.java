package com.burwasolution.vishwakarma.domains.entity.basic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "otp")
public class Otp extends BaseObject{

    private String otp;
    private Date expiryTime;
    private String mobileNumber;
    private String message;
}
