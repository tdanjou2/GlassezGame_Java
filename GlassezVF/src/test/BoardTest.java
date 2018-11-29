package test;

import Logique.Board;
import Logique.Orientation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

	@Test
	void test1() {
		Board b = new Board();

		// Vérifie les Orientations de la première ligne
		assertEquals(Orientation.A, b.getElement(0, 0).getOrientation());
		assertEquals(Orientation.B, b.getElement(1, 0).getOrientation());
		assertEquals(Orientation.C, b.getElement(2, 0).getOrientation());
		assertEquals(Orientation.A, b.getElement(3, 0).getOrientation());
		assertEquals(Orientation.B, b.getElement(4, 0).getOrientation());
		assertEquals(Orientation.C, b.getElement(5, 0).getOrientation());
		assertEquals(Orientation.A, b.getElement(6, 0).getOrientation());
		assertEquals(Orientation.B, b.getElement(7, 0).getOrientation());
		assertEquals(Orientation.C, b.getElement(8, 0).getOrientation());
		assertEquals(Orientation.A, b.getElement(9, 0).getOrientation());

		// Vérifie les Orientations de la deuxième ligne
		assertEquals(Orientation.F, b.getElement(0, 1).getOrientation());
		assertEquals(Orientation.E, b.getElement(1, 1).getOrientation());
		assertEquals(Orientation.D, b.getElement(2, 1).getOrientation());
		assertEquals(Orientation.F, b.getElement(3, 1).getOrientation());
		assertEquals(Orientation.E, b.getElement(4, 1).getOrientation());
		assertEquals(Orientation.D, b.getElement(5, 1).getOrientation());
		assertEquals(Orientation.F, b.getElement(6, 1).getOrientation());
		assertEquals(Orientation.E, b.getElement(7, 1).getOrientation());
		assertEquals(Orientation.D, b.getElement(8, 1).getOrientation());
		assertEquals(Orientation.F, b.getElement(9, 1).getOrientation());

		// Vérifie les Orientations de la troisièmes ligne
		assertEquals(Orientation.B, b.getElement(0, 2).getOrientation());
		assertEquals(Orientation.C, b.getElement(1, 2).getOrientation());
		assertEquals(Orientation.A, b.getElement(2, 2).getOrientation());
		assertEquals(Orientation.B, b.getElement(3, 2).getOrientation());
		assertEquals(Orientation.C, b.getElement(4, 2).getOrientation());
		assertEquals(Orientation.A, b.getElement(5, 2).getOrientation());
		assertEquals(Orientation.B, b.getElement(6, 2).getOrientation());
		assertEquals(Orientation.C, b.getElement(7, 2).getOrientation());
		assertEquals(Orientation.A, b.getElement(8, 2).getOrientation());
		assertEquals(Orientation.B, b.getElement(9, 2).getOrientation());

		// Vérifie les Orientations de la quatrième ligne
		assertEquals(Orientation.E, b.getElement(0, 3).getOrientation());
		assertEquals(Orientation.D, b.getElement(1, 3).getOrientation());
		assertEquals(Orientation.F, b.getElement(2, 3).getOrientation());
		assertEquals(Orientation.E, b.getElement(3, 3).getOrientation());
		assertEquals(Orientation.D, b.getElement(4, 3).getOrientation());
		assertEquals(Orientation.F, b.getElement(5, 3).getOrientation());
		assertEquals(Orientation.E, b.getElement(6, 3).getOrientation());
		assertEquals(Orientation.D, b.getElement(7, 3).getOrientation());
		assertEquals(Orientation.F, b.getElement(8, 3).getOrientation());
		assertEquals(Orientation.E, b.getElement(9, 3).getOrientation());
	}
}