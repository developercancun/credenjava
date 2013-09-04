/**
 * Javier Abell�n, 24 Mayo 2006
 * Interface para las clases encargadas de hacer algo cuando se arrastre el
 * rat�n.
 */
package gafetes.modules.sign;

/**
 * Interface para las clases encargadas de hacer algo cuando se arrastre el
 * rat�n.

 * @author javaapplication4
 *
 */
public interface InterfaceArrastrarRaton
{
    /**
     * Se llama a este m�todo cuando se empieza a arrastrar el rat�n.
     * @param x del rat�n.
     * @param y del rat�n.
     */
    public void comienzaArrastra(int x, int y);

    /**
     * Se llama a este m�todo cada vez que se arrastra el rat�n.
     * @param xAntigua x del rat�n antes del arrastre
     * @param yAntigua y del rat�n antes del arrastre
     * @param xNueva x actual del rat�n
     * @param yNueva y actual del rat�n
     */
    public void arrastra(int xAntigua, int yAntigua, int xNueva, int yNueva);

    /**
     * Se llama a este m�todo cuando se termina de arrastrar el rat�n.
     * @param x del rat�n.
     * @param y del rat�n.
     */
    public void finalizaArrastra(int x, int y);
}
