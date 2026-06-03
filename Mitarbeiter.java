package pvs;

public class Mitarbeiter { // Klasse für CRUD

    private int id;
    private String personalnummer;
    private String nachname;
    private String vorname;
    private String strasse;
    private String hausnummer;
    private Ort ort;
    private int ressort;
    private String geburtsdatum;
    private int vertragstyp;
    private int titel;


                        // 1 Konstruktor
    public Mitarbeiter(int id, String personalnummer, String nachname, String vorname, String strasse, String hausnummer, Ort ort, int ressort, String geburtsdatum, int vertragstyp, int titel) {
        this.id = id;
        this.personalnummer = personalnummer;
        this.nachname = nachname;
        this.vorname = vorname;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.ort = ort;
        this.ressort = ressort;
        this.geburtsdatum = geburtsdatum;
        this.vertragstyp = vertragstyp;
        this.titel = titel;
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
    public void setPersnr(String personalnummer) {
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
    public void setHausnr(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public Ort getOrt() {
        return ort;
    }
    public void setOrt(Ort ort) {
        this.ort = ort;
    }

    public int getRessort() {
        return ressort;
    }
    public void setRessort(int ressort) {
        this.ressort = ressort;
    }

    public String getGeburtsdatum() {
        return geburtsdatum;
    }
    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public int getVertragstyp() {
        return vertragstyp;
    }
    public void setVertragstyp(int vertragstyp) {
        this.vertragstyp = vertragstyp;
    }

    public int getTitel() {
        return titel;
    }
    public void setTitel(int titel) {
        this.titel = titel;
    }

    @Override
    public String toString() { // wenn print(Objekt)
        return "Mitarbeiter " + vorname + " " + nachname + ", Pers-Nr. " + personalnummer + ", wohnhaft " +
                strasse + " " + hausnummer + ", " + ort + "\n";
    }
}
