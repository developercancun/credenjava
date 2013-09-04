package gafetes.db;
import java.sql.*;
import gafetes.beans.*;
import javax.swing.DefaultListModel;
   
/**
  * Microsoft SQL Server JDBC test program
  */
public class SQLServer {
   public SQLServer() throws Exception {
       
       /*
        private java.sql.Connection  con = null;
        private final String url = "jdbc:microsoft:sqlserver://";
        private final String serverName= "localhost";
        private final String portNumber = "1433"; 
        private final String databaseName= "pubs"; 
        private final String userName = "user"; 
        private final String password = "password"; // Indica al controlador que debe utilizar un cursor de servidor, // lo que permite más de una instrucción activa // en una conexión. private final String selectMethod = "cursor"; 
     
     // Constructor public Connect(){}
     
     private String getConnectionUrl(){ return url+serverName+":"+portNumber+";databaseName="+databaseName+";selectMethod="+selectMethod+";"; }
     
     private java.sql.Connection getConnection(){ try{ Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver"); con = java.sql.DriverManager.getConnection(getConnectionUrl(),userName,password); if(con!=null) System.out.println("Conexión correcta."); }catch(Exception e){ e.printStackTrace(); System.out.println("Error de seguimiento en getConnection() : " + e.getMessage()); } return con; }

     
     public void displayDbProperties(){ java.sql.DatabaseMetaData dm = null; java.sql.ResultSet rs = null; try{ con= this.getConnection(); if(con!=null){ dm = con.getMetaData(); System.out.println("Información del controlador"); System.out.println("\tNombre del controlador: "+ dm.getDriverName()); System.out.println("\tVersión del controlador: "+ dm.getDriverVersion ()); System.out.println("\nInformación de la base de datos "); System.out.println("\tNombre de la base de datos: "+ dm.getDatabaseProductName()); System.out.println("\tVersión de la base de datos: "+ dm.getDatabaseProductVersion()); System.out.println("Catálogos disponibles "); rs = dm.getCatalogs(); while(rs.next()){ System.out.println("\tcatálogo: "+ rs.getString(1)); } rs.close(); rs = null; closeConnection(); }else System.out.println("Error: No hay ninguna conexión activa"); }catch(Exception e){ e.printStackTrace(); } dm=null; }     
     
     private void closeConnection(){ try{ if(con!=null) con.close(); con=null; }catch(Exception e){ e.printStackTrace(); } } public static void main(String[] args) throws Exception { Connect myDbTest = new Connect(); myDbTest.displayDbProperties(); 
     } 

		*/
    // Get connection
    DriverManager.registerDriver(new com.microsoft.jdbc.sqlserver.SQLServerDriver());   
    Connection connection = DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433;","sa","rodeo");
    
    if (connection != null) {
        System.out.println();
        System.out.println("Successfully connected");
        System.out.println();
        // Meta data
        DatabaseMetaData meta = connection.getMetaData();
        System.out.println("\nDriver Information");
        System.out.println("Driver Name: "
        + meta.getDriverName());
        System.out.println("Driver Version: "
        + meta.getDriverVersion());
        System.out.println("\nDatabase Information ");
        System.out.println("Database Name: "
        + meta.getDatabaseProductName() + meta.getCatalogs() );

        System.out.println("User Name: "
        +meta.getUserName());

        System.out.println("Database Version: "+
        meta.getDatabaseProductVersion());

        String query = "SELECT * FROM  badge_EMPLEADOS;";
        System.out.println(query);
                
        java.sql.DatabaseMetaData dm = null; 
        java.sql.ResultSet rs = null; 
        try{ 
            if(connection!=null){ 
               dm = connection.getMetaData(); 
                System.out.println("Información del controlador"); System.out.println("\tNombre del controlador: "+ dm.getDriverName());
                System.out.println("\tVersión del controlador: "+ dm.getDriverVersion ()); 
                System.out.println("\nInformación de la base de datos "); 
                System.out.println("\tNombre de la base de datos: "+ dm.getDatabaseProductName()); 
                System.out.println("\tVersión de la base de datos: "+ dm.getDatabaseProductVersion());
                System.out.println("Catálogos disponibles "); rs = dm.getCatalogs();
                while(rs.next()){ 
                    System.out.println("\tcatálogo: "+ rs.getString(1)); } rs.close(); rs = null;  
                }
                else 
                    System.out.println("Error: No hay ninguna conexión activa"); 
        }
        catch(Exception e){ 
                        e.printStackTrace(); 
        } 

     
        
        rs = db.executeQuery(query);
        gafetes.beans.Empleado i = new gafetes.beans.Empleado();

        if( rs != null ) {
            try{
                while( rs.next() )
                {
                    int id  = rs.getInt("ID");               
                    String nombre = rs.getString("Nombre");
                    String apellidos = rs.getString("APELLIDOS");                    
                    i.setId(id);                  
                    i.setNombre(nombre);
                    i.setApellidos(apellidos);
                    System.out.println("Apellidos" + i.getApellidos());
                    
                   // return i;
                   
                }
                
            }catch(java.sql.SQLException ex){
                ex.printStackTrace();
    		//return null;
            }            
        }else{
            i = null;
        }
        
        //return i;
    
    }
 } // Test
  

  
  public static void main (String args[]) throws Exception {
      SQLServer SQL = new SQLServer();
     //SQLServer.getEmpleadoById("1189160");
    
  }
  static MSSQL db =  new MSSQL();
}


