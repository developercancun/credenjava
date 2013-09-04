package gafetes.db;

public class ConnectionFactory{
	
    static java.sql.Connection conn;
    static String error;
    public static final int OK = 23;
    public static final int GENERAL_ERROR = -1;
	
    public  static boolean testConnection( String username, String password ) {     
	//Esta es una clase heredada de un proyecto personal anterior
    	AdqalConfiguration conf = new AdqalConfiguration();
        DataSource ds = conf.getDataSource();
    
        java.sql.Connection otherconn;
        
        //if( conn == null ) {
            try {
                Class.forName( ds.getDriver() );
                //System.out.println( ds.getDriver() );
        		//showMessage( "Opening DBMySQL connection" ); 
        		//System.out.println(ds.getURL() );
        		//System.out.println(password );
        		//System.out.println(username );
        		otherconn = java.sql.DriverManager.getConnection( ds.getURL() , username, password );
        		
				//conn = java.sql.DriverManager.getConnection( url ,user,passwd );
                //conn = DriverManager.getConnection( url, user, passwd );
    			//showMessage(" Conexion exitosa ");      		
            }
			catch ( ClassNotFoundException ex ) {
                showMessage("Cannot find the database driver classes.");
                return false;
            }   
			catch( java.sql.SQLException ex ) {
                showMessage("Error al conectarse dentro de catch");
				tratarExcepcionSQL( ex );
				return false;
            }
        //}
        return true;
    }		
    
    
    public  static java.sql.Connection getConnection( ) throws java.sql.SQLException    
    {   
        try {
            AdqalConfiguration conf = new AdqalConfiguration();
            DataSource ds = conf.getDataSource();

            Class.forName(ds.getDriver());//"com.microsoft.jdbc.sqlserver.SQLServerDriver");// ds.getDriver() );
           
            conn = java.sql.DriverManager.getConnection(ds.getURL(),ds.getUserName(),ds.getPassword());//ds.getUserName(), ds.getPassword() );

           
            
        }catch ( ClassNotFoundException ex ) {
            showMessage("Cannot find the database driver classes.");
        }   
        catch( java.sql.SQLException ex ) {
            showMessage("Error al conectarse dentro de catch");
            tratarExcepcionSQL( ex );
        }
        return conn;
    }	
        
    	
    /*
    public  static java.sql.Connection getDefaultConnection() {     

        if( conn == null ) {
            try {
                Class.forName( driver );
        		showMessage( "Opening DBMySQL connection" ); 
        		
				conn = java.sql.DriverManager.getConnection( url ,user,passwd );
                //conn = DriverManager.getConnection( url, user, passwd );
    			showMessage(" Conexion exitosa ");      		
            }
			catch ( ClassNotFoundException ex ) {
                showMessage("Cannot find the database driver classes.");
            }   
			catch( java.sql.SQLException ex ) {
                showMessage("Error al conectarse dentro de catch");
				tratarExcepcionSQL( ex );
            }
        }
        return conn;
    }		
    
    */
    
        
    public static void showMessage( String message )	{
		System.out.println( message );
	}
	

    public static void close()
	{
        System.out.println("Closing DBSQL connection");
        try {
        	if ( conn != null ) {
	        	conn.close();
	        }
	    }
		
        catch ( java.sql.SQLException e) {        
        	tratarExcepcionSQL( e );
        }
    }
       
	
    public static void tratarExcepcionSQL( java.sql.SQLException ex )
    {
    	do  
    	{
            System.out.println( "SQLSTATE  :"+ex.getSQLState() );
            System.out.println( "ERRORCODE :"+ex.getErrorCode() );    	
            
            System.out.println( "MENSAJE    :"+ex.getMessage() );
            
            javax.swing.JOptionPane.showMessageDialog( new javax.swing.JFrame(), ex.getMessage(), "Error desde la BD", 
            javax.swing.JOptionPane.INFORMATION_MESSAGE);   
            setError(ex.getMessage());
            ex = ex.getNextException();
            
    	}   while( ex  != null );
    }      
    
    public static String getError()   {
        return error;
    }


    public static void setError( String errorString )   {
    	error ="";
        error = errorString ;
    }

}