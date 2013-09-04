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
public class Template{
    
    /** Creates a new instance of Integrante */
    public Template() {
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


    public void setNombre( String newNombre )
    {
            nombre = newNombre;	
    }
        
    public String getNombre() {
        return nombre;
    }
     
    public String getRuta()
	{
		return ruta;
	}
	
    public void setRuta( String newRuta )
    {
            ruta = newRuta;	
    }
     
    public String getRutaReverso()
	{
		return rutaReverso;
	}
	
    public void setRutaReverso( String newRutaReverso)
    {
            rutaReverso = newRutaReverso;	
    }
    
    public String getDireccion()
    {
            return direccion;
    }
	
    public void setDireccion( String newDireccion )
    {
            direccion = newDireccion;	
    }
    
     public String getLogotipo()
    {
        return logotipo;
    }
	
    public void setLogotipo( String newLogo )
    {
        logotipo = newLogo;	
    }

     public String getFondo1()
    {
            return fondo1;
    }
	
    public void setFondo1( String newFondo )
    {
            fondo1 = newFondo;	
    }
     
     public String getFondo2()
    {
            return fondo2;
    }
	
    public void setFondo2( String newFondo)
    {
            fondo2 = newFondo;	
    }
    
    public String toString( )
    {
	return nombre;	
    }
        
    private int id; 
    
    private String nombre;    
    private String ruta;
    private String rutaReverso;
    private String direccion;
    private String fondo1;
    private String fondo2;    
    private String logotipo;
}
