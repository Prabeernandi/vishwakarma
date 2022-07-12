package com.burwasolution.vishwakarma.controller;

import com.burwasolution.vishwakarma.domains.dto.users.LoginUser;
import com.burwasolution.vishwakarma.domains.entity.basic.Otp;
import com.burwasolution.vishwakarma.domains.entity.basic.Serveyor;
import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import com.burwasolution.vishwakarma.service_impl.service.basic.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/login")
    private Users login(@RequestBody LoginUser loginUser) throws Exception {
        return userService.login(loginUser);
    }

    @PostMapping("/insertUsers")
    private Users signUp(@RequestBody Users users) {
        return userService.signUp(users);
    }

    @PostMapping("/serveyorSignUp")
    private ResponseEntity<?> serveyorSignUp(@RequestBody Serveyor serveyor) throws NotFoundException {
        Map<String, Object> serveyorSignUp = new HashMap<>();
        serveyorSignUp.put("status", HttpStatus.OK);
        serveyorSignUp.put("result", userService.serveyorSignUp(serveyor));
        serveyorSignUp.put("message", "Surveyor Details Submitted");
        return new ResponseEntity<>(serveyorSignUp, HttpStatus.OK);
    }


    @PostMapping("/sendOtp")
    private ResponseEntity<?> sendOtp(@RequestBody Otp otp, boolean status) throws NotFoundException, IOException {
        Map<String, Object> sendOtp = new HashMap<>();
        sendOtp.put("status", HttpStatus.OK);
        sendOtp.put("result", userService.sendOtp(otp, status));
        sendOtp.put("message", "OTP Sent SuccessFully");
        return new ResponseEntity<>(sendOtp, HttpStatus.OK);
    }

    @PostMapping("/verifyOtp")
    private ResponseEntity<?> verifyOtp(@RequestBody Otp otp) throws NotFoundException {
        Map<String, Object> verifyOtp = new HashMap<>();
        verifyOtp.put("status", HttpStatus.OK);
        verifyOtp.put("result", userService.verifyOtp(otp));
        verifyOtp.put("message", "OTP SuccessFully Verified");
        return new ResponseEntity<>(verifyOtp, HttpStatus.OK);
    }

    @GetMapping("/unVerifiedMemberDetails")
    private ResponseEntity<?> unVerifyDetails(@RequestParam String idNo) throws NotFoundException {
        Map<String, Object> unVerifyDetails = new HashMap<>();
        unVerifyDetails.put("status", HttpStatus.OK);
        unVerifyDetails.put("result", userService.unVerifyDetails(idNo));
        unVerifyDetails.put("message", "UnVerified Family List");
        return new ResponseEntity<>(unVerifyDetails, HttpStatus.OK);
    }

    @GetMapping("/getFamilyMemberDetails")
    private ResponseEntity<?> getFamilyList(@RequestParam String idNo) throws NotFoundException {
        Map<String, Object> getFamilyList = new HashMap<>();
        getFamilyList.put("status", HttpStatus.OK);
        getFamilyList.put("result", userService.getFamilyList(idNo));
        getFamilyList.put("message", "Family Member Details");
        return new ResponseEntity<>(getFamilyList, HttpStatus.OK);
    }

    @PostMapping("/insertBulkUsers")
    private List<Users> insertBulkUsers(@RequestBody List<Users> users) {

        return userService.insertBulkUsers(users);
    }



}
