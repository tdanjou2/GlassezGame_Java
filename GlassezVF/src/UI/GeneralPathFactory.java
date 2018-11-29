package UI;

import java.awt.geom.GeneralPath;

import Logique.Element;
import Logique.Orientation;


public class GeneralPathFactory {

	public GeneralPath generatePath(Element e, int offsetX, int offsetY) {

		return generatePath(e.getOrientation(), offsetX, offsetY);
	}
	
	public GeneralPath generatePath(Orientation o, int offsetX, int offsetY) {
		
 		double[] xCoords = o.getxCoords();
 		double[] yCoords = o.getyCoords();

		GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xCoords.length);
		polygon.moveTo(xCoords[0] + offsetX, yCoords[0] + offsetY);

		for (int index = 0; index < xCoords.length; index++) {
		        polygon.lineTo(xCoords[index] + offsetX, yCoords[index] + offsetY );
		};

		polygon.closePath();
		return polygon;
	}
	
	// On appelle OffsetX et OffsetY les valeurs par lesquels il faut décaler suivant l'axe des 
	// Abscisses et des ordonées une pièce A qui n'est pas la pièce A initialement représentée avec la classe ElmtPos
	// Respectivement pour une pièce B, C, D, E, F
	
	public int getXoffset(Orientation o) {
		return (int) (2 * o.getr());
	}

	public int getYoffset(Orientation o) {
		return (int) (Math.sqrt(o.getR()*o.getR() - o.getr()*o.getr() ) + o.getR());
	}
}
