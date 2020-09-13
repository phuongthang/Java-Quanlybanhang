/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Object.ChiTietMatHang;
import Object.ChiTietPhieuNhap;
import Object.MatHang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Phuong Thang
 */
public class DAO_ChiTietPN {
    private Connection conn;
    public DAO_ChiTietPN()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DAO_Connection.url
                    + DAO_Connection.username + DAO_Connection.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<ChiTietPhieuNhap> getListPhieuNhapNgay(String ngay, String thang, String nam){
        ArrayList<ChiTietPhieuNhap> list = new ArrayList<>();
        String querry = "SELECT Mapn,ngaynhap,Hoten,Tiennhap FROM TbPhieuNhap,tbNhanVien where tbPhieuNhap.MaNV = tbNhanVien.Manv and Day(NgayNhap) = '"+ngay+"' and MONTH(NgayNhap) = '"+thang+"' and Year(NgayNhap) = '"+nam+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
                ctpn.setMapn(rs.getString(1));
                ctpn.setNgaynhap(rs.getDate(2));
                ctpn.setNhanvien(rs.getString(3));
                ctpn.setTienban(rs.getString(4));
                list.add(ctpn);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<ChiTietPhieuNhap> getListPhieuNhapThang(String thang, String nam){
        ArrayList<ChiTietPhieuNhap> list = new ArrayList<>();
        String querry = "SELECT Mapn,ngaynhap,Hoten,Tiennhap FROM TbPhieuNhap,tbNhanVien where tbPhieuNhap.MaNV = tbNhanVien.Manv  and MONTH(NgayNhap) = '"+thang+"' and Year(NgayNhap) = '"+nam+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
                ctpn.setMapn(rs.getString(1));
                ctpn.setNgaynhap(rs.getDate(2));
                ctpn.setNhanvien(rs.getString(3));
                ctpn.setTienban(rs.getString(4));
                list.add(ctpn);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<ChiTietPhieuNhap> getListPhieuNhapNam(String nam){
        ArrayList<ChiTietPhieuNhap> list = new ArrayList<>();
        String querry = "SELECT Mapn,ngaynhap,Hoten,Tiennhap FROM TbPhieuNhap,tbNhanVien where tbPhieuNhap.MaNV = tbNhanVien.Manv and Year(NgayNhap) = '"+nam+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
                ctpn.setMapn(rs.getString(1));
                ctpn.setNgaynhap(rs.getDate(2));
                ctpn.setNhanvien(rs.getString(3));
                ctpn.setTienban(rs.getString(4));
                list.add(ctpn);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<ChiTietMatHang> getListChiTietMatHang(String mapn){
        ArrayList<ChiTietMatHang> list = new ArrayList<>();
        String querry = "select tbHangNhap.MaHN, TenHN, SoLuong, tbChiTietPN.DonGia from tbChiTietPN,tbHangNhap where tbHangNhap.MaHN = tbChiTietPN.MaHN and MaPN = '"+mapn+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                ChiTietMatHang ctmh = new ChiTietMatHang();
                ctmh.setMamh(rs.getString(1));
                ctmh.setTenmh(rs.getString(2));
                ctmh.setSoluong(rs.getString(3));
                ctmh.setDongia(rs.getString(4));
                list.add(ctmh);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    public boolean updateHangNhap(String soluong ,String mahn)
    {
        String querry = "UPDATE tbHangNhap SET TongSoLuong = '"+soluong+"'  where MaHN ='"+mahn+"' ";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);     
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public String SoluongTon(String mahn)
    {
        String soluong = "0";
        String querry = "select sum(convert(int,soluong)) from tbChiTietPN where mahn ='"+mahn+"' group by MaHN";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                soluong = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return soluong;
    }
}
