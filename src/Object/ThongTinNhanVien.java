/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author Phuong Thang
 */
public class ThongTinNhanVien {

    public ThongTinNhanVien() {
    }

    public ThongTinNhanVien(String manhanvien, String hoten) {
        this.manhanvien = manhanvien;
        this.hoten = hoten;
    }

    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
    String manhanvien;
    String hoten;
}
