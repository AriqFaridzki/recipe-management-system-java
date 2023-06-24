/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Luminescenents
 */
public class Resep {
    private int id_resep;
    private String no_resep;
    private String nama_resep;
    private String deskripsiField;
    private byte[] fotoField;

     public Resep(String no_resep, String nama_resep, String deskripsiField, byte[] fotoField) {
        this.no_resep = no_resep;
        this.nama_resep = nama_resep;
        this.deskripsiField = deskripsiField;
        this.fotoField = fotoField;
    }

    public Resep(int id_resep, String no_resep, String nama_resep, String deskripsiField, byte[] fotoField) {
        this.id_resep = id_resep;
        this.no_resep = no_resep;
        this.nama_resep = nama_resep;
        this.deskripsiField = deskripsiField;
        this.fotoField = fotoField;
    }
    
    public int getId_resep() {
        return id_resep;
    }

    public void setId_resep(int id_resep) {
        this.id_resep = id_resep;
    }

    public String getNo_resep() {
        return no_resep;
    }

    public void setNo_resep(String no_resep) {
        this.no_resep = no_resep;
    }

    public String getNama_resep() {
        return nama_resep;
    }

    public void setNama_resep(String nama_resep) {
        this.nama_resep = nama_resep;
    }

    public String getDeskripsiField() {
        return deskripsiField;
    }

    public void setDeskripsiField(String deskripsiField) {
        this.deskripsiField = deskripsiField;
    }

    public byte[] getFotoField() {
        return fotoField;
    }

    public void setFotoField(byte[] fotoField) {
        this.fotoField = fotoField;
    }

   
    
}
