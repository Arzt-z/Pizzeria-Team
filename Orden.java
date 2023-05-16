import java.util.Scanner;
public class Orden extends Transaccion {
    private String cliente;
    private Pizza[] pizzas= new Pizza[50];
	private Inventario[] inventarios = new Inventario[50];
    private int cInventarios = 0;
    private int cPizzas = 0;
    private String nombre;

    public Orden() {
        this.nombre = nombre;
    }

    public Orden(String nombre) {
        this.nombre = nombre;
    }

    public String queSoy (){
        return "orden";
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


    public void modificar(int cInventarios, Inventario[] inventarios){
        Scanner leer= new Scanner(System.in);
        int opcion;
        char diferencia='c';
        do{
            System.out.println("Que deseas modificar?   1.-cliente   2.-Otros   0.-Cancelar");
            opcion=leer.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("nombre cliente:");
                    String entrada= leer.nextLine();
                    cliente=entrada;
                    break;
                case 2: 
                    super.modificar(cInventarios, inventarios, diferencia);
                    break;
                case 0:
                    return;
            }
        } while(true);
    }

    public void eliminar(){
        Scanner leer= new Scanner(System.in);
        char diferencia= 'c';
        System.out.println("Deseas eliminar un detalle o una orden entera?   1.-Detalle   2.-Orden");
        int eleccion= leer.nextInt();
        if(eleccion==1){
            super.eliminarDetalle(diferencia);
        }
        if(eleccion==2){
            super.eliminar(diferencia);
        }
    }

    public void capturar(Pizza[] pizzas, int cPizzas){
        Scanner datos = new Scanner(System.in);
        Cuadrado.imprimirCuadrado(50, 4, "------------ORDEN------------");
        Cuadrado.imprimirCuadrado(50, 4, "INGRESAR NOMBRE DEL CLIENTE");
        cliente = datos.nextLine();
        mostrar();
        

        int opcion;
        char diferencia= 'o';
        System.out.println("Ingresa los datos de la nueva compra");
        super.capturar(pizzas, cPizzas);
    }

    public boolean buscar(String cadenaAbuscar){
        if(super.buscar(cadenaAbuscar)==true){
            return true;
        }
        String datos=" "+ cliente;
        if(datos.contains(cadenaAbuscar)==true){
            return true;
        }else{
            return false;
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

    public String getCliente(){
        return cliente;
    }

    public void setCliente(String cliente){
        this.cliente= cliente;
    }


}
