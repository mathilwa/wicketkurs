package no.nav.wicketkurs.services;

import no.nav.wicketkurs.domain.Kommentar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DBServiceImpl implements DBService, Serializable {

    private static DBServiceImpl dbServiceImpl;

    private List<Kommentar> kommentarliste;

    public DBServiceImpl() {
        kommentarliste = new ArrayList<Kommentar>();
        opprettMockKommentarer();
    }

    private void opprettMockKommentarer() {
        kommentarliste.add(new Kommentar("Mathilde", "mathilde@mathilde.no", "Hallo, fra Mathilde"));
        kommentarliste.add(new Kommentar("Tine", "tine@tine.no", "Hei, fra Tine"));
        kommentarliste.add(new Kommentar("Team X", "teamx@teamx.no", "Dere gjør en kjempejobb, hilsen Team X"));
    }

    @Override
    public List<Kommentar> getKommentarer() {
        return kommentarliste;
    }

    @Override
    public void leggTilKommentar(Kommentar kommentar) {
        kommentarliste.add(kommentar);
    }

    public static DBServiceImpl getInstance(){
        if(dbServiceImpl == null){
            dbServiceImpl = new DBServiceImpl();
        }
        return dbServiceImpl;

    }
}
