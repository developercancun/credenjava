/**
 * Javier Abellán, 24 Mayo 2006
 * Acción para dibujo de trazos.
 */
package gafetes.modules.sign;

import java.awt.Color;
import java.awt.Component;
import java.util.LinkedList;

/**
 * Construye trazos según se le avisa de arrastre de ratón.
 * @author javaapplication4.
 *
 */
public class PintaTrazo implements InterfaceArrastrarRaton
{
    /** Lista de trazos */
    private LinkedList<Trazo> trazos;

    /** Trazo que se está construyendo actualmente */
    private Trazo trazoActual = null;

    /** Lienzo de dibujo, necesario para llamar a repaint() según se va
     * construyendo un nuevo trazo.
     */
    private Component lienzo;

    /** Color del que se está dibujando el trazo actual */
    private Color colorActual = Color.black;

    /** Construye una instancia de esta clase, guardandose los parémtros que
     * le pasan.
     * @param trazos Lista donde irá metiendo los nuevos trazos que se creen.
     * @param lienzo Llamará a repaint() de este componente según se va
     * construyendo un trazo.
     */
    public PintaTrazo(LinkedList<Trazo> trazos, Component lienzo)
    {
        this.trazos = trazos;
        this.lienzo = lienzo;
    }

    /**
     * Crea un trazo nuevo y le pone como primer punto x,y.
     */
    public void comienzaArrastra(int x, int y)
    {
        trazoActual = new Trazo();
        trazoActual.setColor(colorActual);
        trazoActual.addPunto(x, y);
        trazos.add(trazoActual);
        lienzo.repaint();
    }

    /** Añade un nuevo punto al trazo actual */
    public void arrastra(int xAntigua, int yAntigua, int xNueva, int yNueva)
    {
        trazoActual.addPunto(xNueva, yNueva);
        lienzo.repaint();
    }

    /** Marca que ya no hay trazo actual */
    public void finalizaArrastra(int x, int y)
    {
        trazoActual = null;
    }

    /** Guarda el color para el próximo trazo que se dibuje */
    public void setColorActual(Color colorActual)
    {
        this.colorActual = colorActual;
    }
}
