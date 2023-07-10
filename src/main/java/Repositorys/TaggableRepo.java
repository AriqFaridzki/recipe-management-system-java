/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorys;

import Connectors.DDLResult;
import Connectors.databaseConnector;
import Objects.Taggable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luminescenents
 */
public class TaggableRepo {
          databaseConnector connector = new databaseConnector();
      
      public DDLResult addTaggable(Taggable taggable){
            String query = "INSERT INTO taggable (tipe_taggable) VALUES (?)";
            String queryUpdate = "UPDATE taggable SET no_taggable = ? WHERE id_taggable = ?  ";
           
            
            
       
            String Tipe_taggable = taggable.getTipe_taggable();
            
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
                    
                        Tipe_taggable);
                 
                 int id_taggable = result.getGeneratedKeys();
                 String no_taggable  = "TAG" + id_taggable;
                 
                 connector.executeQueryDML(
                         queryUpdate, 
                         
                         no_taggable,
                         id_taggable);
   
           
            } catch (SQLException e) {
               e.printStackTrace();
               
            } finally {
                connector.closeConnection();
             
        }

//        System.out.println(values);
//        System.out.println("berhasil coy " + RowsAffected);
       return result;
    } // not tested
     
     public DDLResult UpdateTaggableById(Taggable taggable){
            String query = "UPDATE taggable SET tipe_taggable=? WHERE id_taggable = ? OR no_taggable=? ";
           

            String tipe_taggable = taggable.getTipe_taggable();
            int idTaggable = taggable.getId_taggable();
            String noTaggable = taggable.getNo_taggable();
            
//            System.out.println(idBahanBaku);
//            System.out.println(noBahanBaku);qq
//            System.out.println(namaBahan);
//            System.out.println(keterangan);
//            System.out.println(foto);
//            
            DDLResult result = null;
            
             try {
                connector.checkConnection();
                 result  = connector.executeQueryDML(
                        query, 
                     tipe_taggable,
                     idTaggable,
                     noTaggable);
   
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
     
     public DDLResult deleteTaggableByIDName(Taggable taggable){
            String query = "DELETE FROM taggable WHERE id_taggable = ?  OR no_taggable = ? OR tipe_taggable = ?";
           
            int idTaggable = taggable.getId_taggable();
            String noTaggable  = taggable.getNo_taggable();
            String tipe_taggable  = taggable.getTipe_taggable();
            
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
                     idTaggable,
                     noTaggable);
   
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
     
     public List<Taggable> getAllTaggable(){
       List<Taggable> taggableList = new ArrayList<>();
       
       String query = "SELECT * FROM taggable";

        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query);
            
            while(result.next()){
                     int id_taggable = result.getInt("id_taggable");
                     String no_taggable = result.getString("no_taggable");
                     String nama_taggable = result.getString("tipe_taggable");
                     Taggable taggable = new Taggable(
                             id_taggable, 
                             no_taggable, 
                             nama_taggable);
                     
                     taggableList.add(taggable);
            }
       connector.closeResultSet(result);
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally{
            connector.closeConnection();
        }
        
       return  taggableList;
    }
    
     public Taggable getTaggableByName(String  taggable){
       List<Taggable> taggableList = new ArrayList<>();
       
       String query = "SELECT * FROM taggable WHERE tipe_taggable=?";

        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query, taggable);
            
            while(result.next()){
                     int id_taggable = result.getInt("id_taggable");
                     String no_taggable = result.getString("no_taggable");
                     String nama_taggable = result.getString("tipe_taggable");
                     return new Taggable(
                             id_taggable, 
                             no_taggable, 
                             nama_taggable);
                     
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
