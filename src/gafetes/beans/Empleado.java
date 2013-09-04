/*
 * Integrante.java
 *
 * Created on 8 de agosto de 2007, 08:35 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gafetes.beans;
import java.util.Date;
/**
 *
 * @author maritza
 */
public class Empleado{
    
    /** Creates a new instance of Integrante */
    public Empleado() {
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
    
     public int getTemplate( )	{
        return template;
    }
    
    public void setTemplate( int newTemplate )
    {
        template = newTemplate;
    }
    
    	
    
	

    public void setClave( String newCP )
    {
           clave = newCP;	
    }

    public String getClave()
    {
            return clave;
    }
        
    public void setNombre( String newNombre )
    {
            nombre = newNombre;	
    }
        
    public String getNombre() {
        return nombre;
    }
     
    public void setApellidos( String newNombre )
    {
            apellidos = newNombre;
    }
    
    public String getApellidos() {
        return apellidos;
    }
    
        public String getRutaFoto()
	{
		return rutaFoto;
	}
	
	public void setRutaFoto( String newTelefono )
	{
		rutaFoto = newTelefono;	
	}
        
        
        public String getRutaFirma()
	{
            return rutaFirma;
	}
	
	public void setRutaFirma( String newRuta )
	{
            rutaFirma = newRuta;	
	}
        
	public String getArea()
	{
		return area;
	}
	
	public void setArea( String newTelefono )
	{
		area = newTelefono;	
	}

        public String getPuesto()
	{
		return puesto;
	}
	
	public void setPuesto( String newStatus )
	{
		puesto = newStatus;	
	}
	
        public String getZona()
	{
		return zona;
	}
	
	public void setZona( String newStatus )
	{
		zona = newStatus;	
	}
        
        public String getRfc()
	{
		return rfc;
	}
	
	
	public void setRfc( String newTipo )
	{
		rfc = newTipo;	
	}
        
        public String getImss()
	{
		return imss;
	}
	
	public void setImss( String newTipo )
	{
		imss = newTipo;	
	}
         public String getConsecutivo()
	{
		return consecutivo;
	}
		
	public void setConsecutivo( String newTipo )
	{
		consecutivo = newTipo;	
	}
        
         public String getCategoria()
	{
		return categ;
	}
		
	public void setCategoria( String newTipo )
	{
		categ = newTipo;	
	}
        
	public String toString( )
	{
		return nombre;	
	}
	
        public String getEmpresa()
	{
		return empresa;
	}
	
	
	public void setEmpresa( String newEmpresa )
	{
		empresa = newEmpresa;	
	}
        
        public java.util.Calendar getFechaIngreso()
	{
		return fechaIngreso;
	}
	
	
	public void setFechaIngreso( java.util.Calendar newFechaIngreso )
	{
		fechaIngreso = newFechaIngreso;
	}

	
    
    private int id;
    private String clave;
    private String nombre;    
    private String rutaFoto;
    private String rutaFirma;
    private String apellidos;
    private int template;
    private String area;
    private String puesto;    
    private String zona;
    private String rfc;
    private String imss;    
    private String consecutivo;
    private String categ;
    private String empresa;
    
    private java.util.Calendar fechaIngreso;
}
