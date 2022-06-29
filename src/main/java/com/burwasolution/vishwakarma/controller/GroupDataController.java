package com.burwasolution.vishwakarma.controller;

import com.burwasolution.vishwakarma.domains.dto.response.groupData.*;
import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import com.burwasolution.vishwakarma.service_impl.service.groupData.GroupDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/groupData")
public class GroupDataController {

    private final GroupDataService groupDataService;

    @Autowired
    public GroupDataController(GroupDataService groupDataService) {
        this.groupDataService = groupDataService;
    }

    @GetMapping("/getFamilyList")
    private List<FamilyListDTO> getFamilyList(@RequestBody Users users) {

        return groupDataService.findFamilyList(users);
    }

    @GetMapping("/getFamilyDetails")
    private List<IndividualMemberDTO> getFamilyDetails(@RequestBody Users users) {

        return groupDataService.getFamilyMemberDetails(users);
    }

    @GetMapping("/getIndividualMemberDetails")
    private IndividualMemberDTO getIndividualDetails(@RequestBody Users users) {
        return groupDataService.getIndividualDetails(users);
    }

    @GetMapping("/getEmployedTypeList")
    private List<EmployedListDTO> getEmployedList(@RequestBody Users users) {
        return groupDataService.getEmployedList(users);
    }

    @GetMapping("/getSpecificEmployedTypeList")
    private List<EmployedDetailsDTO> getListOfSpecificEmployed(@RequestBody Users users) {
        return groupDataService.getListBySpecificEmployed(users);
    }

    @GetMapping("/getGovtSchemesEnroleldList")
    private List<SchemesEnrolledDTO> getListOfSchemesEnrolled(@RequestBody Users users) {
        return groupDataService.getListOfSchemesEnrolled(users);
    }

    @GetMapping("/getSpecificSchemesList")
    private List<IndividualMemberDTO> getUserDataBySchemeEnrolled(@RequestBody Users users) {
        return groupDataService.getUserDataBySchemeEnrolled(users);
    }

    @GetMapping("/getMulyankaList")
    private List<VmulyankanaResponseDTO> getVmulyankaList(@RequestBody Users users) {
        return groupDataService.getVmulyankaList(users);
    }

}
