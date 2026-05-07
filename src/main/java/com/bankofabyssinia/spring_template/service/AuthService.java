package com.bankofabyssinia.spring_template.service;

import com.bankofabyssinia.spring_template.dto.Request.LdapLoginRequest;
import com.bankofabyssinia.spring_template.dto.Request.RefreshTokenRequest;
import com.bankofabyssinia.spring_template.dto.Response.LdapLoginResponse;

public interface AuthService {

    LdapLoginResponse ldapLogin(LdapLoginRequest request);

    LdapLoginResponse ldapRefresh(RefreshTokenRequest request);
}
