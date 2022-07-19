package com.burwasolution.vishwakarma.controller;

import com.burwasolution.vishwakarma.domains.dto.response.groupData.EmployedType;
import com.burwasolution.vishwakarma.domains.dto.response.headerFilter.Age;
import com.burwasolution.vishwakarma.domains.dto.response.headerFilter.CardDataFilterDTO;
import com.burwasolution.vishwakarma.domains.dto.response.headerFilter.Gender;
import com.burwasolution.vishwakarma.domains.dto.response.location.TableDataFilter;
import com.burwasolution.vishwakarma.domains.entity.basic.Employed;
import com.burwasolution.vishwakarma.domains.entity.basic.GovtSchemes;
import com.burwasolution.vishwakarma.reprository.location.StateRepository;
import com.burwasolution.vishwakarma.service_impl.service.dashboard.*;
import com.burwasolution.vishwakarma.service_impl.service.header.HeaderLabelService;
import com.burwasolution.vishwakarma.service_impl.service.groupData.GroupDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
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
    private final GroupDataService groupDataService;

    @Autowired
    public DashboardController(StateService stateService, DistrictService districtService
            , BlockService blockService, TehsilService tehsilService
            , VillageService villageService, CategoryService categoryService,
                               HeaderLabelService headerService, StateRepository stateRepository,
                               GroupDataService groupDataService
    ) {
        this.stateService = stateService;
        this.districtService = districtService;
        this.blockService = blockService;
        this.tehsilService = tehsilService;
        this.villageService = villageService;
        this.headerService = headerService;
        this.categoryService = categoryService;
        this.stateRepository = stateRepository;
        this.groupDataService = groupDataService;
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
    private ResponseEntity<?> getDistrictListByStateCode(@RequestParam String stateId) {

        Map<String, Object> getDistrictList = new HashMap<>();
        getDistrictList.put("status", HttpStatus.OK);
        getDistrictList.put("result", districtService.findByStateCode(stateId));
        getDistrictList.put("message", "District List");

        return new ResponseEntity<>(getDistrictList, HttpStatus.OK);
    }

    @GetMapping("/getTehsilList")
    private ResponseEntity<?> getTehsilListbyDistrictCode(@RequestParam String districtId) {

        Map<String, Object> getTehsilList = new HashMap<>();
        getTehsilList.put("status", HttpStatus.OK);
        getTehsilList.put("result", tehsilService.findByDistrictCode(districtId));
        getTehsilList.put("message", "Tehsil List");

        return new ResponseEntity<>(getTehsilList, HttpStatus.OK);
    }

    @GetMapping("/getBlockList")
    private ResponseEntity<?> getBlockListbyTehsilCode(@RequestParam String tehsilId) {
        Map<String, Object> getBlockList = new HashMap<>();
        getBlockList.put("status", HttpStatus.OK);
        getBlockList.put("result", blockService.findByTehsilCode(tehsilId));
        getBlockList.put("message", "Block List");

        return new ResponseEntity<>(getBlockList, HttpStatus.OK);
    }

    @GetMapping("/getVillageList")
    private ResponseEntity<?> getVillageListByBlockCode(@RequestParam String blockId) {

        Map<String, Object> getVillageList = new HashMap<>();
        getVillageList.put("status", HttpStatus.OK);
        getVillageList.put("result", villageService.findByBlockCode(blockId));
        getVillageList.put("message", "Village List");

        return new ResponseEntity<>(getVillageList, HttpStatus.OK);
    }

    @GetMapping("/getCategoryList")
    private ResponseEntity<?> getCategoryListByVillageCode(@RequestParam String villageId) {

        Map<String, Object> getCategoryList = new HashMap<>();
        getCategoryList.put("status", HttpStatus.OK);
        getCategoryList.put("result", categoryService.findAll());
        getCategoryList.put("message", "Category List");

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

    @GetMapping("/getHeaderEmployedFilter")
    private List<Employed> getHeaderEmployed() {
        return headerService.getHeaderEmployed();
    }

    @GetMapping("/getHeaderGovtSchemesFilter")
    private List<GovtSchemes> getHeaderGovtSchemesFilter() {
        return headerService.getHeaderGovtSchemesFilter();
    }

    @PostMapping("/getCardDataFilter")
    private ResponseEntity<?> getCardDataFilter(@RequestBody CardDataFilterDTO CardDataFilter) {
        Map<String, Object> getCardDataFilter = new HashMap<>();
        getCardDataFilter.put("status", HttpStatus.OK);
        getCardDataFilter.put("result", groupDataService.findByCardDataFilter(CardDataFilter));
        getCardDataFilter.put("message", "Card Data Filter List");
        return new ResponseEntity<>(getCardDataFilter, HttpStatus.OK);

    }

    @PostMapping("/getTableDataFilter")
    private ResponseEntity<?> getTableDataFilter(@RequestBody TableDataFilter tableDataFilter) {
        Map<String, Object> getTableDataFilter = new HashMap<>();
        getTableDataFilter.put("status", HttpStatus.OK);
        getTableDataFilter.put("result", groupDataService.findByTableDataFilter(tableDataFilter));
        getTableDataFilter.put("message", "Table Data Filter List");
        return new ResponseEntity<>(getTableDataFilter, HttpStatus.OK);

    }



}
