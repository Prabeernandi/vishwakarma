package com.burwasolution.vishwakarma.config.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public interface ApplicationConstant {

    String ACCEPT = "Accept";
    String APPLICATION_JSON = "application/json";
    String CONTENT_TYPE = "Content-Type";
    String ROLE_USER = "USER";
    String ROLE_SERVEYOR = "SERVEYOR";
    long ONE_MINUTE_IN_MILLIS = 60000;
    int pageSizeRequest = 20;
    String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString().replaceAll("vishwakarna-0.0.1-SNAPSHOT", "");
    String serverUploadPath = "/opt/apache-tomcat-9.0.50/webapps";
    String localUploadPath = "C:/Prabeer/project/Vishwakarma";
    String verifyPending = "VERIFICATION_PENDING";
    String submittedForApproval = "APPROVAL_PENDING";
    String approvedByAdmins = "APPROVED";
    String profileCompleted = "PROFILE_COMPLETED";
    String profileNotCompleted = "PROFILE_NOT_COMPLETED";
    String removeSpecialChar = "[-+.^:/,]";
}
