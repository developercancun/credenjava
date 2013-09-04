package  gafetes;

import gafetes.beans.Usuario;
import javax.swing.JFrame;
//import andrea.beans.Usuario;



public abstract class Application {
	
    public static int CODIGO_COLUMN = 0;
    public static int COLOR_COLUMN = 1;
    public static int MATERIAL_COLUMN = 2;
    public static int MEDIDA_COLUMN = 3;
    public static int PAGINA_COLUMN = 4;
    public static int CATALOGO_COLUMN = 5;
    public static int F2_COLUMN = 0;
    public static int CANTIDAD_COLUMN = 6;
    public static int COSTO_COLUMN = 7;
    
    
    protected static Application application;
    //	protected static Preferences preferences;
    //	protected static MainWindow mainWindow;
    protected static String status;
    //protected static Departamento departamento = new Departamento();
    public  static Usuario usuario = new Usuario();
    protected static JFrame parentFrame ;
	
	public Application() {
		if (application != null) {
			// There may be only one Application instance! 
			System.err.println("MDI Framework: ERROR: Attempting to re-instantiante Application");
			System.err.println("HINT: You shuld try to get the Application instance via Application.getInstance()");
			return;
		}
		application = this;
//		preferences = new Preferences();
//		resources = createResources();
		
		setStatus("Ready");
                
	}
	
        protected static int modoImpresion = 0;
        
        public static void setModoImpresion(int modo){
            modoImpresion = modo;
        }
        
        
        public static int getModoImpresion(){
            return modoImpresion;
        }
	public static void setStatus(String newStatus) {
		status = newStatus;
	}
        
        
        public static void setUsuario(Usuario user) {
		usuario = user;
	}
			
	public static Usuario getUsuario() {	
		return usuario;
	}
        
	public static Application getInstance() {
		return application;
	}
	
/*	public static Departamento getDepartamento() {	
		return departamento;
	}
	
	public static void setDepartamento( Departamento newDepartamento) {	
		departamento = newDepartamento;
	}
	
	public static Usuario getUsuario() {	
		return usuario;
	}
	
	public static void setUsuario( Usuario newUsuario) {	
		usuario = newUsuario;
	}
	*/
	public static  void setParentFrame(  JFrame newParentFrame ) {	
		parentFrame = newParentFrame;
	}
	
	public static JFrame getparentFrame() {	
		return parentFrame;
	}
	

		/**
	 * Gets the application's preferences.
	 * The {@link Preferences} object manages per-user preferences and settings for a particular application.
	 * @return	the <code>Preferences</code> object
	 */
	/*public static Preferences getPreferences() {
		return preferences;
	}
	*/
	public abstract String getName();
	
		
	/**
	 * Creates a new document and makes its view (window) visible.
	 */
/*	public void newDocument() {
		Document doc = Document.createNew();
		documents.add(doc);
	}
	
*/	
	/**
	 * Displays a "Open File"-Dialog and tries to open the selected file.
	 * Displays an error message in case of an error.
	 */
	/*public void openDocument() {
		FileFormat formats[] = fileIOManager.getSupportedFormats(FileIOManager.OPEN);
		String filename = mainWindow.showFileOpenDialog(formats);
		if (filename == null || filename.equals("")) return;
		openDocument(filename);
	}
	
	/**
	 * Tries to open the given file.
	 * Displays an error message in case of an error.
	 * @param filename	the file to be opened
	 */
	/*public void openDocument(String filename) {
		for (int i=0; i<documents.size(); i++) {
			Document d = (Document)documents.get(i);
			if (d.getFilename().equals(filename)){
				try {
					selectWindow(d.getView(0).getWindow());
				} catch (RuntimeException ignored) {}
				return;
			}
		}
		setStatus(tr("Loading..."));
		try {			
			Document doc = Document.open(filename);			
			documents.add(doc);
			recentFiles.add(filename);
		} catch (FileIOException e) {
			mainWindow.showMessage(MainWindow.ERROR, null, 
				e.getLocalizedMessage());
			recentFiles.remove(filename);
		}
		setStatus(tr("Ready"));
	}*/
	
	/*public static void setStatus(String status) {
		mainWindow.setStatus(status);
	}
*/

}
/*
public class Adqal extends Application {

	public String getName() { return "Sistema ADQAL"; }
	
	public static void main(String args[]) {
		Adqal  adqal = new adqal();		
		adqal.run(args);
	}


}
	
	
/*
public class AdqalMainWindow extends SwingMainWindow {
		
	ActionMonitor actionMonitor = new ActionMonitor();
	
	public AdqalMainWindow() {
		super();
		constructMenu();				
	}
	
	protected void constructMenu() {
		JMenuItem m;
}	*/