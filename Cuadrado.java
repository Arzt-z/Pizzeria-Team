public class Cuadrado {
    static char[][]  matriz;
    //funciones para cuadrado, considerar que es magia.

    public static void imprimirCuadrado(int x,int y, String palabra){
        matriz=cuadrado(x,y );
        centrarEnXY(palabra,0,0);
        imprimirCuadrado();
    }

    public static void imprimirCuadradoDividido(int x,int y, String palabra, String palabra2){
        matriz=cuadrado(x, y);
        for (int i = 0; i+1 < matriz[0].length-1; i++) {
            centrarEnXY("|",0,i-((int)(matriz[0].length/2)-1));
        }
        centrarEnXY(palabra,-1,0);
        centrarEnXY(palabra2,1,0);
        imprimirCuadrado();
    }

    

    public static void imprimirCuadrado(){
        for (int y = 0; y < matriz[0].length; y++) {
            for (int x = 0; x < matriz.length; x++) {
                System.out.print(matriz[x][y]); 
            }
            System.out.println();
        }
    }

    public static void agregarAlListado(String palabra, int i, int tamano){
        centrarEnXYPresicion(palabra,3, -((int)(tamano/2))+i-1);
    }
    //centra la palabra en XY, -1 en posicion significa que la palabra estara centrada a 1/4 del cuadrado en x,
    //0 en posicion significa que se centrara en 1/2 del cuadrado en x, 1 en posicion significa que se centrara en 3/4 de x.
    //0 en posicionY significa 1/2 del cuadrado en Y, 1 en posicion Y significa 1 linea abajo del 1/2 de y
    public static char[][] centrarEnXY( String palabra,double posicion, int posicionY){
        int center = matriz.length/2-1;
        for (int y = 0; y < matriz[0].length; y++) {
            for (int x = 0; x < matriz.length; x++) {
                if (y == ((int)matriz[0].length/2)+posicionY && x >= (matriz.length/2 - palabra.length()/2)+((int)(center/2)*posicion) && x < (matriz.length/2 + palabra.length()/2 + palabra.length()%2)+(int)((center/2)*posicion)) {
                    matriz[x][y] = palabra.charAt((int)((x - matriz.length/2 + palabra.length() / 2)-((center/2)*posicion)));
                }
            }
        }
        return matriz;
    }
    //escribe la palabra en la posicion que se le de exactamente, la posicion y aun empiesa desde el centro
    public static char[][] centrarEnXYPresicion( String palabra,int posicion, int posicionY){
        for (int y = 0; y < matriz[0].length; y++) {
            for (int x = 0; x < matriz.length; x++) {
                if (y == posicionY+1 && x >  posicion+1 && x <  palabra.length()+posicion+2) {
                    matriz[x][y] = palabra.charAt((int)((x-posicion))-2);
                }
            }
        }
        return matriz;
    }

    public static char[][] cuadrado(int horizontal, int vertical){
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
