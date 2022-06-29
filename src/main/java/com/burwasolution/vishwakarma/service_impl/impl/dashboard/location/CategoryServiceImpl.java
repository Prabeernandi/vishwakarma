package com.burwasolution.vishwakarma.service_impl.impl.dashboard.location;

import com.burwasolution.vishwakarma.domains.dto.response.location.CategoryCountsDTO;
import com.burwasolution.vishwakarma.domains.dto.response.location.LocationLists;
import com.burwasolution.vishwakarma.domains.entity.location.Category;
import com.burwasolution.vishwakarma.reprository.location.CategoryRepository;
import com.burwasolution.vishwakarma.service_impl.service.dashboard.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<Category> saveData(List<Category> category) {
        return categoryRepository.saveAll(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<LocationLists> findByVillageCode(String id) {
        List<Category> categories = categoryRepository.findByVillageCode(id);
        List<LocationLists> locationArray = new ArrayList<>();

        for (Category category : categories) {
            LocationLists locationLists = LocationLists.builder()
                    .name(category.getName())
                    .displayName(category.getDisplayName())
                    .code(category.getCategoryCode())
                    .build();
            locationArray.add(locationLists);
        }
        return locationArray;
    }

    @Override
    public CategoryCountsDTO getCountsInCategory(String categoryId) {
        Category category = categoryRepository.findByCategoryCode(categoryId);
        if (categoryId != null) {
            long families, employed, govtSchemesEnrolled, vMulyankana;
            families = employed = govtSchemesEnrolled = vMulyankana = 0;

            if (categoryId.equals("ST")) {
                families = 34767;
                employed = 12456;
                govtSchemesEnrolled = 3416;
                vMulyankana = 13786;
            } else if (categoryId.equals("OBC")) {
                families = 23768;
                employed = 15987;
                govtSchemesEnrolled = 2544;
                vMulyankana = 18097;

            } else if (categoryId.equals("SC")) {
                families = 38998;
                employed = 22000;
                govtSchemesEnrolled = 9887;
                vMulyankana = 16776;

            }

            CategoryCountsDTO categoryCountsDTO = CategoryCountsDTO.builder()
                    .name(category.getName())
                    .categoryCode(category.getCategoryCode())
                    .families(families)
                    .employed(employed)
                    .govtSchemesEnrolled(govtSchemesEnrolled)
                    .vMulyankana(vMulyankana)
                    .build();
            return categoryCountsDTO;
        } else {
            throw new NoSuchElementException();
        }
    }


}