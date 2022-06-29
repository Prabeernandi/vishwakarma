package com.burwasolution.vishwakarma.domains.dto.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServeyorSignUpDTO {

    private String username;
    private String gender;
    private Date dateOfBirth;
    private String emailId;
    private long mobileNumber;
    private String govtDepart;
    private String govtId;
    private String designation;


}