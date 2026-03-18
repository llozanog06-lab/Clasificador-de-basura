public class FicheroOrganico extends FicheroClasificador{
    private String fechaCaducidad;

    public FicheroOrganico(String codigo, String descripcion, Double peso, String fechaCaducidad){
        super(codigo, descripcion, peso);
        this.fechaCaducidad = fechaCaducidad;
    }
}