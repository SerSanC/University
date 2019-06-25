/**
 * Clase TestHora. 
 * 
 *  @author (IIP - GII - ETSINF, UPV) 
 *  @version (Ejercicio2 - Turno 1 - Curso 2014-15)
 */
import java.util.Scanner;
public class TestHora {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Lectura de teclado de una hora.");
        System.out.print("   -> Introduzca la hora (entre 0 y 23): ");
        int h = teclado.nextInt();
        System.out.print("   -> Introduzca los minutos (entre 0 y 59): ");
        int m = teclado.nextInt();
        Hora hora;
        
        if (h<24 && h >=0 && m < 60 && m >=0){
          hora = new Hora (h,m);
          }     
        else {
        
            hora = new Hora();
        
        }
        hora.decrementar1Min();
        System.out.println(hora.toString());
    }
}