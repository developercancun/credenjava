/*
 * Integrante.java
 *
 * Created on 8 de agosto de 2007, 08:35 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gafetes.beans;

/**
 *
 * @author maritza
 */
public class Integrante {
    
    /** Creates a new instance of Integrante */
    public Integrante() {
        id      = -1;
        nombre  = "";
    }
    
    public int getId( )	{
        return id;
    }
    
    public void setId( int newId )
    {
        id = newId;
    }
    
    	
    	public String getDireccion()
	{
		return direccion;
	}
	
	
	public void setDireccion( String newDomicilio )
	{
		direccion = newDomicilio;	
	}

        	public String getDireccionAdicional()
	{
		return direccionAdicional;
	}
	
	
	public void setDireccionAdicional( String newDomicilio )
	{
		direccionAdicional = newDomicilio;	
	}

        
	public String getColonia()
	{
		return colonia;
	}
	
	
	public void setColonia( String newDomicilio )
	{
		colonia = newDomicilio;	
	}
	public String getCiudad()
	{
		return ciudad;
	}
	
	
	public void setCiudad( String newCiudad )
	{
		ciudad = newCiudad;	
	}
	
	
	
	public String getEstado()
	{
		return estado;
	}
	
	
	public void setEstado( String newEstado )
	{
		estado = newEstado;	
	}
	
	
	public String getCP()
	{
		return cp;
	}

        
        public void setNombre( String newNombre )
        {
                nombre = newNombre;	
        }
        
        public String getNombre() {
        return nombre;
    }
    	
        
   
        
        public void setNombreAdicional( String newNombre )
        {
                nombreAdicional = newNombre;
        }

    
    public String getNombreAdicional() {
        return nombreAdicional;
    }
    
	
	public void setCP( String newCP )
	{
		cp = newCP;	
	}
	
	public String getTelefono()
	{
		return telefono;
	}
	
	public void setTelefono( String newTelefono )
	{
		telefono = newTelefono;	
	}
	
        
        public String getTelefonoAdicional()
	{
		return telefonoAdicional;
	}
	
	public void setTelefonoAdicional( String newTelefono )
	{
		telefonoAdicional = newTelefono;	
	}
        
	public String getCelular()
	{
		return celular;
	}
	
	public void setCelular( String newTelefono )
	{
		celular = newTelefono;	
	}

        
        public java.util.Calendar getFechaNacimiento()
	{
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento( java.util.Calendar fecha )
	{
		this.fechaNacimiento = fecha;
	}
        
        public java.util.Calendar getFechaRegistro()
	{
		return fechaRegistro;
	}
	
	public void setFechaRegistro( java.util.Calendar fecha )
	{
		this.fechaRegistro = fecha;
	}
	        
	public String getStatus()
	{
		return status;
	}
	
		public void setStatus( String newStatus )
	{
		status = newStatus;	
	}
	
        public String getTipo()
	{
		return tipo;
	}
	
	
	public void setTipo( String newTipo )
	{
		tipo = newTipo;	
	}
        
	public String toString( )
	{
		return nombre;	
	}
	

	
    private String nombre;
    private int id;
    private String direccion;
    
    private String nombreAdicional;
    private String telefonoAdicional;
    private String direccionAdicional;
    
    
    private String colonia;
    private String cp;
    private String telefono;
    private String celular;
    private String ciudad;
    private String estado;
    private java.util.Calendar fechaNacimiento;
    private java.util.Calendar fechaRegistro;
    private String status;
    private String tipo;
    
	
        
	
    
}
