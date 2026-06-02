package PVS;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MitarbeiterDAO {

private final String url = "jdbc:mysql://127.0.0.1:3306/projektmanagement";
private final String user = "root";
private final String password = "";


public void einfuegen(Mitarbeiter m) {
    String sql = "INSERT INTO mitarbeiter (id, persnr, nachname, vorname, strasse, hausnr) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, m.getId());
        ps.setString(2, m.getPersnr());
        ps.setString(3, m.getNachname());
        ps.setString(4, m.getVorname());
        ps.setString(5, m.getStrasse());
        ps.setString(6, m.getHausnr());
        ps.executeUpdate();
        System.out.println("Datensatz erfolgreich eingefügt");
    } catch (SQLException e) {
        System.out.println("Datensatz nicht eingefügt: " + e.getMessage());
    }
}

public void loeschen(int id) {
    String sql = "DELETE FROM mitarbeiter WHERE id = ?";
    try (Connection conn = DriverManager.getConnection(url, user, password);
    PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Datensatz gelöscht");
    } catch (SQLException e) {
        System.out.println("Datensatz nicht gelöscht: " + e.getMessage());
    }
}

public void aendern (Mitarbeiter m) {
    String sql = "UPDATE mitarbeiter SET persnr = ?, nachname = ?, vorname = ?, strasse = ?, hausnr = ? WHERE id = ?";
    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement ps = conn.prepareStatement(sql)) {
             ps.setString(1, m.getPersnr());
             ps.setString(2, m.getNachname());
             ps.setString(3, m.getVorname());
             ps.setString(4, m.getStrasse());
             ps.setString(5, m.getHausnr());
             ps.setInt(6, m.getId());
             ps.executeUpdate();
             System.out.println("Datensatz erfolgreich aktualisiert");
    } catch (SQLException e) {
        System.out.println("Datensatz nicht aktualisiert: " + e.getMessage());
    }
}


public Mitarbeiter lesenEins (int id) {
    String sql = "SELECT  * FROM mitarbeiter WHERE id = ?";
    try (Connection conn = DriverManager.getConnection(url, user, password);
    PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if  (rs.next()) {
            return new Mitarbeiter(
                    rs.getInt("id"),
                    rs.getString("persnr"),
                    rs.getString("nachname"),
                    rs.getString("vorname"),
                    rs.getString("strasse"),
                    rs.getString("hausnr")
            );
        }
    } catch (SQLException e) {
        System.out.println("Datensatz nicht aktualisiert: " + e.getMessage());
    }
    return null;
}

public List<Mitarbeiter> lesen () {

    List<Mitarbeiter> liste = new ArrayList<>();
    String sql = "SELECT * FROM mitarbeiter";
    try (Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Mitarbeiter m = new Mitarbeiter(
                rs.getInt("id"),
                rs.getString("persnr"),
                rs.getString("nachname"),
                rs.getString("vorname"),
                rs.getString("strasse"),
                rs.getString("hausnr")
            );
            liste.add(m);
        }
    } catch (Exception e) {
        System.out.println("Fehler bei Ausgabe: " +e.getMessage());
    }
    return liste;
}


















}
