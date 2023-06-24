/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorys;
import Connectors.databaseConnector; 
import Connectors.DDLResult;

import Objects.BahanBaku; // ubah saja ini dengan nama file classnya
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luminescenents
 */
public class BahanBakuRepo {
 databaseConnector connector = new databaseConnector();
// Connection connection = connector.getConnection();
    
     public DDLResult addBahanBaku(BahanBaku bahanBaku){
            String query = "INSERT INTO bahan_baku (nama_bahan, foto, keterangan) VALUES (?,?,?)";
            String queryUpdate = "UPDATE bahan_baku SET no_bahan_baku = ? WHERE id_bahan_baku = ?  ";
           
            
            
            String namaBahan = bahanBaku.getNamaBahan();
            String keterangan = bahanBaku.getKeterangan();
            byte[] foto = bahanBaku.getFoto();
            
//            System.out.println(noBahanBaku);
            System.out.println(namaBahan);
            System.out.println(keterangan);
            System.out.println(foto);
            
            DDLResult result = null;
            
            
             try {
                connector.checkConnection();
                 result  = connector.executeQueryDML(
                        query, 
                    
                        namaBahan,
                        foto,
                        keterangan);
                 
                 int idBahanBaku = result.getGeneratedKeys();
                 String noBahanBaku  = "BBK" + idBahanBaku;
                 connector.executeQueryDML(
                         queryUpdate, 
                         
                         noBahanBaku,
                         idBahanBaku);
   
           
            } catch (SQLException e) {
               e.printStackTrace();
               
            } finally {
                connector.closeConnection();
             
        }

//        System.out.println(values);
//        System.out.println("berhasil coy " + RowsAffected);
       return result;
    }
     
     public DDLResult updateBahanBakuById(BahanBaku bahanBaku){
            String query = "UPDATE bahan_baku SET nama_bahan=?, foto=?, keterangan=? WHERE id_bahan_baku = ? ";
           
            int idBahanBaku = bahanBaku.getIdBahanBaku();
            String noBahanBaku  = bahanBaku.getNo_bahan_baku();
            String namaBahan = bahanBaku.getNamaBahan();
            String keterangan = bahanBaku.getKeterangan();
            byte[] foto = bahanBaku.getFoto();
            
//            System.out.println(idBahanBaku);
//            System.out.println(noBahanBaku);
//            System.out.println(namaBahan);
//            System.out.println(keterangan);
//            System.out.println(foto);
//            
            DDLResult result = null;
            
             try {
                connector.checkConnection();
                 result  = connector.executeQueryDML(
                        query, 
//                     noBahanBaku,
                     namaBahan,
                     keterangan,
                     foto,
                     idBahanBaku);
   
//                       System.out.println("berhasil");

            } catch (SQLException e) {
               e.printStackTrace();
               
            } finally {
                connector.closeConnection();
             
        }

//        System.out.println(values);
//        System.out.println("berhasil coy " + RowsAffected);
       return result;
    }
     
     public DDLResult deleteBahanBakuAddByID(BahanBaku bahanBaku){
            String query = "DELETE FROM bahan_baku WHERE id_bahan_baku = ?  OR no_bahan_baku = ?";
           
            int idBahanBaku = bahanBaku.getIdBahanBaku();
            String noBahanBaku  = bahanBaku.getNo_bahan_baku();
            
//            System.out.println(idBahanBaku);
//            System.out.println(noBahanBaku);
//            System.out.println(namaBahan);
//            System.out.println(keterangan);
//            System.out.println(foto);
//            
            DDLResult result = null;
            
             try {
                connector.checkConnection();
                 result  = connector.executeQueryDML(
                        query, 
                     idBahanBaku,
                     noBahanBaku);
   
//                       System.out.println("berhasil");

            } catch (SQLException e) {
               e.printStackTrace();
               
            } finally {
                connector.closeConnection();
             
        }

//        System.out.println(values);
//        System.out.println("berhasil coy " + RowsAffected);
       return result;
    }
     
     public List<BahanBaku> getAllBahanBaku(){
       List<BahanBaku> bahanBakuList = new ArrayList<>();
       
       String query = "SELECT * FROM bahan_baku";

        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query);
            
            while(result.next()){
                     int id_bahan_baku = result.getInt("id_bahan_baku");
                     String no_bahan_baku = result.getString("no_bahan_baku");
                     String namaBahan = result.getString("nama_bahan");
                     byte[] foto = result.getBytes("foto");
                     String keterangan = result.getString("keterangan");
                     BahanBaku bahanBaku = new BahanBaku(id_bahan_baku, no_bahan_baku, namaBahan, foto, keterangan);
                     bahanBakuList.add(bahanBaku);
            }
       connector.closeResultSet(result);
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally{
            connector.closeConnection();
        }
        
       return  bahanBakuList;
    }
     
     public List<BahanBaku> getAllBahanBakuByKategori(BahanBaku bahanBaku){
         
/**
 * SQL 
 * SELECT
  bahan.nama_bahan,
  KTG.nama_kategori
FROM
  bahan_baku AS bahan
  JOIN kategori_bahan_baku AS KTGBK ON bahan.id_bahan_baku = KTGBK.id_bahan_baku
  JOIN kategori AS KTG ON KTGBK.id_kategori = KTG.id_kategori
  WHERE KTG.nama_kategori = "buah";
 */
       
        List<BahanBaku> bahanBakuListbyKateori = new ArrayList<>();
       
       String query = "SELECT * FROM bahan_baku"; // masih proses querynya

        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query);
            
            while(result.next()){
                     int id_bahan_baku = result.getInt("id_bahan_baku");
                     String no_bahan_baku = result.getString("no_bahan_baku");
                     String namaBahan = result.getString("nama_bahan");
                     byte[] foto = result.getBytes("foto");
                     String keterangan = result.getString("keterangan");
                     
                     
                     BahanBaku bahanBakuByKategori = new BahanBaku(id_bahan_baku, no_bahan_baku, namaBahan, foto, keterangan);
                     
                     bahanBakuListbyKateori.add(bahanBakuByKategori);
            }
       connector.closeResultSet(result);
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally{
            connector.closeConnection();
        }
        
       return  bahanBakuListbyKateori;
     }
     
     public List<BahanBaku> getBahanBakuName(BahanBaku bahanBaku){
       List<BahanBaku> bahanBakuList = new ArrayList<>();
       
       String query = "SELECT * FROM bahan_baku WHERE nama_bahan=?"; // belum fix
       String nama_bahan = bahanBaku.getNamaBahan();

        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query, nama_bahan);
            
            while(result.next()){
                     int id_bahan_baku = result.getInt("id_bahan_baku");
                     String no_bahan_baku = result.getString("no_bahan_baku");
                     String namaBahan = result.getString("nama_bahan");
                     byte[] foto = result.getBytes("foto");
                     String keterangan = result.getString("keterangan");
                     BahanBaku bahanBakuByName = new BahanBaku(id_bahan_baku, no_bahan_baku, namaBahan, foto, keterangan);
                     bahanBakuList.add(bahanBakuByName);
            }
       connector.closeResultSet(result);
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally{
            connector.closeConnection();
        }
        
       return  bahanBakuList;
    }
     
     
     
     
     
     
     
     
}
     
     
     




