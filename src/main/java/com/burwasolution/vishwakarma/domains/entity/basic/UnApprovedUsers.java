package com.burwasolution.vishwakarma.domains.entity.basic;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Document(collection = "unApprovedUsers")
public class UnApprovedUsers extends BaseObject {

    private String familyId;
    private String fullName;
    private String address;
    private Date dateOfBirth;
    private String voterId;
    private String aadharNo;
    private String panCardNo;
    private String mobileNumber;
    private String employed;
    private String rationCardNumber;
    private String manrekaRegNo;
    private String bhulekhId;
    private String govtSchemeEnrolled;
    private String epf_nps;
    private String gramPanchayat;
    private long income;
    private long vmulyankana;
    @JsonProperty
    private boolean isManrekaEnabled;
    @JsonProperty
    private boolean isPMKisaanEnabled;
    private boolean isApproved = false;
    private String status;

}
