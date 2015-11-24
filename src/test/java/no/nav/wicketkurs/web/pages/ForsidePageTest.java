package no.nav.wicketkurs.web.pages;

import no.nav.wicketkurs.web.WicketTestBase;
import org.junit.Before;
import org.junit.Test;

public class ForsidePageTest extends WicketTestBase {

    @Before
    public void setup() {
        wicket().goTo(ForsidePage.class);
    }

    @Test
    public void testForside(){
        wicket.tester.assertRenderedPage(ForsidePage.class);
    }
}
