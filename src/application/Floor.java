package application;

import java.util.ArrayList;

import model.SuperFloor;

/**
 * Klasse zum Anlegen eines Floor-Objekts, das verschiede Flat-Objekte in 
 * einer ArrayList speichern kann.
 * 
 * @author Johannes Keller
 * @version 1.0
 */
public class Floor extends SuperFloor {
	/**
	 * Kontruktor für neuen Floor mit übergebener Fläche
	 */
	public Floor(String floor, double area){
		this.floor = floor;
		this.area = area;
		this.circulation = area * 0.2;
		this.useableArea = area - circulation;
		flatList = new ArrayList<>();
	}
}
