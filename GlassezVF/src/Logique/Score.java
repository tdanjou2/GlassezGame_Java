package Logique;

public class Score {

	private int scoreValue = 0;

	// On ne rajoute pas toujours la même valeur au score (un multiple de 50)
	public void increaseScore(Piece piece) {
		scoreValue = scoreValue + piece.getPieceValue();
	}

	public void decreaseScore(Piece piece) {
		
		// On s'assure que le score ne puisse être négatif
		scoreValue = scoreValue - piece.getPieceValue();
		scoreValue = scoreValue < 0? 0 : scoreValue;
	}

	
	public int getScoreValue() {
		return scoreValue;
	}
	
}