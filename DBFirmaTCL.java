package PVS;

import java.sql.*;

public class DBFirmaTCL {

    public static void createAndInsert() {
        String url = "jdbc:mysql://127.0.0.1:3306/";
        String user = "root";
        String password = "";
        String dbName = "firma2";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();

            // statement.execute("Set Rolle verwaltung1" + dbName);
           /*  statement.execute("DROP DATABASE IF EXISTS " + dbName);
            statement.execute("CREATE DATABASE " + dbName);
            statement.execute("USE " + dbName);

            String createTableSQL = """
                    CREATE TABLE IF NOT EXISTS Mitarbeiter (
                        id int primary key auto_increment,
                        persnr int unique,
                        vorname VARCHAR(100),
                        nachname VARCHAR(100),
                        geburtsdatum Date,
                        strasse VARCHAR(100),
                        hausnummer VARCHAR(10),
                        ort_id int
                    ) ENGINE=InnoDB DEFAULT CHARSET=UTF8
                    """;
            statement.execute(createTableSQL); */

            String insertSQL = """
                    INSERT INTO mitarbeiter (persnr, nachname, vorname, geburtsdatum,
                    strasse, hausnummer)
                    VALUES (?, ?, ?, ?, ?, ?)
                    """;

            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

                preparedStatement.setInt(1, 5555);
                preparedStatement.setString(2, "Maier");
                preparedStatement.setString(3, "Benjamin");
                preparedStatement.setDate(4, Date.valueOf("1980-10-01"));
                preparedStatement.setString(5, "Zum Kniepacker");
                preparedStatement.setString(6, "15A");
                preparedStatement.executeUpdate();

                preparedStatement.setInt(1, 6666);
                preparedStatement.setString(2, "Schmitz");
                preparedStatement.setString(3, "Peter");
                preparedStatement.setDate(4, Date.valueOf("1987-06-12"));
                preparedStatement.setString(5, "Schillerstrasse");
                preparedStatement.setString(6, "120");
                preparedStatement.executeUpdate();

                preparedStatement.setInt(1, 7777);
                preparedStatement.setString(2, "Achilles");
                preparedStatement.setString(3, "Albrecht");
                preparedStatement.setDate(4, Date.valueOf("1977-05-21"));
                preparedStatement.setString(5, "Heidegraben");
                preparedStatement.setString(6, "9b");
                preparedStatement.executeUpdate();

                preparedStatement.setInt(1, 8888);
                preparedStatement.setString(2, "Mertens");
                preparedStatement.setString(3, "Julia");
                preparedStatement.setDate(4, Date.valueOf("1995-08-11"));
                preparedStatement.setString(5, "Ludwig-Alle");
                preparedStatement.setString(6, "90");
                preparedStatement.executeUpdate();

                connection.commit();
                System.out.println("Transaktion erfolgreich durchgeführt.");
            } catch (SQLException e) {
                connection.rollback();
                System.out.println("Fehler beim Einfügen der Daten, Änderungen zurückgerollt: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Fehler bei der Erstellung der Datenbank oder Tabelle: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        createAndInsert();
    }
}
