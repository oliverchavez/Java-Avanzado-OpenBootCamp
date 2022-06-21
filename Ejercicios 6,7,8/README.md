# Ejercicios sesiones 6, 7 y 8:

**Identifica las características principales de los patrones de diseño más conocidos, indica para qué valen y un caso de uso para cada uno de ellos.**

- **Singleton**
Se utiliza cuando solamente puede haber una instancia de una clase, es decir , utilizando este patrón se evita que exista más de una instancia.  
Un caso en donde se utiliza es cuando accedemos a bases de datos, creamos un manejador de bases de datos utilizando el patrón singleton y así no se creará una nueva instancia cada que se haga uso de la base de datos.

- **Factory**
Sirve para crear una jerarquía de clases y utilizar una u otra de forma transparente. Consiste en utilizar una clase constructora (Factory) dedicada a la construcción de objetos de un subtipo de un tipo determinado.  
Un ejemplo sería, un traductor del cual tenemos distintos tipos de subclases dependiendo del idioma, el patrón se utilizaría al pasar como parámetro el idioma y que la clase Factory decida que subclase se debe crear.

- **Builder**
Se utiliza cuando tenemos objetos complejos, es decir, con muchos atributos. Nos permite crear los objetos paso a paso en vez de tener un constructor con muchos parámetros y también evita el uso de muchos setters.  
Un caso en donde se utiliza es cuando tenemos una clase con muchos atributos y sólo algunos de estos son obligatorios para crear un objeto y el resto son opcionales. Al utilzar builder evitamos tener que definir múltiples constructores.

- **Prototype**
Se usa cuando tenemos una instancia de la clase (prototipo) y nos gustaría crear nuevos objetos clonando la instancia ya existente.  
Este patrón se utiliza cuando:
	- La creación de nuevos objetos acarrea un coste computacional elevado..
	- Los objetos a crear tienen o suelen tener atributos que repiten su valor.  


- **Decorator**
Se utiliza para añadir una funcionalidad a una clase que ya existe sin modificar esa clase. De esta forma, si creamos nuevas clases que necesitan esa funcionalidad pero además aportan nuevas características, podremos usar el patrón Decorator para poder usar cualquiera de las clases de manera individual o cualquier combinación de ellas y sus funcionalidades.  
Un caso de uso es si tenemos un sistema que utiliza notificaciones, podemos añadirle funcionalidades adicionales como notificaciones por SMS, Slack, Correo, etc. De esta manera podemos utilizar el patrón Decoratos para no modificar la clase notificación original y añadirle una o alguna combinación de las funcionalidades mencionadas.

- **Adapter**
Permite que clases con una misma implementación y otras clases con distinta implemementación, funcionen
de manera coherente, adaptando los métodos de las clases que implementan cierta interfaz con los métodos
de otras clases que no la implementan.  
Se utiliza cuando se desea usar una clase existente, pero su interfaz no es igual a la necesitada.

- **Facade**
Se utiliza para ocultar lo complejo por detrás.  
Un ejemplo en donde se puede utilizar es un sistema que permite realizar pagos en línea, para lo cual es necesario interactuar con varios sistemas o cuales conllevan una cierta complejidad, por lo que interactuar con todos los subsistemas puede ser muy complicado. Por lo cual se implementará una fachada que permita exponer operaciones de alto nivel, las cuales se encarguen de interactuar con los subsistemas y abstrae a los programadores de la complejidad de interactuar con dichos sistemas.
---

**Crea una pequeña aplicación implementando el patrón Singlenton y demuestra que, efectivamente, no crea instancias nuevas.**  
El ejemplo consiste en un sistema gestor de base de datos (SGBD) del cual sólo puede haber una instancia.

```java
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
```

Se llamará dos veces al método `connect()` para verificar que no se crea una nueva instancia.
```java
public class Main {
    public static void main(String[] args) {
        SGBD sistema1 = SGBD.getInstance();
        SGBD sistema2 = SGBD.getInstance();
        sistema1.connect();
        sistema2.connect();
        System.out.println(sistema1 + " " + sistema2); // Misma zona de memoria
    }
}
```