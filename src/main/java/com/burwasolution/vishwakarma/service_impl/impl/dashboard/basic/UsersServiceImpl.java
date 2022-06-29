package com.burwasolution.vishwakarma.service_impl.impl.dashboard.basic;

import com.burwasolution.vishwakarma.config.JwtUtils;
import com.burwasolution.vishwakarma.controller.exceptionHandler.CustomException;
import com.burwasolution.vishwakarma.controller.exceptionHandler.ResourceAlreadyExists;
import com.burwasolution.vishwakarma.domains.dto.response.groupData.FamilyListDTO;
import com.burwasolution.vishwakarma.domains.dto.users.LoginUser;
import com.burwasolution.vishwakarma.domains.dto.users.ServeyorOtp;
import com.burwasolution.vishwakarma.domains.dto.users.ServeyorSignUpDTO;
import com.burwasolution.vishwakarma.domains.entity.basic.Otp;
import com.burwasolution.vishwakarma.domains.entity.basic.Serveyor;
import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import com.burwasolution.vishwakarma.reprository.users.OtpRepository;
import com.burwasolution.vishwakarma.reprository.users.ServeyorRepository;
import com.burwasolution.vishwakarma.reprository.users.UsersRepository;
import com.burwasolution.vishwakarma.service_impl.service.CountAllService;
import com.burwasolution.vishwakarma.service_impl.service.RoleService;
import com.burwasolution.vishwakarma.service_impl.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class UsersServiceImpl implements UserService, UserDetailsService {

    private final UsersRepository usersRepository;
    private final JwtUtils jwtUtils;
    private final RoleService roleService;
    private final MongoTemplate mongoTemplate;
    private final CountAllService countAllService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private final ServeyorRepository serveyorRepository;
    private final OtpRepository otpRepository;


    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, AuthenticationManager authenticationManager, JwtUtils jwtUtils
            , RoleService roleService, CountAllService countAllService, BCryptPasswordEncoder bCryptPasswordEncoder
            , MongoTemplate mongoTemplate, ServeyorRepository serveyorRepository, OtpRepository otpRepository) {
        this.usersRepository = usersRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.roleService = roleService;
        this.countAllService = countAllService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.mongoTemplate = mongoTemplate;
        this.serveyorRepository = serveyorRepository;
        this.otpRepository = otpRepository;

    }


    @Override
    public Users login(LoginUser loginUser) throws AuthenticationException {
        if (loginUser.getUsername().equals(null) || loginUser.getPassword().equals(null)) {
            throw new CustomException("Credentials are not valid");

        }
        Users users = usersRepository.getUserByUsername(loginUser.getUsername());
        log.info("" + users);
        if (users == null) {
            throw new NoSuchElementException(loginUser.getUsername());
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(loginUser.getPassword(), users.getPassword())) {
            log.error("encoder===ifff===", encoder);
            throw new CustomException("Invalid Credentials. Please Try Again");
        }


        final String token = jwtUtils.generateTokenUsername(loginUser.getUsername());
        users.setAuthToken(token);
        usersRepository.save(users);
        log.error("expiry date " + jwtUtils.getExpirationDateFromToken(token));
        return users;
    }

    @Override
    public Users signUp(Users users) {


        Users usersData = usersRepository.findUserByUsername(users.getUsername());
        if (usersData != null) {
            throw new ResourceAlreadyExists(usersData.getUsername());
        } else {

            String newPassword = bCryptPasswordEncoder.encode(users.getPassword());

            users = Users.builder()
                    .username(users.getUsername())
                    .gender(users.getGender())
                    .stateName(users.getStateName())
                    .firstName(users.getFirstName())
                    .lastName(users.getLastName())
                    .password(newPassword)
                    .mobileNumber(users.getMobileNumber())
                    .familyId(users.getFamilyId())
                    .numberOfFamilyCounts(users.getNumberOfFamilyCounts())
                    .employed(users.getEmployed())
                    .income(users.getIncome())
                    .voterId(users.getVoterId())
                    .aadharNo(users.getAadharNo())
                    .panCardNo(users.getPanCardNo())
                    .epf_nps(users.getEpf_nps())
                    .stateName(users.getStateName())
                    .districtName(users.getDistrictName())
                    .tehsilName(users.getTehsilName())
                    .villageName(users.getVillageName())
                    .houseNumber(users.getHouseNumber())
                    .gramPanchayat(users.getGramPanchayat())
                    .vmulyankana(users.getVmulyankana())
                    .familyHead(users.getFamilyHead())
                    .relationWithHof(users.getRelationWithHof())
                    .isManrekaEnabled(users.isManrekaEnabled())
                    .stateCode(users.getStateCode())
                    .districtCode(users.getDistrictCode())
                    .tehsilCode(users.getTehsilCode())
                    .blockCode(users.getBlockCode())
                    .villageCode(users.getVillageCode())
                    .age(users.getAge())
                    .isManrekaEnabled(users.isManrekaEnabled())
                    .isPMKisaanEnabled(users.isPMKisaanEnabled())
                    .hasPradhanMantriAwaasYojna(users.isHasPradhanMantriAwaasYojna())
                    .authToken("-")
                    .build();

        }


        return usersRepository.save(users);

    }

    @Override
    public Users getUserByUsername(String username) {
        return usersRepository.findUserByUsername(username);
    }

    @Override
    public List<Users> insertBulkUsers(List<Users> users) {


        for (Users userlist : users) {
            String newPassword = bCryptPasswordEncoder.encode(userlist.getPassword());
            Users usersData = usersRepository.findUserByUsername(userlist.getUsername());
            String ageBar = null;
            if (userlist.getAge() < 18) {
                ageBar = "less than 18";
            } else if (userlist.getAge() >= 18 && userlist.getAge() <= 40) {
                ageBar = "18-40";
            } else if (userlist.getAge() >= 41 && userlist.getAge() <= 60) {
                ageBar = "41-60";
            } else if (userlist.getAge() > 60) {
                ageBar = "greater than 60";
            }
            if (usersData == null) {

                Users saveUser = Users.builder()
                        .username(userlist.getUsername())
                        .fullName(userlist.getFullName())
                        .fatherSpouseName(userlist.getFatherSpouseName())
                        .password(newPassword)
                        .ageBar(ageBar)
                        .stateName(userlist.getStateName())
                        .districtName(userlist.getDistrictName())
                        .villageName(userlist.getVillageName())
                        .isManrekaEnabled(userlist.isManrekaEnabled())
                        .familyHead(userlist.getFamilyHead())
                        .relationWithHof(userlist.getRelationWithHof())
                        .familyId(userlist.getFamilyId())
                        .houseNumber(userlist.getHouseNumber())
                        .dateOfBirth(userlist.getDateOfBirth())
                        .mobileNumber(userlist.getMobileNumber())
                        .stateCode(userlist.getStateCode())
                        .districtCode(userlist.getDistrictCode())
                        .tehsilCode(userlist.getTehsilCode())
                        .blockCode(userlist.getBlockCode())
                        .aadharNo(userlist.getAadharNo())
                        .rationCardNumber(userlist.getRationCardNumber())
                        .bhulekhId(userlist.getBhulekhId())
                        .villageCode(userlist.getVillageCode())
                        .caste(userlist.getCaste())
                        .age(userlist.getAge())
                        .gender(userlist.getGender())
                        .employed(userlist.getEmployed())
                        .voterId(userlist.getVoterId())
                        .build();
                usersRepository.save(saveUser);
            } else if (usersData != null) {


                usersData.setUsername(userlist.getUsername());
                usersData.setFullName(userlist.getFullName());
                usersData.setFatherSpouseName(userlist.getFatherSpouseName());
                usersData.setPassword(newPassword);
                usersData.setAgeBar(ageBar);
                usersData.setStateName(userlist.getStateName());
                usersData.setDistrictName(userlist.getDistrictName());
                usersData.setVillageName(userlist.getVillageName());
                usersData.setManrekaEnabled(userlist.isManrekaEnabled());
                usersData.setManrekaRegNo(userlist.getManrekaRegNo());
                usersData.setPMKisaanEnabled(false);
                usersData.setFamilyHead(userlist.getFamilyHead());
                usersData.setRelationWithHof(userlist.getRelationWithHof());
                usersData.setFamilyId(userlist.getFamilyId());
                usersData.setHouseNumber(userlist.getHouseNumber());
                usersData.setDateOfBirth(userlist.getDateOfBirth());
                usersData.setMobileNumber(userlist.getMobileNumber());
                usersData.setStateCode(userlist.getStateCode());
                usersData.setDistrictCode(userlist.getDistrictCode());
                usersData.setTehsilCode(userlist.getTehsilCode());
                usersData.setBlockCode(userlist.getBlockCode());
                usersData.setAadharNo(userlist.getAadharNo());
                usersData.setRationCardNumber(userlist.getRationCardNumber());
                usersData.setBhulekhId(userlist.getBhulekhId());
                usersData.setVillageCode(userlist.getVillageCode());
                usersData.setCaste(userlist.getCaste());
                usersData.setAge(userlist.getAge());
                usersData.setGender(userlist.getGender());
                usersData.setEmployed(userlist.getEmployed());
                usersData.setVoterId(userlist.getVoterId());

                usersRepository.save(usersData);

                log.info("Updated User : " + usersData.getUsername());

//                throw new ResourceAlreadyExists(userlist.getUsername());
            }
        }

        return users;
    }

    @Override
    public ServeyorSignUpDTO serveyorSignUp(Serveyor serveyor) {

        Serveyor serveyorCheck = serveyorRepository.findByUsername(serveyor.getUsername());
        if (serveyorCheck != null) {
            throw new ResourceAlreadyExists(serveyor.getUsername());
        } else {

            ServeyorSignUpDTO signUpDTO = ServeyorSignUpDTO.builder()
                    .username(serveyor.getUsername())
                    .gender("" + serveyor.getGender())
                    .designation(serveyor.getDesignation())
                    .dateOfBirth(serveyor.getDateOfBirth())
                    .emailId(serveyor.getEmailId())
                    .govtDepart(serveyor.getGovtDepart())
                    .govtId(serveyor.getGovtId())
                    .mobileNumber(serveyor.getMobileNumber())
                    .build();

            serveyorRepository.save(serveyor);
            return signUpDTO;
        }


    }

    public boolean verifyMobileNumber(long mobileNumber, boolean status) {
        if (String.valueOf(mobileNumber).length() != 10) {
            throw new CustomException("Please Enter Valid Mobile Number");
        } else {
            status = true;
            return status;
        }
    }


    public boolean verifyServeyor(long mobileNumber, boolean status) {

        Serveyor serveyor = serveyorRepository.findByMobileNumber(mobileNumber);

        if (serveyor == null || !serveyor.isVerified()) {
            throw new NoSuchElementException();
        } else if (!serveyor.isActive() || serveyor.isDeleted()) {
            throw new CustomException("Serveyor is InActive or Deleted, Please Support Team");
        } else {
            status = true;
        }
        return status;
    }

    @Override
    public ServeyorOtp sendOtp(Otp otp, boolean status) {
        status = false;
        ServeyorOtp serveyorOtp = new ServeyorOtp();
        Random random = new Random();
        if (verifyMobileNumber(otp.getMobileNumber(), status) && verifyServeyor(otp.getMobileNumber(), status)) {
            final long ONE_MINUTE_IN_MILLIS = 60000;

            Calendar date = Calendar.getInstance();
            long t = date.getTimeInMillis();
            Date afterAddingTenMins = new Date(t + (5 * ONE_MINUTE_IN_MILLIS));

            String generateOtp = String.format("%06d", random.nextInt(999999));


            otp = Otp.builder()
                    .otp(generateOtp)
                    .mobileNumber(otp.getMobileNumber())
                    .expiryTime(afterAddingTenMins)
                    .build();
            otpRepository.save(otp);
            serveyorOtp = ServeyorOtp.builder()
                    .otp(generateOtp)
                    .mobileNumber(otp.getMobileNumber())
                    .expiryTime(afterAddingTenMins)
                    .build();


        }
        return serveyorOtp;

    }

    @Override
    public ServeyorOtp verifyOtp(Otp otp) {

        final long ONE_MINUTE_IN_MILLIS = 60000;
        Calendar date = Calendar.getInstance();
        long t = date.getTimeInMillis();
        Date afterAddingTenMins = new Date(t + (5 * ONE_MINUTE_IN_MILLIS));

        List<Otp> otpCheck = otpRepository.findByMobileNumber(otp.getMobileNumber());
        ServeyorOtp serveyorOtp = new ServeyorOtp();
        for (Otp otpValidate : otpCheck) {
            if (otpCheck == null) {

                throw new MissingFormatArgumentException("Required Request Body is Missing");

            } else if (afterAddingTenMins.after(otpValidate.getExpiryTime())) {
                throw new NoSuchElementException("Otp Expired, Please Try Again");
            } else if (otpValidate.getOtp().equals(otp.getOtp())) {
                otp = Otp.builder()
                        .message("Mobile Number Verified SuccessFully")
                        .build();

                serveyorOtp = ServeyorOtp.builder()
                        .message("Mobile Number Verified SuccessFully")
                        .build();

                otpRepository.save(otp);
            }


        }

        return serveyorOtp;
    }

    @Override
    public List<FamilyListDTO> unVerifyDetails(String id, String idNo) {
        List<FamilyListDTO> familyListDTOS = new ArrayList<>();
        List<Users> usersList = new ArrayList<>();
        FamilyListDTO voterIdList = new FamilyListDTO();
        if (id.equals("voterId")) {

            usersList = usersRepository.findByVoterId(idNo);


            if (usersList != null) {
                for (Users checkByVoterId : usersList) {

                    List<Users> usersFamilyIdList = usersRepository.findAllByFamilyId(checkByVoterId.getFamilyId());

                    for (Users familyList : usersFamilyIdList) {

                        voterIdList = FamilyListDTO.builder()
                                .name(familyList.getFullName())
                                .aadharNo(familyList.getVoterId())
                                .familyId(checkByVoterId.getFamilyId())
                                .build();

                    }
                    familyListDTOS.add(voterIdList);
                }

                return familyListDTOS;
            } else {
                throw new NoSuchElementException();
            }


        } else if (id.equals("bhulekh")) {
            usersList = usersRepository.findByBhulekhId(idNo);

            if (usersList != null) {

                for (Users checkByBhulekhId : usersList) {
                    List<Users> usersFamilyIdList = usersRepository.findAllByFamilyId(checkByBhulekhId.getFamilyId());

                    for (Users familyList : usersFamilyIdList) {

                        voterIdList = FamilyListDTO.builder()
                                .name(familyList.getFullName())
                                .aadharNo(familyList.getVoterId())
                                .familyId(familyList.getFamilyId())
                                .build();

                    }
                    familyListDTOS.add(voterIdList);
                }
                return familyListDTOS;
            } else {
                throw new NoSuchElementException();
            }
        } else if (id.equals("manreka")) {
            usersList = usersRepository.findByManrekaRegNo(idNo);

            if (usersList != null) {
                for (Users checkByManrekaId : usersList) {
                    List<Users> usersFamilyIdList = usersRepository.findAllByFamilyId(checkByManrekaId.getFamilyId());
                    for (Users familyList : usersFamilyIdList) {

                        voterIdList = FamilyListDTO.builder()
                                .name(familyList.getFullName())
                                .aadharNo(familyList.getVoterId())
                                .familyId(familyList.getFamilyId())
                                .build();

                    }
                    familyListDTOS.add(voterIdList);
                }
                return familyListDTOS;
            } else {
                throw new NoSuchElementException();
            }
        } else if (id.equals("rationId")) {
            usersList = usersRepository.findByRationCardNumber(idNo);

            if (usersList != null) {
                for (Users checkByRationId : usersList) {
                    List<Users> usersFamilyIdList = usersRepository.findAllByFamilyId(checkByRationId.getFamilyId());
                    for (Users familyList : usersFamilyIdList) {
                        voterIdList = FamilyListDTO.builder()
                                .name(familyList.getFullName())
                                .aadharNo(familyList.getVoterId())
                                .familyId(familyList.getFamilyId())
                                .build();


                    }
                    familyListDTOS.add(voterIdList);
                }
                return familyListDTOS;
            } else {
                throw new NoSuchElementException();
            }

        }

        return null;

    }

    @Override
    public Users getFamilyList(String voterId) {

        Users usersFamilyList = usersRepository.findUserByUsername(voterId);


        Users getUsersList = Users.builder()
                .familyId(usersFamilyList.getFamilyId())
                .fullName(usersFamilyList.getFullName())
                .address(usersFamilyList.getAddress())
                .dateOfBirth(usersFamilyList.getDateOfBirth())
                .voterId(usersFamilyList.getVoterId())
                .aadharNo(usersFamilyList.getAadharNo())
                .panCardNo(usersFamilyList.getPanCardNo())
                .mobileNumber(usersFamilyList.getMobileNumber())
                .employed(usersFamilyList.getEmployed())
                .income(usersFamilyList.getIncome())
                .vmulyankana(usersFamilyList.getVmulyankana())
                .isManrekaEnabled(usersFamilyList.isManrekaEnabled())
                .isPMKisaanEnabled(usersFamilyList.isPMKisaanEnabled())
                .epf_nps(usersFamilyList.getEpf_nps())
                .mobileNumber(usersFamilyList.getMobileNumber())
                .gramPanchayat(usersFamilyList.getGramPanchayat())
                .build();


        return getUsersList;

    }

    private Set<SimpleGrantedAuthority> getAuthority(Users user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            // authorities.add(new SimpleGrantedAuthority(role.getName()));
            System.out.println("ROLE_" + role.getRoleName());
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
            // authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });
        return authorities;
        // return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Query query = new Query();
        query = query.addCriteria(Criteria.where("username").is(username));
        Users user = mongoTemplate.findOne(query, Users.class);
//        if (user == null) {
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }

        return new User(user.getUsername(), user.getPassword(), getAuthority(user));
    }


}
