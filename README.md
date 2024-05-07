# Snake Game - Adaptation
This School Project will be about the game Snake.

The player controls a snake that grows longer as it eats food laying around the field. The player must avoid obstacles/enemies and it's own body.
This game is an adaptation to the classic snake game. 
It will include enemies that search for food too, if the snake touches an enemy it's body will shrink instead of a game over.
The game only ends when the snake shrinks until only it's head is visible or when it hits itself or a obstacle.

//current status

Currently containing the first idea of the game. I can see a picture but it defaults so the game over screen. Needs debugging. Found the spot that needs fixing. After fixing the gameover screen, mainframe and drawPanel needs to be checked of any bugs. shortened the initial layout do to it being too overwhelming and starting small. Will add more classes if finished with a baseline.

//info-dump

The Game instance will not be contained into a box but it will be a semi-open World with paths and food scattered about.
The snake will make it's way through the land, while avoiding enemies. 
The enemies will include flies that steal your food and bad snakes that will try to cut your path (it will not be possible to write all of that in a small time window but this is only a info-dump)
The game will speed up the more the snake eats but will not slow down when the snake shrinks, so a cap the goes higher but not lower.

