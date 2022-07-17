package com.burwasolution.vishwakarma.service_impl.impl.groupData;

import com.burwasolution.vishwakarma.config.utils.ApplicationConstant;
import com.burwasolution.vishwakarma.domains.dto.response.groupData.FamilyListDTO;
import com.burwasolution.vishwakarma.domains.dto.response.groupData.IndividualListDTO;
import com.burwasolution.vishwakarma.domains.dto.users.ImageUploadDTO;
import com.burwasolution.vishwakarma.domains.entity.basic.Employed;
import com.burwasolution.vishwakarma.domains.entity.basic.FamilyMembersDetails;
import com.burwasolution.vishwakarma.domains.entity.basic.GovtSchemes;
import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import com.burwasolution.vishwakarma.reprository.users.EmployedRepository;
import com.burwasolution.vishwakarma.reprository.users.GovtSchemesRepository;
import com.burwasolution.vishwakarma.reprository.users.UnApprovedUsersRepository;
import com.burwasolution.vishwakarma.reprository.users.UsersRepository;
import com.burwasolution.vishwakarma.service_impl.service.basic.FileManagementService;
import com.burwasolution.vishwakarma.service_impl.service.groupData.ServeyorService;
import com.fasterxml.jackson.annotation.JsonInclude;
import javassist.NotFoundException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@Data
public class ServeyorServiceImpl implements ServeyorService, ApplicationConstant {


    private final UsersRepository usersRepository;
    private final UnApprovedUsersRepository unApprovedUsersRepository;
    private final GovtSchemesRepository govtSchemesRepository;
    private final EmployedRepository employedRepository;
    private final ModelMapper modelMapper;
    private final FileManagementService fileManagementService;
    String icon = null, employedName = null, schemeName = null;


    @Autowired
    public ServeyorServiceImpl(UsersRepository usersRepository, UnApprovedUsersRepository unApprovedUsersRepository
            , GovtSchemesRepository govtSchemesRepository, EmployedRepository employedRepository,
                               ModelMapper modelMapper, FileManagementService fileManagementService) {
        this.usersRepository = usersRepository;
        this.unApprovedUsersRepository = unApprovedUsersRepository;
        this.govtSchemesRepository = govtSchemesRepository;
        this.employedRepository = employedRepository;
        this.modelMapper = modelMapper;
        this.fileManagementService = fileManagementService;
    }

    public String employed(String employedCode) {

        employedName = null;
        if (employedCode.contains("fr01")) {
            employedName = "Farmer";
            employedName = StringUtils.join(employedName, ",");
        }
        if (employedCode.contains("dw01")) {
            employedName += "Daily Worker";
            employedName = StringUtils.join(employedName, ",");
        }
        if (employedCode.contains("ar01")) {
            employedName += "Artisan";

        }
        if (employedName.endsWith(",")) {
            employedName = employedName.substring(0, employedName.length() - 1);
        }
        employedName = employedName.replaceAll("null", "");
        return employedName;
    }

    public String govtScheme(String scheme) {

        schemeName = null;
        if (scheme.contains("RC01")) {
            schemeName = "RationCard";
            schemeName = StringUtils.join(schemeName, ",");
        }
        if (scheme.contains("RMKY01")) {
            schemeName += "PMKisaanYojana";
            schemeName = StringUtils.join(schemeName, ",");
        }
        if (scheme.contains("PMAY01")) {
            schemeName += "PMAwaasYojana";
            schemeName = StringUtils.join(schemeName, ",");
        }
        if (schemeName.endsWith(",")) {
            schemeName = schemeName.substring(0, schemeName.length() - 1);
        }
        schemeName = schemeName.replaceAll("null", "");
        return schemeName;
    }


