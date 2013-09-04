package gafetes.business;

import java.sql.*;
import gafetes.model.EmpleadosModel;
import gafetes.model.TemplateModel;
import gafetes.model.TemplateModel;
import gafetes.beans.Template;
import gafetes.beans.Empleado;
import javax.swing.DefaultListModel;
import gafetes.db.GlobalSettings;        
import org.jdesktop.swingx.auth.UserNameStore;
/**
 *
 * @author jalafita
 */
public class SqlHelper {
    
    /** Creates a new instance of SqlHelper */
    public SqlHelper() {
        
    }
    public static String TABLE_NAME = "badge_Empleados";
    
    
            
            
    
    
    public static DefaultListModel getListaTemplates(){               
       
        
        DefaultListModel v = new DefaultListModel();
                
        String query = "SELECT * FROM " + GlobalSettings.GetPrefix() + "TEMPLATES";        
        java.sql.ResultSet rs = db.executeQuery(query);
       
        if( rs != null ) {
            try{
                while( rs.next() )
                {
                    int id = rs.getInt("ID");
                    String nombre = rs.getString("NOMBRE");
                    String ruta = rs.getString("RUTA");
                    
                    gafetes.beans.Template t = new gafetes.beans.Template();
                    t.setId(id);
                    t.setNombre(nombre);
                    t.setRuta(ruta);                                        
                    v.addElement(t);
                }
             }catch(java.lang.NullPointerException ne){
                System.out.println(ne.toString());
    		return null;
            
            }catch(java.sql.SQLException ex){
                ex.printStackTrace();
    		return null;
            }
            
          
        }
        return v;
        
    }
        
    
    public static gafetes.beans.Template getTemplateById(int ide){               
       
        String query = "SELECT ID, NOMBRE, RUTA, RUTA_REVERSO, LOGOTIPO, FONDO1, FONDO2 FROM " + GlobalSettings.GetPrefix() + "TEMPLATES WHERE ID = "+ide;        
        java.sql.ResultSet rs = db.executeQuery(query);
        gafetes.beans.Template t = new gafetes.beans.Template();
        
        if( rs != null ) {
            try{
                while( rs.next() )
                {
                    int id = rs.getInt("ID");
                    String nombre = rs.getString("NOMBRE");
                    String ruta = rs.getString("RUTA");                    
                    String rutareverso = rs.getString("RUTA_REVERSO");  
                    String logotipo = rs.getString("LOGOTIPO");  
                    String fondo1 = rs.getString("FONDO1");  
                    String fondo2 = rs.getString("FONDO2");  

                    t.setId(id);
                    t.setNombre(nombre);
                    t.setRuta(ruta);  
                    t.setRutaReverso(rutareverso);
                    t.setLogotipo(logotipo);
                    t.setFondo1(fondo1);
                    t.setFondo2(fondo2);                    
                }
             }catch(java.lang.NullPointerException ne){
                System.out.println(ne.toString());
    		return null;
            
            }catch(java.sql.SQLException ex){
                ex.printStackTrace();
    		return null;
            }
        }
        return t;
        
    }
    
     
     
