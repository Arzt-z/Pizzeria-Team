import java.util.Scanner;
public class ExtrasOProductos {
    
	private String nombre;
	private String tipo;
	private int precio;
	private boolean existencia;
	private Scanner leer =new Scanner(System.in);
	
	public ExtrasOProductos(){
		existencia=true;
	}
	
	public ExtrasOProductos(String nombre, String tipo ,int precio){
		this.nombre= nombre;
		this.tipo=tipo;
		this.precio=precio;
	}
	
	public String toString(){
		return tipo+" "+nombre+"  $"+precio;
	}
	
	public void mostrar(){
		//no le entiendo a la brga matriz
	}
	
	public void capturar(){
		System.out.print("Nombre  :");nombre = leer.nextLine();
		System.out.println("Precio");precio= leer.nextInt();
		System.out.println("que tipo es? 1.-bebida 2.-extra 3.-producto");
		int option = leer.nextInt();
		if(option==1)
			tipo="bebida";
		if(option==2)
			tipo="extra";
		if(option==3)
			tipo="producto";
		
	}
	
	public void modificar(){
		int seguir;
		do{
		System.out.println("que deseas modificar 1-nombre 2-precio 0-cancelar");
		int opcion = leer.nextInt();
		switch(opcion){
			case 1: System.out.println("nuevo nombre");
			nombre= leer.nextLine();
			break;
			case 2: System.out.println("nuevo precio");
			precio= leer.nextInt();
			break;
			case 0: 
			return;	
		}
		System.out.println("deseas continuar? 1-si 2-no");
		seguir =leer.nextInt();
		}while(seguir == 1);
	}
	
	public void eliminarExistencia(){
		existencia=false;
	}
	
	public void enExistencia(){
		existencia=true;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public int getPrecio(){
		return precio;
	}
	
	public void setPrecio(int precio){
		this.precio=precio;
	}
}
