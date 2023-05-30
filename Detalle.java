import java.util.*;
import java.io.*;

public class Detalle implements Interface, Serializable{
	private int cantidad = 0;
	private Pizza pizzas; 
	private Inventario inventario;
	private double precioProd = 0;
	private boolean vigente;
	private char dif;
	private String nombre;

	public Detalle() {
		vigente = true;
	}

	public Detalle(int cantidad, Inventario inventario, double precioProd) {
		this.cantidad = cantidad;
		this.inventario = inventario;
		this.precioProd = precioProd;
		this.dif = 'i';
		vigente = true;
	}

	public Detalle(int cantidad, Pizza pizzas, double precioProd) {
		this.cantidad = cantidad;
		this.pizzas = pizzas;
		this.precioProd = precioProd;
		this.dif = 'p';
		vigente = true;
	}

	public void mostrar() {
		Cuadrado.matriz = Cuadrado.cuadrado(50, 3);
		if (this.dif == 'p') {
			Cuadrado.centrarEnXYPresicion("pizza:", 2, 1);
			Cuadrado.centrarEnXYPresicion(pizzas.getNombre(), 8, 1);
		} else {
			Cuadrado.centrarEnXYPresicion("inv:", 2, 1);
			Cuadrado.centrarEnXYPresicion(inventario.getNombre(), 8, 1);
		}
		Cuadrado.centrarEnXYPresicion("Cantidad|", 28, 0);
		Cuadrado.centrarEnXYPresicion(cantidad + "", 33, 1);
		Cuadrado.centrarEnXYPresicion("precioProd", 37, 0);
		Cuadrado.centrarEnXYPresicion(precioProd + "", 37, 1);
		Cuadrado.imprimirCuadrado();
	}

	public void mostrar(char diferenciador) {
		if (diferenciador == 'i') {
			System.out.println("\t\tInventario: " + inventario);
			System.out.println("\t\tCantidad: " + cantidad);
			System.out.println("\t\tprecioProd: " + precioProd);
		} else {
			System.out.println("\t\tPizza: " + pizzas);
			System.out.println("\t\tCantidad: " + cantidad);
			System.out.println("\t\tprecio: " + precioProd);
		}
	}

