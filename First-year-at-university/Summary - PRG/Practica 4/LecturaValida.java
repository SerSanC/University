import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Clase LecturaValida: clase de utilidades para realizar la lectura válida de datos primitivos
 * desde la entrada estándar.
 * 
 * @author PRG 
 * @version Curso 2014/15
 */
public class LecturaValida {

    /**
     * Lee desde un Scanner y devuelve un valor real positivo.
     * @param tec Scanner para lectura desde teclado.
     * @param mensaje String para petición de valor.
     * @return double, real positivo leído.
     */    
    public static double leerDoublePos(Scanner tec, String mensaje) {
        boolean hayError = true; 
        double res = 0.0;
        do {
            try {
                System.out.printf(mensaje + " ");
                res = tec.nextDouble();    
                
                hayError = false;
           } catch(InputMismatchException e) {
                System.out.println("¡Asegúrate de introducir un entero válido! Inténtalo de nuevo ...");
           } finally {
                tec.nextLine();
           }
        }while (hayError || res <0);
           return res;
    }
    

    /**
     * Lee desde un Scanner y devuelve un valor entero.
     * @param tec Scanner para lectura desde teclado.
     * @param mensaje String para petición de valor.
     * @return int, entero leído.
     */
    public static int leerInt(Scanner tec, String mensaje) {
        int res = 0;
        boolean hayError = true; 
        do {
           try {
                System.out.print(mensaje+" ");
                res = tec.nextInt();
                hayError = false;
           } catch(InputMismatchException e) {
                System.out.println("¡Asegúrate de introducir un entero válido! Inténtalo de nuevo ...");
           } finally {
                tec.nextLine();
           }
        } while (hayError);
        return res;
    }

    /**
     * Lee desde un Scanner y devuelve un valor entero en el intervalo [lInferior..lSuperior] 
     * tal que Integer.MIN_VALUE<=lInferior y lSuperior<=Integer.MAX_VALUE.
     * @param tec Scanner para lectura desde teclado.
     * @param mensaje String para petición de valor.
     * @param lInferior int que indica el límite inferior del intervalo de lectura.
     * @param lSuperior int que indica el límite superior del intervalo de lectura.
     * @return int, entero leído en el intervalo [lInferior..lSuperior].
     */    
    public static int leerInt(Scanner tec,String mensaje, int lInferior, int lSuperior) {
        int res = 0;
        boolean hayError = true;
        do {
            try{
            System.out.print(mensaje);
            res = tec.nextInt(); 
            
            if ( res < lInferior || res > lSuperior )
                throw new IllegalArgumentException("Valor incorrecto");
            hayError = false;    
          }
          catch(InputMismatchException e){
             System.out.println("¡Asegúrate de introducir un entero válido! Inténtalo de nuevo ...");
              
          }
          catch(IllegalArgumentException e){
             System.out.println(e.getMessage());
              
          }
          finally {
              tec.nextLine(); 
        } 
       }while(hayError);
       return res;
    }  
    
}