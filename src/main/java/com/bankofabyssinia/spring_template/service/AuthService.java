package com.bankofabyssinia.spring_template.service;

import com.bankofabyssinia.spring_template.dto.Request.LdapLoginRequest;
import com.bankofabyssinia.spring_template.dto.Request.LogOutDto;
import com.bankofabyssinia.spring_template.dto.Request.RefreshTokenRequest;
import com.bankofabyssinia.spring_template.dto.Response.LdapLoginResponse;
import com.bankofabyssinia.spring_template.dto.Response.LogOutResponse;
import com.bankofabyssinia.spring_template.dto.Response.TokenValidationResponse;

import jakarta.servlet.http.HttpServletRequest;

public interface AuthService {

    LdapLoginResponse ldapLogin(LdapLoginRequest request);

    LdapLoginResponse ldapRefresh(RefreshTokenRequest request);

    LogOutResponse logout(LogOutDto request);

    TokenValidationResponse validateToken(HttpServletRequest httpServletRequest);
}
