package com.burwasolution.vishwakarma.domains.entity.basic;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@Document(collection = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Users extends BaseObject {

    private String username;
    private String firstName;
    private String fullName;
    private String userId;
    private String lastName;
    private String password;
    private Date dateOfBirth;
    private List<Role> roles = new ArrayList<>();
    private String gender;
    private String mobileNumber;
    private String fatherSpouseName;
    private String familyId;
    private String bhulekhId;
    private String ageBar;
    private String familyHead;
    private String motherName;
    private String stateName;
    private String districtName;
    private String tehsilName;
    private String villageName;
    private String stateCode;
    private String districtCode;
    private String tehsilCode;
    private String blockCode;
    private String villageCode;
    private int age;
    private String employed;
    private long income;
    private long vmulyankana;
    private long percentage;
    private String areaInHectare;
    private String farmerKhasraCount;
    private String voterId;
    private String houseNumber;
    private String caste;
    private String aadharNo;
    private String authToken;
    private String panCardNo;
    private String epf_nps;
    private boolean isVerified = true;
    private String gramPanchayat;
    private String nameOfCraft;
    private boolean hasRashanCard;
    private String rationCardNumber;
    private String status;
    private String areaType;
    private int numberOfFamilyCounts;
    private String memberId;
    private String uidNo;
    private String relationWithHof;
    private String registrationNo;
    private String address;
    private boolean isManrekaEnabled;
    private String manrekaRegNo;
    private boolean isPMKisaanEnabled;
    private boolean hasPradhanMantriAwaasYojna;
    private String pmAwaasRegNo;
    private String nregaJobCardNo;
    private String hasBiogasScheme;

    @LastModifiedDate
    private LocalDateTime authTokenCreationTime;

    public enum gender {
        male, female, transgender
    }


}
