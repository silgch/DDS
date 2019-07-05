package API;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import ow.entidades.ClimaCiudad;
import ow.entidades.OWError;
import ow.entidades.RetornoOW;

public class Get_OpenWeather {
	
	public String codigoCiudad = "3433955"; // por defecto es CABA
	
	public void codigoCiudad(String _codigoCiudad) {
		this.codigoCiudad = _codigoCiudad;
	}
	
	public RetornoOW obtenerClima(){
		String codigoUsuario = "1cb3cd02ce6977d6c8491966de7ecc9a";
		
		String url = "http://api.openweathermap.org/data/2.5/forecast?id="+codigoCiudad+"&APPID="+codigoUsuario;

        System.out.println("Inicio: Inicia GetDomicilio");
        System.out.println("url: " + url);
        
        RetornoOW retorno = new RetornoOW();
        ClimaCiudad cc = new ClimaCiudad();
        //devuelve la primer posicion como caso 200 de la lista de domicilios.
        
        
        HttpURLConnection con = null;
        StringBuilder sb = new StringBuilder(); //para conseguir lo que me trae el servicio
        
       	
        String codigoError = "";
        String mensajeError = "";
        String respuesta = "";
    	
       try{
        	System.out.println("Entro al try");
        	//hago conexion
            URL obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();
//            con.setRequestProperty("accept", "*/*");

            con.setRequestMethod("GET");

             
        	System.out.println("Paso los setRequestMethod");
        
        	int responseCode = con.getResponseCode();
            codigoError = "" + con.getResponseCode();
            mensajeError = con.getResponseMessage();
            System.out.println("responseCode: " + responseCode);
            System.out.println("codigoError: " + codigoError);
            System.out.println("mensajeError: " + mensajeError);
        	
            switch(responseCode) {
            
            case 200:
            
          //lectura de la url
            InputStream is = con.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8" );
			
        	System.out.println("Paso el inputStream");

			//lectura del buffer
			BufferedReader reader;
			String line = null;
			reader = new BufferedReader(isr);
			System.out.println("Paso el buffer");
			
			while ((line = reader.readLine()) != null) {
	        	System.out.println("Response: " + line);
				sb.append(line);
			}

			Gson gson = new Gson();
			cc = gson.fromJson(sb.toString(), ClimaCiudad.class);
			
			retorno.getClimaCiudad().add(cc);
			
			reader.close();
	
			break;
            
	
            default:
        		
        		InputStream isError = con.getErrorStream();
        		InputStreamReader isrError = new InputStreamReader(isError, "UTF-8" );
                
                String inputLineError;
                StringBuilder responseError = new StringBuilder();
                BufferedReader inError;
                inError= new BufferedReader(isrError);
                System.out.println("paso el buffer");
                
                while ((inputLineError = inError.readLine()) != null) {
                	responseError.append(inputLineError);
                }
                
                respuesta = responseError.toString();
                System.out.println("Asigno una respuesta");
                inError.close();
                
        		System.out.println(responseCode);
        		System.out.println(respuesta);
        		
        		Gson Erroresgson = new Gson();
        		OWError Bad_request= new OWError();
        		Bad_request = Erroresgson.fromJson(respuesta, OWError.class);

        		
        		retorno.getErrores().add(Bad_request);
        		}

        }
	        catch(Exception e){
	        	OWError err = new OWError();
	        	e.printStackTrace();
		        err.setMessage("Fallo la conexion con APIPersonas");
	    		retorno.getErrores().add(err);
				return retorno;
        }
      
        return retorno;
       
	}

}


//https://openweathermap.org/appid
//https://openweathermap.org/current

//copiar el contenido de
//https://samples.openweathermap.org/data/2.5/forecast?id=524901&appid=b1b15e88fa797225412429c1c50c122a1

//pegarlo en 
//https://jsonformatter.curiousconcept.com/


// caso fallo
//http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=6180a6bce25438c5c7c4d4cda2f16c87
