package com.burwasolution.vishwakarma.domains.dto.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServeyorOtp {

    private String otp;
    private Date expiryTime;
    private long mobileNumber;
    private String message;
}
