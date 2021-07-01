 
package controller;

import application.Floor;
import model.SuperFloor;

/**
 * Testklasse zum überprüfen der grundlegenden Funktionalität von Flat und Floor
 * 
 * @author Johannes Keller
 * @version 1.0
 */
public class Controller {
	
	/**
	 * Main-Methode
	 */	
	public static void main (String[] args) {
		SuperFloor gr = new Floor("Groundlevel", 250.00);
		gr.createFlat("Tim Blocksberg", 110.50, 5);
		gr.createFlat("Regina Brodthardt", 60, 3);
		gr.createFlat("Miriam Maispflod", 29.50, 2);
		gr.createFlat("Banjomin Ruffler", 29.50, 2);
		gr.floorOutline();	
		System.out.println(Integer.valueOf(121).hashCode());
		System.out.println(Integer.valueOf(5).hashCode());
		System.out.println(Integer.valueOf(5).hashCode());
		
	}
	

}
