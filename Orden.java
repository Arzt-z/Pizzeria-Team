public class Orden {
    
    private Pizza[] pizzas= new Pizza[50];
	private Inventario[] inventarios = new Inventario[50];
    private int cInventarios = 0;
    private int cPizzas = 0;
    String nombre;

    public Orden() {
        this.nombre = nombre;
    }

    public Orden(String nombre) {
        this.nombre = nombre;
    }

    public void mostrar() {
        
        if(cPizzas+cInventarios>0){
            System.out.println(cPizzas+cInventarios+"");
            Cuadrado.imprimirCuadrado(50, 2 ,nombre);
            Cuadrado.matriz=Cuadrado.cuadrado(50, cPizzas+cInventarios+2);
            Cuadrado.centrarEnXYPresicion("Precio",37, 0);
            for(int i = 0; i < cPizzas; i++){
                Cuadrado.centrarEnXYPresicion(i + 1 + ".-"+pizzas[i].getNombre(),4,i+1);
                Cuadrado.centrarEnXYPresicion(""+pizzas[i].getPrecio(),37,i+1);
            }
            for(int i = cPizzas; i < cPizzas+cInventarios; i++){
                Cuadrado.centrarEnXYPresicion(i + 1 + ".-"+inventarios[i].getNombre(),4,i+1);
                Cuadrado.centrarEnXYPresicion(""+inventarios[i].getPrecio(),37,i+1);
            }
            Cuadrado.imprimirCuadrado();
        }
    }


    public void capturarInventario(Inventario inventarios) {
        System.out.println("add");
        this.inventarios[cInventarios++] = inventarios;
    }

    public void capturarPizza(Pizza pizzas) {
        System.out.println("add");
        this.pizzas[cPizzas++] = pizzas;
    }

}
