package PVS;

import java.sql.*;

public class zugriffDemo {

    String url = "\"jdbc:mysql://127.0.0.1:3306/projektmanagement";
    String user = "root";
    String password = "";

    public void allesAuswaehlen() {
        String sql = "SELECT * FROM mitarbeiter";
        try (Connection conn = DriverManager.getConnection(url, user, password); // Connection

             Statement stmt = conn.createStatement(); // Statement
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {                         // SQL
                String persnr = rs.getString("persnr");
                String vorname = rs.getString("vorname");
                String nachname = rs.getString("nachname");
                System.out.println(persnr + " - " + vorname + " " + nachname);
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim DB-Zugriff: " + e.getMessage());
        }
    }









}
