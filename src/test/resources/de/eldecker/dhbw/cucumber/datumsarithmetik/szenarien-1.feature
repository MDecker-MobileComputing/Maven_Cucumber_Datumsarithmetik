# Dieses Feature File muss in Gherkin-Syntax geschrieben sein,
# siehe auch: https://cucumber.io/docs/gherkin/reference/

Feature: Hilfsklasse für Datumsarithmetik für heutigen Tag

  Scenario: Heute ist Samstag
    Given die API unter Test ist initialisiert
     When das heutige Datum der <2023-11-25> ist
     Then wird als Wochentag "Samstag" zurückgegeben
