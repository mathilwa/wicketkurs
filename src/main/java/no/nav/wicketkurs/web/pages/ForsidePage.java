package no.nav.wicketkurs.web.pages;

import no.nav.wicketkurs.domain.Kommentar;
import no.nav.wicketkurs.services.DBService;
import no.nav.wicketkurs.services.DBServiceImpl;
import no.nav.wicketkurs.web.containers.VisInnleggKnapp;
import no.nav.wicketkurs.web.panels.DatoPanel;
import no.nav.wicketkurs.web.panels.GratulasjonstekstPanel;
import no.nav.wicketkurs.web.panels.KommentarListePanel;
import no.nav.wicketkurs.web.panels.LeggTilKommentarPanel;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;

import java.util.List;

/**
 * Startside
 */
public class ForsidePage extends BasePage {

    private DBService dbService;

    public ForsidePage() {
        dbService = DBServiceImpl.getInstance();
        setStatelessHint(false);

        final List<Kommentar> kommentarliste = dbService.getKommentarer();
        final KommentarListePanel kommentarListePanel = new KommentarListePanel("kommentarPanel", kommentarliste);

        add(
                new Label("bloggtittel", "Mathildes rosablogg"),
                new Label("blogg", "Hei bloooggen!"),
                new DatoPanel("datoPanel2"),
                new DatoPanel("datoPanel"),
                new LeggTilKommentarPanel("leggTilKommentarPanel"),
                new VisInnleggKnapp("visInnleggKnapp", kommentarListePanel),
                new GratulasjonstekstPanel("gratulasjonstekstPanel", kommentarliste),
                kommentarListePanel
        );
    }
}
