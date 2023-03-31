import java.util.*;
public class Pizzeria extends Cuadrado {
    private String nombre;
    private String domicilio;
    private String correo;
    private String horario;
    private String telefono;
    private String rfc;
    private Ingrediente[] ingredientes = new Ingrediente[500];
    private int cIngredientes; 
    public Pizzeria() {

    }

    public Pizzeria(String nombre, String domicilio, String correo, int horario, String telefono) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.correo = correo;
        this.horario = (horario/1000000)%100 + ":" + (horario/100000)%10 +  (horario/10000)%10 + "-" + (horario/100)%100 + ":" + (horario/10)%10 + horario%10 ;
        this.telefono = telefono;
        inicializarIngredientes();
    }

    public void mostrar(){
        
        //primero decir de que tamano sera la matriz x,y, 
        //luego darle la palabra a imprimir, las funciones estan la clase cuadrado
        imprimirCuadrado(50, 4 ,nombre);

        //para multiples palabras en un mismo cuadrito 
        //asignar el tamano que sera la matriz, luego usar centrarEnXY
        //pasarle esa matriz , la palabra y la posicion X,Y, 0,0 es el centro 
        matriz=cuadrado(50, 6 );
        centrarEnXY(matriz,domicilio,0,-1);
        centrarEnXY(matriz,"Correo: "+correo,0,0);
        centrarEnXY(matriz,"horario: "+ horario,0,1);
        imprimirCuadrado();

        //para imprimir 2 palabras en izquierda y derecha centrados con division al medio'
        imprimirCuadradoDividido(50, 4,"1.-Menu","2.-Orden");
        imprimirCuadradoDividido(50, 4,"3.-Inventario","4.-Compra");
        imprimirCuadradoDividido(50, 4,"5.-Proveedores","6.-Clientes");
        //
        listarIngredientes() ;
        
    }

    protected void inicializarIngredientes() {
        ingredientes[0]=new Ingrediente("Queso mozzarella","Queso", 0);
        ingredientes[++cIngredientes]=new Ingrediente("Queso parmesano","queso", 0);
        ingredientes[++cIngredientes]=new Ingrediente("Queso cheddar","queso", 0);

        ingredientes[++cIngredientes]=new Ingrediente("Peperoni","carne", 0);
        ingredientes[++cIngredientes]=new Ingrediente("Salchicha","carne", 0);
        ingredientes[++cIngredientes]=new Ingrediente("Anchoas","carne", 0);
        ingredientes[++cIngredientes]=new Ingrediente("Salami","carne", 0);
        ingredientes[++cIngredientes]=new Ingrediente("Jamon","carne", 0);
        ingredientes[++cIngredientes]=new Ingrediente("Tocino","carne", 0);
        ingredientes[++cIngredientes]=new Ingrediente("Carne molida","carne", 0);

        ingredientes[++cIngredientes]=new Ingrediente("Cebolla","no carne", 0);
        ingredientes[++cIngredientes]=new Ingrediente("Pimiento verde","no carne", 0);
        ingredientes[++cIngredientes]=new Ingrediente("Pimiento rojo","no carne", 200);
        ingredientes[++cIngredientes]=new Ingrediente("Aceitunas","no carne", 0);
        ingredientes[++cIngredientes]=new Ingrediente("Champiñones","no carne", 0);
        ingredientes[++cIngredientes]=new Ingrediente("Ajo","no carne", 0);
        ingredientes[++cIngredientes]=new Ingrediente("Jalapeños","no carne", 0);
        ingredientes[++cIngredientes]=new Ingrediente("Piña","no carne", 0);
    }

    // funciones de ingredientes
    public void listarIngredientes() {
        imprimirCuadrado(50, 2 ,"----------Ingredientes----------");
        matriz=cuadrado(50, cIngredientes+4 );
        centrarEnXY(matriz,"Stock ",0.75, -((int)(cIngredientes/2))+-2);
        centrarEnXY(matriz," | ",1, -((int)(cIngredientes/2))+-2);
        centrarEnXY(matriz,"Precio ",1.35, -((int)(cIngredientes/2))+-2);
        for (int i = 0; i <= cIngredientes; i++) {
                centrarEnXYPresicion(matriz,i + 1 + ".-"+ingredientes[i].getNombre(),5, -((int)(cIngredientes/2))+i-1);
                centrarEnXY(matriz,ingredientes[i].getStockEnGramos() +"g",0.75, -((int)(cIngredientes/2))+i-1);
                centrarEnXY(matriz," | ",1, -((int)(cIngredientes/2))+i-1);
                centrarEnXY(matriz, ingredientes[i].getPrecioPorGramo()+"" , 1.25 , -((int)(cIngredientes/2))+i-1);
        }
        imprimirCuadrado();
    }
    //fin funciones de ingredientes

    //funciones basicas set get to string.
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