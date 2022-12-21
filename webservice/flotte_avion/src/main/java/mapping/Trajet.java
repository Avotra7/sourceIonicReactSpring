package mapping;

import connexion.Connexion;
import exception.NullException;
import retour.DataRetour;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Trajet {
    int id;
    int idVehicule;
    Date dates;
    double debutkm;
    double finkm;

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(int idVehicule) {
        this.idVehicule = idVehicule;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public double getDebutkm() {
        return debutkm;
    }

    public void setDebutkm(double debutkm) {
        this.debutkm = debutkm;
    }

    public double getFinkm() {
        return finkm;
    }

    public void setFinkm(double finkm) {
        this.finkm = finkm;
    }

    public DataRetour<List<Trajet>> Liste(int id) throws SQLException {
        List<Trajet> allTrajet = new ArrayList<>();
        Connexion c = new Connexion();
        Connection con = null;
        try {
            con = c.getConnection();
        Statement statement = con.createStatement();
        String request = "select * from trajet where idvehicule="+id;
        ResultSet result = statement.executeQuery(request);
        while (result.next()) {
            Trajet trajet = new Trajet();
            trajet.setID(result.getInt(1));
            trajet.setIdVehicule(result.getInt(2));
            trajet.setDates(result.getDate(3));
            trajet.setDebutkm(result.getDouble(4));
            trajet.setFinkm(result.getDouble(5));

            allTrajet.add(trajet);
        }
        if (result != null) result.close();
            statement.close();
            con.close();

    }

        catch(SQLException e){
            e.printStackTrace();
            System.out.println(""+e.getMessage());
        }
        return new DataRetour<List<Trajet>>(allTrajet);

    }
    public void deletetrajet(Trajet trajet) throws SQLException {
        Connexion c = new Connexion();
        PreparedStatement statement = null;
        Connection con = null;
        try {
            String request = " delete from Trajet where id = ?";
            con = c.getConnection();
            statement = con.prepareStatement(request);
            statement.setInt(1, trajet.getID());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.getStackTrace();

        } finally {
            try {
                if (con != null) {
                    statement.close();
                    con.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(Trajet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

            public static void createtrajet (Trajet trajet) throws Exception {

                Connexion c = new Connexion();
                PreparedStatement statement = null;
                Connection con = null;

                try {
                    String sqlrequest = "insert into Trajet(idVehicule,dates,debutkm,finkm)values(?,?,?,?)";
                    con = c.getConnection();
                    statement = con.prepareStatement(sqlrequest);
                    statement.setInt(1, trajet.getIdVehicule());
                    statement.setDate(2, trajet.getDates());
                    statement.setDouble(3, trajet.getDebutkm());
                    statement.setDouble(4, trajet.getFinkm());
                    statement.executeUpdate();


                } catch (SQLException e) {
                    throw e;
                } finally {

                    statement.close();
                    con.close();
                }

            }


    public void updateTrajet (int id,Trajet trajet) throws Exception {

        Connexion c = new Connexion();
        PreparedStatement statement = null;
        Connection con = null;
        try {
            String sqlrequest = "update Trajet set idvehicule = ? , dates = ? , debutkm = ? , finkm = ? where id ="+id+";";
            con = c.getConnection();
            statement = con.prepareStatement(sqlrequest);
            statement.setInt(1, trajet.getIdVehicule());
            statement.setDate(2, trajet.getDates());
            statement.setDouble(3, trajet.getDebutkm());
            statement.setDouble(4, trajet.getFinkm());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.getStackTrace();

        } finally {
            try {
                if (con != null) {
                    statement.close();
                    con.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(Trajet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }


}

