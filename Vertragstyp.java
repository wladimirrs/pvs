package pvs;

public class Vertragstyp {

    private int id;
    private String bezeichnung;

    public Vertragstyp(int id, String bezeichnung) {
        this.id = id;
        this.bezeichnung = bezeichnung;
    }

    public Vertragstyp() {}

    public int getId() {
        return id;
    }

    public String getPlz() {
        return bezeichnung;
    }



    public static Vertragstyp fromId(int id) {
        // Beispiel: harte Zuordnung (oder DB Lookup)
        switch (id) {
            case 1: return new Vertragstyp(1, "Mitarbeiter");
            case 2: return new Vertragstyp(2, "Auszubildender");
            case 3: return new Vertragstyp(3, "Praktikant");
            case 4: return new Vertragstyp (4, "Doktorand");
            default: throw new IllegalArgumentException("Ungültige Ort-ID: " + id);
        }
    }

    @Override
    public String toString() {
        return bezeichnung;
    }
}