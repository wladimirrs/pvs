package pvs;

public class Ort {

    private int ortId;
    private String plz;
    private String ortsname;

    public Ort(int ortId, String plz, String ortsname) {
        this.ortId = ortId;
        this.plz = plz;
        this.ortsname = ortsname;
    }

    public Ort() {}

    public int getId() {
        return ortId;
    }

    public String getPlz() {
        return plz;
    }

    public String getOrtsname() {
        return ortsname;
    }

    public static Ort fromId(int id) {
        // Beispiel: harte Zuordnung (oder DB Lookup)
        switch (id) {
            case 1: return new Ort(1, "56271", "Kleinmaischeid");
            case 2: return new Ort(2, "45739", "Oer-Erkenschwick");
            case 3: return new Ort(3, "55270", "Zornheim");
            case 4: return new Ort(4, "56203", "Höhr-Grenzhausen");
            case 5: return new Ort(5, "22946", "Trittau");
            case 6: return new Ort(6, "56235", "Ransbach-Baumbach");
            case 7: return new Ort(7, "56154", "Boppard");
            case 8: return new Ort(8, "56204", "Hillscheid");
            case 9: return new Ort(9, "56203", "Grenzau");
            default: throw new IllegalArgumentException("Ungültige Ort-ID: " + id);
        }
    }

    @Override
    public String toString() {
        return plz + " " + ortsname;
    }

}