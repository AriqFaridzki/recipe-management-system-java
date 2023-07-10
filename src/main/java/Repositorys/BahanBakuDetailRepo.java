/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorys;
import Connectors.databaseConnector;
import Connectors.DDLResult;
import Objects.bahanBakuDetail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luminescenents
 */
public class BahanBakuDetailRepo {
    
    databaseConnector connector= new databaseConnector();
      public DDLResult addBahanBakuDetail(bahanBakuDetail bahanBakuDetail){
            String query = "INSERT INTO bahan_baku_detail (id_bahan_baku, brand, harga, id_metric) VALUES (?,?,?,?)";
            String queryUpdate = "UPDATE bahan_baku_detail SET no_bahan_baku_detail = ? WHERE id_bahan_baku = ?  ";
           
            
            
//            int id_bahan_baku = bahanBakuDetail.getId_bahan_baku();
            String brand = bahanBakuDetail.getBrand();
//            String no_bahan_baku_detail = bahanBakuDetail.getNo_bahan_baku();
            int harga = bahanBakuDetail.getHarga();   
            int id_metric = bahanBakuDetail.getId_metric();   
            int id_bahan_baku = bahanBakuDetail.getId_bahan_baku();
            
//            System.out.println(noBahanBaku);
//            System.out.println(namaBahan);
//            System.out.println(keterangan);
//            System.out.println(foto);
            
            DDLResult result = null;
            
            
             try {
                connector.checkConnection();
                 result  = connector.executeQueryDML(
                        query, 
                                   id_bahan_baku,
                        brand,
                        harga,
                        id_metric);
                 
                 
                 String no_bahan_baku_detail  = "BDT" + id_bahan_baku;
                 connector.executeQueryDML(
                         queryUpdate, 
                         
                         no_bahan_baku_detail,
                         id_bahan_baku);
   
           
            } catch (SQLException e) {
               e.printStackTrace();
               
            } finally {
                connector.closeConnection();
             
        }

//        System.out.println(values);
//        System.out.println("berhasil coy " + RowsAffected);
       return result;
    }
     
     public DDLResult updateBahanBakuById(bahanBakuDetail bahanBakuDetail){
            String query = "UPDATE bahan_baku_detail SET no_bahan_baku_detail=?, brand=?, harga=?, id_metric=? WHERE id_bahan_baku = ? ";
           
            int id_bahan_baku = bahanBakuDetail.getId_bahan_baku();
            String brand = bahanBakuDetail.getBrand();
            String no_bahan_baku_detail = bahanBakuDetail.getNo_bahan_baku();
            int harga = bahanBakuDetail.getHarga();   
            int id_metric = bahanBakuDetail.getId_metric();   
            
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
                     no_bahan_baku_detail,
                     brand,
                     harga,
                     id_metric,
                     id_bahan_baku);
   
//                       System.out.println("lmao");

            } catch (SQLException e) {
               e.printStackTrace();
               
            } finally {
                connector.closeConnection();
             
        }

//        System.out.println(values);
//        System.out.println("berhasil coy " + RowsAffected);
       return result;
    }
     
     public DDLResult deleteBahanBakuAddByID(bahanBakuDetail bahanBakuDetail){
            String query = "DELETE FROM bahan_baku_detail WHERE id_bahan_baku = ?  OR no_bahan_baku_detail = ?";
           
            int id_bahan_baku = bahanBakuDetail.getId_bahan_baku();
            String no_bahan_baku_detail = bahanBakuDetail.getNo_bahan_baku();
            
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
                     id_bahan_baku,
                     no_bahan_baku_detail);
   
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
     
     public List<bahanBakuDetail> getAllBahanBaku(){
       List<bahanBakuDetail> bahanBakuDetailList = new ArrayList<>();
       
       String query = "SELECT * FROM bahan_baku_detail";

        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query);
            
            

            
            
            while(result.next()){
                     int id_bahan_baku = result.getInt("id_bahan_baku");
                     String no_bahan_baku_detail = result.getString("no_bahan_baku_detail");
                     String brand = result.getString("brand");
                     int id_metric = result.getInt("id_metric");
                     int harga = result.getInt("harga");
                     
                     bahanBakuDetail bahanbakuDetails = new bahanBakuDetail(id_bahan_baku, no_bahan_baku_detail, harga,brand, id_metric);
                     bahanBakuDetailList.add(bahanbakuDetails);
            }
       connector.closeResultSet(result);
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally{
            connector.closeConnection();
        }
        
       return  bahanBakuDetailList;
    }
     
