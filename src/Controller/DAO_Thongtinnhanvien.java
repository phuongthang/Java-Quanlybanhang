/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Object.ThongTinNhanVien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Phuong Thang
 */
public class DAO_Thongtinnhanvien {
    private Connection conn;
    public DAO_Thongtinnhanvien()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DAO_Connection.url
                    + DAO_Connection.username + DAO_Connection.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<ThongTinNhanVien> getInforNhanVien(){
        ArrayList<ThongTinNhanVien> list = new ArrayList<>();
        String querry = "SELECT MaNV, Hoten FROM TbNhanVien";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                ThongTinNhanVien nv = new ThongTinNhanVien();
                nv.setManhanvien(rs.getString(1));
                nv.setHoten(rs.getString(2));
                list.add(nv);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
}
