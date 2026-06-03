package pvs;

public class App {
    static void main(String[] args) {

        Ort o1 = new Ort(10, "Berlin", "00000");
        Mitarbeiter m1 = new Mitarbeiter(14, "230230",  "Peter", "Peter", "Petrestraße", "10", o1, 1, "1999-10-10", 1, 1);
        StatementsMitarbeiter sm1 = new StatementsMitarbeiter();
        /*sm1.einfuegen(m1); // funktioniert*/
        /*sm1.loeschen(8); // funktioniert*/

        /*m1.setNachname("Rudolf"); // funktioniert
        m1.setVorname("Rudolf");
        sm1.aendern(m1);*/

        System.out.println(sm1.lesenNachId(14));  // funktioniert
        System.out.println();

        System.out.println(sm1.lesen()); // funktioniert





    }
}
