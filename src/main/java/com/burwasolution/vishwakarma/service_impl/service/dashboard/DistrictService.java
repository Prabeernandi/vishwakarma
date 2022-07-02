package com.burwasolution.vishwakarma.service_impl.service.dashboard;

import com.burwasolution.vishwakarma.domains.dto.response.location.LocationLists;
import com.burwasolution.vishwakarma.domains.entity.location.District;

import java.util.List;

public interface DistrictService {

    List<District> saveData(List<District> district);

    List<District> findAll();

    List<LocationLists> findByStateCode(String stateId);

//    List<DistrictCountDTO> getCountsInDistrict(String districtId);
}
