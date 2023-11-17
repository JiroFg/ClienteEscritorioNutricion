package clienteescritorionutricion.modelo.dao;

import clienteescritorionutricion.modelo.ConexionWS;
import clienteescritorionutricion.modelo.pojo.Estado;
import clienteescritorionutricion.modelo.pojo.Municipio;
import clienteescritorionutricion.modelo.pojo.RespuestaHTTP;
import clienteescritorionutricion.utils.Constantes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;


public class CatalogoDAO {
    
    public static Estado obtenerEstadoPorId(int idEstado){
        Estado estado = null;
        String url = Constantes.URL_WS+"catalogo/obtenerEstadoPorId/"+idEstado;
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);
        if(respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK){
            Gson gson = new Gson();
            estado = gson.fromJson(respuesta.getContenido(), Estado.class);
        }
        return estado;
    }
    
    public static Municipio obtenerMunicipioPorId(int idMunicipio){
        Municipio municipio = null;
        String url = Constantes.URL_WS+"catalogo/obtenerMunicipioPorId/"+idMunicipio;
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);
        if(respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK){
            Gson gson = new Gson();
            municipio = gson.fromJson(respuesta.getContenido(), Municipio.class);
        }
        return municipio;
    }

    public static List<Estado> obtenerEstados(){
        List<Estado> estados = new ArrayList<>();
        String url = Constantes.URL_WS + "catalogo/obtenerEstados";
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);
        if(respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK){
            Gson gson = new Gson();
            Type tipoListaEstado = new TypeToken<List<Estado>>(){}.getType();
            estados = gson.fromJson(respuesta.getContenido(), tipoListaEstado);
        }
        return estados;
    }
    
    public static List<Municipio> obtenerMunicipioPorEstado(int idEstado){
        List<Municipio> municipios = new ArrayList<>();
        String url = Constantes.URL_WS + "catalogo/obtenerMunicipiosPorEstado/" + idEstado;
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);
        if(respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK){
            Gson gson = new Gson();
            Type tipoListaMunicipio = new TypeToken<List<Municipio>>(){}.getType();
            municipios = gson.fromJson(respuesta.getContenido(), tipoListaMunicipio);
        }
        return municipios;
    }
    
}
