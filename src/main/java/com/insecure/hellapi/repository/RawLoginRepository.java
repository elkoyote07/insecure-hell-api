package com.insecure.hellapi.repository;

import com.insecure.hellapi.entity.LoginEntity;

public interface RawLoginRepository {
    LoginEntity rawFecthLogin(LoginEntity loginEntity);
}
