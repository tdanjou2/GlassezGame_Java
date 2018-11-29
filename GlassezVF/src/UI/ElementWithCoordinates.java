package UI;

import java.awt.Point;

import Logique.Element;

// On appelerai Point (par la suite) un couple de coordonnées X et Y d'un Pixel !


public class ElementWithCoordinates{
	private Element e;
	private Point p;
	public ElementWithCoordinates(Element e, Point p) {
		this.e = e;
		this.p = p;
	}
	public Element getE() {
		return e;
	}
	public Point getP() {
		return p;
	}
}