package no.nav.wicketkurs.web.panels;

import no.nav.wicketkurs.domain.Kommentar;
import no.nav.wicketkurs.services.DBService;
import no.nav.wicketkurs.services.DBServiceImpl;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;


public class LeggTilKommentarPanel extends Panel {

    private DBService dbService = DBServiceImpl.getInstance();

    public LeggTilKommentarPanel(String id) {
        super(id);

        Form kommentarForm = new Form("kommentarForm", new CompoundPropertyModel(new Kommentar())) {
            @Override
            protected void onSubmit() {
                dbService.leggTilKommentar((Kommentar) getModelObject());
                setModelObject(new Kommentar());
            }
        };

        kommentarForm.add(new Label("navnLabel", "Navn"));
        kommentarForm.add(new Label("kommentarLabel", "Kommentar"));
        kommentarForm.add(new Label("epostLabel", "Epost"));
        kommentarForm.add(new TextField("navn"));
        kommentarForm.add(new TextField("epost"));
        kommentarForm.add(new TextField("kommentartekst"));

        add(kommentarForm);
    }
}
