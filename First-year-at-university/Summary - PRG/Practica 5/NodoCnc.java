//import lineales.*;
import java.io.Serializable;

/**
 * clase NodoCnc
 * 
 * @author (PRG - DSIC - ETSINF, curs 2012-13) 
 * @version (curs 2012 - 2013)
 */
public class NodoCnc implements Serializable {
    String pal;
    ColaIntEnla numLins;
    NodoCnc siguiente;
    
    /** Constructor que permite crear un nodo con los datos asociados y 
     *  un nodo siguiente determinados
     *  @param pal String que contiene el nodo
     *  @param num int a encolar
     *  @param siguiente Referencia al siguiente nodo de la concordancia
     */
    NodoCnc(String pal, int num, NodoCnc siguiente) {
        this.pal = pal;
        this.numLins = new ColaIntEnla();
        this.numLins.encolar(num);
        this.siguiente = siguiente;
    }
    
    /** Constructor que permite crear un nodo con los datos asociados y 
     *  cuyo nodo siguiente es null
     *  @param pal String que contiene el nodo
     *  @param num int a encolar
     */
    NodoCnc(String pal, int num) {
        this(pal, num, null);
    }
    public String toString(){
        String res="";
        res+=String.format("%20s (%3d): ", pal,numLins.talla());
        res+=numLins+"\n";
        return res;
    }
}