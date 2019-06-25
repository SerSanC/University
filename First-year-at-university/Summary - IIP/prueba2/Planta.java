/** Clase Planta: representa un conjunto de plazas de parking en una planta 
  * de un parking.
  * Clase simplificada con la funcionalidad minima para el examen
  * @author IIP
  * @version Segunda prueba Lab - Curso 2015/2016
  */
public class Planta {
    private Plaza[] plazas;
    private int plazasLibres;
    private int planta;

    /** Constructor que crea una Planta dados un numero de planta y un numero 
      * de plazas por planta.
      * La planta, al comienzo, esta vacia.
      * @param numPlanta int numero de planta, numPlanta >= 0.
      * @param numPlazas int numero de plazas por planta, numPlazas > 0.
      */
    public Planta(int numPlanta, int numPlazas) {
        plazas = new Plaza[numPlazas];
        plazasLibres = numPlazas;
        planta = numPlanta;
        for (int i = 0; i < numPlazas; i++) {
            plazas[i] = new Plaza(planta, i);
        }
    }

    /** Ejercicio practica 7 - turno 3 */
    public double tiempoMedioOcupacion(Hora actual) {
        double res = 0;
        double n = 0;
        if (plazasLibres == plazas.length) return -1;
        else {
          double hora = actual.aMinutos();
          for (int i = 0 ; i<plazas.length; i++){
              if(plazas[i].esVacia() == false){
                res += hora - plazas[i].getHoraEntrada().aMinutos();
                n++;
            }
            }
            return res/n;
        }
    }
    
}
