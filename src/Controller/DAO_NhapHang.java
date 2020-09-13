/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Object.PhieuNhap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Phuong Thang
 */
public class DAO_NhapHang {
    private Connection conn;
    public DAO_NhapHang()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DAO_Connection.url
                    + DAO_Connection.username + DAO_Connection.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public ArrayList<PhieuNhap> getListPhieuNhap(String mapn){
        ArrayList<PhieuNhap> list = new ArrayList<>();
        String querry = "select tbPhieuNhap.mapn,ngaynhap,tbNhanVien.HoTen,tbChiTietPN.MaHN,tenhn, soluong,tbHangNhap.dongia from tbChiTietPN, tbPhieuNhap,tbHangNhap,tbNhanVien where tbNhanVien.MaNV = tbPhieuNhap.MaNV and tbPhieuNhap.MaPN = tbChiTietPN.MaPN  and tbChiTietPN.MaHN = tbHangNhap.MaHN and tbPhieuNhap.MaPN = '"+mapn+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                PhieuNhap pn = new PhieuNhap();
                pn.setMapn(rs.getString(1));
                pn.setNgaynhap(rs.getDate(2));
                pn.setTennv(rs.getString(3));
                pn.setMahn(rs.getString(4));
                pn.setTenhn(rs.getString(5));
                pn.setSoluong(rs.getString(6));
                pn.setDongia(rs.getString(7));
                list.add(pn);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    public boolean addPhieuNhap(PhieuNhap pn)
    {
        String querry = "INSERT INTO tbPhieuNhap(MaPN,NgayNhap,MaNV) VALUES(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ps.setString(1, pn.getMapn());
            ps.setDate(2, new java.sql.Date(pn.getNgaynhap().getTime()));
            ps.setString(3, pn.getManv());
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addChiTietPN(PhieuNhap pn)
    {
        String querry = "INSERT INTO tbChiTietPN(MaPN,MaHN,SoLuong,DonGia) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ps.setString(1, pn.getMapn());
            ps.setString(2, pn.getMahn());
            ps.setString(3, pn.getSoluong());
            ps.setString(4, pn.getDongia());
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateChiTietPN(PhieuNhap pn)
    {
        String querry = "UPDATE tbChiTietPN SET soluong = ? WHERE MaPN = ? and MaHN = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ps.setString(1, pn.getSoluong());
            ps.setString(2, pn.getMapn());
            ps.setString(3, pn.getMahn());      
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteChiTietPN(String mapn,String mahn)
    {
        String querry = "DELETE FROM tbChiTietPN WHERE MaPN='"+mapn+"'and MaHN='"+mahn+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deletePN(String mapn)
    {
        String querry = "DELETE FROM tbPhieuNhap WHERE MaPN='"+mapn+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateTienNhap(String tiennhap, String mapn)
    {
        String querry = "UPDATE tbPhieuNhap SET TienNhap = N'"+tiennhap+"' WHERE MaPN = '"+mapn+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);      
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteCTPN(String mapn)
    {
        String querry = "DELETE FROM tbCHITIETPN WHERE MaPN='"+mapn+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
