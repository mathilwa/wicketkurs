package no.nav.wicketkurs.web.panels;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;

import java.util.Date;


public class DatingPanel extends Panel {

    public DatingPanel(String id) {
        super(id);

        add(
                new Label("dato", new AbstractReadOnlyModel<String>() {
                    @Override
                    public String getObject() {
                        return new Date().toString();
                    }
                } )
        );
    }


}
