package com.burwasolution.vishwakarma.controller;

import com.burwasolution.vishwakarma.domains.dto.users.ValidationCounts;
import com.burwasolution.vishwakarma.domains.dto.users.ValidationUsersDetails;
import com.burwasolution.vishwakarma.service_impl.service.groupData.ServeyorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/validate")
public class ValidationController {

    private final ServeyorService serveyorService;

    @Autowired
    public ValidationController(ServeyorService serveyorService) {
        this.serveyorService = serveyorService;
    }

    @PostMapping("/getValidationCounts")
    private ResponseEntity<?> getValidationStatus(@RequestBody ValidationCounts validationCounts) {
        Map<String, Object> getValidationStatus = new HashMap<>();
        getValidationStatus.put("status", HttpStatus.OK);
        getValidationStatus.put("result", serveyorService.getValidationStatus(validationCounts));
        getValidationStatus.put("message", "Completed Records Counts");
        return new ResponseEntity<>(getValidationStatus, HttpStatus.OK);
    }

    @PostMapping("/getTotalRecordUserDetails")
    private ResponseEntity<?> getCompletedUserDetails(@RequestBody ValidationUsersDetails validationUsersDetails) {
        Map<String, Object> getCompletedUserDetails = new HashMap<>();
        getCompletedUserDetails.put("status", HttpStatus.OK);
        getCompletedUserDetails.put("result", serveyorService.getCompletedUserDetails(validationUsersDetails));
        getCompletedUserDetails.put("message", "Completed Users Details");
        return new ResponseEntity<>(getCompletedUserDetails, HttpStatus.OK);
    }

    @PostMapping("/getSurveyPendingUserDetails")
    private ResponseEntity<?> getVerifyPendingUserDetails(@RequestBody ValidationUsersDetails validationUsersDetails) {
        Map<String, Object> getVerifyPendingUserDetails = new HashMap<>();
        getVerifyPendingUserDetails.put("status", HttpStatus.OK);
        getVerifyPendingUserDetails.put("result", serveyorService.getVerifyPendingUserDetails(validationUsersDetails));
        getVerifyPendingUserDetails.put("message", "Verification Pending Users Details");
        return new ResponseEntity<>(getVerifyPendingUserDetails, HttpStatus.OK);
    }

    @PostMapping("/getApprovalPendingUserDetails")
    private ResponseEntity<?> getApprovalPendingUserDetails(@RequestBody ValidationUsersDetails validationUsersDetails) {
        Map<String, Object> getApprovalPendingUserDetails = new HashMap<>();
        getApprovalPendingUserDetails.put("status", HttpStatus.OK);
        getApprovalPendingUserDetails.put("result", serveyorService.getApprovalPendingUserDetails(validationUsersDetails));
        getApprovalPendingUserDetails.put("message", "Approval Pending Users Details");
        return new ResponseEntity<>(getApprovalPendingUserDetails, HttpStatus.OK);
    }

    @PostMapping("/getApprovalCompletedUserDetails")
    private ResponseEntity<?> getApprovedUserDetails(@RequestBody ValidationUsersDetails validationUsersDetails) {
        Map<String, Object> getApprovedUserDetails = new HashMap<>();
        getApprovedUserDetails.put("status", HttpStatus.OK);
        getApprovedUserDetails.put("result", serveyorService.getApprovedUserDetails(validationUsersDetails));
        getApprovedUserDetails.put("message", "Approved  Users Details");
        return new ResponseEntity<>(getApprovedUserDetails, HttpStatus.OK);
    }

}
