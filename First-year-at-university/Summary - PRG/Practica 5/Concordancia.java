import java.util.*;
import java.io.*;
public class Concordancia implements Serializable
{
    private NodoCnc prim;
    private NodoCnc ultimo;
    private int talla;
    private boolean esOrd;
    private String separadores;
    
    
    //public void almacena(String fichero);
    
    private void insNoOrd(String pal,int numLin){
           NodoCnc temp= new NodoCnc(pal, numLin);
           
           if (ultimo==null){ prim=ultimo=temp;talla++;}
            else{
                NodoCnc aux=prim;
                while(aux!=null&&!aux.pal.equals(pal)) aux=aux.siguiente;
                if(aux==null){ ultimo.siguiente=temp; ultimo=ultimo.siguiente; talla++;}
                    else aux.numLins.encolar(numLin);
        
            }
        }
            
    private void insOrd(String pal, int numLin) {
            NodoCnc temp=new NodoCnc(pal,numLin);
            if(ultimo==null){prim=ultimo=temp;talla++;}
            else{
                NodoCnc aux=prim;
                NodoCnc ant=null;
                while((aux!=null)&&(aux.pal.compareTo(pal)<0)){ 
                    ant=aux;
                    aux=aux.siguiente;}
                if (aux==null){ultimo.siguiente=temp; ultimo=ultimo.siguiente; talla++;}
                else
                    if(aux.pal.equals(pal)){aux.numLins.encolar(numLin);}
                        else {ant.siguiente=temp;
                              temp.siguiente=aux;
                              talla++;
                            }
                  }
                        
            }
       
    
    public Concordancia(Scanner ent,boolean ord,String sep){
        prim=null;
        ultimo=null;
        talla=0;
        esOrd=ord;
        separadores=sep;
        int temp=1;
        while(ent.hasNext()){
            String one= ent.nextLine().trim();
            String[] res=one.split(sep);
            for(int i=0;i<res.length; i++){
            if(ord) insOrd(res[i],temp);
            else insNoOrd(res[i],temp);
        }
           temp++;
        }
        
        }
            
            
    
    public Concordancia(String str,boolean ord,String sep){
        this(new Scanner(str),ord,sep);
        
        
    }
    
    public int talla(){return talla;}
    
    public boolean esOrdenada(){return esOrd;}
    
    public String toString(){
        String res="";
        NodoCnc aux=prim;
        while(aux!=null){
            res+=aux;
            aux=aux.siguiente;
        }
        return res;
    }
}
