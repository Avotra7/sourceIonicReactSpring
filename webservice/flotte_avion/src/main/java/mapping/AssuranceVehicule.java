package mapping;

import connexion.Connexion;
import retour.DataRetour;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AssuranceVehicule implements Serializable {
    private int id;
    private int idVehicule;
    private Date dateDebutAssurance;
    private Date dateFinAssurance;

    public AssuranceVehicule() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(int idVehicule) {
        this.idVehicule = idVehicule;
    }

    public Date getDateDebutAssurance() {
        return dateDebutAssurance;
    }

    public void setDateDebutAssurance(Date dateDebutAssurance) {
        this.dateDebutAssurance = dateDebutAssurance;
    }

    public Date getDateFinAssurance() {
        return dateFinAssurance;
    }

    public void setDateFinAssurance(Date dateFinAssurance) {
        this.dateFinAssurance = dateFinAssurance;
    }

    public AssuranceVehicule(int id, int idVehicule, Date dateDebutAssurance, Date dateFinAssurance) {
        this.id = id;
        this.idVehicule = idVehicule;
        this.dateDebutAssurance = dateDebutAssurance;
        this.dateFinAssurance = dateFinAssurance;
    }

    public DataRetour<List<AssuranceVehicule>> getAssuranceMonth(int nbmonth) throws Exception{
        Connexion c=new Connexion();
        List<AssuranceVehicule>list=new ArrayList<AssuranceVehicule>();
        String sql="SELECT * FROM V_AssuranceThreeMonth";
        if(nbmonth==1){
            sql="SELECT * FROM V_AssuranceOneMonth";
        }
        Statement stat=c.getConnection().createStatement();
        ResultSet result=stat.executeQuery(sql);
        while(result.next()){
            AssuranceVehicule temp=new AssuranceVehicule(result.getInt("id")
                    ,result.getInt("idVehicule"),result.getDate("dateDebutAssurance"),
                    result.getDate("dateFinAssurance"));
            list.add(temp);
        }
        result.close();
        stat.close();
        return new DataRetour<List<AssuranceVehicule>>(list);

    }


}
