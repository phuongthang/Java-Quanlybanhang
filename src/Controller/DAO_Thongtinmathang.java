/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Object.ThongTinMatHang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Phuong Thang
 */
public class DAO_Thongtinmathang {
    
    private Connection conn;
    public DAO_Thongtinmathang()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DAO_Connection.url
                    + DAO_Connection.username + DAO_Connection.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<ThongTinMatHang> getInforMatHang(){
        ArrayList<ThongTinMatHang> list = new ArrayList<>();
        String querry = "select tbHangNhap.mahn, tenhn, dongia from tbHangNhap";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                ThongTinMatHang mathangnhap = new ThongTinMatHang();
                mathangnhap.setMahang(rs.getString(1));
                mathangnhap.setTenhang(rs.getString(2));
                mathangnhap.setDongia(rs.getString(3));
                list.add(mathangnhap);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<ThongTinMatHang> getInforMatHangLoai(String loai){
        ArrayList<ThongTinMatHang> list = new ArrayList<>();
        String querry = "select tbHangNhap.mahn, tenhn, dongia from tbHangNhap where  Loai = N'"+loai+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                ThongTinMatHang mathangnhap = new ThongTinMatHang();
                mathangnhap.setMahang(rs.getString(1));
                mathangnhap.setTenhang(rs.getString(2));
                mathangnhap.setDongia(rs.getString(3));
                list.add(mathangnhap);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
}
