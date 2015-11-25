package no.nav.wicketkurs.web.pages;

import no.nav.wicketkurs.web.WicketTestBase;
import no.nav.wicketkurs.web.containers.VisInnleggKnapp;
import no.nav.wicketkurs.web.panels.DatoPanel;
import no.nav.wicketkurs.web.panels.GratulasjonstekstPanel;
import no.nav.wicketkurs.web.panels.KommentarListePanel;
import no.nav.wicketkurs.web.panels.LeggTilKommentarPanel;
import org.apache.wicket.markup.html.basic.Label;
import org.junit.Before;
import org.junit.Test;

import static no.nav.modig.wicket.test.matcher.ComponentMatchers.ofType;

public class ForsidePageTest extends WicketTestBase {

    @Before
    public void setup() {
        wicket().goTo(ForsidePage.class);
    }

    @Test
    public void komponenterFinnesISiden() throws Exception {
        wicket()
                .should().containComponent(ofType(Label.class).withId("bloggtittel"))
                .should().containComponent(ofType(Label.class).withId("blogg"))
                .should().containComponent(ofType(DatoPanel.class).withId("datoPanel2"))
                .should().containComponent(ofType(DatoPanel.class).withId("datoPanel"))
                .should().containComponent(ofType(LeggTilKommentarPanel.class).withId("leggTilKommentarPanel"))
                .should().containComponent(ofType(VisInnleggKnapp.class).withId("visInnleggKnapp"))
                .should().containComponent(ofType(GratulasjonstekstPanel.class).withId("gratulasjonstekstPanel"))
                .should().containComponent(ofType(KommentarListePanel.class).withId("kommentarPanel"));
    }
}
