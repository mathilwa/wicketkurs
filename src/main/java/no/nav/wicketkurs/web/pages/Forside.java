package no.nav.wicketkurs.web.pages;

import no.nav.wicketkurs.web.panels.DatingPanel;
import no.nav.wicketkurs.web.panels.KommentarPanel;
import no.nav.wicketkurs.web.panels.KommentarSkjemaPanel;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;

/**
 * Startside
 */
public class Forside extends BasePage {




    public Forside() {

        setStatelessHint(false);

        final KommentarPanel kommentarPanel = new KommentarPanel("kommentarPanel");
        AjaxLink ajaxLink = new AjaxLink("visBlogginnlegg") {

            @Override
            public void onClick(AjaxRequestTarget ajaxRequestTarget) {
                kommentarPanel.setVisibilityAllowed(!kommentarPanel.isVisibilityAllowed());
                ajaxRequestTarget.add(kommentarPanel);
                ajaxRequestTarget.add(this);
            }
        };
        ajaxLink.setOutputMarkupId(true);
        ajaxLink.add(new Label("knappTekst", new AbstractReadOnlyModel<Object>() {
            @Override
            public Object getObject() {
                return kommentarPanel.isVisibilityAllowed() ? "Skjul blogginnlegg" : "Vis blogginnlegg";
            }
        }));

        add(
                new Label("blogg", "Hei bloooggen!"),
                new DatingPanel("datoPanel2"),
                new DatingPanel("datoPanel")
        );
    }
}
