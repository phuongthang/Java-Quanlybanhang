/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_quanly;

import Controller.DAO_ChiTietHD;
import Controller.DAO_ChiTietPN;
import Controller.DAO_Connection;
import Controller.DAO_HoaDon;
import Controller.DAO_Thongtinmathang;
import Controller.DAO_Thongtinnhanvien;
import Object.HoaDon;
import Object.ThongTinMatHang;
import Object.ThongTinNhanVien;
import java.awt.event.ItemEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Phuong Thang
 */
public class fHoaDon extends javax.swing.JFrame {
    ArrayList<ThongTinNhanVien> listInforNhanVien = new ArrayList<>();
    ArrayList<ThongTinMatHang> listMatHang = new ArrayList<>();
    ArrayList<ThongTinMatHang> listMatHangLoai = new ArrayList<>();
    ArrayList<HoaDon> list = new ArrayList<>();
    ArrayList<String> loaiMH = new ArrayList<>();
    public static String mahoadon;
    public static  String tenkhachhang;
    public static String tongtienban;
    DefaultTableModel model;
    int dem = 1;
    int thanhtien = 0;
    int id;
    int soluongcu;
    int comboboxSelected;
    boolean checked = false;
    int comboLoaiIndex;
    public fHoaDon() {
        initComponents();
        model = (DefaultTableModel) tableCTHD.getModel();
        resize();
        getCombobox();
        getDate();
        Enable(false);
        long now = Instant.now().toEpochMilli();
        txtMaHD.setText("HD"+String.valueOf(now));
        txtMaHD.setEditable(false);
        txtTongtien.setEditable(false);
        txtMaKH.setEditable(false);
        txtDongia.setEditable(false);
        Soluong.setValue(1);
        listMatHang = new DAO_Thongtinmathang().getInforMatHang();
        btnThanhtoan.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnLamMoi.setEnabled(false);
        
    }
    public final void resize()
    {
        tableCTHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
        tableCTHD.getColumnModel().getColumn(0).setPreferredWidth(45);
        tableCTHD.getColumnModel().getColumn(1).setPreferredWidth(120);
        tableCTHD.getColumnModel().getColumn(2).setPreferredWidth(100);
        tableCTHD.getColumnModel().getColumn(3).setPreferredWidth(140);
        tableCTHD.getColumnModel().getColumn(4).setPreferredWidth(120);
        tableCTHD.getColumnModel().getColumn(5).setPreferredWidth(140);
        tableCTHD.getColumnModel().getColumn(6).setPreferredWidth(120);
        tableCTHD.getColumnModel().getColumn(7).setPreferredWidth(120);
        tableCTHD.getColumnModel().getColumn(8).setPreferredWidth(120);
        tableCTHD.getColumnModel().getColumn(9).setPreferredWidth(120);
        tableCTHD.getColumnModel().getColumn(10).setPreferredWidth(120);
        tableCTHD.getColumnModel().getColumn(11).setPreferredWidth(120);
        
    }
    public final void getCombobox()
    {
        listInforNhanVien = new DAO_Thongtinnhanvien().getInforNhanVien();
        for(ThongTinNhanVien obj:listInforNhanVien)
        {
            cbNhanVien.addItem(obj.getHoten());
        }
        cbLoaiMH.addItem("Tất cả");
        loaiMH = new DAO_HoaDon().getLoaiMH();
        for(String i:loaiMH)
        {
            cbLoaiMH.addItem(i);
        }
    }
    public final void Enable(boolean check)
    {
        txtMaKH.setEditable(check);
        txtTenKH.setEditable(check);
        txtDiaChi.setEditable(check);
        txtSDT.setEditable(check);
        cbMaHang.setEnabled(check);
        cbTenMH.setEnabled(check);
        Soluong.setEnabled(check);
        btnThem.setEnabled(check);
        
    }
    public final void getDate()
    {
        txtNgayBan.setEditable(false);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");                                                                                           
        txtNgayBan.setText(sdf.format(date));
    }
    public void getData()
    {
        model.setNumRows(0);
        String mahd = txtMaHD.getText();
        list = new DAO_HoaDon().getListHoaDon(mahd);
        
        int i = 1;
            for(HoaDon object:list)
            {
            model.addRow(new Object[]{
            i++, object.getMahd(), object.getNgayban(), object.getTennv(), object.getTenkh(), object.getDiachi(),object.getSdt(),object.getMamh(),object.getTenmh(),object.getSoluong(),object.getDongia(),String.format("%,.0f",Double.parseDouble(object.getSoluong())*Double.parseDouble(object.getDongia())).replace(",", ".")
            });
            }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNgayBan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbNhanVien = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCTHD = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtTongtien = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbTenMH = new javax.swing.JComboBox<>();
        cbMaHang = new javax.swing.JComboBox<>();
        Soluong = new javax.swing.JSpinner();
        txtDongia = new javax.swing.JTextField();
        btnLamMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThemHoaDon = new javax.swing.JButton();
        btnTao = new javax.swing.JButton();
        btnThanhtoan = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        cbLoaiMH = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chi Tiết Hóa Đơn");

        jPanel1.setBackground(new java.awt.Color(52, 73, 94));

        jPanel2.setBackground(new java.awt.Color(230, 136, 24));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 38)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Chi Tiết Hóa Đơn");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/invoice.png"))); // NOI18N

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/desura-icon (2).png"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Phương Thắng Store");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel19)
                        .addGap(366, 366, 366)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)))
                .addContainerGap(528, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel14)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã hóa đơn :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ngày bán :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nhân viên :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mã khách hàng :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tên khách hàng :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Địa chỉ :");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane1.setViewportView(txtDiaChi);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Số điện thoại :");

        tableCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hóa đơn", "Ngày bán", "Nhân viên", "Khách hàng", "Địa chỉ", "Số điện thoại", "Mã mặt hàng", "Tên mặt hàng", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        tableCTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCTHDMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableCTHD);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tổng tiền :");

        txtTongtien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTongtien.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTongtien.setText("0");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Mã mặt hàng :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tên mặt hàng :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Số lượng :");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Đơn giá :");

        cbTenMH.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTenMHItemStateChanged(evt);
            }
        });

        cbMaHang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMaHangItemStateChanged(evt);
            }
        });

        Soluong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtDongia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDongia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btnLamMoi.setBackground(new java.awt.Color(52, 152, 219));
        btnLamMoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btnLamMoi.setText("Nhập tiếp");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(46, 204, 113));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(155, 89, 182));
        btnSua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/running_process.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(231, 76, 60));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThemHoaDon.setBackground(new java.awt.Color(34, 166, 179));
        btnThemHoaDon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnThemHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnThemHoaDon.setText("Thêm hóa đơn");
        btnThemHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHoaDonActionPerformed(evt);
            }
        });

        btnTao.setBackground(new java.awt.Color(46, 204, 113));
        btnTao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTao.setForeground(new java.awt.Color(255, 255, 255));
        btnTao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnTao.setText("Tạo");
        btnTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoActionPerformed(evt);
            }
        });

        btnThanhtoan.setBackground(new java.awt.Color(249, 202, 36));
        btnThanhtoan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThanhtoan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhtoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bill.png"))); // NOI18N
        btnThanhtoan.setText("Thanh toán");
        btnThanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhtoanActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/out.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        cbLoaiMH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbLoaiMH.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLoaiMHItemStateChanged(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Loại :");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("đồng");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("đồng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThemHoaDon))
                    .addComponent(txtTongtien, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgayBan, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel4))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenKH)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(txtMaKH)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(36, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtDongia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addGap(131, 131, 131))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbMaHang, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbTenMH, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbLoaiMH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThanhtoan))
                                .addGap(22, 22, 22))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel6))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtNgayBan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(cbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnTao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThemHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(cbMaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(cbTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbLoaiMH, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(btnThanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(107, 107, 107)))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtDongia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        Soluong.setValue(1); 
        btnThem.setEnabled(true);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        cbMaHang.setEnabled(true);
        cbTenMH.setEnabled(true);
        btnLamMoi.setEnabled(false);
        cbLoaiMH.setEnabled(true);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        
        
        HoaDon hoadon = new HoaDon();
        hoadon.setMahd(txtMaHD.getText());
        listInforNhanVien = new DAO_Thongtinnhanvien().getInforNhanVien();
        int index = cbNhanVien.getSelectedIndex();
        ThongTinNhanVien obj = listInforNhanVien.get(index);
        hoadon.setManv(obj.getManhanvien());
        hoadon.setTennv(cbNhanVien.getItemAt(cbNhanVien.getSelectedIndex()));
        hoadon.setMakh(txtMaKH.getText());
        hoadon.setTenkh(txtTenKH.getText());
        hoadon.setDiachi(txtDiaChi.getText());
        hoadon.setSdt(txtSDT.getText());
        hoadon.setMamh(cbMaHang.getItemAt(cbMaHang.getSelectedIndex()));
        hoadon.setTenmh(cbTenMH.getItemAt(cbTenMH.getSelectedIndex()));
        int soluong = Integer.parseInt(Soluong.getValue().toString());
        hoadon.setSoluong(String.valueOf(soluong));
        try {
            hoadon.setNgayban(new SimpleDateFormat("dd/MM/yyyy").parse(txtNgayBan.getText()));
        } catch (ParseException ex) {
        }
        int dongia = Integer.parseInt(txtDongia.getText());
        hoadon.setDongia(txtDongia.getText());
        list.add(hoadon);
        if(new DAO_HoaDon().addChiTietHD(hoadon) && new DAO_HoaDon().updateKhachHang(hoadon))
        {
            int tienban = dongia * soluong;
        thanhtien += tienban;
        String text = String.valueOf(thanhtien);
        txtTongtien.setText(text);
        hoadon.setTienban(String.valueOf(tienban));
        
        String soluongdaco = new DAO_ChiTietPN().SoluongTon(cbMaHang.getItemAt(cbMaHang.getSelectedIndex()));
        String soluongban = new DAO_ChiTietHD().SoluongBan(cbMaHang.getItemAt(cbMaHang.getSelectedIndex()));
        int soluongconlai = Integer.parseInt(soluongdaco) - Integer.parseInt(soluongban);
        new DAO_ChiTietPN().updateHangNhap(String.valueOf(soluongconlai), cbMaHang.getItemAt(cbMaHang.getSelectedIndex()));
        getData();
        btnThanhtoan.setEnabled(true);
        btnThem.setEnabled(false);
        btnLamMoi.setEnabled(true);
        }
        
        
        
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        HoaDon hoadon = new HoaDon();
        hoadon.setMahd(txtMaHD.getText());
        listInforNhanVien = new DAO_Thongtinnhanvien().getInforNhanVien();
        int index = cbNhanVien.getSelectedIndex();
        ThongTinNhanVien obj = listInforNhanVien.get(index);
        hoadon.setManv(obj.getManhanvien());
        hoadon.setTennv(cbNhanVien.getItemAt(cbNhanVien.getSelectedIndex()));
        hoadon.setMakh(txtMaKH.getText());
        hoadon.setTenkh(txtTenKH.getText());
        hoadon.setDiachi(txtDiaChi.getText());
        hoadon.setSdt(txtSDT.getText());
        comboboxSelected = cbMaHang.getSelectedIndex();
        hoadon.setMamh(cbMaHang.getItemAt(cbMaHang.getSelectedIndex()));
        hoadon.setTenmh(cbTenMH.getItemAt(cbTenMH.getSelectedIndex()));
        int soluong = Integer.parseInt(Soluong.getValue().toString());
        hoadon.setSoluong(String.valueOf(soluong));
        try {
            hoadon.setNgayban(new SimpleDateFormat("dd/MM/yyyy").parse(txtNgayBan.getText()));
        } catch (ParseException ex) {
        }
        int dongia = Integer.parseInt(txtDongia.getText());
        hoadon.setDongia(txtDongia.getText());
        list.add(hoadon);
        if(new DAO_HoaDon().updateChiTietHD(hoadon) && new DAO_HoaDon().updateKhachHang(hoadon))
        {
            thanhtien = thanhtien - (soluongcu*dongia);
            int tienban = dongia * soluong;
            thanhtien += tienban;
            String text = String.valueOf(thanhtien);
            txtTongtien.setText(text);
            hoadon.setTienban(String.valueOf(tienban));
            String soluongdaco = new DAO_ChiTietPN().SoluongTon(cbMaHang.getItemAt(cbMaHang.getSelectedIndex()));
            String soluongban = new DAO_ChiTietHD().SoluongBan(cbMaHang.getItemAt(cbMaHang.getSelectedIndex()));
            int soluongconlai = Integer.parseInt(soluongdaco) - Integer.parseInt(soluongban);
            new DAO_ChiTietPN().updateHangNhap(String.valueOf(soluongconlai), cbMaHang.getItemAt(cbMaHang.getSelectedIndex()));
            getData();
            btnSua.setEnabled(false);
            btnXoa.setEnabled(false);
            btnThem.setEnabled(false);
            btnLamMoi.setEnabled(true);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int result = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn xóa không","Question",JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION)
        {
            String mahd = txtMaHD.getText();
            String mahn = cbMaHang.getItemAt(cbMaHang.getSelectedIndex());
            if(new DAO_HoaDon().deleteChiTietHD(mahd, mahn))
            {
                int dongia = Integer.parseInt(txtDongia.getText());
                thanhtien = thanhtien - soluongcu* dongia;
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công !","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                String soluongdaco = new DAO_ChiTietPN().SoluongTon(cbMaHang.getItemAt(cbMaHang.getSelectedIndex()));
                String soluongban = new DAO_ChiTietHD().SoluongBan(cbMaHang.getItemAt(cbMaHang.getSelectedIndex()));
                int soluongconlai = Integer.parseInt(soluongdaco) - Integer.parseInt(soluongban);
                new DAO_ChiTietPN().updateHangNhap(String.valueOf(soluongconlai), cbMaHang.getItemAt(cbMaHang.getSelectedIndex()));
                getData();
                String text = String.valueOf(thanhtien);
                txtTongtien.setText(text);
                btnSua.setEnabled(false);
                btnXoa.setEnabled(false);
                btnThem.setEnabled(false);
                btnLamMoi.setEnabled(true);
                
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHoaDonActionPerformed

        fHoaDon hoadon = new fHoaDon();
        hoadon.setLocationRelativeTo(null);
        hoadon.setVisible(true);
    }//GEN-LAST:event_btnThemHoaDonActionPerformed

    private void btnTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoActionPerformed
        Enable(true);
        long now = Instant.now().toEpochMilli();
        txtMaKH.setText("KH"+String.valueOf(now));
        HoaDon hoadon = new HoaDon();
        hoadon.setMahd(txtMaHD.getText());
        try {
            hoadon.setNgayban(new SimpleDateFormat("dd/MM/yyyy").parse(txtNgayBan.getText()));
        } catch (ParseException ex) {
        }
        listInforNhanVien = new DAO_Thongtinnhanvien().getInforNhanVien();
        int index = cbNhanVien.getSelectedIndex();
        ThongTinNhanVien obj = listInforNhanVien.get(index);
        hoadon.setManv(obj.getManhanvien());
        hoadon.setMakh(txtMaKH.getText());
        if(new DAO_HoaDon().addKhachHang(hoadon) && new DAO_HoaDon().addHoaDon(hoadon))
        {
            btnTao.setEnabled(false);
        }
        txtMaKH.setEditable(false);

    }//GEN-LAST:event_btnTaoActionPerformed
    
    private void btnThanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhtoanActionPerformed
        mahoadon = txtMaHD.getText();
        tenkhachhang = txtTenKH.getText();
        tongtienban = txtTongtien.getText();
        if(new DAO_HoaDon().updateTienBan(txtTongtien.getText(), txtMaHD.getText()))
        {
            checked = true;
            this.setVisible(false);
            fThanhToan thanhtoan = new fThanhToan();
            thanhtoan.setLocationRelativeTo(null);
            thanhtoan.setVisible(true);
        }
        
        
    }//GEN-LAST:event_btnThanhtoanActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        
        if(checked)
        {
            this.setVisible(false);
            fHeThong hethong = new fHeThong();
            hethong.setLocationRelativeTo(null);
            hethong.setVisible(true);
        }
        else
        {
            int result = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn thoát không. Mọi thông tin sẽ không được lưu lại","Question",JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION)
            {
                String mahd = txtMaHD.getText();
                String makh = txtMaKH.getText();
                if(new DAO_HoaDon().deleteCTHD(mahd))
                {
                    if(new DAO_HoaDon().deleteHD(mahd) && new DAO_HoaDon().deleteKhachHang(makh))
                    {
                        this.setVisible(false);
                        fHeThong hethong = new fHeThong();
                        hethong.setLocationRelativeTo(null);
                        hethong.setVisible(true);
                    }
                }
                else
                {
                    this.setVisible(false);
                    fHeThong hethong = new fHeThong();
                    hethong.setLocationRelativeTo(null);
                    hethong.setVisible(true);
                }
            }
        }
        
    }//GEN-LAST:event_btnThoatActionPerformed

    private void cbMaHangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMaHangItemStateChanged
        
        
        if(evt.getStateChange()==ItemEvent.SELECTED)
        {
            if(comboLoaiIndex==0)
            {
                int index = cbMaHang.getSelectedIndex();
                ThongTinMatHang obj = listMatHang.get(index);
                cbTenMH.setSelectedItem(obj.getTenhang());
                int Dongia = Integer.parseInt(obj.getDongia());
                Dongia = Dongia + ((Dongia * 50)/100);
                txtDongia.setText(String.valueOf(Dongia));
            }
            else
            {
                int index = cbMaHang.getSelectedIndex();
                ThongTinMatHang obj = listMatHangLoai.get(index);
                cbTenMH.setSelectedItem(obj.getTenhang());
                int Dongia = Integer.parseInt(obj.getDongia());
                Dongia = Dongia + ((Dongia * 50)/100);
                txtDongia.setText(String.valueOf(Dongia));
            }

            
            
        }
    }//GEN-LAST:event_cbMaHangItemStateChanged

    private void cbTenMHItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTenMHItemStateChanged
        
        if(evt.getStateChange()==ItemEvent.SELECTED)
        {
            if(comboLoaiIndex == 0)
            {
                
                int index = cbTenMH.getSelectedIndex();
                ThongTinMatHang obj = listMatHang.get(index);
                cbMaHang.setSelectedItem(obj.getMahang());
                int Dongia = Integer.parseInt(obj.getDongia());
                Dongia = Dongia + ((Dongia * 50)/100);
                txtDongia.setText(String.valueOf(Dongia));
            }
            else
            {
                int index = cbTenMH.getSelectedIndex();
                ThongTinMatHang obj = listMatHangLoai.get(index);
                cbMaHang.setSelectedItem(obj.getMahang());
                int Dongia = Integer.parseInt(obj.getDongia());
                Dongia = Dongia + ((Dongia * 50)/100);
                txtDongia.setText(String.valueOf(Dongia));
            }
            
            
            
        }
    }//GEN-LAST:event_cbTenMHItemStateChanged

    private void tableCTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCTHDMouseClicked
        id = tableCTHD.getSelectedRow();
        if(id>=0)
        {
            cbLoaiMH.setSelectedIndex(0);
            cbLoaiMH.setEnabled(false);
            txtTenKH.setText((String) model.getValueAt(id, 4));
            txtDiaChi.setText((String) model.getValueAt(id, 5));
            txtSDT.setText((String) model.getValueAt(id, 6));
            cbMaHang.setSelectedItem((String) model.getValueAt(id, 7));
            cbMaHang.setEnabled(false);
            
            
            cbTenMH.setSelectedItem((String) model.getValueAt(id, 8));
            cbTenMH.setEnabled(false);
            txtDongia.setText((String)model.getValueAt(id, 10));
            int value = Integer.parseInt((String) model.getValueAt(id, 9));
            soluongcu = value;
            Soluong.setValue(value);
            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);
            btnThem.setEnabled(false);
            
            
        }
    }//GEN-LAST:event_tableCTHDMouseClicked

    private void cbLoaiMHItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLoaiMHItemStateChanged
    if(evt.getStateChange()==ItemEvent.SELECTED)
        {
            comboLoaiIndex = cbLoaiMH.getSelectedIndex();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
            if(comboLoaiIndex == 0)
            {
                cbMaHang.removeAllItems();
                cbTenMH.removeAllItems();
                listMatHang = new DAO_Thongtinmathang().getInforMatHang();
                for(ThongTinMatHang obj : listMatHang)
                {
                    cbMaHang.addItem(obj.getMahang());
                    cbTenMH.addItem(obj.getTenhang());
                }
                
            }
            else if(comboLoaiIndex !=0)
            {
                cbMaHang.removeAllItems();
                cbTenMH.removeAllItems();
                String loai = cbLoaiMH.getItemAt(cbLoaiMH.getSelectedIndex());
                listMatHangLoai = new DAO_Thongtinmathang().getInforMatHangLoai(loai);
                for(ThongTinMatHang obj1 : listMatHangLoai)
                {
                    cbMaHang.addItem(obj1.getMahang());
                    cbTenMH.addItem(obj1.getTenhang());
                }
               
            }
        }
        
        
        
    }//GEN-LAST:event_cbLoaiMHItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner Soluong;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTao;
    private javax.swing.JButton btnThanhtoan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemHoaDon;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbLoaiMH;
    private javax.swing.JComboBox<String> cbMaHang;
    private javax.swing.JComboBox<String> cbNhanVien;
    private javax.swing.JComboBox<String> cbTenMH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableCTHD;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtDongia;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNgayBan;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTongtien;
    // End of variables declaration//GEN-END:variables
}
