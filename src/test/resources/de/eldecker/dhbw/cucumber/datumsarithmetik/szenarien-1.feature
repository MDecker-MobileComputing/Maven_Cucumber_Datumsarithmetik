# Dieses Feature File muss in Gherkin-Syntax geschrieben sein,
# siehe auch: https://cucumber.io/docs/gherkin/reference/

Feature: Hilfsklasse für Datumsarithmetik

  Scenario: Heute ist Samstag
    Given die API unter Test ist initialisiert
     When das heutige Datum der <2023-11-25> ist
     Then wird als Wochentag "Samstag" zurückgegeben

# TODO: Rückgabe Wochentag als Tabelle überprüfen

  Scenario: Morgiges Datum im selben Monat
    Given die API unter Test ist initialisiert
     When das heutige Datum der <2023-11-25> ist
     Then ist in <1> Tagen der <2023-11-26>

  Scenario: Morgiges Datum im nächsten Monat
    Given die API unter Test ist initialisiert
     When das heutige Datum der <2023-11-30> ist
     Then ist in <1> Tagen der <2023-12-01>
     
  Scenario: Morgiges Datum im nächsten Jahr
    Given die API unter Test ist initialisiert
     When das heutige Datum der <2023-12-31> ist
     Then ist in <1> Tagen der <2024-01-01>

  Scenario: Gestriges Datum im selben Monat
    Given die API unter Test ist initialisiert
     When das heutige Datum der <2023-11-25> ist
     Then ist in <-1> Tagen der <2023-11-24>
 
   Scenario: Gestriges Datum im vorherigen Monat
    Given die API unter Test ist initialisiert
     When das heutige Datum der <2023-11-01> ist
     Then ist in <-1> Tagen der <2023-10-31>
     
   Scenario: Gestriges Datum im vorherigen Jahr
    Given die API unter Test ist initialisiert
     When das heutige Datum der <2023-01-01> ist
     Then ist in <-1> Tagen der <2022-12-31>