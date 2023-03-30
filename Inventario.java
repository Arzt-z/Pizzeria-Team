public class Inventario{
    private int cIngredientes; 
    private Ingrediente[] ingredientes = new Ingrediente[500];


    public void listarIngredientes() {
        System.out.println("----------Ingredientes----------");
        for (int i = 0; i < cIngredientes; i++) {
                System.out.println(i + 1 + ".-" + ingredientes[i].toString() +" " + ingredientes[i].getPrecioPorGramo() ) ;
        }
    }

    public void agregarIngrediente(String nombre, String clasificacion, float precioPorGramo) {
        ingredientes[cIngredientes++]=new Ingrediente(nombre, clasificacion, precioPorGramo);
        
    }


}
