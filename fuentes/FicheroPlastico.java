public class FicheroPlastico extends FicheroClasificador{
    private String tipoPlastico;

    public FicheroPlastico(String codigo, String descripcion, Double peso, String tipoPlastico){
        super(codigo, descripcion, peso);
        this.tipoPlastico = tipoPlastico;
    }
}