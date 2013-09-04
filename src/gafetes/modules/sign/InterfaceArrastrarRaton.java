/**
 * Javier Abellán, 24 Mayo 2006
 * Interface para las clases encargadas de hacer algo cuando se arrastre el
 * ratón.
 */
package gafetes.modules.sign;

/**
 * Interface para las clases encargadas de hacer algo cuando se arrastre el
 * ratón.

 * @author javaapplication4
 *
 */
public interface InterfaceArrastrarRaton
{
    /**
     * Se llama a este método cuando se empieza a arrastrar el ratón.
     * @param x del ratón.
     * @param y del ratón.
     */
    public void comienzaArrastra(int x, int y);

    /**
     * Se llama a este método cada vez que se arrastra el ratón.
     * @param xAntigua x del ratón antes del arrastre
     * @param yAntigua y del ratón antes del arrastre
     * @param xNueva x actual del ratón
     * @param yNueva y actual del ratón
     */
    public void arrastra(int xAntigua, int yAntigua, int xNueva, int yNueva);

    /**
     * Se llama a este método cuando se termina de arrastrar el ratón.
     * @param x del ratón.
     * @param y del ratón.
     */
    public void finalizaArrastra(int x, int y);
}
