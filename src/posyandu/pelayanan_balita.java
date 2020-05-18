/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package posyandu;
import java.awt.Toolkit;
import java.sql.*; 
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
import java.util.Date;
import java.util.HashMap; 
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane; 
import javax.swing.table.DefaultTableModel; 
import javax.swing.JSpinner; 
import koneksi.koneksi; 

/**
 *
 * @author Adji
 */
public class pelayanan_balita extends javax.swing.JFrame {
 public String id_balita, nama_anak, jenis_kelamin,nama_ayah,nama_ibu,tanggal_lahir,usia_anak,berat_badan,panjang_badan,rt,rw,alamat_lengkap; 
 private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    Object[] Baris = {"No Timbangan","Tanggal","ID Balita","Nama Balita","Berat Badan","Tinggi Badan","Lingkar Kepala","Z Score","Status","Imunisasi"};
 
    /**
     * Creates new form pelayanan_balita
     */
    public pelayanan_balita() {
     initComponents();
     Toolkit tk = Toolkit.getDefaultToolkit();
     int xsize = (int) tk.getScreenSize().getWidth();
     int ysize = (int) tk.getScreenSize().getHeight();
     this.setSize(xsize, ysize);
     kosong();
     aktif();
     autonumber();
    // tglLahir.setVisible(false);
    // aa.setVisible(false);
    // bb.setVisible(false);
    }

   protected void aktif(){
    jtgl.setEditor(new JSpinner.DateEditor(jtgl,"dd/MM/yyyy"));
     tabmode = new DefaultTableModel(null, Baris);
     tabledatatimbangan.setModel(tabmode);
     notimbang.setEnabled(false);
}
    
    protected void kosong (){
     idbalita1.setText("");
     nmanak1.setText("");
    
     notimbang.setText("");
     beratbadan.setText("");
     tinggibadan.setText("");
     zscore.setText("");
     status.setText("");
     tabledatatimbangan.removeAll(); 
    }
    
    protected void Hitung(){
        //String umurbulan = aa.getText();
        String bbn = beratbadan.getText();
        int beratb = Integer.parseInt(bbn);
        
        try{
            String sql = "SELECT * FROM bbu_l_a where umur_bln ='"+aa.getText()+"'";
            Statement stat = conn.createStatement();
            ResultSet rs=stat.executeQuery(sql);
        while(rs.next()){
            String med = rs.getString("median");
            double med2 = Double.parseDouble(med);
            double selisih2 = beratb-med2;
            
           // bb.setText(String.valueOf(selisih2));
            //bb.setText(String.valueOf(med2));
            
            if(beratb>med2){
                try{
            String sql2 = "SELECT * FROM bbu_l_a where umur_bln ='"+aa.getText()+"'";
            Statement stat2 = conn.createStatement();
            ResultSet rs2=stat2.executeQuery(sql2);
        while(rs2.next()){
            String sdplus = rs.getString("kg1SDplus");
            double kgplus = Double.parseDouble(sdplus);
            //double hzscore = (beratb-med2)/(med2-kgplus);
            double hzscore = (beratb-med2)/(kgplus-med2);
            DecimalFormat df = new DecimalFormat("#.##");
            String Shzscore = df.format(hzscore);
            zscore.setText(Shzscore);
                if(hzscore <= -3){
             status.setText("Gizi Buruk");
             }else if(hzscore >=-3 && hzscore<=-2){
             status.setText("Gizi Kurang");
             }else if(hzscore>=-2 && hzscore<=2){
             status.setText("Gizi Baik");
             }else if(hzscore>2){
             status.setText("Gizi Lebih");
            }
        }
                    
                }catch (Exception e){ 
        JOptionPane.showMessageDialog(null,"Data Gagal Di Ambil Pertama" + e);         
                }
            }else{
                try{
            String sql2 = "SELECT * FROM bbu_l_a where umur_bln ='"+aa.getText()+"'";
            Statement stat2 = conn.createStatement();
            ResultSet rs2=stat2.executeQuery(sql2);
        while(rs2.next()){
            String sdmin = rs.getString("kg1SDmin");
            double kgmin = Double.parseDouble(sdmin);
            double hzscore = (beratb-med2)/(med2-kgmin);
            DecimalFormat df = new DecimalFormat("#.##");
            String Shzscore = df.format(hzscore);
            zscore.setText(Shzscore);
            if(hzscore <= -3){
             status.setText("Gizi Buruk");
             }else if(hzscore >=-3 && hzscore<=-2){
             status.setText("Gizi Kurang");
             }else if(hzscore>=-2 && hzscore<=2){
             status.setText("Gizi Baik");
             }else if(hzscore>2){
             status.setText("Gizi Lebih");
            }
        }
                    
                }catch (Exception e){ 
        JOptionPane.showMessageDialog(null,"Data Gagal Di Ambil Kedua" + e);         
                }
            }
        }
            
        }catch (Exception e){ 
        JOptionPane.showMessageDialog(null,"Data Gagal Di Ambil Ketiga" + e);         
    }    
    }
    