//     public BahanBaku getBahanBakuByID(int idBahanBaku){     public BahanBaku getBahanBakuByID(int idBahanBaku){
//       
//       String query = "SELECT * FROM bahan_baku WHERE id_bahan_baku=?";
//
//        try {
//            connector.checkConnection();
//            ResultSet result = connector.executeQueryRead(
//                    query,idBahanBaku);
//            
//            if(result.next()){
//                     String id_bahan_baku = result.getString("id_bahan_baku");
//                     String no_bahan_baku = result.getString("no_bahan_baku");
//                     String namaBahan = result.getString("nama_bahan");
//                     byte[] foto = result.getBytes("foto");
//                     String keterangan = result.getString("keterangan");
//                     return new BahanBaku(id_bahan_baku, no_bahan_baku, namaBahan, foto, keterangan);
//
//            }
//       connector.closeResultSet(result);
//        } catch ( SQLException e) {
//            e.printStackTrace();
//        } finally{
//            connector.closeConnection();
//        }
//       return null;
//    }
//     
//     public List<BahanBaku> getAllBahanBakuByKategori(bahanBakuDetail kategori){
//         
//       
//        List<BahanBaku> bahanBakuListbyKateori = new ArrayList<>();
//       
//       String query = "SELECT bahan_baku.id_bahan_baku, bahan_baku.no_bahan_baku ,bahan_baku.nama_bahan, bahan_baku.keterangan, kategori.nama_kategori, bahan_baku.foto" +
//                                "FROM kategori_bahan_baku" +
//                                "INNER JOIN bahan_baku ON bahan_baku.id_bahan_baku = kategori_bahan_baku.id_bahan_baku" +
//                                "INNER JOIN kategori ON kategori.id_kategori = kategori_bahan_baku.id_kategori" +
//                                "WHERE nama_kategori=?"; 
//
//        try {
//            connector.checkConnection();
//            ResultSet result = connector.executeQueryRead(
//                    query);
//            
//            while(result.next()){
//                     String id_bahan_baku = result.getString("id_bahan_baku");
//                     String no_bahan_baku = result.getString("no_bahan_baku");
//                     String namaBahan = result.getString("nama_bahan");
//                     String keterangan = result.getString("keterangan");
//                     String nama_kategori = result.getString("nama_kategori");
//                     byte[] foto = result.getBytes("foto");
//                     
//                     
//                     BahanBaku bahanBakuByKategori = new BahanBaku(
//                             id_bahan_baku, 
//                             no_bahan_baku, 
//                             namaBahan, 
//                             foto, 
//                             keterangan,
//                             nama_kategori);
//                     
//                     bahanBakuListbyKateori.add(bahanBakuByKategori);
//            }
//       connector.closeResultSet(result);
//        } catch ( SQLException e) {
//            e.printStackTrace();
//        } finally{
//            connector.closeConnection();
//        }
//        
//       return  bahanBakuListbyKateori;
//     }
//     
//     public List<BahanBaku> getBahanBakuByName(bahanBakuDetail bahanBaku){
//       List<BahanBaku> bahanBakuList = new ArrayList<>();
//       
//       String query = "SELECT * FROM bahan_baku WHERE nama_bahan=?"; // belum fix
//       String nama_bahan = bahanBaku.getNamaBahan();
//
//        try {
//            connector.checkConnection();
//            ResultSet result = connector.executeQueryRead(
//                    query, nama_bahan);
//            
//            while(result.next()){
//                     String id_bahan_baku = result.getString("id_bahan_baku");
//                     String no_bahan_baku = result.getString("no_bahan_baku");
//                     String namaBahan = result.getString("nama_bahan");
//                     byte[] foto = result.getBytes("foto");
//                     String keterangan = result.getString("keterangan");
//                     BahanBaku bahanBakuByName = new BahanBaku(id_bahan_baku, no_bahan_baku, namaBahan, foto, keterangan);
//                     bahanBakuList.add(bahanBakuByName);
//            }
//       connector.closeResultSet(result);
//        } catch ( SQLException e) {
//            e.printStackTrace();
//        } finally{
//            connector.closeConnection();
//        }
//        
//       return  bahanBakuList;
//    }
//       
//       String query = "SELECT * FROM bahan_baku WHERE id_bahan_baku=?";
//
//        try {
//            connector.checkConnection();
//            ResultSet result = connector.executeQueryRead(
//                    query,idBahanBaku);
//            
//            if(result.next()){
//                     String id_bahan_baku = result.getString("id_bahan_baku");
//                     String no_bahan_baku = result.getString("no_bahan_baku");
//                     String namaBahan = result.getString("nama_bahan");
//                     byte[] foto = result.getBytes("foto");
//                     String keterangan = result.getString("keterangan");
//                     return new BahanBaku(id_bahan_baku, no_bahan_baku, namaBahan, foto, keterangan);
//
//            }
//       connector.closeResultSet(result);
//        } catch ( SQLException e) {
//            e.printStackTrace();
//        } finally{
//            connector.closeConnection();
//        }
//       return null;
//    }
//     
//     public List<BahanBaku> getAllBahanBakuByKategori(bahanBakuDetail kategori){
//         
//       
//        List<BahanBaku> bahanBakuListbyKateori = new ArrayList<>();
//       
//       String query = "SELECT bahan_baku.id_bahan_baku, bahan_baku.no_bahan_baku ,bahan_baku.nama_bahan, bahan_baku.keterangan, kategori.nama_kategori, bahan_baku.foto" +
//                                "FROM kategori_bahan_baku" +
//                                "INNER JOIN bahan_baku ON bahan_baku.id_bahan_baku = kategori_bahan_baku.id_bahan_baku" +
//                                "INNER JOIN kategori ON kategori.id_kategori = kategori_bahan_baku.id_kategori" +
//                                "WHERE nama_kategori=?"; 
//
//        try {
//            connector.checkConnection();
//            ResultSet result = connector.executeQueryRead(
//                    query);
//            
//            while(result.next()){
//                     String id_bahan_baku = result.getString("id_bahan_baku");
//                     String no_bahan_baku = result.getString("no_bahan_baku");
//                     String namaBahan = result.getString("nama_bahan");
//                     String keterangan = result.getString("keterangan");
//                     String nama_kategori = result.getString("nama_kategori");
//                     byte[] foto = result.getBytes("foto");
//                     
//                     
//                     BahanBaku bahanBakuByKategori = new BahanBaku(
//                             id_bahan_baku, 
//                             no_bahan_baku, 
//                             namaBahan, 
//                             foto, 
//                             keterangan,
//                             nama_kategori);
//                     
//                     bahanBakuListbyKateori.add(bahanBakuByKategori);
//            }
//       connector.closeResultSet(result);
//        } catch ( SQLException e) {
//            e.printStackTrace();
//        } finally{
//            connector.closeConnection();
//        }
//        
//       return  bahanBakuListbyKateori;
//     }
//     
//     public List<BahanBaku> getBahanBakuByName(bahanBakuDetail bahanBaku){
//       List<BahanBaku> bahanBakuList = new ArrayList<>();
//       
//       String query = "SELECT * FROM bahan_baku WHERE nama_bahan=?"; // belum fix
//       String nama_bahan = bahanBaku.getNamaBahan();
//
//        try {
//            connector.checkConnection();
//            ResultSet result = connector.executeQueryRead(
//                    query, nama_bahan);
//            
//            while(result.next()){
//                     String id_bahan_baku = result.getString("id_bahan_baku");
//                     String no_bahan_baku = result.getString("no_bahan_baku");
//                     String namaBahan = result.getString("nama_bahan");
//                     byte[] foto = result.getBytes("foto");
//                     String keterangan = result.getString("keterangan");
//                     BahanBaku bahanBakuByName = new BahanBaku(id_bahan_baku, no_bahan_baku, namaBahan, foto, keterangan);
//                     bahanBakuList.add(bahanBakuByName);
//            }
//       connector.closeResultSet(result);
//        } catch ( SQLException e) {
//            e.printStackTrace();
//        } finally{
//            connector.closeConnection();
//        }
//        
//       return  bahanBakuList;
//    }
     
     
}
