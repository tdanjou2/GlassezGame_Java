package UI;

import java.awt.Graphics;

import javax.swing.JPanel;

import Logique.Board;
import Logique.PatternType;
import Logique.Status;

public class BoardPanel extends JPanel{
	
	private static final int NB_BOARDS = 6;
	private int currentBoardIndex = 0;
	private Board[] boards = new Board[NB_BOARDS];
	private BoardController boardController;
    private PieceLayeredPane piecePane;	
	
	public BoardPanel() {
		piecePane = new PieceLayeredPane(this);
        add(piecePane);
        initBoard();
		this.boardController = new BoardController(boards[0]);
	}
	
	private void initBoard() {
		
		boards[0] = new Board(20,20, PatternType.ALL_ENABLED);
		boards[1] = new Board(30,30, PatternType.RED_AND_GREEN_SQUARES);
		boards[2] = new Board(20,10, PatternType.HALF_RED_HALF_GREEN);
		boards[3] = new Board(10,10, PatternType.CHESS_PATTERN);
		boards[4] = new Board(10,10, PatternType.FIRST_TWO_ROWS_ENABLED);
		boards[5] = new Board(10,10, PatternType.ALL_DISABLED);	
	}

	public void nextBoard() {
		currentBoardIndex++;
		currentBoardIndex = currentBoardIndex < NB_BOARDS ? currentBoardIndex : 0;
	
		System.out.println("currentBoardIndex=" + currentBoardIndex);
		setBoard(boards[currentBoardIndex]);
	}

	public BoardController getController() {
		return boardController;
	}

	public Board getBoard() {
		return boards[currentBoardIndex];
	}
	
	public void setBoard(Board board) {		
		for (int x = 0 ; x < board.getWidth() ; x++) {
			for (int y = 0; y < board.getHeight(); y++) {
				board.getElement(x, y).setStatus(Status.UNMATCHED);
			}
		}
		
		this.boardController = new BoardController(board);
		repaint();
	}
    
    public PieceLayeredPane getPiecePane() {
    		return piecePane;
    }
    
	@Override
    public void paintComponent(Graphics g) {
		boardController.draw(g);
	}	
}