package clienteescritorionutricion.modelo.pojo;


public class Municipio {
    private int idMunicipio;
    private String nombre;
    private int idEstado;

    public Municipio() {
    }

    public Municipio(int idMunicipio, String nombre, int idEstado) {
        this.idMunicipio = idMunicipio;
        this.nombre = nombre;
        this.idEstado = idEstado;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public String toString() {
        return "- " + nombre;
    }
    
    
}
