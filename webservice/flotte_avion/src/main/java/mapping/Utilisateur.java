package mapping;

import connexion.Connexion;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.*;
import java.sql.Connection;
import java.sql.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Utilisateur implements Serializable {
    int id;
    String logins;
    String mdp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogins() {
        return logins;
    }

    public void setLogins(String logins) {
        this.logins = logins;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Utilisateur(int id, String logins, String mdp) {
        this.id = id;
        this.logins = logins;
        this.mdp = mdp;
    }

    public Utilisateur() {

    }

    public TokenUtilisateur login() {
        System.out.println("eooo");
        Connexion c = new Connexion();
        Utilisateur utilisateur = null;
        Statement stat = null;
        ResultSet result = null;
        Connection co = null;
        TokenUtilisateur to = null;
        try {
            co = c.getConnection();
            stat = co.createStatement();
            String requete = "Select * from Utilisateur where logins='" + this.logins + "' And mdp=md5('" + this.mdp
                    + "')";
            System.out.println(requete);
            result = stat.executeQuery(requete);
            if (result.next()) {
                to = new TokenUtilisateur();
                utilisateur = new Utilisateur(result.getInt("id"), result.getString("logins"), result.getString("mdp"));
                to.generateToken(co, utilisateur.id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return to;
    }

    public void logout(int id) {
        Connexion c = new Connexion();
        Utilisateur utilisateur = null;
        Statement stat = null;
        ResultSet result = null;
        Connection co = null;

        try {
            co = c.getConnection();
            stat = co.createStatement();
            String requete = "UPDATE TokenUtilisateur set dateexpiration=now() where id IN(SELECT id FROM V_TokenNonExpire) and idutilisateur="
                    + id + "";
            result = stat.executeQuery(requete);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
