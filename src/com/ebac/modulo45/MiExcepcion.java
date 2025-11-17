package com.ebac.modulo45;

public class MiExcepcion extends Exception{

    public MiExcepcion(String message) {
        super("Ocurrio un error - " + message);
    }

    public MiExcepcion() {
        super("Ocurrio un error");
    }
}

class Miclasenegocio {
    public void calcularSuma(int a, int b) throws MiExcepcion {
        if(a < 10){
            throw new MiExcepcion("El numero a no puede ser menor a 10");
        }else{
            System.out.println("La suma es: " + (a + b));
        }
    }
}

class Contexto {
    public static void main(String[] args) {
        Miclasenegocio mcn = new Miclasenegocio();
        try{
            mcn.calcularSuma(3, 6);
        }catch(MiExcepcion e){
            System.out.println(e.getMessage());
        }
    }
}
