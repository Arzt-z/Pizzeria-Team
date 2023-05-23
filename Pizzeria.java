import java.io.*;
import java.util.*;

public class Pizzeria implements java.io.Serializable {
    private String nombre;
    private String domicilio;
    private String correo;
    private String horario;
    private String telefono;
    private String rfc;
    private Persona[] personas = new Persona[500];
    private int cPersonas;
    private Inventario[] inventarios = new Inventario[500];
    private int cInventarios;
    private Pizza[] pizzas = new Pizza[500];
    private int cPizzas;
    private Orden[] ordenes = new Orden[500];
    private Transaccion[] transaccion = new Transaccion[500];
    private int cTransaccion = 0;

    public Pizzeria() {
        cPizzas = 0;
        cTransaccion = 0;
    }

    public Pizzeria(String nombre, String domicilio, String correo, int horario, String telefono) {
        cPizzas = 0;
        cTransaccion = 0;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.correo = correo;
        this.horario = (horario / 1000000) % 100 + ":" + (horario / 100000) % 10 + (horario / 10000) % 10 + "-"
                + (horario / 100) % 100 + ":" + (horario / 10) % 10 + horario % 10;
        this.telefono = telefono;
        inicializarinventarios();
        inicializarPizzas();
        inicializaPersonas();
    }

    public void mostrar() {

        // primero decir de que tamano sera la matriz x,y,
        // luego darle la palabra a imprimir en cuadrito,las funciones estan la clase
        // cuadrado
        Cuadrado.imprimirCuadrado(50, 4, nombre);

        // para multiples palabras en un mismo cuadrito
        // asignar el tamano que sera la matriz, luego usar centrarEnXY
        // pasarle la palabra y la posicion X,Y, (0,0 es el centro)
        Cuadrado.matriz = Cuadrado.cuadrado(50, 6);
        Cuadrado.centrarEnXY(domicilio, 0, -1);
        Cuadrado.centrarEnXY("Correo: " + correo, 0, 0);
        Cuadrado.centrarEnXY("horario: " + horario, 0, 1);
        Cuadrado.imprimirCuadrado();

    }

    protected void inicializaPersonas() {
        cargarArchivoPersonas();
         /*  personas[0] = new Empleado("Daniel Adrian Roque Cortes", "443 832 7292", "algun lado", "rfc", "1234", "admin");
        personas[++cPersonas] = new Empleado("Alexis Corzas Santiago", "443 363 1574", "algun lado", "rfc", "1234",
                "admin");
        personas[++cPersonas] = new Empleado("maki", "443 619 2989", "algun lado", "rfc", "1234", "empleado");
        personas[++cPersonas] = new Empleado("cajero", "000 000 0000", "algun lado", "rfc", "1234", "empleado");
        personas[++cPersonas] = new Empleado("admin", "000 000 0000", "algun lado", "rfc", "1234", "empleado");

        personas[++cPersonas] = new Proveedores("Verduras Taguada SA de CV", "554 234 2345", "algun lado", "rfc");
        personas[++cPersonas] = new Proveedores("Grupo Alsea SA de CV", "443 312 0093",
                "GP 30, Centro histórico de Morelia, 58000 Morelia, Mich.", "ALS211312FPE");
    */
    }

    protected void inicializarinventarios() {
       cargarArchivoInventario();
/* 
         inventarios[0] = new Inventario("Queso mozzarella", "Queso", 0.3);
        inventarios[++cInventarios] = new Inventario("Queso parmesano", "queso",
                0.26);
        inventarios[++cInventarios] = new Inventario("Peperoni", "carne", 0.6);
        inventarios[++cInventarios] = new Inventario("Salchicha", "carne", 0.08);
        inventarios[++cInventarios] = new Inventario("Anchoas", "carne", 1.0);
        inventarios[++cInventarios] = new Inventario("Salami", "carne", 0.67);
        inventarios[++cInventarios] = new Inventario("Jamon", "carne", 0.14);
        inventarios[++cInventarios] = new Inventario("Tocino", "carne", 0.32);
        inventarios[++cInventarios] = new Inventario("Carne molida", "carne", 0.16);
        inventarios[++cInventarios] = new Inventario("Chorizo", "carne", 0.12);

        inventarios[++cInventarios] = new Inventario("Cebolla", "no carne", 0.016);
        inventarios[++cInventarios] = new Inventario("tomate", "no carne", 0.016);
        inventarios[++cInventarios] = new Inventario("Pimiento verde", "no carne",
                0.06);
        inventarios[++cInventarios] = new Inventario("Pimiento rojo", "no carne",
                0.06);
        inventarios[++cInventarios] = new Inventario("Aceitunas", "no carne", 0.06);
        inventarios[++cInventarios] = new Inventario("Champiñones", "no carne",
                0.07);
        inventarios[++cInventarios] = new Inventario("Ajo", "no carne", 0.05);
        inventarios[++cInventarios] = new Inventario("Jalapeños", "no carne", 0.05);
        inventarios[++cInventarios] = new Inventario("Piña", "no carne", 0.013);

        inventarios[++cInventarios] = new Inventario("orden de papas", "producto",
                20);
        inventarios[++cInventarios] = new Inventario("orden de bonneless",
                "producto", 50);
        inventarios[++cInventarios] = new Inventario("refresco de cola", "bebida",
                15);
        inventarios[++cInventarios] = new Inventario("refresco de manzana", "bebida",
                15);
        inventarios[++cInventarios] = new Inventario("refresco de naranaja",
                "bebida", 15);
        inventarios[++cInventarios] = new Inventario("palitos de queso", "producto",
                20);
        inventarios[++cInventarios] = new Inventario("salsa secreta", "extra", 10);
        inventarios[++cInventarios] = new Inventario("dip de BBQ", "extra", 15); 
    */
    }

