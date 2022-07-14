package com.burwasolution.vishwakarma.config.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public interface ApplicationConstant {

    final static String ACCEPT = "Accept";
    final static String APPLICATION_JSON = "application/json";
    final static String CONTENT_TYPE = "Content-Type";
    final static String ROLE_USER = "USER";
    final static String ROLE_SERVEYOR = "SERVEYOR";
    final static long ONE_MINUTE_IN_MILLIS = 60000;
    final static int pageSizeRequest = 20;
    final static String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString().replaceAll("vishwakarna-0.0.1-SNAPSHOT", "");
}
