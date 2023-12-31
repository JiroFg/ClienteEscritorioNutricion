//Edson Jair Fuentes García
package clienteescritorionutricion.modelo.pojo;


public class RespuestaLogin {
    
    private boolean error;
    private String mensaje;
    private Medico medico;
    
    public RespuestaLogin(){}

    public RespuestaLogin(boolean error, String mensaje, Medico medicoSesion) {
        this.error = error;
        this.mensaje = mensaje;
        this.medico = medicoSesion;
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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
}
//Edson Jair Fuentes García