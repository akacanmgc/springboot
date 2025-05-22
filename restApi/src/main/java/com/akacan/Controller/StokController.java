package com.akacan.Controller;

import com.akacan.Entities.Stok;
import com.akacan.Service.StokService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/akacan")

public class StokController {

    @Autowired
    private StokService stokService;

    @GetMapping("/test")
    public String testRest (){

        return "testRest";
    }

    //TODO Burası Verilen Bir Url bilgisindeki Id bilgisini almak veya tek bir kayıt çekmek için kullaınlır. url = http://localhost:8080/rest/akacan/findById/5
    @GetMapping("/findById/{id}")
    public String addRest(@PathVariable(name = "id", required = true) String id){
         return id;
    }
}
