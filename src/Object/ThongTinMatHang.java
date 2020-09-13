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
public class ThongTinMatHang {

    public ThongTinMatHang() {
    }

    public ThongTinMatHang(String mahang, String tenhang,String dongia) {
        this.mahang = mahang;
        this.tenhang = tenhang;
        this.dongia = dongia;
    }

    public String getMahang() {
        return mahang;
    }

    public void setMahang(String mahang) {
        this.mahang = mahang;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }
    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }
    String mahang;
    String tenhang;
    String dongia;
}
