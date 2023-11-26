package de.eldecker.dhbw.cucumber.datumsarithmetik;

import static java.time.ZoneOffset.UTC;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
 * Relevante API-Doku:
 * <ul>
 *  <li>Cucumber: https://javadoc.io/doc/io.cucumber/cucumber-java/latest/index.html</li>
 *  <li>Junit, Klasse {@code Assertions}: https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/Assertions.html</li>
 * </ul>
 */
public class StepDefinitions {

    /** Instanz der Class Under Test (CUT). */
    private Datumsberechnungen _cut = null;

    
    /**
     * Singleton-Instanz der Klasse unter Test wird geholt.
     */
    @Given("die API unter Test ist initialisiert")
    public void givenApiIstInitialisiert() {

        _cut = Datumsberechnungen.getSingletonInstanz();
        assertNotNull(_cut, "Keine Instant der Klasse unter Test erhalten");
    }
    

    /**
     * Diese Methode wirft eine Exception wenn das spezifizierte Datum nicht
     * möglich ist, z.B. {@code monat=13}. Als Zeitzone wird UTC (Greenwich-Zeit
     * ohne Sommerzeit) verwendet.
     * 
     * @param jahr Jahreszahl vierstellig, z.B. 2023
     * @param monat Monat als Zahl von 1 bis 12
     * @param tagImMonat Tag im Monat, 1-31
     */
    @When("das heutige Datum der <{int}-{int}-{int}> ist")
    public void whenDasHeuteDatumDerIst(Integer jahr, Integer monat, Integer tagImMonat) {

        LocalDate localDate = LocalDate.of(jahr, monat, tagImMonat);
        Instant instant = localDate.atStartOfDay().toInstant(UTC);

        _cut.setHeuteDatumForTesting(instant);
    }

    
    /**
     * Überprüft, ob als Argument übergebener Wochentag als Wochentag für
     * heute zurückgegeben wird.
     * 
     * @param wochentagErwartet Deutscher Wochentag ausgeschrieben, z.B. "Samstag" 
     *                          (der Vergleich ist case-sensitive!)
     */
    @Then("wird als Wochentag {string} zurückgegeben")
    public void thenWirdAlsWochentagZurueckgegeben(String wochentagErwartet) {

        final String wochentagTatsaechlich = _cut.getWochentagHeute();
        assertEquals(wochentagErwartet, wochentagTatsaechlich);
    }
    
    
    /**
     * Überprüft, ob bei Addition von {@code deltaTage} auf das heutige Datum von der Klasse
     * unter Test das Datum zurückgegeben wird, das mit den restlichen drei Argumenten spezifiziert
     * wird.
     * 
     * @param deltaTage Anzahl Tage, die auf heutiges Datum zu addieren ist; kann auch negativ sind.
     * @param jahr Vierstellige Jahreszahl?
     * @param monat Monat, 1-12
     * @param tagImMonat Tag im Monat, 1-31
     */
    @Then("ist in <{int}> Tagen der <{int}-{int}-{int}>")
    public void thenIstInNTagen(Integer deltaTage, Integer jahr, Integer monat, Integer tagImMonat) {

        LocalDate.of(jahr, monat, tagImMonat); // wirft DateTimeException, wenn Datum nicht möglich ist
        
        final String ergebnisDatum = _cut.heutePlusTage(deltaTage);
        
        final String erwartetesDatum = String.format("%d-%02d-%02d", jahr, monat, tagImMonat);
        assertEquals(erwartetesDatum, ergebnisDatum);
    }

}
