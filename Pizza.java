import java.util.Scanner;
public class Pizza extends Cuadrado{

    private String nombre;
    private int size;
    private int precio ;
    private int id;
    private int popularidad;
    private Ingrediente[][] ingredientes = new Ingrediente[50][4];
    private int cPartes;
    private int [] cIngredientes = new int[4];
    public Pizza() {
    }

    public Pizza(String nombre, int size, int id) {
        this.nombre = nombre;
        this.size = size;
        this.id = id;
        cIngredientes[0]=0;
    }

    public void listarIngredientes(){
        for (int f = 0; f < cPartes; f++){   
            imprimirCuadrado(50, 2 ,"----------Ingredientes seccion " + (f+1) +"----------");
            matriz=cuadrado(50, cIngredientes[f]+4 );
            centrarEnXY(matriz,"Stock ",0.75, -((int)(cIngredientes[f]/2))+-2);
            centrarEnXY(matriz," | ",1, -((int)(cIngredientes[f]/2))+-2);
            centrarEnXY(matriz,"Precio ",1.35, -((int)(cIngredientes[f]/2))+-2);
            for (int i = 0; i < cIngredientes[f]; i++) {
                    centrarEnXYPresicion(matriz,i + 1 + ".-"+ingredientes[i][f].getNombre(),5, -((int)(cIngredientes[f]/2))+i-1);
                    centrarEnXY(matriz,ingredientes[i][f].getStockEnGramos() +"g",0.75, -((int)(cIngredientes[f]/2))+i-1);
                    centrarEnXY(matriz," | ",1, -((int)(cIngredientes[f]/2))+i-1);
                    centrarEnXY(matriz, ingredientes[i][f].getPrecioPorGramo()+"" , 1.25 , -((int)(cIngredientes[f]/2))+i-1);
            }
            imprimirCuadrado();
        } 
    }

    public void capturarIngrediente(Ingrediente ingredientesP,int seccion) {
        this.ingredientes[cIngredientes[seccion]++][seccion] = ingredientesP;
        
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
