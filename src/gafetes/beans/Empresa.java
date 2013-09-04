/*
 * Empresa.java
 *
 * Created on 28 de octubre de 2007, 11:07 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gafetes.beans;

/**
 *
 * @author alafita
 */
public class Empresa {
    
    /** Creates a new instance of Empresa */
    public Empresa() {
    }
    
    
    public int getIndex(){
        return index;
    }
    
    public void setIndex(int index){
        this.index = index;
    }
    
    
    public String getNombre(){
        return nombreEmpresa;
    }
    
    public void setNombre(String nombre){
        nombreEmpresa = nombre;
    }
    
    public int getColor1(){
        return color1;
    }
    
    public int getColor3(){
        return color3;
    }
    
    public int getColor2(){
        return color2;
    }
    
    public void setColor(int color1, int color2, int color3){
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public String getTelefono(){
        return this.telefono;
    }
    
    public void setTelefono(String tel){
        this.telefono = tel;
    }
            
    private String nombreEmpresa;
    private int color1,color2,color3;
    private String direccion;
    private String telefono;
    private int index=-1;
    
}
