package com.burwasolution.vishwakarma.domains.entity.primary.foundationDataSources;

import com.burwasolution.vishwakarma.domains.entity.basic.BaseObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RationCard extends BaseObject {

    private cardType cardType;
    private String rationCardNo;
    private String eid;
    private String uid;
    private String dfso;
    private String tfso;
    private String villageName;
    private String fpsName;
    private String headOfFamilyName;
    private int headOfFamilyAge;
    private String motherName;
    private String fatherName;
    private gender gender;
    private String spouseName;
    private Date dateOfBirth;
    private int age;
    private String occupation;
    private int annualIncome;
    private gasConnection gasConnection;
    private String gasNumber;
    private String gasAgencyName;
    private String customerNo;
    private address address;
    private permanentAddress permanentAddress;
    private List<memberDetails> memberDetails;

    private enum cardType {
        APL, BPL, AAY, AAP
    }

    private enum gender {
        Male, Female
    }

    private enum gasConnection {
        Deepam, Double, Single, No_Cylinder
    }

    public static class address {
        private String doorNo;
        private String Locality;
        private String district;
        private String Mandal;
        private String village;
        private int pinCode;
        private String fpShopNo;
    }

    public static class permanentAddress {
        private String doorNo;
        private String Locality;
        private String district;
        private String Mandal;
        private String village;
        private int pinCode;
        private String fpShopNo;
    }

    private static class memberDetails {
        private String name;
        private gender gender;
        private Date dateOfBirth;
        private String motherName;
        private String fatherName;
        private boolean optionToLiftCommodity;
        private int age;
        private String eid;
        private String uid;
        private String relWithHead;

    }
}
