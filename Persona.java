import java.io.Serializable;
import java.util.Scanner;


public abstract class Persona implements Interface, Serializable{
  //  protected Scanner leer = new Scanner(System.in);
    protected String telefono;
    protected String direccion;
    protected String rfc;
    protected boolean vigente = true;

    public Persona() {
        vigente = true;
    }

    public Persona(String telefono, String direccion, String rfc) {
        this.telefono = telefono;
        this.direccion = direccion;
        this.rfc = rfc;
        vigente=true;
    }

    public String toString() {
        return "telefono " + telefono + " " + "direccion " + direccion;
    }

    abstract String quienSoy();

    public void mostrar() {
        Cuadrado.matriz = Cuadrado.cuadrado(50, 6);
        Cuadrado.centrarEnXY(direccion, 0, -1);
        Cuadrado.centrarEnXY("rfc: " + rfc, 0, 0);
        Cuadrado.centrarEnXY("telefono: " + telefono, 0, 1);
        Cuadrado.imprimirCuadrado();
    }

    protected void capturar(char diferenciador) {
        Scanner leer = new Scanner(System.in);
        if (diferenciador == 'c') {
            System.out.println("el pedido es a domicilio? 1-si 2-no");
            int pedido = leer.nextInt();
            if (pedido == 1) {
                System.out.print("ingrese telefono    :");
                telefono = leer.nextLine();
                System.out.print("ingrese direccion    :");
                direccion = leer.nextLine();
            } else {
                telefono = " ";
                direccion = " ";
            }

            System.out.println("desea facturar 1-si 2-no");
            int factura = leer.nextInt();
            if (factura == 1) {
                System.out.print("ingrese rfc del cliente   :");
                rfc = leer.nextLine();
            } else
                rfc = "(el rfc de consumidor general)";

        } else {
            System.out.print("ingrese telefono    :");telefono = leer.nextLine();
            System.out.print("ingrese direccion    :");direccion = leer.nextLine();
            System.out.print("ingrese rfc    :");
            rfc = leer.nextLine();
        }
    }

    protected void modificar() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Que deseas modificar?");
        System.out.println("1.-Telefono 2.-direccion 3-RFC 0.-Cancelar");
        int atributo = leer.nextInt();
        switch (atributo) {

            case 1:
                System.out.println("Ingrese nuevo telefono");
                String telefono = leer.next();
                setTelefono(telefono);
                break;
            case 2:
                System.out.println("Ingrese nuevo direccion");
                String direccion = leer.next();
                setDireccion(direccion);
                break;
            case 3:
                System.out.println("Ingrese nuevo rfc");
                String rfc = leer.next();
                setRfc(rfc);
                break;
            case 0:
                return;
        }

    }

    public boolean buscar(String cadenaAbuscar) {
        String misDatos = telefono + direccion + rfc;
        misDatos=misDatos.toLowerCase();
        return misDatos.contains(cadenaAbuscar.toLowerCase());
    }

    public void eliminar() {
        vigente = false;
    }

    protected void restaurar() {
        vigente = true;
    }

    protected void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    protected boolean isVigente() {
        return vigente;
    }

    protected String getTelefono() {
        return telefono;
    }

    protected String getDireccion() {
        return direccion;
    }

    protected String getRfc() {
        return rfc;
    }

    protected void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    protected void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    protected void setRfc(String rfc) {
        this.rfc = rfc;
    }
}
