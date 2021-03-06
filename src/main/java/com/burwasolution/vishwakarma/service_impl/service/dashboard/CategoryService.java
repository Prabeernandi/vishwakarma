package com.burwasolution.vishwakarma.service_impl.service.dashboard;

import com.burwasolution.vishwakarma.domains.dto.response.location.CategoryCountsDTO;
import com.burwasolution.vishwakarma.domains.dto.response.location.LocationLists;
import com.burwasolution.vishwakarma.domains.entity.location.Category;

import java.util.List;

public interface CategoryService {

    List<Category> saveData(List<Category> category);

    List<LocationLists> findAll();

    List<LocationLists> findByVillageCode(String villageId);

    CategoryCountsDTO getCountsInCategory(String categoryId);
}
