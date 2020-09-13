/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Object.BieuDo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Phuong Thang
 */
public class DAO_ThongKe {
    private Connection conn;
    public DAO_ThongKe()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DAO_Connection.url
                    + DAO_Connection.username + DAO_Connection.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String ThanhtienNgay(String ngay,String thang, String nam){
        String tienban = "0";
        String querry = "select sum(convert(int,thanhtien)) from tbHoaDon where Day(NgayBan) = '"+ngay+"' and Month(NgayBan) = '"+thang+"' and Year(NgayBan) = '"+nam+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                tienban = rs.getString(1);
                
                
            }
        } catch (Exception e) {
        }
        return tienban;
        
    }
    public String ThanhtienThang(String thang, String nam){
        String tienban = "0";
        String querry = "select sum(convert(int,thanhtien)) from tbHoaDon where Month(NgayBan) = '"+thang+"' and Year(NgayBan) = '"+nam+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                tienban = rs.getString(1);
                
                
            }
        } catch (Exception e) {
        }
        return tienban;
        
    }
    public String ThanhtienNam(String nam){
       String tienban = "0";
        String querry = "select sum(convert(int,thanhtien)) from tbHoaDon where Year(NgayBan) = '"+nam+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                tienban = rs.getString(1);
                
                
            }
        } catch (Exception e) {
        }
        return tienban;
        
    }
    
    public String TienNhapNgay(String ngay,String thang, String nam){
        String tiennhap = "0";
        String querry = "select sum(convert(int,tiennhap)) from tbPhieuNhap where Day(NgayNhap) = '"+ngay+"' and Month(NgayNhap) = '"+thang+"' and Year(NgayNhap) = '"+nam+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                tiennhap = rs.getString(1);
                
                
            }
        } catch (Exception e) {
        }
        return tiennhap;
        
    }
    public String TienNhapThang(String thang, String nam){
        String tiennhap = "0";
        String querry = "select sum(convert(int,tiennhap)) from tbPhieuNhap where Month(NgayNhap) = '"+thang+"' and Year(NgayNhap) = '"+nam+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                tiennhap = rs.getString(1);
                
                
            }
        } catch (Exception e) {
        }
        return tiennhap;
        
    }
    public String TienNhapNam(String nam){
        String tiennhap = "0";
        String querry = "select sum(convert(int,tiennhap)) from tbPhieuNhap where Year(NgayNhap) = '"+nam+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                tiennhap = rs.getString(1);
                
                
            }
        } catch (Exception e) {
        }
        return tiennhap;
        
    }
    public ArrayList<BieuDo> getListBieuDo(String start, String end){
        ArrayList<BieuDo> list = new ArrayList<>();
        String querry = "select ngayban, sum(convert(int,thanhtien)) as thanhtien from tbHoaDon where ngayban between '"+start+"' and '"+end+"' group by ngayban";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                BieuDo bd = new BieuDo();
                bd.setNgayban(rs.getString(1));
                bd.setThanhtien(rs.getString(2));
                list.add(bd);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<BieuDo> getListBieuDoMaMH(String start, String end, String mamh){
        ArrayList<BieuDo> list = new ArrayList<>();
        String querry = "select ngayban,sum(convert(int,thanhtien)) as tienban from tbHoaDon,tbChiTietHD where tbHoaDon.MaHD = tbChiTietHD.MaHD and tbChiTietHD.MaHN = '"+mamh+"' and ngayban between '"+start+"' and '"+end+"' group by ngayban";
        try {
            
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                BieuDo bd = new BieuDo();
                bd.setNgayban(rs.getString(1));
                bd.setThanhtien(rs.getString(2));
                list.add(bd);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    
}
