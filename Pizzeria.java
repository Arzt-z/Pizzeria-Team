import java.util.*;
public class Pizzeria{
    private String nombre;
    private String domicilio;
    private String correo;
    private String horario;
    private String telefono;
    private String rfc;
    private Inventario[] inventarios = new Inventario[500];
    private int cInventarios;
    private Pizza[] pizzas = new Pizza[500];
    private int cPizzas=0;
	private ExtrasOProductos[] extras=new ExtrasOProductos[500];
	private int cExtras=0;
    
	
	public Pizzeria() {

    }

    public Pizzeria(String nombre, String domicilio, String correo, int horario, String telefono) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.correo = correo;
        this.horario = (horario/1000000)%100 + ":" + (horario/100000)%10 +  (horario/10000)%10 + "-" + (horario/100)%100 + ":" + (horario/10)%10 + horario%10 ;
        this.telefono = telefono;
        inicializarinventarios();
        inicializarPizzas();
    }

    public void mostrar(){
        
        //primero decir de que tamano sera la matriz x,y, 
        //luego darle la palabra a imprimir en cuadrito,las funciones estan la clase cuadrado
        Cuadrado.imprimirCuadrado(50, 4 ,nombre);

        //para multiples palabras en un mismo cuadrito 
        //asignar el tamano que sera la matriz, luego usar centrarEnXY
        //pasarle esa matriz , la palabra y la posicion X,Y, 0,0 es el centro 
        Cuadrado.matriz=Cuadrado.cuadrado(50, 6 );
        Cuadrado.centrarEnXY(domicilio,0,-1);
        Cuadrado.centrarEnXY("Correo: "+correo,0,0);
        Cuadrado.centrarEnXY("horario: "+ horario,0,1);
        Cuadrado.imprimirCuadrado();
        
    }
	
	protected void inicializaExtras(){
        extras[0]=new ExtrasOProductos("orden de papas", "producto", 20);
        extras[++cExtras]=new ExtrasOProductos("orden de bonneless", "producto", 50);
        extras[++cExtras]=new ExtrasOProductos("refresco de cola", "bebida", 15);
        extras[++cExtras]=new ExtrasOProductos("refresco de manzana", "bebida", 15);
        extras[++cExtras]=new ExtrasOProductos("refresco de naranaj", "bebida", 15);
        extras[++cExtras]=new ExtrasOProductos("palitos de queso", "producto", 20);
        extras[++cExtras]=new ExtrasOProductos("salsa secreta de la casa", "extra", 10);
        extras[++cExtras]=new ExtrasOProductos("dip de BBQ", "extra", 15);
		
	}
	
    protected void inicializarinventarios() {
        //
        inventarios[0]=new Inventario("Queso mozzarella","Queso", 0.3);
        inventarios[++cInventarios]=new Inventario("Queso parmesano","queso", 0.26);
        inventarios[++cInventarios]=new Inventario("Peperoni","carne", 0.6);
        inventarios[++cInventarios]=new Inventario("Salchicha","carne", 0.08);
        inventarios[++cInventarios]=new Inventario("Anchoas","carne", 1.0);
        inventarios[++cInventarios]=new Inventario("Salami","carne", 0.67);
        inventarios[++cInventarios]=new Inventario("Jamon","carne", 0.14);
        inventarios[++cInventarios]=new Inventario("Tocino","carne", 0.32);
        inventarios[++cInventarios]=new Inventario("Carne molida","carne", 0.16);
        inventarios[++cInventarios]=new Inventario("Chorizo","carne", 0.12);

        inventarios[++cInventarios]=new Inventario("Cebolla","no carne", 0.016);
        inventarios[++cInventarios]=new Inventario("tomate","no carne", 0.016);
        inventarios[++cInventarios]=new Inventario("Pimiento verde","no carne", 0.06);
        inventarios[++cInventarios]=new Inventario("Pimiento rojo","no carne", 0.06);
        inventarios[++cInventarios]=new Inventario("Aceitunas","no carne", 0.06);
        inventarios[++cInventarios]=new Inventario("Champiñones","no carne", 0.07);
        inventarios[++cInventarios]=new Inventario("Ajo","no carne", 0.05);
        inventarios[++cInventarios]=new Inventario("Jalapeños","no carne", 0.05);
        inventarios[++cInventarios]=new Inventario("Piña","no carne", 0.013);
    
        inventarios[++cInventarios]=new Inventario("orden de papas", "producto", 20);
        inventarios[++cInventarios]=new Inventario("orden de bonneless", "producto", 50);
        inventarios[++cInventarios]=new Inventario("refresco de cola", "bebida", 15);
        inventarios[++cInventarios]=new Inventario("refresco de manzana", "bebida", 15);
        inventarios[++cInventarios]=new Inventario("refresco de naranaj", "bebida", 15);
        inventarios[++cInventarios]=new Inventario("palitos de queso", "producto", 20);
        inventarios[++cInventarios]=new Inventario("salsa secreta", "extra", 10);
        inventarios[++cInventarios]=new Inventario("dip de BBQ", "extra", 15);
    }

    protected void inicializarPizzas() {
        pizzas[0]=new Pizza("Hawaiana",3, 199);
        pizzas[cPizzas].capturarIngrediente(inventarios[6] , 0);
        pizzas[cPizzas].capturarIngrediente(inventarios[18] , 0);

        pizzas[++cPizzas]=new Pizza("peperoni",3, 199);
        pizzas[cPizzas].capturarIngrediente(inventarios[2] , 0);

        pizzas[++cPizzas]=new Pizza("jamon",3, 199);
        pizzas[cPizzas].capturarIngrediente(inventarios[6] , 0);

        pizzas[++cPizzas]=new Pizza("mexicana",3, 199);
        pizzas[cPizzas].capturarIngrediente(inventarios[10] , 0);
        pizzas[cPizzas].capturarIngrediente(inventarios[9] , 0);
        pizzas[cPizzas].capturarIngrediente(inventarios[8] , 0);
        pizzas[cPizzas].capturarIngrediente(inventarios[17] , 0);

        pizzas[++cPizzas]=new Pizza("loca",3, 199);
        pizzas[cPizzas].capturarIngrediente(inventarios[9] , 0);
    }
    // funciones de inventarios
    public void listarinventarios() {
        int contador=0;
        for (int i = 0; i <= cInventarios; i++) {
            if(inventarios[i].getExistencia()==true){
                    contador++;
            }
            
        }
        Cuadrado.imprimirCuadrado(50, 2 ,"----------inventarios----------");
        Cuadrado.matriz=Cuadrado.cuadrado(50, contador+4 );
        Cuadrado.centrarEnXYPresicion("Stock ",30, 0);
        Cuadrado.centrarEnXYPresicion("|",36, 0);
        Cuadrado.centrarEnXYPresicion("Precio",37, 0);
        for (int i = 0 , c=0; i <= cInventarios; i++) {
            if(inventarios[i].getExistencia()==true){
                c++;
                Cuadrado.centrarEnXYPresicion(i + 1 + ".-"+inventarios[i].getNombre(),4,c+1);
                Cuadrado.centrarEnXYPresicion(inventarios[i].getStock()+"",30, c+1);
                if(inventarios[i].getTipo().toLowerCase().equals("carne")||inventarios[i].getTipo().toLowerCase().equals("no carne")||inventarios[i].getTipo().toLowerCase().equals("queso")||inventarios[i].getTipo().toLowerCase().equals("ingrediente"))
                    Cuadrado.centrarEnXYPresicion("g",35, c+1);
                Cuadrado.centrarEnXYPresicion("| ",36, c+1);
                Cuadrado.centrarEnXYPresicion( (float)(inventarios[i].getPrecio())+"" , 37 , c+1);
            
            }
        }
        Cuadrado.imprimirCuadrado();
    }

    public void listarinventarios(String tipo) {
        Cuadrado.imprimirCuadrado(50, 2 ,"----------inventarios----------");
        int contador=0;
        for (int i = 0; i <= cInventarios; i++) {
            if(inventarios[i].getExistencia()==true){
                if(inventarios[i].getTipo().equals(tipo)||
                ((inventarios[i].getTipo().toLowerCase().equals("carne")||inventarios[i].getTipo().toLowerCase().equals("no carne")||inventarios[i].getTipo().toLowerCase().equals("queso")||inventarios[i].getTipo().toLowerCase().equals("ingrediente"))
                &&(tipo.toLowerCase().equals("ingrediente")))){
                    contador++;
                }
            }
            
        }
        Cuadrado.matriz=Cuadrado.cuadrado(50, contador+3 );
        Cuadrado.centrarEnXYPresicion("Stock ",30, 0);
        Cuadrado.centrarEnXYPresicion("|",36, 0);
        Cuadrado.centrarEnXYPresicion("Precio",37, 0);
        for (int i = 0, c=0; i <= cInventarios; i++) {
            if(inventarios[i].getExistencia()==true){
                if(inventarios[i].getTipo().equals(tipo)||
                ((inventarios[i].getTipo().toLowerCase().equals("carne")||inventarios[i].getTipo().toLowerCase().equals("no carne")||inventarios[i].getTipo().toLowerCase().equals("queso")||inventarios[i].getTipo().toLowerCase().equals("ingrediente"))
                &&(tipo.toLowerCase().equals("ingrediente")))){
                    Cuadrado.centrarEnXYPresicion(i + 1 + ".-"+inventarios[i].getNombre(),4,c+1);
                    Cuadrado.centrarEnXYPresicion(inventarios[i].getStock()+"",30, c+1);
                    if(inventarios[i].getTipo().toLowerCase().equals("carne")||inventarios[i].getTipo().toLowerCase().equals("no carne")||inventarios[i].getTipo().toLowerCase().equals("queso")||inventarios[i].getTipo().toLowerCase().equals("ingrediente"))
                        Cuadrado.centrarEnXYPresicion("g",35, c+1);
                    Cuadrado.centrarEnXYPresicion("| ",36, c+1);
                        Cuadrado.centrarEnXYPresicion( (float)(inventarios[i].getPrecio())+"" , 37 , c+1);
                }
            }
            

        }
        Cuadrado.imprimirCuadrado();
    }

    public void inspeccionarInventario(){
        Scanner datos = new Scanner(System.in);
        int continuar =1;
        int seleccion=0;
        do {
            if(continuar!=1)return;
            seleccion=seleccionInventarios();
            if(seleccion==0){
                return;
            }
            if(inventarios[seleccion-1].getExistencia()){
                inventarios[seleccion-1].mostrar();
                Cuadrado.imprimirCuadrado(50, 3 ,"deseas ver otro?");
                Cuadrado.imprimirCuadradoDividido(50, 2,"1.-si","2.-no");
            }else{
                Cuadrado.imprimirCuadrado(50, 3 ,"ELEMENTO INVALIDO INTENTAR OTRA VEZ?");
                Cuadrado.imprimirCuadradoDividido(50, 2,"1.-si","2.-no");
            }
            continuar = datos.nextInt();
        } while (continuar==1);
    }

    public void capturarInventarios() {
        Scanner datos = new Scanner(System.in);
        int continuar =1;
        do {
            listarinventarios();
            inventarios[++cInventarios]=new Inventario();
            inventarios[cInventarios].capturar();
            Cuadrado.imprimirCuadrado(50, 3 ,"desea capturar otro?");
            Cuadrado.imprimirCuadradoDividido(50, 2,"1.-si","2.-no");
            continuar = datos.nextInt();
        } while (continuar==1);
    }

    public void modificarInventarios(){
        Scanner datos = new Scanner(System.in);
        int seleccion=0;
        int continuar =1;
        seleccion=seleccionInventarios();
        do {
            inventarios[seleccion].modificar();
            Cuadrado.imprimirCuadrado(50, 3 ,"desea modificar otro?");
            Cuadrado.imprimirCuadradoDividido(50, 2,"1.-si","2.-no");
            continuar = datos.nextInt();
        } while (continuar==1);
        
    }

    public void buscarInventarios(){
        Scanner datos = new Scanner(System.in);
        int continuar =1;
        String cadenaAbuscar;
        do {
            System.out.println("TEXTO A BUSCAR");
            cadenaAbuscar = datos.nextLine();
            for (int i = 0; i < cInventarios; i++) {
                if (inventarios[i].buscar(cadenaAbuscar) == true && inventarios[i].getExistencia() == true) {
                    inventarios[i].mostrar();
                }
            }
            Cuadrado.imprimirCuadrado(50, 3 ,"BUSCAR OTRA VEZ?");
            Cuadrado.imprimirCuadradoDividido(50, 2,"1.-SI","2.-NO");
            continuar = datos.nextInt(); datos.nextLine();
        } while (continuar == 1);
    }

    public void eliminarInventarios(){
        Scanner datos = new Scanner(System.in);
        int seleccion=0;
        int continuar =1;
        do{
            Cuadrado.imprimirCuadrado(50, 2 ,"----------inventarios----------");
            Cuadrado.matriz=Cuadrado.cuadrado(50, cInventarios+4 );
            Cuadrado.centrarEnXYPresicion("Stock ",30, 0);
            Cuadrado.centrarEnXYPresicion("|",36, 0);
            Cuadrado.centrarEnXYPresicion("Precio",37, 0);
            for (int i = 0; i <= cInventarios; i++) {
                if(inventarios[i].getExistencia()==true){
                    Cuadrado.centrarEnXYPresicion(i + 1 + ".-"+inventarios[i].getNombre(),4,i+1);
                    Cuadrado.centrarEnXYPresicion(inventarios[i].getStock()+"g",30, i+1);
                    Cuadrado.centrarEnXYPresicion("| ",36, i+1);
                    Cuadrado.centrarEnXYPresicion( (float)(inventarios[i].getPrecio()*100)+"" , 37 , i+1);
                }else{
                    Cuadrado.centrarEnXYPresicion(i + 1 + ".-"+"//////ELIMINADO//////",4,i+1);
                }
            }
            Cuadrado.imprimirCuadrado();
            Cuadrado.imprimirCuadrado(50, 2 ,"---INGRESAR NUMERO---");
            System.out.println("0.-Salir");
            seleccion= datos.nextInt();
            if(seleccion==0){
                return;
            }
            inventarios[seleccion-1].eliminar();

        }while(continuar == 1);
    }

    
    public int seleccionInventarios(){
        Scanner datos = new Scanner(System.in);
        int seleccion=0;
        int continuar =1;
            listarinventarios();
            Cuadrado.imprimirCuadrado(50, 2 ,"---INGRESAR NUMERO---");
            System.out.println("0.-Salir");
            seleccion= datos.nextInt();
            if(seleccion==0){
                return 0;
            }
            return seleccion;
    }



    //fin funciones de inventarios


    //funciones pizza
    public void listarPizza(){
        Scanner datos = new Scanner(System.in);
        int continuar =1;
        int seleccion=0;
        do {
            mostarPizzas();
            if(continuar!=1)return;
            Cuadrado.imprimirCuadrado(50, 3 ,"selecciona una pizza");
            seleccion= datos.nextInt();
            if(pizzas[seleccion-1].getExistencia()){
                pizzas[seleccion-1].mostrar();
                Cuadrado.imprimirCuadrado(50, 3 ,"deseas ver otra pizza?");
                Cuadrado.imprimirCuadradoDividido(50, 2,"1.-si","2.-no");
            }else{
                Cuadrado.imprimirCuadrado(50, 3 ,"PIZZA INVALIDA INTENTAR OTRA VEZ?");
                Cuadrado.imprimirCuadradoDividido(50, 2,"1.-si","2.-no");
            }
            continuar = datos.nextInt();
        } while (continuar==1);
    }

    public void mostarPizzas(){
        Cuadrado.imprimirCuadrado(50, 2 ,"----------Pizzas----------");
            Cuadrado.matriz=Cuadrado.cuadrado(50, cPizzas+4 );
            Cuadrado.centrarEnXYPresicion("Precio ",37,0);
            for(int i=0;i<=cPizzas;i++){
                if(pizzas[i].getExistencia()){
                    Cuadrado.centrarEnXYPresicion(i + 1 + ".-" + pizzas[i].toString(),3, i+1);
                    Cuadrado.centrarEnXYPresicion(pizzas[i].getPrecio() +"$ ",38, 1+i);
                }
            }
            Cuadrado.imprimirCuadrado();
    }

    public void capturarPizza(){
        Scanner datos = new Scanner(System.in);
        pizzas[++cPizzas] = new Pizza();
        Cuadrado.imprimirCuadrado(50, 4 ,"------------PIZZA------------");
        tamanoPizza(cPizzas);
        dividirPizza(cPizzas);
        seleccionarIngredientePizza(cPizzas);
        pizzas[cPizzas].listarIngredientes();
        pizzas[cPizzas].calcularPrecio();
        pizzas[cPizzas].calcularTodosLosIngredientes();
    }

    public void eliminarPizza() {
        Scanner datos = new Scanner(System.in);
        int seleccion=0;
        int continuar =1;
        do{
            mostarPizzas();
            Cuadrado.imprimirCuadrado(50, 3 ,"---SELECCIONA LA PIZZA A ELIMINAR---");
            seleccion= datos.nextInt();
            pizzas[seleccion-1].eliminar();
            Cuadrado.imprimirCuadrado(50, 3 ,"ELIMINAR OTRA PIZZA?");
            Cuadrado.imprimirCuadradoDividido(50, 2,"1.-SI","2.-NO");
            continuar = datos.nextInt();
        }while(continuar == 1);
    }

    public void modificarPizza() {
        Scanner datos = new Scanner(System.in);
        int seleccion=0;
        int continuar =1;
        int opcionMod=0;
        mostarPizzas();
        Cuadrado.imprimirCuadrado(50, 3 ,"---SELECCIONA LA PIZZA A MODIFICAR---");
        seleccion= datos.nextInt()-1;
        do{
            Cuadrado.imprimirCuadrado(50, 3 ,"QUE DESEA MODIFICAR?");
            Cuadrado.imprimirCuadradoDividido(50, 4,"1.-Ingredientes","2.-Nombre");
            Cuadrado.imprimirCuadradoDividido(50, 4,"3.-Dividir en partes","4.-Tamano");
            Cuadrado.imprimirCuadrado(50, 4,"5.-Precio Fijo");
            opcionMod=datos.nextInt();
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
            Cuadrado.imprimirCuadrado(50, 3 ,"MODIFICAR ALGO MAS?");
            Cuadrado.imprimirCuadradoDividido(50, 2,"1.-SI","2.-NO");
            continuar = datos.nextInt();
        }while(continuar == 1);

    }

    public void nombrePizza(int seleccion){
        Scanner datos = new Scanner(System.in);
        Cuadrado.imprimirCuadrado(50, 3 ,"INGRESAR NOMBRE");
        String nombre = datos.nextLine();
        pizzas[seleccion].setNombre(nombre);
    }

    public void precioPizza(int seleccion){
        Scanner datos = new Scanner(System.in);
        Cuadrado.imprimirCuadrado(50, 3 ,"INGRESAR PRECIO");
        int precio = datos.nextInt();
        pizzas[seleccion].setPrecioFijo(true);
        pizzas[seleccion].setPrecio(precio);
    }

    public void tamanoPizza(int seleccion) {
        Scanner datos = new Scanner(System.in);
        Cuadrado.imprimirCuadrado(50, 3 ,"SELECCIONAR UN TAMAÑO");
        Cuadrado.imprimirCuadradoDividido(50, 4,"1.-Chica","2.-Mediana");
        Cuadrado.imprimirCuadradoDividido(50, 4,"3.-Grande","4.-Familiar");
        int size = datos.nextInt();
        pizzas[cPizzas].setSize(size);
    }



    public void dividirPizza(int seleccion) {
        Scanner datos = new Scanner(System.in);
        Cuadrado.imprimirCuadrado(50, 3 ,"PIZZA DIVIDIDA?");
        Cuadrado.imprimirCuadrado(50, 4 ,"1.-NO");
        Cuadrado.imprimirCuadradoDividido(50, 4,"2.-A la mitad","3.-En 4 partes");
        int divisionDP = datos.nextInt();
        if(divisionDP==3)divisionDP++;
        pizzas[seleccion].setcPartes(divisionDP);
    }

    public void seleccionarIngredientePizza(int seleccion){
        Scanner datos = new Scanner(System.in);
        int divisionDP=pizzas[seleccion].getcPartes();
        int continuar =1;
        for(int i=0;i<divisionDP;i++){
            do {
                Cuadrado.imprimirCuadrado(50, 3 ,"SELECCIONAR UN INGREDIENTE ");
                listarinventarios("ingrediente") ;
                if(divisionDP>=2)Cuadrado.imprimirCuadrado(50, 2 ,"Parte "+ (i+1));
                int opcion = datos.nextInt();
                pizzas[seleccion].capturarIngrediente(inventarios[opcion-1] , i);
                Cuadrado.imprimirCuadrado(50, 3 ,"AGREGAR OTRO INGREDIENTE?");
                Cuadrado.imprimirCuadradoDividido(50, 2,"1.-SI","2.-NO");
                continuar = datos.nextInt();
            } while (continuar == 1);
        }
    }


    public void buscarPizza() {
        Scanner datos = new Scanner(System.in);
        int continuar =1;
        do {
            System.out.println("TEXTO A BUSCAR");
            String cadenaAbuscar = datos.nextLine();
            for (int i = 0; i < cPizzas; i++) {
                if (pizzas[i].buscar(cadenaAbuscar) == true && pizzas[i].getExistencia() == true) {
                    pizzas[i].mostrar();
                }
            }
            Cuadrado.imprimirCuadrado(50, 3 ,"BUSCAR OTRA?");
            Cuadrado.imprimirCuadradoDividido(50, 2,"1.-SI","2.-NO");
            continuar = datos.nextInt();datos.nextLine();
        } while (continuar == 1);
    }

    //fin funciones pizza

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
    //fin funciones basicas set get to string.
}