/*
 * Main.java
 *
 * Created on 25 de enero de 2008, 07:58 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gafetes;

/**
 *
 * @author jalafita
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
                                     //new LoginDialogAdqal().show();
                                    
                                  SearchDialog t = new SearchDialog( Application.getparentFrame(), true);
                                   //Application.setParentFrame(t); 
                                   gafetes.util.Misc.centerFrame(t);
                                   t.setVisible(true);
                                   
				}
			});
        
        
    }
    
}
