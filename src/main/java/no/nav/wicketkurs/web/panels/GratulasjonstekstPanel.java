package no.nav.wicketkurs.web.panels;

import no.nav.wicketkurs.domain.Kommentar;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;

import java.util.List;

import static no.nav.modig.wicket.conditional.ConditionalUtils.visibleIf;

/**
 * Created by w132123 on 24.11.2015.
 */
public class GratulasjonstekstPanel extends Panel {

    public GratulasjonstekstPanel(String id, final List<Kommentar> kommentarliste) {
        super(id);

        Label gratulasjonsLabel = (Label) new Label("gratulasjon", "Gratulerer med over flere enn 4 blogginnlegg").add(visibleIf(new AbstractReadOnlyModel<Boolean>() {
            @Override
            public Boolean getObject() {
                return kommentarliste.size() >= 5;
            }
        }));

        gratulasjonsLabel.setOutputMarkupId(true);

        add(gratulasjonsLabel);
    }
}