    protected void inicializarPizzas() {
         cargarArchivoPizzas();
        /* 
        pizzas[0] = new Pizza("Hawaiana", 3, 199);
        pizzas[cPizzas].capturarIngrediente(inventarios[6], 0);
        pizzas[cPizzas].capturarIngrediente(inventarios[18], 0);

        pizzas[++cPizzas] = new Pizza("peperoni", 3, 199);
        pizzas[cPizzas].capturarIngrediente(inventarios[2], 0);

        pizzas[++cPizzas] = new Pizza("jamon", 3, 199);
        pizzas[cPizzas].capturarIngrediente(inventarios[6], 0);

        pizzas[++cPizzas] = new Pizza("mexicana", 3, 199);
        pizzas[cPizzas].capturarIngrediente(inventarios[10], 0);
        pizzas[cPizzas].capturarIngrediente(inventarios[9], 0);
        pizzas[cPizzas].capturarIngrediente(inventarios[8], 0);
        pizzas[cPizzas].capturarIngrediente(inventarios[17], 0);

        pizzas[++cPizzas] = new Pizza("loca", 3, 199);
        pizzas[cPizzas].capturarIngrediente(inventarios[9], 0);
        */
    }

    // funciones de inventarios
    public void listarinventarios() {
        int contador = 0;
        for (int i = 0; i < cInventarios; i++) {
            if (inventarios[i].getExistencia() == true) {
                contador++;
            }

        }
        Cuadrado.imprimirCuadrado(50, 2, "----------inventarios----------");
        Cuadrado.matriz = Cuadrado.cuadrado(50, contador + 4);
        Cuadrado.centrarEnXYPresicion("Stock ", 30, 0);
        Cuadrado.centrarEnXYPresicion("|", 36, 0);
        Cuadrado.centrarEnXYPresicion("Precio", 37, 0);
        for (int i = 0, c = 0; i < cInventarios; i++) {
            if (inventarios[i].getExistencia() == true) {
                c++;
                Cuadrado.centrarEnXYPresicion(i + 1 + ".-" + inventarios[i].getNombre(), 4, c + 1);
                Cuadrado.centrarEnXYPresicion(inventarios[i].getStock() + "", 30, c + 1);
                if (inventarios[i].getTipo().toLowerCase().equals("carne")
                        || inventarios[i].getTipo().toLowerCase().equals("no carne")
                        || inventarios[i].getTipo().toLowerCase().equals("queso")
                        || inventarios[i].getTipo().toLowerCase().equals("ingrediente"))
                    Cuadrado.centrarEnXYPresicion("g", 35, c + 1);
                Cuadrado.centrarEnXYPresicion("| ", 36, c + 1);
                Cuadrado.centrarEnXYPresicion((float) (inventarios[i].getPrecio()) + "", 37, c + 1);

            }
        }
        Cuadrado.imprimirCuadrado();
    }

    public void listarinventarios(String tipo) {
        int contador = 0;
        for (int i = 0; i < cInventarios; i++) {
            if (inventarios[i].getExistencia() == true) {
                if (inventarios[i].getTipo().equals(tipo) ||
                        ((inventarios[i].getTipo().toLowerCase().equals("carne")
                                || inventarios[i].getTipo().toLowerCase().equals("no carne")
                                || inventarios[i].getTipo().toLowerCase().equals("queso")
                                || inventarios[i].getTipo().toLowerCase().equals("ingrediente"))
                                && (tipo.toLowerCase().equals("ingrediente")))) {
                    contador++;
                }
            }

        }
        Cuadrado.matriz = Cuadrado.cuadrado(50, contador + 3);
        Cuadrado.centrarEnXYPresicion("Stock ", 30, 0);
        Cuadrado.centrarEnXYPresicion("|", 36, 0);
        Cuadrado.centrarEnXYPresicion("Precio", 37, 0);
        for (int i = 0, c = 0; i < cInventarios; i++) {
            if (inventarios[i].getExistencia() == true) {
                if (inventarios[i].getTipo().equals(tipo) ||
                        ((inventarios[i].getTipo().toLowerCase().equals("carne")
                                || inventarios[i].getTipo().toLowerCase().equals("no carne")
                                || inventarios[i].getTipo().toLowerCase().equals("queso")
                                || inventarios[i].getTipo().toLowerCase().equals("ingrediente"))
                                && (tipo.toLowerCase().equals("ingrediente")))) {
                    Cuadrado.centrarEnXYPresicion(i + 1 + ".-" + inventarios[i].getNombre(), 1, c + 1);
                    Cuadrado.centrarEnXYPresicion(inventarios[i].getStock() + "", 30, c + 1);
                    if (inventarios[i].getTipo().toLowerCase().equals("carne")
                            || inventarios[i].getTipo().toLowerCase().equals("no carne")
                            || inventarios[i].getTipo().toLowerCase().equals("queso")
                            || inventarios[i].getTipo().toLowerCase().equals("ingrediente"))
                        Cuadrado.centrarEnXYPresicion("g", 35, c + 1);
                    Cuadrado.centrarEnXYPresicion("| ", 36, c + 1);
                    Cuadrado.centrarEnXYPresicion((float) (inventarios[i].getPrecio()) + "", 37, c + 1);
                    c++;
                }
            }

        }
        Cuadrado.imprimirCuadrado();

    }

    public void inspeccionarInventario() {
        Scanner datos = new Scanner(System.in);
        int continuar = 1;
        int seleccion = 0;
        do {
            if (continuar != 1)
                return;
            seleccion = seleccionInventarios();
            if (seleccion == 0) {
                return;
            }
            if (inventarios[seleccion - 1].getExistencia()) {
                inventarios[seleccion - 1].mostrar();
                Cuadrado.imprimirCuadrado(50, 3, "deseas ver otro?");
                Cuadrado.imprimirCuadradoDividido(50, 2, "1.-si", "2.-no");
            } else {
                Cuadrado.imprimirCuadrado(50, 3, "ELEMENTO INVALIDO INTENTAR OTRA VEZ?");
                Cuadrado.imprimirCuadradoDividido(50, 2, "1.-si", "2.-no");
            }
            continuar = datos.nextInt();
        } while (continuar == 1);
    }

    public void capturarInventarios() {
        try {
            Scanner datos = new Scanner(System.in);
            int continuar = 1;
            do {
                listarinventarios();
                inventarios[cInventarios] = new Inventario();
                inventarios[cInventarios++].capturar();
                Cuadrado.imprimirCuadrado(50, 3, "desea capturar otro?");
                Cuadrado.imprimirCuadradoDividido(50, 2, "1.-si", "2.-no");
                continuar = datos.nextInt();
            } while (continuar == 1);
        } catch (InputMismatchException e) {
            System.err.println("CARACTER INVALIDO INSERTE UN NUMERO VAlIDO");
            cInventarios--;
        } catch (Exception e) {
            System.err.println("OCURRIO EL ERROR " + e);
            e.printStackTrace();
            cInventarios--;
        }
    }

