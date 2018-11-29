package Logique;


// Ces Pattern représentent les motifs possible d'un board
// On n'a pas utilisé finalement le pattern ALL_DISABLED
// On avait préféré le rajouter au début car on ne savait 
// Pas très bien où on mettait les pieds..


public enum PatternType {
	
	CHESS_PATTERN, HALF_RED_HALF_GREEN, RED_AND_GREEN_SQUARES, 
	ELEMENT_A_ONLY, ELEMENT_B_ONLY, ELEMENT_C_ONLY, ELEMENT_D_ONLY, ELEMENT_E_ONLY, ELEMENT_F_ONLY,
	FIRST_ROW_VISIBLE_ONLY, FIRST_TWO_ROWS_ENABLED, ALL_ENABLED, ALL_DISABLED,
	PATTERN_PIECES_BLACK,
	
	//PATTERN_PIECES_YELLOW, PATTERN_PIECES_GREEN, PATTERN_PIECES_BLUE, PATTERN_PIECES_WHITE
}

	