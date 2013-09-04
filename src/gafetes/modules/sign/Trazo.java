/**
 * Javier Abellán, 24 Mayo 2006.
 * Trazo que se dibuja en el paint.
 */
package gafetes.modules.sign;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.LinkedList;

/**
 * Trazo que se dibuja en el paint. Esta compuesto de muchos puntos que se
 * unirán por una línea de color.
 * @author javaapplication4
 *
 */
public class Trazo
{
    /** Color del trazo */
    private Color color = Color.black;

    /** Devuelve el color del trazo */
    public Color getColor()
    {
        return color;
    }

    /** Fija el color para el trazo */
    public void setColor(Color color)
    {
        this.color = color;
    }

    /** Lista de puntos que compone el trazo */
    private LinkedList<Point2D> puntos = new LinkedList<Point2D>();

    /** Añade un nuevo punto al trazo */
    public void addPunto(Point2D punto)
    {
        puntos.add(punto);
    }

    /** Devuelve la lista de puntos que compone el trazo */
    public LinkedList<Point2D> getPuntos()
    {
        return puntos;
    }

    /** Devuelve cuántos puntos componen el trazo */
    public int getNumeroPuntos()
    {
        return puntos.size();
    }

    /** Añade un nuevo punto al trazo */
    public void addPunto(int x, int y)
    {
        Point2D p = new Point2D.Float(x, y);
        puntos.add(p);
    }

    /** Devuelve el punto de la lista en la posición indicada
     * 
     * @param posicion en la lista, entre 0 y getNumeroPuntos()-1
     * @return El punto
     */
    public Point2D getPunto(int posicion)
    {
        return puntos.get(posicion);
    }

    /**
     * Devuelve una pseudodistancia entre el punto x,y y el punto más cercano
     * del trazo.
     * Método útil para saber a qué distancia del trazo se pincha el ratón.
     * @param x de un punto exterior al trazo
     * @param y de un punto exterior al trazo.
     * @return La distancia
     */
    public double dameDistanciaMinima(int x, int y)
    {
        double distancia = dameDistancia(x, y, 0);
        for (int i = 1; i < puntos.size(); i++)
        {
            distancia = Math.min(dameDistancia(x, y, i), distancia);
        }
        return distancia;
    }

    /**
     * Devuelve la pseudo-distancia entre el punto x,y y el punto i de la lista.
     * @param x de un punto exterior al trazo
     * @param y de un punto exterior al trazo
     * @param i La posicion de un punto en la lista de puntos de este trazo
     * @return La pseuod-distancia entre x,y y el punto de posicion i
     */
    private double dameDistancia(int x, int y, int i)
    {
        return Math.abs(puntos.get(i).getX() - x)
                + Math.abs(puntos.get(i).getY() - y);
    }
}
