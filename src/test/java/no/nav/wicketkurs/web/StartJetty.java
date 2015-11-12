package no.nav.wicketkurs.web;

import static no.nav.sbl.jetty.Jetty.usingWebAppContextConfiguration;

/**
 * Starter lokal Jetty-server
 */
public final class StartJetty {

    private StartJetty() {
    }

    public static void main(String[] args) throws Exception {

        System.setProperty("wicket.configuration", "development");
        usingWebAppContextConfiguration("jetty-web-context.xml").port(8080).at("/wicketkurs")
                .buildJetty().start();

    }
}
