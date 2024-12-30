package com.entity;

import io.micronaut.core.annotation.Introspected;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Introspected
@Table(name = "jenis_emas")
public class JenisEmasEntity extends AbstractEntity{
    private String nama;
    private String kode;
    // Getters and Setters
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getKode() {
        return kode;
    }
    public void setKode(String kode) {
        this.kode = kode;
    }
}
