package model;

/**
 * Klasse zum Anlegen eines Flat-Objekts, das eine ID, einen Flächeninhalt, 
 * einen User und eine Anzahl an Zimmern als Attribute besitzt
 * 
 * @author Johannes Keller
 * @version 1.0
 */
public class Flat extends SuperFlat {
	
	/**
	 * Kontruktor für neues Flat-Objekt mit Übergabeparametern
	 * @param user
	 * @param area
	 * @param numberRooms
	 * 
	 */
	public Flat(String user, double area, int numberRooms){
		setIdCounter(idCounter + 1);
		this.id = idCounter;
		this.setArea(area);
		this.setUser(user);
		this.setNumberRooms(numberRooms);	
	}
}
