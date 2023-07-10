/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIs;

import javax.swing.WindowConstants;
import Objects.BahanBaku;
import Objects.bahanBakuDetail;
import Repositorys.BahanBakuRepo;
import Repositorys.BahanBakuDetailRepo;
import Objects.JenisMetric;
import Objects.Taggable;
import Repositorys.jenisMetricRepo;
import java.util.List;
import javax.swing.DefaultComboBoxModel;



/**
 *
 * @author Luminescenents
 */
public class TambahBahanBakuForm extends javax.swing.JFrame {
    BahanBakuRepo bahanBakuRepo = new BahanBakuRepo();
    jenisMetricRepo jenisMetricRepo = new jenisMetricRepo();
    BahanBakuDetailRepo bahanBakuDetailRepo = new BahanBakuDetailRepo();

    /**
     * Creates new form BahanBakuForm
     */
    public TambahBahanBakuForm() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public BahanBaku getAlldataBahanFromForms(){ 
        return new BahanBaku(namaBahanField.getText(),keteranganFields.getText());
    }
    
    public bahanBakuDetail getAlldataBahanDetailFromForms(int generatedKeys){
        
        
        String selectedUnit =(String) comboBoxMetric.getSelectedItem();
        JenisMetric jenisMetricItem = jenisMetricRepo.getJenisMetricByNameAdd(selectedUnit);
        System.out.println(generatedKeys);
        
        return new bahanBakuDetail(generatedKeys,Integer.parseInt(hargaFields.getText()),brandFields.getText(),jenisMetricItem.getId_metric());
    }
    
//    public BahanBakuDetail getAlldataBahanDetailFromForms(){
//       
//        
//        
//        return new BahanBakuDetail( brandFields.getText(), hargaFields.getText());
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelAddBahan = new javax.swing.JPanel();
        namaBahan = new javax.swing.JLabel();
        tambahBtn = new javax.swing.JButton();
        ket = new javax.swing.JLabel();
        namaBahanField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        keteranganFields = new javax.swing.JTextArea();
        namaBahan1 = new javax.swing.JLabel();
        hargaFields = new javax.swing.JTextField();
        namaBahan2 = new javax.swing.JLabel();
        brandFields = new javax.swing.JTextField();
        namaBahan3 = new javax.swing.JLabel();
        ambilGambarBtn = new javax.swing.JButton();
        namaBahan4 = new javax.swing.JLabel();
        comboBoxMetric = new javax.swing.JComboBox<>();
        namaBahan5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelAddBahan.setBackground(new java.awt.Color(255, 255, 255));
        panelAddBahan.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        namaBahan.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        namaBahan.setForeground(new java.awt.Color(51, 153, 255));
        namaBahan.setText("Nama Bahan");

