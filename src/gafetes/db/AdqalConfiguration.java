package gafetes.db;

import gafetes.beans.Usuario;
public class AdqalConfiguration {

	private DataSource ds ;


	public AdqalConfiguration() {
	}	
	
	
	public void setDataSource(DataSource ds) {
		this.ds = ds; 
	}
	
	
	public DataSource getDataSource() {
            // Here is an example that uses the class
            try {
            // Create encrypter/decrypter class

                    SampleDigester xmlDigester = new SampleDigester();

                    try
                    {
                        xmlDigester.xml2Object();
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    gafetes.util.DataSourceConfiguration dsc  = gafetes.util.ApplicationConfiguration.getDataSource();
                    
                    DataSource ds = xmlDigester.getDBConfiguration(); 
                    DataSource ds2 = new DataSource();
                    DesEncrypter encrypter = new DesEncrypter( dsc.getPassPhrase() );

                    Usuario user = new Usuario(); 
                    //user.setNombre(encrypter.decrypt(ds.getUserName()));
                    //user.setPassword(encrypter.decrypt(ds.getPassword()));
                    
                    user.setNombre(ds.getUserName());
                    user.setPassword(ds.getPassword());
                    
                    
                    
                    ds2.setUserName(user.getNombre());
                    ds2.setPassword(user.getPassword());

                    ds2.setURL(ds.getURL());
                    ds2.setDriver(ds.getDriver());
                    

                    return ds2; 
		
		} catch (Exception e) {
		
		}	
		
		return null;
	}
	
}