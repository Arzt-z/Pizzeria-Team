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
    private int cPartes;
    private int [] cInventarios = new int[4];
    public Pizza() {
        this.nombre = "nueva pizza";
    }

    public Pizza(String nombre, int size , int precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.size = size;
        this.diametro = 20+size*5;
        cInventarios[0]=0;
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

    public void calcularPrecio(){
        float multiplicador = (float)(this.diametro*this.diametro)/(40*40);
        Cuadrado.imprimirCuadradoDividido(50, 4,"area: "+(this.diametro*this.diametro),"multi "+ multiplicador);
        Cuadrado.imprimirCuadradoDividido(50, 4,"precio de prod: "+(int)(130*multiplicador),"precio venta"+(int)((130*multiplicador)*(2.0-(size/16.8))));

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
                Cuadrado.centrarEnXYPresicion(inventarios[i][f].getStock() +"g",30, i+1);
                Cuadrado.centrarEnXYPresicion(" | ",36,i+1);
                Cuadrado.centrarEnXYPresicion( inventarios[i][f].getPrecio()+"" , 37 , i+1);
            }
            Cuadrado.imprimirCuadrado();
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


}
