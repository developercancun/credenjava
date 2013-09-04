/**
 * Javier Abellán, 24 Mayo 2006
 * 
 * Clase encargada de arrastrar un trazo cuando se arrastra el ratón.
 */
package gafetes.modules.sign;

import java.awt.Component;
import java.awt.geom.Point2D;
import java.util.LinkedList;

/**
 * Arrastra uno de los trazos dibujados cuando se arrastra el ratón.
 * @author javaapplication4
 */
public class ArrastraTrazo implements InterfaceArrastrarRaton
{
    /** Lista de trazos dibujados */
    private LinkedList<Trazo> trazos;

    /** Lienzo en el que se dibuja */
    private Component lienzo;

    /** Indice en la lista de trazos del trazo que se está arrastrando */
    private int trazoArrastrado;

    /**
     * Construye una instancia de esta clase, guardando los parámetros que se
     * le pasan.
     * @param trazos Lista de trazos dibujados
     * @param lienzo Lienzo en el que están dibujados los trazos.
     */
    public ArrastraTrazo(LinkedList<Trazo> trazos, Component lienzo)
    {
        this.trazos = trazos;
        this.lienzo = lienzo;
    }

    /**
     * Busca el trazo más cercano a la posición x,y que se le pasa y lo marca
     * como trazo para arrastrar.
     */
    public void comienzaArrastra(int x, int y)
    {
        trazoArrastrado = 0;
        if (trazos.size()==0)
            return;
        double distancia = trazos.get(0).dameDistanciaMinima(x, y);
        for (int i = 1; i < trazos.size(); i++)
        {
            double distanciaAux = trazos.get(i).dameDistanciaMinima(x, y);
            if (distanciaAux < distancia)
            {
                distancia = distanciaAux;
                trazoArrastrado = i;
            }
        }
    }

    /**
     * Arrastra el trazo marcado como trazo para arrastrar y lo desplaza en 
     * x una distancia xNueva - xAntigua y en y una distnacia yNueva - yAntigua
     */
    public void arrastra(int xAntigua, int yAntigua, int xNueva, int yNueva)
    {
        if (trazos.size()==0)
            return;
        Trazo trazo = trazos.get(trazoArrastrado);
        for (int i = 0; i < trazo.getNumeroPuntos(); i++)
        {
            Point2D punto = trazo.getPunto(i);
            punto.setLocation(punto.getX() + (xNueva - xAntigua), punto.getY()
                    + (yNueva - yAntigua));
        }
        lienzo.repaint();
    }

    /** No hace nada */
    public void finalizaArrastra(int x, int y)
    {
    }

}
