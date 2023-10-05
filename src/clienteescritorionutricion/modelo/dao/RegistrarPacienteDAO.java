package clienteescritorionutricion.modelo.dao;

import clienteescritorionutricion.modelo.ConexionWS;
import clienteescritorionutricion.modelo.pojo.Paciente;
import clienteescritorionutricion.modelo.pojo.Respuesta;
import clienteescritorionutricion.modelo.pojo.RespuestaHTTP;
import clienteescritorionutricion.utils.Constantes;
import com.google.gson.Gson;
import java.net.HttpURLConnection;


public class RegistrarPacienteDAO {
    
    public static Respuesta registrarPaciente(Paciente paciente){
        Respuesta respuesta = new Respuesta();
        String url = Constantes.URL_WS + "pacientes/registrarPaciente";
        String parametros = String.format("nombre=%s&apellidoPaterno=%s"+
                "&apellidoMaterno=%s&fechaNacimiento=%s"+
                "&sexo=%s&peso=%f&estatura=%f&"+
                "tallaInicial=%s&email=%s&"+
                "telefono=%s&contrasena=%s&"+
                "idMedico=%d",
                paciente.getNombre(),
                paciente.getApellidoPaterno(),
                paciente.getApellidoMaterno(),
                paciente.getFechaNacimiento(),
                paciente.getSexo(),
                paciente.getPeso(),
                paciente.getEstatura(),
                paciente.getTallaInicial(),
                paciente.getEmail(),
                paciente.getTelefono(),
                paciente.getContrasena(),
                paciente.getIdMedico());
        RespuestaHTTP respuestaPeticion = ConexionWS.peticionPOST(url, parametros);
        if(respuestaPeticion.getCodigoRespuesta() == HttpURLConnection.HTTP_OK){
            Gson gson = new Gson();
            respuesta = gson.fromJson(respuestaPeticion.getContenido(), Respuesta.class);
        }else{
            respuesta.setError(true);
            respuesta.setMensaje("Error al procesar la petición, por favor intentelo más tarde");
        }
        return respuesta;
    }
    
}
