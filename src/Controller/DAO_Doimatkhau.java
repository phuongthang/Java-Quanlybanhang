/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Phuong Thang
 */
public class DAO_Doimatkhau {
    private Connection conn;
    public DAO_Doimatkhau()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DAO_Connection.url
                    + DAO_Connection.username + DAO_Connection.password);
        } catch (Exception e) {
        }
    }
    public boolean DoiMatKhau(String username, String password)
    {
        String querry = "Update tbAccount set password = '"+password+"' where username = '"+username+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public String getMatKhau(String username)
    {
        String querry = "Select password from tbAccount where username = '"+username+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return rs.getString(1);
            }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
