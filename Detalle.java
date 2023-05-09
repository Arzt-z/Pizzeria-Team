import java.util.*;
public class Detalle {
    private int cantidad;
    private Pizza pizzas;
	private Inventario inventario;
    private double precioProd;
	private  boolean vigente;

    public Detalle() {
		vigente=true;
    }

    public Detalle(int cantidad, Inventario inventario, double precioProd) {
        this.cantidad = cantidad;
        this.inventario = inventario;
        this.precioProd = precioProd;
    }

    public Detalle(int cantidad, Pizza pizzas, double precioProd) {
        this.cantidad = cantidad;
        this.pizzas = pizzas;
        this.precioProd = precioProd;
    }

    public void mostrar() {
		System.out.println("\t\tPizza: " + pizzas);
        System.out.println("\t\tCantidad: " + cantidad);
        System.out.println("\t\tprecioProd: " + precioProd);
    }

    public void modificar(int cPizzas, Pizza [] pizzas, char diferenciador) {
        Scanner leer = new Scanner(System.in);
        int opcion;
        if(diferenciador=='c')
        do {
            System.out.println("Que desea modificar? "
                    + "1.-Pizza 2.-Cantidad 3.-precioProd 0.-Cancelar");
            opcion = leer.nextInt();
            switch (opcion) {
				case 1:
                    for (int i = 0; i < cPizzas; i++) {
                        System.out.println(i + 1 + ".-" + pizzas[i]);
                    }
                    System.out.println("Seleccione la pizza");
                    int laPizza = leer.nextInt() - 1;
                    this.pizzas = pizzas[laPizza];
                    break;
                case 2:
                    System.out.println("cantidad:");
                    cantidad = leer.nextInt();
                    setCantidad(cantidad);
                    break;
                case 3:
                    System.out.println("precioProd: ");
                    precioProd = leer.nextFloat();
                    break;
                case 0:
                    return;
            }
        } while (true);

    
        else{

			do {
				System.out.println("Que deseas modificar? "
						+ "1.-Pizza 2.-Cantidad 0.-Cancelar");
				opcion = leer.nextInt();
				switch (opcion) {
					case 1:
						for (int i = 0; i < cPizzas; i++) {
							System.out.println(i + 1 + ".-" + pizzas[i]);
						}
						System.out.println("Selecione la pizza");
						int laPizza= leer.nextInt() - 1;
						this.pizzas = pizzas[laPizza];
						precioProd=pizzas[laPizza].getPrecioProd();
						break;
					case 2:
						System.out.println("Cantidad:");
						cantidad = leer.nextInt();
						setCantidad(cantidad);
						break;
					case 0:
						return;
				}
			} while (true);
		}
    }

    public boolean buscar(String cadenaAbuscar) {
        String datos = " " + cantidad + pizzas + precioProd;
        if (datos.contains(cadenaAbuscar) == true) {
            return true;
        }
        return false;
    }	

    //capturar de inventarios testear pendiente!!
    public void capturar(int cInventarios, Inventario[] inventarios, char diferenciador) {
		Scanner dato = new Scanner(System.in);
        int error;
	    if(diferenciador=='c'){
		System.out.println("Detalles de Compra");
        for (int i = 0; i < cInventarios; i++) {
			System.out.println(i + 1 + ".-" + inventarios[i]);
        }
        System.out.println("Seleccione los ingredientes");
        int elInventario = dato.nextInt() - 1;
        this.inventario = inventarios[elInventario];
		System.out.println("Cantidad: ");
        cantidad = dato.nextInt();
        System.out.println("precioProd: ");
        precioProd = dato.nextFloat();
		} else{  
			do{
				error=0;
				System.out.println("Detalles de venta");
				for (int i = 0; i < cInventarios; i++) {
				   if(inventarios[i].getExistencia()==true){
				   System.out.println(i + 1 + ".-" + inventarios[i]);}
				}
				int elInventario=0;
				int fail=0;
				do{
					System.out.println("Selecione la pizza");
					elInventario = dato.nextInt() - 1;
					fail=0;
					if(elInventario>=0 && inventarios[elInventario].getExistencia()==true){
						fail++;
					}else{
						System.out.println("Esa pizza no esta disponible");
						fail=0;
					}
				}while(fail==0);
				System.out.println("Cantidad: ");
				cantidad = dato.nextInt();
				if(elInventario>=cInventarios){
					this.cantidad=0;
					this.inventario=inventarios[elInventario];
					System.out.println("No tenemos esa cantidad en stock");
					System.out.println("Desea comprar otra pizza   1.-Si   2.-No");
					error=dato.nextInt();
				}else{
					this.inventario = inventarios[elInventario];
					precioProd = inventarios[elInventario].getPrecio();
					error=2;
				}
			}while(error == 1);
	   }
    }
    //fin capturar inventarios

    //capturar de pizzas
    public void capturar(int cPizzas, Pizza [] pizzas, char diferenciador) {
		Scanner dato = new Scanner(System.in);
        int error;
	    if(diferenciador=='c'){
		System.out.println("Detalles de Compra");
        for (int i = 0; i < cPizzas; i++) {
			System.out.println(i + 1 + ".-" + pizzas[i]);
        }
        System.out.println("Seleccione la pizza");
        int laPizza = dato.nextInt() - 1;
        this.pizzas = pizzas[laPizza];
		System.out.println("Cantidad: ");
        cantidad = dato.nextInt();
        System.out.println("precioProd: ");
        precioProd = dato.nextFloat();
		} else{  
			do{
				error=0;
				System.out.println("Detalles de venta");
				for (int i = 0; i < cPizzas; i++) {
				   if(pizzas[i].getExistencia()==true){
				   System.out.println(i + 1 + ".-" + pizzas[i]);}
				}
				int laPizza=0;
				int fail=0;
				do{
					System.out.println("Selecione la pizza");
					laPizza = dato.nextInt() - 1;
					fail=0;
					if(laPizza>=0 && pizzas[laPizza].getExistencia()==true){
						fail++;
					}else{
						System.out.println("Esa pizza no esta disponible");
						fail=0;
					}
				}while(fail==0);
				System.out.println("Cantidad: ");
				cantidad = dato.nextInt();
				if(laPizza>=cPizzas){
					this.cantidad=0;
					this.pizzas=pizzas[laPizza];
					System.out.println("No tenemos esa cantidad en stock");
					System.out.println("Desea comprar otra pizza   1.-Si   2.-No");
					error=dato.nextInt();
				}else{
					this.pizzas = pizzas[laPizza];
					precioProd = pizzas[laPizza].getPrecioProd();
					error=2;
				}
			}while(error == 1);
	   }
    }
    //fin capturar pizzas

    public void modificar(int cInventarios, Inventario[] inventarios, char diferencia){
		//pendiente
	}

    public String toString() {
        return "Detalle{" + "cantidad:" + cantidad + ", pizza:" + pizzas + ", precioProd:" + precioProd + '}';
    }
	
	public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Inventario getInventario() {
        return inventario;
    }
	public void eliminar(){
		vigente=false;
	}
	
	public boolean isVigente(){
		return vigente;
	}
	
	public void setVigente(boolean vigente){
		this.vigente=vigente;
	}

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioProd() {
        return precioProd;
    }

    public void setPrecioProd(double precioProd) {
        this.precioProd = precioProd;
    }

}
