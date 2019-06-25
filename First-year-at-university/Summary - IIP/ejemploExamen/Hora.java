/**
 * Clase Hora.
 * 
 *  @author (IIP - GII - ETSINF, UPV) 
 *  @version (Ejercicio1 - Turno 1 - Curso 2014-15)
 */
public class Hora {
    private int h;
    private int m;

   /**
    *  Hora correspondiente a las hor horas y min minutos.
    *  Precondicion: 0<=hor<24, 0<=min<60.
    */
    public Hora(int hor, int min) {
            this.h = hor;
            this.m = min;
        
    }
   
    /**
     * Hora (horas y minutos) actual UTC (tiempo coordinado universal).
     */
    public Hora() {   
        long t =  System.currentTimeMillis() % (24 * 3600 * 1000);
        this.h = (int) (t / (3600 * 1000));
        this.m = (int) (t % (3600 * 1000)) / (60 * 1000); 
    }
    
    /** Consulta las horas de la Hora */ 
    public int getHora() {
        return this.h;
    }

    /** Consulta los minutos de la Hora */ 
    public int getMin() {
        return this.m;
    } 
   
    /** Modifica las horas de la Hora */ 
    public void setHora(int hor) {
        this.h = hor;
    }
   
    /** Modifica los minutos de la Hora */ 
    public void setMin(int min) {
        this.m = min;
    }
   
    /** Devuelve la hora en formato "hh:mm". */
    public String toString() {
        String hh = "0" + this.h;
        hh = hh.substring(hh.length() - 2);
        String mm = "0" + this.m;
        mm = mm.substring(mm.length() - 2);
        return hh + ":" + mm;
    }
   
    /** Devuelve el numero de minutos transcurridos desde las 00:00 hasta la Hora */
    public int aMinutos() {
        return this.h * 60 + this.m;
    }
    
    /** Compara cronologicamente la Hora y hor. El resultado es un valor:
     *     - negativo si la Hora es anterior a hor,
     *     - cero si son iguales,
     *     - positivo si la Hora es posterior a hor.
     */
    public int compareTo(Hora hor) {
        return this.aMinutos() - hor.aMinutos(); 
    }

    /** Devuelve true sii o y la Hora son dos horas iguales. */
    public boolean equals(Object o) {
        return o instanceof Hora
               && this.h == ((Hora) o).h
               && this.m == ((Hora) o).m ;
    }
  
    /** Decrementa en 1 minuto la Hora */ 
    public void decrementar1Min() {
        if ( this.m == 0 && this.h == 0){ m=59; h=23;}
        else if(this.m == 0) { m=59; h--;}
        else this.m--;
        }  
    }

