package com.burwasolution.vishwakarma.domains.entity.basic;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document(collection = "otp")
public class Otp extends BaseObject{

    private String otp;
    private Date expiryTime;
    private long mobileNumber;
    private String message;
}
