package mapping;

import connexion.Connexion;
import retour.DataRetour;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Kilometrage implements Serializable {
    private int id;
    private int idAvion;
    private Date dates;
    private int debutKm;
    private int finKm;

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

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public int getDebutKm() {
        return debutKm;
    }

    public void setDebutKm(int debutKm) {
        this.debutKm = debutKm;
    }

    public int getFinKm() {
        return finKm;
    }

    public void setFinKm(int finKm) {
        this.finKm = finKm;
    }

    public Kilometrage(int id, int idAvion, Date dates, int debutKm, int finKm) {
        this.id = id;
        this.idAvion = idAvion;
        this.dates = dates;
        this.debutKm = debutKm;
        this.finKm = finKm;
    }

    public Kilometrage() {
    }

    public static DataRetour<List<Kilometrage>> listKilometrage() throws Exception{
        Connexion c=new Connexion();
        List<Kilometrage> l = new ArrayList<>();
        Statement stat = null;
        ResultSet result = null;
        Connection co = null;

        try{
            co = c.getConnection();
            stat = co.createStatement();
            String requete = "select*from Kilometrage";
            result = stat.executeQuery(requete);
            while(result.next()){
                Kilometrage v = new Kilometrage();
                v.setId(result.getInt("id"));
                v.setIdAvion(result.getInt("idAvion"));
                v.setDates(result.getDate("dates"));
                v.setDebutKm(result.getInt("debutKm"));
                v.setFinKm(result.getInt("FinKm"));
                l.add(v);
            }
        }catch(SQLException e){}
        finally{
            if(result != null){
                result.close();
            }
            if(stat != null){
                stat.close();
            }
            co.close();
        }
        return new DataRetour<List<Kilometrage>>(l);
    }
}
