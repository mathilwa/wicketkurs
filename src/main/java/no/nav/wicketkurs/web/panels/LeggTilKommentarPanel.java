package no.nav.wicketkurs.web.panels;

import no.nav.wicketkurs.domain.Kommentar;
import no.nav.wicketkurs.services.DBService;
import no.nav.wicketkurs.services.DBServiceImpl;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;


public class LeggTilKommentarPanel extends Panel {

    private DBService dbService = DBServiceImpl.getInstance();

    public LeggTilKommentarPanel(String id) {
        super(id);

        final TextField navnFelt = new TextField("navn", new Model());
        final TextField kommentartekstFelt = new TextField("kommentar", new Model());
        final TextField mailFelt = new TextField("mail", new Model());

        Form kommentarForm = new Form("kommentarForm") {
            @Override
            protected void onSubmit() {
                System.out.println("Lagt til");
                dbService.leggTilKommentar(new Kommentar(navnFelt.getModelObject().toString(), mailFelt.getModelObject().toString(), kommentartekstFelt.getModelObject().toString()));
            }
        };

        kommentarForm.add(new Label("navnLabel", "Navn"));
        kommentarForm.add(new Label("kommentarLabel", "Kommentar"));
        kommentarForm.add(new Label("mailLabel", "Mail"));
        kommentarForm.add(navnFelt);
        kommentarForm.add(kommentartekstFelt);
        kommentarForm.add(mailFelt);

        add(kommentarForm);
    }
}
