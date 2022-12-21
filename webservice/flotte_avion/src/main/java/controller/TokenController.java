package controller;

import connexion.Connexion;
import exception.NullException;
import exception.ShowError;
import mapping.TokenUtilisateur;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Connection;

@RestController
@CrossOrigin("*")
@RequestMapping("/token")
public class TokenController {

    @RequestMapping("/{id}")
    public void generateToken(@PathVariable("id") int userid) {
        Connection co = new Connexion().getconnect("vehicule", "postgres", "root");
        try {
            new TokenUtilisateur().generateToken(co, userid);
            co.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @GetMapping
    public ResponseEntity<?> getValidToken(@RequestParam(value = "user") int iduser,
            @RequestParam(value = "token") String token) throws Exception {
        Connection co = new Connexion().getConnection();
        TokenUtilisateur mytoken = null;
        try {
            mytoken = new TokenUtilisateur(token, iduser).checkIfExpire(co);
            co.close();
            System.out.println("mytoken" + mytoken);

            if (mytoken == null) {
                return new ResponseEntity(new ShowError(new NullException(406, "Token Expire")),
                        HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.accepted().body(mytoken);
        } catch (NullException ex) {
            return new ResponseEntity(new ShowError(new NullException(404, "Token Not found")),
                    HttpStatus.NOT_FOUND);
        }

    }
}
