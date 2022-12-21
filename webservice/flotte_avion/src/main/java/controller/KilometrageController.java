package controller;

import mapping.Kilometrage;
import mapping.V_Entretien;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retour.DataRetour;

@RestController
@CrossOrigin("*")
@RequestMapping("/kilometrage")
public class KilometrageController {
    @GetMapping
    public ResponseEntity<DataRetour> listKilometrage() throws Exception {
        return ResponseEntity.accepted().body(new Kilometrage().listKilometrage());

    }
}
