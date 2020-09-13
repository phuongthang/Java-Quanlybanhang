/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_quanly;

import Controller.DAO_HoaDon;
import Controller.DAO_Mathang;
import Controller.DAO_ThongKe;
import Controller.DAO_Thongtinmathang;
import Object.BieuDo;
import Object.MatHang;
import Object.ThongTinMatHang;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Phuong Thang
 */
public class fBieuDo extends javax.swing.JFrame {

    ArrayList<BieuDo> list = new ArrayList<>();
    ArrayList<MatHang> listMH = new ArrayList<>();
    ArrayList<ThongTinMatHang> listMatHang = new ArrayList<>();
    ArrayList<ThongTinMatHang> listMatHangLoai = new ArrayList<>();
    ArrayList<String> loaiMH = new ArrayList<>();
    DefaultTableModel model;
    int comboLoaiIndex;
    int indexcbLuaChon = 0;
    public fBieuDo() {
        initComponents();
        model = (DefaultTableModel) tableMatHang.getModel();
        getDate();
        getCombobox();
        getData();
        cbMaMH.setEnabled(false);
        cbTenMH.setEnabled(false);
        
    }
    public final void getDate()
    {
        txtnowDay.setEditable(false);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");                                                                                           
        txtnowDay.setText(sdf.format(date));
        String[] a = txtnowDay.getText().split("/");
        cbNgay.setSelectedIndex(Integer.parseInt(a[0])-1);
        cbThang.setSelectedIndex(Integer.parseInt(a[1])-2);
        
        cbNgay1.setSelectedIndex(Integer.parseInt(a[0])-1);
        cbThang1.setSelectedIndex(Integer.parseInt(a[1])-1);
    }
    public final void getData()
    {
        model.setNumRows(0);
        listMH = new DAO_Mathang().getListMHN();
        int i = 1;
        for(MatHang obj:listMH)
        {
            model.addRow(new Object[]{
            i++, obj.getMahangnhap(),obj.getTenmathang(),obj.getLoai()
            });
        }
        
    }
    public void LoadChartDoanhThu()
    {
        String dayStart = cbNgay.getItemAt(cbNgay.getSelectedIndex());
        String monthStart = cbThang.getItemAt(cbThang.getSelectedIndex());
        String yearStart = cbNam.getItemAt(cbNam.getSelectedIndex());
        
        String dayEnd = cbNgay1.getItemAt(cbNgay1.getSelectedIndex());
        String monthEnd = cbThang1.getItemAt(cbThang1.getSelectedIndex());
        String yearEnd = cbNam1.getItemAt(cbNam1.getSelectedIndex());
        
        String start = yearStart + "-" + monthStart + "-" +dayStart;
        String end = yearEnd + "-" + monthEnd + "-" +dayEnd;
        
        String ngayStart = dayStart +"/"+ monthStart;
        String ngayEnd = dayEnd +"/"+monthEnd;
        list = new DAO_ThongKe().getListBieuDo(start, end);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(BieuDo obj:list)
        {
            String[] a = obj.getNgayban().split("-");
            String ngayban = a[2] + "/" + a[1];
            dataset.addValue(Integer.parseInt(obj.getThanhtien()), "Doanh thu", ngayban);
        }
        
        
        JFreeChart jChart = ChartFactory.createLineChart(
                "BIỂU ĐỒ DOANH THU CỬA HÀNG TỪ "+ngayStart+" ĐẾN " +ngayEnd,
                "Năm 2020", "Doanh thu",
                dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot plot = jChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        ChartFrame chart = new ChartFrame("Biểu Đồ Doanh Thu",jChart,false);
        chart.setSize(1200,500);
        chart.setLocationRelativeTo(null);
        
        chart.setVisible(true);
        ChartPanel chartPanel = new ChartPanel(jChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 400));
        
    }
    public void LoadChartMatHang(String mamh,String tenmh)
    {
        String dayStart = cbNgay.getItemAt(cbNgay.getSelectedIndex());
        String monthStart = cbThang.getItemAt(cbThang.getSelectedIndex());
        String yearStart = cbNam.getItemAt(cbNam.getSelectedIndex());
        
        String dayEnd = cbNgay1.getItemAt(cbNgay1.getSelectedIndex());
        String monthEnd = cbThang1.getItemAt(cbThang1.getSelectedIndex());
        String yearEnd = cbNam1.getItemAt(cbNam1.getSelectedIndex());
        
        String start = yearStart + "-" + monthStart + "-" +dayStart;
        String end = yearEnd + "-" + monthEnd + "-" +dayEnd;
        
        String ngayStart = dayStart +"/"+ monthStart;
        String ngayEnd = dayEnd +"/"+monthEnd;
        list = new DAO_ThongKe().getListBieuDoMaMH(start, end, mamh);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(BieuDo obj:list)
        {
            String[] a = obj.getNgayban().split("-");
            String ngayban = a[2] + "/" + a[1];
            dataset.addValue(Integer.parseInt(obj.getThanhtien()), "Doanh thu", ngayban);
        }
        
        
        JFreeChart jChart = ChartFactory.createLineChart(
                "BIỂU ĐỒ DOANH THU CỦA MẶT HÀNG "+tenmh+" TỪ "+ngayStart+" ĐẾN " +ngayEnd,
                "Năm 2020", "Doanh thu",
                dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot plot = jChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        ChartFrame chart = new ChartFrame("Biểu Đồ Doanh Thu Mặt Hàng",jChart,false);
        chart.setSize(1200,500);
        chart.setLocationRelativeTo(null);
        
        chart.setVisible(true);
        ChartPanel chartPanel = new ChartPanel(jChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 400));
        
    }
    public void LoadForm()
    {
        this.setVisible(false);
        fBieuDo fChart = new fBieuDo();
        fChart.setLocationRelativeTo(null);
        fChart.setVisible(true);
    }
    public final void getCombobox()
    {
        cbLoai.addItem("Tất cả");
        loaiMH = new DAO_HoaDon().getLoaiMH();
        for(String i:loaiMH)
        {
            cbLoai.addItem(i);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnowDay = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbNgay = new javax.swing.JComboBox<>();
        cbThang = new javax.swing.JComboBox<>();
        cbNam = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbNgay1 = new javax.swing.JComboBox<>();
        cbThang1 = new javax.swing.JComboBox<>();
        cbNam1 = new javax.swing.JComboBox<>();
        btnXem = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        cbLuaChon = new javax.swing.JComboBox<>();
        cbMaMH = new javax.swing.JComboBox<>();
        cbTenMH = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        cbLoai = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMatHang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thống Kê Doanh Thu");

        jPanel1.setBackground(new java.awt.Color(52, 73, 94));

        jPanel2.setBackground(new java.awt.Color(230, 136, 24));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/desura-icon (2).png"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Phương Thắng Store");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Thống Kê Doanh Thu");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/App-chart-icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel21))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel20)))
                .addGap(224, 224, 224)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtnowDay.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtnowDay.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/calendar (1).png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Thời gian :");

        cbNgay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbNgay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cbThang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        cbNam.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("đến");

        cbNgay1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbNgay1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cbThang1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbThang1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        cbNam1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbNam1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031" }));

        btnXem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/views.png"))); // NOI18N
        btnXem.setText("Xem");
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
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

        cbLuaChon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbLuaChon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Doanh thu", "Mặt hàng" }));
        cbLuaChon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLuaChonItemStateChanged(evt);
            }
        });

        cbMaMH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbMaMH.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMaMHItemStateChanged(evt);
            }
        });

        cbTenMH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbTenMH.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTenMHItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tìm kiếm :");

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        cbLoai.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbLoai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLoaiItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Loại :");

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/views.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tableMatHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã mặt hàng", "Tên mặt hàng", "Loại"
            }
        ));
        tableMatHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMatHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMatHang);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(458, 458, 458)
                        .addComponent(txtnowDay, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbNgay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbThang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbNam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbLuaChon, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTimKiem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(cbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(cbTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThoat)
                            .addComponent(btnXem, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtnowDay, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbNgay1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbThang1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNam1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbLuaChon, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXem)
                    .addComponent(cbTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed

        indexcbLuaChon = cbLuaChon.getSelectedIndex();
        if(indexcbLuaChon == 0)
        {
            LoadChartDoanhThu();
        }
        else if(indexcbLuaChon==1)
        {
            String manh = cbMaMH.getItemAt(cbMaMH.getSelectedIndex());
            String tenmh = cbTenMH.getItemAt(cbTenMH.getSelectedIndex());
            LoadChartMatHang(manh,tenmh);
        }
        
    }//GEN-LAST:event_btnXemActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.setVisible(false);
        fHeThong hethong = new fHeThong();
        hethong.setLocationRelativeTo(null);
        hethong.setVisible(true);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String truyvan = txtTimKiem.getText();
        listMH = new DAO_Mathang().findMHN(truyvan);
        model.setNumRows(0);
        int i = 1;
        for(MatHang obj:listMH)
        {
            model.addRow(new Object[]{
            i++, obj.getMahangnhap(),obj.getTenmathang(),obj.getLoai()
            });
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void cbMaMHItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMaMHItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED)
        {
            if(comboLoaiIndex==0)
            {
                int index = cbMaMH.getSelectedIndex();
                ThongTinMatHang obj = listMatHang.get(index);
                cbTenMH.setSelectedItem(obj.getTenhang());
            }
            else
            {
                int index = cbMaMH.getSelectedIndex();
                ThongTinMatHang obj = listMatHangLoai.get(index);
                cbTenMH.setSelectedItem(obj.getTenhang());
            }

            
            
        }
    }//GEN-LAST:event_cbMaMHItemStateChanged

    private void cbTenMHItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTenMHItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED)
        {
            if(comboLoaiIndex == 0)
            {
                
                int index = cbTenMH.getSelectedIndex();
                ThongTinMatHang obj = listMatHang.get(index);
                cbMaMH.setSelectedItem(obj.getMahang());
            }
            else
            {
                int index = cbTenMH.getSelectedIndex();
                ThongTinMatHang obj = listMatHangLoai.get(index);
                cbMaMH.setSelectedItem(obj.getMahang());
            }
            
            
            
        }
    }//GEN-LAST:event_cbTenMHItemStateChanged

    private void cbLoaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLoaiItemStateChanged
        comboLoaiIndex = cbLoai.getSelectedIndex();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
            if(comboLoaiIndex == 0)
            {
                cbMaMH.removeAllItems();
                cbTenMH.removeAllItems();
                listMatHang = new DAO_Thongtinmathang().getInforMatHang();
                for(ThongTinMatHang obj : listMatHang)
                {
                    cbMaMH.addItem(obj.getMahang());
                    cbTenMH.addItem(obj.getTenhang());
                }
                
            }
            else if(comboLoaiIndex !=0)
            {
                cbMaMH.removeAllItems();
                cbTenMH.removeAllItems();
                String loai = cbLoai.getItemAt(cbLoai.getSelectedIndex());
                listMatHangLoai = new DAO_Thongtinmathang().getInforMatHangLoai(loai);
                for(ThongTinMatHang obj1 : listMatHangLoai)
                {
                    cbMaMH.addItem(obj1.getMahang());
                    cbTenMH.addItem(obj1.getTenhang());
                }
               
            }
    }//GEN-LAST:event_cbLoaiItemStateChanged

    private void tableMatHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMatHangMouseClicked
        int id = tableMatHang.getSelectedRow();
        if(id>=0)
        {
            String mamh = (String) model.getValueAt(id, 1);
            String tenmh = (String) model.getValueAt(id, 2);
            LoadChartMatHang(mamh, tenmh);
        }
    }//GEN-LAST:event_tableMatHangMouseClicked

    private void cbLuaChonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLuaChonItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED)
        {
            indexcbLuaChon = cbLuaChon.getSelectedIndex();
            if(indexcbLuaChon==0)
            {
                cbMaMH.setEnabled(false);
                cbTenMH.setEnabled(false);
            }
            else if(indexcbLuaChon==1)
            {
                cbMaMH.setEnabled(true);
                cbTenMH.setEnabled(true);
            }
        }
    }//GEN-LAST:event_cbLuaChonItemStateChanged

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
            java.util.logging.Logger.getLogger(fBieuDo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fBieuDo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fBieuDo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fBieuDo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fBieuDo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXem;
    private javax.swing.JComboBox<String> cbLoai;
    private javax.swing.JComboBox<String> cbLuaChon;
    private javax.swing.JComboBox<String> cbMaMH;
    private javax.swing.JComboBox<String> cbNam;
    private javax.swing.JComboBox<String> cbNam1;
    private javax.swing.JComboBox<String> cbNgay;
    private javax.swing.JComboBox<String> cbNgay1;
    private javax.swing.JComboBox<String> cbTenMH;
    private javax.swing.JComboBox<String> cbThang;
    private javax.swing.JComboBox<String> cbThang1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMatHang;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtnowDay;
    // End of variables declaration//GEN-END:variables
}
