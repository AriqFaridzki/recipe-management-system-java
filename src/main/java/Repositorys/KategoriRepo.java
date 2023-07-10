/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorys;
import Connectors.databaseConnector;
import Connectors.DDLResult;
import Objects.Kategori;
import Objects.BahanBaku;
import Objects.Resep;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luminescenents
 */
public class KategoriRepo {
      databaseConnector connector = new databaseConnector();
     
      public DDLResult insertKategoriBahanBaku(BahanBaku bahanBaku, Kategori kategori){
         String query = "INSERT INTO kategori_bahan_baku (id_kategori, id_bahan_baku) VALUES (?,?)";
         
         int id_kategori = kategori.getId_kategori();
         String id_bahan_baku = bahanBaku.getIdBahanBaku();
         
          DDLResult result = null;
                
             try {
                connector.checkConnection();
                 result  = connector.executeQueryDML(
                        query, 
                    
                        id_kategori,
                        id_bahan_baku
                        );

            } catch (SQLException e) {
               e.printStackTrace();
               
            } finally {
                connector.closeConnection();
             
        }

//        System.out.println(values);
//        System.out.println("berhasil coy " + RowsAffected);
       return result;
         
}
      public DDLResult insertKategoriResep(Resep resep, Kategori kategori){
         String query = "INSERT INTO kategori_bahan_resep (id_kategori, id_bahan_baku) VALUES (?,?)";
         
         int id_kategori = kategori.getId_kategori();
         int id_resep = resep.getId_resep();
         
          DDLResult result = null;
                
             try {
                connector.checkConnection();
                 result  = connector.executeQueryDML(
                        query, 
                    
                        id_kategori,
                        id_resep
                        );

            } catch (SQLException e) {
               e.printStackTrace();
               
            } finally {
                connector.closeConnection();
             
        }

//        System.out.println(values);
//        System.out.println("berhasil coy " + RowsAffected);
       return result;
         
}
      
      public DDLResult addKategori(Kategori kategori){
            String query = "INSERT INTO kategori (nama_kategori, id_taggable) VALUES (?,?)";
            String queryUpdate = "UPDATE kategori SET no_kategori = ? WHERE id_kategori = ?  ";
       
            String nama_Kategori = kategori.getNama_Kategori();
            int id_Taggable = kategori.getId_taggable();
            
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
                    
                        nama_Kategori,
                        id_Taggable);
                 
                 int id_kategori = result.getGeneratedKeys();
                 String no_kategori  = "KTG" + id_kategori;
                 
                 connector.executeQueryDML(
                         queryUpdate, 
                         
                         no_kategori,
                         id_kategori);
   
           
            } catch (SQLException e) {
               e.printStackTrace();
               
            } finally {
                connector.closeConnection();
             
        }