    public static int getLastFolio(){      
        String query = "SELECT MAX(DATAKEY) AS ULTIMO FROM " +TABLE_NAME;
        ResultSet rs = db.executeQuery(query);
        int folio = -1;
        if( rs != null ) {
            try{
                if( rs.next() )
                {
                    folio = rs.getInt("ULTIMO");
                }
            }catch(java.sql.SQLException ex){
    		return -1;
            }
        }        
        return folio+1;
    }
   
    
      public static int saveEmpleado( gafetes.beans.Empleado e ){
      
        String iSQL = " INSERT INTO "+TABLE_NAME +"(CLAVE, NOMBRE, APELLIDOS, RFC, IMSS, AREA, PUESTO,TEMPLATE, PHOTOFILE,CONSEM,CATEG,ZONA, DATAKEY, FECHAINGRESO, RUTAFIRMA) " +
                " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        
        
        int datakey = getLastFolio();
                
        System.out.println("Ruta a la foto-->" + e.getRutaFoto());
        
        System.out.println(e.getRutaFoto());
        System.out.println("Este es el template -->" + e.getTemplate());
        
        PreparedStatement pStmt = db.getPreparedStatement( iSQL );        
       
        java.sql.Date fecha = new java.sql.Date( e.getFechaIngreso().getTime().getTime() );
        
        try{
            pStmt.setString(1, e.getClave());
            pStmt.setString(2,  e.getNombre());
            pStmt.setString(3,  e.getApellidos());
            pStmt.setString(4,  e.getRfc());            
            pStmt.setString(5,  e.getImss());
            pStmt.setString(6,  e.getArea());
            pStmt.setString(7,  e.getPuesto());
            pStmt.setInt(8,  e.getTemplate());
            pStmt.setString(9, e.getRutaFoto());
            pStmt.setString(10, e.getConsecutivo());
            pStmt.setString(11, e.getCategoria());
            pStmt.setString(12, e.getZona());
            pStmt.setInt(13, datakey );
            pStmt.setDate(14, fecha);
            pStmt.setString(15, e.getRutaFirma());
            
            pStmt.executeUpdate();
            
        }catch( NullPointerException npe ) {    		
            javax.swing.JOptionPane.showMessageDialog(gafetes.Application.getparentFrame(),"Ocurrio un error algun dato es nulo");
            return -1;
            
    	}catch( SQLException sqle ) {
    		sqle.printStackTrace();
    		return -1;    		
    	}  	 
        return 1;   
        
    }
    
      
    public static boolean UsuarioEsAdministrador(gafetes.beans.Usuario user) {
            String sSQL = " SELECT Administrador FROM " + gafetes.db.GlobalSettings.GetPrefix()+"USUARIOS WHERE ID = ?" ;  
     
       boolean esAdministrador = false;
    	PreparedStatement pStmt = db.getPreparedStatement( sSQL );    
        try{
            pStmt.setInt(1, user.getId());
           
            java.sql.ResultSet rs = pStmt.executeQuery();
            if( rs != null ) {

                    if( rs.next() )     			
                       esAdministrador 	= rs.getBoolean("ADMINISTRADOR");                   
            }
    	
        } catch( SQLException ex ) {
 	  		db.tratarExcepcionSQL( ex );
        }
        
        return esAdministrador;
    }
    
    
    public static int saveUsuario( gafetes.beans.Usuario user ){
      
        String iSQL = " INSERT INTO " +  gafetes.db.GlobalSettings.GetPrefix() + "USUARIOS(USERNAME, PASSWORD, ADMINISTRADOR) " +
                " VALUES(?,?,?);";
               
        PreparedStatement pStmt = db.getPreparedStatement( iSQL );        
       
        try{
            
            pStmt.setString(1,  user.getNombre());
            pStmt.setString(2,  user.getPassword());
            pStmt.setBoolean(3,  user.EsAdministrador());
           
            
            pStmt.executeUpdate();
            
        }catch( NullPointerException npe ) {    		
            javax.swing.JOptionPane.showMessageDialog(gafetes.Application.getparentFrame(),"Ocurrio un error algun dato es nulo");
            return -1;
            
    	}catch( SQLException sqle ) {
    		System.out.println( sqle.toString() );
    		return -1;    		
    	}  	 
        return 1;   
        
    }
    
    
    public static int saveTemplate( gafetes.beans.Template template ){
      
        String iSQL = " INSERT INTO " +  gafetes.db.GlobalSettings.GetPrefix() + "TEMPLATES(NOMBRE, RUTA, RUTA_REVERSO, LOGOTIPO, FONDO1, FONDO2) " +
                " VALUES(?,?,?,?,?,?);";
        
        PreparedStatement pStmt = db.getPreparedStatement( iSQL );        
       
        try{            
            pStmt.setString(1,  template.getNombre());
            pStmt.setString(2,  template.getRuta());
            pStmt.setString(3,  template.getRutaReverso());
            pStmt.setString(4,  template.getLogotipo());
            pStmt.setString(5,  template.getFondo1());
            pStmt.setString(6,  template.getFondo2());
            
            pStmt.executeUpdate();            
        }catch( NullPointerException npe ) {    		
            javax.swing.JOptionPane.showMessageDialog(gafetes.Application.getparentFrame(),"Ocurrio un error algun dato es nulo");
            return -1;            
    	}catch( SQLException sqle ) {
    		sqle.printStackTrace();
    		return -1;    		
    	}  	 
        return 1;   
        
    }
    
    
    public static int updateTemplate( gafetes.beans.Template template ){
      
        String iSQL = " UPDATE " +  gafetes.db.GlobalSettings.GetPrefix() + "TEMPLATES SET  NOMBRE = ?, RUTA = ?, RUTA_REVERSO = ? , "
                    + " LOGOTIPO = ?, FONDO1 = ?, FONDO2 = ?  WHERE ID = ? ;";
        
        
        PreparedStatement pStmt = db.getPreparedStatement( iSQL );        
       
        try{            
            pStmt.setString(1,  template.getNombre());
            pStmt.setString(2,  template.getRuta());
            pStmt.setString(3,  template.getRutaReverso());
            pStmt.setString(4,  template.getLogotipo());
            pStmt.setString(5,  template.getFondo1());
            pStmt.setString(6,  template.getFondo2());
            pStmt.setInt(7,  template.getId());
            
            pStmt.executeUpdate();            
        }catch( NullPointerException npe ) {    		
            javax.swing.JOptionPane.showMessageDialog(gafetes.Application.getparentFrame(),"Ocurrió un error, algún dato es nulo");
            return -1;            
    	}catch( SQLException sqle ) {
    		sqle.printStackTrace();
    		return -1;    		
    	}  	 
        return 1;   
        
    }
    
