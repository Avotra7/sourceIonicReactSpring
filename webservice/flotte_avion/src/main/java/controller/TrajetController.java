package controller;

import exception.NullException;
import exception.ShowError;
import jdk.net.SocketFlow;
import mapping.Trajet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import retour.DataRetour;

import java.sql.SQLException;

@RestController
@CrossOrigin("*")
@RequestMapping("/trajet")
public class TrajetController {
    @GetMapping
    public ResponseEntity<DataRetour> allTrajet(@RequestParam (value = "idV")int id) throws SQLException {
        return ResponseEntity.accepted().body(new Trajet().Liste(id));
    }

    @PostMapping
    public ResponseEntity<?> createTrajet(@RequestBody Trajet t)throws SQLException {
        try {
            t.createtrajet(t);
        }catch (Exception ex) {
            return new ResponseEntity(new ShowError(new NullException(404,"Vehicule not found")), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateT(@RequestBody Trajet t,
                                     @PathVariable (value = "id")int id) throws Exception {

           try {
            if (t.getDebutkm() < t.getFinkm()) {
                try {
                    t.updateTrajet(id, t);
                } catch (Exception e) {
                    throw new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "finkm ne doit pas etre inferrieur a debutkm", e);
                }
            }
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "user not found", e);
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrajet(@PathVariable (value = "id")int id) throws SQLException {

        try {
            Trajet trajet = new Trajet();
            trajet.setID(id);
            Trajet t = new Trajet();
            t.deletetrajet(trajet);

        }catch (Exception ex) {
            return new ResponseEntity(new ShowError(new NullException(404,"Vehicule not found")), HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
