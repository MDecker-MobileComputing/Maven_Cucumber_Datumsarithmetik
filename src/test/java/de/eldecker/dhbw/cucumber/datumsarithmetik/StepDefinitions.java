package de.eldecker.dhbw.cucumber.datumsarithmetik;

import de.eldecker.dhbw.datumsarithmetik.Datumsberechnungen;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.junit.jupiter.api.Assertions.*;

/**
 * Diese Datei enthält die Implementierung der einzelnen Schritte, die in
 * den <i>Feature Files</i> verwendet werden.
 * <br><br>
 *
 * Javadoc für Cucumber-API: https://javadoc.io/doc/io.cucumber/cucumber-java/latest/index.html
 */
public class StepDefinitions {

    /** Instanz der Class Under Test (CUT). */
    private Datumsberechnungen _cut = null;

    @Given("die API unter Test ist initialisiert")
    public void givenApiIstInitialisiert() {

        _cut = Datumsberechnungen.getSingletonInstanz();
    }

    @When("das heutige Datum der <{int}-{int}-{int}> ist")
    public void whenDasHeuteDatumDerIst(Integer jahr, Integer monat, Integer tag) {
    }


    @Then("wird als Wochentag {string} zurückgegeben")
    public void thenWirdAlsWochentagZurueckgegeben(String string) {
    }

}
