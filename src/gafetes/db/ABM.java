package gafetes.db;

public class ABM {
	
    public static final int NULL = 0;
    public static final int OK = 23;
    public static final int GENERAL_ERROR = -1;
	
	protected MSSQL db ;
	
	String error="";	
	public ABM() {
	
	}
	
	public String getError()   {
        return error;
    }


    public void setError( String errorString )   {
    
        error = errorString ;
    }

	public boolean existeNombre(String tabla, String nombre){
		boolean returnValue = false;
	 	String sSQL = 	" SELECT ID FROM " + tabla +	" WHERE NOMBRE = " + "'"+nombre+"'" 
	 	 				+ " AND STATUS = 'A' ";

	 	java.sql.ResultSet rs = db.executeQuery(sSQL);
	 	if( rs != null ) {
	 		try {
	 		
				if(rs.next())
		 			returnValue = true;
		 			
		 	} catch(java.sql.SQLException ex) {
		 		db.tratarExcepcionSQL(ex);
		 	}
	 	}
	 		return returnValue;	  
	}    
	
	
}
