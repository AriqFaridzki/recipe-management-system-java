/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Luminescenents
 */
public class DetailInstruksiResep {
    private int id_resep;
    private String no_instruksi_resep;
    private String instruksi;
    private byte[] foto;

    public int getId_resep() {
        return id_resep;
    }

    public void setId_resep(int id_resep) {
        this.id_resep = id_resep;
    }

    public String getNo_instruksi_resep() {
        return no_instruksi_resep;
    }

    public void setNo_instruksi_resep(String no_instruksi_resep) {
        this.no_instruksi_resep = no_instruksi_resep;
    }

    public String getInstruksi() {
        return instruksi;
    }

    public void setInstruksi(String instruksi) {
        this.instruksi = instruksi;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public DetailInstruksiResep(String instruksi) {
        this.instruksi = instruksi;
    }

    public DetailInstruksiResep(String instruksi, byte[] foto) {
        this.instruksi = instruksi;
        this.foto = foto;
    }

    public DetailInstruksiResep(int id_resep) {
        this.id_resep = id_resep;
    }

    public DetailInstruksiResep(String no_instruksi_resep, String instruksi, byte[] foto) {
        this.no_instruksi_resep = no_instruksi_resep;
        this.instruksi = instruksi;
        this.foto = foto;
    }

    public DetailInstruksiResep(int id_resep, String no_instruksi_resep, String instruksi, byte[] foto) {
        this.id_resep = id_resep;
        this.no_instruksi_resep = no_instruksi_resep;
        this.instruksi = instruksi;
        this.foto = foto;
    }
}
