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

    public int getOrtId() {
        return ortId;
    }

    public String getPlz() {
        return plz;
    }

    public String getOrtsname() {
        return ortsname;
    }

    @Override
    public String toString() {
        return plz + " " + ortsname;
    }
}