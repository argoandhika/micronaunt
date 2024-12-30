package com.repository;

import com.entity.ManajementAksesEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManajementAksesRepository extends JpaRepository<ManajementAksesEntity, Long> {

    Optional<ManajementAksesEntity> findByRoleCodeAndUri(String roleCode, String uri);
    
   // Metode untuk menemukan entitas berdasarkan ID
   Optional<ManajementAksesEntity> findById(Long id);

   // Metode untuk menghapus entitas berdasarkan ID
   void deleteById(Long id);

   // Metode untuk mendapatkan semua entitas
   List<ManajementAksesEntity> findAll();

}
