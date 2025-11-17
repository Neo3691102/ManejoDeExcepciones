package com.ebac.modulo45;



public class ClaseExcepcionesRunTime {
    public static void main(String[] args) {
        char[] car = new char[2];
        car[0] = 'a';
        car[1] = 'b';

        try{
            car[2] = 'c';
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(car);
    }
}
