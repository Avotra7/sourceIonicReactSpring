package controller;

import exception.NullException;
import exception.ShowError;
import mapping.Vehicule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retour.DataRetour;

@RestController
@CrossOrigin("*")
@RequestMapping("/vehicule")
public class VehiculeController {

    @GetMapping
    public ResponseEntity<DataRetour> lsvehicule() throws Exception {
        System.out.println("etoooo"+new Vehicule().listVehicule());
        return ResponseEntity.accepted().body(new Vehicule().listVehicule());

    }

    @PostMapping
    public void insertVehicule(@RequestBody Vehicule v) throws Exception {
        Vehicule.insertVehicule(v);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVehicule(@PathVariable(value = "id")int id,@RequestBody Vehicule v){
        try{
            Vehicule.modifVehicule(id,v);
        }
        catch (Exception ex){
            return new ResponseEntity(new ShowError(new NullException(404,"Vehicule not found")), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> delVehicule(@PathVariable("id")int id) throws Exception {
        try{
            Vehicule.deleteVehicule(id);
        }
        catch (Exception ex){
            return new ResponseEntity(new ShowError(new NullException(404,"Vehicule not found")), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<DataRetour> lsVehiculeById(@PathVariable("id")int id) throws Exception {
        return ResponseEntity.accepted().body(new Vehicule().listVehiculeById(id));
    }
}
