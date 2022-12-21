package controller;

import exception.NullException;
import exception.ShowError;
import mapping.TokenUtilisateur;
import mapping.Utilisateur;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retour.DataRetour;

@RestController
@CrossOrigin("*")
@RequestMapping("/utilisateur")
public class UtilisateurController {

    @PostMapping
    public ResponseEntity<?> login(@RequestBody Utilisateur u) throws Exception {
        TokenUtilisateur tokenuser = u.login();
        if (tokenuser != null) {
            return ResponseEntity.accepted().body(new DataRetour<TokenUtilisateur>(tokenuser));
        }
        return new ResponseEntity<ShowError>(new ShowError(new NullException(407, "Information non valide")),
                HttpStatus.BAD_REQUEST);

    }

    @PutMapping
    public void logout(@PathVariable(value = "id") int id) {
        Utilisateur u = new Utilisateur();
        u.logout(id);
    }
}
