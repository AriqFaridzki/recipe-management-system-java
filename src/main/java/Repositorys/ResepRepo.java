/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorys;

import Connectors.DDLResult;
import Connectors.databaseConnector;
import java.sql.ResultSet;
import Objects.Resep;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Objects.Kategori;

/**
 *
 * @author Luminescenents
 */
public class ResepRepo {
    
      databaseConnector connector = new databaseConnector();
      
      public DDLResult addResep(Resep resep){
            String query = "INSERT INTO resep (nama_resep, deskripsiField, fotoField) VALUES (?,?,?)";
            String queryUpdate = "UPDATE resep SET no_resep = ? WHERE id_resep = ?";
           
            
            
       
            String nama_resep = resep.getNama_resep();
            String deskripsiField = resep.getDeskripsiField();
//            String no_resep = resep.getNo_resep();
            byte[] fotoField = resep.getFotoField();
            
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
                    
                        nama_resep,
                        deskripsiField,
                        fotoField);
                 
                 int id_resep = result.getGeneratedKeys();
                 String no_resep  = "RSP" + id_resep;
                 
                 connector.executeQueryDML(
                         queryUpdate, 
                         
                         no_resep,
                         id_resep);
   
           
            } catch (SQLException e) {
               e.printStackTrace();
               
            } finally {
                connector.closeConnection();
             
        }

//        System.out.println(values);
//        System.out.println("berhasil coy " + RowsAffected);
       return result;
    } // belum jadi asli, ke detail resep dulu
     
     public DDLResult UpdateResepById(Resep resep){
            String query = "UPDATE resep SET nama_resep=?,deskripsiField=?, fotoField=? WHERE id_resep = ? OR no_resep=? ";
           
            String nama_resep = resep.getNama_resep();
            String deskripsiField = resep.getDeskripsiField();
            byte[] fotoField = resep.getFotoField();
            int id_resep = resep.getId_resep();
            String no_resep = resep.getNo_resep();
                       
            DDLResult result = null;
            
             try {
                connector.checkConnection();
                 result  = connector.executeQueryDML(
                        query, 
                     nama_resep,
                     deskripsiField,
                     fotoField,
                     id_resep,
                     no_resep);
   
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
     
     public DDLResult deleteResepByID(Resep resep){
            String query = "DELETE FROM resep WHERE id_resep = ?  OR no_resep = ?";
           
            int id_resep = resep.getId_resep();
            String no_resep = resep.getNo_resep();
            
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
                     id_resep,
                     no_resep);
   
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
     
     public List<Resep> getAllResep(){
       List<Resep> ResepList = new ArrayList<>();
       
       String query = "SELECT * FROM resep";
       

        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query);
            
            while(result.next()){
                
                int id_resep = result.getInt("id_resep");
                String no_resep = result.getString("no_resep");
                String nama_resep =  result.getString("nama_resep");
                String deskripsiField = result.getString("deskripsiField");
                byte[] fotoField = result.getBytes("fotoField");
                
                  
                     Resep resep = new Resep(
                             id_resep, 
                             no_resep, 
                             nama_resep,
                            deskripsiField,
                             fotoField);
                     
                     ResepList.add(resep);
            }
       connector.closeResultSet(result);
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally{
            connector.closeConnection();
        }
        
       return  ResepList;
    }
     
     public List<Resep> getAllResepByKategoriName(Kategori kategori){
       List<Resep> ResepList = new ArrayList<>();
       
       
       
//       String query = "SELECT * FROM resep";
       String query = "SELECT resep.id_resep, resep.no_resep, resep.nama_resep, resep.deskripsiField, kategori.nama_kategori, resep.fotoField" +
                                "FROM kategori_resep" +
                                "INNER JOIN resep ON resep.id_resep = kategori_resep.id_resep" +
                                "INNER JOIN kategori ON kategori.id_kategori = kategori_resep.id_kategori" +
                                "WHERE nama_kategori=?";

       

        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query);
            
            while(result.next()){
                
                int id_resep = result.getInt("id_resep");
                String no_resep = result.getString("no_resep");
                String nama_resep =  result.getString("nama_resep");
                String deskripsiField = result.getString("deskripsiField");
                String nama_kategori = result.getString("nama_kategori");
                byte[] fotoField = result.getBytes("fotoField");
                
                  
                     Resep resep = new Resep(
                             id_resep, 
                             no_resep, 
                             nama_resep,
                            deskripsiField,
                             nama_kategori,
                             fotoField);
                     
                     ResepList.add(resep);
            }
       connector.closeResultSet(result);
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally{
            connector.closeConnection();
        }
        
       return  ResepList;
    }
    
}
