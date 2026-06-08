package pvs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class MitarbeiterController {

    @FXML
    private Button btnAendern;

    @FXML
    private Button btnEinfuegen;

    @FXML
    private Button btnLoeschen;

    @FXML
    private Button btnSuchen;

    @FXML private AnchorPane mitarbeiterPane;                   // Fenster
    @FXML private TableView<Mitarbeiter> tblMitarbeiter;        // Tabelle

    @FXML private TableColumn<Mitarbeiter, Number> colId;             // Tabellenspalten
    @FXML private TableColumn<Mitarbeiter, String> colNachname;
    @FXML private TableColumn<Mitarbeiter, String> colVorname;
    @FXML private TableColumn<Mitarbeiter, String> colPersonallnummer;
    @FXML private TableColumn<Mitarbeiter, String> colStrasse;
    @FXML private TableColumn<Mitarbeiter, String> colHausnummer;
    @FXML private TableColumn<Mitarbeiter, String> colGeburtsdatum;
    @FXML private TableColumn<Mitarbeiter, Ort> colOrt;
    @FXML private TableColumn<Mitarbeiter, Ressort> colRessort;
    @FXML private TableColumn<Mitarbeiter, Vertragstyp> colVertragstyp;

    @FXML private TextField txtEingabe;

    private ObservableList<Mitarbeiter> daten;







    @FXML
    public void initialize() {      // Spalten setzen

        colId.setCellValueFactory(data -> data.getValue().idProperty());
        colNachname.setCellValueFactory(data -> data.getValue().nachnameProperty());
        colVorname.setCellValueFactory(data -> data.getValue().vornameProperty());
        colPersonallnummer.setCellValueFactory(data -> data.getValue().personalnummerProperty());
        colStrasse.setCellValueFactory(data -> data.getValue().strasseProperty());
        colHausnummer.setCellValueFactory(data -> data.getValue().hausnummerProperty());
        colGeburtsdatum.setCellValueFactory(data -> data.getValue().geburtsdatumProperty());
        colOrt.setCellValueFactory(data -> data.getValue().ortProperty());
        colRessort.setCellValueFactory(data -> data.getValue().ressortProperty());
        colVertragstyp.setCellValueFactory(data -> data.getValue().vertragstypProperty());
        daten = MitarbeiterDAO.getAll();   // 💾 DB LADEN
        tblMitarbeiter.setItems(daten);
    }



    @FXML
    void einfuegen(ActionEvent event) {
        String input = txtEingabe.getText();
        if (input == null || input.isBlank()) return;
        String[] parts = input.split(" ");
        Mitarbeiter m = new Mitarbeiter(
                0,
                parts.length > 0 ? parts[0] : "",
                parts.length > 1 ? parts[1] : "",
                parts.length > 2 ? parts[2] : "",
                parts.length > 3 ? parts[3] : "",
                parts.length > 4 ? parts[4] : "",
                parts.length > 5 ? parts[5] : "",
                Ort.fromId(Integer.parseInt(parts[6])),
                Ressort.fromId(Integer.parseInt(parts[7])),
                Vertragstyp.fromId(Integer.parseInt(parts[8]))
        );
        MitarbeiterDAO.insert(m);
        daten.setAll(MitarbeiterDAO.getAll());
    }

    @FXML
    void loeschen(ActionEvent event) {
        Mitarbeiter selected = tblMitarbeiter.getSelectionModel().getSelectedItem();
        if (selected != null) {
            MitarbeiterDAO.delete(selected.getId());
            daten.setAll(MitarbeiterDAO.getAll());
        }
    }

    @FXML
    void aendern(ActionEvent event) {
        Mitarbeiter selected = tblMitarbeiter.getSelectionModel().getSelectedItem();
        String input = txtEingabe.getText();
        if (selected == null || input == null || input.isBlank()) return;
        String[] parts = input.split(" ");
        selected.setNachname(parts.length > 0 ? parts[0] : selected.getNachname());
        selected.setVorname(parts.length > 1 ? parts[1] : selected.getVorname());
        selected.setPersonalnummer(parts.length > 2 ? parts[2] : selected.getPersonalnummer());
        selected.setStrasse(parts.length > 3 ? parts[3] : selected.getStrasse());
        selected.setHausnummer(parts.length > 4 ? parts[4] : selected.getHausnummer());
        selected.setGeburtsdatum(parts.length > 5 ? parts[5] : selected.getGeburtsdatum());
        if (parts.length > 6) {
            selected.setOrt(Ort.fromId(Integer.parseInt(parts[6])));
        }
        if (parts.length > 7) {
            selected.setRessort(Ressort.fromId(Integer.parseInt(parts[7])));
        }
        if (parts.length > 8) {
            selected.setVertragstyp(Vertragstyp.fromId(Integer.parseInt(parts[8])));
        }

        MitarbeiterDAO.update(selected);
        daten.setAll(MitarbeiterDAO.getAll());
    }

    @FXML
    void suchen(ActionEvent event) {
        String query = txtEingabe.getText().toLowerCase();
        if (query.isBlank()) {
            tblMitarbeiter.setItems(daten);
            return;
        }
        ObservableList<Mitarbeiter> gefiltert = FXCollections.observableArrayList(
                daten.stream()
                        .filter(m ->
                                (m.getNachname() != null && m.getNachname().toLowerCase().contains(query)) ||
                                        (m.getVorname() != null && m.getVorname().toLowerCase().contains(query)) ||
                                        (m.getPersonalnummer() != null && m.getPersonalnummer().toLowerCase().contains(query)) ||
                                        (m.getStrasse() != null && m.getStrasse().toLowerCase().contains(query)) ||
                                        (m.getHausnummer() != null && m.getHausnummer().toLowerCase().contains(query)) ||
                                        (m.getGeburtsdatum() != null && m.getGeburtsdatum().toLowerCase().contains(query)) ||
                                        (m.getOrt() != null && m.getOrt().toString().toLowerCase().contains(query)) ||
                                        (m.getRessort() != null && m.getRessort().toString().toLowerCase().contains(query)) ||
                                        (m.getVertragstyp() != null && m.getVertragstyp().toString().toLowerCase().contains(query))
                        )
                        .toList()
        );
        tblMitarbeiter.setItems(gefiltert);
    }
}