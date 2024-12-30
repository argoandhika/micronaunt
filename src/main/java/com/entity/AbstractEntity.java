package com.entity;

import java.time.LocalDateTime;

import io.micronaut.data.annotation.DateCreated;
import io.micronaut.data.annotation.DateUpdated;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;

@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @DateCreated
    @Column(name = "created_at", nullable =false, updatable = false)
    private LocalDateTime created_at;
    
    @Column(name = "created_by", nullable = false, updatable = false, length = 50)
    private String created_by;
    
    @DateUpdated
    @Column(name = "updated_at")
    private LocalDateTime update_at;
       
    @Column(name = "updated_by", length = 50)
    private String update_by;
    
    @Version
    @Column(name = "version", nullable = false)
    private Long version;
    
    @Column(name = "status", nullable = false,  length = 1)
    private Integer status;
    
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public LocalDateTime getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(LocalDateTime update_at) {
        this.update_at = update_at;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    // public String getFormattedCreatedAt() {
    //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    //     return created_at.format(formatter);
    // }

    // public String getFormattedUpdateAt() {
    //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    //     return update_at.format(formatter);
    // }
}
