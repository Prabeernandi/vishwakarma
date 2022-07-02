package com.burwasolution.vishwakarma.service_impl.service.dashboard;

import com.burwasolution.vishwakarma.domains.dto.response.location.LocationLists;
import com.burwasolution.vishwakarma.domains.dto.response.location.TehsilCountDTO;
import com.burwasolution.vishwakarma.domains.entity.location.Tehsil;

import java.util.List;

public interface TehsilService {

    List<Tehsil> saveData(List<Tehsil> tehsil);

    List<Tehsil> findAll();

    List<LocationLists> findByDistrictCode(String districtId);

    TehsilCountDTO getCountsInTehsil(String tehsilId);
}
