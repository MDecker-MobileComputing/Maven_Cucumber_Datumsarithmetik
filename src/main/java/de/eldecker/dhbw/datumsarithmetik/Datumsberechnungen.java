package de.eldecker.dhbw.datumsarithmetik;

import static java.time.format.TextStyle.FULL;
import static java.time.ZoneOffset.UTC;
import static java.util.Locale.GERMAN;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Diese Klasse enthält Hilfsmethoden für Datumsarithmetik mit dem aktuellen Datum als Startdatum.
 */
public class Datumsberechnungen {

      /** Singleton-Instanz der Klasse, wird bei Bedarf in statischer Methode {@link #getSingletonInstanz()} erzeugt. */  
      private static Datumsberechnungen sSingletonInstanz = null;
      
      /** Formatierer, um {@code Instant}-Objekte in der Form {@code yyyy-MM-dd} zu formatieren, z.B. "2023-01-01". */ 
      private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );
    
      /** Heutiges Datum; kann mit Methode {@link #setHeuteDatumForTesting(Instant)} geändert werden. */
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
    
          if ( sSingletonInstanz == null )  {
    
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
    
        DayOfWeek dayOfWeek = _heuteInstant.atZone( UTC ).getDayOfWeek();
        return dayOfWeek.getDisplayName( FULL, GERMAN );
      }
    
      
      /**
       * Addiert Anzahl {@code tage} auf heutiges Datum und gibt das Ergebnisdatum
       * zurück.
       *
       * @param anzahlTage Anzahl Tage, die auf heutiges Datum zu addieren ist;
       *                   kann auch negativ sein.
       *                   
       * @return String mit Ergebnisdatum im Format {@code YYYY-MM-DD}, z.B. "2023-11-13".
       */
      public String heutePlusTage(int anzahlTage) {
    
          Duration duration       = Duration.ofDays( anzahlTage );
          Instant ergebnisInstant = _heuteInstant.plus( duration );
          
          LocalDate localDate = ergebnisInstant.atZone( UTC ).toLocalDate();
          return localDate.format( DATE_TIME_FORMATTER );
      }
    
      
      /**
       * Mit dieser Methode kann das Datum für den heutigen Tag
       * für Testzwecke kontrolliert (geändert) werden.
       *
       * @param heuteInstant Neues Datum für "Heute"
       */
      public void setHeuteDatumForTesting( Instant heuteInstant ) {
    
          _heuteInstant = heuteInstant;
      }

}