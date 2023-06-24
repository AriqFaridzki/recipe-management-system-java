/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorys;
import Objects.BahanBaku;
import Connectors.DDLResult;
import java.util.List;



/**
 *
 * @author Luminescenents
 */
public class testing {
    public static void main(String [] args){
        byte[] foto = null;
        
//        BahanBaku bahanBaku = new BahanBaku(1, "Buncis", "Hijau Buncis enakksss");
        BahanBaku bahanBaku = new BahanBaku(2, "BBK2", "Cabao" ,foto,"asda");
        BahanBakuRepo repo = new BahanBakuRepo();
        
//        DDLResult result = repo.addBahanBaku(bahanBaku);
//        DDLResult result= repo.updateBahanBakuById(bahanBaku);
//          DDLResult result= repo.deleteBahanBakuAddByID(bahanBaku);
//bahanBakuList[1]
                    List<BahanBaku> bahanBakuList = repo.getAllBahanBaku();
                    for (int i = 0; i < bahanBakuList.size(); i++) {
                        
                        BahanBaku bahanBakuResult = bahanBakuList.get(i);
                        
                        int idBahanBaku = bahanBakuResult.getIdBahanBaku();
                        String noBahanBaku  = bahanBakuResult.getNo_bahan_baku();
                        String namaBahan = bahanBakuResult.getNamaBahan();
                        String keterangan = bahanBakuResult.getKeterangan();
                        byte[] fotos = bahanBakuResult.getFoto();
                        
                        System.out.println("idBahanBaku :" + idBahanBaku);
                        System.out.println("noBahanBaku :" + noBahanBaku);
                        System.out.println("namaBahan :" + namaBahan);
                        System.out.println("keterangan :" + keterangan);
                        System.out.println("fotos :" + fotos+ "\n\n");
                        
            
        }



//        DDLResult resultUpdate = repo.updateBahanBaku(bahanBaku, result.getGeneratedKeys());
//        repo.updateBahanBaku(bahanBaku, result.getGeneratedKeys());
        
//        System.out.println("RowsAffected  : " + result.getRowsAffected() );
//        System.out.println("GeneratedKeys : " + result.getGeneratedKeys());
        
    }
    
    
}
