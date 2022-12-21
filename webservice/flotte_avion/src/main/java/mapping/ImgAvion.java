package mapping;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import connexion.Connexion;

public class ImgAvion implements Serializable {
    private int id;
    private int idavion;
    private String img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdavion() {
        return idavion;
    }

    public void setIdavion(int id) {
        this.idavion = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String id) {
        this.img = id;
    }

    public static void insertImg(String base64, int idAvion) throws Exception {
        Connexion c = new Connexion();
        Statement stat = null;
        Connection co = null;

        try {
            co = c.getConnection();
            String requete = "INSERT INTO ImgAvion VALUES(default," + idAvion + ",'" + base64 + "')";
            stat = co.createStatement();
            stat.executeUpdate(requete);
        } catch (Exception e) {
        } finally {
            if (stat != null) {
                stat.close();
            }
            co.close();
        }
    }

}
