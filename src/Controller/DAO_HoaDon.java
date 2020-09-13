/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Object.HoaDon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Phuong Thang
 */
public class DAO_HoaDon {
    private Connection conn;  
    public DAO_HoaDon()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DAO_Connection.url
                    + DAO_Connection.username + DAO_Connection.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<HoaDon> getListHoaDon(String mahd){
        ArrayList<HoaDon> list = new ArrayList<>();
        String querry = "select tbChiTietHD.mahd,ngayban,tbNhanVien.HoTen,tbKhachhang.hoten,diachi,tbKhachHang.SDT,tbChiTietHD.mahn,tenhn,soluong,tbChiTietHD.dongia from tbHoaDon,tbHangNhap,tbChiTietHD,tbKhachHang,tbNhanVien where tbNhanVien.MaNV = tbHoaDon.MaNV and tbHoaDon.MaHD = tbChiTietHD.MaHD and tbKhachHang.makh = tbHoadon.makh and tbChiTietHD.MaHN = tbHangNhap.MaHN and tbHoaDon.MaHD = '"+mahd+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                HoaDon hoadon = new HoaDon();
                hoadon.setMahd(rs.getString(1));
                hoadon.setNgayban(rs.getDate(2));
                hoadon.setTennv(rs.getString(3));
                hoadon.setTenkh(rs.getString(4));
                hoadon.setDiachi(rs.getString(5));
                hoadon.setSdt(rs.getString(6));
                hoadon.setMamh(rs.getString(7));
                hoadon.setTenmh(rs.getString(8));
                hoadon.setSoluong(rs.getString(9));
                hoadon.setDongia(rs.getString(10));
                list.add(hoadon);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    public boolean addHoaDon(HoaDon hoadon)
    {
        String querry = "INSERT INTO tbHoaDon(MaHD,NgayBan,MaNV,MaKH) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ps.setString(1, hoadon.getMahd());
            ps.setDate(2, new java.sql.Date(hoadon.getNgayban().getTime()));
            ps.setString(3, hoadon.getManv());
            ps.setString(4, hoadon.getMakh());
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addChiTietHD(HoaDon hoadon)
    {
        String querry = "INSERT INTO tbChiTietHD(MaHD,MaHN,SoLuong,DonGia) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ps.setString(1, hoadon.getMahd());
            ps.setString(2, hoadon.getMamh());
            ps.setString(3, hoadon.getSoluong());
            ps.setString(4, hoadon.getDongia());
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addKhachHang(HoaDon hoadon)
    {
        String querry = "INSERT INTO tbKhachHang(MaKH,Hoten,DiaChi,Sdt) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ps.setString(1, hoadon.getMakh());
            ps.setString(2, hoadon.getTenkh());
            ps.setString(3, hoadon.getDiachi());
            ps.setString(4, hoadon.getSdt());
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateKhachHang(HoaDon hoadon)
    {
        String querry = "UPDATE tbKhachHang SET Hoten = ?, DiaChi = ? , SDT = ? WHERE MaKH = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ps.setString(1, hoadon.getTenkh());
            ps.setString(2, hoadon.getDiachi());
            ps.setString(3, hoadon.getSdt());
            ps.setString(4, hoadon.getMakh());      
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateChiTietHD(HoaDon hoadon)
    {
        String querry = "UPDATE tbChiTietHD SET soluong = ? WHERE MaHD = ? and MaHN = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ps.setString(1, hoadon.getSoluong());
            ps.setString(2, hoadon.getMahd());
            ps.setString(3, hoadon.getMamh());      
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteChiTietHD(String mahd,String mahn)
    {
        String querry = "DELETE FROM tbChiTietHD WHERE MaHD='"+mahd+"'and MaHN='"+mahn+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteKhachHang(String makh)
    {
        String querry = "DELETE FROM tbKhachHang WHERE MaKH = '"+makh+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteHD(String mahd)
    {
        String querry = "DELETE FROM tbHoaDon WHERE MaHD='"+mahd+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteCTHD(String mahd)
    {
        String querry = "DELETE FROM tbCHITIETHD WHERE MaHD='"+mahd+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateTienBan(String tienban, String mahd)
    {
        String querry = "UPDATE tbHoaDon SET TienBan = N'"+tienban+"' WHERE MaHD = '"+mahd+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);      
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<String> getLoaiMH(){
        ArrayList<String> loaiMH = new ArrayList<>();
        String querry = "Select DISTINCT Loai from tbHangNhap";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                loaiMH.add(rs.getString(1));
                
            }
        } catch (Exception e) {
        }
        return loaiMH;
    }
    public boolean updateGiamGia(String persent,String mahd)
    {
        String querry = "UPDATE tbHoaDon SET GiamGia = N'"+persent+"' WHERE MaHD = '"+mahd+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);      
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateThanhTien(String thanhtien, String mahd)
    {
        String querry = "UPDATE tbHoaDon SET ThanhTien = N'"+thanhtien+"' WHERE MaHD = '"+mahd+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);      
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
