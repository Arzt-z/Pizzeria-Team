
public class Inventario{
    private String nombre;
    private int stock;
    private float precio;
    private String clasificacion;

    public Inventario(){   
    }

    public Inventario(String nombre, String clasificacion, float precio){
    this.nombre = nombre;
    this.clasificacion = clasificacion;
    this.precio = precio;
    }

    protected void capturar() {

    }

    public String toString() {
        if(clasificacion.equals("producto")){
            return nombre+" - stock: "+ stock ;
        }else{
            return nombre+" - stock: "+ stock +"g";
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }


}