package com.burwasolution.vishwakarma.service_impl.impl.groupData;

import com.burwasolution.vishwakarma.domains.dto.response.groupData.IndividualListDTO;
import com.burwasolution.vishwakarma.domains.entity.basic.Employed;
import com.burwasolution.vishwakarma.domains.entity.basic.GovtSchemes;
import com.burwasolution.vishwakarma.domains.entity.basic.UnApprovedUsers;
import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import com.burwasolution.vishwakarma.reprository.users.EmployedRepository;
import com.burwasolution.vishwakarma.reprository.users.GovtSchemesRepository;
import com.burwasolution.vishwakarma.reprository.users.UnApprovedUsersRepository;
import com.burwasolution.vishwakarma.reprository.users.UsersRepository;
import com.burwasolution.vishwakarma.service_impl.service.groupData.ServeyorService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ServeyorServiceImpl implements ServeyorService {

    private final UsersRepository usersRepository;
    private final UnApprovedUsersRepository unApprovedUsersRepository;
    private final GovtSchemesRepository govtSchemesRepository;
    private final EmployedRepository employedRepository;


    @Autowired
    public ServeyorServiceImpl(UsersRepository usersRepository, UnApprovedUsersRepository unApprovedUsersRepository
            , GovtSchemesRepository govtSchemesRepository, EmployedRepository employedRepository) {
        this.usersRepository = usersRepository;
        this.unApprovedUsersRepository = unApprovedUsersRepository;
        this.govtSchemesRepository = govtSchemesRepository;
        this.employedRepository = employedRepository;
    }

    @Override
    public UnApprovedUsers addFamilyMember(IndividualListDTO familyMember, boolean doLink) throws NotFoundException {
        Users findUser = new Users();
        UnApprovedUsers getDetails = new UnApprovedUsers();

        if (unApprovedUsersRepository.findByVoterId(familyMember.getVoterId()) == null) {

            if (doLink) {

                findUser = usersRepository.findUserByVoterIdAndFamilyId(familyMember.getVoterId(), familyMember.getFamilyId());

                if (findUser == null && familyMember.getFamilyId() != null) {

                    getDetails = UnApprovedUsers.builder()
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
                            .employed(familyMember.getEmployed().trim())
                            .govtSchemeEnrolled(familyMember.getGovtSchemeEnrolled().trim())
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


            } else if (!doLink) {

                findUser = usersRepository.findUserByVoterId(familyMember.getVoterId());
                String familyId = "mv" + familyMember.getVoterId().substring(familyMember.getVoterId().length() - 4);
                if (findUser == null) {

                    getDetails = UnApprovedUsers.builder()
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
                            .employed(familyMember.getEmployed().trim())
                            .govtSchemeEnrolled(familyMember.getGovtSchemeEnrolled().trim())
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
    public UnApprovedUsers editFamilyMember(IndividualListDTO familyMember, String id) throws NotFoundException {

        if (id.trim() != null) {

            UnApprovedUsers findUser = unApprovedUsersRepository.findById(id).get();

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
                findUser.setEmployed(familyMember.getEmployed().trim());
                findUser.setGovtSchemeEnrolled(familyMember.getGovtSchemeEnrolled().trim());
                findUser.setIncome(familyMember.getIncome());
                findUser.setVmulyankana(familyMember.getVmulyankana());
                findUser.setEpf_nps(familyMember.getEpf_nps());
                findUser.setGramPanchayat(familyMember.getGramPanchayat());
                unApprovedUsersRepository.save(findUser);
                return findUser;
            } else {
                throw new NotFoundException("User Not Found");
            }


        } else {
            throw new NoSuchElementException("Please Check All the Parameters");
        }

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
                    getList.add(secondList);
                }
            }
        }


        String[] list4 = getList.parallelStream().toArray(String[]::new);

        for (String list5 : list4) {

            if (list5.equals("Farmer")) {
                employedId = "f01";
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

        return finalList;
    }




    @Override
    public List<GovtSchemes> getGovtSchemes() {
        List<Users> govtSchemesList = usersRepository.findAllByGovtSchemeEnrolled();
        String schemeCode = null, icon = null;

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> getList = new ArrayList<>();
        List<GovtSchemes> finalList = new ArrayList<>();
        for (Users arr : govtSchemesList) {


            if (!list.contains(arr.getGovtSchemeEnrolled())) {
                list.add(arr.getGovtSchemeEnrolled());
            }

        }
        String[] list2 = list.parallelStream().toArray(String[]::new);
        for (String list3 : list2) {
            String[] removeComma = list3.split(",");

            for (String secondList : removeComma) {
                if (!getList.contains(secondList)) {
                    getList.add(secondList);
                }
            }
        }
        String[] list4 = getList.parallelStream().toArray(String[]::new);

        for (String list5 : list4) {
            if (list5.equals("RationCard")) {
                icon = " http://10.18.11.143:8080/icon/rationcard.jpg";
                schemeCode = "RC01";

            }
            if (list5.equals("PMKisaanYojana")) {
                icon = "http://10.18.11.143:8080/icon/pmkishan.jpg";
                schemeCode = "RMKY01";
            }
            if (list5.equals("PMAwaasYojana")) {
                icon = " http://10.18.11.143:8080/icon/voterCard.png";
                schemeCode = "PMAY01";
            }

            GovtSchemes firstList = GovtSchemes.builder()
                    .name(list5)
                    .schemeCode(schemeCode)
                    .icon(icon)
                    .build();
            if (govtSchemesRepository.findBySchemeCode(schemeCode) != null) {

            } else {
                govtSchemesRepository.save(firstList);
            }
            finalList.add(firstList);
        }


        return finalList;
    }


}
