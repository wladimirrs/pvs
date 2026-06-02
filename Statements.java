package pvs;

import java.sql.*;

public class Statements {

    private final String url = "\"jdbc:mysql://127.0.0.1:3306/pvs";
    private final String user = "root";
    private final String password = "";




    public void einfuegen(Mitarbeiter m) {
        String sql = "INSERT INTO mitarbeiter (id, personalnummer, nachname, vorname, strasse, hausnummer, ort, ressort) VALUES" +
                " (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, m.getId());
            ps.setString(2, m.getPersnr());
            ps.setString(3,  m.getNachname());
            ps.setString(4,  m.getVorname());
            ps.setString(5,  m.getStrasse());
            ps.setString(6, m.getHausnr());
            ps.setInt(7, m.getOrt());
            ps.setInt(8, m.getRessort());
        } catch
        (SQLException e) {
            System.out.println("Datensatz nicht eingefügt: " + e.getMessage());
        }
    }












}
