/**
 * Javier Abellán, 24 Mayo 2006
 * 
 * Programa de prueba con main y applet de PanelPaint
 */
package gafetes.modules.sign.pruebas;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.awt.Component;
import javax.swing.JComponent;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

import java.awt.image.*;
import java.io.*;


import gafetes.modules.sign.PanelPaint;

/**
 * Clase para prueba de PanelPaint
 * 
 * @author Chuidiang
 *
 */
public class PruebaPaint extends JPanel
{

    /**
     *  serial uid
     */
    private static final long serialVersionUID = 3690194364970250292L;

    /**
     * Inatancia esta clase y llama al método que la lanza en un JFrame.
     * @param args
     */
    public static void main(String[] args)
    {
        //javax.swing.JDialog d = new javax.swing.JDialog(new javax.swing.JFrame(), true);
        
        new PruebaPaint().lanzaVentanaSeparada();

    }

    /**
     * Crea un JFrame, le mete una barra de herramientas y un PanelPaint y lo
     * visualiza todo
     *
     */
    public void lanzaVentanaSeparada()
    {
        JFrame v = new JFrame();
        construyeTodo(v.getContentPane());
        v.setSize(200, 200);
        //v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        v.setVisible(true);
    }

    /**
     * Método que inicializa el applet. Mete dentro del applet la barra de
     * herramientas y el PanelPaint
     */
    public void init()
    {
        construyeTodo(this);
    }

    /**
     * Inicilaiza las variables de esta clase.
     */
    private void inicializaVariables()
    {
        cadenasColor = new String[] { "Rojo", "Verde", "Azul", "Blanco",
                "Negro" };
        colores = new Color[] { Color.red, Color.green, Color.blue,
                Color.white, Color.black };
    }

    /**
     * Inicializa las variables, construye la barra de herramientas y el 
     * PanelPaint y lo mete todo en el contenedor que se le pasa.
     * @param contenedor
     */
    private void construyeTodo(Container contenedor)
    {
        inicializaVariables();
        contenedor.setSize(200, 200);
        contenedor.setLayout(new BorderLayout());
        panelPaint = new PanelPaint();
        panelPaint.setBackground(Color.white);
        contenedor.add(panelPaint, BorderLayout.CENTER);
        Component panelHerramientas = damePanelHerramientas();
        contenedor.add(panelHerramientas, BorderLayout.NORTH);
    }

    /**
     * Construye la barra de herramientas y la devuelve.
     * @return La barra de herramientas
     */
    private Component damePanelHerramientas()
    {
        JPanel panelHerramientas = new JPanel(new FlowLayout());
        ButtonGroup grupo = new ButtonGroup();
        JRadioButton botones[] = new JRadioButton[cadenasColor.length];
        for (int i = 0; i < cadenasColor.length; i++)
        {
            botones[i] = new JRadioButton(cadenasColor[i]);
            botones[i].setActionCommand(cadenasColor[i]);
            grupo.add(botones[i]);
            panelHerramientas.add(botones[i]);
            botones[i].addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    for (int i = 0; i < cadenasColor.length; i++)
                        if (cadenasColor[i].equals(e.getActionCommand()))
                        {
                            panelPaint.setColorActual(colores[i]);
                            break;
                        }
                }
            });
        }
        checkArrastrar = new JCheckBox("Arrastrar");
        checkArrastrar.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                if (checkArrastrar.isSelected())
                {
                    panelPaint.modoArrastrar();
                    guardar();
                } else
                    panelPaint.modoPintar();
            }

        });
        panelHerramientas.add(checkArrastrar);
        return panelHerramientas;
    }

    private void guardar(){
        File f = new File("c:\\Gafetes\\fotos\\lola.png");
        guardarImagen(f,this);
    }
    
       
    public void guardarImagen(File file, JComponent c){
               
        int width = (int) c.getSize().getWidth();
        int height = (int)c.getSize().getHeight();
        BufferedImage bi = new  BufferedImage(200,200,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bi.createGraphics();
        c.paint(g2d);
        g2d.dispose();
        RenderedImage ri = bi;
        try{
            ImageIO.write(ri,"jpg",file);
            
        }catch(IOException ios){
            // System.out.println("Error"+ios.printStackTrace());
        }
        return;
    }
    /**
     * Texto para los colores
     */
    private String[] cadenasColor = null;

    /**
     * Colores
     */
    private Color[] colores = null;

    /**
     * Panel de dibujo estilo paint
     */
    private PanelPaint panelPaint;

    /**
     * Check para decidir si arrastrar o pintar los trazos
     */
    private JCheckBox checkArrastrar;
}
