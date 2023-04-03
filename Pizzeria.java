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

    protected void inicializarinventarios() {
        inventarios[0]=new Inventario("Queso mozzarella","Queso", 0);
        inventarios[++cInventarios]=new Inventario("Queso parmesano","queso", 0);
        inventarios[++cInventarios]=new Inventario("Queso cheddar","queso", 0);

        inventarios[++cInventarios]=new Inventario("Peperoni","carne", 0);
        inventarios[++cInventarios]=new Inventario("Salchicha","carne", 0);
        inventarios[++cInventarios]=new Inventario("Anchoas","carne", 0);
        inventarios[++cInventarios]=new Inventario("Salami","carne", 0);
        inventarios[++cInventarios]=new Inventario("Jamon","carne", 0);
        inventarios[++cInventarios]=new Inventario("Tocino","carne", 0);
        inventarios[++cInventarios]=new Inventario("Carne molida","carne", 0);

        inventarios[++cInventarios]=new Inventario("Cebolla","no carne", 0);
        inventarios[++cInventarios]=new Inventario("Pimiento verde","no carne", 0);
        inventarios[++cInventarios]=new Inventario("Pimiento rojo","no carne", 200);
        inventarios[++cInventarios]=new Inventario("Aceitunas","no carne", 0);
        inventarios[++cInventarios]=new Inventario("Champiñones","no carne", 0);
        inventarios[++cInventarios]=new Inventario("Ajo","no carne", 0);
        inventarios[++cInventarios]=new Inventario("Jalapeños","no carne", 0);
        inventarios[++cInventarios]=new Inventario("Piña","no carne", 0);
    }

    protected void inicializarPizzas() {
        pizzas[0]=new Pizza("Hawaiana",3, 199);
        pizzas[++cPizzas]=new Pizza("peperoni",3, 199);
        pizzas[++cPizzas]=new Pizza("jamon",3, 199);
        pizzas[++cPizzas]=new Pizza("mexicana",3, 199);
        pizzas[++cPizzas]=new Pizza("loca",3, 199);
    }
    // funciones de inventarios
    public void listarinventarios() {
        Cuadrado.imprimirCuadrado(50, 2 ,"----------inventarios----------");
        Cuadrado.matriz=Cuadrado.cuadrado(50, cInventarios+4 );
        Cuadrado.centrarEnXYPresicion("Stock ",30, 0);
        Cuadrado.centrarEnXYPresicion("|",36, 0);
        Cuadrado.centrarEnXYPresicion("Precio",37, 0);
        for (int i = 0; i <= cInventarios; i++) {
                Cuadrado.centrarEnXYPresicion(i + 1 + ".-"+inventarios[i].getNombre(),4,i+1);
                Cuadrado.centrarEnXYPresicion(inventarios[i].getStock()+"g",30, i+1);
                Cuadrado.centrarEnXYPresicion("| ",36, i+1);
                Cuadrado.centrarEnXYPresicion( inventarios[i].getPrecio()+"" , 37 , i+1);
        }
        Cuadrado.imprimirCuadrado();
    }
    //fin funciones de inventarios


    //funciones pizza
    public void listarPizza(){
        Cuadrado.imprimirCuadrado(50, 2 ,"----------Pizzas----------");
        Cuadrado.matriz=Cuadrado.cuadrado(50, cPizzas+4 );
        Cuadrado.centrarEnXYPresicion("Precio ",37,0);
        for(int i=0;i<cPizzas;i++){
            Cuadrado.centrarEnXYPresicion(i + 1 + ".-" + pizzas[i].toString(),3, i+1);
            Cuadrado.centrarEnXYPresicion(pizzas[i].getPrecio() +"$ ",38, 1+i);
        }   
        Cuadrado.imprimirCuadrado();
    }

    public void capturarPizza(){
        Scanner datos = new Scanner(System.in);
        pizzas[++cPizzas] = new Pizza();
        Cuadrado.imprimirCuadrado(50, 4 ,"------------PIZZA------------");
        Cuadrado.imprimirCuadrado(50, 3 ,"SELECCIONAR UN TAMAÑO");
        Cuadrado.imprimirCuadradoDividido(50, 4,"1.-Chica","2.-Mediana");
        Cuadrado.imprimirCuadradoDividido(50, 4,"3.-Grande","4.-Familiar");
        int size = datos.nextInt();
        int continuar;

        Cuadrado.imprimirCuadrado(50, 3 ,"PIZZA DIVIDIDA?");
        Cuadrado.imprimirCuadrado(50, 4 ,"1.-NO");
        Cuadrado.imprimirCuadradoDividido(50, 4,"2.-A la mitad","3.-En 4 partes");
        int divisionDP = datos.nextInt();
        if(divisionDP==3)divisionDP++;
        pizzas[cPizzas].setcPartes(divisionDP);
        for(int i=0;i<divisionDP;i++){
            do {
                Cuadrado.imprimirCuadrado(50, 3 ,"SELECCIONAR UN INGREDIENTE ");
                listarinventarios() ;
                if(divisionDP>=2)Cuadrado.imprimirCuadrado(50, 2 ,"Parte "+ (i+1));
                int opcion = datos.nextInt();
                pizzas[cPizzas].capturarIngrediente(inventarios[opcion-1] , i);
                Cuadrado.imprimirCuadrado(50, 3 ,"AGREGAR OTRO INGREDIENTE?");
                Cuadrado.imprimirCuadradoDividido(50, 2,"1.-SI","2.-NO");
                continuar = datos.nextInt();
            } while (continuar == 1);
        }
        pizzas[cPizzas].listarIngredientes();
        cPizzas++;
    
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