package com.burwasolution.vishwakarma.controller;

import com.burwasolution.vishwakarma.domains.dto.response.groupData.IndividualListDTO;
import com.burwasolution.vishwakarma.service_impl.service.groupData.ServeyorService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/serveyor")
public class ServeyorController {

    private final ServeyorService serveyorService;

    @Autowired
    public ServeyorController(ServeyorService serveyorService) {
        this.serveyorService = serveyorService;
    }


    @PostMapping("/addFamilyMember")
    private ResponseEntity<?> addFamilyMember(@RequestBody IndividualListDTO familyMember) throws NotFoundException {
        Map<String, Object> addFamilyMember = new HashMap<>();
        addFamilyMember.put("status", HttpStatus.OK);
        addFamilyMember.put("result", serveyorService.addFamilyMember(familyMember));
        addFamilyMember.put("message", "Family Details Submitted For Approval");
        return new ResponseEntity<>(addFamilyMember, HttpStatus.OK);
    }

    @PostMapping("/editFamilyMember")
    private ResponseEntity<?> editFamilyMember(@RequestBody IndividualListDTO familyMember) throws NotFoundException {
        Map<String, Object> editFamilyMember = new HashMap<>();
        editFamilyMember.put("status", HttpStatus.OK);
        editFamilyMember.put("result", serveyorService.editFamilyMember(familyMember));
        editFamilyMember.put("message", "Family Details SuccessFully Edited");
        return new ResponseEntity<>(editFamilyMember, HttpStatus.OK);
    }

    @GetMapping("/getEmployedType")
    private ResponseEntity<?> getEmployedType() {
        Map<String, Object> getEmployedType = new HashMap<>();
        getEmployedType.put("status", HttpStatus.OK);
        getEmployedType.put("result", serveyorService.getEmployedType());
        getEmployedType.put("message", "Employment Type List");
        return new ResponseEntity<>(getEmployedType, HttpStatus.OK);
    }


    @GetMapping("/getGovtSchemes")
    private ResponseEntity<?> getGovtSchemes() {
        Map<String, Object> getGovtSchemes = new HashMap<>();
        getGovtSchemes.put("status", HttpStatus.OK);
        getGovtSchemes.put("result", serveyorService.getGovtSchemes());
        getGovtSchemes.put("message", "Govt Schemes List");
        return new ResponseEntity<>(getGovtSchemes, HttpStatus.OK);
    }

}
