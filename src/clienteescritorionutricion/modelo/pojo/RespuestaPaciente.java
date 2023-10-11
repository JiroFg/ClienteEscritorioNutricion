//Edson Jair Fuentes García
package clienteescritorionutricion.modelo.pojo;

import java.util.List;


public class RespuestaPaciente {
    
    private boolean error;
    private String mensaje;
    private List<Paciente> listaPacientes;
    
    public RespuestaPaciente(){}

    public RespuestaPaciente(boolean error, String mensaje, List<Paciente> listaPacientes) {
        this.error = error;
        this.mensaje = mensaje;
        this.listaPacientes = listaPacientes;
    }
    
    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(List<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }
    
    @Override
    public String toString() {
        return "RespuestaPaciente{" + "error=" + error + ", mensaje=" + mensaje + ", listaPacientes=" + listaPacientes + '}';
    }
    
}
//Edson Jair Fuentes García