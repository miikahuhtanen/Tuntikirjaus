import java.sql.*;

public class Kantalukija {

    private Connection con;
   private Tulostaja tulostaja;

    public Kantalukija() throws SQLException {

        this.tulostaja = new Tulostaja();

            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tuntikirjaukset?useSSL=false&serverTimezone=UTC", "root", "password");


    }

    public void haeKayttajanTunnit(int kayttajaid, String alku, String loppu) throws SQLException {
        String sql = "Select kayttajaid, kayttajat.sukunimi, paivamaara, minuutit, tehtavakuvaus, laskutettava from tuntienkirjaus join kayttajat on kayttajat.id = kayttajaid where kayttajaid=? and paivamaara<? and paivamaara>?";
        System.out.println("testi");
        PreparedStatement lause = con.prepareStatement(sql);
        lause.setInt(1, kayttajaid);
        lause.setString(2,loppu);
        lause.setString(3,alku);
        ResultSet rs = lause.executeQuery();
        tulostaja.tulostaTiedot(rs);
    }

    public void haeKayttajanTunnit(String alku, String loppu) throws SQLException {
        String sql = "Select kayttajaid, kayttajat.sukunimi, paivamaara, minuutit, tehtavakuvaus, laskutettava from tuntienkirjaus join kayttajat on kayttajat.id = kayttajaid where paivamaara<? and paivamaara>?";
        System.out.println("testi");
        PreparedStatement lause = con.prepareStatement(sql);
        lause.setString(1,loppu);
        lause.setString(2,alku);
        ResultSet rs = lause.executeQuery();
        tulostaja.tulostaTiedot(rs);
    }

    public void haeKayttajanTunnit(int kayttajaid) throws SQLException {
        String sql = "Select kayttajaid, kayttajat.sukunimi, paivamaara, minuutit, tehtavakuvaus, laskutettava from tuntienkirjaus join kayttajat on kayttajat.id = kayttajaid where kayttajaid=?";
        System.out.println("testi");
        PreparedStatement lause = con.prepareStatement(sql);
        lause.setInt(1, kayttajaid);
        ResultSet rs = lause.executeQuery();
        tulostaja.tulostaTiedot(rs);
    }

    public void kirjaaKayttajanTunnit(int kayttajaid, String paivamaara, int minuutit, String tehtavakuvaus, boolean laskutettava) throws SQLException {
        String sql = "insert into tuntienkirjaus(kayttajaid, paivamaara, minuutit, tehtavakuvaus, laskutettava) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement lause = con.prepareStatement(sql);
        lause.setInt(1, kayttajaid);
        lause.setString(2, paivamaara);
        lause.setInt(3, minuutit);
        lause.setString(4, tehtavakuvaus);
        lause.setBoolean(5, laskutettava);
        lause.executeUpdate();
        System.out.println("Tunnit kirjattu!");



    }

    public void haeKaikkiTunnit() throws SQLException {
        String sql = "Select * from tuntienkirjaus";
        PreparedStatement lause = con.prepareStatement(sql);
        ResultSet rs = lause.executeQuery();
        tulostaja.tulostaTiedot(rs);
    }

}
