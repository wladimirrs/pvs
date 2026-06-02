package pvs;

public class App {
    static void main(String[] args) {

        Mitarbeiter m1 = new Mitarbeiter(8, "230230",  "Peter", "Peter", "Petrestraße", "10", 1, 1);
        StatementsMitarbeiter sm1 = new StatementsMitarbeiter();
        /*sm1.einfuegen(m1); // funktioniert*/
        /*sm1.loeschen(8); // funktioniert*/

        /*m1.setNachname("Rudolf"); // funktioniert
        m1.setVorname("Rudolf");
        sm1.aendern(m1);*/

        System.out.println(sm1.lesenNachId(8));  // funktioniert
        System.out.println();

        System.out.println(sm1.lesen()); // funktioniert





    }
}
