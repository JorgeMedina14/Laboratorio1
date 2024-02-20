import java.util.Scanner;

public class Main {
    private Nodo<Integer> cabeza;
    private int tamanio;
    private Scanner scanner;

    public Main() {
        cabeza = null;
        tamanio = 0;
        scanner = new Scanner(System.in);
    }
    public static void main(String[] args) {
        Main programa = new Main();

        while (true) {
            programa.Menu();
            if (!programa.scanner.hasNextInt()) {
                programa.scanner.next();
            }
        }
    }


    public void Menu(){
        System.out.println("\n--- Menú ---");
        System.out.println("1. Insertar al Inicio");
        System.out.println("2. Insertar al Final");
        System.out.println("3. Recorrer la lista");
        System.out.println("4. Buscar un Elemento");
        System.out.println("5. Borrar un Elemento");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");

        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                System.out.print("Ingrese el elemento a insertar al inicio: ");
                int elementoInicio = scanner.nextInt();
                insertarAlInicio(elementoInicio);
                break;
            case 2:
                System.out.print("Ingrese el elemento a insertar al final: ");
                int elementoFinal = scanner.nextInt();
                insertarAlFinal(elementoFinal);
                break;
            case 3:
                recorrer();
                break;
            case 4:
                System.out.print("Ingrese el elemento a buscar: ");
                int elementoBuscar = scanner.nextInt();
                int posicion = buscarElemento(elementoBuscar);
                if (posicion != -1) {
                    System.out.println("El elemento " + elementoBuscar + " se encuentra en la posición " + posicion + ".");
                } else {
                    System.out.println("El elemento " + elementoBuscar + " no se encuentra en la lista.");
                }
                break;
            case 5:
                System.out.print("Ingrese la posición del elemento a borrar: ");
                int posicionBorrar = scanner.nextInt();
                borrarElemento(posicionBorrar);
                break;
            case 6:
                System.out.println("Saliendo del programa...");
                System.exit(0);
            default:
                System.out.println("Opción inválida.");
        }
    }
    public void insertarAlInicio(int item){
        Nodo<Integer> nodoNuevo = new Nodo<>(item);
        nodoNuevo.next = cabeza;
        cabeza = nodoNuevo;
        tamanio++;
    }
    public void insertarAlFinal(int item){
        Nodo<Integer> nuevoNodo = new Nodo<>(item);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<Integer> nodoActual = cabeza;
            while (nodoActual.next != null) {
                nodoActual = nodoActual.next;
            }
            nodoActual.next = nuevoNodo;
        }
        tamanio++;
    }
    public void recorrer(){
        if(cabeza == null){
            System.out.println("La lista no contiene nada.");
            return;
        }
        System.out.println("Elementos de la lista: ");
        Nodo<Integer> nodoactual = cabeza;
        while (nodoactual != null){
            System.out.println(nodoactual.item);
            nodoactual = nodoactual.next;
        }
    }
    public int buscarElemento(int item){
        if(cabeza == null){
            return -1;
        }
        int posicion = 0;
        Nodo<Integer> nodoactual = cabeza;
        while(nodoactual != null && nodoactual.item != item){
            nodoactual = nodoactual.next;
            posicion++;
        }
        if(nodoactual ==null){
            return -1;
        }else{
            return posicion;
        }
    }
    public void borrarElemento(int posicion){
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        if (posicion < 0 || posicion >= tamanio) {
            System.out.println("Posición inválida.");
            return;
        }

        if (posicion == 0) {
            cabeza = cabeza.next;
        } else {
            Nodo<Integer> anterior = null;
            Nodo<Integer> actual = cabeza;
            for (int i = 0; i < posicion; i++) {
                anterior = actual;
                actual = actual.next;
            }
            anterior.next = actual.next;
        }
        tamanio--;
    }
    }
     class Nodo<T>{
        T item;
        Nodo<T> next;
        public Nodo(T item) {
            this.item = item;
            this.next = null;
        }
        }

