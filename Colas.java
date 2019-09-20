/*
Realizado por: Castillo Guzman Carlos Emilio  || 18/09/2019
Matricula: 61729
 */
import java.util.LinkedList;
import java.util.Scanner;

public class Colas {

    /* Creamos los objetos y hacemos llamar al metodo menu */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        LinkedList cola = new LinkedList<>();
        menu(entrada,cola);
    }
    /*Mostramos el menu con las opcciones y un switch con un captura de excepccion en caso de que el usuario
    digite algo que no es debido*/ 
    public static void menu(Scanner entrada, LinkedList cola){        
        try {
            System.out.println("1.- Insterta en la cola");
            System.out.println("2.- Recuperar un objeto de la cola");
            System.out.println("3.- Obtener el primer elemento");
            System.out.println("4.- Cola vacia?");
            System.out.println("5.- Cantidad de elementos en la cola");

            System.out.println("Ingrese una opccion:");
            int opc = entrada.nextInt();

            switch (opc){
                case 1:
                insertarCola(entrada,cola);
                break;
                case 2:
                recuperarCola(entrada,cola);
                break;
                case 3:
                primerElementoCola(entrada, cola);
                break;
                case 4:
                vaciaCola(entrada, cola);
                break;
                case 5:
                cantidadCola(entrada,cola);
                break;
            }

        }catch (Exception e) {
            System.out.println("Ingrese una respuesta valida");
        }
    }
    /* Pedimos que ingrese un valor y le preguntamos si desea ingresar otro valor usando un do-while y llendo 
    agregando estos valores en la pila
    */
    public static void insertarCola(Scanner entrada, LinkedList cola){
        int sn;
        do {
            System.out.println("Ingrese un valor:");
            String dato = entrada.next();
            cola.add(dato);
            System.out.println("Desea ingresar otro dato? \n 1. Si \n 2. No");
            sn = entrada.nextInt();
        } while (sn != 2);
        cls();
        menu(entrada,cola);
    }
    /* Le pedimos al usuario buscar un valor en la cola y si este existe se lo notificamos y en caso contrario
    le decimos que no se ha encontrado o no existe */
    public static void recuperarCola(Scanner entrada, LinkedList cola){
        System.out.println("Digite una valor a buscar:");
        String valor = entrada.next();
        boolean esta = cola.contains(valor);
        if(esta == true){
            System.out.println("El valor " + valor + " se ha encontrado en la cola");
        }else{
            System.out.println("El valor " + valor + " no se ha encontrado y/o no existe en la cola");
        }
        cls();
        menu(entrada, cola);
    }

    /* Usamos una condicional para decil que en la cola con el atributo peek es igual a null es decir que no hay nada
    le notificamos al usuario que no hay elemento en la cola y en caso contrario le decimos cual es el primero elemento
    en la cola*/
    public static void primerElementoCola(Scanner entrada, LinkedList cola){
        if(cola.peek() == null){
            System.out.println("No hay elementos en la cola");
        }else{
            System.out.println("El primero elemento en la cola es: " + cola.peek());
        }
        cls();
        menu(entrada, cola);
    }

    /*Usamos un condicional y usamos el size para saber cuantos elemetos hay en la cola en caso de ser 0 le notificamos
    al usuario que la cola esta vacia y en caso contrario reciclamos codigo llamando al metodo cantidadCola que nos
    mostrara la cantidad de elemetos en la cola*/
    public static void vaciaCola(Scanner entrada, LinkedList cola){
        if(cola.size() == 0){
            System.out.println("La cola esta vacia");
        }else{
            cantidadCola(entrada, cola);
        }
        cls();
        menu(entrada, cola);
    }

    /*Mostramos al usuario cuantos elementos en la cola hay*/
    public static void cantidadCola(Scanner entrada, LinkedList cola){
        System.out.println("En la cola hay: " + cola.size() + " elementos");
        cls();
        menu(entrada, cola);
    }

    /* Metodo Extra: Usamos este metodo para esperar al usuario al oprimir una tecla y borramos lo anterior para
    tener una consola mas limpia y estica para el usuario*/
    public static void cls() {
        System.out.println("Presiona alguna tecla para continuar...");
        try {
            System.in.read();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();            
        } catch (Exception e) {

        }

    }

}
