/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Object.ChiTietHoaDon;
import Object.ChiTietMatHang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Phuong Thang
 */
public class DAO_ChiTietHD {
   private Connection conn;
    public DAO_ChiTietHD()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DAO_Connection.url
                    + DAO_Connection.username + DAO_Connection.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<ChiTietHoaDon> getListHoaDonNgay(String ngay, String thang, String nam){
        ArrayList<ChiTietHoaDon> list = new ArrayList<>();
        String querry = "SELECT MaHD,ngayban,Hoten,TienBan,Giamgia,Thanhtien FROM TbHoaDon,tbNhanVien where tbHoaDon.MaNV = tbNhanVien.Manv and Day(NgayBan) = '"+ngay+"' and MONTH(NgayBan) = '"+thang+"' and Year(NgayBan) = '"+nam+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setMahd(rs.getString(1));
                cthd.setNgayban(rs.getDate(2));
                cthd.setNhanvien(rs.getString(3));
                cthd.setTienban(rs.getString(4));
                cthd.setGiamgia(rs.getString(5));
                cthd.setThanhtien(rs.getString(6));
                list.add(cthd);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<ChiTietHoaDon> getListHoaDonThang(String thang, String nam){
        ArrayList<ChiTietHoaDon> list = new ArrayList<>();
        String querry = "SELECT MaHD,ngayban,Hoten,TienBan,Giamgia,Thanhtien FROM TbHoaDon,tbNhanVien where tbHoaDon.MaNV = tbNhanVien.Manv and MONTH(NgayBan) = '"+thang+"' and Year(NgayBan) = '"+nam+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setMahd(rs.getString(1));
                cthd.setNgayban(rs.getDate(2));
                cthd.setNhanvien(rs.getString(3));
                cthd.setTienban(rs.getString(4));
                cthd.setGiamgia(rs.getString(5));
                cthd.setThanhtien(rs.getString(6));
                list.add(cthd);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<ChiTietHoaDon> getListHoaDonNam(String nam){
        ArrayList<ChiTietHoaDon> list = new ArrayList<>();
        String querry = "SELECT MaHD,ngayban,Hoten,TienBan,Giamgia,Thanhtien FROM TbHoaDon,tbNhanVien where tbHoaDon.MaNV = tbNhanVien.Manv and Year(NgayBan) = '"+nam+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setMahd(rs.getString(1));
                cthd.setNgayban(rs.getDate(2));
                cthd.setNhanvien(rs.getString(3));
                cthd.setTienban(rs.getString(4));
                cthd.setGiamgia(rs.getString(5));
                cthd.setThanhtien(rs.getString(6));
                list.add(cthd);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<ChiTietMatHang> getListChiTietMatHang(String mahd){
        ArrayList<ChiTietMatHang> list = new ArrayList<>();
        String querry = "select tbHangNhap.MaHN, TenHN, SoLuong, tbChiTietHD.DonGia from tbChiTietHD,tbHangNhap where tbHangNhap.MaHN = tbChiTietHD.MaHN and MaHD = '"+mahd+"'";
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
    public String SoluongBan(String mahn)
    {
        String soluong = "0";
        String querry = "select sum(convert(int,soluong)) from tbChiTietHD where mahn ='"+mahn+"' group by MaHN";
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
