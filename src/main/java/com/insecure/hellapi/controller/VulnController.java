package com.insecure.hellapi.controller;

import com.insecure.hellapi.dto.LoginDTO;
import com.insecure.hellapi.service.login.RawLoginService;
import com.insecure.hellapi.service.ping.PingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VulnController {

    @Autowired
    PingService pingService;

    @Autowired
    RawLoginService rawLoginService;

    @GetMapping("/login-raw")
    public String loginRaw(@RequestBody LoginDTO loginDTO){
        return rawLoginService.check(loginDTO);
    }

    @GetMapping("/send-ping")
    public String ping(@RequestHeader String ip){
        return pingService.sendPing(ip);
    }
}
