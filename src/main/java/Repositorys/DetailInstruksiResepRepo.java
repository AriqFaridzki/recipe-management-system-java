/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorys;

import Connectors.DDLResult;
import Connectors.databaseConnector;
import Objects.DetailInstruksiResep;
import Objects.DetailInstruksiResepResult;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Objects.Resep;

/**
 *
 * @author Luminescenents
 */
public class DetailInstruksiResepRepo {
    databaseConnector connector = new databaseConnector();
      
      public DDLResult addDetailInstruksiResep(DetailInstruksiResep detailInstruksiResep){
            String query = "INSERT INTO detail_instruksi_resep (instruksi, foto) VALUES (?,?)";
            String queryUpdate = "UPDATE detail_instruksi_resep SET no_instruksi_resep = ? WHERE id_resep = ?";
           
            
            
            
            String instruksi = detailInstruksiResep.getInstruksi();
            byte[] foto = detailInstruksiResep.getFoto();
            
            DDLResult result = null;
            
            
             try {
                connector.checkConnection();
                 result  = connector.executeQueryDML(
                        query, 
                         
                        instruksi,
                        foto
   
                        ); 
                 
            int id_resep = result.getGeneratedKeys();
            String no_instruksi_resep ="NOIR"  + id_resep;    
            
                 connector.executeQueryDML(
                         queryUpdate, 
                         
                         no_instruksi_resep,
                         id_resep);
   
           
            } catch (SQLException e) {
               e.printStackTrace();
               
            } finally {
                connector.closeConnection();
             
        }

//        System.out.println(values);
//        System.out.println("berhasil coy " + RowsAffected);
       return result;
    } // not tested
     
     public DDLResult UpdateDetailInstruksiResepById(DetailInstruksiResep detailInstruksiResep){
            String query = "UPDATE detail_instruksi_resep SET instruksi=?, foto=? WHERE id_resep = ? OR no_instruksi_resep=? ";
           
            int id_resep = detailInstruksiResep.getId_resep();
            String no_instruksi_resep = detailInstruksiResep.getNo_instruksi_resep();
            String instruksi = detailInstruksiResep.getInstruksi();
            byte[] foto = detailInstruksiResep.getFoto();

            DDLResult result = null;
            
             try {
                connector.checkConnection();
                 result  = connector.executeQueryDML(
                        query, 
                     instruksi,
                     foto,
                     id_resep,
                     no_instruksi_resep
                 );
   
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
     
     public DDLResult deleteDetailInstruksiResepByID(DetailInstruksiResep detailInstruksiResep){
            String query = "DELETE FROM detail_instruksi_resep WHERE id_resep = ?  OR no_instruksi_resep = ?";
           
           int id_resep = detailInstruksiResep.getId_resep();
            String no_instruksi_resep = detailInstruksiResep.getNo_instruksi_resep();
            
       
            DDLResult result = null;
            
             try {
                connector.checkConnection();
                 result  = connector.executeQueryDML(
                        query, 
                     id_resep,
                     no_instruksi_resep);
   
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
     
     public List<DetailInstruksiResepResult> getAlDetailInstruksiResepByRecipeId(Resep resep){
       List<DetailInstruksiResepResult> detailInstruksiResepResultList = new ArrayList<>();
       
         String query = "SELECT * FROM detail_instruksi_resep WHERE id_resep=?";
         
         int id_reseps = resep.getId_resep();

        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query,
                    id_reseps
            
           );
            
            while(result.next()){
                
                int id_resep = result.getInt("id_resep");
                String no_instruksi_resep = result.getString("no_instruksi_resep");
                String instruksi =  result.getString("instruksi");
                byte[] foto = result.getBytes("foto");
                  
                     DetailInstruksiResepResult detailInstruksiResepResult = new DetailInstruksiResepResult(
                             id_resep, 
                             no_instruksi_resep, 
                             instruksi,
                             foto
                     );
                     
                     
                     
                     detailInstruksiResepResultList.add(detailInstruksiResepResult);
            }
       connector.closeResultSet(result);
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally{
            connector.closeConnection();
        }
        
       return  detailInstruksiResepResultList;
    }
}

