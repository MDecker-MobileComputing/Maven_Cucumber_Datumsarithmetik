package de.eldecker.dhbw.datumsarithmetik;

import static java.time.format.TextStyle.FULL;
import static java.time.ZoneOffset.UTC;
import static java.util.Locale.GERMAN;

import java.time.DayOfWeek;
import java.time.Instant;

/**
 * Diese Klasse enthält Hilfsmethoden für Datumsarithmetik
 * mit dem aktuellen Datum als Startdatum.
 */
public class Datumsberechnungen {

  private static Datumsberechnungen sSingletonInstanz = null;

  private Instant _heuteInstant = Instant.now();

  /**
   * Privater Dummy-Konstruktor um zu verhindern, dass ein Objekt
   * dieser Klasse von einer anderen Klasse erzeugt wird.
   */
  private Datumsberechnungen() {

      // absichtlich leer gelassen
  }

  /**
   * Methode liefert Singleton-Instanz der Klasse zurück;
   * Singleton-Objekt wird ggf. erzeugt.
   *
   * @return Singleton-Instanz
   */
  public static Datumsberechnungen getSingletonInstanz() {

      if (sSingletonInstanz == null)  {

          sSingletonInstanz = new Datumsberechnungen();
      }

      return sSingletonInstanz;
  }

  /**
   * Methode um den Namen des heutigen Wochentages zu bekommen.
   *
   * @return Wochentag, ausgeschrieben und auf Deutsch, z.B. "Samstag"
   */
  public String getWochentagHeute() {

    DayOfWeek dayOfWeek = _heuteInstant.atZone(UTC).getDayOfWeek();
    return dayOfWeek.getDisplayName(FULL, GERMAN);
  }

  public String heutePlusTage(int tage) {

    return "";
  }

  /**
   * Mit dieser Methode kann das Datum für den heutigen Tag
   * für Testzwecke kontrolliert (geändert) werden.
   */
  public void setHeuteDatumForTesting(Instant heuteInstant) {

      _heuteInstant = heuteInstant;
  }

}