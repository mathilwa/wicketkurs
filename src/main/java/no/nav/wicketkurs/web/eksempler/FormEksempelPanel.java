package no.nav.wicketkurs.web.eksempler;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

/**
 * Created by w132123 on 24.11.2015.
 */
public class FormEksempelPanel extends Panel {

    public FormEksempelPanel(String id) {
        super(id);

        Form eksempelForm = new Form("eksempelForm") {
            @Override
            protected void onSubmit() {
                //Gjør noe
            }
        };

        eksempelForm.add(new Label("tekstfeltLabel", "Fyll inn tekst"));
        eksempelForm.add(new TextField("tekstfelt", new Model()));
    }
}