     public static int updateEmpleado( gafetes.beans.Empleado e, String claveAnterior ){
      
        String uSQL = " UPDATE "+TABLE_NAME+" SET NOMBRE=?, APELLIDOS=?, RFC=?,IMSS=?, AREA=?, PUESTO=?, ZONA=?,CONSEM=?,CATEG=?,PHOTOFILE=?, TEMPLATE=?,  FECHAINGRESO = ?, RUTAFIRMA = ?," +
                
                "   CLAVE=? WHERE CLAVE = ? AND DATAKEY= ?";

        System.out.println(uSQL);
        
        System.out.println(claveAnterior+"-- Clave Antigua -"+ e.getClave());
        
        
        PreparedStatement pStmt = db.getPreparedStatement( uSQL );        
     
        java.sql.Date fecha = new java.sql.Date( e.getFechaIngreso().getTime().getTime() );
        
        try{            
            pStmt.setString(1,  e.getNombre());
            pStmt.setString(2,  e.getApellidos());
            pStmt.setString(3,  e.getRfc());            
            pStmt.setString(4,  e.getImss());
            pStmt.setString(5,  e.getArea());
            
            pStmt.setString(6,  e.getPuesto());            
            pStmt.setString(7, e.getZona());
            
            pStmt.setString(8, e.getConsecutivo());
          
            pStmt.setString(9, e.getCategoria());
            pStmt.setString(10, e.getRutaFoto());
            
            pStmt.setInt(11, e.getTemplate());
            
            
            pStmt.setDate(12, fecha);
            pStmt.setString(13, e.getRutaFirma());
            pStmt.setString(14,e.getClave());
            pStmt.setString(15, claveAnterior);
            pStmt.setInt(16, e.getId());
            
            pStmt.executeUpdate();
            
        }catch( NullPointerException npe ) {    		
            javax.swing.JOptionPane.showMessageDialog(gafetes.Application.getparentFrame(),"Ocurrio un error algun dato es nulo");
            return -1;
            
    	}catch( SQLException sqle ) {
    		sqle.printStackTrace();
    		return -1;    		
   	}  	 
        return 1;        
    }
    
    public static int deleteTemplate( gafetes.beans.Template template ){
      
        String uSQL = " DELETE FROM   " + gafetes.db.GlobalSettings.GetPrefix() + "TEMPLATES "                
                        + "   WHERE ID = ?";

        System.out.println(uSQL);
        
        PreparedStatement pStmt = db.getPreparedStatement( uSQL );        
       
       
        try{            
            pStmt.setInt(1, template.getId());            
            pStmt.executeUpdate();            
        }catch( NullPointerException npe ) {    		
            javax.swing.JOptionPane.showMessageDialog(gafetes.Application.getparentFrame(),"Ocurrio un error algun dato es nulo");
            return -1;
            
    	}catch( SQLException sqle ) {
    		sqle.printStackTrace();
    		return -1;    		
   	}  	 
        return 1;   
        
    }
    
