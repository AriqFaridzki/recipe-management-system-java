/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;
import Connectors.databaseConnector;
import java.sql.SQLException;
/**
 *
 * @author Luminescenents
 */
import java.sql.ResultSet;
public class TableConfig {
    databaseConnector connector = new databaseConnector();
    
    public int getDbTableId(String theTable, String idTableColumn, String idValueFromRow){ 
        
        int idTable=0;
        try {
              connector.checkConnection();
            String query = "SELECT " + idTableColumn + " FROM " + theTable + " WHERE "+ idTableColumn+" = ?";
           ResultSet result=  connector.executeQueryRead(query, idValueFromRow);
                
            if(result.next()){
                idTable = result.getInt(idTableColumn);
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return idTable;
    }
    

    
    
    public static void main(String [] args){
        TableConfig test = new TableConfig();
        System.out.println(test.getDbTableId("bahan_baku", "id_bahan_baku", "7"));
    }
}
