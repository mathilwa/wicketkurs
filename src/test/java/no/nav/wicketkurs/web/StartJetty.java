package no.nav.wicketkurs.web;

import java.io.File;

import static no.nav.sbl.dialogarena.common.jetty.Jetty.usingWar;
import static no.nav.sbl.dialogarena.test.path.FilesAndDirs.TEST_RESOURCES;

/**
 * Starter lokal Jetty-server
 */
public final class StartJetty {

    private StartJetty() {
    }

    public static void main(String[] args) throws Exception {

        System.setProperty("wicket.configuration", "development");
        usingWar(new File(TEST_RESOURCES, "webapp"))
                .at("/wicketkurs")
                .port(8080)
                .buildJetty()
                .start();

    }
}
