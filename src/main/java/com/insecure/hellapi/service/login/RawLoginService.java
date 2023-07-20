package com.insecure.hellapi.service.login;

import com.insecure.hellapi.dto.LoginDTO;

public interface RawLoginService {
    String check(LoginDTO loginDTO);
}
