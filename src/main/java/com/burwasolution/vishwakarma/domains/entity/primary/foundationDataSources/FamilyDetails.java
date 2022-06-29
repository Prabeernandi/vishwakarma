package com.burwasolution.vishwakarma.domains.entity.primary.foundationDataSources;

import com.burwasolution.vishwakarma.domains.entity.basic.BaseObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "family_details")
public class FamilyDetails extends BaseObject {

    private String name;
    private String address;
    private Date dateOfBirth;
    private occupation occupation;
    private String govtSchemesEnrolled;
    private int cibilScore;

    public enum occupation {
        Farmer, Landless_Farmer, Artisan, Street_vendor, Farmer_who_is_also_an_Artisan, Labour, Farmer_who_is_also_a_Labour,
        Farmer_who_is_also_a_Government_Servant, Landless_Farmer_who_is_also_a_Government_Servant,
        Farmer_with_Allied_farming_or_Supporting_Business
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class address {
        private static final String DEFAULT_COUNTRY = "IND";

        private String state;
        private String district;
        private String subDistrict;
        private String block;
        private String village;

    }
}
