package com.burwasolution.vishwakarma.domains.entity.primary.foundationDataSources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BioGasData {

    private String name;
    private String fatherName;
    private String husbandName;
    private address address;
    private long contactNo;
    private String category;
    private int noOfCattleOwned;
    private String sizeOfBiogas;
    private String modelOfBiogas;
    private String identificationOnMark;
    private String codeNumberOfBiogasPlant;
    private Date dateOfCommissioningBiogas;
    private long subsidyPaid;


}
