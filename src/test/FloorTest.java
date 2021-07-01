package test;

import static org.mockito.Mockito.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.Floor;
import model.Flat;

/**
 * Aufgabe 1) Klasse zum Testen mit JUnit der Klassen Floor und Flat. Aufgabe 2) 
 * siehe testCheckAreaException() und testCheckNumberRoomsException() und Aufgabe 4) 
 * siehe testGetRestArea()
 * 
 * @author Johannes Keller
 * @version 1.0
 */
class FloorTest {
	
	Floor floor;
	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	
	@BeforeEach
	void setUp() throws Exception {
		floor = new Floor("Groundlevel", 250.00);
	}
	
	@AfterEach
	 public void cleanUpEach(){
		Flat.setIdCounter(0);
	}
	

	@Test
	void testCreateFlat() {
		assertEquals(floor.createFlat("Regina Reginae", 110.50, 5),true);
		assertEquals(floor.createFlat("Miriam Maispflod", 29.50, 2),true);
		assertEquals(floor.createFlat("Roger Ramsfeld", 250, 8),false);
	}
	
	@Test
	void testDeleteFlat() {
		floor.createFlat("Tim Blocksberg", 90, 5);
		assertEquals(floor.deleteFlat(2),false);
		assertEquals(floor.deleteFlat(1),true);
		assertEquals(floor.deleteFlat(1),false);
		assertEquals(floor.deleteFlat(7),false);
	}
	
	@Test
	void testCheckArea() {
		Flat f1 = new Flat("Roger Ramsfeld", 290, 8);
		Flat f2 = new Flat("Harry Tölke", 100, 4);
		assertEquals(floor.checkArea(f1),false);
		assertEquals(floor.checkArea(f2),true);
	}
	/** Aufgabe 2)
	 */		
	@Test
	void testCheckAreaException() {	
		Flat f1 = new Flat("Roger Ramsfeld", -290, 8);
		assertThrows(IllegalArgumentException.class,()->{floor.checkArea(f1);});
	}
	
	@Test
	void testCheckNumberRooms() {
		Flat f1 = new Flat("Roger Ramsfeld", 56, 8);
		Flat f2 = new Flat("Harry Tölke", 100, 4);
		assertEquals(floor.checkNumberRooms(f1),false);
		assertEquals(floor.checkNumberRooms(f2),true);
	}
	/** Aufgabe 2)
	 */	
	@Test
	void testCheckNumberRoomsException() {
		Flat f1 = new Flat("Roger Ramsfeld", 290, 0);
		assertThrows(IllegalArgumentException.class,()->{floor.checkNumberRooms(f1);});
	}
	/** Aufgabe 4)
	 */
	@Test
	void testGetRestArea() {
		floor.createFlat("Tim Blocksberg", 90, 5);
		Flat f = mock(Flat.class);
		when(f.getArea()).thenReturn(40.00);
		floor.addFlat(f);
		assertEquals(70, floor.getRestArea(),0);
	}
	
	@Test
	void testGetUseableArea() {
		assertEquals(200, floor.getUseableArea(),0);
	}
	
	@Test
	void testFloorOutline() {
		floor.createFlat("Miriam Maispflod", 29.50, 2);
		System.setOut(new PrintStream(output));
		floor.floorOutline();
		assertEquals("Floor : Groundlevel\n"
				+ "Total area: 250.0m²\n"
				+ "Circulation area: 50.0m²\n"
				+ "Useable area: 200.0m²\n"
				+ "Area left: 170.5m²\n"
				+ "--------------------------------\n"
				+ "Flat ID: 1\n"
				+ "Owner: Miriam Maispflod\n"
				+ "Size: 29.5 m²\n"
				+ "Number of rooms: 2\n"
				+ "--------------------------------", output.toString().trim());
	}

}
