package com.burwasolution.vishwakarma.service_impl.service.basic;

import com.burwasolution.vishwakarma.domains.dto.response.groupData.FamilyListDTO;
import com.burwasolution.vishwakarma.domains.dto.response.groupData.IndividualListDTO;
import com.burwasolution.vishwakarma.domains.dto.users.LoginUser;
import com.burwasolution.vishwakarma.domains.dto.users.OtpDTO;
import com.burwasolution.vishwakarma.domains.dto.users.ServeyorSignUpDTO;
import com.burwasolution.vishwakarma.domains.entity.basic.Otp;
import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import javassist.NotFoundException;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface UserService {
    Users login(LoginUser loginUser) throws Exception;
    Users signUp(Users users);
    Users getUserByUsername(String username);
    List<Users> insertBulkUsers(List<Users> users);
    ServeyorSignUpDTO serveyorSignUp(ServeyorSignUpDTO serveyor) throws NotFoundException, ParseException;
    OtpDTO sendOtp(Otp otp, boolean status) throws NotFoundException, IOException;
    OtpDTO verifyOtp(Otp otp) throws NotFoundException;
    List<FamilyListDTO> unVerifyDetails(String idName, String idNo) throws NotFoundException;
    IndividualListDTO getFamilyList(String idNo) throws NotFoundException, ParseException;
    OtpDTO serveyorSendOtp(Otp otp, boolean status) throws NotFoundException, IOException;
    ServeyorSignUpDTO serveyorVerifyOtp(Otp otp) throws NotFoundException;
}
