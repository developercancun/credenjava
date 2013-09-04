package gafetes.db;

import gafetes.util.DataSourceConfiguration;
import java.io.IOException;
import java.util.Hashtable;
import org.xml.sax.SAXException;
import org.apache.commons.digester.Digester;

public class SampleDigester
{
    private Hashtable dataSources = new Hashtable();
    private DataSource dbconf;        
    private DataSourceConfiguration conf;
	
    public static void main(String[] args)
    {
        SampleDigester sample = new SampleDigester();

        try
        {
          sample.xml2Object();
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
    }

    public void xml2Object()  throws SAXException
    {
        Digester digester = new Digester();
        digester.push(this);        
        digester.addCallMethod("datasources/datasource", "addDataSource", 5 );
        digester.addCallParam("datasources/datasource/name", 0);
        digester.addCallParam("datasources/datasource/driver", 1);
        digester.addCallParam("datasources/datasource/url", 2);
        digester.addCallParam("datasources/datasource/username", 3);
        digester.addCallParam("datasources/datasource/password", 4);
	try{	
            //java.io.InputStream xmlFile =  getClass().getResourceAsStream("xml/datasource.xml");
            java.io.InputStream xmlFile 
            =  new java.io.FileInputStream(gafetes.util.VariablesAmbiente.getArchivoDBConfiguracion());        
            digester.parse(xmlFile);
        }catch( java.io.IOException ioex ){
            System.out.println();
        }
        
    }


    public void xmlConfiguration2Object()  throws SAXException
    {
        Digester digester = new Digester();
        digester.push(this);        
        digester.addCallMethod("datasources/datasource", "addDataConfigurationSource", 4 );
        digester.addCallParam("datasources/datasource/rutaFotos", 0);
        digester.addCallParam("datasources/datasource/rutaCarpetaFotos", 1);
        digester.addCallParam("datasources/datasource/rutaFotoNoExiste", 2);        
        digester.addCallParam("datasources/datasource/passPhrase", 3); 
	try{	
            //java.io.InputStream xmlFile =  getClass().getResourceAsStream("xml/datasource.xml");
            java.io.InputStream xmlFile 
            =  new java.io.FileInputStream(gafetes.util.VariablesAmbiente.getArchivoConfiguracion());        
            digester.parse(xmlFile);
        }catch( java.io.IOException ioex ){
            System.out.println();
        }        
    }


    public void addDataSource(String name,
                            String driver,
                            String url,
                            String userName,
                            String password)
    {
        DataSource dataSource = new DataSource(name, driver,url, userName, password);
        //dataSources.put(name, dataSource);    	
        dbconf = dataSource;
    }
    
    
     public void addDataConfigurationSource(String rutaFotos,
                            String rutaCarpetaFotos,
                            String rutaFotoNoExiste, String passPhrase
                            )
    {
        DataSourceConfiguration dataSource = new DataSourceConfiguration(rutaFotos,rutaCarpetaFotos,rutaFotoNoExiste, passPhrase);
        //dataSources.put(name, dataSource);    	
        conf = dataSource;
    }
  
    public DataSource getDBConfiguration(){
            return  dbconf;
    }
        
    public DataSourceConfiguration getConfiguration(){
            return  conf;
    }
}