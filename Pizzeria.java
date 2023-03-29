import java.util.*;
public class Pizzeria extends Cuadrado {
    private String nombre;
    private String domicilio;
    private String correo;
    private String horario;
    private String telefono;
    private String rfc;


    public Pizzeria() {

    }

    public Pizzeria(String nombre, String domicilio, String correo, int horario, String telefono) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.correo = correo;
        this.horario = (horario/1000000)%100 + ":" + (horario/100000)%10 +  (horario/10000)%10 + "-" + (horario/100)%100 + ":" + (horario/10)%10 + horario%10 ;
        this.telefono = telefono;
    }

    public void mostrar(){
        
        //primero decir de que tamano sera la matriz x,y, 
        //luego darle la palabra a imprimir en cuadrito
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
        imprimirCuadradoDividido(50, 4,"1.-Orden","2.-Menu");
        imprimirCuadradoDividido(50, 4,"3.-Inventario","4.-Compra");
        imprimirCuadradoDividido(50, 4,"5.-Proveedores","6.-Clientes");
        //

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

}