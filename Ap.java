import java.util.Scanner;
public class Ap{
	public static void main (String[] args){
        
		Pizzeria pizzafactory = new Pizzeria("Pizza Factory", "Av. Lic. Enrique Ramírez Miguel, Las Américas", "PizzaFactory@Pizza.com", 7002200 , "445697234");
		pizzafactory.mostrar();
        Empleado[] empleados = pizzafactory.getEmpleados();
        int user = login(empleados,pizzafactory);
        if(user==-1){return;}
		do {
            Cuadrado.matriz=Cuadrado.cuadrado(50, 6 );
            Cuadrado.centrarEnXY("Bienvenido "+ (empleados[user]).getNombre(),0,0);
            Cuadrado.centrarEnXY((empleados[user]).getTipo(),0,1);
            Cuadrado.imprimirCuadrado();
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
                case 21:
                    pizzafactory.inspeccionarInventario();
                    break;
                case 22:
                    pizzafactory.capturarInventarios();
                    break;
                case 23:
                    pizzafactory.eliminarInventarios();
                    break;
                case 24:
                    pizzafactory.modificarInventarios();
                    break;
                case 25:
                    pizzafactory.buscarInventarios();
                    break;
                case 31:
                    pizzafactory.buscarInventarios();
                    break;
                case 32:
                    pizzafactory.capturarOrden();
                    break;
                case 33:
                    pizzafactory.buscarInventarios();
                    break;
                case 34:
                    pizzafactory.buscarInventarios();
                    break;
                case 35:
                    pizzafactory.buscarInventarios();
                    break;

                case 0:
                    return;
            }
        } while (true);
    }

    public static int menu() {
        Scanner datos = new Scanner(System.in);
        Cuadrado.imprimirCuadradoDividido(50, 4,"1.-Pizzas","2.-Inventario");
        Cuadrado.imprimirCuadradoDividido(50, 4,"3.-Orden","4.-Compra");
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

    public static int login(Empleado[] empleados,Pizzeria pizerria) {
        Scanner datos = new Scanner(System.in);
        int opcion = 1;
        do{
        Cuadrado.imprimirCuadrado(50, 4 ,"------------LOGIN------------");
        Cuadrado.imprimirCuadrado(50, 4 ,"INTRODUCIR USUARIO");
        System.out.println("para salir introducir: 0");
        String usuario = datos.next();
        if(usuario.equals("0"))return -1;
        Cuadrado.imprimirCuadrado(50, 4 ,"INTRODUCIR PASSWORD");
        String password = datos.next();
        
        for(int i=0;i<pizerria.getCempleados();i++){
            if((empleados[i].getUsuario().equalsIgnoreCase(usuario.toLowerCase())) && (empleados[i].getPassword().equalsIgnoreCase(password.toLowerCase()))){
                return i;
            }
        }
        Cuadrado.imprimirCuadrado(50, 4 ,"!!!!!!!!!!!!!!!!");
        Cuadrado.imprimirCuadrado(50, 4 ,"usuario o contrasena incorrectos!!");
        //Cuadrado.imprimirCuadrado(50, 3 ,"intentarlo otra vez?");
        //Cuadrado.imprimirCuadradoDividido(50, 2,"1.-SI","2.-NO");
        //opcion = datos.nextInt();
        }while(opcion==1);
        return -1;
    }

	 
}