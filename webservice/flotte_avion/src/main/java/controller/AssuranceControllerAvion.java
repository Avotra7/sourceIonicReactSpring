package controller;

import mapping.AssuranceA;
import mapping.Trajet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retour.DataRetour;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/assurance")
public class AssuranceControllerAvion {

    @GetMapping
    public List<AssuranceA> listAssurancetroisM() throws Exception {
        return new AssuranceA().getAssuranceThreeMonth();

    }

    // @GetMapping("/one")
    // public ResponseEntity<?>listAssuranceUnMois(){
    // try {
    // return ResponseEntity.accepted().body(new
    // AssuranceAvion().getAssuranceOneMonth());
    // } catch (Exception e) {
    // return new ResponseEntity(new ShowError(new NullException(403,"Assurance not
    // found")), HttpStatus.NOT_FOUND);
    // }
    // }

}
