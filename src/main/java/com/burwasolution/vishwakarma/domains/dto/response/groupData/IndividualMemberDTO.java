package com.burwasolution.vishwakarma.domains.dto.response.groupData;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndividualMemberDTO {

    private String name;
    private String familyId;
    private String userId;
    private int age;
    private String address;
    private String stateName;
    private String districtName;
    private String tehsilName;
    private String villageName;
    private String voterResidence;
    private String dateOfBirth;
    private String employed;
    private String income;
    private String vmulyankana;
    private String rationCardImgUrl;
    private boolean isManrekaEnabled;
    private String govtSchemeEnrolled;
    private String pmAwaasImgUrl;
    private String pmkissanImgUrl;
    private String voterId;
    private String aadharNo;
    private String panCardNo;
    private String epf_nps;
    private String gramPanchayat;
    private String mobileNumber;

}
