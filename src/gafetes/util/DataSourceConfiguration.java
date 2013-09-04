/*
 * DataSourceConfiguration.java
 *
 * Created on 9 de julio de 2008, 04:41 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gafetes.util;

public class DataSourceConfiguration
{
  private String rutaFotos;
  private String rutaCarpetaFotos;
  private String rutaFotoNoExiste;
  private String passPhrase;


  public DataSourceConfiguration(String rutaFotos, String rutaCarpetaFotos, 
          String rutaFotoNoExiste, String passPhrase)
  {
    this.rutaFotos = rutaFotos;
    this.rutaCarpetaFotos = rutaCarpetaFotos;
    this.rutaFotoNoExiste =rutaFotoNoExiste;   
    this.passPhrase = passPhrase;
  }
 
  
    public DataSourceConfiguration()
    {
    }

    public String getRutaFotos()
    {
    return rutaFotos;
    }
   
    public void setRutaFotos(String rutaFotos)
    {
    this.rutaFotos = rutaFotos;
    }
   
    public String getRutaFotoNoExiste()
    {
        return rutaFotoNoExiste;
    }

    public void setRutaFotoNoExiste(String ruta)
    {
        this.rutaFotoNoExiste = ruta;
    }
    
   
    public String getRutaCarpetaFotos()
    {
        return rutaCarpetaFotos;
    }
	
    public void setRutaCarpetaFotos(String ruta)
    {
     this.rutaCarpetaFotos = ruta;
    }

    public String getPassPhrase()
    {
        return passPhrase;
    }
	
    public void setPassPhrase(String passPhrase)
    {
        this.passPhrase = passPhrase;
    }
  
}
