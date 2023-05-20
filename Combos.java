import java.util.Scanner;
public class Combos {
    private String nombre;
    private float precio;
    private Pizza[] pizzas = new Pizza[5];
    private Inventario[] inventarios = new Inventario[7];
    private boolean existencia;
    private int cPizzas;
    private int cInventarios;

    public Combos() {
        existencia = true;
    }

    public Combos(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
        existencia = true;
        cPizzas = 0;
        cInventarios = 0;
    }

    public String toString() {
        return "combo :" + nombre + " precio: " + precio;
    }

    public void mostrar() {
        System.out.println("nombre del combo:  " + nombre);
        System.out.println("precio:  " + precio);
        System.out.println("contenido del combo:");
        for (int i = 0; i < cPizzas; i++) {
            if (pizzas[i].getExistencia() == true) {
                System.out.println(pizzas[i]);
            }
        }
        System.out.println("");
        for (int i = 0; i < cInventarios; i++) {
            if (inventarios[i].getExistencia() == true) {
                System.out.println(inventarios[i]);
            }
        }
    }

    public void capturar(){
        Scanner leer = new Scanner (System.in);
        System.out.print("nombre del combo:   "); nombre=leer.nextLine();
        System.out.print("precio del combo:   "); precio=leer.nextFloat();
    }

    public void agrgarPizzas(){
     
    }

    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getPrecio() {
        return precio;
    }
}