    public void modificarInventarios() {
        Scanner datos = new Scanner(System.in);
        int seleccion = 0;
        int continuar = 1;
        seleccion = seleccionInventarios() - 1;
        do {
            inventarios[seleccion].modificar();
            Cuadrado.imprimirCuadrado(50, 3, "desea modificar otro?");
            Cuadrado.imprimirCuadradoDividido(50, 2, "1.-si", "2.-no");
            continuar = datos.nextInt();
        } while (continuar == 1);

    }

    public void buscarInventarios() {
        Scanner datos = new Scanner(System.in);
        int continuar = 1;
        String cadenaAbuscar;
        do {
            System.out.println("TEXTO A BUSCAR");
            cadenaAbuscar = datos.nextLine();
            for (int i = 0; i < cInventarios; i++) {
                if (inventarios[i].buscar(cadenaAbuscar) == true && inventarios[i].getExistencia() == true) {
                    inventarios[i].mostrar();
                }
            }
            Cuadrado.imprimirCuadrado(50, 3, "BUSCAR OTRA VEZ?");
            Cuadrado.imprimirCuadradoDividido(50, 2, "1.-SI", "2.-NO");
            continuar = datos.nextInt();
            datos.nextLine();
        } while (continuar == 1);
    }

    public void eliminarInventarios() {
        Scanner datos = new Scanner(System.in);
        int seleccion = 0;
        int continuar = 1;
        do {
            Cuadrado.imprimirCuadrado(50, 2, "----------inventarios----------");
            Cuadrado.matriz = Cuadrado.cuadrado(50, cInventarios + 4);
            Cuadrado.centrarEnXYPresicion("Stock ", 30, 0);
            Cuadrado.centrarEnXYPresicion("|", 36, 0);
            Cuadrado.centrarEnXYPresicion("Precio", 37, 0);
            for (int i = 0; i < cInventarios; i++) {
                if (inventarios[i].getExistencia() == true) {
                    Cuadrado.centrarEnXYPresicion(i + 1 + ".-" + inventarios[i].getNombre(), 4, i + 1);
                    Cuadrado.centrarEnXYPresicion(inventarios[i].getStock() + "g", 30, i + 1);
                    Cuadrado.centrarEnXYPresicion("| ", 36, i + 1);
                    Cuadrado.centrarEnXYPresicion((float) (inventarios[i].getPrecio() * 100) + "", 37, i + 1);
                } else {
                    Cuadrado.centrarEnXYPresicion(i + 1 + ".-" + "//////ELIMINADO//////", 4, i + 1);
                }
            }
            Cuadrado.imprimirCuadrado();
            Cuadrado.imprimirCuadrado(50, 2, "---INGRESAR NUMERO---");
            System.out.println("0.-Salir");
            seleccion = datos.nextInt();
            if (seleccion == 0) {
                return;
            }
            inventarios[seleccion - 1].eliminar();

        } while (continuar == 1);

    }

    public int seleccionInventarios() {
        Scanner datos = new Scanner(System.in);
        int seleccion = 0;
        int continuar = 1;
        listarinventarios();
        Cuadrado.imprimirCuadrado(50, 2, "---INGRESAR NUMERO---");
        System.out.println("0.-Salir");
        seleccion = datos.nextInt();
        if (seleccion == 0) {
            return 0;
        }
        return seleccion;
    }
    // fin funciones de inventarios

    // funciones pizza
    public void listarPizza() {
        Scanner datos = new Scanner(System.in);
        int continuar = 1;
        int seleccion = 0;
        do {
            mostrarPizzas();
            if (continuar != 1)
                return;
            Cuadrado.imprimirCuadrado(50, 3, "selecciona una pizza");
            seleccion = datos.nextInt();
            if (pizzas[seleccion - 1].getExistencia()) {
                pizzas[seleccion - 1].mostrar();
                Cuadrado.imprimirCuadrado(50, 3, "deseas ver otra pizza?");
                Cuadrado.imprimirCuadradoDividido(50, 2, "1.-si", "2.-no");
            } else {
                Cuadrado.imprimirCuadrado(50, 3, "PIZZA INVALIDA INTENTAR OTRA VEZ?");
                Cuadrado.imprimirCuadradoDividido(50, 2, "1.-si", "2.-no");
            }
            continuar = datos.nextInt();
        } while (continuar == 1);
    }

    public void mostrarPizzas() {
        Cuadrado.imprimirCuadrado(50, 2, "----------Pizzas----------");
        Cuadrado.matriz = Cuadrado.cuadrado(50, cPizzas + 4);
        Cuadrado.centrarEnXYPresicion("Precio ", 37, 0);
        for (int i = 0; i <= cPizzas; i++) {
            if (pizzas[i].getExistencia()) {
                Cuadrado.centrarEnXYPresicion(i + 1 + ".-" + pizzas[i].toString(), 3, i + 1);
                Cuadrado.centrarEnXYPresicion(pizzas[i].getPrecio() + "$ ", 38, 1 + i);
            }
        }
        Cuadrado.imprimirCuadrado();
    }

    public void capturarPizza() {
        Scanner datos = new Scanner(System.in);
        try {
            pizzas[++cPizzas] = new Pizza();
            Cuadrado.imprimirCuadrado(50, 4, "------------PIZZA------------");
            tamanoPizza(cPizzas);
            dividirPizza(cPizzas);
            seleccionarIngredientePizza(cPizzas);
            Cuadrado.imprimirCuadrado(50, 4, "Nombre de la pizza");
            pizzas[cPizzas].setNombre(datos.nextLine());
            pizzas[cPizzas].capturar();
        } catch (InputMismatchException e) {
            System.err.println("CARACTER INVALIDO INSERTE UN NUMERO VAlIDO");
            cPizzas--;
        } catch (Exception e) {
            System.err.println("OCURRIO EL ERROR " + e);
            e.printStackTrace();
            cPizzas--;
        }
    }

