/*
 * IntegranteModel.java
 *
 * Created on 7 de agosto de 2007, 12:26 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gafetes.model;


import javax.swing.event.*;
import javax.swing.plaf.*;
import javax.swing.table.*;
import java.util.*;




public class IntegranteModel extends AbstractTableModel {

//class KitModel extends DefaultTableModel {



    Vector		rows = new Vector();

	String[] columnNames = {"ID", "NOMBRE","DIRECCION","TELEFONO","CIUDAD","F. NACIMIENTO", "TIPO"};

	

	private double subtotal	=0;

	private double total	=0;

	private double totalImpuesto	=0;

	private double totalDescuento	=0;

	

		

	public IntegranteModel()

	{

		/*rows = new Vector();



		int count = getColumnCount() ;

		

		for (int j = 0; j < 1; j++) {

			Vector newRow = new Vector();

			for (int i = 0; i < count; i++) {			   	

							

			switch( i ) {			

		

			case 0:
				newRow.addElement(	new Integer(0) );
			break;

			

			case 1:
				newRow.addElement(	new String("") );

			break;

			
			case 2:
				newRow.addElement(	new String("") );

			break;

			default:

				newRow.addElement(	new String( "" )	);

			}

				

				

			

			   						

    		}

        	rows.addElement(newRow);

		}	*/	

	}		

	

	public int getColumnCount() {

	    return columnNames.length;

	}

	

	public int getRowCount() {

        return rows.size();

    }



	public Object getValueAt(int aRow, int aColumn) {

        Vector row = (Vector)rows.elementAt(aRow);

        return row.elementAt(aColumn);

    }

	

	public String getColumnName(int column) {

     

	    if (columnNames[column] != null) {

            return columnNames[column];

        } else {

            return "";

        }

    }

	

	

	public Class getColumnClass(int c) {

		return getValueAt(0	, c).getClass();

	}



	public boolean isCellEditable(int row, int col) {
		return false;	
	}

	

	public void setValueAt(Object aValue, int row, int column) {	 	

	    Vector dataRow = (Vector)rows.elementAt(row);

	    dataRow.setElementAt( aValue, column);

	}	

	

	



	

/*	public void update( Articulo a )

	{				

	

	}		*/

	public void removeRow( int row )
	{	
		rows.remove( row );
		fireTableRowsDeleted( row, row );
	}

	

	public void addRow( Vector newRow )
	{
	 	rows.addElement(newRow);
		int rowCount = getRowCount();
		fireTableRowsInserted(rowCount,rowCount);
	}
	
	
	public void addRow()
	{


		int count = getColumnCount() ;

		

		for (int j = 0; j < 1; j++) {

			Vector newRow = new Vector();

			for (int i = 0; i < count; i++) {			   	

							

			switch( i ) {			

                        case 0:
				newRow.addElement(	new Integer(0) );
			break;

                        case 1:
				newRow.addElement(	new String("") );
			break;


			case 2:
				newRow.addElement(	new String("") );

			break;

			default:

				newRow.addElement(	new String( "" )	);

			}
    		}

        	rows.addElement(newRow);

		}		

	}		

	

}



