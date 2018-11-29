package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLayeredPane;

import Logique.Board;
import Logique.Element;
import Logique.Matcher;
import Logique.Piece;
import Logique.Display;
import Logique.PatternType;
import Logique.Status;
import UI.ColorConverter;
import UI.ElementWithCoordinates;
import UI.Indexes;

public class PieceLayeredPane extends JLayeredPane implements MouseMotionListener, MouseListener {

	private static final int LAYERED_PANE_HEIGHT_IN_PIXELS = 900;
	private static final int LAYERED_PANE_WIDTH_IN_PIXELS = 900;
	
	private PieceController pieceController;
	private ColorConverter colorConverter = new ColorConverter();
	private GeneralPath[][] allPieceGeneralPaths;
	private BoardPanel boardPanel;
	private Matcher matcher = new Matcher();
	
	private static final int NB_PIECES = 10;
	private Piece[] pieces = new Piece[NB_PIECES];
	private int currentPieceIndex = 0;

	
	public PieceLayeredPane(BoardPanel boardPanel) {
		
		initPieces();
		this.boardPanel = boardPanel;
		pieceController = new PieceController(pieces[0]);		
		allPieceGeneralPaths = pieceController.getAllGeneralPaths();
		
		this.setPreferredSize (new Dimension(LAYERED_PANE_WIDTH_IN_PIXELS, LAYERED_PANE_HEIGHT_IN_PIXELS));
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	private void initPieces() {
		
		pieces[0] = new Piece(4, 4, PatternType.ELEMENT_A_ONLY);
		pieces[1] = new Piece(2, 2, PatternType.ELEMENT_B_ONLY);
		pieces[2] = new Piece(4, 4, PatternType.ELEMENT_C_ONLY);
		pieces[3] = new Piece(4, 4, PatternType.ELEMENT_D_ONLY);
		pieces[4] = new Piece(4, 4, PatternType.ELEMENT_E_ONLY);
		pieces[5] = new Piece(4, 4, PatternType.ELEMENT_F_ONLY);
		pieces[6] = new Piece(4, 4, PatternType.FIRST_ROW_VISIBLE_ONLY);
		pieces[7] = new Piece(4, 4, PatternType.FIRST_TWO_ROWS_ENABLED);
		pieces[8] = new Piece(4, 4, PatternType.PATTERN_PIECES_BLACK);
		pieces[9] = new Piece(6, 6, PatternType.PATTERN_PIECES_BLACK);

	}
	
	public void nextPiece() {
	    currentPieceIndex++;
		currentPieceIndex = currentPieceIndex < NB_PIECES ? currentPieceIndex : 0;	
		
		changePiece(pieces[currentPieceIndex]);
	    System.out.println("Selecting piece:" + currentPieceIndex);
	}	

	public Piece getCurrentPiece() {
		return pieces[currentPieceIndex];
	}
	
	public void changePiece(Piece p) {
		if (p != null) {
			pieceController = new PieceController(p);		
			allPieceGeneralPaths = pieceController.getAllGeneralPaths();
			repaint();
		}
	}
	
	public void rotate() {
		Piece piece = pieceController.getPiece();
		piece.rotate();
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		Piece piece = pieceController.getPiece();
		for (int x = 0; x < piece.getWidth(); x++) {
			for (int y = 0; y < piece.getHeight() ;y++) {
				
				// Dessine l'élément avec sa couleur
				Element e = piece.getElement(x, y);
				if (e.getDisplay().equals(Display.VISIBLE)) {
					Color awtColor = colorConverter.getColor(e);
					g2.setPaint(awtColor);
					g2.fill(allPieceGeneralPaths[x][y]);
					
					// Dessine le contour
					g2.setColor(Color.BLACK);
					g2.draw(allPieceGeneralPaths[x][y]);					
				}
			}
		}
	}

	int getPieceCenterX() {
		Piece piece = pieceController.getPiece();
		double minX = allPieceGeneralPaths[0][0].getBounds2D().getMinX();
		double maxX = allPieceGeneralPaths[piece.getWidth()-1][piece.getHeight()-1].getBounds2D().getMaxX();
		return (int) (((maxX - minX) / 2) + minX);
	}

	int getPieceCenterY() {
		Piece piece = pieceController.getPiece();
		double minY = allPieceGeneralPaths[0][0].getBounds2D().getMinY();
		double maxY = allPieceGeneralPaths[piece.getWidth()-1][piece.getHeight()-1].getBounds2D().getMaxY();
		return (int) (((maxY - minY) / 2) + minY);
	}

	// Utilisation de l'interface MouseListener
	@Override
	public void mouseDragged(MouseEvent e) {
		
		Piece piece = pieceController.getPiece();
		int mouseX = e.getX();
		int mouseY = e.getY();

		if (isMouseDraggedOverAPiece(mouseX, mouseY)) {
			int centerX = getPieceCenterX();
			int centerY = getPieceCenterY();
			int deltaX = mouseX - centerX;
			int deltaY = mouseY - centerY;
			AffineTransform at = AffineTransform.getTranslateInstance(deltaX, deltaY);
			for (int x = 0; x < piece.getWidth(); x++) {
				for (int y = 0; y < piece.getHeight() ;y++) {
					allPieceGeneralPaths[x][y].transform(at);
				}
			}
			repaint();
		}
	}
	
	// On test si notre souris est au dessus de la pièce
	// On rappelle qu'une pièce est un ensemble de GeneralPaths
	
	private boolean isMouseDraggedOverAPiece(int mouseX, int mouseY) {
		Piece piece = pieceController.getPiece();
		for (int x = 0; x < piece.getWidth(); x++) {
			for (int y = 0; y < piece.getHeight() ;y++) {
				if (allPieceGeneralPaths[x][y].contains(mouseX, mouseY)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// On actualise la valeur de isMatch() à chaque fois qu'on clique sur la souris
		
		boolean isMatch = true;
		List<Indexes> allIndexes = new ArrayList<Indexes>();
		Piece piece = pieceController.getPiece();

		int pixelX = e.getX();
		int pixelY = e.getY();
		
        System.out.println("Souris en : x:" + pixelX  + " y:" + pixelY);	
        
        Board board = boardPanel.getBoard();
        BoardController boardController = boardPanel.getController();

		Logique.Color boardElementReferenceColor = Logique.Color.UNDEFINED;

		List<ElementWithCoordinates> ewcs = pieceController.getListOfPixelsCoordinatesForTheCenterOfAllElements();
        for(ElementWithCoordinates ewc: ewcs) {
        	
        		Indexes indexes = boardController.getIndexesForPixelCoordinates((int)ewc.getP().getX(), (int)ewc.getP().getY());
        		// null Si l'élément de la pièce qu'on vient de sélectionner à un pixel (qu'on obtient avec un getPixelCoordinatesForCenterOfElement() )
        		// Qui n'est pas présent dans le board
        		if(indexes == null) {
        			isMatch = false;
        			break; // On quitte toute la boucle for car il n'y a plus d'intérêt
        		}
        		
        		// On garde en mémoire les indices des éléments pour éventuellement changer leur statut par la suite
        		allIndexes.add(indexes);
        		
        		boolean result = matcher.isMatch(board, ewc.getE(), indexes.getX(), indexes.getY(), boardElementReferenceColor);
        		if (result == true) {
        			//System.out.println("Element du board d'indice {" + indexes.getX() + "," + indexes.getY() + "}"
        					//+ " de Pixel {" + (int)ewc.getP().getX() + "," + (int)ewc.getP().getY() + "}"
        					//+ board.getElement(indexes.getX(), indexes.getY()) +" match avec " + ewc.getE());

        			// Nécessité de sauvegarder la couleur du premier Element matché sur le Board
        			boardElementReferenceColor = board.getElement(indexes.getX(), indexes.getY()).getColor();
        		} else {
        			//System.out.println("Element du board d'indice {" + indexes.getX() + "," + indexes.getY() + "}"
        					//+ " de Pixel {" + (int)ewc.getP().getX() + "," + (int)ewc.getP().getY() + "}"
        					//+ board.getElement(indexes.getX(), indexes.getY()) +" ne match pas avec " + ewc.getE());
        			isMatch = false;
        			break; 
        		}
        }
        
        if (isMatch) {
	        boardPanel.getController().getScore().increaseScore(pieceController.getPiece());

	        // On change le statut de tous les Elements du board avec les Index stockés
			for (Indexes index: allIndexes) {
				boardPanel.getBoard().getElement(index.getX(), index.getY()).setStatus(Status.MATCHED);
			}
	
			// change de pièce 
			nextPiece();
			
			// On vérifie si tous les éléments du board ont été matchés 
			if (board.areAllElementsMatched()) {
				System.out.println("	Victoire ! ");            	
			}
        }
        
		repaint();
	}
	
	
	// Interface MouseMotionListener qu'il faut implémenter
	@Override
	public void mouseMoved(MouseEvent e) {
		// Rien
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// Rien
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// Rien
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Rien
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Rien
	}

}