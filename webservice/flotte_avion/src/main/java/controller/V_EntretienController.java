package controller;

import mapping.V_Entretien;
import mapping.Vehicule;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retour.DataRetour;

@RestController
@CrossOrigin("*")
@RequestMapping("/entretien")
public class V_EntretienController {

    @GetMapping("/{id}")
    public ResponseEntity<DataRetour> listEntretien(@PathVariable(value = "id") int id) throws Exception {
        return ResponseEntity.accepted().body(new V_Entretien().listEntretien(id));

    }
}
