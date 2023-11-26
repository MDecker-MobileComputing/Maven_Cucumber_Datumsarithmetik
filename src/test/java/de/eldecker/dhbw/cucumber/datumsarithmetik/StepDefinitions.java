package de.eldecker.dhbw.cucumber.datumsarithmetik;

import static java.time.ZoneOffset.UTC;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import de.eldecker.dhbw.datumsarithmetik.Datumsberechnungen;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.time.Instant;
import java.time.LocalDate;


/**
 * Diese Datei enthält die Implementierung der einzelnen Schritte, die in
 * den <i>Feature Files</i> verwendet werden.
 * <br><br>
 *
 * Relevante API-Docu:
 * <ul>
 *  <li>Cucumber: https://javadoc.io/doc/io.cucumber/cucumber-java/latest/index.html</li>
 *  <li>Junit, Klasse {@code Assertions}: https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/Assertions.html</li>
 * </ul>
 * Javadoc für
 */
public class StepDefinitions {

    /** Instanz der Class Under Test (CUT). */
    private Datumsberechnungen _cut = null;

    @Given("die API unter Test ist initialisiert")
    public void givenApiIstInitialisiert() {

        _cut = Datumsberechnungen.getSingletonInstanz();
        assertNotNull(_cut, "Keine Instant der Klasse unter Test erhalten");
    }

    /**
     * Diese Methode wirft eine Exception wenn das spezifizierte Datum nicht
     * möglich ist, z.B. {@code monat=13}. Als Zeitzone wird UTC (Greenwich-Zeit
     * ohne Sommerzeit) verwendet.
     */
    @When("das heutige Datum der <{int}-{int}-{int}> ist")
    public void whenDasHeuteDatumDerIst(Integer jahr, Integer monat, Integer tag) {

        LocalDate localDate = LocalDate.of(jahr, monat, tag);
        Instant instant = localDate.atStartOfDay().toInstant(UTC);

        _cut.setHeuteDatumForTesting(instant);
    }


    @Then("wird als Wochentag {string} zurückgegeben")
    public void thenWirdAlsWochentagZurueckgegeben(String wochentagErwartet) {

        final String wochentagTatsaechlich = _cut.getWochentagHeute();
        assertEquals(wochentagErwartet, wochentagTatsaechlich);
    }

}
