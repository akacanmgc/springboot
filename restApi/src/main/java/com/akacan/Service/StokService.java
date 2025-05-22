package com.akacan.Service;

import com.akacan.Entities.Stok;
import com.akacan.Repository.StokRepository;
import org.springframework.stereotype.Service;

@Service
public class StokService {

    private StokRepository stokRepository;

    public Stok addStok(Stok stok){

        Stok stokAdd = new Stok();
        stokAdd.setName(stok.getName());
        stokAdd.setDescription(stok.getDescription());
        this.stokRepository.save(stokAdd);
        return null;
    }

}
