package pvs;

public class Ressort {

    private int id;
    private String bezeichnung;

    public Ressort(int id, String bezeichnung) {
        this.id = id;
        this.bezeichnung = bezeichnung;
    }

    public Ressort() {}

    public int getId() {
        return id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public static Ressort fromId(int id) {
        switch (id) {
            case 1: return new Ressort(1, "Stadtgärtnerei");
            case 2: return new Ressort(2, "Bauamt");
            case 3: return new Ressort(3, "Ordnungsamt");
            default: throw new IllegalArgumentException("Ungültige Ort-ID: " + id);
        }
    }

    @Override
    public String toString() {
        return bezeichnung;
    }
}