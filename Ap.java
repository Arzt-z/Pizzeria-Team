import java.util.InputMismatchException;
import java.util.Scanner;

public class Ap {
   

    public static void main(String[] args) {

        Pizzeria pizzafactory = new Pizzeria("Pizza Factory", "Av. Lic. Enrique Ramírez Miguel, Las Américas",
                "PizzaFactory@Pizza.com", 7002200, "445697234");
        pizzafactory.mostrar();

        do {

            Empleado[] empleados = pizzafactory.getEmpleados();
            int user = login(empleados, pizzafactory);
            try{
            boolean salir = false;
            if (user == -1) {
                return;
            }

            if (empleados[user].getTipo().equalsIgnoreCase("admin")) {
                
                do {
                    Cuadrado.matriz = Cuadrado.cuadrado(50, 6);
                    Cuadrado.centrarEnXY("Bienvenido " + (empleados[user]).getNombre(), 0, 0);
                    Cuadrado.centrarEnXY((empleados[user]).getTipo(), 0, 1);
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
                            // pizzafactory.buscarInventarios();
                            break;
                        case 32:
                            pizzafactory.capturarOrden();
                            break;
                        case 33:
                            // pizzafactory.buscarInventarios();
                            break;
                        case 34:
                            // pizzafactory.buscarInventarios();
                            break;
                        case 35:
                            // pizzafactory.buscarInventarios();
                            break;
                        case 41:
                            pizzafactory.listarCompras();
                            break;
                        case 42:
                            pizzafactory.capturarCompra();
                            break;
                        case 43:
                            pizzafactory.eliminarCompra();
                            break;
                        case 44:
                            pizzafactory.modificarCompra();
                            break;
                        case 45:
                            pizzafactory.buscarCompra();
                            break;
                        case 51:
                            pizzafactory.listarProveedores();
                            break;
                        case 52:
                            pizzafactory.capturarProveedores();
                            break;
                        case 53:
                            pizzafactory.eliminarProveedores();
                            break;
                        case 54:
                            pizzafactory.modificarProveedores();
                            break;
                        case 55:
                            pizzafactory.buscarProveedores();
                            break;
                        case 61:
                            pizzafactory.listarEmpleados();
                            break;
                        case 62:
                            pizzafactory.capturarEmpleado();
                            break;
                        case 63:
                            pizzafactory.eliminarEmpleado();
                            break;
                        case 64:
                            pizzafactory.modificarEmpleado();
                            break;
                        case 65:
                            pizzafactory.buscarEmpleado();
                            break;
                        case 0:
                            salir = true;
                            pizzafactory.generarArchivoInventario();
                            break;
                    }
                } while (salir == false);
            

            } else if (empleados[user].getTipo().equalsIgnoreCase("empleado")) {
               
                do {
                    Cuadrado.matriz = Cuadrado.cuadrado(50, 6);
                    Cuadrado.centrarEnXY("Bienvenido " + (empleados[user]).getNombre(), 0, 0);
                    Cuadrado.centrarEnXY((empleados[user]).getTipo(), 0, 1);
                    Cuadrado.imprimirCuadrado();
                    switch (menuCajeros()) {
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
                            // pizzafactory.inspeccionarInventario();
                            break;
                        case 22:
                            pizzafactory.capturarOrden();
                            break;
                        case 23:
                            pizzafactory.buscarInventarios();
                            break;
                        case 24:
                            pizzafactory.buscarInventarios();
                            break;
                        case 25:
                            pizzafactory.buscarInventarios();
                            break;
                        case 0:
                            salir = true;
                            break;
                    }
                } while (salir == false);
                 
            }

        
     }catch(InputMismatchException e){
        System.err.println("CARACTER INVALIDO INSERTE UN NUMERO VAlIDO");
       }catch(Exception e){
        System.err.println("OCURRIO EL ERROR "+e);
       }
    } while (true);
    }

    public static int menu() {
        Scanner datos = new Scanner(System.in);
        Cuadrado.imprimirCuadradoDividido(50, 4,"1.-Pizzas","2.-Inventario");
        Cuadrado.imprimirCuadradoDividido(50, 4,"3.-Orden","4.-Compra");
        Cuadrado.imprimirCuadradoDividido(50, 4,"5.-Proveedores","6.-Empleados");
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

    public static int menuCajeros(){
		Scanner datos = new Scanner(System.in);
        Cuadrado.imprimirCuadradoDividido(50, 4,"1.-pizzas","2.-orden");
		System.out.println("0.-Salir");
        int seleccio = datos.nextInt();
        if (seleccio == 0) {
            return seleccio;
        }
        if(seleccio==1 || seleccio==2){
        Cuadrado.imprimirCuadradoDividido(50, 4,"1.-Listar","2.-Capturar");
        Cuadrado.imprimirCuadradoDividido(50, 4,"3.-Eliminar","4.-Modificar");
        Cuadrado.imprimirCuadradoDividido(50, 4,"5.-Buscar","0.-cancelar");
        seleccio = seleccio * 10 + datos.nextInt();
		return seleccio;
        }
        return seleccio;
	}

    public static int login(Empleado[] empleados,Pizzeria pizerria) {
        Scanner datos = new Scanner(System.in);
        int opcion = 1;
        do{
        Cuadrado.imprimirCuadrado(50, 4 ,"------------LOGIN------------");
        Cuadrado.imprimirCuadrado(50, 4 ,"INTRODUCIR USUARIO");
        System.out.println("0.-Cerrar programa");
        String usuario = datos.next();
        if(usuario.equals("0"))return -1;
        Cuadrado.imprimirCuadrado(50, 4 ,"INTRODUCIR PASSWORD");
        System.out.println("0.-salir");
        String password = datos.next();
        if(password == "0")return -1;
        for(int i=0;i<pizerria.getCempleados();i++){
            if((empleados[i].getUsuario().equalsIgnoreCase(usuario.toLowerCase())) && (empleados[i].getPassword().equalsIgnoreCase(password.toLowerCase()))){
                return i;
            }
        }
        Cuadrado.imprimirCuadrado(50, 4 ,"!!!!!!!!!!!!!!!!");
        Cuadrado.imprimirCuadrado(50, 4 ,"usuario o contrasena incorrectos!!");
        Cuadrado.imprimirCuadrado(50, 4 ,"desea crear un nuevo usuario?");
        Cuadrado.imprimirCuadradoDividido(50, 2,"1.-Nuevo Empleado","2.-Re intentar");
        opcion = datos.nextInt();
        if(opcion==1)pizerria.capturarEmpleado();
        //Cuadrado.imprimirCuadrado(50, 3 ,"intentarlo otra vez?");
        //Cuadrado.imprimirCuadradoDividido(50, 2,"1.-SI","2.-NO");
        //opcion = datos.nextInt();
        }while(true);
    }

}
