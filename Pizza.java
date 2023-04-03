import java.util.Scanner;
public class Pizza extends Cuadrado{

    private String nombre;
    private int size;
    private int precio ;
    private int id;
    private int popularidad;
    private Inventario[][] inventarios = new Inventario[50][4];
    private int cPartes;
    private int [] cInventarios = new int[4];
    public Pizza() {
    }

    public Pizza(String nombre, int size, int id) {
        this.nombre = nombre;
        this.size = size;
        this.id = id;
        cInventarios[0]=0;
    }

    public void listarIngredientes(){
        for (int f = 0; f < cPartes; f++){   
            imprimirCuadrado(50, 2 ,"----------Ingredientes seccion " + (f+1) +"----------");
            matriz=cuadrado(50, cInventarios[f]+4 );
            Cuadrado.centrarEnXY("Stock ",0.75, -((int)(cInventarios[f]/2))+-2);
            Cuadrado.centrarEnXY(" | ",1, -((int)(cInventarios[f]/2))+-2);
            Cuadrado.centrarEnXY("Precio ",1.35, -((int)(cInventarios[f]/2))+-2);
            for (int i = 0; i < cInventarios[f]; i++) {
                Cuadrado.centrarEnXYPresicion(i + 1 + ".-"+inventarios[i][f].getNombre(),5, -((int)(cInventarios[f]/2))+i-1);
                Cuadrado.centrarEnXY(inventarios[i][f].getStock() +"g",0.75, -((int)(cInventarios[f]/2))+i-1);
                Cuadrado.centrarEnXY(" | ",1, -((int)(cInventarios[f]/2))+i-1);
                Cuadrado.centrarEnXY( inventarios[i][f].getPrecio()+"" , 1.25 , -((int)(cInventarios[f]/2))+i-1);
            }
            imprimirCuadrado();
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
