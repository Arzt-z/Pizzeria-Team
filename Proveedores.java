import java.util.Scanner;

public class Proveedores extends Persona {
	private String razonSocial;
	private Scanner leer = new Scanner(System.in);

	public Proveedores() {

	}

	public Proveedores(String razonSocial, String telefono, String direccion, String rfc) {
		super(telefono, direccion, rfc);
		this.razonSocial = razonSocial;
	}
	public String toString() {
		return razonSocial;
	}

	public void mostrar() {
		Cuadrado.imprimirCuadradoDividido(50, 4, razonSocial, "");
		super.mostrar();
	}

	public String quienSoy() {
		return "Proveedor";
	}

	public void capturar() {
		char diferenciador = 'p';
		System.out.println("Informacion del proveedor");
		System.out.print("razon social  :");
		razonSocial = leer.nextLine();
		super.capturar(diferenciador);
	}
	public void modificar() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Que deseas modificar?");
		int ciclo = 1;
		do {
			System.out.println("1.-razon social 2.-Otros  0.-cancelar");
			int atributo = leer.nextInt();
			switch (atributo) {
				case 1:
					System.out.println("Ingrese nueva razon Social");
					leer.nextLine();
					String razonSocial = leer.nextLine();
					setRazonSocial(razonSocial);
					break;
				case 2:
					super.modificar();
					break;
				case 0:
					return;
			}
			System.out.println("Deseas seguir?   1.-Si   2.-No");
			String option = leer.next();
			if (option.equalsIgnoreCase("si") || option.equals("1")) {
				ciclo = 1;
			} else {
				ciclo = 0;
			}
		} while (ciclo == 1);
	}

	public boolean buscar(String cadenaAbuscar) {
        String misDatos;
        if (super.buscar(cadenaAbuscar) == true) {
            return true;
        }

        misDatos = razonSocial;

        return misDatos.contains(cadenaAbuscar);
	}

	public void eliminar() {
		super.eliminar();
		System.out.println("Eliminaste a " + razonSocial);
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRazonSocial() {
		return razonSocial;
	}
}
