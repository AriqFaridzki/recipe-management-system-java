/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorys;
import Connectors.databaseConnector;
import Connectors.DDLResult;
import Objects.Kategori;


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
      
      public DDLResult addKategori(Kategori kategori){
            String query = "INSERT INTO kategori (nama_kategori) VALUES (?)";
            String queryUpdate = "UPDATE kategori SET no_kategori = ? WHERE id_kategori = ?  ";
           
            
            
       
            String nama_Kategori = kategori.getNama_Kategori();
            
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
                    
                        nama_Kategori);
                 
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
     
     public DDLResult updateBahanBakuById(Kategori kategori){
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
     
     public DDLResult deleteBahanBakuAddByID(Kategori kategori){
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
     
     public List<Kategori> getAllBahanBaku(){
       List<Kategori> kategoriList = new ArrayList<>();
       
       String query = "SELECT * FROM kategori";

        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query);
            
            while(result.next()){
                     int id_kategori = result.getInt("id_kategori");
                     String no_kategori = result.getString("no_kategori");
                     String nama_kategori = result.getString("nama_kategori");
                     Kategori kategori = new Kategori(
                             id_kategori, 
                             no_kategori, 
                             nama_kategori);
                     
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
}