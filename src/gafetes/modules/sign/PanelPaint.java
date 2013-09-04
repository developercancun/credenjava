/**
 * Javier Abellán, 24 Mayo 2006
 * Panel de paint.
 */
package gafetes.modules.sign;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.LinkedList;

/**
 * Panel similar a un paintbrush de windows, que permite dibujar trazos 
 * arrastrando el ratón.
 * @author Chuidiang.
 *
 */
public class PanelPaint extends Canvas
{
    /**
     * serial uid
     */
    private static final long serialVersionUID = 3978706198935583032L;

    /** Acción de pintar trazo mientrasa se arrastra el ratón */
    private PintaTrazo pintaTrazo = null;

    /** Clase suscriptora de los arrastres de ratón */
    private ListenerArrastre listener = null;

    /** Lista de trazos dibujados */
    private LinkedList<Trazo> trazos = new LinkedList<Trazo>();

    /** Acción de mover un trazo cuando se le arrastra con el ratón. */
    private ArrastraTrazo arrastraTrazo = null;

    /** Indica si estamos en modo de arrastre de trazos o de dibujo de los 
     * mismos.
     */
    private boolean modoArrastrar = false;

    /**
     * Pone el modo de arrastre de trazos.
     *
     */
    public void modoArrastrar()
    {
        listener.setAccion(arrastraTrazo);
        modoArrastrar = true;
    }

    /** 
     * Pone el modo de dibujo de trazos.
     *
     */
    public void modoPintar()
    {
        listener.setAccion(pintaTrazo);
        modoArrastrar = false;
    }

    /**
     * Crea una intancia de esta clase, inicializando todo.
     *
     */
    public PanelPaint()
    {
        pintaTrazo = new PintaTrazo(trazos, this);
        listener = new ListenerArrastre(pintaTrazo);
        arrastraTrazo = new ArrastraTrazo(trazos, this);
        addMouseMotionListener(listener);
    }

    /**
     * Si el modo es arrastre, borra el canvas entero. Si no, no lo hace.
     * Luego llama a paint(g)
     */
    public void update(Graphics g)
    {
        if (modoArrastrar)
            super.update(g);
        paint(g);
    }

    /**
     * Dibuja los trazos en este componente
     */
    public void paint(Graphics g)
    {
        for (int i = 0; i < trazos.size(); i++)
        {
            dibujaTrazo(trazos.get(i), g);
        }
    }

    /**
     * Dibuja un trazo en este componente.
     * @param trazo Trazo a dibujar.
     * @param g Graphics para dibujo.
     */
    private void dibujaTrazo(Trazo trazo, Graphics g)
    {
        g.setColor(trazo.getColor());
        Point2D p0 = trazo.getPunto(0);
        for (int i = 0; i < trazo.getNumeroPuntos() - 1; i++)
        {
            Point2D p1 = trazo.getPunto(i + 1);
            g.drawLine((int) p0.getX(), (int) p0.getY(), (int) p1.getX(),
                    (int) p1.getY());
            p0 = p1;
        }
    }

    /**
     * Cambia el color de dibujo del trazo.
     * @param colorActual
     */
    public void setColorActual(Color colorActual)
    {
        pintaTrazo.setColorActual(colorActual);
    }
}
