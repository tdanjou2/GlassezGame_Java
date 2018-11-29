package Logique;

import java.util.List;

import UI.BoardController;
import UI.ElementWithCoordinates;
import UI.Indexes;
import UI.PieceController;

public class Demonstrations {
//	
//	Matcher mat = new Matcher();
//	Calculus calc  = new Calculus ();
//	
////	Element element1 = new Element ( Color.BLUE, Display.VISIBLE,  Orientation.A  , Status.MATCHED );
////	Element element2 = new Element(Color.YELLOW, Display.VISIBLE,  Orientation.B  , Status.MATCHED);
////	Element element3 = new Element(Color.GREEN, Display.VISIBLE,  Orientation.F  , Status.MATCHED);
////	Element element4 = new Element(Color.BLUE, Display.VISIBLE,  Orientation.E  , Status.MATCHED);
////	
////	String string1 = element1.toString();
////	String string2 = element2.toString();
////	String string3 = element3.toString();
////	String string4 = element4.toString();
////	
////	System.out.println(string1);
////	System.out.println(string2);
////	System.out.println(string3);
////	System.out.println(string4);
////	
////	Element [][] matriceElement = {{element1,element2},{element3,element4}};
////	calc.printMatrix(matriceElement , 2);
////	calc.rotate(matriceElement, 2);
////	
//	Board board = new Board(4,4,PatternType.ALL_ENABLED);
////	calc.printMatrix(board.getAllElements() , 4);
////	for (int i = 0 ; i < 4 ; i++ ) {
////		for ( int j = 0 ; j < 4 ; j ++ ) {
////			System.out.print(board.getElement(i, j).toString());
////		}
////		System.out.print("/n");
////	}
//	
//	Piece piece1 = new Piece(2,2,PatternType.FIRST_ROW_VISIBLE_ONLY);
//	calc.printMatrix(piece1.getAllElements() , 2);
//	for (int i = 0 ; i < 2 ; i++ ) {
//		for ( int j = 0 ; j < 2 ; j ++ ) {
//			System.out.print(piece1.getElement(i, j).toString());
//		}
//		System.out.print("/n");
//		
//	}
//	BoardController boardController = new BoardController(board);
//	PieceController pieceController = new PieceController(piece1);
//	List <ElementWithCoordinates > ewcs = pieceController.getListOfPixelsCoordinatesForTheCenterOfAllElements();
//	boolean isMatch = true;
//	for (ElementWithCoordinates ewc : ewcs ) {
//		Indexes indexes = boardController.getIndexesForPixelCoordinates((int)(ewc.getP().getX()), (int)(ewc.getP().getX()));
//		if (indexes == null) {
//			isMatch = false;
//			break;
//		}
//		
//		boolean resul = mat.isMatch(board, piece1.getElement(x, y));
//	}
}
