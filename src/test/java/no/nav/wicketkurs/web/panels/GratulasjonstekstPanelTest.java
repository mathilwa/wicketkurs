package no.nav.wicketkurs.web.panels;

import no.nav.wicketkurs.domain.Kommentar;
import no.nav.wicketkurs.web.WicketTestBase;
import org.apache.wicket.markup.html.basic.Label;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static no.nav.modig.wicket.test.matcher.ComponentMatchers.ofType;

public class GratulasjonstekstPanelTest extends WicketTestBase {


    @Test
    public void gratulasjonstekstSkalIkkeVisesOmDetErMindreEnn5Kommentarer() throws Exception {
        wicket().goToPageWith(new GratulasjonstekstPanel("id", genererKommentarliste(4)))
                .should()
                .containComponent(ofType(Label.class).thatIsInvisible());
    }

    private List<Kommentar> genererKommentarliste(int antallKommentarerILista) {
        List<Kommentar> kommentarliste = new ArrayList<Kommentar>();
        for (int i = 0; i < antallKommentarerILista; i++) {
            kommentarliste.add(new Kommentar());
        }

        return kommentarliste;
    }
}