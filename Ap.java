import java.util.Scanner;
public class Ap{
	public static void main (String[] args){
		Pizzeria pizzafactory = new Pizzeria("Pizza Factory", "Av. Lic. Enrique Ramírez Miguel, Las Américas", "PizzaFactory@Pizza.com", 7002200 , "445697234");
		pizzafactory.mostrar();
		do {
            switch (menu()) {
                case 11:
                    pizzafactory.listarPizza();
                    break;
                case 12:
                    pizzafactory.capturarPizza();
                    break;
                case 13:
                    pizzafactory.eliminarPizza();
                    break;
                case 14:
                    pizzafactory.modificarPizza();
                    break;
                case 15:
                    pizzafactory.buscarPizza();
                    break;
                case 0:
                    return;
            }
        } while (true);
    }

    public static int menu() {
        Scanner datos = new Scanner(System.in);
        Cuadrado.imprimirCuadradoDividido(50, 4,"1.-Pizzas","2.-Orden");
        Cuadrado.imprimirCuadradoDividido(50, 4,"3.-Inventario","4.-Compra");
        Cuadrado.imprimirCuadradoDividido(50, 4,"5.-Proveedores","6.-Clientes");
		System.out.println("0.-Salir");
        int seleccion = datos.nextInt();
        if (seleccion == 0) {
            return seleccion;
        }
        Cuadrado.imprimirCuadradoDividido(50, 4,"1.-Listar","2.-Capturar");
        Cuadrado.imprimirCuadradoDividido(50, 4,"3.-Eliminar","4.-Modificar");
        Cuadrado.imprimirCuadradoDividido(50, 4,"5.-Buscar","0.-cancelar");
        seleccion = seleccion * 10 + datos.nextInt();
		return seleccion;
    }
	 
}