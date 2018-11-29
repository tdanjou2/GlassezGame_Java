package Logique;

import Logique.Orientation;

public class Element {

	private Color color;
	private Display display;
	private Orientation orientation;
	private Status status;

	public Element(Color color, Display display, Orientation orientation, Status status) {
		this.color = color;
		this.display = display;
		this.orientation = orientation;
		this.status = status;
	}

	public Element() {
		this(Color.UNDEFINED, Display.UNVISIBLE, Orientation.A, Status.UNMATCHED);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	// On redefinit la méthode toString() initialement présente en Java
	@Override
	public String toString() {
		return "Element [color=" + color + ", display=" + display + ", orientation=" + orientation + ", status="
				+ status + "]";
	}
}