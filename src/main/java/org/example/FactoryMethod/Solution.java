package org.example.FactoryMethod;

public class Solution {
    public static void main(String[] args) {

       Transport transport = new CarsPlant().createTransport();
       System.out.println(transport.getClass());

       Transport transport1 = new MotorcyclesPlant().createTransport();
       System.out.println(transport1.getClass());

    }
}
