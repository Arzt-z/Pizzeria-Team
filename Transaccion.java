import java.util.Scanner;
import java.util.Date;
import java.io.*;
import java.text.SimpleDateFormat;

public abstract class Transaccion implements Interface, Serializable{
    
    protected String fecha;
    protected String folio;
    protected boolean vigente;
    protected Detalle[] detalles = new Detalle[500];
    protected int cDetalles;

    protected Transaccion() {
        vigente = true;
    }

    protected Transaccion(String fecha, String folio) {
        this.fecha = fecha;
        this.folio = folio;
        vigente = true;
        cDetalles = 0;
    }

    public String toString() {
        return "fecha: " + fecha + "folio: " + folio;
    }

    public void mostrar() {

        System.out.println("Fecha: " + fecha);
        System.out.println("Folio: " + folio);
       
    }

    abstract String queSoy();

    public void eliminar(char diferencia) {
        vigente = false;
        if (diferencia == 'c') {
            for (int i = 0; i < cDetalles; i++) {
                detalles[i].getInventario().setStock(detalles[i].getInventario().getStock() - detalles[i].getCantidad());
            }
        } else {
            for (int i = 0; i < cDetalles; i++) {
                //detalles[i].getInventario().setStock(detalles[i].getInventario().getStock() + detalles[i].getCantidad());
            }
        }
    }
	
	public void eliminarDetalle(char diferencia){
		 Scanner leer = new Scanner(System.in);
		 if (diferencia == 'c') { 
		 for (int i = 0; i < cDetalles; i++) {
                 if(detalles[i].isVigente()==true)
				 System.out.println(i+1+".-"+detalles[i]);
            }
			System.out.println("Que detalle deseas eliminar?");
			int nDetalle= leer.nextInt() -1;
			if(cDetalles<=nDetalle || nDetalle<0 ||detalles[nDetalle].isVigente()==false){
				System.out.println("No existe ese detalle");
			}
			else if(detalles[nDetalle].isVigente()==true || nDetalle<cDetalles || nDetalle>=0){
			detalles[nDetalle].eliminar();
			detalles[nDetalle].getInventario().setStock(detalles[nDetalle].getInventario().getStock() - detalles[nDetalle].getCantidad());}
		 }
		 else{
			for (int i = 0; i < cDetalles; i++) {
				if(detalles[i].isVigente()==true)
                System.out.println(i+1+".-"+detalles[i]);
            }
			System.out.println("Que detalle deseas eliminar?");
			int nDetalle= leer.nextInt() -1;
			if(cDetalles<=nDetalle || nDetalle<0 || detalles[nDetalle].isVigente()==false){
				System.out.println("ese no es un detalle o ya se elimino");
			}
			else if(detalles[nDetalle].isVigente()==true ||nDetalle<cDetalles || nDetalle>=0){
			detalles[nDetalle].eliminar();
			detalles[nDetalle].getInventario().setStock(detalles[nDetalle].getInventario().getStock() - detalles[nDetalle].getCantidad());}
		 }
	}
	
    public void capturar(Inventario[] inventarios, int cInventarios, char diferencia) {
        Scanner datos = new Scanner(System.in);
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy HH:mm");
        int ciclo;
        if (diferencia == 'c') {
            this.fecha =  formatoFecha.format(fechaActual);
            do {
                capturarDetalle(inventarios, cInventarios, diferencia);
                System.out.println("Desea Continuar?   1.-Si   2.-No");
                ciclo=datos.nextInt();
            } while (ciclo == 1 && cDetalles <= 500);
        } else {
            this.fecha =  formatoFecha.format(fechaActual);
                capturarDetalle(inventarios, cInventarios, diferencia);

        }
    }


    public void capturar(Pizza[] pizzas, int cPizzas) {
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy HH:mm");
            this.fecha =  formatoFecha.format(fechaActual);
                capturarDetalle(pizzas, cPizzas);
    }


