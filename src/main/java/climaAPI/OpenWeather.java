package climaAPI;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;

import excepciones.NoConexionApiException;
import climaAPI.openWeather.ClimaCiudad;
import climaAPI.openWeather.OWError;
import climaAPI.openWeather.RetornoOW;

public class OpenWeather implements ClimaAdapter{
	
	public String nombreDeAPI(){return "OpenWeather";}
	
	//public String codigoCiudad = "3433955"; // por defecto es CABA
	
	public RetornoOW temperaturaActual(String codigoCiudad){
		String codigoUsuario = Key.getKey(); //Agregar clase con codigo personal y poner la clase key  archivo el 
		
		String url = "http://api.openweathermap.org/data/2.5/forecast?id="+codigoCiudad+"&APPID="+codigoUsuario;
		
		System.out.println("");
        System.out.println("Inicio: Inicia GetClima");
        System.out.println("Conectado a: " + url);
        
        RetornoOW retorno = new RetornoOW();
        ClimaCiudad cc = new ClimaCiudad();
        //devuelve la primer posicion como caso 200 de la lista de domicilios.
        
        
        HttpURLConnection con = null;
        StringBuilder sb = new StringBuilder(); //para conseguir lo que me trae el servicio
        
       	
        //String codigoError = "";
        //String mensajeError = "";
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
        	//codigoError = "" + con.getResponseCode();
            //mensajeError = con.getResponseMessage();
            //System.out.println("responseCode: " + responseCode);
            //System.out.println("codigoError: " + codigoError);
            //System.out.println("mensajeError: " + mensajeError);
        	
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
		        err.setMessage("Fallo la conexion con API");
	    		retorno.getErrores().add(err);
				return retorno;
        }
      
        return retorno;
       
	}
	
	@Override
	public double obtenerClima(String unCodigoCiudad) throws NoConexionApiException {
		/* como me devuelve una cantidad n de medidas, algunas estan rotas, la idea fue
		 *  refinar la busqueda devolviendo solo un promedio de valores que esten entre
		 *  un intervalo +- 0.25 del valor promedio*/
		
		RetornoOW aux = this.temperaturaActual(unCodigoCiudad);
		double promedio=0;
		double sumaTotal=0;
		double auxiliarParaRefinar =0;
		double retorno = 0;
		ArrayList<Double> listaAuxiliar = new ArrayList<Double>();
		if(aux.getErrores().size()>0) {
			throw new NoConexionApiException(aux.getErrores().get(0).getMessage());
		}
		else {
			int cantidadMedidas = aux.getClimaCiudad().get(0).getList().size();
			
			for(int i=0;i<cantidadMedidas;i++) { 
				sumaTotal=sumaTotal+(aux.getClimaCiudad().get(0).getList().get(i).getMain().getTemp() - pasajeDeKelvin);
			}
			promedio = sumaTotal/cantidadMedidas;
			
			for(int i=0;i<cantidadMedidas;i++) {
				auxiliarParaRefinar =aux.getClimaCiudad().get(0).getList().get(i).getMain().getTemp() - pasajeDeKelvin;
				if(auxiliarParaRefinar>(promedio+(promedio*0.25))
						|| auxiliarParaRefinar<(promedio-(promedio*0.25))) {
				}
				else {
					listaAuxiliar.add(auxiliarParaRefinar);
				}
			}
			for( Double elemento : listaAuxiliar) {
				retorno = retorno + elemento;
			}
			return retorno/cantidadMedidas;
			}	
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
