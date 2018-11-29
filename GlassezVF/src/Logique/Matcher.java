package Logique;

public class Matcher {
	
	// On regarde si un Element (qui appartiendra, plus tard quand on appelera la méthode, à une pièce) 
	// Est bien en mesure de matcher avec un Element en position x,y d'un Board
	// On garde en mémoire la couleur qui nous a fait matcher
	
	public boolean isMatch(Board board, Element element, int x, int y, Color referenceColor) {

		if (board == null || element == null) {
			System.out.println("Attention : Ne peut être un null");
			return false;
		}
		if (x < 0 || x > board.getWidth() || y < 0 || y > board.getHeight()) {
			System.out.println("Attention : problème de dimensions");
			return false;
		}
		if (element.getDisplay() == Display.VISIBLE) {
			if (referenceColor.equals(Color.UNDEFINED)) {
				referenceColor = board.getElement(x, y).getColor();
			}
			if (checkElements(board.getElement(x, y), element, referenceColor)) {
				return true;
			}
		}
		return false;
		
	}

	private boolean checkElements(Element board, Element piece, Color colorToMatch) {
		if (board.getColor() != colorToMatch || 
			board.getDisplay() != piece.getDisplay() || 
			board.getOrientation() != piece.getOrientation() || 
			board.getStatus() == Status.MATCHED) {
			return false;
		}
		return true;
	}
}
