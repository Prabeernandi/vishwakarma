package com.burwasolution.vishwakarma.service_impl.service.dashboard;

import com.burwasolution.vishwakarma.domains.dto.response.location.LocationLists;
import com.burwasolution.vishwakarma.domains.dto.response.location.VillageCountDTO;
import com.burwasolution.vishwakarma.domains.entity.location.Village;

import java.util.List;

public interface VillageService {

    List<Village> saveData(List<Village> village);

    List<Village> findAll();

    List<LocationLists> findByBlockCode(String id);

    VillageCountDTO getCountsInVillage(String villageId);
}
