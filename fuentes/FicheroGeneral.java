public class FicheroGeneral extends FicheroClasificador{
    private String origen;

    public FicheroGeneral(String codigo, String descripcion, Double peso, String origen){
        super(codigo, descripcion, peso);
        this.origen = origen;
    }
}