# GlassezGame_Java

Requirements gathering

The game:
The user has to fill in a puzzle using shapes presented to him/her on the User Interface.
The user can rotate the shapes before placing them on the canvas.
The user can only place a shape on one color at the time.
The user can trash pieces but this is costing him/her points.
The user has to complete the puzzle in order to access the next level.
The user's score is kept in a score board.
The score board is persisted.

The actors:
The User
The Game

Questions:
Regarding the pieces presented to the user:
Are they random shapes?
I was wondering if the PuzzleGenerator needs to provide the list of shapes a puzzle is made of?
Do the high scores need to be persisted to disk?
Not all of the shapes seem to have the same value. Is this decided based on the number of segments a shape contains?
