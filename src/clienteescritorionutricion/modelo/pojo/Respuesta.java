//Edson Jair Fuentes García
package clienteescritorionutricion.modelo.pojo;


public class Respuesta {
    
    private boolean error;
    private String mensaje;
    
    public Respuesta(){}

    public Respuesta(boolean error, String mensaje) {
        this.error = error;
        this.mensaje = mensaje;
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
    
}
//Edson Jair Fuentes García