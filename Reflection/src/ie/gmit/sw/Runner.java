package ie.gmit.sw;

import java.io.*;

/**
 * @author Sean Fitzpatrick
 *
 */
public class Runner {
	
	
	public static void main(String[] args) throws IOException {	
		//swing-sample runner
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new AppWindow();
			}
		});
					
	}
}
