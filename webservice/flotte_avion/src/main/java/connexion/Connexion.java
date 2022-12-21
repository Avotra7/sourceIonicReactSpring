/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    private Connection connection;

    public Connexion() {
    }

    public Connection getconnect(String dbname, String utilisateur, String mdp) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, utilisateur, mdp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection getConnection() {
        Connexion c = new Connexion();
        Connection connect = c.getconnect("avion", "postgres", "root");
        return connect;
    }
}
