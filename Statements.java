package pvs;

import java.sql.*;

public class Statements {

    private final String url = "jdbc:mysql://127.0.0.1:3306/pvs";
    private final String user = "root";
    private final String password = "";




    public void einfuegen(Mitarbeiter m) {  // erstellten Mitarbeiter m in DB einfügen
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
            ps.executeUpdate();
            System.out.println("Datensatz erfolgreich eingefügt");
        } catch
        (SQLException e) {
            System.out.println("Datensatz nicht eingefügt: " + e.getMessage());
        }
    }







    public void loeschen (int id) {
        String sql = "DELETE FROM mitarbeiter WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Datensatz gelöscht.");
        } catch (SQLException e) {
            System.out.println("Datensatz nicht gelöscht: " + e.getMessage());
        }
    }



    public void aendern (Mitarbeiter m) {
        String sql = "UPDATE mitarbeiter SET personalnummer = ?, nachname = ?, vorname = ?, strasse = ?, hausnummer = ?, ort = ?, ressort = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, m.getPersnr());
            ps.setString(2, m.getNachname());
            ps.setString(3, m.getVorname());
            ps.setString(4, m.getStrasse());
            ps.setString(5, m.getHausnr());
            ps.setInt(6, m.getOrt());
            ps.setInt(7, m.getRessort());
            ps.setInt(8, m.getId());
            ps.executeUpdate();
            System.out.println("Datensatz erfolgreich aktualisiert.");
        } catch (SQLException e) {
            System.out.println("Datensatz nicht aktualisiert: " + e.getMessage());
        }
    }























}
