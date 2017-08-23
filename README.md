# Gomoku (오목)

<img src="https://user-images.githubusercontent.com/28660183/29639319-f5d4831c-881f-11e7-95ab-8c67eb9c7196.png">

For now, it should run through Eclipse IDE to see console message. 
Original plan was practicing minimax algorithm but it ended up finishing with one human player game.

## what this program can do
1. Resize the map 
2. Check and print winning message in console menu

## What was the challenge?

Checking every winning condition was frustrated since Gomoku has many winning cases that depend on where a player puts the stone. 
Eventually, I checked every each condition. 
There might be a good solution to detect a win.  

```java
public boolean winCheck(int x, int y){
		if(winCheckUp(x,y) || winCheckDown(x, y)||winCheckRight(x, y)||winCheckLeft(x, y)||winCheckUpRight(x,y)
				||winCheckUpleft(x, y)||winCheckDownRight(x, y)||winCheckDownLeft(x, y)){
			return true;
		}
		//special cases 1 
		if(winCheckUp(x,y-1)||winCheckDown(x,y+1)||winCheckRight(x-1, y)||winCheckLeft(x+1, y)||winCheckUpRight(x-1,y+1)
				||winCheckUpleft(x+1, y+1)||winCheckDownRight(x-1, y-1)||winCheckDownLeft(x+1, y-1)
				){
			return true;
		}
		//special cases 2
		if(winCheckUp(x,y-2)||winCheckRight(x-2, y)||winCheckUpRight(x-2,y+2)
				||winCheckUpleft(x+2, y+2)){
			return true;
		}else{
			return false;
		}
	}



