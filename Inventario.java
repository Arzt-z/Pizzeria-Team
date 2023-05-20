import java.io.Serializable;
import java.util.Scanner;
public class Inventario implements Serializable{
    private String nombre;
    private int stock;
    private double precio;
    private boolean existencia;
    private transient Scanner datos =new Scanner(System.in);
    private String tipo;

    public Inventario(){   
        existencia=true;
    }

    public Inventario(String nombre, String tipo, double precio){
    this.nombre = nombre;
    this.tipo=tipo;
    this.precio = precio;
    existencia=true;
    }

    public String toString() {
        if(tipo.equals("carne") || tipo.equals("no carne") || tipo.equals("queso")){
            return nombre+" - stock: "+ stock +"g";
        }else{
            return nombre+" - stock: "+ stock;
        }

    }

    public void mostrar(){
        Cuadrado.matriz=Cuadrado.cuadrado(50, 6 );
        Cuadrado.centrarEnXYPresicion("nombre: " + nombre,12, 0);
        Cuadrado.centrarEnXYPresicion("tipo: " + tipo, 12 , 1);
        Cuadrado.centrarEnXYPresicion("stock: " + stock,12, 2);
        Cuadrado.centrarEnXYPresicion("precio: " + precio,12, 3);
        Cuadrado.imprimirCuadrado();
    }

    public void capturar(){
        Cuadrado.imprimirCuadrado(50, 3 ,"INGRESAR NOMBRE");
        nombre = datos.nextLine();
        Cuadrado.imprimirCuadrado(50, 3 ,"INGRESAR TIPO");
        Cuadrado.imprimirCuadradoDividido(50, 2,"1.-carne","2.-no carne");
        Cuadrado.imprimirCuadradoDividido(50, 2,"3.-bebida","4.-producto");
		int option = datos.nextInt();
        if(option==1){
            this.tipo="carne";
            Cuadrado.imprimirCuadrado(50, 3 ,"INGRESAR PRECIO POR GRAMO");
        }
		if(option==2){
            this.tipo="no carne";
            Cuadrado.imprimirCuadrado(50, 3 ,"INGRESAR PRECIO POR GRAMO");
        }
		if(option==3){
            this.tipo="bebida";
            Cuadrado.imprimirCuadrado(50, 3 ,"INGRESAR PRECIO");
        }
		if(option==4){
            this.tipo="producto";
            Cuadrado.imprimirCuadrado(50, 3 ,"INGRESAR PRECIO");
        }
        this.precio= datos.nextDouble();
	}
	
	public void modificar(){
        Scanner datos = new Scanner(System.in);
		int seguir;
		do{
            Cuadrado.imprimirCuadradoDividido(50, 2,"1.-nombre","2.-precio");
            int opcion = datos.nextInt();datos.nextLine();
            switch(opcion){
                case 1: Cuadrado.imprimirCuadrado(50, 3 ,"nuevo nombre");
                    nombre= datos.nextLine();
                break;
                case 2: Cuadrado.imprimirCuadrado(50, 3 ,"nuevo precio");
                    precio= datos.nextInt();
                break;
                case 0: 
                return;	
		}
        Cuadrado.imprimirCuadrado(50, 3 ,"deseas continuar?");
        Cuadrado.imprimirCuadradoDividido(50, 2,"1.-nsi","2.-no");
		seguir =datos.nextInt();
		}while(seguir == 1);
	}

    public boolean buscar(String cadenaAbuscar){
        String misDatos = nombre + stock + precio + tipo;
        misDatos=misDatos.toLowerCase();
        if (misDatos.contains(cadenaAbuscar.toLowerCase()) == true) {
            return true;
        }
        return false;
    }


    public void eliminar() {
        this.existencia = false;
    }

    public boolean getExistencia(){
        return existencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }


}