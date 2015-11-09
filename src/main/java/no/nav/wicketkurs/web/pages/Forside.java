package no.nav.wicketkurs.web.pages;

import no.nav.wicketkurs.services.DBService;
import no.nav.wicketkurs.services.DBServiceImpl;
import no.nav.wicketkurs.web.panels.DatoPanel;
import org.apache.wicket.markup.html.basic.Label;

/**
 * Startside
 */
public class Forside extends BasePage {

    private DBService dbService;

    public Forside() {
        dbService = DBServiceImpl.getInstance();

        setStatelessHint(false);

        add(
                new Label("blogg", "Hei bloooggen!"),
                new DatoPanel("datoPanel2"),
                new DatoPanel("datoPanel")
        );
    }
}
