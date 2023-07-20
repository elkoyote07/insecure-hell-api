package com.insecure.hellapi.service.login;

import com.insecure.hellapi.dto.LoginDTO;
import com.insecure.hellapi.entity.LoginEntity;
import com.insecure.hellapi.repository.RawLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RawLoginServiceImpl implements RawLoginService{

    @Autowired
    RawLoginRepository rawLoginRepository;
    @Override
    public String check(LoginDTO loginDTO) {
        LoginEntity loginEntity = new LoginEntity(loginDTO.getUsername(), loginDTO.getPassword());

        LoginEntity loginResult;

        loginResult = rawLoginRepository.rawFecthLogin(loginEntity);

        if (loginResult != null){
            LoginDTO loginDTOResult = new LoginDTO();
            loginDTOResult.setRole(loginResult.getRole());
            return loginDTOResult.getRole();
        }

        return "Not found";
    }
}
