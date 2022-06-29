package com.burwasolution.vishwakarma.service_impl.service.dashboard;

import com.burwasolution.vishwakarma.domains.dto.response.location.BlockCountDTO;
import com.burwasolution.vishwakarma.domains.dto.response.location.LocationLists;
import com.burwasolution.vishwakarma.domains.entity.location.Blocks;

import java.util.List;

public interface BlockService {

    List<Blocks> saveData(List<Blocks> blocks);

    List<Blocks> findAll();

    List<LocationLists> findByTehsilCode(String id);

    BlockCountDTO getCountsInBlock(String blockId);
}
