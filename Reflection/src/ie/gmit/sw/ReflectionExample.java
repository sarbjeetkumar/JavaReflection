package ie.gmit.sw;

import java.lang.reflect.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Sean Fitzpatrick
 *
 */

public class ReflectionExample {
   
   
   private Class<?> c;
   //private int afferent = 0;
   //private int efferent = 0;
   private List<Object> classList;
    
   /*
   public static void main(String args[]){
        if (args.length == 0) {
            System.out.println("Please specify a class name.");
            System.exit(1);
        }
        try {
            Class queryClass = Class.forName(args[0]);
            new ReflectionExample(queryClass);
        } catch (ClassNotFoundException ee) {
            System.out.println("Couldn't find class '"+ args[0] + "'");
            System.exit(1);
        }
   }*/
   

   public ReflectionExample(@SuppressWarnings("rawtypes") Class c){
      super();
      this.c = c;
      
     classList = new LinkedList<Object>();
     
      
      System.out.println("aClass.getName() = " + c.getName());
      
      //printInterfaces();
      printConstructors();
      printFields();
      printMethods();
      getInterface(c);
      createArray();
   }
   

	/**
	 * Methods to get interfaces
	 */
   @SuppressWarnings("rawtypes")
   public void printInterfaces(){
	      
	   
	   Class interfaces[] = c.getInterfaces();
	   System.out.println("--------------" + interfaces.length + " Interfaces --------------");
	      for (int i = 0; i < interfaces.length; i++) {  
	         
			Class inter = interfaces[i];
	         
	         System.out.println("\tname = " + inter.getName());
	         int mod = inter.getModifiers();
	         System.out.println("\tmodifiers = " + Modifier.toString(mod));
	         System.out.println("-----");

	      }
	   }
   
   public ClassList getInterface(Class<?> cls) 
	{
	   
	   ClassList classList = new ClassList();
		
		Class<?> inter[] = cls.getInterfaces();
		
		for(Class<?> c : inter)
		{
			classList.add(c);
			System.out.println(c);
		}
		
		return classList;	
	}
   
   @SuppressWarnings("rawtypes")
   public Object[] printConstructors(){
      
	Constructor ctorlist[] = c.getDeclaredConstructors();
      System.out.println("--------------" + ctorlist.length + " Constructors --------------");
      for (int i = 0; i < ctorlist.length; i++) {
        
		Constructor ct = ctorlist[i];
         System.out.println("\tname  = " + ct.getName());
         System.out.println("\tdecl class = " + ct.getDeclaringClass());

         
		Class pvec[] = ct.getParameterTypes();
         for (int j = 0; j < pvec.length; j++){
            System.out.println("\tparam #" + j + " " + pvec[j]);
         }

         
		Class evec[] = ct.getExceptionTypes();
         for (int j = 0; j < evec.length; j++){
            System.out.println("\texc #" + j + " " + evec[j]);
         }
         System.out.println("\t-----");
      }
	return ctorlist;
   }

   public Object[] printFields(){
      Field fieldlist[] = c.getDeclaredFields();
      for (int i = 0; i < fieldlist.length; i++) {
         Field fld = fieldlist[i];
         System.out.println("\tname = " + fld.getName());
         System.out.println("\tdecl class = " + fld.getDeclaringClass());
         System.out.println("\ttype = " + fld.getType());
         int mod = fld.getModifiers();
         System.out.println("\tmodifiers = " + Modifier.toString(mod));
         System.out.println("-----");
      }
	return fieldlist;
   }
   
   @SuppressWarnings("rawtypes")
   public Object[] printMethods(){
      Method methlist[] = c.getDeclaredMethods();
      System.out.println("--------------" + methlist.length + " Methods --------------");
      for (int i = 0; i < methlist.length;i++) {
      	Method m = methlist[i];
      	System.out.println("\tname = " + m.getName());
      	System.out.println("\tdecl class = " + m.getDeclaringClass());
      	
		Class pvec[] = m.getParameterTypes();
      	for (int j = 0; j < pvec.length; j++){
         		System.out.println("\tparam #" + j + " " + pvec[j]);
    	}
      	
		Class evec[] = m.getExceptionTypes();
      	for (int j = 0; j < evec.length; j++){
         		System.out.println("\texc #" + j + " " + evec[j]);
      	}
      	System.out.println("\treturn type = " + m.getReturnType());
      	System.out.println("\t-----");
      }
	return methlist;
   }
   
   @SuppressWarnings("rawtypes")
   public void createArray(){
	      try {
			Class cls = Class.forName("java.lang.String");
	         Object arr = Array.newInstance(cls, 10);
	         Array.set(arr, 5, "Msc OO");
	         String s = (String)Array.get(arr, 5);
	         System.out.println(s);
	      }catch (Throwable e) {
	         System.err.println(e);
	      }
	   }
}
