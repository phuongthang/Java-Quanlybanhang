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
public class MatHang {

    public MatHang() {
    }

    public MatHang(String mahangnhap, String tenmathang, String mota, String loai, String dongia) {
        this.mahangnhap = mahangnhap;
        this.tenmathang = tenmathang;
        this.mota = mota;
        this.loai = loai;
        this.dongia = dongia;
    }

    public String getMahangnhap() {
        return mahangnhap;
    }

    public void setMahangnhap(String mahangnhap) {
        this.mahangnhap = mahangnhap;
    }

    public String getTenmathang() {
        return tenmathang;
    }

    public void setTenmathang(String tenmathang) {
        this.tenmathang = tenmathang;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
    private String mahangnhap;
    private String tenmathang;
    private String mota;
    private String loai;

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }
    String dongia;
}