      public static int deleteEmpleado( gafetes.beans.Empleado e ){
      
        String uSQL = " DELETE FROM   " +TABLE_NAME+
                
                "   WHERE CLAVE = ? AND DATAKEY = ?";

        System.out.println(uSQL);
        
        PreparedStatement pStmt = db.getPreparedStatement( uSQL );        
        java.util.Calendar cal = java.util.Calendar.getInstance();
        java.sql.Date fecha = new java.sql.Date( cal.getTime().getTime() );
        
        try{            
          
            pStmt.setString(1, e.getClave());
            pStmt.setInt(2, e.getId());
            
            pStmt.executeUpdate();
            
        }catch( NullPointerException npe ) {    		
            javax.swing.JOptionPane.showMessageDialog(gafetes.Application.getparentFrame(),"Ocurrio un error algun dato es nulo");
            return -1;
            
    	}catch( SQLException sqle ) {
    		sqle.printStackTrace();
    		return -1;    		
   	}  	 
        return 1;   
        
    }
    
    public static void updatePhoto(String file, int id){            
            String update = "UPDATE "+TABLE_NAME+" SET PHOTOFILE='"+file+"' WHERE DATAKEY="+id;
            db.executeQuery(update);
    }
    
    public static void updateFirma(String file, int id){            
            String update = "UPDATE "+TABLE_NAME+" SET RUTAFIRMA='"+file+"' WHERE DATAKEY="+id;
            db.executeQuery(update);
    }
    
     public static void updateTemplate(int template, int clave){
            String update = "UPDATE "+TABLE_NAME+" SET TEMPLATE="+template+" WHERE DATAKEY="+clave;
            db.executeQuery(update);
    }
     
    
    public static gafetes.model.EmpleadosModel getListadoEmpleados(String orden, String ascdesc){
    
        String query = "SELECT * FROM "+TABLE_NAME+" ORDER BY "+ orden + " "+ ascdesc;
        
        java.sql.ResultSet rs = db.executeQuery(query);
        gafetes.model.EmpleadosModel mm = new gafetes.model.EmpleadosModel();
        if( rs != null ) {
            try{
                while( rs.next() )
                {
                    String codigo = rs.getString("CLAVE");
                    int id  = rs.getInt("DATAKEY");
                    String nombre = rs.getString("NOMBRE");
                    String apellidos = rs.getString("APELLIDOS");
                    String area = rs.getString("AREA");
                    String puesto = rs.getString("PUESTO");
                    String photofile = rs.getString("PHOTOFILE");
                    int template = rs.getInt("TEMPLATE");
                    
                    Empleado e = new Empleado();
                    e.setId(id);
                    e.setClave(codigo);
                    e.setNombre(nombre);
                    
                    java.util.Vector row = new java.util.Vector();
                    row.add(codigo);                    
                    
                    row.add(e);                    
                    row.add(apellidos);
                    row.add(puesto);
                    row.add(area);
                    
                    mm.addRow(row);
                }
             }catch(java.lang.NullPointerException ne){
                System.out.println(ne.toString());
    		return null;
            
            }catch(java.sql.SQLException ex){
                ex.printStackTrace();
    		return null;
            }
            
          
        }
        return mm;
    }
    
