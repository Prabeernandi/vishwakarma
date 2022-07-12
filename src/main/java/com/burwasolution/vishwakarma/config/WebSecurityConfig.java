package com.burwasolution.vishwakarma.config;

import com.burwasolution.vishwakarma.config.utils.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder((encoder()));
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

    @Bean
    public JwtFilter authenticationTokenFilterBean() throws Exception {
        return new JwtFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/admin/login", "/admin/insertUsers", "/admin/serveyorSignUp").permitAll()
                .antMatchers("/admin/sendOtp", "/admin/verifyOtp").permitAll()
                .antMatchers("/admin/unVerifiedMemberDetails", "/admin/getFamilyMemberDetails").permitAll()
                .antMatchers("/dashboard/saveHeaderFilter", "/dashboard/getHeaderAgeFilter").permitAll()
                .antMatchers("/dashboard/getHeaderGenderFilter", "/dashboard/saveBlockData").permitAll()
                .antMatchers("/dashboard/getStateList", "/dashboard/getDistrictList", "/dashboard/getTehsilList",
                        "/dashboard/getBlockList", "/dashboard/getVillageList", "/dashboard/getCategoryList").permitAll()
                .antMatchers("/dashboard/getHeaderEmployedFilter", "/dashboard/getHeaderGovtSchemesFilter").permitAll()
                .antMatchers("/dashboard/getCardDataFilter", "/dashboard/getTableDataFilter").permitAll()
                .antMatchers("/dashboard/saveStateDetails", "/dashboard/saveDistrictData", "/dashboard/saveTehsilData",
                        "/dashboard/saveBlockData", "/dashboard/saveVillageData", "/dashboard/saveCategoryData").permitAll()
                .antMatchers("/dashboard/getDistrictDataFilter", "/dashboard/getTehsilDataFilter", "/dashboard/getBlockDataFilter",
                        "/dashboard/getVillageDataFilter", "/dashboard/getcategoryDataFilter").permitAll()
                .antMatchers("/groupData/getFamilyList", "/groupData/getFamilyDetails", "/groupData/getIndividualMemberDetails",
                        "/groupData/getSpecificEmployedTypeList", "/groupData/getGovtSchemesEnroleldList", "/groupData/getSpecificSchemesList",
                        "/groupData/getMulyankaList", "/groupData/getEmployedTypeList").permitAll()
                .antMatchers("/admin/insertBulkUsers", "/dashboard/getStateDataFilter").permitAll()
                .antMatchers("/serveyor/getEmployedType", "/serveyor/getGovtSchemes", "/serveyor/addFamilyMember").permitAll()
                .antMatchers("/serveyor/editFamilyMember").permitAll()
                .antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/security", "/swagger-ui.html", "/webjars/**").permitAll()
                .anyRequest().authenticated().and().exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

    }

}
