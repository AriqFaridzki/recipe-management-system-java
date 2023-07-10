/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Luminescenents
 */
public class bahanBakuDetail {
    private int id_bahan_baku;
    private String no_bahan_baku_detail;
    private int harga;
    private String brand;
    private int id_metric;

    public bahanBakuDetail(int id_bahan_baku, int harga, String brand) {
        this.id_bahan_baku = id_bahan_baku;
        this.harga = harga;
        this.brand = brand;
    }

    public bahanBakuDetail(int harga, String brand, int id_metric) {
        this.harga = harga;
        this.brand = brand;
        this.id_metric = id_metric;
    }

    public int getId_metric() {
        return id_metric;
    }

    public bahanBakuDetail(int id_bahan_baku, int harga, String brand, int id_metric) {
        this.id_bahan_baku = id_bahan_baku;
        this.harga = harga;
        this.brand = brand;
        this.id_metric = id_metric;
    }

    public void setId_metric(int id_metric) {
        this.id_metric = id_metric;
    }

    public bahanBakuDetail(int id_bahan_baku, String no_bahan_baku_detail, int harga, String brand, int id_metric) {
        this.id_bahan_baku = id_bahan_baku;
        this.no_bahan_baku_detail = no_bahan_baku_detail;
        this.harga = harga;
        this.brand = brand;
        this.id_metric = id_metric;
    }

    public bahanBakuDetail(int id_bahan_baku, String brand) {
        this.id_bahan_baku = id_bahan_baku;
        this.brand = brand;
    }

    public String getNo_bahan_baku() {
        return no_bahan_baku_detail;
    }

    public bahanBakuDetail(int id_bahan_baku, String no_bahan_baku_detail, int harga, String brand) {
        this.id_bahan_baku = id_bahan_baku;
        this.no_bahan_baku_detail = no_bahan_baku_detail;
        this.harga = harga;
        this.brand = brand;
    }

    public String getNo_bahan_baku_detail() {
        return no_bahan_baku_detail;
    }
    

    public void setNo_bahan_baku_detail(String no_bahan_baku_detail) {
        this.no_bahan_baku_detail = no_bahan_baku_detail;
    }

    public void setNo_bahan_baku(String no_bahan_baku) {
        this.no_bahan_baku_detail = no_bahan_baku;
    }

    public bahanBakuDetail(int id_bahan_baku, int harga) {
        this.id_bahan_baku = id_bahan_baku;
        this.harga = harga;
    }

    public int getId_bahan_baku() {
        return id_bahan_baku;
    }

    public void setId_bahan_baku(int id_bahan_baku) {
        this.id_bahan_baku = id_bahan_baku;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
   
    
    
    
    
    
}
