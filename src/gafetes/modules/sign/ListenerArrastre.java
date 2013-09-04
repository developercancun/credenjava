/**
 * Javier Abellán, 24 Mayo 2006
 * Clase que se suscribe a los movimientos de ratón y lleva las coordenadas
 * por las que se va arrastrando, avisando al InterfaceArrastrarRaton 
 * correspondiente.
 */
package gafetes.modules.sign;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Clase que se suscribe a los movimientos de ratón y lleva las coordenadas por
 * las que se va arrastrando, avisando al InterfaceArrastrarRaton
 * correspondiente.
 * Implementa MouseMotionListener para que la pueda añadir como 
 * addMouseMotionListener() de un Component java.
 * 
 * @author javaapplication4
 */
public class ListenerArrastre implements MouseMotionListener
{
    /** Clase encargada de hacer algo con el arrastre del ratón */
    private InterfaceArrastrarRaton accion;

    /** Construye una instancia de esta clase y se guarda la accion que se le
     * pasa.
     * @param accion Clase a la que se irá avisando del arrastre del ratón.
     */
    public ListenerArrastre(InterfaceArrastrarRaton accion)
    {
        this.accion = accion;
    }

    /** Si actualmente se está arrastrando o no el ratón */
    boolean arrastrando = false;

    /** x del ratón antes de producirse el último arrastre */
    int xAntigua;

    /** y del ratón antes de producirse el último arrastre */
    int yAntigua;

    /**
     * Se mueve el ratón sin arrastre. Se marca como que no se está arrastrando
     */
    public void mouseMoved(MouseEvent e)
    {
        if (arrastrando == true)
            accion.finalizaArrastra(xAntigua, yAntigua);
        arrastrando = false;
        xAntigua = e.getX();
        yAntigua = e.getY();
    }

    /**
     * Se está arrastrando el ratón. Se avisa a la accion correspondiente y
     * se actualizan todas las coordenadas.
     */
    public void mouseDragged(MouseEvent e)
    {
        if (arrastrando == false)
        {
            accion.comienzaArrastra(e.getX(), e.getY());
            arrastrando = true;
        }
        accion.arrastra(xAntigua, yAntigua, e.getX(), e.getY());
        xAntigua = e.getX();
        yAntigua = e.getY();
    }

    /**
     * Permite cambiar la acción a realizar cuando se arrastre el ratón.
     * @param accion La nueva acción a realizar.
     */
    public void setAccion(InterfaceArrastrarRaton accion)
    {
        this.accion = accion;
    }

}
