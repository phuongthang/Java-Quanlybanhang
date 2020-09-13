/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Object.TaiKhoan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Phuong Thang
 */
public class DAO_TaiKhoan {
    private Connection conn;
    public DAO_TaiKhoan()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DAO_Connection.url
                    + DAO_Connection.username + DAO_Connection.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<TaiKhoan> getListTaiKhoan(){
        ArrayList<TaiKhoan> list = new ArrayList<>();
        String querry = "select * from tbAccount";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                TaiKhoan tk = new TaiKhoan();
                tk.setTaikhoan(rs.getString(1));
                tk.setMatkhau(rs.getString(2));
                list.add(tk);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    public boolean deleteTaiKhoan(String taikhoan)
    {
        String querry = "DELETE FROM tbAccount WHERE Username='"+taikhoan+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