//        System.out.println(values);
//        System.out.println("berhasil coy " + RowsAffected);
       return result;
    } // not tested
        
     public DDLResult updateKategoriById(Kategori kategori){
            String query = "UPDATE kategori SET nama_kategori=? WHERE id_kategori = ? ";
           

            String nama_kategori = kategori.getNama_Kategori();
            int id_kategori = kategori.getId_kategori();
            
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
                     nama_kategori,
                     id_kategori);
   
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
     
     public DDLResult deleteKategoriByID(Kategori kategori){
            String query = "DELETE FROM kategori WHERE id_kategori = ?  OR no_kategori = ?";
           
            int id_kategori = kategori.getId_kategori();
            String no_kategori  = kategori.getNo_kategori();
            
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
                     id_kategori,
                     no_kategori);
   
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
     
     public List<Kategori> getAllKategori(){
       List<Kategori> kategoriList = new ArrayList<>();
       
//       String query = "SELECT * FROM kategori";
       String query = "SELECT kategori.id_kategori, kategori.no_kategori, kategori.nama_kategori, taggable.tipe_taggable" +
                                " FROM kategori" +
                                " INNER JOIN taggable ON taggable.id_taggable = kategori.id_taggable";

        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query);
            
            while(result.next()){
                     int id_kategori = result.getInt("id_kategori");
                     String no_kategori = result.getString("no_kategori");
                     String nama_kategori = result.getString("nama_kategori");
                     String tipe_taggable = result.getString("tipe_taggable");
                     Kategori kategori = new Kategori(
                             id_kategori, 
                             no_kategori, 
                             nama_kategori,
                     tipe_taggable);
                     
                     kategoriList.add(kategori);
            }
       connector.closeResultSet(result);
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally{
            connector.closeConnection();
        }
        
       return  kategoriList;
    }
     
     public List<Kategori> getAllKategoriByName(String nama_Kategori){
       List<Kategori> kategoriList = new ArrayList<>();
       
//       String query = "SELECT * FROM kategori";
       String query = "SELECT kategori.id_kategori, kategori.no_kategori, kategori.nama_kategori, taggable.tipe_taggable" +
                                " FROM kategori" +
                                " INNER JOIN taggable ON taggable.id_taggable = kategori.id_taggable"
                                +" WHERE nama_kategori LIKE CONCAT(?, '%')";

        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query, nama_Kategori);
            
            while(result.next()){
                     int id_kategori = result.getInt("id_kategori");
                     String no_kategori = result.getString("no_kategori");
                     String nama_kategori = result.getString("nama_kategori");
                     String tipe_taggable = result.getString("tipe_taggable");
                     Kategori kategori = new Kategori(
                             id_kategori, 
                             no_kategori, 
                             nama_kategori,
                     tipe_taggable);
                     
                     kategoriList.add(kategori);
            }
       connector.closeResultSet(result);
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally{
            connector.closeConnection();
        }
        
       return  kategoriList;
    }
     
     public Kategori getAllKategoriByID(int id_taggable) {
       
//       String query = "SELECT * FROM kategori";
       String query = "SELECT kategori.id_kategori, kategori.no_kat egori, kategori.nama_kategori, taggable.tipe_taggable" +
                                " FROM kategori" +
                                " INNER JOIN taggable ON taggable.id_taggable = kategori.id_taggable"
                                +" WHERE kategori.id_kategori=?";

        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query, id_taggable);
            
            while(result.next()){
                     int id_kategori = result.getInt("id_kategori");
                     String no_kategori = result.getString("no_kategori");
                     String nama_kategori = result.getString("nama_kategori");
                     String tipe_taggable = result.getString("tipe_taggable");
                     return new Kategori(id_kategori, no_kategori, nama_kategori, tipe_taggable);
                     
                     
            }
       connector.closeResultSet(result);
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally{
            connector.closeConnection();
        }
        
       return null;
    }
     
     public Kategori getAllKategoriById(int id_kategoris){
       
//       String query = "SELECT * FROM kategori";
       String query = "SELECT kategori.id_kategori, kategori.no_kategori, kategori.nama_kategori, taggable.tipe_taggable" +
                                " FROM kategori" +
                                " INNER JOIN taggable ON taggable.id_taggable = kategori.id_taggable"
                                +" WHERE nama_kategori = ?";

        try {
            connector.checkConnection();
;
            ResultSet result = connector.executeQueryRead(
                    query, id_kategoris);
            
            while(result.next()){
                     int id_kategori = result.getInt("id_kategori");
                     String no_kategori = result.getString("no_kategori");
                     String nama_kategori = result.getString("nama_kategori");
                     String tipe_taggable = result.getString("tipe_taggable");
                      System.out.println(result.getString("nama_kategori"));
                     return new Kategori(id_kategori, no_kategori, nama_kategori, tipe_taggable);
                     
            }
            
       connector.closeResultSet(result);
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally{
            connector.closeConnection();
        }
        
       return  null;
    }
     
}


