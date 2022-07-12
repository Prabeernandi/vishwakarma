package com.burwasolution.vishwakarma.service_impl.service.groupData;

import com.burwasolution.vishwakarma.domains.dto.response.groupData.*;
import com.burwasolution.vishwakarma.domains.dto.response.headerFilter.CardDataFilterDTO;
import com.burwasolution.vishwakarma.domains.dto.response.location.TableDataFilter;
import com.burwasolution.vishwakarma.domains.entity.headerFilter.CardDataFilter;
import com.burwasolution.vishwakarma.domains.entity.basic.Users;

import java.util.List;

public interface GroupDataService {
    List<FamilyListDTO> findFamilyList(Users users);
    List<IndividualMemberDTO> getFamilyMemberDetails(Users users);
    IndividualMemberDTO getIndividualDetails(Users users);
    List<EmployedDetailsDTO> getListBySpecificEmployed(Users users);
    CardDataFilter findByCardDataFilter(CardDataFilterDTO cardDataFilter);
    TableDataFilter findByTableDataFilter(TableDataFilter tableDataFilter);
}
