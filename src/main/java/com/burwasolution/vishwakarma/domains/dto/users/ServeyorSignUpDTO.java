package com.burwasolution.vishwakarma.domains.dto.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServeyorSignUpDTO {

    private String username;
    private String gender;
    private String dateOfBirth;
    private String emailId;
    private String mobileNumber;
    private String govtDepart;
    private String govtId;
    private String designation;
    private String role;
}
