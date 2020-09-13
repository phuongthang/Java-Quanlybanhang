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
public class ChiTietHoaDon {

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String mahd, Date ngayban, String nhanvien, String tienban,String giamgia,String thanhtien) {
        this.mahd = mahd;
        this.ngayban = ngayban;
        this.nhanvien = nhanvien;
        this.tienban = tienban;
        this.giamgia = giamgia;
        this.thanhtien = thanhtien;
        
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public Date getNgayban() {
        return ngayban;
    }

    public void setNgayban(Date ngayban) {
        this.ngayban = ngayban;
    }

    public String getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(String nhanvien) {
        this.nhanvien = nhanvien;
    }

    public String getTienban() {
        return tienban;
    }

    public void setTienban(String tienban) {
        this.tienban = tienban;
    }
    String mahd;
    Date ngayban;
    String nhanvien;
    String tienban;

    public String getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(String giamgia) {
        this.giamgia = giamgia;
    }

    public String getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(String thanhtien) {
        this.thanhtien = thanhtien;
    }
    String giamgia;
    String thanhtien;
}
