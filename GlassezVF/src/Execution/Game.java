package Execution;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Logique.Element;
import Logique.Orientation;
import Logique.PatternType;
import Logique.Display;
import Logique.Color;
import Logique.Status;
import Logique.Calculus;
import Logique.Board;
import Logique.Piece;
import UI.ColorConverter;
import UI.PieceController;
import UI.ElementWithCoordinates;
import java.util.ArrayList;
import java.util.List;
import UI.BoardController;
import Logique.Matcher;
import UI.Indexes;


public class Game {

	private JFrame frame;
	private GameMgr gameMgr;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
		
					Game window = new Game();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}		
);
		
//		Calculus calc  = new Calculus ();
//		Element element1 = new Element ( Color.BLUE, Display.VISIBLE,  Orientation.A  , Status.MATCHED );
//		Element element2 = new Element(Color.YELLOW, Display.VISIBLE,  Orientation.B  , Status.MATCHED);
//		Element element3 = new Element(Color.GREEN, Display.VISIBLE,  Orientation.F  , Status.MATCHED);
//		Element element4 = new Element(Color.BLUE, Display.VISIBLE,  Orientation.E  , Status.MATCHED);
//		String string1 = element1.toString();
//		String string2 = element2.toString();
//		String string3 = element3.toString();
//		String string4 = element4.toString();
//		System.out.println(string1);
//		System.out.println(string2);
//		System.out.println(string3);
//		System.out.println(string4);
//		
//		Element [][] matriceElement = {{element1}};
//		calc.printMatrix(matriceElement , 1);
//		calc.rotate(matriceElement, 1);
	}
	

	public Game() {
		gameMgr = new GameMgr();
		initialize();
	}

	private void initialize() {
		JPanel panelCenter = new JPanel();
		JPanel boardPanel = gameMgr.getBoardPanel();		
		JPanel controlPanel = new JPanel();
		
		panelCenter.add(controlPanel);
		panelCenter.add(boardPanel);

		frame = new JFrame();
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));		
		frame.getContentPane().add(panelCenter, BorderLayout.CENTER);

		// Bouton Poubelle
		JButton btnTrash = new JButton("Next Board");
		btnTrash.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    //System.out.println("Board suivant");
			    gameMgr.nextBoard();
			  } 
			} );		
		controlPanel.add(btnTrash);

		// Bouton Rotation
		JButton btnNewButton = new JButton("Rotate");
		btnNewButton.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    //System.out.println("Rotation");
			    gameMgr.rotate();
			  } 
			} );		
		controlPanel.add(btnNewButton);

		// Bouton Next Piece
		JButton btnNextPieceButton = new JButton("Next Piece");
		// Un boutton sur lequel on peut cliquer
		btnNextPieceButton.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    //System.out.println("Piece suivante");
			    gameMgr.nextPiece();
			  } 
			} );				
		controlPanel.add(btnNextPieceButton);
	}
}