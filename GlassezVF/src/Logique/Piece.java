package Logique;

public class Piece extends Board {

	public Piece(int width, int height, PatternType patternType) {
		super(width, height, patternType);
	}

	public void rotate() {
		Element[][] currentMatrix = this.getAllElements();
		Element[][] newMatrix = calc.rotate(currentMatrix, this.getWidth());
		this.setAllElements(newMatrix);
	}

	public int getPieceValue() {
		int value = 0;
		for (int x = 0; x < getWidth(); x++) {
			for(int y = 0; y < getHeight(); y++) {
				if (getElement(x, y).getDisplay().equals(Display.VISIBLE)) {
					value = value + 50;
				}
			}
		}
		return value;
	}

	@Override
	// Ici on utilise un StringBuffer car plus flexible qu'un String - on aurait pu aussi uitliser un String
	// Mieux pour la garbage collector de Java
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Element[][] matrix = this.getAllElements();
		for (int y = 0; y < this.getHeight(); y++) {
			for (int x = 0; x < this.getWidth(); x++) {
				sb.append("(" + x + "," + y + 
						"){" +  matrix[x][y].getOrientation() + 
						"," + matrix[x][y].getDisplay() +
						"," + matrix[x][y].getStatus() +
						"," + matrix[x][y].getColor() +
						"} "
						);
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}