package com.burwasolution.vishwakarma.domains.entity.basic;

import lombok.*;
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
@ToString
@Document(collection = "serveyor")
public class Serveyor extends BaseObject {

    private String username;
    private String gender;
    private Date dateOfBirth;
    private String emailId;
    private String mobileNumber;
    private String govtDepart;
    private String govtId;
    private String designation;
    private boolean isVerified = false;
    private List<Role> roles = new ArrayList<>();
    private String authToken;
    @LastModifiedDate
    private LocalDateTime authTokenCreationTime;


    private enum gender {
        male, female;
    }

}
