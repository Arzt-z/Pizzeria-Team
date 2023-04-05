import java.util.Scanner;
public class Pizza{

    private String nombre;
    private int size;
    private int precio;
    private int precioProd=130;
    private int diametro;
    private int id;
    private int popularidad;
    private Inventario[][] inventarios = new Inventario[50][4];
    private int [] cInventarios = new int[4];
    private int cPartes;
    private float multiplicador;
    private Inventario[] ingredientes = new Inventario[500];
    private int cIngredientes = 0;
    private int extras=0;


    private int[] gramosIngrediente = new int[500];

    public Pizza() {
        this.nombre = "nueva pizza";
    }

    public Pizza(String nombre, int size , int precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.size = size;
        this.diametro = 20+size*5;
        cInventarios[0]=0;
        cPartes=1;
    }

    public String toString(){
        String tamano="";
        switch (size) {
            case 1:tamano="chica";break;
            case 2:tamano="mediana";break;
            case 3:tamano="grande";break;
            case 4:tamano="familiar";break;
            case 0:tamano="";
        }
        return "pizza " + nombre+" "+ tamano ;
    }

    public void MostrarCalcularPrecio(){
        multiplicador = (float)(this.diametro*this.diametro)/(40*40);
        Cuadrado.imprimirCuadradoDividido(50, 4,"area: "+(this.diametro*this.diametro),"multi "+ multiplicador);
        Cuadrado.imprimirCuadradoDividido(50, 4,"precio de prod: "+(int)((precioProd+extras)*multiplicador),"precio venta"+(int)(((precioProd+extras)* multiplicador)*(2.0-(size/16.8))));
    }

    public void calcularPrecio(){
        multiplicador = (float)(this.diametro*this.diametro)/(40*40);
        precio=(int)(((precioProd+extras)*multiplicador)*(2.0-(size/16.8)));
    }

    public void listarIngredientes(){
        for (int f = 0; f < cPartes; f++){
            Cuadrado.imprimirCuadrado(50, 3 ,nombre);
            Cuadrado.imprimirCuadrado(50, 2 ,"----------Ingredientes seccion " + (f+1) +"----------");
            Cuadrado.matriz=Cuadrado.cuadrado(50, cInventarios[f]+2 );
            Cuadrado.centrarEnXYPresicion("cantidad",27, 0);
            Cuadrado.centrarEnXYPresicion("|",36, 0);
            Cuadrado.centrarEnXYPresicion("Precio",37, 0);
            for (int i = 0; i < cInventarios[f]; i++) {
                Cuadrado.centrarEnXYPresicion(i + 1 + ".-"+inventarios[i][f].getNombre(),4, i+1);
                Cuadrado.centrarEnXYPresicion( 30/inventarios[i][f].getPrecio() +"g",29, i+1);
                Cuadrado.centrarEnXYPresicion("|",36,i+1);
                Cuadrado.centrarEnXYPresicion( inventarios[i][f].getPrecio()+"" , 37 , i+1);
            }
            Cuadrado.imprimirCuadrado();
        } 
    }

    public void calcularTodosLosIngredientes(){
        for (int f = 0; f < cPartes; f++){
            for (int i = 0; i < cInventarios[f]; i++) {
                ingredientes[cIngredientes]=inventarios[i][f];
                gramosIngrediente[cIngredientes]=(int)(30/ingredientes[cIngredientes].getPrecio());
                cIngredientes++;
            }
        } 
    }

    public Inventario[] getTodosLosIngredientes(){
        return ingredientes;
    }

    public int getcIngredientes() {
        return cIngredientes;
    }

    public void listarTodosLosIngredientes(){
        Cuadrado.imprimirCuadrado(50, 3 ,nombre);
        Cuadrado.imprimirCuadrado(50, 2 ,"----------todos los ingredientes ----------");
        Cuadrado.matriz=Cuadrado.cuadrado(50, cIngredientes+2 );
        Cuadrado.centrarEnXYPresicion("cantidad",27, 0);
        Cuadrado.centrarEnXYPresicion("|",36, 0);
        Cuadrado.centrarEnXYPresicion("Precio",37, 0);
        for (int i = 0; i < cIngredientes; i++) {
            Cuadrado.centrarEnXYPresicion(i + 1 + ".-"+ingredientes[i].getNombre(),4, i+1);
            Cuadrado.centrarEnXYPresicion(gramosIngrediente[i] +"g",30, i+1);
            Cuadrado.centrarEnXYPresicion("|",36,i+1);
            Cuadrado.centrarEnXYPresicion(ingredientes[i].getPrecio()+"" , 37 , i+1);
        }
        Cuadrado.imprimirCuadrado();
    }

    public void todosLosIngredientesListar(){
        for (int i = 0; i < cIngredientes; i++){
            Cuadrado.centrarEnXYPresicion(i + 1 + ".-"+ingredientes[i].getNombre(),4, i+1);
        }
        
    }

    public void capturarIngrediente(Inventario ingredientesP,int seccion) {
        this.inventarios[cInventarios[seccion]++][seccion] = ingredientesP;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
        this.diametro = 20+size*5;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(int popularidad) {
        this.popularidad = popularidad;
    }

    public int getcPartes() {
        return cPartes;
    }

    public void setcPartes(int cPartes) {
        this.cPartes = cPartes;
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }
    
    public int getPrecioProd() {
        return (int)((precioProd+extras)*multiplicador);
    }

    public void setPrecioProd(int precioProd) {
        this.precioProd = precioProd;
    }

    public int getExtras() {
        return extras;
    }

    public void setExtras(int extras) {
        this.extras = extras;
    }

}
