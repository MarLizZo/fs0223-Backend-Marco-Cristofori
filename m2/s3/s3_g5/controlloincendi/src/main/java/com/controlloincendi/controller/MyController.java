package com.controlloincendi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlloincendi.models.CustomResponse;
import com.controlloincendi.models.Sonda;
import com.controlloincendi.service.MyService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class MyController {

    @Autowired
    MyService svc;

    @PostMapping("/alert")
    public ResponseEntity<CustomResponse> getAlert(@RequestBody Sonda sonda) {
        if (sonda.getLivelloFumo() >= 4) {
            return new ResponseEntity<CustomResponse>(this.svc.allertaVigili(sonda), HttpStatus.OK);
        } else {
            String str = "Ricevuto warning per la Sonda " + sonda.getName() + " con livello di fumo "
                    + sonda.getLivelloFumo();
            System.out.println(str);
            return new ResponseEntity<CustomResponse>(new CustomResponse(str, false, null, null), HttpStatus.OK);
        }
    }
}
