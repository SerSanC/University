import java.util.*;

/**
 * Clase Hora. 
 * 
 *  @author (IIP. Grado en Informatica. ETSINF, UPV) 
 *  @version (Curso 2015-16)
 */
public class Hora {

    // ATRIBUTOS:
    private int h;
    private int m;

    // CONSTRUCTORES:
    /**
     *  Hora correspondiente a las hh horas y mm minutos.
     *  Precondicion: 0<=hh<24, 0<=mm<60.
     */
    public Hora(int hh, int mm){
       h = hh;
       m = mm;
    }
    
    /**
     * Hora (horas y minutos) actual UTC (tiempo coordinado universal).
     */
    
    public Hora(){
       int segundosDia = (int)( (System.currentTimeMillis() / 1000) % (24*60*60) );
       h = segundosDia / (60*60);
       m = (segundosDia/60) % 60;
       Calendar cal = Calendar.getInstance();
       h = cal.get( Calendar.HOUR_OF_DAY );
       m = cal.get( Calendar.MINUTE );
       System.out.printf( "Hora actual: %02d:%02d\n", h, m);
    }
    // CONSULTORES Y MODIFICADORES:
    /** Devuelve las horas de la Hora. */ 
    
    public int getHoras(){return h;}
    /** Devuelve los minutos de la Hora. */ 
   
    public int getMin(){return m;}
    /** Modifica las horas de la Hora. */ 
    public void setHora(int horanueva){h = horanueva;}
   
    /** Modifica los minutos de la Hora. */ 
    
    public void setMinutos(int minutosnuevos){m = minutosnuevos;}
    // OTROS METODOS:
    /** Devuelve la hora en formato "hh:mm".
     */
    public String toString(){String res = h +":"+ m;
     return res;}
   
    /** Devuelve true sii o es una Hora que coincide en horas
     *  y minutos con la Hora.  
     */
     public boolean equals (Object o){
         if (o instanceof Hora){
             Hora otro = (Hora)o;
             return this.h== otro.h
             && this.m== otro.m;
            } else return false;
        }
    /** Devuelve el numero de minutos transcurridos
     *  desde las 00:00 hasta la Hora.
     */
    public int Minutos(){
        return this.h * 60 + this.m;
    }
    /** Compara cronologicamente la Hora y otraHora. El resultado es un valor:
     *     - negativo si la Hora es anterior a otraHora,
     *     - cero si son iguales,
     *     - positivo si la Hora es posterior a otraHora.
     */
    public int CompareTo(Hora otraHora){
        return this.Minutos() - otraHora.Minutos();
    }

    // ACTIVIDAD EXTRA:
    /** Devuelve una Hora a partir de la descripcion textual en formato "hh:mm".
     */
    public static Hora valueOf(String hhmm){
        int hora = 10 * (hhmm.charAt(0) - '0') + (hhmm.charAt(1) - '0');
        int min = 10 * (hhmm.charAt(3) - '0') + (hhmm.charAt(4) - '0');
        Hora horanueva = new Hora (hora , min);
        return horanueva;
    }
}
