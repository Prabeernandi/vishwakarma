package com.burwasolution.vishwakarma.domains.entity.basic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "serveyor")
public class Approver extends BaseObject{

    private String username;
    private String gender;
    private Date dateOfBirth;
    private String emailId;
    private String mobileNumber;
    private String govtDepart;
    private String govtId;
    private String designation;
    private boolean isVerified = true;
    private List<Role> roles = new ArrayList<>();
    private String authToken;
    private String role;
    @LastModifiedDate
    private LocalDateTime authTokenCreationTime;
}
