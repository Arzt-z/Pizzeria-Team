import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
public abstract class Transaccion{
    
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

        System.out.println("Folio: " + fecha);
        System.out.println("Fecha: " + folio);
       
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

            do {
                capturarDetalle(inventarios, cInventarios, diferencia);
                if (detalles[cDetalles - 1].getCantidad() == 0) {
                    ciclo = 0;

                } else {
                    System.out.println("Quiere seguir agregrando detalles?   1.-Si   2.-No");
                    String option = datos.next();
                    if (option.equalsIgnoreCase("si") || option.equals("1")) {
                        ciclo = 1;
                    } else {
                        ciclo = 0;
                    }
                }
            } while (ciclo == 1 && cDetalles < 500);
        }
    }


    public void capturar(Pizza[] pizzas, int cPizzas) {
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy HH:mm");
        Scanner datos = new Scanner(System.in);
        int ciclo;
            this.fecha =  formatoFecha.format(fechaActual);
            do {
                capturarDetalle(pizzas, cPizzas);
                System.out.println("Desea Continuar?   1.-Si   2.-No");
                String option = datos.next();
                if (option.toLowerCase() == "si" || option == "1") {
                    ciclo = 1;
                } else {
                    ciclo = 0;
                }
            } while (ciclo == 1 && cDetalles < 500);
    }


    public void modificar(int cInventarios, Inventario[] inventarios, char diferencia) {
        Scanner leer = new Scanner(System.in);
        int opcion;

        if (diferencia == 'c') {
            do {
                System.out.println("Que deseas modificar? "
                        + "1.-Fecha 2.-Folio 3.-Modificar detalles 0.-Cancelar");
                opcion = leer.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Fecha: ");
                        leer.nextLine();
                        folio = leer.nextLine();
                        break;
                    case 2:
                        System.out.println("Folio: ");
                        leer.nextLine();
                        fecha = leer.nextLine();
                        break;
                    case 3:
                        System.out.println("Detalles: ");
                        for (int i = 0; i < cDetalles; i++) {
                            System.out.println(i + 1 + ".-" + detalles[i]);
                        }
                        int nDetalle = leer.nextInt();
                        detalles[nDetalle - 1].modificar(cInventarios, inventarios, diferencia);
                        break;
                    case 0:
                        return;
                }
            } while (true);
        } 
		else {

            do {
                System.out.println("Que deseas modificar? "
                        + "1.-Fecha 2.-Folio 3.-Modificar detalles 0.-Cancelar");
                opcion = leer.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Fecha: ");
                        leer.nextLine();
                        folio = leer.nextLine();
                        break;
                    case 2:
                        System.out.println("Folio: ");
                        leer.nextLine();
                        fecha = leer.nextLine();
                    case 3:
                        System.out.println("Detalles: ");
                        for (int i = 0; i < cDetalles; i++) {
                            System.out.println(i + 1 + ".-" + detalles[i]);
                        }
                        int nDetalle = leer.nextInt();
                        detalles[nDetalle - 1].modificar(cInventarios, inventarios, diferencia);
                        break;
                    case 0:
                        return;
                }
            } while (true);
        }

    }

    public boolean buscar(String cadenaAbuscar) {
        String datos = fecha + folio;
        if (datos.contains(cadenaAbuscar) == true) {
            return true;
        }
        for (int i = 0; i < cDetalles; i++) {
            if (detalles[i].buscar(cadenaAbuscar) == true) {
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
        double totalf = 0;
        double total = 0;

        for (int i = 0; i < cDetalles; i++) {
            if (detalles[i].getCantidad() == 0) {

                totalf += detalles[i].getPrecioProd() * detalles[i].getCantidad();
                total += detalles[i].getPrecioProd() * detalles[i].getCantidad();

                total = 0;

            } else {
                if(detalles[i].isVigente()==true){
				detalles[i].mostrar(diferenciador);
                totalf += detalles[i].getPrecioProd() * detalles[i].getCantidad();
                total += detalles[i].getPrecioProd() * detalles[i].getCantidad();
                System.out.println("\t\ttotal= " + total);
                total = 0;
				}

            }

        }
        System.out.println("\t\t----------------------------");
        System.out.println("\t\ttotal final= " + totalf);
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