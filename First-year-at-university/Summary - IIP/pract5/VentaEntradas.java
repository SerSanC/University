
import java.util.Scanner;
import java.util.Locale;

/** Clase VentaEntradas.
 *  Practica 5 - IIP - ETSINF-UPV.
 *  
 *  @author
 *  @version Curso 2015/16
 */
public class VentaEntradas {
    public static void main(String [] args) {
        Scanner teclado = new Scanner(System.in).useLocale(Locale.US);
        
        // Lectura de los datos de la entrada
        System.out.println("Caracteristicas de la entrada: ");
        System.out.print("Titulo: ");
        String titulo = teclado.nextLine();
        System.out.print("Cine :");
        String cine = teclado.nextLine();
        System.out.print("Hora:");
        int hora = teclado.nextInt();
        System.out.print("Minutos:");
        int minutos = teclado.nextInt();
        
        
        // Creacion de la Entrada
        Entrada e = new Entrada(titulo, cine, hora, minutos);
    
        // Lectura de los datos para aplicar descuentos
        // variables a utilizar inicializadas por defecto a false:
        boolean diaEspec = false, festivo = false, 
                vispera = false, tCliente = false;
                
        System.out.print("Edad: ");
        int edad = teclado.nextInt(); teclado.nextLine();
        
        System.out.print("Es el dia del espectador? (SI/NO) "); 
        String res = teclado.next().toUpperCase(); 
        if (res.equals("SI")) { diaEspec = true; }
        
        /* A COMPLETAR: Lectura del RESTO de datos para aplicar DESCUENTOS */
        System.out.print("Es un dia festivo? (SI/NO) "); 
        String fest = teclado.next().toUpperCase(); 
        if (fest.equals("SI")) { festivo = true; }
        
        System.out.print("Es la vispera de un dia festivo? (SI/NO) "); 
        String visp = teclado.next().toUpperCase(); 
        if (visp.equals("SI")) { vispera = true; }
        
        System.out.print("Tiene tarjeta cliente? (SI/NO) "); 
        String Cliente = teclado.next().toUpperCase(); 
        if (Cliente.equals("SI")) { tCliente = true; }
        // Calculo del precio final de la Entrada e, 
        // invocando al metodo precioFinal
        double pFin = e.precioFinal(edad, diaEspec, festivo, vispera,tCliente);
                      
    
        // Mostrar por pantalla el precio final
        System.out.println("El precio final para la entrada es: " 
                           + String.format("%.2f", pFin) + " euros");
    }
}