    public void eliminarPizza() {
        Scanner datos = new Scanner(System.in);
        int seleccion = 0;
        int continuar = 1;
        do {
            mostrarPizzas();
            Cuadrado.imprimirCuadrado(50, 3, "---SELECCIONA LA PIZZA A ELIMINAR---");
            seleccion = datos.nextInt();
            pizzas[seleccion - 1].eliminar();
            Cuadrado.imprimirCuadrado(50, 3, "ELIMINAR OTRA PIZZA?");
            Cuadrado.imprimirCuadradoDividido(50, 2, "1.-SI", "2.-NO");
            continuar = datos.nextInt();
        } while (continuar == 1);
    }

    public void modificarPizza() {
        Scanner datos = new Scanner(System.in);
        int seleccion = 0;
        int continuar = 1;
        int opcionMod = 0;
        mostrarPizzas();
        Cuadrado.imprimirCuadrado(50, 3, "---SELECCIONA LA PIZZA A MODIFICAR---");
        seleccion = datos.nextInt() - 1;
        do {
            Cuadrado.imprimirCuadrado(50, 3, "QUE DESEA MODIFICAR?");
            Cuadrado.imprimirCuadradoDividido(50, 4, "1.-Ingredientes", "2.-Nombre");
            Cuadrado.imprimirCuadradoDividido(50, 4, "3.-Dividir en partes", "4.-Tamano");
            Cuadrado.imprimirCuadrado(50, 4, "5.-Precio Fijo");
            opcionMod = datos.nextInt();
            switch (opcionMod) {
                case 1:
                    seleccionarIngredientePizza(seleccion);
                    break;
                case 2:
                    nombrePizza(seleccion);
                    break;
                case 3:
                    dividirPizza(seleccion);
                    break;
                case 4:
                    tamanoPizza(seleccion);
                    break;
                case 5:
                    precioPizza(seleccion);
                    break;
                case 0:
                    return;
            }
            Cuadrado.imprimirCuadrado(50, 3, "MODIFICAR ALGO MAS?");
            Cuadrado.imprimirCuadradoDividido(50, 2, "1.-SI", "2.-NO");
            continuar = datos.nextInt();
        } while (continuar == 1);

    }

    public void nombrePizza(int seleccion) {
        Scanner datos = new Scanner(System.in);
        Cuadrado.imprimirCuadrado(50, 3, "INGRESAR NOMBRE");
        String nombre = datos.nextLine();
        pizzas[seleccion].setNombre(nombre);
    }

    public void precioPizza(int seleccion) {
        Scanner datos = new Scanner(System.in);
        Cuadrado.imprimirCuadrado(50, 3, "INGRESAR PRECIO");
        int precio = datos.nextInt();
        pizzas[seleccion].setPrecioFijo(true);
        pizzas[seleccion].setPrecio(precio);
    }

    public void tamanoPizza(int seleccion) {
        Scanner datos = new Scanner(System.in);
        Cuadrado.imprimirCuadrado(50, 3, "SELECCIONAR UN TAMAÑO");
        Cuadrado.imprimirCuadradoDividido(50, 4, "1.-Chica", "2.-Mediana");
        Cuadrado.imprimirCuadradoDividido(50, 4, "3.-Grande", "4.-Familiar");
        int size = datos.nextInt();
        pizzas[cPizzas].setSize(size);
    }

    public void dividirPizza(int seleccion) {
        Scanner datos = new Scanner(System.in);
        Cuadrado.imprimirCuadrado(50, 3, "PIZZA DIVIDIDA?");
        Cuadrado.imprimirCuadrado(50, 4, "1.-NO");
        Cuadrado.imprimirCuadradoDividido(50, 4, "2.-A la mitad", "3.-En 4 partes");
        int divisionDP = datos.nextInt();
        if (divisionDP == 3)
            divisionDP++;
        pizzas[seleccion].setcPartes(divisionDP);
    }

    public void seleccionarIngredientePizza(int seleccion) {
        Scanner datos = new Scanner(System.in);
        int divisionDP = pizzas[seleccion].getcPartes();
        int continuar = 1;
        for (int i = 0; i < divisionDP; i++) {
            do {
                Cuadrado.imprimirCuadrado(50, 3, "SELECCIONAR UN INGREDIENTE ");
                listarinventarios("ingrediente");
                if (divisionDP >= 2)
                    Cuadrado.imprimirCuadrado(50, 2, "Parte " + (i + 1));
                int opcion = datos.nextInt();
                pizzas[seleccion].capturarIngrediente(inventarios[opcion - 1], i);
                Cuadrado.imprimirCuadrado(50, 3, "AGREGAR OTRO INGREDIENTE?");
                Cuadrado.imprimirCuadradoDividido(50, 2, "1.-SI", "2.-NO");
                continuar = datos.nextInt();
            } while (continuar == 1);
        }
    }

    public void buscarPizza() {
        Scanner datos = new Scanner(System.in);
        int continuar = 1;
        do {
            System.out.println("TEXTO A BUSCAR");
            String cadenaAbuscar = datos.nextLine();
            for (int i = 0; i <= cPizzas; i++) {
                if (pizzas[i].buscar(cadenaAbuscar) == true && pizzas[i].getExistencia() == true) {
                    pizzas[i].mostrar();
                }
            }
            Cuadrado.imprimirCuadrado(50, 3, "BUSCAR OTRA?");
            Cuadrado.imprimirCuadradoDividido(50, 2, "1.-SI", "2.-NO");
            continuar = datos.nextInt();
            datos.nextLine();
        } while (continuar == 1);
    }

    // fin funciones pizza

    // funciones orden
    public void capturarOrden() {
        Scanner datos = new Scanner(System.in);
        try {
            int continuar = 1;
            transaccion[cTransaccion] = new Orden();
            transaccion[cTransaccion].setFolio("FO-" + (cTransaccion + 1));
            ((Orden) transaccion[cTransaccion]).capturarCliente();
            do {
                Cuadrado.imprimirCuadrado(50, 3, "Selecciona Pizza o producto");
                // Cuadrado.imprimirCuadrado(50, 4,"COMBOS");
                Cuadrado.imprimirCuadradoDividido(50, 4, "1.-PRODUCTOS", "2.-PIZZA");
                int opcion = datos.nextInt();
                if (opcion == 1) {
                    transaccion[cTransaccion].capturar(inventarios, cInventarios, 'v');
                } else if (opcion == 2) {
                    transaccion[cTransaccion].capturar(pizzas, cPizzas);
                }
                Cuadrado.imprimirCuadrado(50, 3, "agregar otra pizza o producto?");
                Cuadrado.imprimirCuadradoDividido(50, 2, "1.-SI", "2.-NO");
                continuar = datos.nextInt();
            } while (continuar == 1);
            cTransaccion++;
        } catch (InputMismatchException e) {
            System.err.println("CARACTER INVALIDO INSERTE UN NUMERO VAlIDO");
            cTransaccion--;
        } catch (Exception e) {
            System.err.println("OCURRIO EL ERROR " + e);
            e.printStackTrace();
            cTransaccion--;
        }
    }

