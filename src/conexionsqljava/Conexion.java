package conexionsqljava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Conexion {

    String db = "prueba";
    String ulr = "jdbc:mysql://localhost/";
    String user = "root";
    String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cone;
    Statement s = null;
    ResultSet rs = null;

    public Conexion() {

    }

    public Connection conectar() {
        try {
            Class.forName(driver);
            cone = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "root", "");
            System.out.println("Se conecto a la base de datos");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se conecto a la base de datos");

        }
        return null;
    }

    public Connection consultaTabla() {

        try {
            s = cone.createStatement();
            rs = s.executeQuery("select * from persona");
            System.out.println("\n TODOS LOS REGISTROS DE LA TABLA PERSONA:\n");
            while (rs.next()) {

                System.out.println(rs.getInt("id") + " | " + rs.getString("nombre") + " | " + rs.getDate("nacimiento"));
            }
        } catch (SQLException e) {

        }
        return null;

    }

    public Connection desconectar() {

        try {
            cone.close();
            System.out.println();
            System.out.println("La conexion a la base de datos se ha terminado");

        } catch (SQLException e) {

        }
        return null;

    }

}
