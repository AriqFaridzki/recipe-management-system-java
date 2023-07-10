/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Luminescenents
 */
public class JenisMetric {
    private int id_metric;
    private String no_metric;
    private String nama_metric;
    private String keterangan;

    public int getId_metric() {
        return id_metric;
    }

    public void setId_metric(int id_metric) {
        this.id_metric = id_metric;
    }

    public String getNo_metric() {
        return no_metric;
    }

    public JenisMetric(String nama_metric, String keterangan) {
        this.nama_metric = nama_metric;
        this.keterangan = keterangan;
    }

    public void setNo_metric(String no_metric) {
        this.no_metric = no_metric;
    }

    public String getNama_metric() {
        return nama_metric;
    }

    public void setNama_metric(String nama_metric) {
        this.nama_metric = nama_metric;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public JenisMetric(int id_metric) {
        this.id_metric = id_metric;
    }

    public JenisMetric(String no_metric, String nama_metric, String keterangan) {
        this.no_metric = no_metric;
        this.nama_metric = nama_metric;
        this.keterangan = keterangan;
    }

    public JenisMetric(int id_metric, String no_metric, String nama_metric, String keterangan) {
        this.id_metric = id_metric;
        this.no_metric = no_metric;
        this.nama_metric = nama_metric;
        this.keterangan = keterangan;
    }
    
    
}
