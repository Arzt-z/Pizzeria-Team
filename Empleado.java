import java.util.Scanner;


public class Empleado extends Persona{

    private String nombre;
   
    private String usuario;
    private String password;
    private String tipo;
    private boolean vigente;

    public Empleado() {
        vigente=true;
    }

    public Empleado(String nombre, String telefono, String direccion, String rfc, String password, String tipo) {
        super(telefono, direccion, rfc);
        this.nombre = nombre;
        this.usuario = generarUsuario(nombre);
        this.password = password;
        this.tipo = tipo;
        vigente=true;
    }

    public String toString() {
        return "nombre " + nombre;
    }

    public String quienSoy() {
        return "Empleado";
    }

    public void mostrar(){
        super.mostrar(); Cuadrado.matriz = Cuadrado.cuadrado(50, 6);
        Cuadrado.centrarEnXY("nombre: " + nombre, 0, 0);
        Cuadrado.centrarEnXY("usuario: " + usuario, 0, 1);
        Cuadrado.imprimirCuadrado();
    }
       

    public String generarUsuario(String nombre) {
        String usuario = "";
        int espacio = 0;
        boolean check = true;
        while ((espacio = nombre.indexOf(' ', espacio)) != -1) {
            if (check) {
                usuario = usuario + nombre.substring(0, espacio) + nombre.charAt(++espacio);
                check = false;
            } else {
                usuario = usuario + nombre.charAt(++espacio);
            }
        }
        if (check)
            usuario = nombre;
        return usuario.toLowerCase();
    }
 
    public void capturar() {
        Scanner leer = new Scanner(System.in);
        char diferenciador = 'e';
        super.capturar(diferenciador);
        String verificar, contrasenia;
        System.out.print("nombre  :");
        nombre = leer.nextLine();
        boolean aprobado= false;
        do {
            System.out.print("ingresa contrasenia:  ");
            contrasenia = leer.nextLine();
            System.out.println("vuelva a ingresar la contrasenia:");
            verificar = leer.nextLine();
            if (contrasenia.equals(verificar)) {
                this.password = contrasenia;
                aprobado=true;
            }
        } while (aprobado==false);
        int tip;
        boolean aprobar=false;
        do {
            System.out.println("tipo de trabajador  1.-empleado 2.-admin");
            tip = leer.nextInt();
            if (tip == 1) {
                tipo = "empleado";
                aprobar=true;
            }
            if (tip == 2) {
                tipo = "admin";
                aprobar=true;
            }
            if (tip != 1 && tip != 2) {
                System.out.println("esa no es una opcion");
            }
        } while (aprobar==false);

        
        this.usuario = generarUsuario(nombre);

    }


    public void modificar() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Que deseas modificar?");
        int ciclo = 1;
        String verificar, contrasenia;
        do {
            System.out.println("1.-nombre 2.-contrasenia 3.-puesto 4.-Otros  0.-cancelar");
            int atributo = leer.nextInt();
            switch (atributo) {
                case 1:
                    System.out.println("Ingrese nuevo nombre");
                    leer.nextLine();
                    String nombre = leer.nextLine();
                    setNombre(nombre);
                    this.usuario = generarUsuario(nombre);
                    System.out.println("/////////NUEVO USUARIO///////////:"+usuario);
                    break;
                case 2:
                boolean aprobado= false;
                do {
                    System.out.print("ingresa contrasenia:  ");
                    contrasenia = leer.nextLine();
                    System.out.println("vuelva a ingresar la contrasenia:");
                    verificar = leer.nextLine();
                    if (contrasenia.equals(verificar)) {
                        this.password = contrasenia;
                        aprobado=true;
                    }
                } while (aprobado==false);
                    break;
                case 3:
                    int tip;
                    boolean aprobar=false;
                    do {
                        System.out.println("tipo de trabajador  1.-empleado 2.-admin");
                        tip = leer.nextInt();
                        if (tip == 1) {
                            tipo = "empleado";
                            aprobar=true;
                        }
                        if (tip == 2) {
                            tipo = "admin";
                            aprobar=true;
                        }
                        if (tip != 1 && tip != 2) {
                            System.out.println("esa no es una opcion");
                        }
                    } while (aprobar==false);
                    break;
                case 4:
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

        misDatos = nombre + telefono + direccion+ rfc+ password+ tipo;

        return misDatos.contains(cadenaAbuscar);
	}
    
    public void eliminar(){
        vigente=false;
    }

    public boolean isVigente(){
        return vigente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
