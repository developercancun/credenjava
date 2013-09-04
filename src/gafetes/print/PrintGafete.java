/*
 * PrintGafete.java
 *
 * Created on 25 de enero de 2008, 09:32 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gafetes.print;
import gafetes.db.*;
import gafetes.util.VariablesAmbiente;
import java.io.*;

//import gafetes.db.*;
import java.net.URL;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine .*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.logging.Log;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.*;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.engine.export.*;


public class PrintGafete {    
    public PrintGafete() {		
    }
        
    public   java.sql.Connection getConnection( )  
    {
        Connection conn=null;
        try{
        conn = ConnectionFactory.getConnection();
        }catch(java.sql.SQLException ex){
            conn = null;
        }
        return conn;
        
        
    }	

     public void print(gafetes.beans.Empleado e, boolean frente) {	
        java.util.Calendar cal = java.util.Calendar.getInstance();                        
        java.sql.Date fecha = new java.sql.Date( cal.getTime().getTime() );
        int year = cal.get(java.util.Calendar.YEAR);
        int year2 = year +  1;
        String vigencia  = year + " - " + year2;
        
        URL urlMaestro = null;
        String ruta = gafetes.business.SqlHelper.getRutaTemplate(e.getTemplate(),frente);
       
        
          /*  Modificado por: Juan Carlos Alafita Caballero
           Desactivamos la extraccion por URL con getClass, lo obtendremos como archivo*/
         //URL urlMaestro = getClass().getResource("/gafetes/reports/firmas.jasper");
            /*urlMaestro = getClass().getResource( "/gafetes/reports/"+ruta);
            if (urlMaestro == null) {
                    javax.swing.JOptionPane.showMessageDialog( new javax.swing.JFrame(), 
                    "No se encontró el archivo del reporte maestro.", "Mensaje desde el Servidor",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);	
            }*/
        //JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file);
        //System.out.println("Successfully created jasper report");
        
        // Cargamos el reporte mediante como archivo mediante FileInputStream desde el directorio reports
        JasperReport masterReport = null;
        FileInputStream file = null;
        String rutaReporte = gafetes.business.SqlHelper.getRutaTemplate(e.getTemplate(),frente);
        
        try {
             rutaReporte = "reports" + java.io.File.separator + rutaReporte;
             System.out.println("Ruta al reporte:" + rutaReporte);
             
             file = new FileInputStream(rutaReporte);            
             masterReport = (JasperReport) JRLoader.loadObject(file);
             
            

        } catch (JRException ex) {
                System.out.println("JRException:: Error en metodo masterReport = (JasperReport) JRLoader.loadObject(file)");
                javax.swing.JOptionPane.showMessageDialog( new javax.swing.JFrame() , 
                            ex.getStackTrace() + "  Error cargando el archivo." + ex.getMessage() + "  " +  rutaReporte, "Mensaje desde el Servidor",
                            javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }catch(Exception exs){
            System.out.println("Error en metodo masterReport = (JasperReport) JRLoader.loadObject(file)");
                javax.swing.JOptionPane.showMessageDialog( new javax.swing.JFrame() , 
                            exs.getStackTrace() + "  Excepcion General. Error cargando el archivo: " + exs.getMessage() + "  " , "Mensaje desde el Servidor",
                            javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
            // Obtenemos una conexión con la base de datos
        java.sql.Connection con = null;
        con = getConnection();

        // Parámetros del reporte maestro
        Map masterParams = new HashMap();
        /*
       gafetes.beans.Configuracion config = gafetes.business.SqlHelper.getConfiguracionEspecifica("CAMPO_CODIGOBARRA");
       if(config!=null){
       if( config.getValor().equals("IMSS") )                     
                masterParams.put("CODIGOBARRA", e.getImss());
       
       else   if( config.getValor().equals("CLAVE") )
              masterParams.put("CODIGOBARRA", e.getClave());
               
       else if( config.getValor().equals("IDE_INTEGRANTE") )  
                    masterParams.put("CODIGOBARRA", e.getId());
       
       else if( config.getValor().equals("RFC") )     
                masterParams.put("CODIGOBARRA", e.getRfc());
       else             
                masterParams.put("CODIGOBARRA", e.getClave());
       }else
               masterParams.put("CODIGOBARRA", e.getClave());
      */
       
        
        masterParams.put("CLAVE", e.getClave());
        /*
        
        
        masterParams.put("DATAKEY", e.getId());
        masterParams.put("VIGENCIA", vigencia);
        masterParams.put("TABLE_NAME", "Empleados");*/
        try {
            //String rutaCompleta = VariablesAmbiente.getRutaCarpetaFotos()+e.getRutaFoto().substring(11).replace("\\","//");
           // java.io.File file = null;
           /* 
           if(reverso)
               file = new java.io.File(e.getRutaFoto());
           else
               file = new java.io.File(e.getRutaFirma());
            
         */
            //java.net.URL rutaURL = new java.net.URL(rutaCompleta);
           // masterParams.put("PHOTOFILE", file );
           // System.out.println("Ruta Web"+ rutaCompleta );

            // Llenamos el reporte maestro (y por ende el subreporte)
            // y obtenemos un objeto JasperPrint que puede ser
            // visua	lizado, impreso o exportado
            JasperPrint masterPrint = null;
            try {			
                masterPrint = JasperFillManager.fillReport(masterReport, masterParams,
                                con);                
                JasperViewer.viewReport(masterPrint , false);
                
                
            } catch (JRException exe) {
                                System.out.println("ex Error en metodo masterPrint = JasperFillManager.fillReport(masterReport, masterParams,con); ");
                    javax.swing.JOptionPane.showMessageDialog( new javax.swing.JFrame() , 
                            "Error llenando el reporte" + exe.getMessage(), "Mensaje desde el Servidor",
                            javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception exs) {
                 System.out.println("exs  Error en metodo masterPrint = JasperFillManager.fillReport(masterReport, masterParams,con); ");
                javax.swing.JOptionPane.showMessageDialog( new javax.swing.JFrame() , 
                        "Error llenando el reporte" + exs.getStackTrace(), "Mensaje desde el Servidor",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception exa) {
                                          System.out.println("exa Error en metodo masterPrint = JasperFillManager.fillReport(masterReport, masterParams,con); ");
        javax.swing.JOptionPane.showMessageDialog( new javax.swing.JFrame() , 
                        "Error llenando el reporte" + exa.getStackTrace(), "Mensaje desde el Servidor",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }

     
    public void printLetterSize(gafetes.beans.Empleado e, boolean frente, String sqlString1,String sqlString2,String sqlString3) {	
        java.util.Calendar cal = java.util.Calendar.getInstance();                        
        java.sql.Date fecha = new java.sql.Date( cal.getTime().getTime() );
        int year = cal.get(java.util.Calendar.YEAR);
        int year2 = year +  1;
        String vigencia  = year + " - " + year2;
        
         URL urlMaestro = null;
       // String ruta = gafetes.business.SqlHelper.getRutaTemplate(e.getTemplate(),frente);
       
        
          /*  Modificado por: Juan Carlos Alafita Caballero
           Desactivamos la extraccion por URL con getClass, lo obtendremos como archivo*/
         //URL urlMaestro = getClass().getResource("/gafetes/reports/firmas.jasper");
            /*urlMaestro = getClass().getResource( "/gafetes/reports/"+ruta);
            if (urlMaestro == null) {
                    javax.swing.JOptionPane.showMessageDialog( new javax.swing.JFrame(), 
                    "No se encontró el archivo del reporte maestro.", "Mensaje desde el Servidor",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);	
            }*/
            
        // Cargamos el reporte mediante como archivo mediante FileInputStream desde el directorio reports
        JasperReport masterReport = null;
        FileInputStream file = null;
        String rutaReporte = gafetes.business.SqlHelper.getRutaTemplate(e.getTemplate(),frente);
        
        try {
             rutaReporte = "reports" + java.io.File.separator + rutaReporte;
             file = new FileInputStream(rutaReporte);
             System.out.println("Ruta al reporte:" + rutaReporte);
             masterReport = (JasperReport) JRLoader.loadObject(file);
        } catch (JRException ex) {
                System.out.println("JRException:: Error en metodo masterReport = (JasperReport) JRLoader.loadObject(file)");
                javax.swing.JOptionPane.showMessageDialog( new javax.swing.JFrame() , 
                            ex.getStackTrace() + "  Error cargando el archivo." + ex.getMessage() + "  " +  rutaReporte, "Mensaje desde el Servidor",
                            javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }catch(Exception exs){
            System.out.println("Error en metodo masterReport = (JasperReport) JRLoader.loadObject(file)");
                javax.swing.JOptionPane.showMessageDialog( new javax.swing.JFrame() , 
                            exs.getStackTrace() + "  Excepcion General. Error cargando el archivo: " + exs.getMessage() + "  " , "Mensaje desde el Servidor",
                            javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
            // Obtenemos una conexión con la base de datos
        java.sql.Connection con = null;
        con = getConnection();

        // Parámetros del reporte maestro
        Map masterParams = new HashMap();
        /*
       gafetes.beans.Configuracion config = gafetes.business.SqlHelper.getConfiguracionEspecifica("CAMPO_CODIGOBARRA");
       if(config!=null){
       if( config.getValor().equals("IMSS") )                     
                masterParams.put("CODIGOBARRA", e.getImss());
       
       else   if( config.getValor().equals("CLAVE") )
              masterParams.put("CODIGOBARRA", e.getClave());
               
       else if( config.getValor().equals("IDE_INTEGRANTE") )  
                    masterParams.put("CODIGOBARRA", e.getId());
       
       else if( config.getValor().equals("RFC") )     
                masterParams.put("CODIGOBARRA", e.getRfc());
       else             
                masterParams.put("CODIGOBARRA", e.getClave());
       }else
               masterParams.put("CODIGOBARRA", e.getClave());
      */
        masterParams.put("SQLQUERY1", sqlString1);
        masterParams.put("SQLQUERY2", sqlString2);
        masterParams.put("SQLQUERY3", sqlString3);
      
     
        
        
        masterParams.put("CLAVE", e.getClave());
        /*
        
        
        masterParams.put("DATAKEY", e.getId());
        masterParams.put("VIGENCIA", vigencia);
        masterParams.put("TABLE_NAME", "Empleados");*/
        try {
            //String rutaCompleta = VariablesAmbiente.getRutaCarpetaFotos()+e.getRutaFoto().substring(11).replace("\\","//");
           // java.io.File file = null;
           /* 
           if(reverso)
               file = new java.io.File(e.getRutaFoto());
           else
               file = new java.io.File(e.getRutaFirma());
            
         */
            //java.net.URL rutaURL = new java.net.URL(rutaCompleta);
           // masterParams.put("PHOTOFILE", file );
           // System.out.println("Ruta Web"+ rutaCompleta );

            // Llenamos el reporte maestro (y por ende el subreporte)
            // y obtenemos un objeto JasperPrint que puede ser
            // visua	lizado, impreso o exportado
            JasperPrint masterPrint = null;
            try {			
                masterPrint = JasperFillManager.fillReport(masterReport, masterParams,
                                con);                
                JasperViewer.viewReport(masterPrint, false);
                
            } catch (JRException exe) {
                                System.out.println("ex Error en metodo masterPrint = JasperFillManager.fillReport(masterReport, masterParams,con); ");
                    javax.swing.JOptionPane.showMessageDialog( new javax.swing.JFrame() , 
                            "Error llenando el reporte" + exe.getMessage(), "Mensaje desde el Servidor",
                            javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception exs) {
                 System.out.println("exs  Error en metodo masterPrint = JasperFillManager.fillReport(masterReport, masterParams,con); ");
                javax.swing.JOptionPane.showMessageDialog( new javax.swing.JFrame() , 
                        "Error llenando el reporte" + exs.getStackTrace(), "Mensaje desde el Servidor",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception exa) {
                                          System.out.println("exa Error en metodo masterPrint = JasperFillManager.fillReport(masterReport, masterParams,con); ");
        javax.swing.JOptionPane.showMessageDialog( new javax.swing.JFrame() , 
                        "Error llenando el reporte" + exa.getStackTrace(), "Mensaje desde el Servidor",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
