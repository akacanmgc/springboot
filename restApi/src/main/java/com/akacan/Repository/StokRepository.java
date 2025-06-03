package com.akacan.Repository;

import com.akacan.Entities.Stok;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface StokRepository extends JpaRepository<Stok, Integer> {

    // HQL kullanımı
    @Query(value = " from Stok" , nativeQuery = false)
    List<Stok> findAll();

    // HQL kullanımı
    @Query(value = " from Stok s  where s.id = :id" , nativeQuery = false)
    Optional<Stok> findAllParam(int id);

    // Sql kullanımı
    @Query(value = "select * from semaadi.stok" , nativeQuery = true)
    List<Stok> findAllSql();

}
