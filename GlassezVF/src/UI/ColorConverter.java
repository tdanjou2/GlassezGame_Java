package UI;

import java.awt.Color;
import Logique.Element;
import Logique.Status;
import Logique.Display;

// Cette classe est centrale dans le sens qu'elle fait le lien entre la conceptualisation
// Et le package de l'interface graphique
// C'est ici qu'on dit à JAVA que les couleurs du package Logique sont des Couleurs awt

public class ColorConverter {

	private static final int COEFF_TRANSPARENCEU = 35;
	private static final int COEFF_TRANSPARENCEV = 90;

	public Color getColor(Element e) {
		Color result;
		if (e.getStatus()==Status.MATCHED) {
			return Color.PINK;
		}
		
		Logique.Color c = e.getColor();
		switch(c) {
			case RED:
				result = (e.getDisplay()==Display.VISIBLE) ? Color.RED : createTransparentColorUnvisible(Color.RED);
				break;
			case BLUE:
				result = (e.getDisplay()==Display.VISIBLE) ? Color.BLUE : createTransparentColorUnvisible(Color.BLUE); 
				break;
			case GREEN:
				result = (e.getDisplay()==Display.VISIBLE) ? Color.GREEN : createTransparentColorUnvisible(Color.GREEN); 
				break;
			case WHITE:
				result = (e.getDisplay()==Display.VISIBLE) ? Color.WHITE : createTransparentColorUnvisible(Color.WHITE); 
				break;
			case YELLOW:
				result = (e.getDisplay()==Display.VISIBLE) ? Color.YELLOW : createTransparentColorUnvisible(Color.YELLOW); 
				break;	
			case BLACK :
				result = (e.getDisplay()==Display.VISIBLE) ? createTransparentColorVisible(Color.BLACK) : createTransparentColorUnvisible(Color.BLACK); 
				break;	
				
			default:
				result = createTransparentColorUnvisible(Color.BLACK);
		}
		return result;
	}

	private Color createTransparentColorUnvisible(Color color) {
		
		Color transparentColorU = new Color(
				color.getRed(), 
				color.getGreen(), 
				color.getBlue(),
				COEFF_TRANSPARENCEU);
		
		return transparentColorU;
	}	
	
	private Color createTransparentColorVisible(Color color) {
		
		Color transparentColorV = new Color(
				color.getRed(), 
				color.getGreen(), 
				color.getBlue(),
				COEFF_TRANSPARENCEV);
		
		return transparentColorV;
	}	
}