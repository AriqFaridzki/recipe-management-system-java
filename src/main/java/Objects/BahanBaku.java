/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Luminescenents
 */
public class BahanBaku {
    private int id_bahan_baku;
    private String no_bahan_baku;
    private String nama_bahan;
    private byte[] foto;
    private String keterangan;
    private String nama_kategori;

    public BahanBaku(int id_bahan_baku, String no_bahan_baku, String nama_bahan, byte[] foto, String keterangan) {
        this.id_bahan_baku = id_bahan_baku;
        this.no_bahan_baku = no_bahan_baku;
        this.nama_bahan = nama_bahan;
        this.foto = foto;
        this.keterangan = keterangan;
    }
    
    public BahanBaku(int id_bahan_baku, String no_bahan_baku, String nama_bahan, byte[] foto, String keterangan, String nama_kategori) {
        this.id_bahan_baku = id_bahan_baku;
        this.no_bahan_baku = no_bahan_baku;
        this.nama_bahan = nama_bahan;
        this.foto = foto;
        this.keterangan = keterangan;
        this.nama_kategori = nama_kategori;
    }
    
    

    public BahanBaku(int id_bahan_baku, String nama_bahan, byte[] foto, String keterangan) {
        this.id_bahan_baku = id_bahan_baku;
        this.nama_bahan = nama_bahan;
        this.foto = foto;
        this.keterangan = keterangan;
    }

    public BahanBaku(String nama_bahan, String keterangan) {
         this.nama_bahan = nama_bahan;
         this.keterangan = keterangan;
    }

    
    public BahanBaku(int id_bahan_baku) {
        this.id_bahan_baku = id_bahan_baku;
    }

    public BahanBaku(int id_bahan_baku, String nama_bahan, String keterangan) {
        this.id_bahan_baku = id_bahan_baku;
        this.nama_bahan = nama_bahan;
        this.keterangan = keterangan;
    }

    public int getId_bahan_baku() {
        return id_bahan_baku;
    }

    public void setId_bahan_baku(int id_bahan_baku) {
        this.id_bahan_baku = id_bahan_baku;
    }

    public String getNama_bahan() {
        return nama_bahan;
    }

    public void setNama_bahan(String nama_bahan) {
        this.nama_bahan = nama_bahan;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }

    public String getNo_bahan_baku() {
        return no_bahan_baku;
    }

    public void setNo_bahan_baku(String no_bahan_baku) {
        this.no_bahan_baku = no_bahan_baku;
    }
   
    
    public int getIdBahanBaku() {
        return id_bahan_baku;
    }

    public void setIdBahanBaku(int id_bahan_baku) {
        this.id_bahan_baku = id_bahan_baku;
    }

    public String getNamaBahan() {
        return nama_bahan;
    }

    public void setNamaBahan(String nama_bahan) {
        this.nama_bahan = nama_bahan;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
