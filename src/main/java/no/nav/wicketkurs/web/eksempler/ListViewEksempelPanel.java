package no.nav.wicketkurs.web.eksempler;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;

import java.util.Arrays;
import java.util.List;

public class ListViewEksempelPanel extends Panel {

    public ListViewEksempelPanel(String id) {
        super(id);

        List liste = Arrays.asList("Element 1", "Element 2", "Element 3");

        ListView listevisning = new ListView("listevisning", liste) {

            @Override
            protected void populateItem(ListItem listItem) {
                String listeelement = (String) listItem.getModelObject();

                listItem.add(new Label("listeelement", listeelement));
            }
        };

        add(listevisning);


    }
}
