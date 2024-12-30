package com.entity;

import io.micronaut.core.annotation.Introspected;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Introspected
@Table(name = "jenis_po")
public class JenisPoEntity extends AbstractEntity{
    private String nama_po;
    private String kode_po;
    // Getters and Setters
    public String getNama_po() {
        return nama_po;
    }
    public void setNama_po(String nama_po) {
        this.nama_po = nama_po;
    }
    public String getKode_po() {
        return kode_po;
    }
    public void setKode_po(String kode_po) {
        this.kode_po = kode_po;
    }

}
