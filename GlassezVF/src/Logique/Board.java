package Logique;

import Logique.Orientation;
import java.util.Arrays;
import java.util.List;

public class Board {
	
	public Calculus calc = new Calculus ();
	public static final int DEFAULT_MATRIX_WIDTH = 40;
	public static final int DEFAULT_MATRIX_HEIGHT = 40;
	private int width;
	private int height;
	private Element[][] matrix = new Element[DEFAULT_MATRIX_WIDTH][DEFAULT_MATRIX_HEIGHT];
	
	// C'est le motif sur un Board
	// A , B , C
	// F , E , D
	// B , C , A
	// E , D , F
	
	List<Orientation> line1Pattern = Arrays.asList(Orientation.A, Orientation.B, Orientation.C);
	List<Orientation> line2Pattern = Arrays.asList(Orientation.F, Orientation.E, Orientation.D);
	List<Orientation> line3Pattern = Arrays.asList(Orientation.B, Orientation.C, Orientation.A);
	List<Orientation> line4Pattern = Arrays.asList(Orientation.E, Orientation.D, Orientation.F);
	List<List<Orientation>> allPatterns = Arrays.asList(line1Pattern, line2Pattern, line3Pattern, line4Pattern);

	public Board(int width, int height, PatternType patternType) {
		
		calc.adjustWidthAndHeight(width, height);

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				this.matrix[x][y] = createElement(x, y, patternType);
			}
		}
		this.width = width;
		this.height = height;
	}
	
	// Cette méthode permet d'ajuster la taille de notre matrice Board
	// Notre méthode "rotate()" utilisée dans la Class Piece fonctionne 
	// Mieux avec des matrices de taille paire
	

	public Board() {
		this(DEFAULT_MATRIX_WIDTH, DEFAULT_MATRIX_HEIGHT, PatternType.ALL_ENABLED);
	}

	private Element createElement(int x, int y, PatternType patternType) {
		switch (patternType) {
		case CHESS_PATTERN:
			return new Element(
					calc.isEvenNumber((x + y)) ? Color.BLUE : Color.YELLOW, 
					Display.VISIBLE,
					allPatterns.get(y % 4).get(x % 3), 
					Status.UNMATCHED);
		case ELEMENT_A_ONLY:
			return new Element(
					Color.BLACK, 
					(x==0) && (y == 0) ? Display.VISIBLE : Display.UNVISIBLE,
					allPatterns.get(y % 4).get(x % 3), 
					Status.UNMATCHED);
		case ELEMENT_B_ONLY:
			return new Element(
					Color.BLACK, 
					(x==1) && (y == 0) ? Display.VISIBLE : Display.UNVISIBLE,
					allPatterns.get(y % 4).get(x % 3), 
					Status.UNMATCHED);
		case ELEMENT_C_ONLY:
			return new Element(
					Color.BLACK, 
					(x==2) && (y == 0) ? Display.VISIBLE : Display.UNVISIBLE,
					allPatterns.get(y % 4).get(x % 3), 
					Status.UNMATCHED);
		case ELEMENT_D_ONLY:
			return new Element(
					Color.BLACK, 
					(x==2) && (y == 1) ? Display.VISIBLE : Display.UNVISIBLE,
					allPatterns.get(y % 4).get(x % 3), 
					Status.UNMATCHED);
		case ELEMENT_E_ONLY:
			return new Element(
					Color.BLACK, 
					(x==1) && (y == 1) ? Display.VISIBLE : Display.UNVISIBLE,
					allPatterns.get(y % 4).get(x % 3), 
					Status.UNMATCHED);
		case ELEMENT_F_ONLY:
			return new Element(
					Color.BLACK, 
					(x==0) && (y == 1) ? Display.VISIBLE : Display.UNVISIBLE,
					allPatterns.get(y % 4).get(x % 3), 
					Status.UNMATCHED);
			
		case FIRST_ROW_VISIBLE_ONLY:
			return new Element(
					Color.BLUE, 
					(y == 0) ? Display.VISIBLE : Display.UNVISIBLE,
					allPatterns.get(y % 4).get(x % 3), 
					Status.UNMATCHED);
		case FIRST_TWO_ROWS_ENABLED:
			return new Element(
					Color.BLUE, 
					(y == 0 || y==1) ? Display.VISIBLE : Display.UNVISIBLE,
					allPatterns.get(y % 4).get(x % 3), 
					Status.UNMATCHED);
		case HALF_RED_HALF_GREEN:
			return new Element(
					(y < (height/2)) ? Color.RED : Color.GREEN, 
					Display.VISIBLE,
					allPatterns.get(y % 4).get(x % 3), 
					Status.UNMATCHED);
		case RED_AND_GREEN_SQUARES:
			return new Element(
					(y < (height-2) && y > 2) && (x < (width-2) && x > 2 ) ? Color.RED : Color.GREEN, 
					Display.VISIBLE,
					allPatterns.get(y % 4).get(x % 3), 
					Status.UNMATCHED);
			
		case ALL_DISABLED:
			return new Element(
					Color.UNDEFINED, 
					Display.UNVISIBLE, 
					allPatterns.get(y % 4).get(x % 3), 
					Status.UNMATCHED);
			
		case PATTERN_PIECES_BLACK:
			return new Element(
					Color.BLACK, 
					Display.VISIBLE, 
					allPatterns.get(y % 4).get(x % 3), 
					Status.UNMATCHED);
			
		case ALL_ENABLED:
		default:
			return new Element(
					Color.BLUE, 
					Display.VISIBLE, 
					allPatterns.get(y % 4).get(x % 3), 
					Status.UNMATCHED);
		}
	}

	public void setElement(Element element, int x, int y) {

		if (x < 0 || x > width || y < 0 || y > height) {
			System.out.println("Attention : problème de dimensions");
			return;
		}

		this.matrix[x][y] = element;
	}

	public Element getElement(int x, int y) {

		if (x < 0 || x > width || y < 0 || y > height) {
			System.out.println("Attention : problème de dimensions");
			return new Element();
		}

		return this.matrix[x][y];
	}

	public Element[][] getAllElements() {
		return matrix;
	}

	protected void setAllElements(Element[][] newMatrix) {

		if (getWidth() != newMatrix.length) {
			System.out.println("Attention : problème de dimensions");
			return;
		}
		for (int i = 0; i < width; i++) {
			if (newMatrix[i].length != width) {
				System.out.println("Attention : problème de dimensions");
				return;
			}
		}
		matrix = newMatrix;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void markElementAsMatched(int x, int y) {
		if (x < 0 || x > width || y < 0 || y > height) {
			System.out.println("Attention : problème de dimensions");
			return;
		}
		matrix[x][y].setStatus(Status.MATCHED);
	}
	
	public boolean areAllElementsMatched() {
		for (int x = 0; x < width; x++) {
			for (int y =0; y < height; y++) {
				if (matrix[x][y].getStatus().equals(Status.UNMATCHED)) {
					return false;
				}
			}
		}
		return true;
	}
}
