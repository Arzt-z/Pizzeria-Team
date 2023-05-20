import java.io.Serializable;
import java.util.Scanner;
public class Pizza implements Serializable{

    private String nombre;
    private int size;
    private int precio;
    private boolean precioFijo;


    private int precioProd=130;
    private int diametro=0;
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
    private boolean existencia=true;
    

    public Pizza() {
        this.nombre = "nueva pizza";
		this.precioFijo=false;
    }

    public Pizza(String nombre, int size , int precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.size = size;
        this.diametro = 20+size*5;
        cInventarios[0]=0;
        cPartes=1;
        precioFijo=true;
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

    public void mostrar(){
        listarTodosLosIngredientes();
        calcularPrecio();
        Cuadrado.matriz=Cuadrado.cuadrado(50, 4 );
        Cuadrado.centrarEnXYPresicion("area: ",4, 0); Cuadrado.centrarEnXYPresicion((diametro*diametro) +" cm^2",30, 0);
        Cuadrado.centrarEnXYPresicion("Precio produccion: ",4, 1);Cuadrado.centrarEnXYPresicion((precioProd+extras)+"$",30, 1);
        Cuadrado.centrarEnXYPresicion("Precio Venta: ",4, 2);Cuadrado.centrarEnXYPresicion(precio+"$",30, 2); 
        Cuadrado.imprimirCuadrado();
    }

    public void capturar(){
        listarIngredientes();
        calcularPrecio();
        calcularTodosLosIngredientes();
        MostrarCalcularPrecio();
    }

    public void MostrarCalcularPrecio(){
        multiplicador = (float)(this.diametro*this.diametro)/(40*40);
        Cuadrado.imprimirCuadradoDividido(50, 2,"area: "+(this.diametro*this.diametro),"multi "+ multiplicador);
        Cuadrado.imprimirCuadradoDividido(50, 2,"precio de prod: "+(int)((precioProd+extras)*multiplicador),"precio venta: "+(int)(((precioProd+extras)* multiplicador)*(2.0-(size/16.8))));
    }

    public void calcularPrecio(){
        if(precioFijo==false || precio==0){
            multiplicador = (float)(this.diametro*this.diametro)/(40*40);
            precio=(int)(((precioProd+extras)*multiplicador)*(2.0-(size/16.8)));
        }
    }

    public void listarIngredientes(){
        calcularTodosLosIngredientes();
        int xi=0;
        int yi=0;
        for (int f = 0; f < cPartes; f++){
            Cuadrado.imprimirCuadrado(50, 3 ,nombre);
            Cuadrado.imprimirCuadrado(50, 2 ,"----------Ingredientes seccion " + (f+1) +"----------");
            Cuadrado.matriz=Cuadrado.cuadrado(50, cInventarios[f]+2 );
            Cuadrado.centrarEnXYPresicion("cantidad",27, 0);
            Cuadrado.centrarEnXYPresicion("|",36, 0);
            Cuadrado.centrarEnXYPresicion("Precio",37, 0);
            for (int i = 0; i < cInventarios[f]; i++) {
                Cuadrado.centrarEnXYPresicion(i + 1 + ".-"+inventarios[i][f].getNombre(),4, i+1);
                
                if(ingredientes[i].getTipo().equalsIgnoreCase("carne")){
                    xi=((int)(((15/inventarios[i][f].getPrecio()+140)/cInventarios[f])/cPartes));
                }else{
                    xi=((int)(((15/(25*inventarios[i][f].getPrecio())+140)/cInventarios[f])/cPartes));
                }

                Cuadrado.centrarEnXYPresicion( xi +"g",29, i+1);
                Cuadrado.centrarEnXYPresicion("|",36,i+1);
                Cuadrado.centrarEnXYPresicion(  (int)(inventarios[i][f].getPrecio()*(xi)) +"" , 37 , i+1);
            }
            Cuadrado.imprimirCuadrado();
        } 

    }

    public void calcularTodosLosIngredientes(){
        cIngredientes=0;
        for (int f = 0; f < cPartes; f++){
            for (int i = 0; i < cInventarios[f]; i++) {
                ingredientes[cIngredientes]=inventarios[i][f];
                if(ingredientes[cIngredientes].getTipo().equalsIgnoreCase("carne")){
                    gramosIngrediente[cIngredientes]=((int)(15/ingredientes[cIngredientes].getPrecio()+140));
                }else{
                    gramosIngrediente[cIngredientes]=(int)(15/(25*ingredientes[cIngredientes].getPrecio())+140);
                }
                cIngredientes++;
            }
        } 
        for (int i = 0; i < cIngredientes; i++) {
            gramosIngrediente[cIngredientes]=gramosIngrediente[cIngredientes]/cIngredientes;
        }
    }

    public void listarTodosLosIngredientes(){
        calcularTodosLosIngredientes();
        Cuadrado.imprimirCuadrado(50, 3 ,nombre);
        Cuadrado.imprimirCuadrado(50, 2 ,"----------todos los ingredientes ----------");
        Cuadrado.matriz=Cuadrado.cuadrado(50, cIngredientes+2 );
        Cuadrado.centrarEnXYPresicion("cantidad",27, 0);
        Cuadrado.centrarEnXYPresicion("|",36, 0);
        Cuadrado.centrarEnXYPresicion("Precio",37, 0);
        for (int i = 0; i < cIngredientes; i++) {
            Cuadrado.centrarEnXYPresicion(i + 1 + ".-"+ingredientes[i].getNombre(),4, i+1);
            Cuadrado.centrarEnXYPresicion(gramosIngrediente[i]/cIngredientes +"g",30, i+1);
            Cuadrado.centrarEnXYPresicion("|",36,i+1);
            Cuadrado.centrarEnXYPresicion((int)(ingredientes[i].getPrecio()*(gramosIngrediente[i]/cIngredientes))+"" , 37 , i+1);
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

    public boolean buscar(String cadenaAbuscar) {
        String misDatos = nombre + cPartes + precio + diametro;
        calcularTodosLosIngredientes();
        for (int i = 0; i < cIngredientes; i++){
            misDatos=misDatos+ingredientes[i].getNombre();
        }
        misDatos=misDatos.toLowerCase();
        if (misDatos.contains(cadenaAbuscar.toLowerCase()) == true) {
            return true;
        }
        return false;
    }

    public void sustraerIngredientesAInventarios(int multiplicador){
        calcularTodosLosIngredientes();
            for (int i = 0; i < cIngredientes; i++) {
                ingredientes[i].setStock(inventarios[i][0].getStock()-((int)(gramosIngrediente[i]*multiplicador)));
            }
    }

    public void agregarIngredientesAInventarios(int multiplicador){
        calcularTodosLosIngredientes();
            for (int i = 0; i < cIngredientes; i++) {
                ingredientes[i].setStock(inventarios[i][0].getStock()+((int)(gramosIngrediente[i]*multiplicador)));
            }
    }


    //regresa una matriz con una lista de todos los ingredientes.
    public Inventario[] getTodosLosIngredientes(){
        return ingredientes;
    }
    //regresa la lista con los gramos usados de cada ingrediente usar junto con la de arriba.
    public int[] getGramosIngrediente() {
        return gramosIngrediente;
    }

    public int getcIngredientes() {
        return cIngredientes;
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

    public boolean getExistencia() {
        return existencia;
    }

    public void eliminar() {
        this.existencia = false;
    }

    public void setPrecioFijo(boolean precioFijo) {
        this.precioFijo = precioFijo;
    }

}
