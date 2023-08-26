package com.controlloincendi.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlloincendi.models.CustomResponse;
import com.controlloincendi.models.CustomResponseInt;
import com.controlloincendi.models.Sonda;
import com.controlloincendi.models.TeamPompieri;
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

    @PostMapping("/intervento")
    public ResponseEntity<CustomResponseInt> setRitornoInCaserma(@RequestBody TeamPompieri t) {
        System.out.println("Endpoint intervento pingato");
        if (t.getId() != null) {
            if (svc.setIntervento(t, false) != null) {
                return new ResponseEntity<CustomResponseInt>(new CustomResponseInt(
                        "** Team contrassegnato come tornato in caserma e di nuovo disponibile **",
                        LocalDate.now()), HttpStatus.OK);
            } else {
                return new ResponseEntity<CustomResponseInt>(
                        new CustomResponseInt("** Errore nella procedura.. So guai seri. **", LocalDate.now()),
                        HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<CustomResponseInt>(
                    new CustomResponseInt("** ID null, so guai veramente seri.. **", LocalDate.now()),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
