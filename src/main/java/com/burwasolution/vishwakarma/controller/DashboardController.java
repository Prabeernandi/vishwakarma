package com.burwasolution.vishwakarma.controller;

import com.burwasolution.vishwakarma.domains.dto.response.headerFilter.Age;
import com.burwasolution.vishwakarma.domains.dto.response.headerFilter.Gender;
import com.burwasolution.vishwakarma.domains.dto.response.location.*;
import com.burwasolution.vishwakarma.reprository.location.StateRepository;
import com.burwasolution.vishwakarma.service_impl.service.dashboard.*;
import com.burwasolution.vishwakarma.service_impl.service.general.HeaderLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final StateService stateService;
    private final StateRepository stateRepository;
    private final DistrictService districtService;
    private final BlockService blockService;
    private final TehsilService tehsilService;
    private final VillageService villageService;
    private final HeaderLabelService headerService;
    private final CategoryService categoryService;

    @Autowired
    public DashboardController(StateService stateService, DistrictService districtService
            , BlockService blockService, TehsilService tehsilService
            , VillageService villageService, CategoryService categoryService,
                               HeaderLabelService headerService, StateRepository stateRepository
    ) {
        this.stateService = stateService;
        this.districtService = districtService;
        this.blockService = blockService;
        this.tehsilService = tehsilService;
        this.villageService = villageService;
        this.headerService = headerService;
        this.categoryService = categoryService;
        this.stateRepository = stateRepository;
    }

    // dashboard Side bar API

    @GetMapping("/getStateList")
    private ResponseEntity<?> getStateList() {

        Map<String, Object> getStateList = new HashMap<>();
        getStateList.put("status", HttpStatus.OK);
        getStateList.put("result", stateService.findAll());
        getStateList.put("message", "State List");

        return new ResponseEntity<>(getStateList, HttpStatus.OK);
    }

    @GetMapping("/getDistrictList")
    private ResponseEntity<?> getDistrictListByStateCode(@RequestParam String id) {

        Map<String, Object> getDistrictList = new HashMap<>();
        getDistrictList.put("status", HttpStatus.OK);
        getDistrictList.put("result", districtService.findByStateCode(id));
        getDistrictList.put("message", "District List");

        return new ResponseEntity<>(getDistrictList, HttpStatus.OK);
    }

    @GetMapping("/getTehsilList")
    private ResponseEntity<?> getTehsilListbyDistrictCode(@RequestParam String id) {

        Map<String, Object> getTehsilList = new HashMap<>();
        getTehsilList.put("status", HttpStatus.OK);
        getTehsilList.put("result", tehsilService.findByDistrictCode(id));
        getTehsilList.put("message", "District List");

        return new ResponseEntity<>(getTehsilList, HttpStatus.OK);
    }

    @GetMapping("/getBlockList")
    private ResponseEntity<?> getBlockListbyTehsilCode(@RequestParam String id) {
        Map<String, Object> getBlockList = new HashMap<>();
        getBlockList.put("status", HttpStatus.OK);
        getBlockList.put("result", blockService.findByTehsilCode(id));
        getBlockList.put("message", "District List");

        return new ResponseEntity<>(getBlockList, HttpStatus.OK);
    }

    @GetMapping("/getVillageList")
    private ResponseEntity<?> getVillageListByBlockCode(@RequestParam String id) {

        Map<String, Object> getVillageList = new HashMap<>();
        getVillageList.put("status", HttpStatus.OK);
        getVillageList.put("result", villageService.findByBlockCode(id));
        getVillageList.put("message", "District List");

        return new ResponseEntity<>(getVillageList, HttpStatus.OK);
    }

    @GetMapping("/getCategoryList")
    private ResponseEntity<?> getCategoryListByVillageCode(@RequestParam String id) {

        Map<String, Object> getCategoryList = new HashMap<>();
        getCategoryList.put("status", HttpStatus.OK);
        getCategoryList.put("result", categoryService.findByVillageCode(id));
        getCategoryList.put("message", "District List");

        return new ResponseEntity<>(getCategoryList, HttpStatus.OK);
    }

//    @PostMapping("/saveStateData")
//    private List<States> saveStateData(@RequestBody List<States> states) {
//        return stateService.saveData(states);
//    }
//
//    @PostMapping("/saveDistrictData")
//    private List<District> saveDistrictData(@RequestBody List<District> district) {
//        return districtService.saveData(district);
//    }
//
//    @PostMapping("/saveTehsilData")
//    private List<Tehsil> saveTehsilData(@RequestBody List<Tehsil> tehsil) {
//        return tehsilService.saveData(tehsil);
//    }
//
//    @PostMapping("/saveBlockData")
//    private List<Blocks> saveBlockData(@RequestBody List<Blocks> blocks) {
//        return blockService.saveData(blocks);
//    }
//
//    @PostMapping("/saveVillageData")
//    private List<Village> saveVillageData(@RequestBody List<Village> village) {
//        return villageService.saveData(village);
//    }
//
//    @PostMapping("/saveCategoryData")
//    private List<Category> saveCategoryData(@RequestBody List<Category> category) {
//        return categoryService.saveData(category);
//    }
//
//    @PostMapping("/saveHeaderFilter")
//    private List<Age> getStateDetails(@RequestBody List<Age> details) {
//        return headerService.saveDetails(details);
//    }

    @GetMapping("/getHeaderAgeFilter")
    private List<Age> getHeaderAgeFilter() {
        return headerService.getAgeFilter();
    }

    @GetMapping("/getHeaderGenderFilter")
    private List<Gender> getHeaderGenderFilter() {
        return headerService.getGenderFilter();
    }


    @GetMapping("/getStateDataFilter")
    private List<StatesDTO> getCountsInState(@RequestParam String stateId) {
        return stateService.getCountsInState(stateId);
    }

//    @GetMapping("/getDistrictDataFilter")
//    private List<DistrictCountDTO> getCountsInDistrict(@RequestParam String districtId) {
//        return districtService.getCountsInDistrict(districtId);
//    }

    @GetMapping("/getTehsilDataFilter")
    private TehsilCountDTO getCountsInTehsil(@RequestParam String tehsilId) {
        return tehsilService.getCountsInTehsil(tehsilId);
    }

    @GetMapping("/getBlockDataFilter")
    private BlockCountDTO getCountsInBlock(@RequestParam String blockId) {
        return blockService.getCountsInBlock(blockId);
    }

    @GetMapping("/getVillageDataFilter")
    private VillageCountDTO getCountsInVillage(@RequestParam String villageId) {
        return villageService.getCountsInVillage(villageId);
    }

    @GetMapping("/getcategoryDataFilter")
    private CategoryCountsDTO getCountsInCategory(@RequestParam String categoryId) {
        return categoryService.getCountsInCategory(categoryId);
    }


}
