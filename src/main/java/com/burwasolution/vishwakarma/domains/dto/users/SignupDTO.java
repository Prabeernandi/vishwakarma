package com.burwasolution.vishwakarma.domains.dto.users;

import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupDTO {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private Users.gender gender;
    private long mobileNumber;
}
