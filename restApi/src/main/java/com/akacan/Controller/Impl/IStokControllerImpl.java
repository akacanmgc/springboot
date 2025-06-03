package com.akacan.Controller.Impl;

import com.akacan.Dto.DtoStok;
import com.akacan.Dto.DtoStokUI;
import com.akacan.Entities.Stok;

import java.util.List;

public interface IStokControllerImpl {

    public DtoStok saveStok(DtoStokUI stokUI);

    public List<Stok> getStokAll();

    public Stok getStokById(int id);

    public void deleteStokById(int id);

    public void updateStok(int id,Stok stok);
}
