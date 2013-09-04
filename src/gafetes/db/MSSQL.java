package gafetes.db;
import java.sql.*;



public class MSSQL{
    Connection conn;
    Statement stmt;
    PreparedStatement pStmt;  
    CallableStatement spStmt;
	
    String error="";	
    int intError = 0 ;
    public static final int NULL = 0;
    public static final int OK = 23;
    public static final int GENERAL_ERROR = -1;
		
    public MSSQL()	{

    }

	
    public Connection getConnection()  {
        try{
        conn = ConnectionFactory.getConnection();
        }catch(java.sql.SQLException ex){
            conn = null;
        }
        return conn;
    }

        
    public Statement getStatement(){     
        if( stmt == null )   {
            if( getConnection() == null )   {                
                setError( ConnectionFactory.getError());				
								
            }            
            try {
                stmt    =   conn.createStatement();
            }catch( SQLException ex ){
                tratarExcepcionSQL( ex );                
            }
        }
        return stmt;    
    }
	

    public PreparedStatement getPreparedStatement( String sqlString ){
        if( getConnection() == null )   {                setError( ConnectionFactory.getError());				                
            pStmt = null;            
        }else            
        {
            try {
            pStmt    =   conn.prepareStatement( sqlString );
            }
            catch( SQLException ex ){
                tratarExcepcionSQL( ex );
            }
        }        
        return pStmt;            
    }


	
    public CallableStatement getCallableStatement( String sqlString ){
        if( getConnection() == null )   {
            setError( ConnectionFactory.getError());				                
            pStmt = null;
            //return pStmt;
        }else            
        {
            try {
            spStmt    =   conn.prepareCall( sqlString );
            }
            catch( SQLException ex ){
                tratarExcepcionSQL( ex );
            }
        }        
        return spStmt;            
    }


	public ResultSet executeQuery( String sqlString )   {     
	    
            ResultSet rs	= null ;
		
	    if( getConnection() == null )   {	            
	            rs = null;
				return rs;
	    }
	    try   {
	        stmt    =   conn.createStatement();
	        rs		=	stmt.executeQuery( sqlString );
	        //System.out.println( sqlString );		
	    }
	    catch( SQLException ex )   {
	        tratarExcepcionSQL( ex );
	    }
	
	    return rs;
	}
	
	
    public int executeUpdate( String sqlString )   {     
        int returnValue = -1 ;
        
        if( getConnection() == null )   {
                setError(" Error al conectarse ");
                return GENERAL_ERROR;
        }
        try {
            stmt    =   conn.createStatement();
            stmt.executeUpdate( sqlString );                    
            returnValue =  OK;        
        }
        catch( SQLException ex ){
            tratarExcepcionSQL( ex );
            returnValue = GENERAL_ERROR;
        }
    
        
        //System.out.println(sqlString);
        return returnValue;
        
        
    }
    
    
	public void showMessage( String message )	{
		//System.out.println( message );
	}
	

	public void close()
	{
        System.out.println("Closing DBSQL connection");
        try
	    {
    	   	if ( stmt != null)
			{
				stmt.close();
		    }

        	if ( conn != null )
			{
	        	conn.close();
	        }
	    }
		
        catch (SQLException e)
		{
        	tratarExcepcionSQL( e );
        }
    }
       
	
	public static void tratarError( int ierror) {
		
		switch( ierror ) {
			
			case 1216:
				
			
			case 1217:
				
			break ;
			
			case 1062:
                            javax.swing.JOptionPane.showMessageDialog(gafetes.Application.getparentFrame(),"El registro ya existe");				
			break;
                        
                        case 3621:
                            javax.swing.JOptionPane.showMessageDialog(gafetes.Application.getparentFrame(),"El campo es demasiado largo");
                        break;
			
		}
	
	}
	
	
    public  static void tratarExcepcionSQL( java.sql.SQLException ex )
    {    	
    	do  
    	{   		
            System.out.println(ex.getMessage());
            tratarError(ex.getErrorCode());                
            ex = ex.getNextException();
    	}while( ex  != null );
    }        
    
    public  String getError()   {
        return error;
    }


    public   void setError( String errorString )   {
        error="";
        error = errorString ;
    }

}
