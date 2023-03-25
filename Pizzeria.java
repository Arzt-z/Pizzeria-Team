import java.util.*;
public class Pizzeria{
    private String nombre;
    private String domicilio;
    private String correo;
    private String horario;
    private String rfc;
    char[][] matriz;


    public Pizzeria() {

    }

    public Pizzeria(String nombre, String domicilio, String correo, String horario, String rfc) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.correo = correo;
        this.horario = horario;
        this.rfc = rfc;
    }

    public void mostrar(){
        matriz=cuadrito(50, 4 , nombre);
        imprimirCuadrito(matriz, nombre);
        matriz=cuadrito(50, 6 , nombre);
        imprimirCuadrito(matriz, domicilio,"Correo: "+correo , "horario: "+ horario);
        imprimirCuadrito(matriz, "", "horario: ","","","");
    }


    public void imprimirCuadrito(char[][] matriz, String palabra){
        for (int y = 0; y < matriz[0].length; y++) {
            for (int x = 0; x < matriz.length; x++) {
                if (y == (int)matriz[0].length/2 && x >= matriz.length/2 - palabra.length()/2 && x < matriz.length/2 + palabra.length()/2 + palabra.length()%2) {
                    matriz[x][y] = palabra.charAt(x - matriz.length/2 + palabra.length() / 2);
                }
                System.out.print(matriz[x][y]); 
            }
            System.out.println();
        }
    }
    public void imprimirCuadrito(char[][] matriz, String palabra,String palabra2, String palabra3){
        for (int y = 0; y < matriz[0].length; y++) {
            for (int x = 0; x < matriz.length; x++) {
                matriz=centrarEnY(matriz, palabra, -1);
                matriz=centrarEnY(matriz, palabra2, 0);
                matriz=centrarEnY(matriz, palabra3, 1);
                System.out.print(matriz[x][y]); 
            }
            System.out.println();
        }
    }

    public void imprimirCuadritoDividido(char[][] matriz, String palabra,String palabra2){
        for (int y = 0; y < matriz[0].length; y++) {
            for (int x = 0; x < matriz.length; x++) {
                matriz=centrarEnY(matriz, palabra, -1);
                matriz=centrarEnY(matriz, palabra2, 0);
                matriz=centrarEnY(matriz, palabra3, 1);
                System.out.print(matriz[x][y]); 
            }
            System.out.println();
        }
    }

    public char[][] centrarEnY(char[][] matriz, String palabra,int posicion){
        for (int y = 0; y < matriz[0].length; y++) {
            for (int x = 0; x < matriz.length; x++) {
                if (y == ((int)matriz[0].length/2)+posicion && x >= matriz.length/2 - palabra.length()/2 && x < matriz.length/2 + palabra.length()/2 + palabra.length()%2) {
                    matriz[x][y] = palabra.charAt(x - matriz.length/2 + palabra.length() / 2);
                }
            }
        }
        return matriz;
    }


    public char[][] cuadrito(int horizontal, int vertical , String palabra){
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

    public String getrfc() {
        return rfc;
    }

}