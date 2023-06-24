/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Luminescenents
 */
public class DetailBahanResep {
    private int id_resep;
    private String no_bahan_resep;
    private int id_bahan_baku;
    private byte[] foto;
    private int qty;
    private int id_metric;

    public int getId_resep() {
        return id_resep;
    }

    public void setId_resep(int id_resep) {
        this.id_resep = id_resep;
    }

    public String getNo_bahan_resep() {
        return no_bahan_resep;
    }

    public void setNo_bahan_resep(String no_bahan_resep) {
        this.no_bahan_resep = no_bahan_resep;
    }

    public int getId_bahan_baku() {
        return id_bahan_baku;
    }

    public void setId_bahan_baku(int id_bahan_baku) {
        this.id_bahan_baku = id_bahan_baku;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getId_metric() {
        return id_metric;
    }

    public void setId_metric(int id_metric) {
        this.id_metric = id_metric;
    }
    
    public DetailBahanResep(String no_bahan_resep, int id_bahan_baku, byte[] foto, int qty, int id_metric) {
        this.no_bahan_resep = no_bahan_resep;
        this.id_bahan_baku = id_bahan_baku;
        this.foto = foto;
        this.qty = qty;
        this.id_metric = id_metric;
    }

    public DetailBahanResep(int id_resep, String no_bahan_resep, int id_bahan_baku, byte[] foto, int qty, int id_metric) {
        this.id_resep = id_resep;
        this.no_bahan_resep = no_bahan_resep;
        this.id_bahan_baku = id_bahan_baku;
        this.foto = foto;
        this.qty = qty;
        this.id_metric = id_metric;
    }
    
    
}
