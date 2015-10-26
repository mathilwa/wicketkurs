package no.nav.wicketkurs.web;

import no.nav.wicketkurs.web.pages.Forside;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.settings.IMarkupSettings;

/**
 * Kontrollerer wicket-applikasjonen
 */
public class WicketApplication extends WebApplication {
    @Override
    protected void init() {
        super.init();

        IMarkupSettings settings = getMarkupSettings();
        settings.setDefaultMarkupEncoding("UTF-8");
        settings.setStripWicketTags(true);
        settings.setStripComments(true);
        settings.setCompressWhitespace(true);

        mountPage("forside", Forside.class);

    }

    @Override
    public Class<? extends Page> getHomePage() {
        return Forside.class;
    }

}
