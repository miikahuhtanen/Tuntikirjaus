import java.sql.SQLException;
import java.util.Scanner;

public class Tekstikayttoliittyma {
    public void start() throws SQLException {
        Kantalukija kantalukija = new Kantalukija();
        Scanner lukija = new Scanner(System.in);

        while (true) {
            System.out.println("Mitä haluat tehdä?\n " +
                    "\t 1: Katso tuntisi" +
                    "\t 2: Kirjaa tunnit" +
                    "\t 3: Katso kaikki tunnit" +
                    "\t 4: Lopeta");
            String input = lukija.nextLine();
            try {
                if (input.equals("1")) {
                    System.out.println("Syötä haettavan id: ");
                    int kayttajaid = Integer.parseInt(lukija.nextLine());
                    System.out.println("Haetaanko tietyltä aikaväliltä? kyllä/ei");
                    String input2 = lukija.nextLine();
                    if (input2.equals("kyllä")){
                        System.out.println("Syötä aikavälin alku: ");
                        String alku = lukija.nextLine();
                        System.out.println("Syötä aikavälin loppu:");
                        String loppu = lukija.nextLine();
                        kantalukija.haeKayttajanTunnit(kayttajaid, alku, loppu);
                    } else {
                        kantalukija.haeKayttajanTunnit(kayttajaid);
                    }
                } else if (input.equals(("2"))) {
                    System.out.println("Syötä kirjattavan id: ");
                    int kayttajaid = Integer.parseInt(lukija.nextLine());
                    System.out.println("Syötä päivämäärä");
                    String paivamaara = lukija.nextLine();
                    System.out.println("Syötä tehtävän kesto minuutteina");
                    int minuutit = Integer.parseInt(lukija.nextLine());
                    System.out.println("Syötä tehtävän kuvaus");
                    String tehtavakuvaus = lukija.nextLine();
                    System.out.println("Oliko laskutettavaa kyllä/ei");
                    String laskutettavaInput = lukija.nextLine();
                    boolean laskutettava;
                    if(laskutettavaInput.equals("kyllä")) {
                        laskutettava = true;
                    } else {
                        laskutettava = false;
                    }
                    kantalukija.kirjaaKayttajanTunnit(kayttajaid, paivamaara, minuutit, tehtavakuvaus, laskutettava);
                } else if (input.equals("3")) {
                    System.out.print("Syötä salasana: ");
                    String salasana = lukija.nextLine();
                    if (salasana.equals("hunter2")) {
                        System.out.println("Haetaanko tietyltä aikaväliltä? kyllä/ei");
                        String input2 = lukija.nextLine();
                        if (input2.equals("kyllä")){
                            System.out.println("Syötä aikavälin alku: ");
                            String alku = lukija.nextLine();
                            System.out.println("Syötä aikavälin loppu:");
                            String loppu = lukija.nextLine();
                            kantalukija.haeKayttajanTunnit(alku, loppu);
                        } else {
                            kantalukija.haeKaikkiTunnit();
                        }

                    } else {
                        System.out.println("Väärä salasana.");
                    }
                } else if (input.equals("4")) {
                    break;
                } else {
                    System.out.println("Syötettä ei tunnistettu");
                }
            }
            catch(Exception e){
                    System.out.println(e.getMessage());
                }
        }
        System.out.println("Kiitos käynnistä. Hyvää päivänjatkoa!");
    }
}
