package com.burwasolution.vishwakarma.domains.entity.primary.schemeBeneficiaryData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "pmayd")
public class PMAwaasScheme {

    private String fatherSpouseName;
    private String beneficiaryName;
    private String registrationNo;
    private String schemeName;
    private String financialYear;
    private String priorityCategory;
    private String category;
    private String bplFamilyIdNo;
    private String nregaJobCardNo;
    private String siteAllottedByGovt;
    private String inspectingOfficer;
    private String houseStatus;
    private String sanctionNo;
    private Date sanctionDate;
    private long sanctionAmt;
    private int NoOfInstallments;
    private long amountReleased;
    private Date lastAmtTransferDate;
    private Date inspectionDate;


}
