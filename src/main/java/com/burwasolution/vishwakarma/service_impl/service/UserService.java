package com.burwasolution.vishwakarma.service_impl.service;

import com.burwasolution.vishwakarma.domains.dto.response.groupData.FamilyListDTO;
import com.burwasolution.vishwakarma.domains.dto.response.groupData.IndividualListDTO;
import com.burwasolution.vishwakarma.domains.dto.users.LoginUser;
import com.burwasolution.vishwakarma.domains.dto.users.ServeyorOtp;
import com.burwasolution.vishwakarma.domains.dto.users.ServeyorSignUpDTO;
import com.burwasolution.vishwakarma.domains.entity.basic.Otp;
import com.burwasolution.vishwakarma.domains.entity.basic.Serveyor;
import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import javassist.NotFoundException;

import java.util.List;

public interface UserService {

    Users login(LoginUser loginUser) throws Exception;
    Users signUp(Users users);
    Users getUserByUsername(String username);
    List<Users> insertBulkUsers(List<Users> users);
    ServeyorSignUpDTO serveyorSignUp(Serveyor serveyor) throws NotFoundException;
    ServeyorOtp sendOtp(Otp otp, boolean status) throws NotFoundException;
    ServeyorSignUpDTO verifyOtp(Otp otp) throws NotFoundException;
    List<FamilyListDTO> unVerifyDetails( String idNo) throws NotFoundException;
    IndividualListDTO getFamilyList(String idNo) throws NotFoundException;
}
