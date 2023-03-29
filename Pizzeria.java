import java.util.*;
public class Pizzeria{
    private String nombre;
    private String domicilio;
    private String correo;
    private String horario;
    private String telefono;
    private String rfc;
    char[][] matriz;


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
        imprimirCuadrito(50, 4 ,nombre);

        //para multiples palabras en un mismo cuadrito 
        //asignar el tamano que sera la matriz, luego introducir la matriz
        // luego usar el centrarEnXY para escojer donde iran las palabras.
        matriz=cuadrito(50, 6 );
        centrarEnXY(matriz,domicilio,0,-1);
        centrarEnXY(matriz,"Correo: "+correo,0,0);
        centrarEnXY(matriz,"horario: "+ horario,0,1);
        imprimirCuadrito();

        //para imprimir 2 palabras en izquierda y derecha centrados con division al medio'
        imprimirCuadritoDividido(50, 4,"1.-Orden","2.-Menu");
        imprimirCuadritoDividido(50, 4,"3.-Inventario","4.-Compra");
        imprimirCuadritoDividido(50, 4,"5.-Proveedores","6.-Clientes");
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

    //funciones para cuadrito, considerar que es magia.

    public void imprimirCuadrito(int x,int y, String palabra){
        matriz=cuadrito(x,y );
        centrarEnXY(matriz,palabra,0,0);
        imprimirCuadrito();
    }

    public void imprimirCuadritoDividido(int x,int y, String palabra, String palabra2){
        matriz=cuadrito(x, y);
        for (int i = 0; i+1 < matriz[0].length-1; i++) {
            centrarEnXY(matriz,"|",0,i-((int)(matriz[0].length/2)-1));
        }
        centrarEnXY(matriz,palabra,-1,0);
        centrarEnXY(matriz,palabra2,1,0);
        imprimirCuadrito();
    }


    public void imprimirCuadrito(){
        for (int y = 0; y < matriz[0].length; y++) {
            for (int x = 0; x < matriz.length; x++) {
                System.out.print(matriz[x][y]); 
            }
            System.out.println();
        }
    }

    public char[][] centrarEnXY(char[][] matriz, String palabra,int posicion, int posicionY){
        int center = matriz.length/2;
        for (int y = 0; y < matriz[0].length; y++) {
            for (int x = 0; x < matriz.length; x++) {
                if (y == ((int)matriz[0].length/2)+posicionY && x >= (matriz.length/2 - palabra.length()/2)+((int)(center/2)*posicion) && x < (matriz.length/2 + palabra.length()/2 + palabra.length()%2)+((int)(center/2)*posicion)) {
                    matriz[x][y] = palabra.charAt((x - matriz.length/2 + palabra.length() / 2)-((center/2)*posicion));
                }
            }
        }
        return matriz;
    }

    public char[][] cuadrito(int horizontal, int vertical){
        char[][] matriz = new char[horizontal+1][vertical+1];
        char borde;
        char borde2;
        for (int y = 0; y <= vertical; y++) {
            for (int x = 0; x <= horizontal; x++) {
                borde = '/';
                borde2 = '|';
                if(y==0 || y==vertical){
                    matriz[x][y]=borde;
                }else{
                    if(x==0 || x==horizontal||x==1|| x==horizontal-1){
                        matriz[x][y]=borde2;
                    }else{
                        matriz[x][y]=' ';
                    }
                }
            }
        }
        return matriz;
    }
    //fin de funciones de cuadrito
}