package pvs;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class StatementsMitarbeiter {

    private final String url = "jdbc:mysql://127.0.0.1:3306/pvs";
    private final String user = "root";
    private final String password = "";




    public void einfuegen(Mitarbeiter m) {  // erstellten Mitarbeiter m in DB einfügen
        String sql = "INSERT INTO mitarbeiter (id, personalnummer, nachname, vorname, strasse, hausnummer, ort, ressort, geburtsdatum, vertragstyp, titel) VALUES" +
                " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, m.getId());
            ps.setString(2, m.getPersnr());
            ps.setString(3,  m.getNachname());
            ps.setString(4,  m.getVorname());
            ps.setString(5,  m.getStrasse());
            ps.setString(6, m.getHausnr());
            ps.setInt(7, m.getOrt().getOrtId());
            ps.setInt(8, m.getRessort());
            ps.setString(9, m.getGeburtsdatum());
            ps.setInt(10, m.getVertragstyp());
            ps.setInt(11,  m.getTitel());
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
        String sql = "UPDATE mitarbeiter SET personalnummer = ?, nachname = ?, vorname = ?, strasse = ?, hausnummer = ?, ort = ?, ressort = ?, geburtsdatum = ?, vertragstyp = ?, titel = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, m.getPersnr());
            ps.setString(2, m.getNachname());
            ps.setString(3, m.getVorname());
            ps.setString(4, m.getStrasse());
            ps.setString(5, m.getHausnr());
            ps.setInt(6, m.getOrt().getOrtId());
            ps.setInt(7, m.getRessort());
            ps.setString(8,  m.getGeburtsdatum());
            ps.setInt(9, m.getVertragstyp());
            ps.setInt(10, m.getTitel());
            ps.setInt(11, m.getId());
            ps.executeUpdate();
            System.out.println("Datensatz erfolgreich aktualisiert.");
        } catch (SQLException e) {
            System.out.println("Datensatz nicht aktualisiert: " + e.getMessage());
        }
    }





    public Mitarbeiter lesenNachId (int id) {
        String sql = "SELECT m.*, o.id AS ort_id, o.plz, o.ortsname FROM mitarbeiter m JOIN orte o ON m.ort = o.id WHERE m.id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Ort ort = new Ort(
                        rs.getInt("ort_id"),
                        rs.getString("plz"),
                        rs.getString("ortsname")
                );
                return new Mitarbeiter(
                        rs.getInt("id"),
                        rs.getString("personalnummer"),
                        rs.getString("nachname"),
                        rs.getString("vorname"),
                        rs.getString("strasse"),
                        rs.getString("hausnummer"),
                        ort,
                        rs.getInt("ressort"),
                        rs.getString("geburtsdatum"),
                        rs.getInt("vertragstyp"),
                        rs.getInt("titel")
                );
            }
        } catch (SQLException e) {
            System.out.println("Datensatz nicht gelesen." + e.getMessage());
        }
        return null;
    }







    public List<Mitarbeiter> lesen() {

        List<Mitarbeiter> liste = new ArrayList<>();
        String sql = "SELECT m.*, o.id, o.plz, o.ortsname FROM mitarbeiter m JOIN orte o ON m.ort = o.id";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Ort ort = new Ort(
                        rs.getInt("id"),
                        rs.getString("plz"),
                        rs.getString("ortsname")
                );
                Mitarbeiter m = new Mitarbeiter(
                        rs.getInt("id"),
                        rs.getString("personalnummer"),
                        rs.getString("nachname"),
                        rs.getString("vorname"),
                        rs.getString("strasse"),
                        rs.getString("hausnummer"),
                        ort,
                        rs.getInt("ressort"),
                        rs.getString("geburtsdatum"),
                        rs.getInt("vertragstyp"),
                        rs.getInt("titel")
                );
                liste.add(m);
            }
        } catch (SQLException e) {
            System.out.println("Datensätze konnten nicht gelesen werden: " + e.getMessage());
        }
        return liste;
    }





















}
