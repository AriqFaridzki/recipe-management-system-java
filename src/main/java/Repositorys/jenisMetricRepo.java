/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorys;

import Connectors.DDLResult;
import Connectors.databaseConnector;
import Objects.BahanBaku;
import Objects.JenisMetric;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luminescenents
 */
public class jenisMetricRepo {
           databaseConnector connector = new databaseConnector();
      
      public DDLResult addJenisMetric(JenisMetric jenisMetric){
            String query = "INSERT INTO jenis_Metric (nama_metric, keterangan) VALUES (?,?)";
            String queryUpdate = "UPDATE jenis_Metric SET no_metric = ? WHERE id_metric = ?";
           
            
            
       
            String nama_metric = jenisMetric.getNama_metric();
            String Keterangan = jenisMetric.getKeterangan();
            
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
                    
                        nama_metric,
                        Keterangan);
                 
                 int id_metric = result.getGeneratedKeys();
                 String no_metric  = "UNIT" + id_metric;
                 
                 connector.executeQueryDML(
                         queryUpdate, 
                         
                         no_metric,
                         id_metric);
   
           
            } catch (SQLException e) {
               e.printStackTrace();
               
            } finally {
                connector.closeConnection();
             
        }

//        System.out.println(values);
//        System.out.println("berhasil coy " + RowsAffected);
       return result;
    } // not tested
     
     public DDLResult UpdateJenisMetricById(JenisMetric jenisMetric){
            String query = "UPDATE jenis_metric SET nama_metric=?,keterangan=? WHERE id_metric = ? OR no_metric=? ";
           
            int id_metric = jenisMetric.getId_metric();
            String no_metric = jenisMetric.getNo_metric();
            String nama_metric = jenisMetric.getNama_metric();
            String Keterangan = jenisMetric.getKeterangan();
            
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
                     nama_metric,
                     Keterangan,
                     id_metric,
                     no_metric);
   
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
     
     public DDLResult deleteJenisMetricByID(JenisMetric jenisMetric){
            String query = "DELETE FROM jenis_metric WHERE id_metric = ?  OR no_metric = ?";
           
            int id_metric = jenisMetric.getId_metric();
            String no_metric = jenisMetric.getNo_metric();
            
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
                     id_metric,
                     no_metric);
   
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
     
     public List<JenisMetric> getAllJenisMetric(){
       List<JenisMetric> JenisMetricList = new ArrayList<>();
       
       String query = "SELECT * FROM jenis_metric";

        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query);
            
            while(result.next()){
                
                int id_metric = result.getInt("id_metric");
                String no_metric = result.getString("no_metric");
                String nama_metric =  result.getString("nama_metric");
                String Keterangan = result.getString("keterangan");
                  
                     JenisMetric JenisMetric = new JenisMetric(
                             id_metric, 
                             no_metric, 
                             nama_metric,
                     Keterangan);
                     
                     JenisMetricList.add(JenisMetric);
            }
       connector.closeResultSet(result);
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally{
            connector.closeConnection();
        }
        
       return  JenisMetricList;
    }
     
      public List<JenisMetric> getJenisMetricByName(String nama_metric){
           List<JenisMetric> JenisMetricList = new ArrayList<>();
       
       String query = "SELECT * FROM jenis_metric WHERE nama_metric LIKE CONCAT(?, '%')";// belum fix

        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query, nama_metric);
            
          while(result.next()){
                
                int id_metric = result.getInt("id_metric");
                String no_metric = result.getString("no_metric");
                String nama_metrics =  result.getString("nama_metric");
                String Keterangan = result.getString("keterangan");
                  
                     JenisMetric JenisMetric = new JenisMetric(
                             id_metric, 
                             no_metric, 
                             nama_metrics,
                     Keterangan);
                     
                     JenisMetricList.add(JenisMetric);
            }
       connector.closeResultSet(result);
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally{
            connector.closeConnection();
        }
        
       return  JenisMetricList;
    }
    
       public JenisMetric getJenisMetricByID(int id_metric){
       
       String query = "SELECT * FROM jenis_metric WHERE id_metric=?";

        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query, id_metric);
            
          while(result.next()){
                
                int id_metrics = result.getInt("id_metric");
                String no_metric = result.getString("no_metric");
                String nama_metrics =  result.getString("nama_metric");
                String Keterangan = result.getString("keterangan");
                 
                return new JenisMetric(id_metrics, no_metric, nama_metrics, Keterangan);
            }
       connector.closeResultSet(result);
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally{
            connector.closeConnection();
        }
        
       return null;
    }
       
       public JenisMetric getJenisMetricByNameAdd(String nama_metric){
       
       String query = "SELECT * FROM jenis_metric WHERE nama_metric=?";

        try {
            connector.checkConnection();
            ResultSet result = connector.executeQueryRead(
                    query, nama_metric);
            
          while(result.next()){
                
                int id_metrics = result.getInt("id_metric");
                String no_metric = result.getString("no_metric");
                String nama_metrics =  result.getString("nama_metric");
                String Keterangan = result.getString("keterangan");
                 
                return new JenisMetric(id_metrics, no_metric, nama_metrics, Keterangan);
            }
       connector.closeResultSet(result);
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally{
            connector.closeConnection();
        }
        
       return null;
    }
       
       
}
