package mapping;

import connexion.Connexion;
import retour.DataRetour;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AssuranceA implements Serializable {

    String marque;

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public List<AssuranceA> getAssuranceThreeMonth() throws Exception {
        List<AssuranceA> listeAssurance = new ArrayList<>();
        Connexion c = new Connexion();
        Connection con = null;
        try {
            con = c.getConnection();
            Statement statement = con.createStatement();
            String request = "select * from assuranceT ";
            ResultSet result = statement.executeQuery(request);
            while (result.next()) {
                AssuranceA assurance = new AssuranceA();

                assurance.setMarque(result.getString(1));

                listeAssurance.add(assurance);
            }
            if (result != null)
                result.close();
            statement.close();
            con.close();

        }

        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("" + e.getMessage());
        }
        return listeAssurance;

    }
}
