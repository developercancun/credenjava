/*
 * MenuPrincipal.java
 *
 * Created on 1 de febrero de 2008, 08:42 PM
 */

package gafetes;

/**
 *
 * @author  jalafita
 */
public class MenuPrincipal extends javax.swing.JFrame {
    
    /** Creates new form MenuPrincipal */
    public MenuPrincipal() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jButton1.setBackground(new java.awt.Color(244, 244, 240));
        jButton1.setIcon(new javax.swing.ImageIcon(""));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(52, 52, 52)
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 240, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(531, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(367, 367, 367))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
    
}