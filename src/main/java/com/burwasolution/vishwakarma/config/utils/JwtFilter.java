package com.burwasolution.vishwakarma.config.utils;

import com.burwasolution.vishwakarma.config.JwtUtils;
import com.burwasolution.vishwakarma.controller.exceptionHandler.UnauthorizedException;
import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import com.burwasolution.vishwakarma.service_impl.service.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.burwasolution.vishwakarma.config.utils.Constants.HEADER_STRING;
import static com.burwasolution.vishwakarma.config.utils.Constants.TOKEN_PREFIX;

@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("=========service url====" + request.getRequestURL());
        String header = request.getHeader(HEADER_STRING);
        String username = null;
        long mobileNumber = 0;
        String authToken = null;

        if (header != null && header.startsWith(TOKEN_PREFIX)) {
            authToken = header.replace(TOKEN_PREFIX, "");
            try {
                username = jwtUtils.getUsernameFromToken(authToken);
            } catch (IllegalArgumentException e) {
                log.error("An Error Occurred During Getting The Username From Token", e);
            } catch (ExpiredJwtException e) {
                log.error("The Token Is Expired & Valid Anymore", e);
            } catch (SignatureException e) {
                log.error("Authentication Failed. Username or Password is not valid.");
                throw new UnauthorizedException("username Not Authorized");

            }
        } else {
            log.warn("Couldn't Find Bearer String, Will Ignore The Header");
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            Users users = userService.getUserByUsername(username);

            if (!users.isActive()) {
                log.info("User is Disabled" + username);
                throw new UnauthorizedException("You're not Authorized");
            }

            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if (jwtUtils.validateToken(authToken, userDetails)) {

                UsernamePasswordAuthenticationToken authenticationToken = jwtUtils.getAuthentication(authToken, SecurityContextHolder.getContext().getAuthentication(), userDetails);
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                log.info("Authenticated User " + username + " , Setting Security Content");
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }

        }
        filterChain.doFilter(request, response);
    }
}
