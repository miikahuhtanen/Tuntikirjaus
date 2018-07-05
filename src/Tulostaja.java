import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.sql.Date;

public class Tulostaja {

    public void tulostaTiedot(ResultSet rs) throws SQLException {
        ArrayList<Kayttajantunnit> kayttajat = new ArrayList<>();

        while(rs.next()) {
            String sukunimi = rs.getString("sukunimi");
            int id = rs.getInt("kayttajaid");
            Date paivamaara = rs.getDate("paivamaara");
            LocalDate date = paivamaara.toLocalDate();
            String tehtavakuvaus = rs.getString("tehtavakuvaus");
            boolean laskutettava = rs.getBoolean("laskutettava");
            double tunnit = (1.0*rs.getInt("minuutit") / 60);
            tunnit  = Math.round(tunnit*100d)/100d;
            Kayttajantunnit k = new Kayttajantunnit(date, tunnit, tehtavakuvaus, laskutettava,sukunimi,id);
            kayttajat.add(k);
        }
        for (Kayttajantunnit k: kayttajat) {
            System.out.println(k.toString());
        }
    }
}