    public void modificar(int cInventarios, Inventario[] inventarios, char diferencia, int cPizzas,Pizza[] pizzas) {
        Scanner leer = new Scanner(System.in);
        int opcion;
        int error;
        int continuar = 1;
            do {
                if(diferencia=='c'){
                    do{
                        error=0;
                        Cuadrado.imprimirCuadrado(50, 3,"Detalles: ");
                        Cuadrado.matriz = Cuadrado.cuadrado(50, cDetalles + 2);
                        for (int i = 0; i < cDetalles; i++) {
                            Cuadrado.centrarEnXYPresicion(i + 1 + ".-" + detalles[i].getNombre(),1, i + 1);
                        }
                        Cuadrado.imprimirCuadrado();
                        int nDetalle = leer.nextInt();
                        if(nDetalle>0 && nDetalle<=cDetalles){
                            detalles[nDetalle - 1].modificar(cInventarios, inventarios, diferencia);
                        }else{
                            System.out.println("Opcion no valida");
                            System.out.println("Intente de nuevo");
                            error=1;
                        }
                    }while(error==1);
                }else{
                    do{
                        error=0;
                        Cuadrado.imprimirCuadrado(50, 3,"Detalles: ");
                        Cuadrado.matriz = Cuadrado.cuadrado(50, cDetalles + 2);
                        Cuadrado.centrarEnXYPresicion("Nombre",1, 0);
                        Cuadrado.centrarEnXYPresicion("cantidad",25,0);
                        for (int i = 0; i < cDetalles; i++) {
                            Cuadrado.centrarEnXYPresicion(i + 1 + ".-" + detalles[i].getNombre(),1, i + 1);
                            Cuadrado.centrarEnXYPresicion("" + detalles[i].getCantidad(),25, i + 1);
                            Cuadrado.centrarEnXYPresicion("" + detalles[i].getPrecioProd(),30, i + 1);
                        }
                        Cuadrado.imprimirCuadrado();
                        int nDetalle = leer.nextInt();
                        if(nDetalle>0 && nDetalle<=cDetalles){
                            if(detalles[nDetalle - 1].getDif()=='p'){
                                detalles[nDetalle - 1].modificar(cPizzas, pizzas, 'p');
                            }else{
                                detalles[nDetalle - 1].modificar(cInventarios, inventarios, 'i');
                            }
                        }else{
                            System.out.println("Opcion no valida");
                            System.out.println("Intente de nuevo");
                            error=1;
                        }
                    }while(error==1);
                }
                
                Cuadrado.imprimirCuadrado(50, 3, "modificar otro?");
                Cuadrado.imprimirCuadradoDividido(50, 2, "1.-si", "2.-no");
                continuar = leer.nextInt();

            } while (continuar == 1);

    }

    public boolean buscar(String cadenaAbuscar) {
        String datos = fecha + folio;
        datos= datos.toLowerCase();
        if (datos.contains(cadenaAbuscar.toLowerCase()) == true) {
            return true;
        }
        for (int i = 0; i < cDetalles; i++) {
            if (detalles[i].buscar(cadenaAbuscar.toLowerCase()) == true) {
                return true;
            }
        }
        return false;
    }

    public void agregarDetalles(int cantidad, Inventario inventarios, double costo, char diferencia) {
        if (diferencia == 'c') {
            detalles[cDetalles++] = new Detalle(cantidad, inventarios, costo);
            int stockAnterio = inventarios.getStock();
            int stocknuevo = stockAnterio + cantidad;
            inventarios.setStock(stocknuevo);
        } else {
            detalles[cDetalles++] = new Detalle(cantidad, inventarios, costo);
            int stockAnterio = inventarios.getStock();
            int stocknuevo = stockAnterio - cantidad;
            inventarios.setStock(stocknuevo);
        }
    }

    public void capturarDetalle(Inventario[] inventarios, int cInventarios, char diferencia) {
        if (diferencia == 'c') {
            detalles[cDetalles] = new Detalle();
            detalles[cDetalles].capturar(cInventarios, inventarios, diferencia);

            cDetalles++;
        } else {
            detalles[cDetalles] = new Detalle();
            detalles[cDetalles].capturar(cInventarios, inventarios, diferencia);

            cDetalles++;
        }
    }

    public void capturarDetalle(Pizza[] pizzas, int cPizzas) {
            detalles[cDetalles] = new Detalle();
            detalles[cDetalles++].capturar(cPizzas, pizzas);
    }

    public void getDetalles(char diferenciador) {
        Cuadrado.matriz = Cuadrado.cuadrado(50, cDetalles+4);
        double totalf = 0;
        double total = 0;
        Cuadrado.centrarEnXYPresicion("Producto", 2, 0);
        Cuadrado.centrarEnXYPresicion("cantidad", 28, 0);
        Cuadrado.centrarEnXYPresicion("|precio", 36, 0);
        for (int i = 0; i < cDetalles; i++) {
            if (detalles[i].getCantidad() == 0) {
                totalf += detalles[i].getPrecioProd() * detalles[i].getCantidad();
                total += detalles[i].getPrecioProd() * detalles[i].getCantidad();
                total = 0;
            } else {
                if(detalles[i].isVigente()==true){
                    if(detalles[i].getDif()=='p'){
                        Cuadrado.centrarEnXYPresicion("pizza:"+detalles[i].getNombre(), 2, 1+i);
                    }else{
                        Cuadrado.centrarEnXYPresicion(detalles[i].getNombre(), 2, 1+i);
                    }
                Cuadrado.centrarEnXYPresicion(""+detalles[i].getCantidad(), 28, 1+i);
                Cuadrado.centrarEnXYPresicion("|"+(detalles[i].getPrecioProd()*detalles[i].getCantidad()), 36, 1+i);
                totalf += detalles[i].getPrecioProd() * detalles[i].getCantidad();
                total += detalles[i].getPrecioProd() * detalles[i].getCantidad();
                total = 0;
				}
            }

        }
        Cuadrado.centrarEnXYPresicion("-------------------------------------------", 2, cDetalles+1);
        Cuadrado.centrarEnXYPresicion("total final= " + totalf, 24, cDetalles+2);
        Cuadrado.imprimirCuadrado();
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public void eliminarDetalles() {
        cDetalles=0;
    }
	
}