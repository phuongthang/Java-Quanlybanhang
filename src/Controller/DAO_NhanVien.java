/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Object.NhanVien;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Phuong Thang
 */
public class DAO_NhanVien {
    private Connection conn;
    public DAO_NhanVien()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DAO_Connection.url
                    + DAO_Connection.username + DAO_Connection.password);
        } catch (Exception e) {
        }
    }
    public ArrayList<NhanVien> getListNhanVien(){
        ArrayList<NhanVien> list = new ArrayList<>();
        String querry = "SELECT * FROM tbNhanVien";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                NhanVien nv = new NhanVien();
                nv.setManv(rs.getString(1));
                nv.setHoten(rs.getString(2));
                nv.setGioitinh(rs.getString(3));
                nv.setQuequan(rs.getString(4));
                nv.setNgaySinh(rs.getDate(5));
                nv.setSdt(rs.getString(6));
                list.add(nv);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public boolean addNhanVien(NhanVien nv)
    {
        String querry = "INSERT INTO tbNhanVien(Manv,HoTen,GioiTinh,QueQuan,NgaySinh,Sdt) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ps.setString(1, nv.getManv());
            ps.setString(2, nv.getHoten());
            ps.setString(3, nv.getGioitinh());
            ps.setString(4, nv.getQuequan());
            ps.setDate(5, new Date(nv.getNgaySinh().getTime()));
            ps.setString(6, nv.getSdt());
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateNhanVien(NhanVien nv)
    {
        String querry = "UPDATE tbNhanVien SET Manv=?, HoTen =?, GioiTinh = ?,QueQuan =?,NgaySinh =?,Sdt=? WHERE Manv = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ps.setString(1, nv.getManv());
            ps.setString(2, nv.getHoten());
            ps.setString(3, nv.getGioitinh());
            ps.setString(4, nv.getQuequan());
            ps.setDate(5, new Date(nv.getNgaySinh().getTime()));
            ps.setString(6, nv.getSdt());
            ps.setString(7, nv.getManv());
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteNhanVien(String manv)
    {
        String querry = "DELETE FROM tbNhanVien WHERE Manv='"+manv+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<NhanVien> findNhanVien(String truyvan){
        ArrayList<NhanVien> list = new ArrayList<>();
        String querry = "SELECT * FROM tbNhanVien WHERE MANV = '"+truyvan+"' OR HOTEN LIKE N'%"+truyvan+"%' OR GIOITINH=N'"+truyvan+"'OR QUEQUAN LIKE N'%"+truyvan+"%'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                NhanVien nv = new NhanVien();
                nv.setManv(rs.getString(1));
                nv.setHoten(rs.getString(2));
                nv.setGioitinh(rs.getString(3));
                nv.setQuequan(rs.getString(4));
                nv.setNgaySinh(rs.getDate(5));
                nv.setSdt(rs.getString(6));
                list.add(nv);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    
}
