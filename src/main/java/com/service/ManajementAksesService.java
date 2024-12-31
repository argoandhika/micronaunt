package com.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import com.dto.CreateManejementAksesDTO;
import com.entity.ManajementAksesEntity;
import com.exception.impl.ConflictException;
import com.repository.ManajementAksesRepository;

import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;

@Singleton
public class ManajementAksesService {
    private final ManajementAksesRepository manajementAksesRepository;

    public ManajementAksesService(ManajementAksesRepository manajementAksesRepository) {
        this.manajementAksesRepository = manajementAksesRepository;
    }

    public ManajementAksesEntity createAccess(CreateManejementAksesDTO dto) throws Exception {
        Optional<ManajementAksesEntity> existingAccess = manajementAksesRepository.findByRoleCodeAndUri(dto.getRole_code(), dto.getUri());
        if (existingAccess.isPresent()) {
            throw new ConflictException("Access already exists");
        }
        ManajementAksesEntity entity = new ManajementAksesEntity();
        entity.setRoleName(dto.getRole_name());
        entity.setRoleCode(dto.getRole_code());
        entity.setUri(dto.getUri());
        entity.setCreated_at(LocalDateTime.now());
        entity.setCreated_by("DMUSER");
        entity.setVersion(System.currentTimeMillis());
        entity.setStatus(1);
        return manajementAksesRepository.save(entity);
    }

    public void deleteAccess(Long accessId) {
        manajementAksesRepository.deleteById(accessId);
    }

    public Optional<ManajementAksesEntity> getAccess(Long accessId) {
        return manajementAksesRepository.findById(accessId);
    }

    public List<ManajementAksesEntity> getAllAccess() {
        return manajementAksesRepository.findAll();
    }

    @Transactional
    public ManajementAksesEntity updateAccess(Long accessId, ManajementAksesEntity updatedAccess ) throws Exception {
        Optional<ManajementAksesEntity> existingAccess = manajementAksesRepository.findById(accessId);
    
        if (existingAccess.isPresent()) {
            ManajementAksesEntity entityToUpdate = existingAccess.get();
            // BeanUtils.copyProperties(updatedAccess, entityToUpdate, "id", "created_at", "created_by");
            // Perbarui nilai-nilai yang diperlukan
            entityToUpdate.setRoleCode(updatedAccess.getRoleCode());
            entityToUpdate.setRoleName(updatedAccess.getRoleName());
            entityToUpdate.setUri(updatedAccess.getUri());
            entityToUpdate.setVersion(System.currentTimeMillis());
            entityToUpdate.setUpdate_at(LocalDateTime.now()); // Atur waktu pembaruan
            entityToUpdate.setUpdate_by("DMUSER"); // Atur siapa yang memperbarui
            
            // Simpan entitas yang diperbarui
            return manajementAksesRepository.update(entityToUpdate);
        } else {
            throw new Exception("Access not found");
        }
    }
}
