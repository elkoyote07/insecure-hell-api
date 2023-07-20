package com.insecure.hellapi.repository;

import com.insecure.hellapi.config.Postgres;
import com.insecure.hellapi.entity.LoginEntity;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Repository
public class RawLoginRepositoryImpl implements RawLoginRepository{
    @Override
    public LoginEntity rawFecthLogin(LoginEntity loginEntity) {
        Statement stmt = null;
        LoginEntity loginResult = null;
        try {
            Connection cxn = Postgres.connection();
            stmt = cxn.createStatement();
            System.out.println("Opened database successfully");

            String query = "select * from login where username = '" + loginEntity.getUsername()+ "' and password = '" + loginEntity.getPassword() + "' limit 1";
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                Long user_id = Long.valueOf(rs.getString("id"));
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");
                loginResult = new LoginEntity(user_id, username, password, role);
            }
            cxn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        } finally {
            return loginResult;
        }
    }
}
