package com.bankofabyssinia.spring_template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankofabyssinia.spring_template.dto.Request.LdapLoginRequest;

import com.bankofabyssinia.spring_template.dto.Request.RefreshTokenRequest;
import com.bankofabyssinia.spring_template.dto.Response.ApiResponse;
import com.bankofabyssinia.spring_template.dto.Response.LdapLoginResponse;
import com.bankofabyssinia.spring_template.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/auth")
public class AuthController extends BaseController {

   
    @Autowired
    private AuthService authService;
   
    @Operation(summary = "LDAP login", description = "Delegates login to external auth-service LDAP endpoint")
    @PostMapping("/ldap-login")
    public ResponseEntity<ApiResponse<LdapLoginResponse>> ldapLogin(@Valid @RequestBody LdapLoginRequest request) {
        return ok("Login successful", authService.ldapLogin(request));
    }

    @Operation(summary = "LDAP refresh", description = "Refreshes the LDAP token by delegating to auth-service")
    @PostMapping("/ldap-refresh")
    public ResponseEntity<ApiResponse<LdapLoginResponse>> ldapRefresh(@Valid @RequestBody RefreshTokenRequest request) {
        return ok("Token refreshed successfully", authService.ldapRefresh(request));
    }

}
