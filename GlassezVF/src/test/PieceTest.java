package test;

import Logique.Board;
import Logique.Element;
import Logique.Piece;
import Logique.Orientation;
import Logique.PatternType;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//public class PieceTest {
//	@Test
//	void testSimpleMatch() {
//		Board b = new Board();
//		Piece p = new Piece(2, 2, PatternType.ALL_ENABLED);
//		
//		Element[][] initialMatrix = p.getAllElements();
//
//		assertEquals(Orientation.A, initialMatrix[0][0].getOrientation());
//		assertEquals(Orientation.F, initialMatrix[0][1].getOrientation());
//
//		assertEquals(Orientation.B, initialMatrix[1][0].getOrientation());
//		assertEquals(Orientation.E, initialMatrix[1][1].getOrientation());
//
//		p.rotate();
//
//		Element[][] rotatedMatrix = p.getAllElements();
//		assertEquals(Orientation.B, rotatedMatrix[0][0].getOrientation());
//		assertEquals(Orientation.A, rotatedMatrix[0][1].getOrientation());
//
//		assertEquals(Orientation.E, rotatedMatrix[1][0].getOrientation());
//		assertEquals(Orientation.F, rotatedMatrix[1][1].getOrientation());
//	}
//}