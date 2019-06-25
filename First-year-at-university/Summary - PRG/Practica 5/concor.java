
import java.util.*;
import java.io.*;
public class concor
{ 
 public static void main(String[] args)throws Exception{
     boolean ord=false;
     //int i=0;
     String sep="[\\p{Space}\\p{Punct}\\p{Digit}¿¡]+";
     boolean cerrar=false;
     try{
     Scanner in=null;
    for(int i=0;i<args.length;i++){
        if(args[i].equals("-o")){ord=true;}
        else {in=new Scanner(new File(args[i]));
              cerrar= true;
            }
        }
     
     if(!cerrar) in=new Scanner(System.in);
     Concordancia t= new Concordancia(in,ord,sep);
     System.out.println(t);
     if (cerrar) in.close();
    }
    catch(FileNotFoundException e){System.out.println("Error Archivo");}


}


}
