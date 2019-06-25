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
    
    public Hora(int hh , int mm){
        h=hh;
        m=mm;
    }
   
    /**
     * Hora (horas y minutos) actual UTC (tiempo coordinado universal).
     */
    
    public Hora(){
        int tRestante = (int) (System.currentTimeMillis() % (24 * 3600 * 1000));
        int hors = tRestante/3600000;
        int horsRest = tRestante%3600000;
        int mins = horsRest/60000;
        h=hors;
        m=mins;
    }
    
    // CONSULTORES Y MODIFICADORES:
    /** Devuelve las horas de la Hora. */ 
    
    public int getHora(){return h;}

    /** Devuelve los minutos de la Hora. */ 
    
    public int getMin(){return m;}
   
    /** Modifica las horas de la Hora. */ 
    
    public void setHora(int nh){h=nh;}
   
    /** Modifica los minutos de la Hora. */ 
    
    public void setMin(int nm){m=nm;}
   
    // OTROS METODOS:
    /** Devuelve la hora en formato "hh:mm".
     */
    
    public String toString(){
        String hor1 = "0" + this.h;
        String hora1 = hor1.substring(hor1.length()-2);
        String min1 = "0" + this.m;
        String minu1 = min1.substring(min1.length()-2);
        String res = hora1 + ":" + minu1;
        return res;
    }
   
    /** Devuelve true sii o es una Hora que coincide en horas
     *  y minutos con la Hora.  
     */
    public boolean equals(Object o){
        if (o instanceof Hora){
          Hora otra = (Hora)o;
          return this.h==otra.h
                  && this.m==otra.m;}
         else return false;         
    }
      
    /** Devuelve el numero de minutos transcurridos
     *  desde las 00:00 hasta la Hora.
     */
    public int aMinutos(){
        return h*60+m;
    }
    
    /** Compara cronologicamente la Hora y otraHora. El resultado es un valor:
     *     - negativo si la Hora es anterior a otraHora,
     *     - cero si son iguales,
     *     - positivo si la Hora es posterior a otraHora.
     */
    public int compareTo(Hora otraHora){
        return this.aMinutos() - otraHora.aMinutos();
    }

    // ACTIVIDAD EXTRA:
    /** Devuelve una Hora a partir de la descripcion textual en formato "hh:mm".
     */
    public static Hora valueOf(String hhmm){
        int hora = 10*(hhmm.charAt(0) - '0') + (hhmm.charAt(1) - '0');
        int minuto = 10*(hhmm.charAt(3) - '0') + (hhmm.charAt(4) - '0');
        Hora hor = new Hora(hora,minuto);
        return hor;
    }
  
}