    public static EmpleadosModel getEmpleadosByField(String name, String field ){
        
  //db = new MSSQL();   
        //dIRTY HACK
        if(field.toUpperCase().equals("EMPRESA"))
            field = " T.NOMBRE ";
        
        String query = "SELECT E.DATAKEY, E.CLAVE, E.NOMBRE, E.APELLIDOS, E.PUESTO, E.AREA, E.TEMPLATE, E.RFC, E.IMSS, E.CONSEM, E.PHOTOFILE, T.ID AS IDTEMPLATE, T.NOMBRE AS PLANTILLA, T.RUTA, T.FONDO1, T.FONDO2  FROM "+TABLE_NAME+" E INNER JOIN " + gafetes.db.GlobalSettings.GetPrefix() + "TEMPLATES  T ON  E.TEMPLATE = T.ID  WHERE "+field+ " LIKE '%"+ name +"%' ORDER BY APELLIDOS;";
        ResultSet rs = db.executeQuery(query);
        EmpleadosModel im = new EmpleadosModel();
        
        if( rs != null ) {
            try{
                while( rs.next() )
                {
                    
                    
                    Empleado i = new Empleado();
                    int id  = rs.getInt("DATAKEY");
                    String clave = rs.getString("CLAVE");
                    String nombre = rs.getString("Nombre");
                    String apellidos = rs.getString("APELLIDOS");
                    String puesto = rs.getString("PUESTO");
                    String area = rs.getString("AREA");
                    int template = rs.getInt("TEMPLATE");
                    
                    String rfc = rs.getString("RFC");
                    String imss = rs.getString("IMSS");
                    String consecutivo  = rs.getString("CONSEM");
                                                 
                    String photofile  = rs.getString("PHOTOFILE");
                    
                    i.setId(id);
                    i.setClave(clave);
                    i.setNombre(nombre);
                    i.setApellidos(apellidos);
                    
                    i.setTemplate(template);
                    
                    i.setPuesto(puesto);
                    i.setArea(area);
                    i.setImss(imss);
                    i.setConsecutivo(consecutivo);
                    i.setRutaFoto(photofile);
                    //System.out.println("Desde i " +i.getRutaFoto());
                    
                    java.util.Vector row = new java.util.Vector();
                    row.add(clave);
                    row.add(i);
                    row.add(apellidos);
                    row.add(puesto);
                    row.add(area);
                    row.add(new Boolean(false));
                    row.add(rfc);
                    row.add(imss);
                    row.add(imss);
                    
                    im.addRow(row);
                }
            }catch(java.sql.SQLException ex){
                ex.printStackTrace();
    		return null;
            }
            
        }else{
            im = null;
        }        
        return im;
    }
    
