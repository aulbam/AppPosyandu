/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package posyandu;

/**
 *
 * @author Adji
 */
public class menu_utama extends javax.swing.JFrame {

    /**
     * Creates new form menu_utama
     */
    public menu_utama() {
        initComponents();
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
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        dbalita = new javax.swing.JLabel();
        dibuhamil = new javax.swing.JLabel();
        pbalita = new javax.swing.JLabel();
        pibuhamil = new javax.swing.JLabel();
        ptgs = new javax.swing.JLabel();
        imunisasi = new javax.swing.JLabel();
        laporan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

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
                .addGap(168, 168, 168)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel17)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(39, 39, 39))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        dbalita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/daftarbalita.png"))); // NOI18N
        dbalita.setToolTipText("PENDAFTARAN BALITA");
        dbalita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dbalitaMouseClicked(evt);
            }
        });

        dibuhamil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/daftaribu.png"))); // NOI18N
        dibuhamil.setToolTipText("PENDAFTARAN IBU HAMIL");
        dibuhamil.setMaximumSize(new java.awt.Dimension(150, 150));
        dibuhamil.setMinimumSize(new java.awt.Dimension(150, 150));
        dibuhamil.setPreferredSize(new java.awt.Dimension(150, 150));
        dibuhamil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dibuhamilMouseClicked(evt);
            }
        });

        pbalita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pelayananbalita.png"))); // NOI18N
        pbalita.setToolTipText("PELAYANAN BALITA");
        pbalita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pbalitaMouseClicked(evt);
            }
        });

        pibuhamil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pelayananiuhamil.png"))); // NOI18N
        pibuhamil.setToolTipText("PELAYANAN IBU HAMIL");
        pibuhamil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pibuhamilMouseClicked(evt);
            }
        });

        ptgs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/PicsArt_04-30-03.38.15.png"))); // NOI18N
        ptgs.setToolTipText("DATA PETUGAS");
        ptgs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ptgsMouseClicked(evt);
            }
        });

        imunisasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dataimunisasi.png"))); // NOI18N
        imunisasi.setToolTipText("IMUNISASI");
        imunisasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imunisasiMouseClicked(evt);
            }
        });

        laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/PicsArt_04-30-03.49.33.png"))); // NOI18N
        laporan.setToolTipText("LAPORAN");
        laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                laporanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(dbalita)
                        .addGap(58, 58, 58)
                        .addComponent(dibuhamil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(pbalita)
                        .addGap(54, 54, 54)
                        .addComponent(pibuhamil))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(imunisasi)
                        .addGap(63, 63, 63)
                        .addComponent(ptgs)
                        .addGap(59, 59, 59)
                        .addComponent(laporan)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dbalita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dibuhamil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pbalita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pibuhamil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ptgs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imunisasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(laporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dbalitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dbalitaMouseClicked
new pendaftaran_balita ().setVisible (true);
dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_dbalitaMouseClicked

    private void dibuhamilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dibuhamilMouseClicked
new pendaftaran_ibuhamil ().setVisible (true);
dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_dibuhamilMouseClicked

    private void pbalitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pbalitaMouseClicked
new pelayanan_balita ().setVisible (true);
dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_pbalitaMouseClicked

    private void pibuhamilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pibuhamilMouseClicked
new pelayanan_ibuhamil ().setVisible (true);
dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_pibuhamilMouseClicked

    private void imunisasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imunisasiMouseClicked
new imunisasi ().setVisible (true);
dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_imunisasiMouseClicked

    private void ptgsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ptgsMouseClicked
new petugas_posyandu ().setVisible (true);
dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_ptgsMouseClicked

    private void laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laporanMouseClicked
new laporan ().setVisible (true);
dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_laporanMouseClicked

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
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dbalita;
    private javax.swing.JLabel dibuhamil;
    private javax.swing.JLabel imunisasi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel laporan;
    private javax.swing.JLabel pbalita;
    private javax.swing.JLabel pibuhamil;
    private javax.swing.JLabel ptgs;
    // End of variables declaration//GEN-END:variables
}