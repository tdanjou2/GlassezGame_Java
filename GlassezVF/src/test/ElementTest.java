package test;

import Logique.Element;
import Logique.Color;
import Logique.Display;
import Logique.Orientation;
import Logique.Status;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElementTest {

	@Test
	void testDefaultConstructor() {
		Element e = new Element();
		assertEquals(Color.UNDEFINED, e.getColor());
		assertEquals(Display.UNVISIBLE, e.getDisplay());
		assertEquals(Orientation.A, e.getOrientation());
		assertEquals(Status.UNMATCHED, e.getStatus());
	}

	@Test
	void testGetterAndSetter() {
		Element e = new Element();

		e.setColor(Color.RED);
		assertEquals(Color.RED, e.getColor());

		e.setDisplay(Display.VISIBLE);
		assertEquals(Display.VISIBLE, e.getDisplay());

		e.setOrientation(Orientation.F);
		assertEquals(Orientation.F, e.getOrientation());

		e.setStatus(Status.MATCHED);
		assertEquals(Status.MATCHED, e.getStatus());
	}
}