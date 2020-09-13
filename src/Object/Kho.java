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
public class Kho {

    public Kho() {
    }

    public Kho(String mahn, String tenhn, String loai, String soluong, String dongia) {
        this.mahn = mahn;
        this.tenhn = tenhn;
        this.loai = loai;
        this.soluong = soluong;
        this.dongia = dongia;
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

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
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
    String mahn;
    String tenhn;
    String loai;
    String soluong;
    String dongia;
}
