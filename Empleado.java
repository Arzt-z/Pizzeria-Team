import java.util.Scanner;

public class Empleado extends Persona {

    private String nombre;
    private double sueldo;
    private int horasDeTrabajo;
    private int diasTrabajados;
    private String usuario;
    private String password;
    private String tipo;
    private boolean vigente;

    public Empleado() {
        horasDeTrabajo = 8;
        diasTrabajados = 7;
        sueldo = 250.33 / horasDeTrabajo;
        vigente=true;
    }

    public Empleado(String nombre, String telefono, String direccion, String rfc, String password, String tipo) {
        super(telefono, direccion, rfc);
        this.nombre = nombre;
        this.usuario = generarUsuario(nombre);
        this.password = password;
        this.tipo = tipo;
        horasDeTrabajo = 8;
        diasTrabajados = 7;
        sueldo = 250.33 / horasDeTrabajo;
        vigente=true;
    }

    public String toString() {
        return "nombre " + nombre;
    }

    public String quienSoy() {
        return "Empleado";
    }

    // alguien haga el mostrar o nose
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
        char diferenciador = 'e';
        String verificar, contraeña;
        System.out.print("nombre  :");
        nombre = leer.nextLine();
        do {
            System.out.print("ingresa contraseña:  ");
            contraeña = leer.nextLine();
            System.out.println("vuelva a ingresar la contraseña:");
            verificar = leer.nextLine();
            if (contraeña == verificar) {
                password = contraeña;
            }
        } while (contraeña != verificar);
        int tip;
        do {
            System.out.print("tipo de trabajador  1.-empleado 2.-admin");
            tip = leer.nextInt();
            if (tip == 1) {
                tipo = "empleado";
            }
            if (tip == 2) {
                tipo = "admin";
            }
            if (tip != 1 || tip != 2) {
                System.out.println("esa no es una opcion");
            }
        } while (tip != 1 || tip != 2);

        super.capturar(diferenciador);
        this.usuario = generarUsuario(nombre);

    }


    public void modificar() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Que deseas modificar?");
        int ciclo = 1;
        String verificar, contraeña;
        do {
            System.out.println("1.-nombre 2.-contraseña 3.-puesto 4.-Otros  0.-cancelar");
            int atributo = leer.nextInt();
            switch (atributo) {
                case 1:
                    System.out.println("Ingrese nuevo nombre");
                    leer.nextLine();
                    String nombre = leer.nextLine();
                    setNombre(nombre);
                    break;
                case 2:
                    do {
                        System.out.print("ingresa contraseña:  ");
                        contraeña = leer.nextLine();
                        System.out.println("vuelva a ingresar la contraseña:");
                        verificar = leer.nextLine();
                        if (contraeña == verificar) {
                            setPassword(contraeña);
                        }
                    } while (contraeña != verificar);
                    break;
                case 3:
                    int tip;
                    do {
                        System.out.print("tipo de trabajador  1.-empleado 2.-admin");
                        tip = leer.nextInt();
                        if (tip == 1) {
                            tipo = "empleado";
                        }
                        if (tip == 2) {
                            tipo = "admin";
                        }
                        if (tip != 1 || tip != 2) {
                            System.out.println("esa no es una opcion");
                        }
                    } while (tip != 1 || tip != 2);
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

    public void eliminar(){
        vigente=false;
    }

    public boolean isVigente(){
        return vigente;
    }

    public double sueldoSemana() {
        double sueldoSemana = diasTrabajados * horasDeTrabajo * sueldo;
        return sueldoSemana;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getHorasDeTrabajo() {
        return horasDeTrabajo;
    }

    public void setHorasDeTrabajo(int horasDeTrabajo) {
        this.horasDeTrabajo = horasDeTrabajo;
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(int diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
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
