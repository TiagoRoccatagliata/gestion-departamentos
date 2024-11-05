package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Ajustar Ruta
    private static final String DB_URL = "jdbc:sqlite:julia.db";
    private static Connection conn = null;

    // Metodo para conectar a la base de datos
    public static Connection  connect() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(DB_URL);
                System.out.println("Conexion a SQLite establecida");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
        return conn;
        }

        // Metodo para crear la conexion
        public static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexion a SQLite cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerar la conexion con la base de datos: " + e.getMessage());

        }

    }

}
