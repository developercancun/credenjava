package gafetes.util;

import gafetes.beans.Usuario;
import gafetes.util.DataSourceConfiguration;
import gafetes.util.ApplicationConfiguration;
import gafetes.db.SampleDigester;

public class ApplicationConfiguration {

	private DataSourceConfiguration ds ;


	public ApplicationConfiguration() {
	}	
	
	
	public void setDataSource(DataSourceConfiguration ds) {
		this.ds = ds; 
	}
	
	
	public static DataSourceConfiguration getDataSource() {
		// Here is an example that uses the class
		try {
		// Create encrypter/decrypter class
		
			SampleDigester xmlDigester = new SampleDigester();
		
			try
			{
				xmlDigester.xmlConfiguration2Object();
			}
			catch(Exception e)
			{
                            e.printStackTrace();
			}
			
			DataSourceConfiguration ds = xmlDigester.getConfiguration(); 
			return ds; 
		
		} catch (Exception e) {
		
		}		
		return null;
	}
	
}