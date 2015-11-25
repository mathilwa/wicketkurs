package no.nav.wicketkurs.web.panels;

import no.nav.wicketkurs.domain.Kommentar;
import no.nav.wicketkurs.web.WicketTestBase;
import org.apache.wicket.markup.html.basic.Label;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static no.nav.modig.wicket.test.matcher.ComponentMatchers.ofType;
import static org.junit.Assert.*;

public class KommentarListePanelTest extends WicketTestBase{

    @Before
    public void setUp() throws Exception {
        wicket().goToPageWith(new KommentarListePanel("id", genererKommentarliste()));
    }

    @Test
    public void sjekkAtListeelementeneGenereres() throws Exception {
        wicket()
                .should().containComponents(2, ofType(Label.class).withId("navn"))
                .should().containComponents(2, ofType(Label.class).withId("epost"))
                .should().containComponents(2, ofType(Label.class).withId("kommentartekst"));
    }

    private List<Kommentar> genererKommentarliste() {
        List<Kommentar> kommentarliste = new ArrayList<Kommentar>();
        kommentarliste.add(new Kommentar());
        kommentarliste.add(new Kommentar());

        return kommentarliste;
    }
}