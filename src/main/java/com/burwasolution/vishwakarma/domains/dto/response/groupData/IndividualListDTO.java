package com.burwasolution.vishwakarma.domains.dto.response.groupData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IndividualListDTO {

    private String familyId;
    private String fullName;
    private String address;
    private Date dateOfBirth;
    private String voterId;
    private String aadharNo;
    private String panCardNo;
    private String mobileNumber;
    private String employed;
    private String epf_nps;
    private String gramPanchayat;
    private long income;
    private long vmulyankana;
    private boolean isManrekaEnabled;
    private boolean isPMKisaanEnabled;
}
