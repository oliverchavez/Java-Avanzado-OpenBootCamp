package com.openbootcamp.ejemplosingleton;

public class SGBD {

    private static SGBD sgbd;
    boolean isConnected = false;

    private SGBD() {
    }

    public static SGBD getInstance() {
        if (sgbd == null) {
            sgbd = new SGBD();
        }
        return sgbd;
    }

    public void connect() {
        if (!isConnected) {
            isConnected = true;
            System.out.println("Realizando conexión con la base de datos...");
        } else {
            System.out.println("Ya estaba conectado con la base de datos!");
        }
    }
}
