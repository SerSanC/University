/**
 * La clase IIPMath implementa algunas operaciones matematicas:
 * IIPMath.sqrt(double) e IIPMath.log(double).
 *
 * @author ()
 * @version ()
 */
public class IIPMath {
    
    // A COMPLETAR
    public final static double LOG_2 = 0.6931471805599453 ;
        
    /**
     * Devuelve la raiz cuadrada de x >= 0, con error epsilon > 0. 
     * A COMPLETAR COMENTARIO
     */
    public static double sqrt(double x, double epsilon) {
        // A COMPLETAR
        double t = (1+x)/2 ; 
        double ta = 1;
        double e = Math.abs(t-ta);
        while (e>=epsilon){
         ta = t;
         t = (ta+(x/ta))/2;
         e = ta-t;
        }
        return t;
    }            

    /**
     * Devuelve la raiz cuadrada de x >= 0 con error 1e-15. 
     * A COMPLETAR COMENTARIO
     */
    public static double sqrt(double x) {    
        // A COMPLETAR
        return sqrt(x, 1e-15);
        
    }  
                    
    /* ******************************************************** */
    /* ******************************************************** */
    /* ******************************************************** */
                
    /**
     * Devuelve log(z), 1/2 <= z < 1, con error epsilon > 0.
     * A COMPLETAR COMENTARIO
     */
    public static double logBase(double z, double epsilon) {
        // A COMPLETAR
        double y = (1-z)/(1+z);
        double suma = y;
        double k = 1;
        double u = y;
        while(u > epsilon){
          u = (y*y) * ((2*k - 1)/(2*k + 1)) * u;
          suma = suma + u;
          k++;
        }
        return suma * -2;
    }
            
    /**
     * Devuelve log(x), x > 0, con error epsilon > 0.
     * A COMPLETAR COMENTARIO
     */
    public static double log(double x, double epsilon) {
        // A COMPLETAR  
       int m = 0;
       double z = x;
        if (x>=1){
        do{
            z = z/2;
            m++;
        }while (z >= 1 );
        return m*LOG_2 + logBase(z,epsilon);
       }else if (x <= 0.5){
        do{
            z = z*2;
            m++;
        }while(z <= 0.5);
        return -m * LOG_2 + logBase(z, epsilon);
       }else{
        return logBase(x, epsilon);
       }
    } 
    /**
     * Devuelve log(x), x > 0, con error 1e-15.
     * A COMPLETAR COMENTARIO
     */
    public static double log(double x) {    
        // A COMPLETAR
        return log(x, 1e-15);                 
    }
    public static double termNSqrt (double x, int n){
        
        double t = (1+x)/2 ; 
        double ta = 1;
        for (int i= 1; i<n; i++){
        if(x>0){
            ta = t;
            t = (ta+(x/ta))/2;
         
        }
      }
        return t;
        
       
    }
}