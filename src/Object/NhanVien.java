/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.util.Date;

/**
 *
 * @author Phuong Thang
 */
public class NhanVien {

    public NhanVien() {
    }

    public NhanVien(String Manv, String Hoten, String Gioitinh, String Quequan, Date NgaySinh, String Sdt) {
        this.Manv = Manv;
        this.Hoten = Hoten;
        this.Gioitinh = Gioitinh;
        this.Quequan = Quequan;
        this.NgaySinh = NgaySinh;
        this.Sdt = Sdt;
    }

    public String getManv() {
        return Manv;
    }

    public void setManv(String Manv) {
        this.Manv = Manv;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(String Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public String getQuequan() {
        return Quequan;
    }

    public void setQuequan(String Quequan) {
        this.Quequan = Quequan;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }
    String Manv;
    String Hoten;
    String Gioitinh;
    String Quequan;
    Date NgaySinh;
    String Sdt;
    
}
