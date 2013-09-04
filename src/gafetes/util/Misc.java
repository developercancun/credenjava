package gafetes.util;
import javax.swing.UIManager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.JDesktopPane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JTree;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeNode;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import java.util.Enumeration;

import java.net.URL;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.GridLayout;
public class Misc {
	
        /** Creates a new instance of Misc */
	public Misc() {
    
    }
    
    public static void centerFrame(java.awt.Component c) {
                java.awt.Toolkit tk = java.awt.Toolkit.getDefaultToolkit();
               
               c.setLocation((int)((tk.getScreenSize().getWidth()-c.getWidth())/2), 
                       (int)((tk.getScreenSize().getHeight()- c.getHeight())/2) );
	}
	
	public static String getClassPath() {
                return (String)System.getProperty("java.class.path");
	}
        
    public static void windowsItemActionPerformed(java.awt.Component comp) {
    
        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(comp);
        }
         catch(ClassNotFoundException cnfe)
         {
            System.out.println("can't find normal L&F " + cnfe);
         }
         catch(InstantiationException ie)
         {
            System.out.println("can't instantiate normal L&F " + ie);
         }
         catch(IllegalAccessException iae)
         {
            System.out.println("can't access normal L&F " + iae);
         }
         catch(UnsupportedLookAndFeelException ulafe)
         {
            System.out.println("unsupported L&F  " + ulafe);
         }
    }
        
        
}