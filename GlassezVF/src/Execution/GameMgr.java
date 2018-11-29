package Execution;

import UI.BoardPanel;
import UI.PieceLayeredPane;

public class GameMgr {

	private BoardPanel boardPanel = new BoardPanel();

	public void nextBoard() {
		boardPanel.nextBoard();
	}
	
	// On veut pouvoir utiliser notre BoardPanel plus tard dans la classe Game
	public BoardPanel getBoardPanel() {
		return boardPanel;
	}
	
	// On cherche à obtenir la piece suivante
	public void nextPiece() {
		PieceLayeredPane pieceLayeredPane = boardPanel.getPiecePane();
        boardPanel.getController().getScore().decreaseScore(pieceLayeredPane.getCurrentPiece());
		pieceLayeredPane.nextPiece();
	}
	
	// Rotation d'une piece
	public void rotate() {
	    PieceLayeredPane pieceLayeredPane = boardPanel.getPiecePane();
	    pieceLayeredPane.rotate();
	 }	
}