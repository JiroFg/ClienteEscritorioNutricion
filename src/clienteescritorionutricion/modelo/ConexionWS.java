//Edson Jair Fuentes García
package clienteescritorionutricion.modelo;

import clienteescritorionutricion.modelo.pojo.RespuestaHTTP;
import clienteescritorionutricion.utils.Constantes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConexionWS{
    
    private static String obtenerContenidoWS(InputStream inputWS) throws IOException{
        InputStreamReader inputDatos = new InputStreamReader(inputWS);
        BufferedReader in = new BufferedReader(inputDatos);
        String inputLine;
        StringBuffer respuestaEntrada = new StringBuffer();
        while((inputLine = in.readLine()) != null){
            respuestaEntrada.append(inputLine);
        }
        in.close();
        return respuestaEntrada.toString();
    }
    
    public static RespuestaHTTP peticionPUTImg(String url, byte[] img){
        RespuestaHTTP respuesta = new RespuestaHTTP();
        try{
            URL urlDestino = new URL(url);
            HttpURLConnection conexionHttp = (HttpURLConnection) urlDestino.openConnection();
            conexionHttp.setRequestMethod("PUT");
            conexionHttp.setDoOutput(true);
            OutputStream os = conexionHttp.getOutputStream();
            os.write(img);
            os.flush();
            os.close();
            int codigoRespuesta = conexionHttp.getResponseCode();
            respuesta.setCodigoRespuesta(codigoRespuesta);
            if(codigoRespuesta == HttpURLConnection.HTTP_OK){
                respuesta.setContenido(obtenerContenidoWS(conexionHttp.getInputStream()));
            }else{
                respuesta.setContenido("Codigo de respuesta HTTP: "+codigoRespuesta);
            }
        }catch(MalformedURLException e){
            respuesta.setCodigoRespuesta(Constantes.ERROR_URL);
            respuesta.setContenido("Error: No se pudo establecer conexión a la dirección proporcionada");
        }catch(IOException io){
            respuesta.setCodigoRespuesta(Constantes.ERROR_PETICION);
            respuesta.setContenido("Error: No se pudo realizar la solicitud correspondiente");
        }
        return respuesta;
    }
    
    public static RespuestaHTTP peticionPOST(String url, String parametros){
        RespuestaHTTP respuesta = new RespuestaHTTP();
        try{
            URL urlDestino = new URL(url);
            HttpURLConnection conexionHttp = (HttpURLConnection) urlDestino.openConnection();
            conexionHttp.setRequestMethod("POST");
            conexionHttp.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conexionHttp.setDoOutput(true);
            OutputStream os = conexionHttp.getOutputStream();
            os.write(parametros.getBytes());
            os.flush();
            os.close();
            int codigoRespuesta = conexionHttp.getResponseCode();
            respuesta.setCodigoRespuesta(codigoRespuesta);
            if(codigoRespuesta == HttpURLConnection.HTTP_OK){
                respuesta.setContenido(obtenerContenidoWS(conexionHttp.getInputStream()));
            }else{
                respuesta.setContenido("Codigo de respuesta HTTP: "+codigoRespuesta);
            }
        }catch(MalformedURLException e){
            respuesta.setCodigoRespuesta(Constantes.ERROR_URL);
            respuesta.setContenido("Error: No se pudo establecer conexión a la dirección proporcionada");
        }catch(IOException io){
            respuesta.setCodigoRespuesta(Constantes.ERROR_PETICION);
            respuesta.setContenido("Error: No se pudo realizar la solicitud correspondiente");
        }
        return respuesta;
    }
    
    public static RespuestaHTTP peticionPOSTJSON(String url, String json){
        RespuestaHTTP respuesta = new RespuestaHTTP();
        try{
            URL urlDestino = new URL(url);
            HttpURLConnection conexionHttp = (HttpURLConnection) urlDestino.openConnection();
            conexionHttp.setRequestMethod("POST");
            conexionHttp.setRequestProperty("Content-Type", "application/json");
            conexionHttp.setDoOutput(true);
            OutputStream os = conexionHttp.getOutputStream();
            os.write(json.getBytes());
            os.flush();
            os.close();
            int codigoRespuesta = conexionHttp.getResponseCode();
            respuesta.setCodigoRespuesta(codigoRespuesta);
            if(codigoRespuesta == HttpURLConnection.HTTP_OK){
                respuesta.setContenido(obtenerContenidoWS(conexionHttp.getInputStream()));
            }else{
                respuesta.setContenido("Codigo de respuesta HTTP: "+codigoRespuesta);
            }
        }catch(MalformedURLException e){
            respuesta.setCodigoRespuesta(Constantes.ERROR_URL);
            respuesta.setContenido("Error: No se pudo establecer conexión a la dirección proporcionada");
        }catch(IOException io){
            respuesta.setCodigoRespuesta(Constantes.ERROR_PETICION);
            respuesta.setContenido("Error: No se pudo realizar la solicitud correspondiente");
        }
        return respuesta;
    }
 
    public static RespuestaHTTP peticionGET(String url){
        RespuestaHTTP respuesta = new RespuestaHTTP();
        try{
            URL urlDestino = new URL(url);
            HttpURLConnection conexionHttp = (HttpURLConnection) urlDestino.openConnection();
            conexionHttp.setRequestMethod("GET");
            int codigoRespuesta = conexionHttp.getResponseCode();
            respuesta.setCodigoRespuesta(codigoRespuesta);
            if(codigoRespuesta == HttpURLConnection.HTTP_OK){
                respuesta.setContenido(obtenerContenidoWS(conexionHttp.getInputStream()));
            }else{
                respuesta.setContenido("Codigo de respuesta HTTP: "+codigoRespuesta);
            }
        }catch(MalformedURLException e){
            respuesta.setCodigoRespuesta(Constantes.ERROR_URL);
            respuesta.setContenido("Error: No se pudo establecer conexión a la dirección proporcionada");
        }catch(IOException io){
            respuesta.setCodigoRespuesta(Constantes.ERROR_PETICION);
            respuesta.setContenido("Error: No se pudo realizar la solicitud correspondiente");
        }
        return respuesta;
    }
    
    public static RespuestaHTTP peticionPUT(String url, String parametros){
        RespuestaHTTP respuesta = new RespuestaHTTP();
        try{
            URL urlDestino = new URL(url);
            HttpURLConnection conexionHttp = (HttpURLConnection) urlDestino.openConnection();
            conexionHttp.setRequestMethod("PUT");
            conexionHttp.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conexionHttp.setDoOutput(true);
            OutputStream os = conexionHttp.getOutputStream();
            os.write(parametros.getBytes());
            os.flush();
            os.close();
            int codigoRespuesta = conexionHttp.getResponseCode();
            respuesta.setCodigoRespuesta(codigoRespuesta);
            if(codigoRespuesta == HttpURLConnection.HTTP_OK){
                respuesta.setContenido(obtenerContenidoWS(conexionHttp.getInputStream()));
            }else{
                respuesta.setContenido("Codigo de respuesta HTTP: "+codigoRespuesta);
            }
        }catch(MalformedURLException e){
            respuesta.setCodigoRespuesta(Constantes.ERROR_URL);
            respuesta.setContenido("Error: No se pudo establecer conexión a la dirección proporcionada");
        }catch(IOException io){
            respuesta.setCodigoRespuesta(Constantes.ERROR_PETICION);
            respuesta.setContenido("Error: No se pudo realizar la solicitud correspondiente");
        }
        return respuesta;
    }
    
    public static RespuestaHTTP peticionPUTJSON(String url, String json){
        RespuestaHTTP respuesta = new RespuestaHTTP();
        try{
            URL urlDestino = new URL(url);
            HttpURLConnection conexionHttp = (HttpURLConnection) urlDestino.openConnection();
            conexionHttp.setRequestMethod("PUT");
            conexionHttp.setRequestProperty("Content-Type", "application/json");
            conexionHttp.setDoOutput(true);
            OutputStream os = conexionHttp.getOutputStream();
            os.write(json.getBytes());
            os.flush();
            os.close();
            int codigoRespuesta = conexionHttp.getResponseCode();
            respuesta.setCodigoRespuesta(codigoRespuesta);
            if(codigoRespuesta == HttpURLConnection.HTTP_OK){
                respuesta.setContenido(obtenerContenidoWS(conexionHttp.getInputStream()));
            }else{
                respuesta.setContenido("Codigo de respuesta HTTP: "+codigoRespuesta);
            }
        }catch(MalformedURLException e){
            respuesta.setCodigoRespuesta(Constantes.ERROR_URL);
            respuesta.setContenido("Error: No se pudo establecer conexión a la dirección proporcionada");
        }catch(IOException io){
            respuesta.setCodigoRespuesta(Constantes.ERROR_PETICION);
            respuesta.setContenido("Error: No se pudo realizar la solicitud correspondiente");
        }
        return respuesta;
    }
    
    public static RespuestaHTTP peticionDELETE(String url, String parametros){
        RespuestaHTTP respuesta = new RespuestaHTTP();
        try{
            URL urlDestino = new URL(url);
            HttpURLConnection conexionHttp = (HttpURLConnection) urlDestino.openConnection();
            conexionHttp.setRequestMethod("DELETE");
            conexionHttp.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conexionHttp.setDoOutput(true);
            OutputStream os = conexionHttp.getOutputStream();
            os.write(parametros.getBytes());
            os.flush();
            os.close();
            int codigoRespuesta = conexionHttp.getResponseCode();
            respuesta.setCodigoRespuesta(codigoRespuesta);
            if(codigoRespuesta == HttpURLConnection.HTTP_OK){
                respuesta.setContenido(obtenerContenidoWS(conexionHttp.getInputStream()));
            }else{
                respuesta.setContenido("Codigo de respuesta HTTP: "+codigoRespuesta);
            }
        }catch(MalformedURLException e){
            respuesta.setCodigoRespuesta(Constantes.ERROR_URL);
            respuesta.setContenido("Error: No se pudo establecer conexión a la dirección proporcionada");
        }catch(IOException io){
            respuesta.setCodigoRespuesta(Constantes.ERROR_PETICION);
            respuesta.setContenido("Error: No se pudo realizar la solicitud correspondiente");
        }
        return respuesta;
    }
}
//Edson Jair Fuentes García