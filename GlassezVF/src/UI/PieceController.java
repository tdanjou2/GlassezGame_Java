package UI;

import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import Logique.Element;
import Logique.Piece;
import Logique.Calculus;
import UI.CalculusForUI;
import Logique.Display;
import UI.ElementWithCoordinates;
import UI.GeneralPathFactory;

public class PieceController {
	
	public Calculus calc = new Calculus ();
	public CalculusForUI calcUI = new CalculusForUI();
	private static final int PIECE_INITIAL_POSITION_Y = 180;
	private static final int PIECE_INITIAL_POSITION_X = 500;
	private GeneralPath[][] allGeneralPaths; 
	private Piece piece;
	private GeneralPathFactory pf = new GeneralPathFactory();
	
	public PieceController(Piece piece) {
		this.piece = piece;
		this.allGeneralPaths = new GeneralPath[piece.getWidth()][piece.getHeight()];
		generateArrayOfGeneralPathsForPiece(piece);
	}
	
	private void generateArrayOfGeneralPathsForPiece(Piece p) {
		int width = p.getWidth();
		int height = p.getHeight();
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				Element e = p.getElement(x, y);
				allGeneralPaths[x][y] = (pf.generatePath(
						e, 
						PIECE_INITIAL_POSITION_X + (int) (x/3) * calcUI.getXOffset(x,y,p) + calcUI.getXShiftValue(x,y,p),
						PIECE_INITIAL_POSITION_Y + (int)(y/2) * calcUI.getYOffset(x,y,p)));
			}
		}
	}

	protected GeneralPath[][] getAllGeneralPaths(){
		return allGeneralPaths;
	}
	
	protected Piece getPiece() {
		return piece;
	}
	
	
	// Renvoie une list qui contient des ElementWithCoordinates
	// on rappelle que des ElementWithCoordinates sont des objets qui contiennent
	// 1 Element et son couple de Point associé
	// C'est à dire son couple de Pixel associé
	
	public List<ElementWithCoordinates> getListOfPixelsCoordinatesForTheCenterOfAllElements(){
		List<ElementWithCoordinates> allEwc = new ArrayList<ElementWithCoordinates>();
		for(int x = 0; x < piece.getWidth(); x++) {
			for (int y = 0 ; y < piece.getHeight(); y++) {
				Element e = piece.getElement(x, y);
				if (e.getDisplay().equals(Display.VISIBLE)) {
					Point p = getPixelCoordinatesForCenterOfElement(x,y);
					ElementWithCoordinates ewc = new ElementWithCoordinates(e, p);
					allEwc.add(ewc);
				}
			}
		}
		return allEwc;
	}
	
	// Le couple de pixel qui est à coup sur dans mon élément
	// Pour en être sûr, on prend le milieu du rectangle qui englobe l'élement
	// On rappelle que Point est un couple de pixel et Index est un couple d'indice dans une matrice
	
	public Point getPixelCoordinatesForCenterOfElement(int x, int y) {
		GeneralPath generalPath = allGeneralPaths[x][y];
		Rectangle2D rect2D = generalPath.getBounds2D();
		
		int centerX = (int)(rect2D.getMinX() + (rect2D.getWidth()/2));
		int centerY = (int)(rect2D.getMinY() + (rect2D.getHeight()/2));
		Point point = new Point(centerX, centerY);
		return point;
	}	
}