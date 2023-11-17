package clienteescritorionutricion.modelo.dao;

import clienteescritorionutricion.modelo.ConexionWS;
import clienteescritorionutricion.modelo.pojo.Domicilio;
import clienteescritorionutricion.modelo.pojo.Respuesta;
import clienteescritorionutricion.modelo.pojo.RespuestaHTTP;
import clienteescritorionutricion.utils.Constantes;
import com.google.gson.Gson;
import java.net.HttpURLConnection;


public class DomicilioDAO {
  
    public static Respuesta registrarDomicilio(Domicilio domicilioPaciente){
        Respuesta respuesta = new Respuesta();
        String url = Constantes.URL_WS + "domicilio/registrarDomicilio";
        Gson gson = new Gson();
        String parametros = gson.toJson(domicilioPaciente);
        RespuestaHTTP respuestaHttp = ConexionWS.peticionPOSTJSON(url, parametros);
        if(respuestaHttp.getCodigoRespuesta() == HttpURLConnection.HTTP_OK){
            respuesta = gson.fromJson(respuestaHttp.getContenido(), Respuesta.class);
        }else{
            respuesta.setError(true);
            respuesta.setMensaje("No se pudo registrar el domicilio, intentelo más tarde");
        }
        return respuesta;
    }
    
    public static Respuesta actualizarDomicilio(Domicilio domicilioPaciente){
        Respuesta respuesta = new Respuesta();
        String url = Constantes.URL_WS + "domicilio/actualizarDomicilio";
        Gson gson = new Gson();
        String parametros = gson.toJson(domicilioPaciente);
        RespuestaHTTP respuestaHttp = ConexionWS.peticionPUTJSON(url, parametros);
        if(respuestaHttp.getCodigoRespuesta() == HttpURLConnection.HTTP_OK){
            respuesta = gson.fromJson(respuestaHttp.getContenido(), Respuesta.class);
        }else{
            respuesta.setError(true);
            respuesta.setMensaje("No se pudo actualizar el domicilio, intentelo más tarde");
        }
        return respuesta;
    }
    
    public static Domicilio obtenerDomicilio(int idPaciente){
        Domicilio domicilio = null;
        String url = Constantes.URL_WS + "domicilio/obtenerDomicilioPorPaciente/"+idPaciente;
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);
        if(respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK){
            Gson gson = new Gson();
            domicilio = gson.fromJson(respuesta.getContenido(), Domicilio.class);
        }
        return domicilio;
    }
    
}