    @Override
    public FamilyMembersDetails addFamilyMember(IndividualListDTO familyMember) throws NotFoundException {
        Users findUser = new Users();
        FamilyMembersDetails getDetails = new FamilyMembersDetails();
        employed(familyMember.getEmployed());
        govtScheme(familyMember.getGovtSchemeEnrolled());

        if (unApprovedUsersRepository.findByVoterId(familyMember.getVoterId()) == null) {

            if (familyMember.getDoLink().trim().equals("true")) {

                findUser = usersRepository.findUserByVoterIdAndFamilyId(familyMember.getVoterId(), familyMember.getFamilyId());

                if (findUser == null && familyMember.getFamilyId() != null) {

                    getDetails = FamilyMembersDetails.builder()
                            .address(familyMember.getAddress())
                            .dateOfBirth(familyMember.getDateOfBirth())
                            .voterId(familyMember.getVoterId())
                            .familyId(familyMember.getFamilyId())
                            .fullName(familyMember.getFullName())
                            .aadharNo(familyMember.getAadharNo())
                            .panCardNo(familyMember.getPanCardNo())
                            .rationCardNumber(familyMember.getRationCardNumber())
                            .manrekaRegNo(familyMember.getManrekaRegNo())
                            .bhulekhId(familyMember.getBhulekhId())
                            .mobileNumber(familyMember.getMobileNumber())
                            .employedCode(familyMember.getEmployed().trim())
                            .employed(null)
                            .employed(employedName.replaceAll("null", ""))
                            .schemeCode(familyMember.getGovtSchemeEnrolled().trim())
                            .govtSchemeEnrolled(null)
                            .govtSchemeEnrolled(schemeName.replaceAll("null", ""))
                            .income(familyMember.getIncome())
                            .vmulyankana(familyMember.getVmulyankana())
                            .epf_nps(familyMember.getEpf_nps())
                            .gramPanchayat(familyMember.getGramPanchayat())
                            .build();
                    unApprovedUsersRepository.save(getDetails);
                    return getDetails;

                } else {
                    throw new NotFoundException("The User is Already Registered");
                }


            } else if (!familyMember.getDoLink().trim().equals("true")) {

                findUser = usersRepository.findUserByVoterId(familyMember.getVoterId());
                String familyId = "mv" + familyMember.getVoterId().substring(familyMember.getVoterId().length() - 4);
                if (findUser == null) {

                    getDetails = FamilyMembersDetails.builder()
                            .address(familyMember.getAddress())
                            .dateOfBirth(familyMember.getDateOfBirth())
                            .voterId(familyMember.getVoterId())
                            .familyId(familyId)
                            .fullName(familyMember.getFullName())
                            .aadharNo(familyMember.getAadharNo())
                            .panCardNo(familyMember.getPanCardNo())
                            .rationCardNumber(familyMember.getRationCardNumber())
                            .manrekaRegNo(familyMember.getManrekaRegNo())
                            .bhulekhId(familyMember.getBhulekhId())
                            .mobileNumber(familyMember.getMobileNumber())
                            .employed(null)
                            .employed(employedName.replaceAll("null", ""))
                            .schemeCode(familyMember.getGovtSchemeEnrolled().trim())
                            .govtSchemeEnrolled(null)
                            .govtSchemeEnrolled(schemeName.replaceAll("null", ""))
                            .income(familyMember.getIncome())
                            .vmulyankana(familyMember.getVmulyankana())
                            .epf_nps(familyMember.getEpf_nps())
                            .gramPanchayat(familyMember.getGramPanchayat())
                            .build();
                    unApprovedUsersRepository.save(getDetails);

                    return getDetails;


                } else {
                    throw new NotFoundException("The User is Already Registered");
                }


            } else {
                throw new NullPointerException();
            }
        } else {

            throw new NotFoundException("The VoterId " + familyMember.getVoterId() + "is Already Submitted For Approval ");

        }
    }


    @Override
    public IndividualListDTO editFamilyMember(IndividualListDTO familyMember) throws NotFoundException {

        if (familyMember.getVoterId().trim() != null) {

            Users findUser = usersRepository.findUserByVoterId(familyMember.getVoterId());
            employedName = schemeName = "";
            if (familyMember.getEmployed() != null && !familyMember.getEmployed().isEmpty()) {
                employed(familyMember.getEmployed());
            }
            if (familyMember.getGovtSchemeEnrolled() != null && !familyMember.getGovtSchemeEnrolled().isEmpty()) {
                govtScheme(familyMember.getGovtSchemeEnrolled());

            }


            if (findUser != null) {
                findUser.setAddress(familyMember.getAddress());
                findUser.setDateOfBirth(familyMember.getDateOfBirth());
                findUser.setVoterId(familyMember.getVoterId());
                findUser.setFullName(familyMember.getFullName());
                findUser.setAadharNo(familyMember.getAadharNo());
                findUser.setPanCardNo(familyMember.getPanCardNo());
                findUser.setRationCardNumber(familyMember.getRationCardNumber());
                findUser.setManrekaRegNo(familyMember.getManrekaRegNo());
                findUser.setBhulekhId(familyMember.getBhulekhId());
                findUser.setMobileNumber(familyMember.getMobileNumber());
                findUser.setEmployedCode(null);
                findUser.setEmployedCode(familyMember.getEmployed());
                findUser.setEmployed(employedName);
                findUser.setApproved(false);
                findUser.setSchemeCode(null);
                findUser.setSchemeCode(familyMember.getGovtSchemeEnrolled().trim());
                findUser.setGovtSchemeEnrolled(null);
                findUser.setGovtSchemeEnrolled(schemeName);
                findUser.setIncome(familyMember.getIncome());
                findUser.setVmulyankana(familyMember.getVmulyankana());
                findUser.setEpf_nps(familyMember.getEpf_nps());
                findUser.setGramPanchayat(familyMember.getGramPanchayat());
                findUser.setVerificationStatus(submittedForApproval.trim());
                usersRepository.save(findUser);
                IndividualListDTO mapper = modelMapper.map(findUser, IndividualListDTO.class);

                return mapper;
            } else {
                throw new NotFoundException("User Not Found");
            }

        } else {
            throw new NoSuchElementException("Please Check All the Parameters");
        }

    }