        tambahBtn.setText("Tambah Data ! :D");
        tambahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBtnActionPerformed(evt);
            }
        });

        ket.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        ket.setForeground(new java.awt.Color(51, 153, 255));
        ket.setText("Keterangan");

        keteranganFields.setColumns(20);
        keteranganFields.setRows(5);
        jScrollPane1.setViewportView(keteranganFields);

        namaBahan1.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        namaBahan1.setForeground(new java.awt.Color(51, 153, 255));
        namaBahan1.setText("Harga");

        namaBahan2.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        namaBahan2.setForeground(new java.awt.Color(51, 153, 255));
        namaBahan2.setText("Brand");

        namaBahan3.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        namaBahan3.setForeground(new java.awt.Color(51, 153, 255));
        namaBahan3.setText("Pilih Gambar :");

        ambilGambarBtn.setText("Klik !");
        ambilGambarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ambilGambarBtnActionPerformed(evt);
            }
        });

        namaBahan4.setFont(new java.awt.Font("Poppins Light", 0, 16)); // NOI18N
        namaBahan4.setForeground(new java.awt.Color(102, 102, 102));
        namaBahan4.setText("none");

        comboBoxMetric.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxMetric.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                comboBoxMetricFocusGained(evt);
            }
        });

        namaBahan5.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        namaBahan5.setForeground(new java.awt.Color(51, 153, 255));
        namaBahan5.setText("Unit");

        javax.swing.GroupLayout panelAddBahanLayout = new javax.swing.GroupLayout(panelAddBahan);
        panelAddBahan.setLayout(panelAddBahanLayout);
        panelAddBahanLayout.setHorizontalGroup(
            panelAddBahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddBahanLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(panelAddBahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ket, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaBahanField, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaBahan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(panelAddBahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hargaFields, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAddBahanLayout.createSequentialGroup()
                        .addComponent(namaBahan3)
                        .addGap(18, 18, 18)
                        .addComponent(namaBahan4))
                    .addComponent(namaBahan1)
                    .addComponent(ambilGambarBtn)
                    .addComponent(namaBahan2)
                    .addComponent(brandFields, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, Short.MAX_VALUE)
                .addGroup(panelAddBahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaBahan5)
                    .addComponent(comboBoxMetric, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addGroup(panelAddBahanLayout.createSequentialGroup()
                .addGap(369, 369, 369)
                .addComponent(tambahBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAddBahanLayout.setVerticalGroup(
            panelAddBahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddBahanLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panelAddBahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelAddBahanLayout.createSequentialGroup()
                        .addComponent(namaBahan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namaBahanField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(ket)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAddBahanLayout.createSequentialGroup()
                        .addComponent(namaBahan2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(brandFields, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(panelAddBahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namaBahan1)
                            .addComponent(namaBahan5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAddBahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hargaFields, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxMetric, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(panelAddBahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namaBahan3)
                            .addComponent(namaBahan4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ambilGambarBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(tambahBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jLabel2.setFont(new java.awt.Font("Poppins Light", 0, 24)); // NOI18N
        jLabel2.setText("Bahan Baku");

        jLabel4.setFont(new java.awt.Font("Poppins SemiBold", 0, 24)); // NOI18N
        jLabel4.setText("Tambah");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelAddBahan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(panelAddBahan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ambilGambarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ambilGambarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ambilGambarBtnActionPerformed

    private void tambahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBtnActionPerformed
        // TODO add your handling code here:
        BahanBaku bahanBaku = getAlldataBahanFromForms();
        bahanBakuRepo.addBahanBaku(bahanBaku);
        bahanBakuDetail bahanBakuDetail = getAlldataBahanDetailFromForms(bahanBakuRepo.getGeneratedKeys());
        bahanBakuDetailRepo.addBahanBakuDetail(bahanBakuDetail);
    }//GEN-LAST:event_tambahBtnActionPerformed

    private void comboBoxMetricFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboBoxMetricFocusGained
        // TODO add your handling code here:
                
        
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        List<JenisMetric> jenisMetricList = jenisMetricRepo.getAllJenisMetric();
        
        for (int i = 0; i < jenisMetricList.size(); i++) {
            JenisMetric jenisMetricValue = jenisMetricList.get(i);
            comboBoxModel.addElement(jenisMetricValue.getNama_metric());
        }
        
        comboBoxMetric.setModel( comboBoxModel);
    }//GEN-LAST:event_comboBoxMetricFocusGained

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
            java.util.logging.Logger.getLogger(TambahBahanBakuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahBahanBakuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahBahanBakuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahBahanBakuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahBahanBakuForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ambilGambarBtn;
    private javax.swing.JTextField brandFields;
    private javax.swing.JComboBox<String> comboBoxMetric;
    private javax.swing.JTextField hargaFields;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel ket;
    private javax.swing.JTextArea keteranganFields;
    private javax.swing.JLabel namaBahan;
    private javax.swing.JLabel namaBahan1;
    private javax.swing.JLabel namaBahan2;
    private javax.swing.JLabel namaBahan3;
    private javax.swing.JLabel namaBahan4;
    private javax.swing.JLabel namaBahan5;
    private javax.swing.JTextField namaBahanField;
    private javax.swing.JPanel panelAddBahan;
    private javax.swing.JButton tambahBtn;
    // End of variables declaration//GEN-END:variables
}
