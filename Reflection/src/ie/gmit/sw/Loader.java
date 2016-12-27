package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.io.*;

/*
 * Class loader for loading in .jar files from directory.
 */
public class Loader {
	
	/*
	 *getJarContents method for loading .jar file class names into a list 
	 */
	
	public List<String> getJarContents(String jarName){
		
		//Create List
		List<String> classeList = new ArrayList<String>();
		
		try {
			@SuppressWarnings("resource")
			//Create JarInputStream for .jar file
			JarInputStream in = new JarInputStream(new FileInputStream(jarName));
			JarEntry next = in.getNextJarEntry();//Assign JarEntry to next
 
			//while next is not null
			while (next != null) {
				next = in.getNextJarEntry();//Read in JarEntry
				
				//if next is null break
				if (next == null) {
					break;
				}
				//if class name ends with .class
				if ((next.getName().endsWith(".class"))) {
					
					String name = next.getName().replaceAll("/", "\\.");
					name = name.replaceAll(".class", "");//replace .class with empty string
					if (!name.contains("$")) name.substring(0, name.length() -".class".length());
					System.out.println(name);//Print class name
					classeList.add(name);//Add class name to List
				}
			}
			
			next = in.getNextJarEntry();

		} catch (IOException e) {
			//Print exception
			System.out.println("Issue while parsing jar" + e.toString());
		}
		
		return classeList;//return List
		
	}
}
