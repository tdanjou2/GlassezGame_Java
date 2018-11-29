package Logique;
import Logique.Board;

public class Calculus {
	
	Board board;
	
	int DEFAULT_MATRIX_HEIGHT = board.DEFAULT_MATRIX_HEIGHT;
	int DEFAULT_MATRIX_WIDTH = board.DEFAULT_MATRIX_WIDTH;
	
	// Test si un nombre est pair ou non
	// Cette classe avait vocation à rassembmer toutes les opérations mathématiques pour le projet
	
	public boolean isEvenNumber(int nb) {
		if ((nb % 2) == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public void adjustWidthAndHeight(int width, int height) {

		if ((width < 1) || (width > DEFAULT_MATRIX_HEIGHT)) {
			width = DEFAULT_MATRIX_WIDTH;
		}
		if ((height < 1) || (height > DEFAULT_MATRIX_HEIGHT)) {
			height = DEFAULT_MATRIX_HEIGHT;
		}

		int max = width > height ? width : height;

		max = max % 2 == 0 ? max : max + 1;
		width = max;
		height = max;
	}
	
	public Element[][] rotate(Element[][] matrix, int n) {
		
		Element[][] newMatrix = new Element[n][n];
//		if ( n == 1) {
//			
//			System.out.println("Matrice avant");
//			printMatrix(matrix, n);
//			
//			
//			if (matrix[0][0].getOrientation() == Orientation.A) {
//				newMatrix[0][0] = new Element (matrix[0][0].getColor(), matrix[0][0].getDisplay(), Orientation.B,  matrix[0][0].getStatus());
//			}
//			if (matrix[0][0].getOrientation() == Orientation.B) {
//				newMatrix[0][0] = new Element (matrix[0][0].getColor(), matrix[0][0].getDisplay(), Orientation.C,  matrix[0][0].getStatus());}
//			if (matrix[0][0].getOrientation() == Orientation.C) {
//				newMatrix[0][0] = new Element (matrix[0][0].getColor(), matrix[0][0].getDisplay(), Orientation.D,  matrix[0][0].getStatus());}
//			if (matrix[0][0].getOrientation() == Orientation.A) {
//				newMatrix[0][0] = new Element (matrix[0][0].getColor(), matrix[0][0].getDisplay(), Orientation.E,  matrix[0][0].getStatus());}
//			if (matrix[0][0].getOrientation() == Orientation.A) {
//				newMatrix[0][0] = new Element (matrix[0][0].getColor(), matrix[0][0].getDisplay(), Orientation.F,  matrix[0][0].getStatus());}
//			if (matrix[0][0].getOrientation() == Orientation.A) {
//				newMatrix[0][0] = new Element (matrix[0][0].getColor(), matrix[0][0].getDisplay(), Orientation.A,  matrix[0][0].getStatus());}
//			}
		
//		else {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				newMatrix[i][j] = matrix[i][j];
			}
		}
		
		System.out.println("Matrice avant");
		printMatrix(matrix, n);
		for (int layer = 0; layer < n / 2; ++layer) {

			int last = n - 1 - layer;
			for (int i = layer; i < last; ++i) {
				int offset = i - layer;
				Element buffer = matrix[layer][i];


				set(newMatrix[layer][i], matrix[last-offset][layer]);

				set(newMatrix[last - offset][layer], matrix[last][last - offset]);

				set(newMatrix[last][last - offset], matrix[i][last]);

				set(newMatrix[i][last], buffer);

			}
		}

		System.out.println("Matrice après :");
		printMatrix(newMatrix, n);
		return newMatrix;
	}

	public void set(Element newElement, Element oldElement) {
		if (newElement != null && oldElement != null) {
			newElement.setColor(oldElement.getColor());
			newElement.setDisplay(oldElement.getDisplay());
			newElement.setStatus(oldElement.getStatus());
		}
	}
	
	
	// Affiche le détails d'une matrice (d'un board)
	
	public void printMatrix(Element[][] matrix, int n) {
		System.out.print("\n");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(" " + matrix[i][j].getOrientation());
			}
			System.out.print("\n");
		}
	}
	
	
	
}