    public static EmpleadosModel getEmpleadosById(String ID ){
        
        //db = new MSSQL();        
        String query = "SELECT * FROM "+ TABLE_NAME+" WHERE CLAVE=' "+ ID +"' ORDER BY IDE_INTEGRANTE;";
        ResultSet rs = db.executeQuery(query);
        EmpleadosModel im = new EmpleadosModel();
        
        if( rs != null ) {
            try{
                while( rs.next() )
                {
                    Empleado i = new Empleado();
                    int id  = rs.getInt("DATAKEY");
                    String clave = rs.getString("CLAVE");
                    String nombre = rs.getString("Nombre");
                    String apellidos = rs.getString("APELLIDOS");
                    String puesto = rs.getString("PUESTO");
                    String area = rs.getString("AREA");
                    int template = rs.getInt("TEMPLATE");
                    
                    String rfc = rs.getString("RFC");
                    String imss = rs.getString("IMSS");
                    String consecutivo  = rs.getString("CONSEM");
                    String photofile  = rs.getString("PHOTOFILE");
                                                 
                    i.setId(id);
                    i.setClave(clave);
                    i.setNombre(nombre);
                    i.setApellidos(apellidos);
                
                    i.setPuesto(puesto);
                    i.setArea(area);
                    i.setRutaFoto(photofile);
                    i.setImss(imss);
                    i.setConsecutivo(consecutivo);
                    i.setTemplate(template);
                    
                    
                    java.util.Vector row = new java.util.Vector();
                    row.add(id);
                    row.add(nombre);
                    row.add(apellidos);
                    row.add(puesto);
                    row.add(area);
                    row.add(rfc);
                    row.add(imss);
                    im.addRow(row);
                }
                //rs.close();
            }catch(java.sql.SQLException ex){
                ex.printStackTrace();
    		return null;
            }
            
        }else{
            im = null;
        }
        
        return im;
    }
    
     
    public static gafetes.beans.Empleado getEmpleadoById( Empleado e ){
        
        //db = new MSSQL();        
        String query = "SELECT * FROM " +TABLE_NAME+ " WHERE CLAVE = '"+e.getClave()+"' AND DATAKEY="+e.getId()+";";
        ResultSet rs = db.executeQuery(query);
        Empleado i = new Empleado();
        
        if( rs != null ) {
            try{
                if( rs.next() )
                {
                    int id  = rs.getInt("DATAKEY");
                    String clave = rs.getString("CLAVE");
                    String nombre = rs.getString("Nombre");
                    String apellidos = rs.getString("APELLIDOS");
                    String puesto = rs.getString("PUESTO");
                    String zona = rs.getString("ZONA");
                    String area = rs.getString("AREA");
                    int template = rs.getInt("TEMPLATE");
                    String categoria = rs.getString("CATEG");
                    
                    String rfc = rs.getString("RFC");
                    String ruta = rs.getString("PHOTOFILE");
                    String imss = rs.getString("IMSS");
                    String consecutivo  = rs.getString("CONSEM");
                    String rutaFirma  = rs.getString("RUTAFIRMA");
                    Date fechaIngreso = rs.getDate("FECHAINGRESO");
                    
                    
                    i.setId(id);
                    i.setClave(clave);
                    i.setNombre(nombre);
                    i.setApellidos(apellidos);
                    i.setRfc(rfc);
                
                    i.setPuesto(puesto);
                    i.setArea(area);
                    i.setImss(imss);
                    i.setCategoria(categoria);                
                    i.setConsecutivo(consecutivo);
                    i.setZona(zona);
                    i.setRutaFoto(ruta);
                    i.setTemplate(template);
                    i.setRutaFirma(rutaFirma);
                    java.util.Calendar calendar = java.util.Calendar.getInstance();
                    
                    calendar.setTimeInMillis(fechaIngreso.getTime());


                    i.setFechaIngreso(calendar);
                    
                    
                    return i;
                }
                
                db.close();
            }catch(java.sql.SQLException ex){
                ex.printStackTrace();
    		return null;
            }
            
        }else{
            i = null;
        }
        
        return i;
    }    
    
    
     public static TemplateModel getAllTemplates(int status){
        
        String query = "SELECT ID, NOMBRE, RUTA, RUTA_REVERSO, LOGOTIPO, FONDO1, FONDO2 FROM " + gafetes.db.GlobalSettings.GetPrefix() + "TEMPLATES ORDER BY ID;";
        ResultSet rs = db.executeQuery(query);
        TemplateModel im = new TemplateModel();
        
        if( rs != null ) {
            try{
                while( rs.next() )
                {
                    Template t = new Template();
                    int id  = rs.getInt("ID");
                    String nombre = rs.getString("NOMBRE");
                    String ruta = rs.getString("RUTA");
                    String reverso = rs.getString("RUTA_REVERSO");
                    String logotipo = rs.getString("LOGOTIPO");
                    String fondo1 = rs.getString("FONDO1");
                    String fondo2 = rs.getString("FONDO2");
                    
                    t.setId(id);
                    t.setNombre(nombre);
                    t.setRuta(ruta);
                    t.setRutaReverso(reverso);                    
                    t.setLogotipo(logotipo);
                    
                    t.setFondo1(fondo1);
                    t.setFondo2(fondo2);                   
                    
                    java.util.Vector row = new java.util.Vector();
                    row.add(id);
                    row.add(t);
                    row.add(t.getRuta());
                    row.add(t.getRutaReverso());
                    row.add(t.getLogotipo());
                    row.add(t.getFondo1());
                    row.add(t.getFondo2());
                    
                    im.addRow(row);
                }
            }catch(java.sql.SQLException ex){
                ex.printStackTrace();
    		return null;
            }
            
        }else{
            im = null;
        }        
        return im;
    }
    
     
    //Obtiene la ruta a la plantilla, frontal o reverso segun el parametro que se especifica  
    public static String getRutaTemplate( int id, boolean frente ){
           
        String query = "SELECT * FROM " + GlobalSettings.GetPrefix() + "TEMPLATES WHERE ID = "+id+";";
        ResultSet rs = db.executeQuery(query);        
        String ruta = "";
        
        System.out.println("Obteniendo el Template ID: " + id);
              
        if( rs != null ) {
            try{
                while( rs.next() )
                {
                    int ID  = rs.getInt("ID");
                    if( frente )
                        ruta = rs.getString("RUTA");                        
                    else
                        ruta = rs.getString("RUTA_REVERSO");
                                        
                }
            }catch(java.sql.SQLException ex){
                ex.printStackTrace();
    		return "";
            }
            
        }else{
            ruta = "";
        }
        
        db.close();
        return ruta;
    }    

    public static boolean existeTemplate(int template){        
        String query = "SELECT * FROM " + GlobalSettings.GetPrefix() + "TEMPLATES WHERE ID="+template;
        java.sql.ResultSet rs = db.executeQuery(query);
        try{
            while( rs.next() )
                return true;
            }catch(java.sql.SQLException ex){
                ex.printStackTrace();
    		return false;
            }
        return false;
    }
    
