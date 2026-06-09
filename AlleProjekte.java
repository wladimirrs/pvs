package pvs;

import javafx.beans.property.*;

public class AlleProjekte {

    private final IntegerProperty id = new SimpleIntegerProperty(); // Zeichenketten aktualisieren
    private final StringProperty bezeichnung = new SimpleStringProperty();

    // Konstruktor
    public AlleProjekte(int id, String bezeichnung) {   // Konstruktor
        this.id.set(id);
        this.bezeichnung.set(bezeichnung);
    }




    public int getId() {                                            // getter und setter
        return id.get();
    }
    public void setId(int value) {
        id.set(value);
    }
    public IntegerProperty idProperty() {
        return id;
    }




    public String getBezeichnung() {
        return bezeichnung.get();
    }
    public void setBezeichnung(String value) {
        bezeichnung.set(value);
    }

    public StringProperty bezeichnungProperty() {
        return bezeichnung;
    }




}