/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Object.Kho;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Phuong Thang
 */
public class DAO_Kho {
    private Connection conn;
    public DAO_Kho()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DAO_Connection.url
                    + DAO_Connection.username + DAO_Connection.password);
        } catch (Exception e) {
        }
    }
    public ArrayList<Kho> getKhoHang(){
        ArrayList<Kho> list = new ArrayList<>();
        String querry = "select tbHangNhap.MaHN, TenHN, Loai, convert(int,tongsoluong) as tongsoluong, tbHangNhap.dongia  from tbHangNhap, tbChiTietPN where tbHangNhap.MaHN = tbChiTietPN.MaHN group by tbHangNhap.MaHN,TenHN,Loai,convert(int,tongsoluong),tbHangNhap.dongia";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Kho kho = new Kho();
                kho.setMahn(rs.getString(1));
                kho.setTenhn(rs.getString(2));
                kho.setLoai(rs.getString(3));
                kho.setSoluong(rs.getString(4));
                kho.setDongia(rs.getString(5));
                list.add(kho);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<String> getListMaHN(){
        ArrayList<String> listmahn = new ArrayList<>();
        String querry = "select DISTINCT MaHN From tbHangNhap";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                String mahn = rs.getString(1);
                
                listmahn.add(mahn);
                
            }
        } catch (Exception e) {
        }
        return listmahn;
    }
    public ArrayList<String> getListTenHN(){
        ArrayList<String> listtenhn = new ArrayList<>();
        String querry = "select DISTINCT TenHN From tbHangNhap";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                String tenhn = rs.getString(1);
                
                listtenhn.add(tenhn);
                
            }
        } catch (Exception e) {
        }
        return listtenhn;
    }
    public ArrayList<String> getListLoai(){
        ArrayList<String> listloai = new ArrayList<>();
        String querry = "select DISTINCT Loai From tbHangNhap";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                String loai = rs.getString(1);
                
                listloai.add(loai);
                
            }
        } catch (Exception e) {
        }
        return listloai;
    }
    public ArrayList<Kho> TimKiem(String doituong,String truyvan){
        ArrayList<Kho> list = new ArrayList<>();
        String querry = "select DISTINCT tbHangNhap.MaHN, TenHN, Loai, convert(int,tongsoluong) as tongsoluong, tbHangNhap.dongia  from tbHangNhap, tbChiTietPN where tbHangNhap.MaHN = tbChiTietPN.MaHN and "+doituong+" = N'"+truyvan+"' group by tbHangNhap.MaHN,TenHN,Loai,convert(int,tongsoluong),tbHangNhap.dongia";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Kho kho = new Kho();
                kho.setMahn(rs.getString(1));
                kho.setTenhn(rs.getString(2));
                kho.setLoai(rs.getString(3));
                kho.setSoluong(rs.getString(4));
                kho.setDongia(rs.getString(5));
                list.add(kho);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<Kho> getSapXep(String loai, String chieu){
        ArrayList<Kho> list = new ArrayList<>();
        String querry = "select tbHangNhap.MaHN, TenHN, Loai, convert(int,tongsoluong) as tongsoluong, tbHangNhap.dongia  from tbHangNhap, tbChiTietPN where tbHangNhap.MaHN = tbChiTietPN.MaHN group by tbHangNhap.MaHN,TenHN,Loai,convert(int,tongsoluong),tbHangNhap.dongia order by "+loai+" "+chieu+"  ";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Kho kho = new Kho();
                kho.setMahn(rs.getString(1));
                kho.setTenhn(rs.getString(2));
                kho.setLoai(rs.getString(3));
                kho.setSoluong(rs.getString(4));
                kho.setDongia(rs.getString(5));
                list.add(kho);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<Kho> TimKiemSapXep(String truyvan,String loai, String chieu){
        ArrayList<Kho> list = new ArrayList<>();
        String querry = "select tbHangNhap.MaHN, TenHN, Loai, convert(int,tongsoluong) as tongsoluong, tbHangNhap.dongia  from tbHangNhap, tbChiTietPN where tbHangNhap.MaHN = tbChiTietPN.MaHN and Loai = N'"+truyvan+"' group by tbHangNhap.MaHN,TenHN,Loai,convert(int,tongsoluong),tbHangNhap.dongia order by "+loai+" "+chieu+" ";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Kho kho = new Kho();
                kho.setMahn(rs.getString(1));
                kho.setTenhn(rs.getString(2));
                kho.setLoai(rs.getString(3));
                kho.setSoluong(rs.getString(4));
                kho.setDongia(rs.getString(5));
                list.add(kho);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<Kho> getTruyVan(String truyvan){
        ArrayList<Kho> list = new ArrayList<>();
        String querry = "select tbHangNhap.MaHN, TenHN, Loai, convert(int,tongsoluong) as tongsoluong, tbHangNhap.dongia  from tbHangNhap, tbChiTietPN where tbHangNhap.MaHN = tbChiTietPN.MaHN and tbHangNhap.TenHN Like N'%"+truyvan+"%' group by tbHangNhap.MaHN,TenHN,Loai,convert(int,tongsoluong),tbHangNhap.dongia";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Kho kho = new Kho();
                kho.setMahn(rs.getString(1));
                kho.setTenhn(rs.getString(2));
                kho.setLoai(rs.getString(3));
                kho.setSoluong(rs.getString(4));
                kho.setDongia(rs.getString(5));
                list.add(kho);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
}
