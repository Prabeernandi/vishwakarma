package com.burwasolution.vishwakarma.controller;

import com.burwasolution.vishwakarma.domains.dto.response.groupData.*;
import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import com.burwasolution.vishwakarma.service_impl.service.groupData.GroupDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/groupData")
public class GroupDataController {

    private final GroupDataService groupDataService;

    @Autowired
    public GroupDataController(GroupDataService groupDataService) {
        this.groupDataService = groupDataService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/getFamilyList")
    private List<FamilyListDTO> getFamilyList(@RequestBody Users users) {

        return groupDataService.findFamilyList(users);
    }

    @PostMapping("/getFamilyDetails")
    private List<IndividualMemberDTO> getFamilyDetails(@RequestBody Users users) {

        return groupDataService.getFamilyMemberDetails(users);
    }

    @PostMapping("/getIndividualMemberDetails")
    private IndividualMemberDTO getIndividualDetails(@RequestBody Users users) {
        return groupDataService.getIndividualDetails(users);
    }

    @PostMapping("/getEmployedTypeList")
    private List<EmployedListDTO> getEmployedList(@RequestBody Users users) {
        return groupDataService.getEmployedList(users);
    }

    @PostMapping("/getSpecificEmployedTypeList")
    private List<EmployedDetailsDTO> getListOfSpecificEmployed(@RequestBody Users users) {
        return groupDataService.getListBySpecificEmployed(users);
    }

    @PostMapping("/getGovtSchemesEnroleldList")
    private List<SchemesEnrolledDTO> getListOfSchemesEnrolled(@RequestBody Users users) {
        return groupDataService.getListOfSchemesEnrolled(users);
    }

    @PostMapping("/getSpecificSchemesList")
    private List<IndividualMemberDTO> getUserDataBySchemeEnrolled(@RequestBody Users users) {
        return groupDataService.getUserDataBySchemeEnrolled(users);
    }

    @PostMapping("/getMulyankaList")
    private List<VmulyankanaResponseDTO> getVmulyankaList(@RequestBody Users users) {
        return groupDataService.getVmulyankaList(users);
    }

}
