package com.burwasolution.vishwakarma.domains.entity.primary.foundationDataSources;

import com.burwasolution.vishwakarma.domains.entity.basic.BaseObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "voter_details")
public class VoterCardDetails extends BaseObject {

    @Indexed(unique = true)
    private String voteridCardNumber;
    private String voterName;
    private String voterFatherName;
    private int voterAge;
    private sex voterGender;
    private Date dateOfBirth;
    private String voterResidence;
    private String voterHouseNo;
    private Date issueDate;
    private String address;
    private String profilePic;

    public enum sex {
        Male, Female
    }


}
