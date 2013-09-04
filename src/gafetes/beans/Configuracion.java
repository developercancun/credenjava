/*
 * Configuracion.java
 *
 * Created on 28 de abril de 2010, 11:51 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gafetes.beans;

/**
 *
 * @author gateway
 */
public class Configuracion {
    
    int id;
    String parametro;
    String valor;
    
    /** Creates a new instance of Integrante */
    public Configuracion() {
        id      = -1;
        parametro  = "";
    }
    
    public int getId( )	{
        return id;
    }
    
    public void setId( int newId )
    {
        id = newId;
    }
    
    public String getParametro( )	{
        return parametro;
    }
    
    public void setParametro( String newParametro )
    {
        parametro= newParametro;
    }
    
     public String getValor( )	{
        return valor;
    }
    
    public void setValor( String newValor )
    {
        valor =  newValor;
    }
    
    public String toString(){
        return parametro;
    }
    
}
    