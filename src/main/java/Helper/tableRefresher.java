/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import Objects.*;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Repositorys.*;



/**
 *
 * @author Luminescenents
 */
public class tableRefresher {
    TableConfig tableConfig = new TableConfig();
    jenisMetricRepo jenisMetricRepo = new jenisMetricRepo();
    BahanBakuRepo bahanBakuRepo = new BahanBakuRepo();
    ResepRepo resepRepo = new ResepRepo();
    KategoriRepo kategoriRepo = new KategoriRepo();
    
    
    public void refreshGetAllDataTableJenisUnit(JTable table){
            // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
         tableConfig.removeAllData(model);

        
       List<JenisMetric>  jenisMetric=  jenisMetricRepo.getAllJenisMetric();

        if(jenisMetric != null){
            
                for (int i = 0; i < jenisMetric.size(); i++) {
                    JenisMetric JenisMetricValue = jenisMetric.get(i);
                    // Lakukan sesuatu dengan setiap objek Mahasiswa
                    String no_metric = JenisMetricValue.getNo_metric();
                    String nama_metric = JenisMetricValue.getNama_metric();
                    String Keterangan = JenisMetricValue.getKeterangan();
                    model.addRow(new Object[]{no_metric, nama_metric, Keterangan});
                   
                }

    }
}
    public void refreshGetAllDataTableBahan(JTable table){
            // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
         tableConfig.removeAllData(model);

        
       List<BahanBaku> bahanBakuList =  bahanBakuRepo.getAllBahanBaku();
        if(bahanBakuList != null){
            
                for (int i = 0; i < bahanBakuList.size(); i++) {
                    BahanBaku bahanBakuValue = bahanBakuList.get(i);
                    // Lakukan sesuatu dengan setiap objek Mahasiswa
                    String No_bahan_baku = bahanBakuValue.getNo_bahan_baku();
                    String Nama_bahan = bahanBakuValue.getNama_bahan();
                    String getKeterangan = bahanBakuValue.getKeterangan();
                    model.addRow(new String[] {No_bahan_baku, Nama_bahan, getKeterangan});
                   
                }

    }
}
    public void refreshGetAllDataTableResep(JTable table){
            // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
         tableConfig.removeAllData(model);

        
       List<Resep> ResepList =  resepRepo.getAllResep();
        if(ResepList != null){
            
                for (int i = 0; i < ResepList.size(); i++) {
                    Resep ResepValue = ResepList.get(i);
                    // Lakukan sesuatu dengan setiap objek Mahasiswa
                    String No_resep = ResepValue.getNo_resep();
                    String Nama_resep = ResepValue.getNama_resep();
                    String deskripsi = ResepValue.getDeskripsiField();
                    byte[] foto = ResepValue.getFotoField();
                    model.addRow(new Object[] {No_resep, Nama_resep, deskripsi, foto});
                   
                }

    }
}
    public void refreshGetAllDataTableKategori(JTable table){
            // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
         tableConfig.removeAllData(model);

        
       List<Kategori> KategoriList =  kategoriRepo.getAllKategori();
        if(KategoriList != null){
            
                for (int i = 0; i < KategoriList.size(); i++) {
                    Kategori KategoriValue = KategoriList.get(i);
                    // Lakukan sesuatu dengan setiap objek Mahasiswa
                    String No_Kategori = KategoriValue.getNo_kategori();
                    String Nama_Kategori = KategoriValue.getNama_Kategori();
                    String tipe_taggable = KategoriValue.getTipe_kategori();
                    model.addRow(new Object[] {No_Kategori, Nama_Kategori,tipe_taggable});
                   
                }

    }
}
}
