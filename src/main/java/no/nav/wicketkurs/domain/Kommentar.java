package no.nav.wicketkurs.domain;

import java.io.Serializable;

public class Kommentar implements Serializable {

    private String navn;

    private String epost;

    private String kommentartekst;

    public Kommentar() {}

    public Kommentar(String navn, String epost, String kommentartekst) {
        this.navn = navn;
        this.epost = epost;
        this.kommentartekst = kommentartekst;
    }

    public String getNavn() {
        return navn;
    }

    public String getEpost() {
        return epost;
    }

    public String getKommentartekst() {
        return kommentartekst;
    }

    public void setNavn() {

    }
}
