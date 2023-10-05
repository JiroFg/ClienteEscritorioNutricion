package clienteescritorionutricion.modelo.pojo;


public class RespuestaLogin {
    
    private boolean error;
    private String mensaje;
    private Medico medicoSesion;
    
    public RespuestaLogin(){}

    public RespuestaLogin(boolean error, String mensaje, Medico medicoSesion) {
        this.error = error;
        this.mensaje = mensaje;
        this.medicoSesion = medicoSesion;
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

    public Medico getMedicoSesion() {
        return medicoSesion;
    }

    public void setMedicoSesion(Medico medicoSesion) {
        this.medicoSesion = medicoSesion;
    }
    
}
