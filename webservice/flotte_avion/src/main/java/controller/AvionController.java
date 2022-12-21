package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mapping.Avion;
import mapping.Vehicule;
import retour.DataRetour;

@RestController
@CrossOrigin("*")
@RequestMapping("/avion")
public class AvionController {

    @GetMapping
    public ResponseEntity<DataRetour> lsavion() throws Exception {
        return ResponseEntity.accepted().body(new Avion().listAvion());
    }

}
