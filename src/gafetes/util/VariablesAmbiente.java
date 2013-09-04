/*
 * VariablesAmbiente.java
 *
 * Created on 29 de junio de 2008, 12:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gafetes.util;

/**
 *
 * @author jalafita
 */
public class VariablesAmbiente {
     static DataSourceConfiguration ds;
    /** Creates a new instance of VariablesAmbiente */
    public  VariablesAmbiente() {
        ApplicationConfiguration conf = new ApplicationConfiguration();
        ds = conf.getDataSource();
    }
    

    public static  String getRutaFotos(){
        ApplicationConfiguration conf = new ApplicationConfiguration();
        ds = conf.getDataSource();
        return ds.getRutaFotos();
        //return "c:\\gafetes\\fotos";
    }
    
    public static  String getRutaFotoNoExiste(){
        ApplicationConfiguration conf = new ApplicationConfiguration();
        ds = conf.getDataSource();
        return ds.getRutaFotoNoExiste();
      //  return "c:\\gafetes\\fotos";
    }
    
    public static String getArchivoConfiguracion(){
        return "configuracion.xml";
    }
    
    public static String getArchivoDBConfiguracion(){
        return "datasource.xml";
    }
    
    public static  String getRutaCarpetaFotos(){
        ApplicationConfiguration conf = new ApplicationConfiguration();
        ds = conf.getDataSource();
        return ds.getRutaCarpetaFotos();
        //return "c:\\gafetes\\fotos";
    }
    
}
