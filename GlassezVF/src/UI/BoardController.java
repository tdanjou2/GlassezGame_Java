package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;

import Logique.Calculus;
import UI.CalculusForUI;
import Logique.Board;
import Logique.Element;
import Logique.Score;
import UI.ColorConverter;
import UI.GeneralPathFactory;
import UI.Indexes;

public class BoardController {
	
	public CalculusForUI calcUI = new CalculusForUI();
	public Calculus calc = new Calculus ();
	private GeneralPathFactory generalPathFactory = new GeneralPathFactory();
	private ColorConverter colorConverter = new ColorConverter();
	private Score score = new Score();

	private GeneralPath[][] generalPathCache = new GeneralPath[Board.DEFAULT_MATRIX_WIDTH][Board.DEFAULT_MATRIX_HEIGHT];

	private Graphics2D g2;
	private Board board;
	
	public BoardController(Board board) {
		this.board = board;
	}
	
	public void draw(Graphics g) {
        g2 = (Graphics2D) g;
        for (int x = 0 ; x < board.getWidth() ; x++) {
            for (int y = 0 ; y < board.getHeight() ; y++) {
            		Element e = board.getElement(x, y);

            		drawPolygon(g2, 
            				e,
            				x,
            				y,
            				(generalPathFactory.getXoffset(e.getOrientation())) * (int)(x/3) + calcUI.getXShiftValue(x, y), 
            				(generalPathFactory.getYoffset(e.getOrientation())) * (int)(y/2));
            }
        }    
        
        // Position de l'affichage du score
        g.drawString("Score: " + score.getScoreValue(), 500, 250);
	}
	
	public void drawPolygon(Graphics2D g2, Element e, int x, int y, int offsetX, int offsetY) {

		GeneralPath gp = generalPathFactory.generatePath(e.getOrientation(), offsetX, offsetY);
		generalPathCache[x][y] = gp;
	
		// Remplissage avec la Color
		g2.setPaint(colorConverter.getColor(e));
		g2.fill(gp);
		
		// Les bordures
		g2.setColor(Color.BLACK);
		g2.draw(gp);
	}

	//  Renvoie les indices dans la martrice de generalPathCache (les mêmes indices que dans le Board)
	// De l'élément qui est situé en (pixelX;pixeY)
	
	public Indexes getIndexesForPixelCoordinates(int pixelX, int pixelY) {
		for (int x =0; x < board.getWidth(); x ++) {
			for(int y = 0; y < board.getHeight(); y++) {
				if (generalPathCache[x][y].contains(pixelX, pixelY)) {
					return new Indexes(x,y);
				}
			}
		}
		return null;
	}
	
	public Score getScore() {
		return score;
	}
}