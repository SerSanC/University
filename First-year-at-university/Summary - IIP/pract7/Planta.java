/** Clase Planta: representa un conjunto de plazas de parking en una planta 
  * de un parking.
  * @author IIP
  * @version Curso 2015/2016
  */
public class Planta {
  
    // ATRIBUTOS
    private Plaza plazas[];
    
    private int planta;
    private int plazasLibres;
    /** Constructor que crea una Planta dados un numero de planta y un numero 
      * de plazas por planta.
      * La planta, al comienzo, esta vacia.
      * @param numPlanta int numero de planta, numPlanta >= 0.
      * @param numPlazas int numero de plazas por planta, numPlazas > 0.
      */
    public Planta(int numPlanta , int numPlazas){
      plazas = new Plaza[numPlazas];
      planta = numPlanta;
      plazasLibres = numPlazas;
      for (int i = 0; i < numPlazas; i++){
        plazas[i] = new Plaza(planta, i);
        }
      
    }

    /** Devuelve el numero de planta.
      * @return int numero de planta del parking.
      */
    public int getPlanta(){return planta;}
  
    /** Devuelve el numero de plazas libres.
      * @return int numero de plazas de la planta.
      */
    public int getPlazasLibres(){return plazasLibres;}

    /** Devuelve si la planta esta llena.
      * @return boolean planta llena (sin plazas libres).
      */
    public boolean estaLlena(){
     return (plazasLibres == 0);
    }

    /** Devuelve la primera plaza libre en la planta, o 
      * -1 si no hay plazas libres. 
      * @return int, indice de la primera plaza libre en la planta o 
      * -1 si no hay plazas libres.
      */

    // ==== Emplea Plaza.esVacia() ====
    public int primeraLibre(){
        for(int i = 0 ; i < plazas.length ; i++){
         if (plazas[i].esVacia()){return i;}
        }
        return -1;
    }
    /** Entra un coche en la planta y devuelve su plaza, o 
      * devuelve null cuando no hay plazas libres.
      * Precondicion: el coche no esta en la planta.
      * @param m String matricula del coche.
      * @param h Hora hora de entrada del coche.
      * @return Plaza si el coche entra o null en caso contrario.
      */
    public Plaza entrarCoche(String m, Hora h){
       if (estaLlena() == true){return null;}
       else{
            int pos = primeraLibre();
            plazas[pos].entrarCoche(m,h);
            plazasLibres--;
            return plazas[pos];
        }
    }
  
    // ==== Emplea estaLlena() y Plaza.entrarCoche(String, Hora) ====

    /** Comprueba si un coche dado esta en la planta.
      * @param m String matricula del coche a buscar.
      * @return Plaza, la plaza que ocupa el coche, si se encuentra, 
      * o null si no se encuentra.
      */
    public Plaza buscarCoche(String m){
       for (int i = 0 ; i < plazas.length ; i++){
           if (!plazas[i].esVacia() && m.equals(plazas[i].getMatricula())){
            return plazas[i];
            }
        }
       return null;
    }
    // ==== Emplea Plaza.esVacia() y Plaza.getMatricula() ====

    /** Saca el coche del parking, devolviendo cuantos minutos ha estado.
      * @param m String matricula del coche. Precondicion: siempre esta.
      * @param h Hora hora de salida. 
      *   Precondicion: posterior a la hora de entrada del coche.
      * @return int, numero de minutos que el coche ha estado en el parking.
      */
    public int salirCoche(String m , Hora h){
     Plaza plaz = buscarCoche(m);
     int p = plaz.getHoraEntrada().aMinutos();
     int hor = h.aMinutos();
     plaz.salirCoche();
     plazasLibres++;
     return hor - p;  
     }
    
     /** Vacia toda la planta y devuelve el numero total de minutos 
      * que los coches han permanecido 
      * en la planta hasta una hora dada.
      * @param h Hora hora en la que todos los coches deben salir. 
      *   Precondicion: posterior a la hora de entrada.
      * @return int, numero total de minutos transcurridos.
      */
    public int vaciarPlanta(Hora horaSalida){
     // ==== Emplea Hora.aMinutos(), Plaza.esVacia(), Plaza.getHoraEntrada() 
     //      y Plaza.salirCoche() ====
     int sum = 0;
     for (int i = 0; i < plazas.length; i++){
        if (!plazas[i].esVacia()){
          sum += horaSalida.aMinutos() - plazas[i].getHoraEntrada().aMinutos();
          plazas[i].salirCoche();
          plazasLibres++;
        }
     }
     return sum;
    }
    
    /** Devuelve un String con la ocupacion del parking, con 'X' ocupada, 
      * ' ' libre. <br>
      * Formato: <pre> planta (ocupando 3 posiciones), espacio, ocupacion 
      * ("  X" o "   "), espacio, ..., ocupacion ("  X" o "   "), 
      * espacio, '\n'</pre>
      * Ejemplo de formato (5 plazas): <pre> "  2   X       X   X      " </pre>
      * @return String, representacion de la ocupacion de la planta.
      */

    // ==== Emplea Plaza.esVacia() ====
    public String toString(){
     String res = String.format("%3d ", planta);
     for (int i = 0; i < plazas.length; i++){
       if(plazas[i].esVacia()) {res += "    ";}
       else{res += "  X ";}
     }
     res += "\n";
     return res;
    }
}
