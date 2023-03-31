public class Cuadrado {
    char[][] matriz;
    //funciones para cuadrado, considerar que es magia.

    public void imprimirCuadrado(int x,int y, String palabra){
        matriz=cuadrado(x,y );
        centrarEnXY(matriz,palabra,0,0);
        imprimirCuadrado();
    }

    public void imprimirCuadradoDividido(int x,int y, String palabra, String palabra2){
        matriz=cuadrado(x, y);
        for (int i = 0; i+1 < matriz[0].length-1; i++) {
            centrarEnXY(matriz,"|",0,i-((int)(matriz[0].length/2)-1));
        }
        centrarEnXY(matriz,palabra,-1,0);
        centrarEnXY(matriz,palabra2,1,0);
        imprimirCuadrado();
    }


    public void imprimirCuadrado(){
        for (int y = 0; y < matriz[0].length; y++) {
            for (int x = 0; x < matriz.length; x++) {
                System.out.print(matriz[x][y]); 
            }
            System.out.println();
        }
    }

    public char[][] centrarEnXY(char[][] matriz, String palabra,double posicion, int posicionY){
        int center = matriz.length/2;
        for (int y = 0; y < matriz[0].length; y++) {
            for (int x = 0; x < matriz.length; x++) {
                if (y == ((int)matriz[0].length/2)+posicionY && x >= (matriz.length/2 - palabra.length()/2)+((int)(center/2)*posicion) && x < (matriz.length/2 + palabra.length()/2 + palabra.length()%2)+(int)((center/2)*posicion)) {
                    matriz[x][y] = palabra.charAt((int)((x - matriz.length/2 + palabra.length() / 2)-((center/2)*posicion)));
                }
            }
        }
        return matriz;
    }

    public char[][] centrarEnXYPresicion(char[][] matriz, String palabra,int posicion, int posicionY){
        for (int y = 0; y < matriz[0].length; y++) {
            for (int x = 0; x < matriz.length; x++) {
                if (y == ((int)matriz[0].length/2)+posicionY && x >  posicion+1 && x <  palabra.length()+posicion+2) {
                    matriz[x][y] = palabra.charAt((int)((x-posicion))-2);
                }
            }
        }
        return matriz;
    }

    public char[][] cuadrado(int horizontal, int vertical){
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
