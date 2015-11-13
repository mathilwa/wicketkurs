package no.nav.wicketkurs.web.panels;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DatoPanel extends Panel {

    public DatoPanel(String id) {
        super(id);

        add(
                new Label("dato", new AbstractReadOnlyModel<String>() {
                    @Override
                    public String getObject() {
                        SimpleDateFormat datovisning = new SimpleDateFormat("dd.MM.yy hh:mm");
                        return datovisning.format(new Date());
                    }
                } )
        );
    }


}
