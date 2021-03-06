package preprocessing;

import java.util.ArrayList;

public class ClassPacket {
	
	public String className;
	public String packageName;
	public int lineCount;
	public ArrayList<String> associatedWith;
	public ArrayList<String> staticAccess;
	public ArrayList<String> instantiated;
	public ArrayList<String> assigned;
	
	
	public ClassPacket(String name, String pName, int count){
		className = name;
		packageName = pName;
		lineCount = count;
		associatedWith = new ArrayList<String>();
		staticAccess = new ArrayList<String>();
		instantiated = new ArrayList<String>();
		assigned = new ArrayList<String>();
	}
	/**
	 * @param newClass
	 *void
	 */
	public void addToAssociatedWith(String newClass){
		if (!associatedWith.contains(newClass))
			associatedWith.add(newClass);
	}
	/**
	 * add newClass to list of all the statically accessed classes 
	 * @param newClass
	 *void
	 */
	public void addToStaticAccess(String newClass){
		if(!staticAccess.contains(newClass))
			staticAccess.add(newClass);
	}
	
	/**
	 * add newClass list of classes instantiated
	 * @param newClass
	 *void
	 */
	public void addToInstantiated(String newClass){
		if(!instantiated.contains(newClass))
			instantiated.add(newClass);
	}
	
	/**
	 * @param newClass Class added to assigned list
	 * @return void
	 */
	public void addToAssigned(String newClass) {
		if(!assigned.contains(newClass))
			assigned.add(newClass);		
	}
}
