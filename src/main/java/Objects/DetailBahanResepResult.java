/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Luminescenents
 */

public class DetailBahanResepResult {
    private int id_resep;
    private String no_bahan_resep;
    private String nama_bahan;
    private int qty;
    private String nama_metric;
    private byte[] foto;

    public DetailBahanResepResult(int id_resep, String no_bahan_resep, String nama_bahan, int qty, String nama_metric, byte[] foto) {
        this.id_resep = id_resep;
        this.no_bahan_resep = no_bahan_resep;
        this.nama_bahan = nama_bahan;
        this.qty = qty;
        this.nama_metric = nama_metric;
        this.foto = foto;
    }

    // Getters and Setters
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

    public String getNama_bahan() {
        return nama_bahan;
    }

    public void setNama_bahan(String nama_bahan) {
        this.nama_bahan = nama_bahan;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getNama_metric() {
        return nama_metric;
    }

    public void setNama_metric(String nama_metric) {
        this.nama_metric = nama_metric;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
