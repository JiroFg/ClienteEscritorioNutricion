//Edson Jair Fuentes García
package clienteescritorionutricion.modelo.dao;

import clienteescritorionutricion.modelo.ConexionWS;
import clienteescritorionutricion.modelo.pojo.RespuestaHTTP;
import clienteescritorionutricion.modelo.pojo.RespuestaLogin;
import clienteescritorionutricion.utils.Constantes;
import com.google.gson.Gson;
import java.net.HttpURLConnection;


public class InicioSesionDAO {
    
    public static RespuestaLogin iniciarSesion(String numeroPersonal, String contrasena){
        RespuestaLogin respuesta = new RespuestaLogin();
        String url = Constantes.URL_WS + "autenticacion/loginEscritorio";
        String parametros = String.format("numeroPersonal=%s&contrasena=%s", numeroPersonal, contrasena);
        RespuestaHTTP respuestaPeticion = ConexionWS.peticionPOST(url, parametros);
        if(respuestaPeticion.getCodigoRespuesta() == HttpURLConnection.HTTP_OK){
            Gson gson = new Gson();
            respuesta = gson.fromJson(respuestaPeticion.getContenido(), RespuestaLogin.class);
        }else{
            respuesta.setError(true);
            respuesta.setMensaje("Error al procesar la petición, por favor intentelo más tarde");
        }
        return respuesta;
    }
    
}
//Edson Jair Fuentes García