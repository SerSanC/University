import java.util.Scanner;
import java.util.Locale;
/** Clase GestorParking: gestor de un parking.
  * 
  * @author IIP
  * @version Curso 2015/2016
  */
public class GestorParking {
    /**
     * Muestra un menu de opciones por pantalla y
     * lee desde teclado una opcion valida.
     * @param tec Scanner que representa el teclado.
     * @return int, opcion valida.
     */ 
    public static void menu(){
     System.out.println("Seleccione un comando:");
     System.out.println(" " + "Entrada de vehículo  (1)");
     System.out.println(" " + "Salida de vehículo   (2)");
     System.out.println(" " + "Buscar vehículo      (3)");
     System.out.println(" " + "Mostrar ocupación    (4)");
     System.out.println(" " + "Vaciar parking       (5)");
     System.out.println(" " + "Finalizar aplicación (6)");
     System.out.println("");
    }
  
    /**
     * Lectura desde teclado de una hora valida.
     * @param tec Scanner que representa el teclado.
     * @return Hora, hora valida.
     */
    public static Hora lecturaHora(){
     Scanner tec = new Scanner(System.in).useLocale(Locale.US);
     System.out.print("Introduce la hora: ");
     int h = tec.nextInt();
     System.out.print("Introduce los minutos: ");
     int m = tec.nextInt();
     System.out.println("");
     Hora t = new Hora(h,m);
     return t;
    }

    /**
     * Metodo principal.
     * @param args String[].  
     * @throws Exception si ocurre algun error de entrada/salida.
     */
    public static void main(String [] args) throws Exception {
     String m;
     Plaza f;
     Hora e, s;
     int p;
     Scanner teclado = new Scanner(System.in).useLocale(Locale.US);
     Parking P = new Parking(4,20,0.5);
     menu();
     for(int i=1; i!=0;){ 
      int x = teclado.nextInt();
      System.out.println("");
	  if (x>0 && x<6){
       if (x==1){
        System.out.print("Introduce la matrícula: ");
        m = teclado.next();
        System.out.println("");
        f = P.buscarCoche(m);
        if (f != null) System.out.println("El vehículo ya se encuentra en el parking");
        else{
         e = lecturaHora();
         System.out.print("Introduce el número de planta: ");
         p = teclado.nextInt();
         System.out.println("");
         System.out.println(P.entrarCoche(m,e,p));
        }
        System.out.println("");
       }
       if (x==2){
        System.out.print("Introduce la matrícula: ");
        m = teclado.next();
        System.out.println("");
        f = P.buscarCoche(m);
        if (f == null) System.out.println("El vehículo no se encuentra en el parking");
        else{
         s = lecturaHora();
         while (P.buscarCoche(m).getHoraEntrada().aMinutos() > s.aMinutos()){
          System.out.println("Hora de salida no válida, intentelo de nuevo");
          System.out.println("");
          s=lecturaHora();
         }
         System.out.println("El vehiculo de matrícula "+m+" ha salido del parking a las "+s+
         " con un coste de "+P.salirCoche(m,s)+" euros");
        }
        System.out.println("");
       }
       if (x==3){
        System.out.print("Introduce la matrícula: ");
        m = teclado.next();
        System.out.println("");
        f = P.buscarCoche(m);
        if (f == null) System.out.println("El vehículo no se encuentra en el parking");
        else{
         System.out.println(P.buscarCoche(m));
        }
        System.out.println("");
       }
       if (x==4){
        System.out.println(P.toString());
        System.out.println("");
       }
       if (x==5){
        System.out.print("Se vacía el parking al completo con un coste total de: ");
        System.out.print(P.vaciarParking());
        System.out.println(" euros");
        System.out.println("");
       }
       menu();
      }
      else {
       if (x==6) {
        i= 0;
        System.out.print("Programa finalizado, hasta otra");
       } 
       else System.out.println("Comando no reconocido");
      }
     
     }
    }
}
