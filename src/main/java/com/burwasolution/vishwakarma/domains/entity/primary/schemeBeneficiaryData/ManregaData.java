package com.burwasolution.vishwakarma.domains.entity.primary.schemeBeneficiaryData;

import com.burwasolution.vishwakarma.domains.entity.basic.BaseObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "manrega_data")
public class ManregaData extends BaseObject {


    private String headOfFamily;
    private String idCardNumber;
    private gender gender;
    private String relationWithHof;
    private String motherName;
    private String registrationNo;
    private String headOfHousehold;
    private String applicantNo;
    private String applicantName;
    private String stateName;
    private String districtName;
    private String blockNamme;
    private String panchayat;
    private String villageName;
    private String address;
    private int age;

    private enum gender {
        Male, Female
    }
}
