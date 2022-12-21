package mapping;

import connexion.Connexion;
import org.springframework.stereotype.Service;
import retour.DataRetour;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Vehicule implements Serializable {
    private int id;
    private String matricule;
    private String marque;

    private List<Trajet> listtrajet;

    public List<Trajet> getListtrajet() {
        return listtrajet;
    }

    public void setListTrajet(List<Trajet> listTrajet) {
        this.listtrajet = listTrajet;
    }

    public Vehicule(int id, String matricule, String marque) {
        this.id = id;
        this.matricule=matricule;
        this.marque=marque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Vehicule() {
    }

    public static void insertVehicule(Vehicule v) throws Exception{
        Connexion c=new Connexion();
        PreparedStatement stat = null;
        Connection co = null;

        try{
            co = c.getConnection();
            String requete = "INSERT INTO Vehicule VALUES(default,?,?)";
            stat = co.prepareStatement(requete);
            stat.setString(1,v.getMarque());
            stat.setString(2,v.getMatricule());
            stat.executeUpdate();
        }catch(SQLException e){}
        finally{
            if(stat != null){
                stat.close();
            }
            co.close();
        }
    }

    public static void modifVehicule(int id,Vehicule v) throws Exception{
        Connexion c=new Connexion();
        PreparedStatement stat = null;
        Connection co = null;

        try{
            co = c.getConnection();
            String requete = "update vehicule set marque=?,matricule=? where id="+id+";";
            stat = co.prepareStatement(requete);
            stat.setString(1,v.getMarque());
            stat.setString(2,v.getMatricule());
            stat.executeUpdate();
        }catch(SQLException e){}
        finally{
            if(stat != null){
                stat.close();
            }
            co.close();
        }
    }

    public static void deleteVehicule(int id) throws Exception{
        Connexion c=new Connexion();
        Statement stat = null;
        ResultSet result = null;
        Connection co = null;

        try{
            co = c.getConnection();
            stat = co.createStatement();
            String requete = "delete from vehicule where id="+id+";";
            result = stat.executeQuery(requete);
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
    }

    private void initListTrajet() throws Exception{
        this.listtrajet=new Trajet().Liste(this.id).getData();
    }

    public static DataRetour<List<Vehicule>> listVehicule() throws Exception{
        Connexion c=new Connexion();
        List<Vehicule> l = new ArrayList<>();
        Statement stat = null;
        ResultSet result = null;
        Connection co = null;

        try{
            co = c.getConnection();
            stat = co.createStatement();
            String requete = "select*from vehicule";
            result = stat.executeQuery(requete);
            while(result.next()){
                Vehicule v = new Vehicule();
                v.setId(result.getInt("id"));
                v.setMarque(result.getString("marque"));
                v.setMatricule(result.getString("matricule"));
                v.initListTrajet();
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
        return new DataRetour<List<Vehicule>>(l);
    }

    public static DataRetour<Vehicule> listVehiculeById(int idVehicule) throws Exception{
        Connexion c=new Connexion();
        Vehicule v = new Vehicule();
        Statement stat = null;
        ResultSet result = null;
        Connection co = null;

        try{
            co = c.getConnection();
            stat = co.createStatement();
            String requete = "select*from vehicule where id="+idVehicule+";";
            result = stat.executeQuery(requete);
            while (result.next()) {
                v.setId(result.getInt("id"));
                v.setMarque(result.getString("marque"));
                v.setMatricule(result.getString("matricule"));
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
        return new DataRetour<Vehicule>(v);
    }
}
