package no.nav.wicketkurs.web.panels;

import no.nav.wicketkurs.domain.Kommentar;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;

import java.util.List;

public class KommentarListePanel extends Panel {

    public KommentarListePanel(String id, List<Kommentar> kommentarliste) {
        super(id);

        add(
                new ListView<Kommentar>("kommentarliste", kommentarliste) {
                    @Override
                    protected void populateItem(ListItem<Kommentar> item) {
                        Kommentar kommentar = item.getModelObject();
                        item.add(new Label("navn", kommentar.getNavn()));
                        item.add(new Label("epost", kommentar.getEpost()));
                        item.add(new Label("tekst", kommentar.getKommentartekst()));
                    }
                }
        );
    }


}
