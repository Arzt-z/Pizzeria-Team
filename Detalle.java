import java.util.*;
public class Detalle {
    private int cantidad=0;
    private Pizza pizzas;
	private Inventario inventario;
    private double precioProd=0;
	private boolean vigente;
	private char dif;
	private String nombre;

    public Detalle() {
		vigente=true;
    }

    public Detalle(int cantidad, Inventario inventario, double precioProd) {
        this.cantidad = cantidad;
        this.inventario = inventario;
        this.precioProd = precioProd;
		this.dif= 'i';
    }

    public Detalle(int cantidad, Pizza pizzas, double precioProd) {
        this.cantidad = cantidad;
        this.pizzas = pizzas;
        this.precioProd = precioProd;
		this.dif='p';
    }


    public void mostrar() {
		Cuadrado.matriz=Cuadrado.cuadrado(50, 3);
		if(this.dif=='p'){
			Cuadrado.centrarEnXYPresicion("pizza:",2, 1);
            Cuadrado.centrarEnXYPresicion(pizzas.getNombre(),8, 1);
		}else{
			Cuadrado.centrarEnXYPresicion("inventario:",2, 1);
			Cuadrado.centrarEnXYPresicion(inventario.getNombre(),8, 1);
		}
		Cuadrado.centrarEnXYPresicion("Cantidad|",28, 0);
		Cuadrado.centrarEnXYPresicion(cantidad+"",33, 1);
		Cuadrado.centrarEnXYPresicion("precioProd",37, 0);
		Cuadrado.centrarEnXYPresicion(precioProd+"",37, 1);
		Cuadrado.imprimirCuadrado();
	}

    public void mostrar(char diferenciador) {
		if(diferenciador=='c'){
			System.out.println("\t\tIngredientes: " + pizzas);
			System.out.println("\t\tCantidad: " + cantidad);
			System.out.println("\t\tprecioProd: " + precioProd);
		}else{
		System.out.println("\t\tPizza: " + pizzas);
        System.out.println("\t\tCantidad: " + cantidad);
        System.out.println("\t\tprecio: " + precioProd);
		}
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
			listarProductos(cInventarios,inventarios,'c');
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
				listarProductos(cInventarios,inventarios,'v');
				int elInventario=0;
				int fail=0;
				do{
					System.out.println("Selecione el producto");
					elInventario = dato.nextInt() - 1;
					fail=0;
					if(elInventario>=0 && inventarios[elInventario].getExistencia()==true){
						fail++;
					}else{
						System.out.println("Ese producto no esta disponible");
						fail=0;
					}
				}while(fail==0);
				Cuadrado.imprimirCuadrado(50, 3 ,"Cantidad");
				cantidad = dato.nextInt();
				this.inventario=inventarios[elInventario];
				if(cantidad>inventario.getStock()){
					this.cantidad=0;
					System.out.println("No tenemos esa cantidad en stock");
					System.out.println("Desea comprar otra pizza   1.-Si   2.-No");
					error=dato.nextInt();
				}else{
					inventario.setStock(inventario.getStock()-cantidad);
					precioProd = inventarios[elInventario].getPrecio();
					error=2;
				}
			}while(error == 1);
	   }
	   this.nombre = this.inventario.getNombre();
    }
    //fin capturar inventarios

	public void listarProductos(int cInventarios, Inventario[] inventarios, char differenciador){
		int contador=0;
		int contador2=0;
		Cuadrado.imprimirCuadrado(50, 2, "----------inventarios----------");
		if(differenciador == 'c'){
			Cuadrado.matriz=Cuadrado.cuadrado(50, cInventarios+3);
			Cuadrado.centrarEnXYPresicion("STOCK",28, 0);
			Cuadrado.centrarEnXYPresicion("|precioProd",36, 0);
			for (int i = 0; i < cInventarios; i++) {
				Cuadrado.centrarEnXYPresicion((i+1)+".-"+inventarios[i].getNombre(),2, 1+i);
				Cuadrado.centrarEnXYPresicion(inventarios[i].getStock()+"",30, 1+i);
                Cuadrado.centrarEnXYPresicion(inventarios[i].getPrecio()+"",37, 1+i);
			}
		}else{
			System.out.println(cInventarios);
			for (int i = 0; i < cInventarios; i++) {
				if(inventarios[i].getExistencia()==true && (inventarios[i].getTipo().equals("carne") || inventarios[i].getTipo().equals("no carne") || inventarios[i].getTipo().equalsIgnoreCase("queso"))==false){
					contador++;
				}
			}
			Cuadrado.matriz=Cuadrado.cuadrado(50, contador+3);
			Cuadrado.centrarEnXYPresicion("STOCK",28, 0);
			Cuadrado.centrarEnXYPresicion("|precioProd",36, 0);
			for (int i = 0; i < cInventarios; i++) {
				if(inventarios[i].getExistencia()==true && (inventarios[i].getTipo().equals("carne") || inventarios[i].getTipo().equals("no carne") || inventarios[i].getTipo().equalsIgnoreCase("queso"))==false){
					Cuadrado.centrarEnXYPresicion((i+1)+".-"+inventarios[i].getNombre(),2, 1+contador2);
					Cuadrado.centrarEnXYPresicion(inventarios[i].getStock()+"",30, 1+contador2);
                    Cuadrado.centrarEnXYPresicion(inventarios[i].getPrecio()+"",37, 1+contador2);
					contador2++;
				}
			}
		}
		Cuadrado.imprimirCuadrado();
	}

    //capturar de pizzas
    public void capturar(int cPizzas, Pizza [] pizzas) {
		Scanner dato = new Scanner(System.in);
			Cuadrado.imprimirCuadrado(50, 2, "---------Pizzas---------");
			Cuadrado.matriz = Cuadrado.cuadrado(50, cPizzas + 4);
			Cuadrado.centrarEnXYPresicion("Precio ", 37, 0);
			for (int i = 0; i <= cPizzas; i++) {
				if (pizzas[i].getExistencia()) {
					Cuadrado.centrarEnXYPresicion(i + 1 + ".-" + pizzas[i].toString(), 3, i + 1);
					Cuadrado.centrarEnXYPresicion(pizzas[i].getPrecio() + "$ ", 38, 1 + i);
				}
			}
			Cuadrado.imprimirCuadrado();

			int laPizza = dato.nextInt() - 1;
			this.pizzas = pizzas[laPizza];
			Cuadrado.imprimirCuadrado(50,4,"Cantidad: ");
			cantidad = dato.nextInt();
			pizzas[laPizza].calcularPrecio();
			precioProd = pizzas[laPizza].getPrecio();
			pizzas[laPizza].sustraerIngredientesAInventarios(cantidad);
			this.dif='p';
			this.nombre = this.pizzas.getNombre();
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

	public int getDif() {
        return dif;
    }

    public void setDif(char dif) {
        this.dif = dif;
    }

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
