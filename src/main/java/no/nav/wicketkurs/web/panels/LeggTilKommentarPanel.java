package no.nav.wicketkurs.web.panels;

import no.nav.wicketkurs.domain.Kommentar;
import no.nav.wicketkurs.services.DBService;
import no.nav.wicketkurs.services.DBServiceImpl;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;


public class LeggTilKommentarPanel extends Panel {

    public static final String VELLYKKET_INNSENDING = "Du har sendt inn melding";
    private DBService dbService = DBServiceImpl.getInstance();

    public LeggTilKommentarPanel(String id) {
        super(id);

        FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackPanel");
        Form kommentarForm = new Form<Kommentar>("kommentarForm", new CompoundPropertyModel<Kommentar>(new Kommentar())) {
            @Override
            protected void onSubmit() {
                dbService.leggTilKommentar(getModelObject());
                setModelObject(new Kommentar());

                info(VELLYKKET_INNSENDING);
            }
        };

        kommentarForm.add(feedbackPanel);
        kommentarForm.add(new Label("navnLabel", "Navn"));
        kommentarForm.add(new Label("kommentarLabel", "Kommentar"));
        kommentarForm.add(new Label("epostLabel", "Epost"));
        kommentarForm.add(new TextField("navn"));
        kommentarForm.add(new TextField("epost"));
        kommentarForm.add(new TextField("kommentartekst"));

        add(kommentarForm);
    }
}
