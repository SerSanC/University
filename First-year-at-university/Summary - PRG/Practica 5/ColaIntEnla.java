
import java.util.*;
public class ColaIntEnla
{ 
    private int talla;
    private NodoInt primero;
    private NodoInt ultimo;

    public ColaIntEnla(){
        talla=0;
        primero=null;
        ultimo=null;
    }
    public void encolar(int x){
        
        NodoInt nuevo = new NodoInt(x);
        if (ultimo!=null) ultimo.siguiente = nuevo;
        else primero = nuevo;
        ultimo = nuevo;
        talla++;
    }
    public int desencolar () {
        int x = primero.dato;
        primero = primero.siguiente;
        if (primero==null) ultimo = null;
        talla--;
        return x;
    }
    public int primero(){return primero.dato;}
    
    public boolean vacia(){return talla==0;}
     
    public int talla(){return talla;}
    
    public String toString(){
        String res="";
        NodoInt aux=primero;
        while(aux!=null)
        {res+=aux.dato+" ";aux=aux.siguiente;}
        return res;
    }
    
}


