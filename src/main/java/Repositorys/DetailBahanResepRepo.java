/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorys;

import Connectors.DDLResult;
import Connectors.databaseConnector;
import Objects.DetailBahanResepResult;
import Objects.DetailBahanResep;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Objects.Resep;

/**
 *
 * @author Luminescenents
 */
public class DetailBahanResepRepo {
    
      databaseConnector connector = new databaseConnector();
      
      public DDLResult addDetailBahanResep(DetailBahanResep detailBahanResep){
            String query = "INSERT INTO detail_bahan_resep (id_resep, id_bahan_baku, qty, id_metric, foto) VALUES (?,?,?,?,?)";
            String queryUpdate = "UPDATE detail_bahan_resep SET no_bahan_resep = ? WHERE id_resep = ?";
           
            
            
            int id_resep = detailBahanResep.getId_resep();
//            String no_bahan_resep = detailBahanResep.getNo_bahan_resep();
            String no_bahan_resep ="BHNR"  + id_resep;
            int id_bahan_baku = detailBahanResep.getId_bahan_baku();
            int qty = detailBahanResep.getQty();
            int id_metric = detailBahanResep.getId_metric();
            byte[] foto = detailBahanResep.getFoto();
            
            DDLResult result = null;
            
            
             try {
                connector.checkConnection();
                 result  = connector.executeQueryDML(
                        query, 
                         
                        id_resep,
                        id_bahan_baku,
                        qty,
                        id_metric,
                        foto
                        ); 
                 
                 
                 connector.executeQueryDML(
                         queryUpdate, 
                         
                         no_bahan_resep,
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
     
     public DDLResult UpdateDetailBahanResepById(DetailBahanResep detailBahanResep){
            String query = "UPDATE detail_bahan_resep SET id_bahan_baku=?,qty=?,id_metric=?,foto=? WHERE id_resep = ? OR no_bahan_resep=? ";
           
             int id_resep = detailBahanResep.getId_resep();
            String no_bahan_resep = detailBahanResep.getNo_bahan_resep();
            int id_bahan_baku = detailBahanResep.getId_bahan_baku();
            int qty = detailBahanResep.getQty();
            int id_metric = detailBahanResep.getId_metric();
            byte[] foto = detailBahanResep.getFoto();
            
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
                     id_bahan_baku,
                     qty,
                     id_metric,
                     foto,
                     id_resep,
                     no_bahan_resep);
   
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
     
     public DDLResult deleteDetailBahanResepByID(DetailBahanResep detailBahanResep){
            String query = "DELETE FROM detail_bahan_resep WHERE id_resep = ?  OR no_bahan_resep = ?";
           
            int id_resep = detailBahanResep.getId_resep();
            String no_bahan_resep = detailBahanResep.getNo_bahan_resep();
            
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
                     no_bahan_resep);
   
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
     
     public List<DetailBahanResepResult> getAllDetailBahanResepByRecipeId(Resep resep){
       List<DetailBahanResepResult> DetailBahanResepResultList = new ArrayList<>();
       
       int id_reseps = resep.getId_resep();
       
//       String query = "SELECT * FROM detail_bahan_resep"; // HARUS JOIN
         String query = "SELECT detail_bahan_resep.id_resep, detail_bahan_resep.no_bahan_resep, bahan_baku.nama_bahan , detail_bahan_resep.qty, jenis_metric.nama_metric, detail_bahan_resep.foto "
                                 + "FROM resep" +
                                 "INNER JOIN detail_bahan_resep ON resep.id_resep = detail_bahan_resep.id_resep" +
                                 "INNER JOIN jenis_metric ON jenis_metric.id_metric = detail_bahan_resep.id_metric" +
                                 "INNER JOIN bahan_baku ON bahan_baku.id_bahan_baku = detail_bahan_resep.id_bahan_baku"
                                 + "WHERE id_resep=?";
       

        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query,
            id_reseps
            );
            
            while(result.next()){
                
                int id_resep = result.getInt("id_resep");
                String no_bahan_resep = result.getString("no_bahan_resep");
                String nama_bahan =  result.getString("nama_bahan");
                int qty = result.getInt("qty");
                String nama_metric = result.getString("nama_metric");
                byte[] foto = result.getBytes("foto");
                  
                     DetailBahanResepResult detailBahanResepResult = new DetailBahanResepResult(
                             id_resep, 
                             no_bahan_resep, 
                             nama_bahan,
                             qty,       
                             nama_metric,
                             foto
                     );
                     
                     
                     
                     DetailBahanResepResultList.add(detailBahanResepResult);
            }
       connector.closeResultSet(result);
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally{
            connector.closeConnection();
        }
        
       return  DetailBahanResepResultList;
    }
    
}
