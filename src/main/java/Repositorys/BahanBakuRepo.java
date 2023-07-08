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
import Objects.Kategori;
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
            String query = "UPDATE bahan_baku SET no_bahan_baku=?, nama_bahan=?, keterangan=?, foto=?  WHERE id_bahan_baku = ? ";
           
            String idBahanBaku = bahanBaku.getIdBahanBaku();
            String noBahanBaku  = bahanBaku.getNo_bahan_baku();
            String namaBahan = bahanBaku.getNamaBahan();
            String keterangan = bahanBaku.getKeterangan();
            byte[] foto = bahanBaku.getFoto();
            
            System.out.println(idBahanBaku);
            System.out.println(noBahanBaku);
            System.out.println(namaBahan);
            System.out.println(keterangan);
            System.out.println(foto);
//            
            DDLResult result = null;
            
             try {
                connector.checkConnection();
                 result  = connector.executeQueryDML(
                        query, 
                     noBahanBaku,
                     namaBahan,
                     keterangan,
                     foto,
                     idBahanBaku);
   
                       System.out.println("lmao");

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
           
            String idBahanBaku = bahanBaku.getIdBahanBaku();
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
                     String id_bahan_baku = result.getString("id_bahan_baku");
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
     
     public BahanBaku getBahanBakuByID(String idBahanBaku){
       
       String query = "SELECT * FROM bahan_baku WHERE id_bahan_baku=?";

        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query,idBahanBaku);
            
            if(result.next()){
                     String id_bahan_baku = result.getString("id_bahan_baku");
                     String no_bahan_baku = result.getString("no_bahan_baku");
                     String namaBahan = result.getString("nama_bahan");
                     byte[] foto = result.getBytes("foto");
                     String keterangan = result.getString("keterangan");
                     return new BahanBaku(id_bahan_baku, no_bahan_baku, namaBahan, foto, keterangan);

            }
       connector.closeResultSet(result);
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally{
            connector.closeConnection();
        }
       return null;
    }
     
     public List<BahanBaku> getAllBahanBakuByKategori(Kategori kategori){
         
       
        List<BahanBaku> bahanBakuListbyKateori = new ArrayList<>();
       
       String query = "SELECT bahan_baku.id_bahan_baku, bahan_baku.no_bahan_baku ,bahan_baku.nama_bahan, bahan_baku.keterangan, kategori.nama_kategori, bahan_baku.foto" +
                                "FROM kategori_bahan_baku" +
                                "INNER JOIN bahan_baku ON bahan_baku.id_bahan_baku = kategori_bahan_baku.id_bahan_baku" +
                                "INNER JOIN kategori ON kategori.id_kategori = kategori_bahan_baku.id_kategori" +
                                "WHERE nama_kategori=?"; 

        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query);
            
            while(result.next()){
                     String id_bahan_baku = result.getString("id_bahan_baku");
                     String no_bahan_baku = result.getString("no_bahan_baku");
                     String namaBahan = result.getString("nama_bahan");
                     String keterangan = result.getString("keterangan");
                     String nama_kategori = result.getString("nama_kategori");
                     byte[] foto = result.getBytes("foto");
                     
                     
                     BahanBaku bahanBakuByKategori = new BahanBaku(
                             id_bahan_baku, 
                             no_bahan_baku, 
                             namaBahan, 
                             foto, 
                             keterangan,
                             nama_kategori);
                     
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
     
     public List<BahanBaku> getBahanBakuByName(BahanBaku bahanBaku){
       List<BahanBaku> bahanBakuList = new ArrayList<>();
       
       String query = "SELECT * FROM bahan_baku WHERE nama_bahan=?"; // belum fix
       String nama_bahan = bahanBaku.getNamaBahan();

        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query, nama_bahan);
            
            while(result.next()){
                     String id_bahan_baku = result.getString("id_bahan_baku");
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
     
     
     




