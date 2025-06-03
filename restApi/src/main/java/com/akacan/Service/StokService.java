package com.akacan.Service;

import com.akacan.Dto.DtoStok;
import com.akacan.Dto.DtoStokUI;
import com.akacan.Entities.Stok;
import com.akacan.Repository.StokRepository;
import com.akacan.Service.Impl.IStokService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StokService implements IStokService {

    @Autowired
    private StokRepository stokRepository;

    public List<Stok> findAll(){


        return stokRepository.findAll();
    }

    @Override
    public DtoStok saveStok(DtoStokUI dtoStokUI) {
        Stok stok = new Stok();
        DtoStok dtoStok = new DtoStok();
        BeanUtils.copyProperties(dtoStokUI,stok);

        Stok saveStok = stokRepository.save(stok);

         BeanUtils.copyProperties(saveStok,dtoStok);
        return dtoStok;
    }

    @Override
    public List<Stok> findAllStok() {
        return stokRepository.findAll();
    }

    @Override
    public Stok findStokById(int id) {
        Optional<Stok> stok = stokRepository.findById(id);
        if (stok.isPresent()) {
            return stok.get();
        }
        return null;
    }

    @Override
    public void deleteStok(int id) {
        Stok stok = findStokById(id);
        stokRepository.delete(stok);
    }

    @Override
    public void updateStok(int id , Stok updateStok) {
        Stok stok = findStokById(id);
        if (stok != null) {
            stok.setName(updateStok.getName());
            stok.setDescription(updateStok.getDescription());
            stok.setDate(updateStok.getDate());
            stokRepository.save(stok);
        }
        stokRepository.save(stok);
     }
}
