package controller;

import exception.NullException;
import exception.ShowError;
import mapping.AssuranceVehicule;
import mapping.Vehicule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/assurancev")
public class AssuranceController {

    @GetMapping("/{nbmonth}")
    public ResponseEntity<?> listAssurance(@PathVariable(value = "nbmonth") int nbmonth) {
        try {
            return ResponseEntity.accepted().body(new AssuranceVehicule().getAssuranceMonth(nbmonth));
        } catch (Exception e) {
            return new ResponseEntity(new ShowError(new NullException(403, "Assurance not found")),
                    HttpStatus.NOT_FOUND);
        }
    }

}
