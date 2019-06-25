/**
 *  Classe Practica3.
 *  Una primera classe amb lectura de dades des de teclat, 
 *  i us d'operacions amb int, long, Math i String.
 *  Conte tres errores de compilacio.
 *  @author (IIP. Grau en Informatica. ETSINF, UPV) 
 *  @version (Curs 2014-15)
 */
import java.util.*;

public class Practica3
{    
   public static void main( String[] args )
   {
       Scanner teclat = new Scanner(System.in);

       // Informa al usuario
       System.out.println("Lectura de teclat d'una hora.");
       // Pide al usuario que introduzca una hora
       System.out.print(" -> Introduiu l'hora (entre 0 i 23): ");
       // Espera a que el usuario la introduzca
       int hman = teclat.nextInt();
       // Pide al usuario que introduzca los minutos
       System.out.print(" -> Introduiu els minuts (entre 0 i 59): ");
       // Espera a que el usuario los introduzca
       int mman = teclat.nextInt();

       // Muestra por pantalla lo que el usuario a introducido, en varios formatos, cada uno en una línea
       //System.out.println("Hora introduida: "
                      //  + (hman/10) + (hman%10) + ":"
                       // + (mman/10) + (mman%10) + "." );
       System.out.printf( "Hora introduida: %02d:%02d\n", hman, mman );
       //System.out.println( String.format( "Hora introduida: %02d:%02d", hman, mman ) );
       
       // Muestra por pantalla los milisegundos transcurridos desde las 00:00:00 del 1 de enero de 1970
       System.out.println( System.currentTimeMillis() );
       
       // Nos quedamos con los segundos del día actual desde las 00:00:00
       // Para ello dividimos por 1000 para obtener la cantidad en segundos
       // con el módulo respecto del total de segundos en un día obtenemos el dato buscado.
       int segundosDia = (int)( (System.currentTimeMillis() / 1000) % (24*60*60) );
       
       // Mostramos el dato buscado
       System.out.println();
       System.out.println( "Segundos de un día: " + segundosDia );
       
       // Desglosamos a hh:mm:ss
       int hsys = segundosDia / (60*60);
       int msys = (segundosDia/60) % 60;
       int ssys = segundosDia % 60;
       System.out.printf( "Hora actual en Canarias: %02d:%02d:%02d\n", hsys, msys, ssys );
       
       // Obtenemos una instancia de la clase Calendar con el tiempo al instante actual
       Calendar cal = Calendar.getInstance();
       // Extraemos de dicho objeto o instancia los datos que nos interesan.
       // Calendar se encarga de controlar el desfase horario según la zona horaria
       hsys = cal.get( Calendar.HOUR_OF_DAY );
       msys = cal.get( Calendar.MINUTE );
       ssys = cal.get( Calendar.SECOND );
       System.out.printf( "Hora actual: %02d:%02d:%02d\n", hsys, msys, ssys );
       
       // Pasamos a segundos la hora introducida por el usuario
       int man = hman * 60*60 + mman * 60 + 0;
       // Pasamos a segundos la hora actual obtenida del sistema
       int sys = hsys * 60*60 + msys * 60 + ssys;
       
       int dif = man - sys;
       
       // Si diferencia negativa sumamos los segundos de un día
       if ( dif < 0 ) dif += 24*60*60;
       
       // Desglosamos a hh:mm:ss la diferencia en segundos
       int hdif = dif / (60*60);
       int mdif = (dif/60) % 60;
       int sdif = dif % 60;
       
       System.out.printf( "Diferencia: %02d:%02d:%02d\n", hdif, mdif, sdif );
       
       String hora = String.format( "%02d:%02d", hman, mman );
       
       // Guardamos en la variable 'capicua' del tipo boolean 'verdadero' o 'falso' según
       // el resultado de evaluar la expresión a la derecha del operador de asignación '='.
       boolean capicua = hora.charAt( 0 ) == hora.charAt( 4 )
                      && hora.charAt( 1 ) == hora.charAt( 3 );
                   
      System.out.printf( "La hora %s %s capicua\n", hora, (capicua ? "es" : "no es") );  
    }    
}
