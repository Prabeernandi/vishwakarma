package com.burwasolution.vishwakarma.service_impl.impl.groupData;

import com.burwasolution.vishwakarma.domains.dto.response.groupData.IndividualListDTO;
import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import com.burwasolution.vishwakarma.reprository.users.UsersRepository;
import com.burwasolution.vishwakarma.service_impl.service.groupData.ServeyorService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServeyorServiceImpl implements ServeyorService {

    private final UsersRepository usersRepository;

    @Autowired
    public ServeyorServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public IndividualListDTO addFamilyMember(IndividualListDTO familyMember, boolean doLink) throws NotFoundException {

        if (doLink) {

            Users findUser = usersRepository.findUserByVoterIdAndFamilyId(familyMember.getVoterId(), familyMember.getFamilyId());

            if (findUser == null && familyMember.getFamilyId() != null) {

                Users getDetails = Users.builder()
                        .address(familyMember.getAddress())
                        .dateOfBirth(familyMember.getDateOfBirth())
                        .voterId(familyMember.getVoterId())
                        .familyId(familyMember.getFamilyId())
                        .aadharNo(familyMember.getAadharNo())
                        .panCardNo(familyMember.getPanCardNo())
                        .mobileNumber(familyMember.getMobileNumber())
                        .employed(familyMember.getEmployed())
                        .income(familyMember.getIncome())
                        .vmulyankana(familyMember.getVmulyankana())
                        .epf_nps(familyMember.getEpf_nps())
                        .gramPanchayat(familyMember.getGramPanchayat())
                        .build();
                usersRepository.save(getDetails);

                IndividualListDTO showDetails = IndividualListDTO.builder()
                        .address(getDetails.getAddress())
                        .dateOfBirth(getDetails.getDateOfBirth())
                        .voterId(getDetails.getVoterId())
                        .aadharNo(getDetails.getAadharNo())
                        .panCardNo(getDetails.getPanCardNo())
                        .mobileNumber(getDetails.getMobileNumber())
                        .employed(getDetails.getEmployed())
                        .familyId(getDetails.getFamilyId())
                        .income(getDetails.getIncome())
                        .vmulyankana(getDetails.getVmulyankana())
                        .epf_nps(getDetails.getEpf_nps())
                        .gramPanchayat(getDetails.getGramPanchayat())
                        .build();

                return showDetails;

            } else {
                throw new NotFoundException("The User is Already Registered");
            }


        } else if (!doLink) {

        } else {
            throw new NullPointerException();
        }

        return null;
    }
}