    public static void main (String args[]) throws Exception {
        gafetes.business.SqlHelper.getRutaTemplate(1,true);        
    }
    
    
           
    public static int saveConfig (gafetes.beans.Configuracion config ){
      
        String deleteSQL = " DELETE FROM   " +gafetes.db.GlobalSettings.GetPrefix() + "CONFIGURACION "                
               + "   WHERE PARAMETRO = ?";
        
         String iSQL = " INSERT INTO "+ gafetes.db.GlobalSettings.GetPrefix() + "CONFIGURACION" +"(PARAMETRO,VALOR) " +
        " VALUES(?,?);";
         
        PreparedStatement pStmt = db.getPreparedStatement( deleteSQL );        
       
        try{            
            //Borramos previamente el parametro en caso de que ya exista
            pStmt.setString(1, config.getParametro());
            pStmt.executeUpdate();
            //Ahora insertamos el nuevo parametro y valor
            pStmt = db.getPreparedStatement( iSQL );        
            pStmt.setString(1, config.getParametro());
            pStmt.setString(2,  config.getValor());           
            pStmt.executeUpdate();
            
        }catch( NullPointerException npe ) {    		
            javax.swing.JOptionPane.showMessageDialog(gafetes.Application.getparentFrame(),"Ocurrió un error algún dato es nulo");
            return -1;
            
    	}catch( SQLException sqle ) {
    		sqle.printStackTrace();
    		return -1;    		
    	}  	 
        return 1;   
        
    }
    
    
     public static java.util.Vector getListaCampos(String tableName){
    
        java.util.Vector v = new java.util.Vector();
            String query = " SELECT sc.name FROM sys.objects so INNER JOIN sys.columns sc ON "
            + " so.[object_id]=sc.[object_id] "
            + " WHERE so.name='"  + tableName +"'";
             java.sql.ResultSet rs = db.executeQuery(query);
       
        if( rs != null ) {
            try{
                while( rs.next() )
                {
                 
                    String nombre = rs.getString("name");
                 
                    v.addElement(nombre);
                }
             }catch(java.lang.NullPointerException ne){
                System.out.println(ne.toString());
    		return null;
            
            }catch(java.sql.SQLException ex){
                ex.printStackTrace();
    		return null;
            }
           
        }
         return v;
    }
    
     
      public static java.util.Vector getConfiguracionGlobal(){
    
        java.util.Vector v = new java.util.Vector();
        String query = " SELECT * FROM " + gafetes.db.GlobalSettings.GetPrefix() + "CONFIGURACION";

        java.sql.ResultSet rs = db.executeQuery(query);
       
        if( rs != null ) {
            try{
                while( rs.next() )
                {
                    gafetes.beans.Configuracion config = new gafetes.beans.Configuracion();
                    String parametro = rs.getString("PARAMETRO");
                    String valor = rs.getString("VALOR");
                    config.setParametro(parametro);
                    config.setValor(valor);
                    v.addElement(config);
                }
             }catch(java.lang.NullPointerException ne){
                System.out.println(ne.toString());
    		return null;
            
            }catch(java.sql.SQLException ex){
                ex.printStackTrace();
    		return null;
            }
           
        }
         return v;
    }
    
     public static gafetes.beans.Configuracion getConfiguracionEspecifica(String parameterName){
    
        java.util.Vector v = new java.util.Vector();
        String query = " SELECT * FROM " + gafetes.db.GlobalSettings.GetPrefix() + "CONFIGURACION WHERE PARAMETRO = '" + parameterName +"'";

        java.sql.ResultSet rs = db.executeQuery(query);
        gafetes.beans.Configuracion config = null ;
        if( rs != null ) {
            try{
                while( rs.next() )
                {
                   config = new gafetes.beans.Configuracion();
                    String parametro = rs.getString("PARAMETRO");
                    String valor = rs.getString("VALOR");
                    config.setParametro(parametro);
                    config.setValor(valor);
                 
                }
             }catch(java.lang.NullPointerException ne){
                System.out.println(ne.toString());
    		return null;
            
            }catch(java.sql.SQLException ex){
                ex.printStackTrace();
    		return null;
            }
           
        }
         return config;
    }
    
    
    //public static gafetes.MsAccess db = new gafetes.MsAccess();
    public static gafetes.db.MSSQL db = new gafetes.db.MSSQL();
}


