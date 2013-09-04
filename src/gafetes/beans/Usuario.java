package  gafetes.beans;

public class Usuario
{
	private int id;
	private String nombre;
	private String password;
	
	private int  tipo;
	private String status;
        private boolean esAdmin = false;
	
	public static int SUPER = 0;
	public static int ADMINISTRATOR = 1;
	public static int OPERATOR = 2;
	public static int USER = 3;
	
	
	


	public int getId()
	{
		return id;
	}

	public void setId(int newUsuarioID ) {
		id = newUsuarioID;
	}
	

	
	public void setPassword( String newPassword )
	{
		password	=	newPassword;
	}
	
	public String getPassword(  )
	{
		return password;
	}
	

	public String getNombre()
	{
		return nombre;
	}
	
	
	public void setNombre( String newNombre )
	{
		nombre = newNombre;	
	}
	
	public int getTipo()
	{
		return tipo;
	}

	public void setTipo(int newTipo ) {
		tipo = newTipo;
	}

	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus( String newStatus )
	{
		status = newStatus;	
	}
	
	public String toString()
	{
		return nombre;
	}
        
        
        public boolean EsAdministrador( )
	{
		return esAdmin;	
	}
	
	public void setAdmin(boolean value)
	{
		esAdmin = value;
	}

		
	public static void main( String[] args) 
	{
		Usuario newUsuario = new Usuario();		
		newUsuario.setId(1);		
		System.out.println( newUsuario.getId() );		
	}
	
}

//
//
//	DataStore	ds = Hibernate.createDatastore();
//	ds.storeClass( Usuario.class );
//	
//	or maybe
//	Configuration conf	= new Configuration();

//
//	ds.storeFile( "Usuario.hbm.xml" );
//	
//	SesionFactory sf	=	ds.buildSessionFactory();
//	
//	Session session		=	sf.openSession();
//	
//	
//	Usuario	newUsuario		=	new Usuario();
//	
//	newUsuario.setID( "jcac" );
//	newUsuario.setUsuarioName( "Juan Carlos Alafita Caballero" );
//	
//	session.save( newUsuario );
//	
//	
