package com.burwasolution.vishwakarma.service_impl.service.groupData;

import com.burwasolution.vishwakarma.domains.dto.response.groupData.FamilyListDTO;
import com.burwasolution.vishwakarma.domains.dto.response.groupData.IndividualListDTO;
import com.burwasolution.vishwakarma.domains.dto.users.GovtSchemesDTO;
import com.burwasolution.vishwakarma.domains.dto.users.ImageUploadDTO;
import com.burwasolution.vishwakarma.domains.dto.users.ValidationUsersDetails;
import com.burwasolution.vishwakarma.domains.entity.basic.Employed;
import com.burwasolution.vishwakarma.domains.entity.basic.FamilyMembersDetails;
import com.burwasolution.vishwakarma.domains.dto.users.ValidationCounts;
import javassist.NotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ServeyorService {
    FamilyMembersDetails addFamilyMember(IndividualListDTO familyMember) throws NotFoundException;

    List<Employed> getEmployedType();

    List<GovtSchemesDTO> getGovtSchemes(String schemeCode, String idNo, String schemeName);

    IndividualListDTO editFamilyMember(IndividualListDTO familyMember) throws NotFoundException;

    List<FamilyListDTO> getUnVerifiedMemberList(int pageNumber);

    ImageUploadDTO serveyorUploadImage(String idName, String idNo, MultipartFile file) throws IOException;

    List<FamilyListDTO> getFamilyList(String familyId);

    ValidationCounts getValidationStatus(ValidationCounts validationCounts);

    List<ValidationUsersDetails> getCompletedUserDetails(ValidationUsersDetails validationUsersDetails);

    List<ValidationUsersDetails> getVerifyPendingUserDetails(ValidationUsersDetails validationUsersDetails);

    List<ValidationUsersDetails> getApprovalPendingUserDetails(ValidationUsersDetails validationUsersDetails);

    List<ValidationUsersDetails> getApprovedUserDetails(ValidationUsersDetails validationUsersDetails);
}

