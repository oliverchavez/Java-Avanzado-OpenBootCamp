package com.openbootcamp.ejemplosingleton;

public class Main {
    public static void main(String[] args) {
        SGBD sistema1 = SGBD.getInstance();
        SGBD sistema2 = SGBD.getInstance();
        sistema1.connect();
        sistema2.connect();
        System.out.println(sistema1 + " " + sistema2); // Misma zona de memoria
    }
}
