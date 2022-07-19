package com.burwasolution.vishwakarma.service_impl.service.groupData;

import com.burwasolution.vishwakarma.domains.dto.response.groupData.EmployedDetailsDTO;
import com.burwasolution.vishwakarma.domains.dto.response.groupData.EmployedType;
import com.burwasolution.vishwakarma.domains.dto.response.groupData.FamilyListDTO;
import com.burwasolution.vishwakarma.domains.dto.response.groupData.IndividualMemberDTO;
import com.burwasolution.vishwakarma.domains.dto.response.headerFilter.CardDataFilterDTO;
import com.burwasolution.vishwakarma.domains.dto.response.location.TableDataFilter;
import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import com.burwasolution.vishwakarma.domains.entity.headerFilter.CardDataFilter;

import java.util.List;

public interface GroupDataService {
    List<FamilyListDTO> findFamilyList(CardDataFilterDTO cardDataFilter);
    List<IndividualMemberDTO> getFamilyMemberDetails(String familyId);
    IndividualMemberDTO getIndividualDetails(Users users);
    List<EmployedDetailsDTO> getListBySpecificEmployed(Users users);
    CardDataFilter findByCardDataFilter(CardDataFilterDTO cardDataFilter);
    List<TableDataFilter> findByTableDataFilter(TableDataFilter tableDataFilter);
    List<EmployedType> getListOfEmployedTypes(EmployedType employedType);
    List<EmployedType> getSchemeTypeList(EmployedType cardDataFilter);
}
