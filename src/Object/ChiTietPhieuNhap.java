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
public class ChiTietPhieuNhap {

    public ChiTietPhieuNhap() {
    }

    public ChiTietPhieuNhap(String mapn, Date ngaynhap, String nhanvien, String tienban) {
        this.mapn = mapn;
        this.ngaynhap = ngaynhap;
        this.nhanvien = nhanvien;
        this.tienban = tienban;
    }

    public String getMapn() {
        return mapn;
    }

    public void setMapn(String mapn) {
        this.mapn = mapn;
    }

    public Date getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(Date ngaynhap) {
        this.ngaynhap = ngaynhap;
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
    String mapn;
    Date ngaynhap;
    String nhanvien;
    String tienban;
}
