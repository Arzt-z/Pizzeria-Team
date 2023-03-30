public class Ingrediente {
    private String nombre;
    private int stockEnGramos;
    private String clasificacion;
    private float precioPorGramo;

    public Ingrediente(){   
    }

    public Ingrediente(String nombre, String clasificacion, float precioPorGramo){
    this.nombre = nombre;
    this.clasificacion = clasificacion;
    this.precioPorGramo = precioPorGramo;
    }

    public String toString() {
        return nombre+" - stock: "+ stockEnGramos + "g";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStockEnGramos() {
        return stockEnGramos;
    }

    public void setStockEnGramos(int stockEnGramos) {
        this.stockEnGramos = stockEnGramos;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public float getPrecioPorGramo() {
        return precioPorGramo;
    }

    public void setPrecioPorGramo(float precioPorGramo) {
        this.precioPorGramo = precioPorGramo;
    }

   
}
