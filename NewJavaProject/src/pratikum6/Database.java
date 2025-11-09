package pratikum6;

import java.sql.*;
import javax.swing.JOptionPane;

public class Database {
    public static Connection koneksi() {
        try {
            // Driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/laundry_apps", // database
                "root", 
                ""      
            );

            System.out.println("Koneksi ke database berhasil!");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        koneksi();
    }
}