    @Override
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public List<FamilyListDTO> getUnVerifiedMemberList(int PageNo) {
        if (PageNo == 0) {
            PageNo = PageNo;
        } else {
            PageNo = PageNo - 1;
        }
        Page<Users> usersPage = usersRepository.findAllByProfileStatus(PageRequest.of(PageNo, pageSizeRequest));
        List<FamilyListDTO> list = new ArrayList<>();
        FamilyListDTO usersList = new FamilyListDTO();
        for (Users usersData : usersPage) {
            usersList = FamilyListDTO.builder()
                    .name(usersData.getFullName())
                    .address(usersData.getAddress())
                    .idNo(usersData.getVoterId())
                    .familyId(usersData.getFamilyId())
                    .build();
            list.add(usersList);
        }
        return list;
    }

    @Override
    public ImageUploadDTO serveyorUploadImage(String idName, String idNo, MultipartFile file) throws IOException {
        ImageUploadDTO uploadDTO = fileManagementService.uploadFile(idName, idNo, file);
        log.info("File " + uploadDTO.getFileName() + " Saved SuccessFully!!!");


        return uploadDTO;
    }


    @Override
    public List<Employed> getEmployedType() {

        List<Users> employedList = usersRepository.findAllByEmployed();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> getList = new ArrayList<>();
        List<Employed> finalList = new ArrayList<>();
        String employedId = null;
        for (Users arr : employedList) {


            if (!list.contains(arr.getEmployed())) {
                list.add(arr.getEmployed());
            }

        }
        String[] list2 = list.parallelStream().toArray(String[]::new);

        for (String list3 : list2) {
            String[] removeComma = list3.split(",");

            for (String secondList : removeComma) {
                if (!getList.contains(secondList)) {
                    getList.add(secondList.trim());
                    getList.removeAll(Collections.singleton(""));
                }
            }
        }


        String[] list4 = getList.parallelStream().toArray(String[]::new);

        for (String list5 : list4) {

            if (list5.equals("Farmer")) {
                employedId = "fr01";
            }
            if (list5.equals("Daily Worker")) {
                employedId = "dw01";
            }
            if (list5.equals("Artisan")) {
                employedId = "ar01";
            }
            Employed firstList = Employed.builder()
                    .name(list5)
                    .employedCode(employedId)
                    .build();
            if (employedRepository.findByEmployedCode(employedId) != null) {

            } else {
                employedRepository.save(firstList);
            }
            finalList.add(firstList);
        }
        finalList = employedRepository.findAll();

        return finalList;
    }


    @Override
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GovtSchemes> getGovtSchemes() {
        List<Users> govtSchemesList = usersRepository.findAllByGovtSchemeEnrolled();
        String schemeCode = null;
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> getList = new ArrayList<>();
        List<GovtSchemes> finalList = new ArrayList<>();
        for (Users arr : govtSchemesList) {


            if (!list.contains(arr.getGovtSchemeEnrolled())) {
                list.add(arr.getGovtSchemeEnrolled());
                getList.removeAll(Collections.singleton(""));
            }

        }
        String[] list2 = list.parallelStream().toArray(String[]::new);
        for (String list3 : list2) {
            String[] removeComma = list3.split(",");

            for (String secondList : removeComma) {
                if (!getList.contains(secondList)) {
                    getList.add(secondList.trim());

                }
            }
        }
        String[] list4 = getList.parallelStream().toArray(String[]::new);

        for (String list5 : list4) {
            if (list5.equals("RationCard")) {
                icon = baseUrl + "/icon/ic_ration_card.png";
                schemeCode = "RC01";
            }
            if (list5.equals("PMKisaanYojana")) {
                icon = baseUrl + "/icon/ic_pm_kisan.png";
                schemeCode = "RMKY01";
            }
            if (list5.equals("PMAwaasYojana")) {
                icon = baseUrl + "/icon/ic_pm_yojana.png";
                schemeCode = "PMAY01";
            }

            GovtSchemes firstList = GovtSchemes.builder()
                    .name(list5)
                    .schemeCode(schemeCode)
                    .icon(icon.trim())
                    .build();
            if (govtSchemesRepository.findBySchemeCode(schemeCode) != null) {

            } else {
                govtSchemesRepository.save(firstList);
            }
            finalList.add(firstList);
        }

        finalList = govtSchemesRepository.findAll();
        return finalList;
    }


}
