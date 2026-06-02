package pvs;

public class Mitarbeiter { // Klasse für CRUD

    private int id;
    private String personalnummer;
    private String nachname;
    private String vorname;
    private String strasse;
    private String hausnummer;
    private int ort;
    private int ressort;


                        // 1 Konstruktor
    public Mitarbeiter(int id, String persnr, String nachname, String vorname, String strasse, String hausnummer, int ort, int ressort) {
        this.id = id;
        this.personalnummer = personalnummer;
        this.nachname = nachname;
        this.vorname = vorname;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.ort = ort;
        this.ressort = ressort;
    }



    public int getId() {    // Getter und Setter
        return id;
    }  // Getter und Setter
    public void setId(int id) {
        this.id = id;
    }

    public String getPersnr() {
        return personalnummer;
    }
    public void setPersnr(String persnr) {
        this.personalnummer = personalnummer;
    }

    public String getNachname() {
        return nachname;
    }
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getStrasse() {
        return strasse;
    }
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getHausnr() {
        return hausnummer;
    }
    public void setHausnr(String hausnr) {
        this.hausnummer = hausnr;
    }

    public int getOrt() {
        return ort;
    }
    public void setOrt(int ort) {
        this.ort = ort;
    }

    public int getRessort() {
        return ressort;
    }
    public void setRessort(int ressort) {
        this.ressort = ressort;
    }

    @Override
    public String toString() { // wenn print(Objekt)
        return "Mitarbeiter{" +
                "id=" + id +
                ", personalnummer='" + personalnummer + '\'' +
                ", nachname='" + nachname + '\'' +
                ", vorname='" + vorname + '\'' +
                ", strasse='" + strasse + '\'' +
                ", hausnummer='" + hausnummer + '\'' +
                ", ort='" + ort + '\'' +
                ", ressort='" + ressort + '\'' +
                '}' + "\n";
    }
}