/**
 *
 *
 *
 *
 *
 *drop TABLE badge_Empleados;
CREATE TABLE badge_Empleados(

IDE_INTEGRANTE	INT NOT NULL IDENTITY,
DATAKEY		INT NOT NULL,
CLAVE		VARCHAR(20) NOT NULL,
NOMBRE		VARCHAR(80) NOT NULL,
APELLIDOS	VARCHAR(80) NOT NULL,
PUESTO		VARCHAR(80) NOT NULL,	
ZONA		VARCHAR(80) NOT NULL,	

AREA		VARCHAR(80) NOT NULL,
TEMPLATE	INT NOT NULL,
CATEG		VARCHAR(20) NOT NULL,	
RFC		VARCHAR(20) NOT NULL,	
IMSS		VARCHAR(20) NOT NULL,	
CONSEM		VARCHAR(20) NOT NULL,
PHOTOFILE	VARCHAR(200) NOT NULL,
FECHAINGRESO    DATETIME NOT NULL,
RUTAFIRMA       VARCHAR(200) NOT NULL,
EMPRESA         VARCHAR(200) NOT NULL,
PRIMARY KEY(DATAKEY)
);

DROP TABLE badge_TEMPLATES;
CREATE TABLE badge_TEMPLATES(
ID	INT NOT NULL IDENTITY,
NOMBRE VARCHAR(200) NOT NULL,
RUTA		VARCHAR(200) NOT NULL,
RUTA_REVERSO	VARCHAR(200) NOT NULL,
LOGOTIPO        VARCHAR(200) NOT NULL,
UNIQUE(NOMBRE),
PRIMARY KEY(ID)
);
 
  DROP TABLE badge_USUARIOS;
 CREATE TABLE badge_USUARIOS
 (
    ID INT NOT NULL IDENTITY,
    USERNAME VARCHAR(15) NOT NULL,
    PASSWORD VARCHAR(15) NOT NULL,
    ADMINISTRADOR BIT NOT NULL,
    UNIQUE(USERNAME),
    PRIMARY KEY(ID) 
 );
 
 DROP TABLE badge_CONFIGURACION;
 CREATE TABLE badge_CONFIGURACION(
    ID  INT NOT NULL IDENTITY,
    PARAMETRO VARCHAR(50) NOT NULL,
    VALOR     VARCHAR(200) NOT NULL,
    UNIQUE (PARAMETRO),
   PRIMARY KEY(ID) 
 );
 
 INSERT INTO  BADGE_USUARIOS(USERNAME, PASSWORD,ADMINISTRDOR) VALUES('ADMIN','ADMIN',1);
 
 *
 *
 *
 *
 *
 *
 
 */