 public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Suma total de billetes vendidos
    private int totalBilletesVendidos;
    //M�quina con premios
    private boolean premio;
    /**
     * Crea una m�quina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean premioGanado) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        totalBilletesVendidos = 0;
        premio = premioGanado;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
        }
        else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
        }        
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = (precioBillete - balanceClienteActual);
        if (cantidadDeDineroQueFalta <= 0) {        
            // Simula la impresion de un billete
            System.out.println("##################");
            System.out.println("# Billete de tren:");
            System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
            System.out.println("# " + precioBillete + " euros.");
            System.out.println("##################");
            System.out.println();         
    
            // Actualiza el total de dinero acumulado en la maquina
            totalDineroAcumulado = totalDineroAcumulado + precioBillete;
            // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
            balanceClienteActual = balanceClienteActual - precioBillete;
            //Conador billetes
            totalBilletesVendidos = totalBilletesVendidos + 1;
            if (premio == true) {
                double
                descuentoPremio = 0.10;
                double
                descuentoTotal = 0;
                descuentoTotal = ((precioBillete * descuentoPremio)/100);  }
        }
        else {
            System.out.println("Tienes que introducir " + (cantidadDeDineroQueFalta) + " euros mas!");
              
        }
    }
    
    /**
     * Vac�a todo el dinero que quede en la m�quina
     */
    
    public int vaciarDineroDeLaMaquina() {
        int valorADevolver = totalDineroAcumulado;
        if (balanceClienteActual == 0) {
            totalDineroAcumulado = 0;
        } else {
            valorADevolver = -1;
            System.out.println("No se puede vaciar la m�quina con una operaci�n en curso");
        }
        return valorADevolver;
    }
    
    /** 
    /Imprime por pantalla el n�mero de billetes vendidos desde la 
     * puesta en funcionamiento de la m�quina.
     */
    public void imprimeNumeroBilletesVendidos() {
        System.out.println("# N� de billetes vendidos: " + totalBilletesVendidos);
    }
    
     /**
     * Devuelve el n�mero de billetes vendidos desde la puesta en 
     * funcionanmiento de la m�quina.
     */
    public int getNumeroBilletesVendidos() {
        return totalBilletesVendidos;
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    }
}