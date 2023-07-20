package com.insecure.hellapi.service.ping;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class PingServiceImpl implements PingService{
    @Override
    public String sendPing(String ip) {
        StringBuilder output = null;
        try {
            String console = "ping -n 1 " + ip;
            System.out.println(console);
            final Process processBuilder = new ProcessBuilder("CMD", "/C", console).start();

            output = new StringBuilder();


            BufferedReader reader = new BufferedReader(new InputStreamReader(processBuilder.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toString();
    }
}