    public void modificarOrden() {
        Scanner datos = new Scanner(System.in);
        int continuar = 1;
        int seleccion = 0;
        do {
            mostrarOrdenes();
            if (continuar != 1)
                return;
            Cuadrado.imprimirCuadrado(50, 3, "selecciona una orden");
            seleccion = datos.nextInt();
            if (transaccion[seleccion - 1].isVigente()) {
                Cuadrado.imprimirCuadrado(50, 3, "Que deseas modificar?");
                Cuadrado.imprimirCuadradoDividido(50, 2, "1.-Cliente", "2.-Pedido");
                int eleccion = datos.nextInt();
                switch (eleccion) {
                    case 1:
                        ((Orden) transaccion[seleccion - 1]).capturarCliente();
                        break;
                    case 2: 
                        //transaccion[seleccion-1].eliminarDetalles();
                        //((Orden)transaccion[seleccion-1]).capturarPizza(pizzas, cPizzas);
                        transaccion[seleccion-1].modificar(cInventarios, inventarios, 'v' , cPizzas , pizzas);
                        break;
                    case 0:
                        return;
                }

            } else {
                Cuadrado.imprimirCuadrado(50, 3, "ORDEN INVALIDA INTENTAR OTRA VEZ?");
                Cuadrado.imprimirCuadradoDividido(50, 2, "1.-si", "2.-no");
            }
            continuar = datos.nextInt();
        } while (continuar == 1);

    }

    public void listarOrden() {
        Scanner datos = new Scanner(System.in);
        int continuar = 1;
        int seleccion = 0;
        do {
            mostrarOrdenes();
            if (continuar != 1)
                return;
            Cuadrado.imprimirCuadrado(50, 3, "selecciona una orden");
            seleccion = datos.nextInt();
            if (transaccion[seleccion - 1].isVigente()) {
                ((Orden) transaccion[seleccion - 1]).mostrarOrden();
                (transaccion[seleccion - 1]).getDetalles('v');
                Cuadrado.imprimirCuadrado(50, 3, "deseas ver otro detalle?");
                Cuadrado.imprimirCuadradoDividido(50, 2, "1.-si", "2.-no");
            } else {
                Cuadrado.imprimirCuadrado(50, 3, "DETALLE INVALIDO INTENTAR OTRA VEZ?");
                Cuadrado.imprimirCuadradoDividido(50, 2, "1.-si", "2.-no");
            }
            continuar = datos.nextInt();
        } while (continuar == 1);
    }

    public void eliminarOrden() {
        Scanner datos = new Scanner(System.in);
        int continuar = 1;
        int seleccion = 0;
        do {
            mostrarOrdenes();
            if (continuar != 1)
                return;
            Cuadrado.imprimirCuadrado(50, 3, "selecciona una orden");
            seleccion = datos.nextInt();
            if (transaccion[seleccion - 1].isVigente()) {
                ((Orden) transaccion[seleccion - 1]).eliminar();
                Cuadrado.imprimirCuadrado(50, 3, "deseas eliminar otro detalle?");
                Cuadrado.imprimirCuadradoDividido(50, 2, "1.-si", "2.-no");
            } else {
                Cuadrado.imprimirCuadrado(50, 3, "DETALLE INVALIDO INTENTAR OTRA VEZ?");
                Cuadrado.imprimirCuadradoDividido(50, 2, "1.-si", "2.-no");
            }
            continuar = datos.nextInt();
        } while (continuar == 1);

    }

    public void buscarOrden() {
        Scanner datos = new Scanner(System.in);
        int continuar = 1;
        String cadenaAbuscar;
        do {
            System.out.println("TEXTO A BUSCAR");
            cadenaAbuscar = datos.nextLine();
            for (int i = 0; i < cTransaccion; i++) {
                if ((transaccion[i].buscar(cadenaAbuscar) == true
                        || ((Orden) transaccion[i]).getCliente().contains(cadenaAbuscar))
                        && transaccion[i].isVigente() == true && transaccion[i].queSoy().equalsIgnoreCase("orden")) {
                    ((Orden) transaccion[i]).mostrarOrden();
                }
            }
            Cuadrado.imprimirCuadrado(50, 3, "BUSCAR OTRA VEZ?");
            Cuadrado.imprimirCuadradoDividido(50, 2, "1.-SI", "2.-NO");
            continuar = datos.nextInt();
            datos.nextLine();
        } while (continuar == 1);
    }

    public void mostrarOrdenes() {
        int contador = 0;
        Cuadrado.imprimirCuadrado(50, 2, "----------Ordenes----------");
        for (int i = 0; i < cTransaccion; i++) {
            if (transaccion[i].isVigente() && transaccion[i].queSoy().equalsIgnoreCase("orden")) {
                contador++;
            }
        }
        Cuadrado.matriz = Cuadrado.cuadrado(50, contador + 3);
        Cuadrado.centrarEnXYPresicion("folio ", 3, 0);
        Cuadrado.centrarEnXYPresicion("fecha ", 12, 0);
        Cuadrado.centrarEnXYPresicion("nombre ", 30, 0);
        contador = 0;
        for (int i = 0; i < cTransaccion; i++) {
            if (transaccion[i].isVigente() && transaccion[i].queSoy().equalsIgnoreCase("orden")) {
                Cuadrado.centrarEnXYPresicion(i + 1 + ".-" + transaccion[i].getFolio(), 2, contador + 1);
                Cuadrado.centrarEnXYPresicion(transaccion[i].getFecha() + "", 12, 1 + contador);
                Cuadrado.centrarEnXYPresicion(((Orden) transaccion[i]).getCliente(), 30, 1 + contador);
                contador++;
            }
        }
        Cuadrado.imprimirCuadrado();
    }
    // fin funciones orden
    // inicio funciones proveedor

