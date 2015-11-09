package no.nav.wicketkurs.web;

import no.nav.modig.wicket.test.FluentWicketTester;
import org.apache.wicket.Page;
import org.apache.wicket.ThreadContext;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.settings.IMarkupSettings;
import org.apache.wicket.settings.IResourceSettings;
import org.apache.wicket.spring.test.ApplicationContextMock;
import org.junit.After;

/**
 * Baseklasse for wicket tester
 */
public class WicketTestBase<WebApplication> {

    protected ApplicationContextMock applicationContext;
    protected FluentWicketTester<WicketApplication> wicket;

    protected final FluentWicketTester<WicketApplication> wicket() {
        applicationContext = new ApplicationContextMock();
        if (wicket == null) {
            wicket = new FluentWicketTester<WicketApplication>(createWebApplication());
        }
        return wicket;
    }

    protected WicketApplication createWebApplication() {
        return new WicketApplication() {
            @Override
            public Class<? extends Page> getHomePage() {
                return WebPage.class;
            }

            @Override
            protected void init() {
                WicketTestBase.this.initApplication(this);
            }
        };
    }

    /**
     * Call this from your {@link org.apache.wicket.protocol.http.WebApplication#init()}
     *
     * @param application the WebApplication to use in the test
     */
    protected final void initApplication(WicketApplication application) {
        IMarkupSettings settings = application.getMarkupSettings();
        settings.setDefaultMarkupEncoding("UTF-8");
        settings.setStripWicketTags(true);

        initResources(application.getResourceSettings());
//        application.getFrameworkSettings().add(new AnnotationEventDispatcher());

        application.getResourceSettings().setUseDefaultOnMissingResource(true);
        application.getResourceSettings().setThrowExceptionOnMissingResource(false);
    }

    @After
    public void unsetWicketApplication() {
        ThreadContext.setApplication(null);
    }

    /**
     * Override to manipulate the Wicket application's {@link org.apache.wicket.settings.IResourceSettings}.
     *
     * @param resourceSettings settings to manipulate.
     */
    protected void initResources(IResourceSettings resourceSettings) {
    }

}
