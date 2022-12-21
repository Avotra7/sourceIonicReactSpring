package mapping;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import retour.DataRetour;

public class Avion implements Serializable {
    private int id;
    private int nbplace;
    private String marque;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbplace() {
        return id;
    }

    public void setNbplace(int nbplace) {
        this.nbplace = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public static DataRetour<List<Avion>> listAvion() throws Exception {
        Connexion c = new Connexion();
        List<Avion> l = new ArrayList<Avion>();
        Statement stat = null;
        ResultSet result = null;
        Connection co = null;

        try {
            co = c.getConnection();
            stat = co.createStatement();
            String requete = "select * from Avion";
            result = stat.executeQuery(requete);
            while (result.next()) {
                Avion av = new Avion();
                av.setId(result.getInt("id"));
                av.setMarque(result.getString("marque"));
                av.setNbplace(result.getInt("nbplace"));
                l.add(av);
            }
        } catch (SQLException e) {
        } finally {
            if (result != null) {
                result.close();
            }
            if (stat != null) {
                stat.close();
            }
            co.close();
        }
        return new DataRetour<List<Avion>>(l);
    }

}
