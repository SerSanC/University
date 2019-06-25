
public class PRGString
{ 

public static boolean esPrefijo(String a, String b){
if(a.length()==0){     //caso base
    return true;}
else if(a.length()>b.length()){    // caso general
    return false;}
else if(a.charAt(0)!=b.charAt(0)){
    return false;}
else return esPrefijo(a.substring(1), b.substring(1));
}

public static boolean esSubcadena(String a, String b){
if(a.length()>b.length()){    //caso base
    return false;}
else if (esPrefijo(a,b)==true){    //caso general
         return true;}
     else return esSubcadena(a, b.substring(1));
        

}

public static boolean esPalindromo(String a){

if (a.length()<=1){
   return true;}
else if (!Character.isLetter(a.charAt(0))){
      return esPalindromo(a.substring(1) );}
else if (!Character.isLetter(a.charAt(a.length()-1))){
      return esPalindromo(a.substring(0,a.length()-1));}
else if (a.charAt(0)!=a.charAt(a.length()-1)){
      return false;}
else return esPalindromo ( a.substring(1,a.length()-1));
   

}

}


