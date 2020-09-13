/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Object.NCC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Phuong Thang
 */
public class DAO_NCC {
   private Connection conn;
    public DAO_NCC()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DAO_Connection.url
                    + DAO_Connection.username + DAO_Connection.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<NCC> getListNCC(){
        ArrayList<NCC> list = new ArrayList<>();
        String querry = "SELECT * FROM TbNCC";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                NCC ncc = new NCC();
                ncc.setMancc(rs.getString(1));
                ncc.setTenncc(rs.getString(2));
                ncc.setDiachi(rs.getString(3));
                ncc.setSdt(rs.getString(4));
                list.add(ncc);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    public boolean addNCC(NCC ncc)
    {
        String querry = "INSERT INTO tbNCC(MaNCC,TenNCC,DiaChi,SDT) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ps.setString(1, ncc.getMancc() );
            ps.setString(2, ncc.getTenncc());
            ps.setString(3, ncc.getDiachi());
            ps.setString(4, ncc.getSdt());
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateNCC(NCC ncc)
    {
        String querry = "UPDATE tbNCC SET MaNCC=?, TenNCC =?, DiaChi = ?,SDT =? WHERE MaNCC = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ps.setString(1, ncc.getMancc());
            ps.setString(2, ncc.getTenncc());
            ps.setString(3, ncc.getDiachi());
            ps.setString(4, ncc.getSdt());
            ps.setString(5, ncc.getMancc());
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteNCC(String mancc)
    {
        String querry = "DELETE FROM tbNCC WHERE MaNCC='"+mancc+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<NCC> findNCC(String truyvan){
        ArrayList<NCC> list = new ArrayList<>();
        String querry = "SELECT * FROM TbNCC WHERE MANCC = '"+truyvan+"' OR TENNCC LIKE N'%"+truyvan+"%' OR DiaChi LIKE N'%"+truyvan+"%'";
        try {
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                NCC ncc = new NCC();
                ncc.setMancc(rs.getString(1));
                ncc.setTenncc(rs.getString(2));
                ncc.setDiachi(rs.getString(3));
                ncc.setSdt(rs.getString(4));
                list.add(ncc);
                
            }
        } catch (Exception e) {
        }
        return list;
    } 
}