    protected void autonumber(){ 
        try{ 
            String sql = "SELECT notimbangan FROM Pelayanan_balita order by notimbangan asc";
            Statement stat = conn.createStatement();
            ResultSet rs=stat.executeQuery(sql);
            notimbang.setText ("PB0001");
             while(rs.next()){ 
                 String notimbangan = rs.getString("notimbangan").substring(2);
                 int nomor = Integer.parseInt(notimbangan) + 1;
                 String nol = "";
                  if (nomor<10) 
                  {nol = "000";} 
                  else if (nomor<100)
                  {nol = "00";} 
                  else if (nomor<1000)
                  {nol = "0";}
                  else if (nomor<10000)
                  {nol = "";}
                  
                 
                 notimbang.setText("PB"+ nol+nomor);
        }
        }
    
     catch (Exception e){ 
        JOptionPane.showMessageDialog(null,"Penomoran Salah" + e);         
    }
    }
    
    public void itemTerpilih3(){
        popup_databalita Pp = new popup_databalita();
        Pp.balita = this;
        idbalita1.setText(id_balita);
        nmanak1.setText(nama_anak);
        nmibu1.setText(nama_ibu);
        tglLahir.setText(tanggal_lahir);
    }

       /*
        Date currentDate = new Date();
        String birthDateInString = a.getText();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	Date birthDate = null;
        
        try {
		birthDate = format.parse(birthDateInString);
			
		//time difference in milliseconds
		long diff = currentDate.getTime() - birthDate.getTime();
			
		long diffSeconds = diff / 1000;
		long diffMinutes = diff / (60 * 1000);
		long diffHours = diff / (60 * 60 * 1000);
		long diffDays = diff / (24 * 60 * 60 * 1000);
		long diffMonths = (diff / (24 * 60 * 60 * 1000)) / 30;
		long diffYears =  ((diff / (24 * 60 * 60 * 1000)) / 30) / 12;
			
		System.out.println(diff + " miliseconds");
		System.out.println(diffSeconds + " seconds");
		System.out.println(diffMinutes + " minutes");
		System.out.println(diffHours + " hours");
		System.out.println(diffDays + " days");
		System.out.println(diffMonths + " months");
		System.out.println(diffYears + " years");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
     
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        notimbang = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jtgl = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        b_pelblt = new javax.swing.JButton();
        b_penibuhamil = new javax.swing.JButton();
        b_penblt = new javax.swing.JButton();
        b_pelibuhamil = new javax.swing.JButton();
        b_pgs = new javax.swing.JButton();
        b_imun = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        idbalita1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nmanak1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        nmibu1 = new javax.swing.JTextField();
        bcari = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tglLahir = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        beratbadan = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tinggibadan = new javax.swing.JTextField();
        zscore = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lingkarkepala = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        status = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        imun = new javax.swing.JComboBox();
        btambah = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        aa = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        bhitung = new javax.swing.JButton();
        b_laporan = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabledatatimbangan = new javax.swing.JTable();
        bhapus2 = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PELAYANAN BALITA");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("No Timbangan");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tanggal");

        jtgl.setModel(new javax.swing.SpinnerDateModel());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logoposyandu.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 30)); // NOI18N
        jLabel1.setText("APLIKASI PELAYANAN KESEHATAN");

        jLabel17.setFont(new java.awt.Font("Tw Cen MT", 1, 30)); // NOI18N
        jLabel17.setText("POSYANDU WIJAYA KUSUMA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(jLabel16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel17))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)))
                .addContainerGap(389, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        b_pelblt.setBackground(new java.awt.Color(0, 102, 102));
        b_pelblt.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        b_pelblt.setForeground(new java.awt.Color(255, 255, 255));
        b_pelblt.setText("PELAYANAN BALITA");
        b_pelblt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_pelbltActionPerformed(evt);
            }
        });

        b_penibuhamil.setBackground(new java.awt.Color(0, 102, 102));
        b_penibuhamil.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        b_penibuhamil.setForeground(new java.awt.Color(255, 255, 255));
        b_penibuhamil.setText("PENDAFTARAN IBU HAMIL");
        b_penibuhamil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_penibuhamilActionPerformed(evt);
            }
        });

        b_penblt.setBackground(new java.awt.Color(0, 102, 102));
        b_penblt.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        b_penblt.setForeground(new java.awt.Color(255, 255, 255));
        b_penblt.setText("PENDAFTARAN BALITA");
        b_penblt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_penbltActionPerformed(evt);
            }
        });

        b_pelibuhamil.setBackground(new java.awt.Color(0, 102, 102));
        b_pelibuhamil.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        b_pelibuhamil.setForeground(new java.awt.Color(255, 255, 255));
        b_pelibuhamil.setText("PELAYANAN IBU HAMIL");
        b_pelibuhamil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_pelibuhamilActionPerformed(evt);
            }
        });

        b_pgs.setBackground(new java.awt.Color(0, 102, 102));
        b_pgs.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        b_pgs.setForeground(new java.awt.Color(255, 255, 255));
        b_pgs.setText("DATA PETUGAS");
        b_pgs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_pgsActionPerformed(evt);
            }
        });

        b_imun.setBackground(new java.awt.Color(0, 102, 102));
        b_imun.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        b_imun.setForeground(new java.awt.Color(255, 255, 255));
        b_imun.setText("DATA IMIUSASI");
        b_imun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_imunActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Data Timbangan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Id Balita");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Nama Anak");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Nama Ibu");

        bcari.setBackground(new java.awt.Color(102, 153, 255));
        bcari.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bcari.setText("Cari");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Tanggal Lahir");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel14))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nmibu1)
                            .addComponent(nmanak1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(idbalita1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bcari))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(tglLahir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(idbalita1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nmanak1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nmibu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Data Timbangan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Berat Badan");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Tinggi Badan");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Z Score");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Lingkar Kepala");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Status");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Imunisasi");

        imun.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        imun.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hepatitis A", "Hepatitis B", "Polio", "BCG", "Campak", "Pentavalen", "MMR", "Tifoid", "Rotavirus", "PCV", "Varicella", "Influenza", "HPV" }));

        btambah.setBackground(new java.awt.Color(102, 153, 255));
        btambah.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btambah.setText("Tambah");
        btambah.setToolTipText("Tambah");
        btambah.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Umur");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Bulan");

        bhitung.setBackground(new java.awt.Color(102, 153, 255));
        bhitung.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bhitung.setText("Hitung");
        bhitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhitungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18)
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lingkarkepala, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(tinggibadan, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(beratbadan, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(bhitung))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(75, 75, 75)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(aa, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(zscore, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(status)
                                        .addComponent(imun, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel19)
                            .addComponent(jLabel21)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(beratbadan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(tinggibadan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lingkarkepala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bhitung, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(aa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(zscore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(imun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btambah)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        b_laporan.setBackground(new java.awt.Color(0, 102, 102));
        b_laporan.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        b_laporan.setForeground(new java.awt.Color(255, 255, 255));
        b_laporan.setText("LAPORAN");
        b_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_laporanActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(153, 204, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Data Timbangan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        tabledatatimbangan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(tabledatatimbangan);

        bhapus2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bhapus2.setText("Hapus");
        bhapus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapus2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bhapus2)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bhapus2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bsimpan.setBackground(new java.awt.Color(102, 153, 255));
        bsimpan.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save (1).png"))); // NOI18N
        bsimpan.setText("Simpan");
        bsimpan.setToolTipText("simpan");
        bsimpan.setIconTextGap(0);
        bsimpan.setMargin(new java.awt.Insets(2, 0, 2, 14));
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        bbatal.setBackground(new java.awt.Color(102, 153, 255));
        bbatal.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bbatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/batal.png"))); // NOI18N
        bbatal.setText("Batal");
        bbatal.setToolTipText("Batal");
        bbatal.setMargin(new java.awt.Insets(2, 0, 2, 14));
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });

        bkeluar.setBackground(new java.awt.Color(102, 153, 255));
        bkeluar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bkeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/keluar2.png"))); // NOI18N
        bkeluar.setText("Keluar");
        bkeluar.setToolTipText("Keluar");
        bkeluar.setMargin(new java.awt.Insets(2, 0, 2, 0));
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(b_penibuhamil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_penblt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_pelblt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_pelibuhamil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_imun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_pgs, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(b_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bsimpan)
                        .addGap(18, 18, 18)
                        .addComponent(bbatal)
                        .addGap(18, 18, 18)
                        .addComponent(bkeluar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b_penblt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_penibuhamil, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_pelblt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_pelibuhamil, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_imun, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_pgs, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bkeluar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bbatal)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(467, 467, 467))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(notimbang, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(123, 123, 123))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(notimbang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
        String fd = sdf.format(jtgl.getValue()); 
        
        int jumlah_baris =tabledatatimbangan.getRowCount();
        if(jumlah_baris==0){
            JOptionPane.showMessageDialog(rootPane,"Table Masih Kosong!");
        }
        else {
            try{
                int i=0;
                while(i<jumlah_baris){
                    
                    String sql1 = "insert into pelayanan_balita values ("+"'"+tabledatatimbangan.getValueAt(i,0)+"',"+"'"+tabledatatimbangan.getValueAt(i,1)+"',"+"'"+tabledatatimbangan.getValueAt(i,2)+"',"+"'"+tabledatatimbangan.getValueAt(i,3)+"',"+"'"+tabledatatimbangan.getValueAt(i,4)+"',"+"'"+tabledatatimbangan.getValueAt(i,5)+"',"+"'"+tabledatatimbangan.getValueAt(i,6)+"',"+"'"+tabledatatimbangan.getValueAt(i,7)+"','"+tabledatatimbangan.getValueAt(i,8)+"','"+tabledatatimbangan.getValueAt(i,9)+"')";
                    //String sql2 = "insert into isi_blt values ("+"'"+tabledatatimbangan.getValueAt(i,0)+"',"+"'"+tabledatatimbangan.getValueAt(i,1)+"',"+"'"+idbalita1.getText()+"',"+"'"+nmanak1.getText()+"',"+"'"+nmibu1.getText()+"',"+"'"+tabledatatimbangan.getValueAt(i,2)+"',"+"'"+tabledatatimbangan.getValueAt(i,3)+"',"+"'"+tabledatatimbangan.getValueAt(i,4)+"',"+"'"+tabledatatimbangan.getValueAt(i,5)+"',"+"'"+tabledatatimbangan.getValueAt(i,6)+"',"+"'"+tabledatatimbangan.getValueAt(i,7)+"')";
                    
                    i++;
                    PreparedStatement stat = conn.prepareStatement(sql1);
                    //PreparedStatement stat2 = conn.prepareStatement(sql2);
                     stat.executeUpdate(); 
                      //stat2.executeUpdate(); 
                }
                JOptionPane.showMessageDialog(null, "data berhasil disimpan"); 
        } 
        catch (SQLException e){ 
            JOptionPane.showMessageDialog(null, "data gagal disimpan"+e);
            }
        }
  
            kosong(); 
            aktif(); 
            autonumber(); 
        // TODO add your handling code here:*/
    }//GEN-LAST:event_bsimpanActionPerformed

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fd = sdf.format(jtgl.getValue());
        try{
            String no_timbangan = notimbang.getText();
            String tanggal = fd; 
            String id_balita = idbalita1.getText();
            String nm_balita = nmanak1.getText();
            String bb_balita = beratbadan.getText();
            String tb_balita = tinggibadan.getText();
            String lk_balita = lingkarkepala.getText();
            String z_score = zscore.getText();
            String Status = status.getText();
            String Imun = imun.getSelectedItem().toString();

            tabmode.addRow(new Object[]{no_timbangan,tanggal,id_balita,nm_balita,bb_balita,tb_balita,lk_balita,z_score,Status,Imun});
            tabledatatimbangan.setModel(tabmode);
        }
        catch(Exception e)
        {
            System.out.println("Error : "+e);
        }   
     lingkarkepala.setText("");
     beratbadan.setText("");
     tinggibadan.setText("");
     zscore.setText("");
     status.setText("");
     imun.setSelectedItem("");

        // TODO add your handling code here:
    }//GEN-LAST:event_btambahActionPerformed

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
popup_databalita Pp = new popup_databalita();
    Pp.balita = this;
    Pp.setVisible(true);
    Pp.setResizable(false); 
        // TODO add your handling code here:
    }//GEN-LAST:event_bcariActionPerformed

    private void bhitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhitungActionPerformed
