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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/serveyor")
public class ServeyorController {

    private final ServeyorService serveyorService;

    @Autowired
    public ServeyorController(ServeyorService serveyorService) {
        this.serveyorService = serveyorService;
    }


    @PostMapping("/addFamilyMember")
    private ResponseEntity<?> addFamilyMember(@RequestBody IndividualListDTO familyMember, @RequestParam boolean doLink) throws NotFoundException {
        Map<String, Object> addFamilyMember = new HashMap<>();
        addFamilyMember.put("status", HttpStatus.OK);
        addFamilyMember.put("result", serveyorService.addFamilyMember(familyMember,doLink));
        addFamilyMember.put("message", "UnVerified Family List");
        return new ResponseEntity<>(addFamilyMember, HttpStatus.OK);
    }


}
