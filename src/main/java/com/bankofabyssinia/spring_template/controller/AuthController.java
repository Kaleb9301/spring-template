package com.bankofabyssinia.spring_template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankofabyssinia.spring_template.dto.Request.LdapLoginRequest;
import com.bankofabyssinia.spring_template.dto.Request.LogOutDto;
import com.bankofabyssinia.spring_template.dto.Request.RefreshTokenRequest;
import com.bankofabyssinia.spring_template.dto.Response.ApiResponse;
import com.bankofabyssinia.spring_template.dto.Response.LdapLoginResponse;
import com.bankofabyssinia.spring_template.dto.Response.LogOutResponse;
import com.bankofabyssinia.spring_template.dto.Response.TokenValidationResponse;
import com.bankofabyssinia.spring_template.service.AuthService;

import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/auth")
public class AuthController extends BaseController {

   
    @Autowired
    private AuthService authService;
   
    @Operation(summary = "LDAP login", description = "Delegates login to external auth-service LDAP endpoint")
    @PostMapping("/ldap-login")
    public ResponseEntity<ApiResponse<LdapLoginResponse>> ldapLogin(@Valid @RequestBody LdapLoginRequest request, HttpServletRequest httpServletRequest) {
        return ok("Login successful", authService.ldapLogin(request), httpServletRequest.getRequestURI());
    }

    @Operation(summary = "LDAP refresh", description = "Refreshes the LDAP token by delegating to auth-service")
    @PostMapping("/ldap-refresh")
    public ResponseEntity<ApiResponse<LdapLoginResponse>> ldapRefresh(@Valid @RequestBody RefreshTokenRequest request, HttpServletRequest httpServletRequest) {
        return ok("Token refreshed successfully", authService.ldapRefresh(request), httpServletRequest.getRequestURI());
    }

    @Operation(summary = "LDAP refresh", description = "Refreshes the LDAP token by delegating to auth-service")
    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<Void>> logout(@Valid @RequestBody LogOutDto request, HttpServletRequest httpServletRequest) {
        LogOutResponse response = authService.logout(request);
        return ok(response.getMessage(), httpServletRequest.getRequestURI());
    }

    // validate token endpoint
        @Operation(summary = "Validate token", description = "Validates the provided token by delegating to auth-service")
        @GetMapping("/validate-token")
        public ResponseEntity<ApiResponse<TokenValidationResponse>> validateToken(HttpServletRequest httpServletRequest) {
            TokenValidationResponse response = authService.validateToken(httpServletRequest);
            if (response.isValid()) {
                return ok("Token is valid", response, httpServletRequest.getRequestURI());
            } else {
                return fail(HttpStatus.UNAUTHORIZED, "Token is invalid", httpServletRequest.getRequestURI());
            }

            // return ok("Token ", response, httpServletRequest.getRequestURI().toString());
        }    



}
