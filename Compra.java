import java.util.Scanner;

public class Compra extends Transaccion {
    private Proveedores proveedor;

    public Compra(){

    }

    public Compra (String fecha, String folio, Proveedores proveedor){
        super(fecha, folio);
        this.proveedor=proveedor;
    }

    public void mostrar(){
        super.mostrar();
        System.out.println("Proveedor: "+proveedor);
    }

    public String toString(){
        return "Folio: "+folio+" Fecha: "+fecha;
    }

    public String queSoy (){
        return "compra";
    }

    public void modificar(int cProveedores, Proveedo0res[] misProveedores, int cInventarios, Inventario[] inventarios){
        Scanner leer= new Scanner(System.in);
        int opcion;
        char diferencia='c';
        do{
            System.out.println("Que deseas modificar?   1.-Proveedor   2.-Otros   0.-Cancelar");
            opcion=leer.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Proveedores:");
                    for(int i=0; i<cProveedores; i++){
                        System.out.println(i+1+".- "+misProveedores);
                    }
                    System.out.println("Selecciona un proveedor");
                    int eleccion= leer.nextInt();
                    proveedor=misProveedores[eleccion-1];
                    break;
                case 2: 
                    super.modificar(cInventarios, inventarios, diferencia);
                    break;
                case 0:
                    return;
            }
        } while(true);
    }

    public void eliminar(){
        Scanner leer= new Scanner(System.in);
        char diferencia= 'c';
        System.out.println("Deseas eliminar un detalle o una venta entera?   1.-Detalle   2.-Venta");
        int eleccion= leer.nexxtInt();
        if(eleccion==1){
            super.eliminarDetalle(diferencia);
        }
        if(eleccion==2){
            super.eliminar(diferencia);
        }
    }

    public void capturar(Proveedores[] misProveedores, int cProveedores, Inventario[] inventarios){
        Scanner datos = new Scanner(System.in);
        int opcion;
        char diferencia= 'c';
        int ciclo=1;
        System.out.println("Ingresa los datos de la nueva compra");
    }








    public void agregarDetalles(int cantidad, Inventario inventarios , double precioProd){
        char diferencia='c';
        super.agregarDetalles(cantidad, inventarios, precioProd, diferencia);
    }

    public void capturarDetalle(Inventario[] inventarios, int cInventarios){
        char diferencia='c';
        super.capturarDetalle(inventarios, cInventarios, diferencia);
    }
}
