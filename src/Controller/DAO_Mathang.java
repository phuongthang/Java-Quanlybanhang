/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class DAO_Mathang {
    private Connection conn;
    public DAO_Mathang()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DAO_Connection.url
                    + DAO_Connection.username + DAO_Connection.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<MatHang> getListMHN(){
        ArrayList<MatHang> list = new ArrayList<>();
        String querry = "SELECT * FROM TbHangNhap";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                MatHang mathangnhap = new MatHang();
                mathangnhap.setMahangnhap(rs.getString(1));
                mathangnhap.setTenmathang(rs.getString(2));
                mathangnhap.setMota(rs.getString(5));
                mathangnhap.setLoai(rs.getString(3));
                mathangnhap.setDongia(rs.getString(4));
                list.add(mathangnhap);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    public boolean addMHN(MatHang mathangnhap)
    {
        String querry = "INSERT INTO tbHangNhap(MaHN,TenHN,Loai,Dongia,Mota) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ps.setString(1, mathangnhap.getMahangnhap() );
            ps.setString(2, mathangnhap.getTenmathang());
            ps.setString(4, mathangnhap.getDongia());
            ps.setString(5, mathangnhap.getMota());
            ps.setString(3, mathangnhap.getLoai());
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateMHN(MatHang mathangnhap)
    {
        String querry = "UPDATE tbHangNhap SET MaHN=?, TenHN =?,Loai =?, DonGia = ?, Mota = ? WHERE MaHN = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ps.setString(1, mathangnhap.getMahangnhap());
            ps.setString(2, mathangnhap.getTenmathang());
            ps.setString(4, mathangnhap.getDongia());
            ps.setString(5, mathangnhap.getMota());
            ps.setString(3, mathangnhap.getLoai());
            ps.setString(6, mathangnhap.getMahangnhap());
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteMHN(String mahangnhap)
    {
        String querry = "DELETE FROM tbHangNhap WHERE MaHN='"+mahangnhap+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<MatHang> findMHN(String truyvan){
        ArrayList<MatHang> list = new ArrayList<>();
        String querry = "SELECT * FROM TbHangNhap WHERE MAHN = '"+truyvan+"' OR TENHN LIKE N'%"+truyvan+"%' OR LOAI LIKE N'%"+truyvan+"%'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                MatHang mathangnhap = new MatHang();
                mathangnhap.setMahangnhap(rs.getString(1));
                mathangnhap.setTenmathang(rs.getString(2));
                mathangnhap.setDongia(rs.getString(4));
                mathangnhap.setLoai(rs.getString(3));
                mathangnhap.setMota(rs.getString(5));
                list.add(mathangnhap);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
}