    public void listarProveedores() {
        Scanner leer = new Scanner(System.in);
        int opcion = 0;
        int error = 0;
        int nprov = 0;
        mostrarProveedores();
        System.out.println("Inserte el numero del proveedor que desee ver    0.-SALIR");
        opcion = leer.nextInt();
        if (opcion > 0) {
            nprov = opcion - 1;
            opcion = 1;
        }
        switch (opcion) {
            case 0:
                return;

            case 1:
                do {
                    error = 0;
                    if (!personas[nprov].quienSoy().equals("Proveedor") || personas[nprov].isVigente() == false) {
                        System.out.println("Este proveedor no existe");
                        System.out.println("Vuelva a intentarlo");
                        System.out.println("Inserte el numero del proveedor que desea ver");
                        nprov = leer.nextInt() - 1;
                        error = 1;
                    } else if (personas[nprov].isVigente() == true && personas[nprov].quienSoy().equals("Proveedor")) {
                        personas[nprov].mostrar();
                        String cadenaAbuscar = ((Proveedores) personas[nprov]).getRazonSocial();
                        for (int i = 0; i < cTransaccion; i++) {
                            if (transaccion[i].queSoy().equals("Compra")) {
                                if (((Compra) transaccion[i]).buscar(cadenaAbuscar) == true
                                        && transaccion[i].isVigente() == true) {
                                    ((Compra) transaccion[i]).mostrar();
                                    ((Compra) transaccion[i]).getDetalles();
                                }
                            }
                        }
                    }
                } while (error == 1);
                break;
        }

    }

    public void mostrarProveedores() {
        System.out.println("          P R O V E E D O R E S          ");
        for (int i = 0; i <= cPersonas; i++) {
            if (personas[i].isVigente() == true && personas[i].quienSoy().equals("Proveedor")) {
                System.out.println(i + 1 + ".-" + personas[i]);
            }
        }
    }

    public void capturarProveedores() {
        Scanner sc = new Scanner(System.in);
        try {
            int opcion = 0;
            do {

                personas[++cPersonas] = new Proveedores();
                ((Proveedores) personas[cPersonas]).capturar();
                System.out.println("Quiere agregar otro proveedor?   1.-Si   2.-No");
                opcion = sc.nextInt();
            } while (opcion == 1);
        } catch (InputMismatchException e) {
            System.err.println("CARACTER INVALIDO INSERTE UN NUMERO VAlIDO");
            cPersonas--;
        } catch (Exception e) {
            System.err.println("OCURRIO EL ERROR " + e);
            e.printStackTrace();
            cPersonas--;
        }
    }

    public void modificarProveedores() {
        Scanner leer = new Scanner(System.in);
        int error = 0;
        do {
            error = 0;
            mostrarProveedores();
            System.out.println("Que proveedor va modificar?");
            int mod = leer.nextInt() - 1;
            if (!personas[mod].quienSoy().equals("Proveedor") || mod > cPersonas
                    || personas[mod].isVigente() == false) {
                System.out.println("Ese proveedor no existe");
                System.out.println("vuelva a intentarlo");
                error = 1;
            } else {
                personas[mod].modificar();
            }
        } while (error == 1);
    }