	public void modificar(int cPizzas, Pizza[] pizzas, char diferenciador) {
		Scanner leer = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("Que deseas modificar? "
					+ "1.-Pizza 2.-Cantidad 0.-Cancelar");
			opcion = leer.nextInt();
			switch (opcion) {
				case 1:
					for (int i = 0; i < cPizzas; i++) {
						System.out.println(i + 1 + ".-" + pizzas[i]);
					}
					Cuadrado.imprimirCuadrado(50, 4, "Selecione la pizza");
					int laPizza = leer.nextInt() - 1;
					this.pizzas = pizzas[laPizza];
					this.nombre = pizzas[laPizza].getNombre();
					precioProd = pizzas[laPizza].getPrecioProd();
					break;
				case 2:
					Cuadrado.imprimirCuadrado(50, 4, "Cantidad:");
					cantidad = leer.nextInt();
					setCantidad(cantidad);
					break;
				case 0:
					return;
			}
		} while (true);
	}

	public void modificar(int cInventarios, Inventario[] inventarios, char differenciador) {
		Scanner leer = new Scanner(System.in);
		int opcion;
		int error;
			do {
					Cuadrado.imprimirCuadrado(50, 3,"Que desea modificar?");
					Cuadrado.imprimirCuadradoDividido(50, 2, "1.-producto", "2.-cantidad");
					Cuadrado.imprimirCuadradoDividido(50, 2, "3.-precioProd", "0.-Cancelar");
					opcion = leer.nextInt();
						switch (opcion) {
							case 1:
							do{
								error=0;
								listarProductos(cInventarios, inventarios, differenciador);
								Cuadrado.imprimirCuadrado(50, 3, "Seleccione el producto nuevo");
								int elinventario = leer.nextInt() - 1;
								if(elinventario>=0 && elinventario<cInventarios){
									if(differenciador=='c'){
										inventario.setStock(inventario.getStock()-cantidad);
										this.nombre=inventarios[elinventario].getNombre();
										inventarios[elinventario].setStock(inventarios[elinventario].getStock()+cantidad);
									}else{
										inventario.setStock(inventario.getStock()+cantidad);
										inventarios[elinventario].setStock(inventarios[elinventario].getStock()-cantidad);
										this.nombre=inventarios[elinventario].getNombre();
									}
									this.inventario = inventarios[elinventario];
									break;
								}else{
									System.out.println("Opcion no valida");
									System.out.println("Intente de nuevo");
									error=1;
								}
							}while(error==1);
							case 2:
								Cuadrado.imprimirCuadrado(50, 4, "cantidad:");
								cantidad = leer.nextInt();
								setCantidad(cantidad);
								break;
							case 3:
								Cuadrado.imprimirCuadrado(50, 4, "precioProd: ");
								precioProd = leer.nextFloat();
								break;
							case 0:
								return;
						}
			} while (true);

	}

	public boolean buscar(String cadenaAbuscar) {
		String datos = " " + cantidad + pizzas + precioProd+inventario;
		datos = datos.toLowerCase();
		if (datos.contains(cadenaAbuscar.toLowerCase()) == true) {
			return true;
		}else{
			return false;
		}
	}

	// capturar de inventarios testear pendiente!!
	public void capturar(int cInventarios, Inventario[] inventarios, char diferenciador) {
		Scanner dato = new Scanner(System.in);
		int error;
		if (diferenciador == 'c') {
			System.out.println("Detalles de Compra");
			int error2;
			do {
				error2 = 0;
				listarProductos(cInventarios, inventarios, 'c');
				System.out.println("Seleccione el ingrediente ");
				int elInventario = dato.nextInt() - 1;
				if (elInventario > -1 && elInventario < cInventarios) {
					this.inventario = inventarios[elInventario];
					System.out.println("Cantidad: ");
					cantidad = dato.nextInt();
					System.out.println("Precio del producto: ");
					precioProd = dato.nextFloat();
					cambiarStock();
				} else {
					error2 = 1;
					System.out.println("Ese ingrediente no existe");
				}
			} while (error2 == 1);
		} else {
			do {
				error = 0;
				System.out.println("Detalles de venta");
				listarProductos(cInventarios, inventarios, 'v');
				int elInventario = 0;
				int fail = 0;
				do {
					System.out.println("Selecione el producto");
					elInventario = dato.nextInt() - 1;
					fail = 0;

					if (elInventario >= 0 && elInventario < cInventarios) {
						if(inventarios[elInventario].getExistencia() == true){
							fail++;
						}else{
							System.out.println("Ese producto no esta disponible");
							fail = 0;
						}
					} else {
						System.out.println("Ese producto no esta disponible");
						fail = 0;
					}
				} while (fail == 0);
				Cuadrado.imprimirCuadrado(50, 3, "Cantidad");
				cantidad = dato.nextInt();
				this.inventario = inventarios[elInventario];
				this.inventario = inventarios[elInventario];
				if (cantidad > inventario.getStock() && cantidad>=0) {
					this.cantidad = 0;
					System.out.println("No tenemos esa cantidad en stock");
					System.out.println("Desea comprar otra cosa   1.-Si   2.-No");
					error = dato.nextInt();
				} else {
					inventario.setStock(inventario.getStock() - cantidad);
					precioProd = inventarios[elInventario].getPrecio();
					error = 2;
					this.nombre = inventario.getNombre();
					this.dif = 'i';
				}
			} while (error == 1);
		}
		this.nombre = inventario.getNombre();
		this.dif = 'i';
	}
	// fin capturar inventarios

	public void listarProductos(int cInventarios, Inventario[] inventarios, char differenciador) {
		int contador = 0;
		int contador2 = 0;
		Cuadrado.imprimirCuadrado(50, 2, "----------inventarios----------");
		if (differenciador == 'c') {
			Cuadrado.matriz = Cuadrado.cuadrado(50, cInventarios + 3);
			Cuadrado.centrarEnXYPresicion("STOCK", 28, 0);
			Cuadrado.centrarEnXYPresicion("|precioProd", 36, 0);
			for (int i = 0; i < cInventarios; i++) {
				Cuadrado.centrarEnXYPresicion((i + 1) + ".-" + inventarios[i].getNombre(), 2, 1 + i);
				Cuadrado.centrarEnXYPresicion(inventarios[i].getStock() + "", 30, 1 + i);
				Cuadrado.centrarEnXYPresicion(inventarios[i].getPrecio() + "", 37, 1 + i);
			}
		} else {
			System.out.println(cInventarios);
			for (int i = 0; i < cInventarios; i++) {
				if (inventarios[i].getExistencia() == true
						&& (inventarios[i].getTipo().equals("carne") || inventarios[i].getTipo().equals("no carne")
								|| inventarios[i].getTipo().equalsIgnoreCase("queso")) == false) {
					contador++;
				}
			}
			Cuadrado.matriz = Cuadrado.cuadrado(50, contador + 3);
			Cuadrado.centrarEnXYPresicion("STOCK", 28, 0);
			Cuadrado.centrarEnXYPresicion("|precioProd", 36, 0);
			for (int i = 0; i < cInventarios; i++) {
				if (inventarios[i].getExistencia() == true
						&& (inventarios[i].getTipo().equals("carne") || inventarios[i].getTipo().equals("no carne")
								|| inventarios[i].getTipo().equalsIgnoreCase("queso")) == false) {
					Cuadrado.centrarEnXYPresicion((i + 1) + ".-" + inventarios[i].getNombre(), 2, 1 + contador2);
					Cuadrado.centrarEnXYPresicion(inventarios[i].getStock() + "", 30, 1 + contador2);
					Cuadrado.centrarEnXYPresicion(inventarios[i].getPrecio() + "", 37, 1 + contador2);
					contador2++;
				}
			}
		}
		Cuadrado.imprimirCuadrado();
	}

	// capturar de pizzas
	public void capturar(int cPizzas, Pizza[] pizzas) {
		Scanner dato = new Scanner(System.in);
		int error;
		do {
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
			error = 0;
			if (laPizza >= 0 && laPizza <= cPizzas) {
				this.pizzas = pizzas[laPizza];
				Cuadrado.imprimirCuadrado(50, 4, "Cantidad: ");
				cantidad = dato.nextInt();
				pizzas[laPizza].calcularPrecio();
				precioProd = pizzas[laPizza].getPrecio();
				pizzas[laPizza].sustraerIngredientesAInventarios(cantidad);
				this.dif = 'p';
				this.nombre = this.pizzas.getNombre();
			} else {
				System.out.println("Esa pizza no existe.");
				System.out.println("SELECCIONE UN PIZZA VALIDA");
				error = 1;
			}
		} while (error == 1);
	}
	// fin capturar pizzas

	public void cambiarStock() {
		int stockAnterio = inventario.getStock();
		int stocknuevo = stockAnterio + cantidad;
		inventario.setStock(stocknuevo);
	}

	// public void modificar(int cInventarios, Inventario[] inventarios, char
	// diferencia){
	// pendiente
	// }

	public String toString() {
		return "Detalle{" + "cantidad:" + cantidad + ", pizza:" + pizzas + ", precioProd:" + precioProd + '}';
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void eliminar() {
		vigente = false;
	}

	public boolean isVigente() {
		return vigente;
	}

	public void setVigente(boolean vigente) {
		this.vigente = vigente;
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

	public char getDif() {
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
