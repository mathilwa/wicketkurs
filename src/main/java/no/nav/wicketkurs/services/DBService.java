package no.nav.wicketkurs.services;

import no.nav.wicketkurs.domain.Kommentar;

import java.util.List;

/**
 *
 */
public interface DBService {

    List<Kommentar> getKommentarer();
}