Date currentDate = new Date();
    String text = tglLahir.getText();
   // DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
   // java.util.Date textFieldAsDate = null;

try {
    Date Tanggal = sdf.parse(text);
    //String tgl = textFieldAsDate.getTime();
    long diff = currentDate.getTime() - Tanggal.getTime();
    long diffMonths = (diff / (24 * 60 * 60 * 1000)) / 30;
    aa.setText(Long.toString(diffMonths));
} catch (ParseException pe) {
    // deal with ParseException
}
    Hitung();

        // TODO add your handling code here:
    }//GEN-LAST:event_bhitungActionPerformed

    private void bhapus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapus2ActionPerformed
int index = tabledatatimbangan.getSelectedRow(); 
        tabmode.removeRow(index); 
        tabledatatimbangan.setModel(tabmode); 
        // TODO add your handling code here:
    }//GEN-LAST:event_bhapus2ActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        kosong();
        aktif();
        autonumber();
        // TODO add your handling code here:
    }//GEN-LAST:event_bbatalActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_bkeluarActionPerformed

    private void b_penbltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_penbltActionPerformed
        new pendaftaran_balita ().setVisible (true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_b_penbltActionPerformed

    private void b_penibuhamilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_penibuhamilActionPerformed
        new pendaftaran_ibuhamil ().setVisible (true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_b_penibuhamilActionPerformed

    private void b_pelbltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_pelbltActionPerformed
        new pelayanan_balita ().setVisible (true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_b_pelbltActionPerformed

    private void b_pelibuhamilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_pelibuhamilActionPerformed
        new pelayanan_ibuhamil ().setVisible (true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_b_pelibuhamilActionPerformed

    private void b_imunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_imunActionPerformed
        new imunisasi ().setVisible (true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_b_imunActionPerformed

    private void b_pgsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_pgsActionPerformed
        new petugas_posyandu ().setVisible (true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_b_pgsActionPerformed

    private void b_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_laporanActionPerformed
        new laporan ().setVisible (true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_b_laporanActionPerformed

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
            java.util.logging.Logger.getLogger(pelayanan_balita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pelayanan_balita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pelayanan_balita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pelayanan_balita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pelayanan_balita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aa;
    private javax.swing.JButton b_imun;
    private javax.swing.JButton b_laporan;
    private javax.swing.JButton b_pelblt;
    private javax.swing.JButton b_pelibuhamil;
    private javax.swing.JButton b_penblt;
    private javax.swing.JButton b_penibuhamil;
    private javax.swing.JButton b_pgs;
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bcari;
    private javax.swing.JTextField beratbadan;
    private javax.swing.JButton bhapus2;
    private javax.swing.JButton bhitung;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton btambah;
    private javax.swing.JTextField idbalita1;
    private javax.swing.JComboBox imun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jtgl;
    private javax.swing.JTextField lingkarkepala;
    private javax.swing.JTextField nmanak1;
    private javax.swing.JTextField nmibu1;
    private javax.swing.JTextField notimbang;
    private javax.swing.JTextField status;
    private javax.swing.JTable tabledatatimbangan;
    private javax.swing.JTextField tglLahir;
    private javax.swing.JTextField tinggibadan;
    private javax.swing.JTextField zscore;
    // End of variables declaration//GEN-END:variables
}
