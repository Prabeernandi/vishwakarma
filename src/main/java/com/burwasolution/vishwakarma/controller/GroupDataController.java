package com.burwasolution.vishwakarma.controller;

import com.burwasolution.vishwakarma.domains.dto.response.groupData.EmployedDetailsDTO;
import com.burwasolution.vishwakarma.domains.dto.response.groupData.EmployedType;
import com.burwasolution.vishwakarma.domains.dto.response.groupData.IndividualMemberDTO;
import com.burwasolution.vishwakarma.domains.dto.response.headerFilter.CardDataFilterDTO;
import com.burwasolution.vishwakarma.domains.entity.basic.Users;
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
@RequestMapping("/groupData")
public class GroupDataController {

    private final GroupDataService groupDataService;

    @Autowired
    public GroupDataController(GroupDataService groupDataService) {
        this.groupDataService = groupDataService;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/getFamilyList")
    private ResponseEntity<?> getFamilyList(@RequestBody CardDataFilterDTO cardDataFilter) {
        Map<String, Object> getFamilyList = new HashMap<>();
        getFamilyList.put("status", HttpStatus.OK);
        getFamilyList.put("result", groupDataService.findFamilyList(cardDataFilter));
        getFamilyList.put("message", "List of Families");
        return new ResponseEntity<>(getFamilyList, HttpStatus.OK);
    }

    @GetMapping("/getFamilyDetails")
    private ResponseEntity<?> getFamilyDetails(@RequestParam String familyId) {
        Map<String, Object> getFamilyDetails = new HashMap<>();
        getFamilyDetails.put("status", HttpStatus.OK);
        getFamilyDetails.put("result", groupDataService.getFamilyMemberDetails(familyId));
        getFamilyDetails.put("message", "Family Members List");
        return new ResponseEntity<>(getFamilyDetails, HttpStatus.OK);

    }

    @PostMapping("/getIndividualMemberDetails")
    private IndividualMemberDTO getIndividualDetails(@RequestBody Users users) {
        return groupDataService.getIndividualDetails(users);
    }

    @PostMapping("/getSpecificEmployedTypeList")
    private List<EmployedDetailsDTO> getListOfSpecificEmployed(@RequestBody Users users) {
        return groupDataService.getListBySpecificEmployed(users);
    }


    @PostMapping("/getEmployedTypeList")
    private ResponseEntity<?> getEmployedTypeList(@RequestBody EmployedType cardDataFilter) throws Exception {
        Map<String, Object> getEmployedTypeList = new HashMap<>();
        getEmployedTypeList.put("status", HttpStatus.OK);
        getEmployedTypeList.put("result", groupDataService.getListOfEmployedTypes(cardDataFilter));
        getEmployedTypeList.put("message", "Employment List");
        return new ResponseEntity<>(getEmployedTypeList, HttpStatus.OK);
    }

    @PostMapping("/getSchemeTypeList")
    private ResponseEntity<?> getSchemeTypeList(@RequestBody EmployedType cardDataFilter) {
        Map<String, Object> getSchemeTypeList = new HashMap<>();
        getSchemeTypeList.put("status", HttpStatus.OK);
        getSchemeTypeList.put("result", groupDataService.getSchemeTypeList(cardDataFilter));
        getSchemeTypeList.put("message", "Employment List");
        return new ResponseEntity<>(getSchemeTypeList, HttpStatus.OK);
    }


}
