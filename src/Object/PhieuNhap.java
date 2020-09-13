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
public class PhieuNhap {

    public PhieuNhap() {
    }

    public PhieuNhap(String mapn, Date ngaynhap, String tiennhap, String manv, String tennv, String mahn, String tenhn, String soluong, String dongia) {
        this.mapn = mapn;
        this.ngaynhap = ngaynhap;
        this.tiennhap = tiennhap;
        this.manv = manv;
        this.tennv = tennv;
        this.mahn = mahn;
        this.tenhn = tenhn;
        this.soluong = soluong;
        this.dongia = dongia;
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

    public String getTiennhap() {
        return tiennhap;
    }

    public void setTiennhap(String tiennhap) {
        this.tiennhap = tiennhap;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getMahn() {
        return mahn;
    }

    public void setMahn(String mahn) {
        this.mahn = mahn;
    }

    public String getTenhn() {
        return tenhn;
    }

    public void setTenhn(String tenhn) {
        this.tenhn = tenhn;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }
    String mapn;
    Date ngaynhap;
    String tiennhap;
    String manv;
    String tennv;
    String mahn;
    String tenhn;
    String soluong;
    String dongia;
}
