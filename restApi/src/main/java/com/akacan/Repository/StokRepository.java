package com.akacan.Repository;

import com.akacan.Entities.Stok;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StokRepository extends JpaRepository<Stok,Long> {

}
