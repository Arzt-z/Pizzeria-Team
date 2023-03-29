import java.util.Scanner;
public class Ap{
	public static void main (String[] args){
		Pizzeria pizzafactory = new Pizzeria("Pizza Factory", "Av. Lic. Enrique Ramírez Miguel, Las Américas", "PizzaFactory@Pizza.com", 7002200 , "445697234");
		pizzafactory.mostrar();
		do {
            switch (menu()) {
                case 11:
                  
                    break;
                case 0:
                    return;
            }
        } while (true);
    }

    public static int menu() {
        Scanner datos = new Scanner(System.in);
		System.out.println("0.-Salir");
        int seleccion = datos.nextInt();
        if (seleccion == 0) {
            return seleccion;
        }

		return seleccion;
    }
	 
}