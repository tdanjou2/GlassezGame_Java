package UI;

import Logique.Orientation;
import Logique.Piece;
import Logique.Calculus;


// Class dédiée aux opérations mathématiques nécessaires dans le package UI


public class CalculusForUI {
	

	public Calculus calc = new Calculus();
	
	public int getXShiftValue(int x, int y) {
		
		if (calc.isEvenNumber(y/2)) {
			return 0;
		} else {
			if ((x+1)%3==0) {
				return (int)(0 + Orientation.A.getr() ); 
			} else {
				return (int)(0 - Orientation.A.getr() );
			}
		}
	}
	
	public int getXShiftValue(int x, int y, Piece p) {
		
		Orientation o = p.getElement(x,y).getOrientation();
		if (calc.isEvenNumber(y/2)) {
			return 0;
		} else {
			if ((x+1)%3==0) {
				return (int)(0 + o.getr()); 
			} else {
				return (int)(0 - o.getr());
			}
		}
	}
	

	public int getYOffset(int x, int y, Piece p) {
		Orientation o = p.getElement(x,y).getOrientation();
		return (int) (Math.sqrt(o.getR()*o.getR() - o.getr()*o.getr() ) + o.getR());
	}
	
	public int getXOffset(int x , int y , Piece p) {
		return (int) (2 * p.getElement(x,y).getOrientation().getr());
	
	}


	
}
