package com.burwasolution.vishwakarma.service_impl.service.groupData;

import com.burwasolution.vishwakarma.domains.dto.response.groupData.*;
import com.burwasolution.vishwakarma.domains.dto.response.headerFilter.CardDataFilterDTO;
import com.burwasolution.vishwakarma.domains.entity.headerFilter.CardDataFilter;
import com.burwasolution.vishwakarma.domains.dto.response.location.FilterCounts;
import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import javassist.NotFoundException;

import java.util.List;

public interface GroupDataService {
    List<FamilyListDTO> findFamilyList(Users users);
    List<IndividualMemberDTO> getFamilyMemberDetails(Users users);
    IndividualMemberDTO getIndividualDetails(Users users);
    List<EmployedListDTO> getEmployedList(Users users);
    List<EmployedDetailsDTO> getListBySpecificEmployed(Users users);
    List<SchemesEnrolledDTO> getListOfSchemesEnrolled(Users users);
    List<IndividualMemberDTO> getUserDataBySchemeEnrolled(Users users);
    List<VmulyankanaResponseDTO> getVmulyankaList(Users users);
    FilterCounts findByLocationFilter(FilterCounts filterCounts) throws NotFoundException;
    CardDataFilter findByCardDataFilter(CardDataFilterDTO cardDataFilter);
}
