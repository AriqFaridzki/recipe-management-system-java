/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Luminescenents
 */
public class Kategori {
    
    private int id_kategori;
    private String no_kategori;
    private String nama_Kategori;
    private String tipe_kategori;
    private int id_taggable;

    public Kategori(int id_kategori, String no_kategori, String nama_Kategori, String tipe_kategori) {
        this.id_kategori = id_kategori;
        this.no_kategori = no_kategori;
        this.nama_Kategori = nama_Kategori;
        this.tipe_kategori = tipe_kategori;
    }

    public Kategori(String nama_Kategori) {
        this.nama_Kategori = nama_Kategori;
    }

    public String getTipe_kategori() {
        return tipe_kategori;
    }

    public void setTipe_kategori(String tipe_kategori) {
        this.tipe_kategori = tipe_kategori;
    }
    

    public Kategori(int id_kategori, String no_kategori, String nama_Kategori) {
        this.id_kategori = id_kategori;
        this.no_kategori = no_kategori;
        this.nama_Kategori = nama_Kategori;
    }

    public Kategori(String no_kategori, String nama_Kategori) {
        this.no_kategori = no_kategori;
        this.nama_Kategori = nama_Kategori;
    }

    public int getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(int id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getNo_kategori() {
        return no_kategori;
    }

    public void setNo_kategori(String no_kategori) {
        this.no_kategori = no_kategori;
    }

    public String getNama_Kategori() {
        return nama_Kategori;
    }

    public void setNama_Kategori(String nama_Kategori) {
        this.nama_Kategori = nama_Kategori;
    }

    public Kategori(String nama_Kategori, int id_taggable) {
        this.nama_Kategori = nama_Kategori;
        this.id_taggable = id_taggable;
    }

    public int getId_taggable() {
        return id_taggable;
    }

    public void setId_taggable(int id_taggable) {
        this.id_taggable = id_taggable;
    }

   
    
}
