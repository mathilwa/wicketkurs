package no.nav.wicketkurs.web.containers;


import no.nav.wicketkurs.web.panels.KommentarListePanel;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;

public class VisInnleggKnapp extends AjaxLink {

    private KommentarListePanel kommentarListePanel;

    public VisInnleggKnapp(String id, final KommentarListePanel kommentarListePanel) {
        super(id);
        this.kommentarListePanel = kommentarListePanel;
        setOutputMarkupId(true);

        add(new Label("knappTekst", new AbstractReadOnlyModel<Object>() {
            @Override
            public Object getObject() {
                if (kommentarListePanel.isVisibilityAllowed()) {
                    return "Skjul blogginnlegg";
                } else {
                    return "Vis blogginnlegg";
                }
            }
        }));
    }

    @Override
    public void onClick(AjaxRequestTarget ajaxRequestTarget) {
        kommentarListePanel.setVisibilityAllowed(!kommentarListePanel.isVisibilityAllowed());
        ajaxRequestTarget.add(kommentarListePanel);
        ajaxRequestTarget.add(this);
    }
}
