import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class Compra extends Transaccion {
    private Proveedores proveedor;
    private Proveedores[] misProveedores;
    private int cProveedores;
    private Inventario[] inventarios;
    private int cInventarios;
    private Pizza pizzas[];
    private int cPizza;
    
    public Compra(int cProveedores, Proveedores[] misProveedores, int cInventarios, Inventario[] inventarios, int cPizzas,Pizza[] pizzas){
        this.misProveedores=misProveedores;
        this.cProveedores=cProveedores;
        this.inventarios=inventarios;
        this.cInventarios=cInventarios;
        this.pizzas=pizzas;
        this.cPizza=cPizzas;
    }

    public Compra (String fecha, String folio, Proveedores proveedor,int cProveedores, Proveedores[] misProveedores, int cInventarios, Inventario[] inventarios, int cPizzas,Pizza[] pizzas){
        super(fecha, folio);
        this.proveedor=proveedor;
        this.misProveedores=misProveedores;
        this.cProveedores=cProveedores;
        this.inventarios=inventarios;
        this.cInventarios=cInventarios;
        this.pizzas=pizzas;
        this.cPizza=cPizzas;
    }

    public void mostrar(){
        System.out.println("Proveedor: "+proveedor);
        super.mostrar();
    }

    public String toString(){
        return "Folio: "+folio+" Fecha: "+fecha;
    }

    public String queSoy (){
        return "compra";
    }

    public void modificar(){
        Scanner leer= new Scanner(System.in);
        int opcion;
        char diferencia='c';
        int error=0;
        do{
            System.out.println("Que deseas modificar?   1.-Proveedor   2.-Otros   0.-Cancelar");
            opcion=leer.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Proveedores:");
                    
                    for(int i=0; i<cProveedores; i++){
                        System.out.println(i+1+".- "+misProveedores);
                    }
                    do{   
                    System.out.println("Selecciona un proveedor");
                    int eleccion= leer.nextInt()-1;
                    if(eleccion<0 || eleccion>cProveedores){
                        System.out.println("ESA NO ES UNA OPCION");
                        error=1;
                    }else{
                    proveedor=misProveedores[eleccion];
                    error=1;}
                    }while(error==0);
                    break;
                case 2: 
                    super.modificar(cInventarios, inventarios, diferencia, cPizza, pizzas);
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
        int eleccion= leer.nextInt();
        if(eleccion==1){
            super.eliminarDetalle(diferencia);
        }
        if(eleccion==2){
            super.eliminar(diferencia);
        }
    }

    public void capturar(){
        Scanner datos = new Scanner(System.in);
        int opcion;
        char diferencia= 'c';
        for(int i=0; i<cProveedores; i++){
            System.out.println(i+1+".-"+misProveedores[i]);
        }
        System.out.println("Selecciona un proveedor");
        opcion= datos.nextInt();
        proveedor= misProveedores[opcion-1];
        System.out.println("Ingresa los datos compra");
        super.capturar(inventarios, cInventarios, diferencia);
    }

    public boolean buscar(String cadenaAbuscar){
        if(super.buscar(cadenaAbuscar)==true){
            return true;
        }
        String datos=" "+ proveedor;
        if(datos.contains(cadenaAbuscar)==true){
            return true;
        }else{
            return false;
        }
    }

    public void agregarDetalles(int cantidad, Inventario inventarios , double precioProd){
        char diferencia='c';
        super.agregarDetalles(cantidad, inventarios, precioProd, diferencia);
    }

    public void capturarDetalle(Inventario[] inventarios, int cInventarios){
        char diferencia='c';
        super.capturarDetalle(inventarios, cInventarios, diferencia);
    }
    
    public void getDetalles(){
        char diferencia='c';
        super.getDetalles(diferencia);
    }

    public Proveedores getProveedor(){
        return proveedor;
    }

    public void setProveedor(Proveedores proveedor){
        this.proveedor= proveedor;
    }
}
