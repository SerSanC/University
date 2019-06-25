/**
 * Clase Cuenta para representar una cuenta bancaria.
 * @author PRG 
 * @version Curso 2014/15
 */
public class Cuenta {

    private double saldo;
    private int numCuenta;

    /**
     * Constructor que, dados un número de cuenta y un saldo inicial, crea una cuenta. 
     * @param numCuenta int que indica el número de cuenta asociado a esta cuenta.
     *                  Debe ser un entero con 5 dígitos.
     * @param saldoInicial double que indica el saldo inicial de la cuenta.
     *                     Debe ser un valor real >=0.
     */
    public Cuenta(int numCuenta, double saldoInicial) {        
        this.numCuenta = numCuenta;
        saldo = saldoInicial;
    }

    /**
     * Permite ingresar dinero en la cuenta.
     * @param cantidad double que indica la cantidad a ingresar.
     *                 Debe ser un valor real >=0.
     */    
    public void ingresar(double cantidad) { 
        if ( cantidad>0 ){
            saldo += cantidad; }
        else System.out.printf("No es posible realizar la operacion");
    }

    /**
     * Permite retirar dinero de la cuenta.
     * @param cantidad double que indica la cantidad a retirar.
     *                 Debe ser un valor real >=0 y <=saldo.
     */ 
    public void retirar(double cantidad) { 
        if(saldo>0 && cantidad<=saldo){
            saldo -= cantidad; 
        }
        else 
            throw new IllegalArgumentException("ERROR: No dispone de tal cantidad.");
    }

    /**
     * Consultor del saldo actual de la cuenta.
     * @return double, el saldo actual.
     */
    public double getSaldo() { return saldo; }

    /**
     * Consultor del número de cuenta de la cuenta.
     * @return int, el número de cuenta.
     */
    public int getNumCuenta() { return numCuenta; }

    /**
     * Devuelve una String representando la cuenta en el formato siguiente, 
     * por ejemplo, 12345 100.52 donde 12345 es el número de cuenta y 
     * 100.52 es el saldo de la misma.
     * @return String.
     */
    public String toString() {
        return numCuenta + " " + saldo;
    }
}
