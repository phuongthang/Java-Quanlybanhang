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
public class ChiTietMatHang {

    public ChiTietMatHang() {
    }

    public ChiTietMatHang(String mamh, String tenmh, String soluong, String dongia) {
        this.mamh = mamh;
        this.tenmh = tenmh;
        this.soluong = soluong;
        this.dongia = dongia;
        
    }

    public String getMamh() {
        return mamh;
    }

    public void setMamh(String mamh) {
        this.mamh = mamh;
    }

    public String getTenmh() {
        return tenmh;
    }

    public void setTenmh(String tenmh) {
        this.tenmh = tenmh;
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
    String mamh;
    String tenmh;
    String soluong;
    String dongia;
}
