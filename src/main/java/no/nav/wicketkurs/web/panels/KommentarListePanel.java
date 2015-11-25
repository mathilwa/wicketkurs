package no.nav.wicketkurs.web.panels;

import no.nav.wicketkurs.domain.Kommentar;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.markup.html.panel.Panel;

import java.util.List;

public class KommentarListePanel extends Panel {

    public KommentarListePanel(String id, List<Kommentar> kommentarliste) {
        super(id);
        setOutputMarkupPlaceholderTag(true);

        add(
                new PropertyListView<Kommentar>("kommentarliste", kommentarliste) {
                    @Override
                    protected void populateItem(ListItem<Kommentar> item) {
                        item.add(new Label("navn"));
                        item.add(new Label("epost"));
                        item.add(new Label("kommentartekst"));
                    }
                }
        );
    }


}
