package com.akacan.Service.Impl;

import com.akacan.Dto.DtoStok;
import com.akacan.Dto.DtoStokUI;
import com.akacan.Entities.Stok;

import java.util.List;

public interface IStokService {
    public DtoStok saveStok(DtoStokUI stok);

    public List<Stok> findAllStok();

    public Stok findStokById(int id);

    public void deleteStok(int id);

    public void updateStok(int id ,Stok updateStok);
}
