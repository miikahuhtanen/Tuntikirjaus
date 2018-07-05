import java.time.LocalDate;

public class Kayttajantunnit {
    private LocalDate paivamaara;
    private double tunnit;
    private String tehtavakuvaus;
    private boolean laskutettava;
    private String sukunimi;
    private int kayttajaid;


    public Kayttajantunnit(LocalDate paivamaara, double tunnit, String tehtavakuvaus, boolean laskutettava, String sukunimi, int kayttajaid) {
        this.paivamaara = paivamaara;
        this.tunnit = tunnit;
        this.tehtavakuvaus = tehtavakuvaus;
        this.laskutettava = laskutettava;
        this.kayttajaid = kayttajaid;
        this.sukunimi = sukunimi;
    }

    public LocalDate getPaivamaara() {
        return paivamaara;
    }

    public void setPaivamaara(LocalDate paivamaara) {
        this.paivamaara = paivamaara;
    }

    public double getTunnit() {
        return tunnit;
    }

    public void setTunnit(double tunnit) {
        this.tunnit = tunnit;
    }

    public String getTehtavakuvaus() {
        return tehtavakuvaus;
    }

    public void setTehtavakuvaus(String tehtavakuvaus) {
        this.tehtavakuvaus = tehtavakuvaus;
    }

    public boolean isLaskutettava() {
        return laskutettava;
    }

    public void setLaskutettava(boolean laskutettava) {
        this.laskutettava = laskutettava;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public int getKayttajaid() {
        return kayttajaid;
    }

    public void setKayttajaid(int kayttajaid) {
        this.kayttajaid = kayttajaid;
    }

    @Override
    public String toString() {
        String format = "%-5s | %-20s | %-20s | %-20s | %-30s | %-10s";
        String i = Integer.toString(this.getKayttajaid());
        String s = this.getSukunimi();
        String p = this.getPaivamaara().toString();
        String t = Double.toString(this.getTunnit());
        String tk = this.getTehtavakuvaus();
        String l = Boolean.toString(this.isLaskutettava());

        return String.format(format,i,s,p,t,tk,l);
//        return String.format(format,n,this.getSukunimi(),this.getPaivamaara(),this.getTunnit(),this.getTehtavakuvaus(),this.isLaskutettava());

    }
}
