package no.nav.wicketkurs.web.pages;

import no.nav.wicketkurs.domain.Kommentar;
import no.nav.wicketkurs.services.DBService;
import no.nav.wicketkurs.services.DBServiceImpl;
import no.nav.wicketkurs.web.panels.DatoPanel;
import no.nav.wicketkurs.web.panels.KommentarListePanel;
import no.nav.wicketkurs.web.panels.LeggTilKommentarPanel;
import org.apache.wicket.markup.html.basic.Label;

import java.util.List;

/**
 * Startside
 */
public class Forside extends BasePage {

    private DBService dbService;

    public Forside() {
        dbService = DBServiceImpl.getInstance();
        List<Kommentar> kommentarliste = dbService.getKommentarer();

        setStatelessHint(false);

        add(
                new Label("bloggtittel", "Mathildes rosablogg"),
                new Label("blogg", "Hei bloooggen!"),
                new DatoPanel("datoPanel2"),
                new DatoPanel("datoPanel"),
                new LeggTilKommentarPanel("leggTilKommentarPanel"),
                new KommentarListePanel("kommentarPanel", kommentarliste)
        );
    }
}
