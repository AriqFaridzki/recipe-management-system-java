/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Luminescenents
 */
public class Taggable {
    private int id_taggable;
    private String no_taggable;
    private String tipe_taggable;

    public Taggable(String no_taggable, String tipe_taggable) {
        this.no_taggable = no_taggable;
        this.tipe_taggable = tipe_taggable;
    }

    public Taggable(int id_taggable, String no_taggable, String tipe_taggable) {
        this.id_taggable = id_taggable;
        this.no_taggable = no_taggable;
        this.tipe_taggable = tipe_taggable;
    }

    public int getId_taggable() {
        return id_taggable;
    }

    public void setId_taggable(int id_taggable) {
        this.id_taggable = id_taggable;
    }

    public String getNo_taggable() {
        return no_taggable;
    }

    public void setNo_taggable(String no_taggable) {
        this.no_taggable = no_taggable;
    }

    public String getTipe_taggable() {
        return tipe_taggable;
    }

    public void setTipe_taggable(String tipe_taggable) {
        this.tipe_taggable = tipe_taggable;
    }


    public Taggable(String tipe_taggable) {
        this.tipe_taggable = tipe_taggable;
    }
    
}
