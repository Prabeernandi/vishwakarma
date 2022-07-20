package com.burwasolution.vishwakarma.service_impl.impl.dashboard.basic;

import com.burwasolution.vishwakarma.domains.entity.basic.Approver;
import com.burwasolution.vishwakarma.reprository.users.ApproverRespository;
import com.burwasolution.vishwakarma.service_impl.service.basic.ApproverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApproverServiceImpl implements ApproverService {

    private ApproverRespository approverRespository;

    @Autowired
    public ApproverServiceImpl(ApproverRespository approverRespository) {
        this.approverRespository = approverRespository;
    }

    @Override
    public Approver login(Approver approver) {
        return null;
    }
}