    public void eliminarProveedores() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            opcion = 0;
            mostrarProveedores();
            System.out.println("Que proveedor va eliminar?");
            int num = sc.nextInt() - 1;
            if (num < 0) {
                System.out.println("Ese proveedore no existe");
            } else {
                if (num > cPersonas || personas[num].isVigente() == false
                        || !personas[num].quienSoy().equals("Proveedor")) {
                    System.out.println("Ese proveedor no existe");
                } else {
                    personas[num].eliminar();
                }
            }
            System.out.println("Quiere seguir eliminando?   1.-Si   2.-No");
            opcion = sc.nextInt();
        } while (opcion == 1);
    }

    public void buscarProveedores() {
        Scanner leer = new Scanner(System.in);
        int opcion = 0;
        do {
            opcion = 0;
            System.out.println("Inserte el texto que desea buscar");
            String cadenaAbuscar = leer.next();
            int error = 0;
            for (int i = 0; i <= cPersonas; i++) {
                if (personas[i].buscar(cadenaAbuscar) == true && personas[i].quienSoy().equals("Proveedor")) {
                    System.out.println("------------------------------");
                    personas[i].mostrar();
                    error++;
                }
            }
            if (error == 0) {
                System.out.println("No se han encontrado resultados");
            }
            System.out.println("Desea seguir buscando?   1.-Si   2.-No");
            opcion = leer.nextInt();
        } while (opcion == 1);
    }

    // Fin funciones proveedor

    // Funciones de compra

    public void listarCompras() {
        for (int i = 0; i < cTransaccion; i++) {
            if (transaccion[i].isVigente() == true && transaccion[i].queSoy().equals("compra")) {
                ((Compra) transaccion[i]).mostrar();
                ((Compra) transaccion[i]).getDetalles();
            }
            System.out.println("-------------------------------------------");
        }
    }

    public void capturarCompra() {
        try {
            Proveedores[] proveedor = new Proveedores[500];
            int cProveedores = 0;
            for (int i = 0; i <= cPersonas; i++) {
                if (personas[i].quienSoy().equals("Proveedor")) {
                    proveedor[cProveedores] = (Proveedores) personas[i];
                    cProveedores++;
                }
            }
            transaccion[cTransaccion] = new Compra(cProveedores, proveedor, this.cInventarios, this.inventarios,
                    this.cPizzas, this.pizzas);
            transaccion[cTransaccion].setFolio("FO-" + (cTransaccion + 1));
            ((Compra) transaccion[cTransaccion]).capturar();
            cTransaccion++;
        } catch (InputMismatchException e) {
            System.err.println("CARACTER INVALIDO INSERTE UN NUMERO VAlIDO");
            cTransaccion--;
        } catch (Exception e) {
            System.err.println("OCURRIO EL ERROR " + e);
            e.printStackTrace();
            cTransaccion--;
        }
    }

    public void modificarCompra() {
        Scanner datos = new Scanner(System.in);
        System.out.println("Que compra deseas modificar");
        int selecciona;
        int error = 0;
        for (int i = 0; i < cTransaccion; i++) {
            if (transaccion[i].isVigente() == true && transaccion[i].queSoy().equals("compra")) {
                System.out.println(i + 1 + ".-" + transaccion[i]);
            }
        }
        do {
            error = 0;
            System.out.println("Selecione la compra:");
            selecciona = datos.nextInt();
            if (transaccion[selecciona - 1].isVigente() == true
                    && transaccion[selecciona - 1].queSoy().equals("compra")) {
                Proveedores[] proveedor = new Proveedores[50];
                int contador = 0;
                for (int i = 0; i < cPersonas; i++) {
                    if (personas[i].quienSoy().equals("Proveedor")) {
                        proveedor[contador] = (Proveedores) personas[i];
                        contador++;
                    }
                }

                ((Compra) transaccion[selecciona - 1]).modificar();
            } else {
                System.out.println("Esa compra no existe ");
                error = 1;
            }
        } while (error == 1);
    }

    public void eliminarCompra() {
        Scanner datos = new Scanner(System.in);
        int selecciona;
        int opcion = 0;
        do {
            opcion = 0;
            for (int i = 0; i < cTransaccion; i++) {
                if (transaccion[i].isVigente() == true && transaccion[i].queSoy().equals("compra")) {
                    System.out.println(i + 1 + ".-" + transaccion[i]);
                }
            }
            System.out.println("Selecione la compra:");
            selecciona = datos.nextInt();
            if (transaccion[selecciona - 1].isVigente() == true
                    && transaccion[selecciona - 1].queSoy().equals("compra")) {
                ((Compra) transaccion[selecciona - 1]).eliminar();
            } else {
                System.out.println("Esa compra no existe");
            }
            System.out.println("Quiere seguir eliminando?   1.-Si   2.-No");
            opcion = datos.nextInt();
        } while (opcion == 1);
    }

    public void buscarCompra() {
        Scanner leer = new Scanner(System.in);
        int error = 0;
        int opcion = 0;
        do {
            error = 0;
            opcion = 0;
            System.out.println("Ponga el texto que desea buscar");
            String cadenaAbuscar = leer.next();
            for (int i = 0; i < cTransaccion; i++) {
                if (transaccion[i].queSoy().equals("compra")) {
                    if (((Compra) transaccion[i]).buscar(cadenaAbuscar) == true && transaccion[i].isVigente() == true) {
                        ((Compra) transaccion[i]).mostrar();
                        ((Compra) transaccion[i]).getDetalles();
                        error++;
                    }
                }

            }
            if (error == 0) {
                System.out.println("No se encontraron resultados");
            }
            System.out.println("Desea continuar?   1.-Si   2.-No");
            opcion = leer.nextInt();
        } while (opcion == 1);
    }
    // fin funciones de compra

    // generar archivos

    public void generarArchivoInventario() {
        FileOutputStream archivoSalida = null;
        try {
            archivoSalida = new FileOutputStream("Inventario.dat");
            ObjectOutputStream flujoSalida = new ObjectOutputStream(archivoSalida);
            System.out.println("generando Inventario.dat...");
            // flujoSalida.writeObject(cInventarios);
            for (int i = 0; i < cInventarios; i++) {
                if (inventarios[i].getExistencia() == true) {
                    flujoSalida.writeObject(inventarios[i]);
                }
            }
            archivoSalida.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void cargarArchivoInventario() {
        System.out.println("Cargando los datos de las Inventario . . . ");
        try {
            FileInputStream archivoEntrada = new FileInputStream("Inventario.dat");
            ObjectInputStream flujoEntrada = new ObjectInputStream(archivoEntrada);
            // cInventarios = (int) flujoEntrada.readObject();
            // for (int i = 0; i < cInventarios; i++)
            cInventarios = 0;
            inventarios[cInventarios] = (Inventario) flujoEntrada.readObject();
            while (inventarios[cInventarios] != null) {
                inventarios[++cInventarios] = (Inventario) flujoEntrada.readObject();
            }
            flujoEntrada.close();
           
        } catch (Exception e) {
            System.err.println("Error, no se cargaron los datos inventario " + e);
        }
    }

    // cuidado al copiar pizzas usa <= y inventarios solo esta usando < en el for()
    public void generarArchivoPizzas() {
        FileOutputStream archivoSalida = null;
        try {
            archivoSalida = new FileOutputStream("Pizzas.dat");
            ObjectOutputStream flujoSalida = new ObjectOutputStream(archivoSalida);
            System.out.println("generando Pizzas.dat...");
           // flujoSalida.writeObject(cPizzas);
            for (int i = 0; i <= cPizzas; i++) {
                if(pizzas[i].getExistencia()==true){
                flujoSalida.writeObject(pizzas[i]);
            }
            }
            archivoSalida.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void cargarArchivoPizzas() {
        System.out.println("Cargando los datos de las Pizzas . . . ");
        try {
            FileInputStream archivoEntrada = new FileInputStream("Pizzas.dat");
            ObjectInputStream flujoEntrada = new ObjectInputStream(archivoEntrada);
            //cPizzas = (int) flujoEntrada.readObject();
            cPizzas=0;
            pizzas[cPizzas] = (Pizza) flujoEntrada.readObject();
            while(pizzas[cPizzas]!=null){
                pizzas[++cPizzas] = (Pizza) flujoEntrada.readObject();
            }
            flujoEntrada.close();
            System.out.println(cPizzas);
        } catch (Exception e) {
            System.err.println("Error, no se cargaron los datos pizza" + e);
            cPizzas--;
        }
    }

    public void generarArchivoPersonas() {
        FileOutputStream archivoSalida = null;
        try {
            archivoSalida = new FileOutputStream("Personas.dat");
            ObjectOutputStream flujoSalida = new ObjectOutputStream(archivoSalida);
            System.out.println("generando Personas.dat...");
        
            for (int i = 0; i <= cPersonas; i++) {
                if(personas[i].isVigente()==true){
                flujoSalida.writeObject(personas[i]);
            }
            }
            archivoSalida.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void cargarArchivoPersonas() {
        System.out.println("Cargando los datos de las Personas . . . ");
        try {
            FileInputStream archivoEntrada = new FileInputStream("Personas.dat");
            ObjectInputStream flujoEntrada = new ObjectInputStream(archivoEntrada);
            //cPizzas = (int) flujoEntrada.readObject();
            cPersonas=0;
            personas[cPersonas] = (Persona) flujoEntrada.readObject();
            while(personas[cPersonas]!=null){
                personas[++cPersonas] = (Persona) flujoEntrada.readObject();
            }
            flujoEntrada.close();
            
        } catch (Exception e) {
            System.err.println("datos cargados");
            cPersonas--;
        }
    }

    // funciones empleado
    public void listarEmpleados() {
        Scanner leer = new Scanner(System.in);
        for (int i = 0; i <= cPersonas; i++) {
            if (personas[i].quienSoy().equals("Empleado") && personas[i].isVigente() == true) {
                System.out.println(i + 1 + ".-" + ((Empleado) personas[i]));

            }
        }
        int empleado;
        int opcion;
        do {
            System.out.println("Mostrar informacion del empleado(ingrese numero del empleado):  ");
            empleado = leer.nextInt() - 1;
            if (empleado > cPersonas || empleado < 0) {
                System.err.println("es una seleccion incorrecta");
            } else if (personas[empleado].quienSoy().equals("Empleado") && personas[empleado].isVigente() == true) {
                ((Empleado) personas[empleado]).mostrar();
            } else {
                System.out.println("esto no es un empleado");
            }
            do {
                System.out.println("deseas ver la informacion de otro empleado? 1.-si 2.-no");
                opcion = leer.nextInt();
                if (opcion != 2 && opcion != 1) {
                    System.out.println("esa no es una opcion");
                    opcion = 3;
                }
            } while (opcion == 3);
        } while (opcion == 1);
    }

    public void listarEmpleo() {
        for (int i = 0; i <= cPersonas; i++) {
            if (personas[i].quienSoy().equals("Empleado") && personas[i].isVigente() == true) {
                System.out.println(i + 1 + ".-" + ((Empleado) personas[i]));

            }
        }
    }

    public void capturarEmpleado() {
        try {
            System.out.println("//////////////////////REGISTRO////////////////////////////77");
            Scanner datos = new Scanner(System.in);
            personas[++cPersonas] = new Empleado();
            ((Empleado) personas[cPersonas]).capturar();
            System.out.println("///////////////////USUARIO/////////////////////");
            Cuadrado.imprimirCuadrado(50, 4, "TU USUARIO ES: " + ((Empleado) personas[cPersonas]).getUsuario());
        } catch (InputMismatchException e) {
            System.err.println("CARACTER INVALIDO INSERTE UN NUMERO VAlIDO");
            cPersonas--;
        } catch (Exception e) {
            System.err.println("OCURRIO EL ERROR " + e);
            e.printStackTrace();
            cPersonas--;
        }
    }

    public void modificarEmpleado() {
        Scanner leer = new Scanner(System.in);
        int empleado;
        int opcion;
        do {
            listarEmpleo();
            System.out.println("que empleado deseas modificar? (ingrese numero de empleado):  ");
            empleado = leer.nextInt() - 1;
            if (empleado > cPersonas || empleado < 0) {
                System.err.println("es una seleccion incorrecta");
            } else if (personas[empleado].quienSoy().equals("Empleado") && personas[empleado].isVigente() == true) {
                ((Empleado) personas[empleado]).modificar();
            } else {
                System.out.println("esto no es un empleado");
            }
            do {
                System.out.println("deseas modificar otro empleado? 1.-si 2.-no");
                opcion = leer.nextInt();
                if (opcion != 2 && opcion != 1) {
                    System.out.println("esa no es una opcion");
                    opcion = 3;
                }
            } while (opcion == 3);
        } while (opcion == 1);
    }

    public void eliminarEmpleado() {
        Scanner leer = new Scanner(System.in);
        int empleado;
        int opcion;
        do {
            listarEmpleo();
            System.out.println("que empleado deseas eliminar? (ingrese numero de empleado):  ");
            empleado = leer.nextInt() - 1;
            if (empleado > cPersonas || empleado < 0) {
                System.err.println("es una seleccion incorrecta");
            } else if (personas[empleado].quienSoy().equals("Empleado") && personas[empleado].isVigente() == true) {
                personas[empleado].eliminar();
                System.out.println("SE ELIMINO A: " + ((Empleado) personas[empleado]));
            } else {
                System.out.println("esto no es un empleado");
            }
            do {
                System.out.println("deseas eliminar otro empleado? 1.-si 2.-no");
                opcion = leer.nextInt();
                if (opcion != 2 && opcion != 1) {
                    System.out.println("esa no es una opcion");
                    opcion = 3;
                }
            } while (opcion == 3);
        } while (opcion == 1);
    }

    public void buscarEmpleado() {
        Scanner leer = new Scanner(System.in);
        int opcion = 0;
        do {
            opcion = 0;
            System.out.println("INSERTE EL TEXTO QUE DESEA BUSCAR");
            String cadenaAbuscar = leer.next();
            int error = 0;
            for (int i = 0; i <= cPersonas; i++) {
                if (personas[i].buscar(cadenaAbuscar) == true && personas[i].quienSoy().equals("Empleado")) {
                    System.out.println("------------------------------");
                    ((Empleado) personas[i]).mostrar();
                    error++;
                }
            }
            if (error == 0) {
                System.out.println("No se han encontrado resultados");
            }
            System.out.println("Desea seguir buscando?   1.-Si   2.-No");
            opcion = leer.nextInt();
        } while (opcion == 1);
    }

    public Empleado[] getEmpleados() {
        Empleado[] empleado = new Empleado[50];
        int contador = 0;
        for (int i = 0; i <= cPersonas; i++) {
            if (personas[i].isVigente() == true && personas[i].quienSoy().equals("Empleado")) {
                empleado[contador] = ((Empleado) personas[i]);
                contador++;
            }
        }

        return empleado;
    }

    public int getCempleados() {
        int contador = 0;
        for (int i = 0; i <= cPersonas; i++) {
            if (personas[i].isVigente() == true && personas[i].quienSoy().equals("Empleado")) {
                contador++;
            }
        }
        return contador;

    }

    public String toString() {
        return nombre + " / " + correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setrfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getCorreo() {
        return correo;
    }

    public String getHorario() {
        return horario;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getrfc() {
        return rfc;
    }

    // fin funciones basicas set get to string.
}
