package mapping;

import connexion.Connexion;
import retour.DataRetour;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class V_Entretien implements Serializable {
    private int id;
    private int idAvion;
    private String typeEntretien;
    private Date dateEntretien;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }

    public String getTypeEntretien() {
        return typeEntretien;
    }

    public void setTypeEntretien(String typeEntretien) {
        this.typeEntretien = typeEntretien;
    }

    public Date getDateEntretien() {
        return dateEntretien;
    }

    public void setDateEntretien(Date dateEntretien) {
        this.dateEntretien = dateEntretien;
    }

    public V_Entretien(int id, int idAvion, String typeEntretien, Date dateEntretien) {
        this.id = id;
        this.idAvion = idAvion;
        this.typeEntretien = typeEntretien;
        this.dateEntretien = dateEntretien;
    }

    public V_Entretien() {
    }

    public static DataRetour<List<V_Entretien>> listEntretien(int idV) throws Exception {
        Connexion c = new Connexion();
        List<V_Entretien> l = new ArrayList<>();
        Statement stat = null;
        ResultSet result = null;
        Connection co = null;

        try {
            co = c.getConnection();
            stat = co.createStatement();
            String requete = "select*from V_Entretien WHERE idavion=" + idV;
            result = stat.executeQuery(requete);
            while (result.next()) {
                V_Entretien v = new V_Entretien();
                v.setId(result.getInt("id"));
                v.setIdAvion(result.getInt("idAvion"));
                v.setTypeEntretien(result.getString("TypeEntretien"));
                v.setDateEntretien(result.getDate("dateEntretien"));
                l.add(v);
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
        return new DataRetour<List<V_Entretien>>(l);
    }

}