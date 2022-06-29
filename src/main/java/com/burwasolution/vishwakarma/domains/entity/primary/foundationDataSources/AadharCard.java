package com.burwasolution.vishwakarma.domains.entity.primary.foundationDataSources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "aadhar_details")
public class AadharCard {

    @Indexed(unique = true)
    private String rationCardNumber;
    private status status;
    private String areaType;
    private String familyHead;
    private int MSNo;
    private String memberName;
    private String memberId;
    private int memberAge;
    private long UID;
    private long mobileNo;
    private String relationWithHoF;
    private String motherName;
    private String fatherName;
    private gender gender;

    private enum gender {
        Male, Female
    }

    private enum status {
        Verified_And_Approved, Yet_To_Be_Scanned
    }


}
