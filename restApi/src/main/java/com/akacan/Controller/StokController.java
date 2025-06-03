package com.akacan.Controller;

import com.akacan.Controller.Impl.IStokControllerImpl;
import com.akacan.Dto.DtoStok;
import com.akacan.Dto.DtoStokUI;
import com.akacan.Entities.Stok;
import com.akacan.Service.Impl.IStokService;
import com.akacan.Service.StokService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/akacan")

public class StokController implements IStokControllerImpl {

    @Autowired
    private StokService stokService;

    @Autowired
    private IStokService stokServiceImpl;

    @GetMapping("/test")
    public String testRest (){
        return "testRest";
    }

    //TODO Burası Verilen Bir Url bilgisindeki Id bilgisini almak veya tek bir kayıt çekmek için kullaınlır. url = http://localhost:8080/rest/akacan/findById/5
    @GetMapping("/findById/{id}")
    public String addRest(@PathVariable(name = "id", required = true) String id){
         return id;
    }

    @GetMapping(path = "/list-stop")
    public List<Stok> getStokList(){


        return stokService.findAll();
    }

    //TODO http://localhost:8080/rest/akacan/stokWithParams?firstname=akacan&lastname=bak. withParam kullanımı ve rest bilgisi

    @GetMapping(path = "/stokWithParams")
    public String getStokWithParams(@RequestParam(name = "firstname", required = false) String firtname,
                                    @RequestParam(name = "lastname", required = false) String lastname){
        System.out.println(firtname + " " + lastname);

        return firtname + " " + lastname;
    }

    //TODO http://localhost:8080/rest/akacan/saveStok/9 rest isteğinde hem PatVariable ve body kullanımı yapıldı
    /*
    {
    "id":98,
    "name":"stokk",
    "description":"descriptionaa"
    }
    */

    @PostMapping(path = "/saveStok/{id}")
    public Stok saveStok(@PathVariable(name = "id", required = false)String id,@RequestBody Stok stok){
        return stok;
    }

     @DeleteMapping("/deleteId/{id}")
    public String deleteRest(@PathVariable(name = "id", required = true) String id){
        return id;
    }

     @DeleteMapping("/updateId/{id}")
    public String updateRest(@PathVariable(name = "id", required = true) String id,@RequestBody Stok stok){
        // güncelleme istenilen alanlar burada yazılacak. Yada servis aracılıpı ile db de güncelleme yapılacaktır.
        return id;
    }


    @Override
    @PostMapping(path = "/stok-save")
    public DtoStok saveStok(@RequestBody @Valid DtoStokUI stokUI) {
        return stokServiceImpl.saveStok(stokUI);
    }

    @Override
    @GetMapping(path = "/list")
    public List<Stok> getStokAll() {

        return stokServiceImpl.findAllStok();
    }

    @Override
    @PostMapping(path = "/listById/{id}")
    public Stok getStokById(@PathVariable(name = "id") int id) {

        return stokServiceImpl.findStokById(id);
    }

    @Override
    @DeleteMapping(path = "/deleteById/{id}")
    public void deleteStokById(@PathVariable(name = "id") int id) {
        stokServiceImpl.deleteStok(id);
    }

    @Override
    @PutMapping(path = "/update/{id}")
    public void updateStok(@PathVariable(name = "id")int id, @RequestBody Stok stok) {
        stokServiceImpl.updateStok(id, stok);

    }


}
