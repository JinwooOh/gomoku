//Map class that contain board information and check win condition. 
public class Map {
	//2d array map; black = 1, white = -1, unoccupied = 0
	private int[][] map;
	private final int BLACK = 1;
	private final int WHITE = -1;
	//true = black turn, false = white turn
	private boolean checkTurn = true;
	
	public Map(MapSize ms){
		map = new int[ms.getSize()][];
		for(int i = 0; i < map.length; i++){
			map[i] = new int[ms.getSize()];
		}
	}
	public int getBlack(){
		return BLACK;
	}
	public int getWhite(){
		return WHITE;
	}
	public int getXY(int y, int x){
		return map[y][x];
		
	}
	public void changeTurn(){
		if(checkTurn){
			checkTurn = false;
		}else{
			checkTurn = true;
		}
	}
	public void setMap(int y, int x){
		if(checkTurn){
			map[y][x] = BLACK;
		}else{
			map[y][x] = WHITE;
		}
	}
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
	
	//check each direction for winning condition
	public boolean winCheckUp(int x, int y){
		try{
			for(int i = y; i < y+5; i++){
				if(map[y][x] != map[i][x]){
					return false;
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
		return true;
	}
	public boolean winCheckDown(int x, int y){
		try{
			for(int i = y; i > y-5; i--){
				if(map[y][x] != map[i][x]){
					return false;
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
		return true;
	}
	public boolean winCheckRight(int x, int y){
		try{
			for(int i = x; i < x+5; i++){
				if(map[y][x] != map[y][i]){
					return false;
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
		return true;
	}
	public boolean winCheckLeft(int x, int y){
		try{
			for(int i = x; i > x-5; i--){
				if(map[y][x] != map[y][i]){
					return false;
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
		return true;
	}
	public boolean winCheckUpRight(int x, int y){
		try{
			for(int i = y, z=x; i > y-5; i--, z++){
				if(map[y][x] != map[i][z]){
					return false;
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
		return true;
	}
	public boolean winCheckUpleft(int x, int y){
		try{
			for(int i = y, z=x; i > y-5; i--, z--){
				if(map[y][x] != map[i][z]){
					return false;
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
		return true;
	}
	public boolean winCheckDownRight(int x, int y){
		try{
			for(int i = y, z=x; i < y+5; i++, z++){
				if(map[y][x] != map[i][z]){
					return false;
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
		return true;
	}
	public boolean winCheckDownLeft(int x, int y){
		try{
			for(int i = y, z=x; i < y+5; i++, z--){
				if(map[y][x] != map[i][z]){
					return false;
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
		return true;
	}
	
	public int[][] getMapinfo(){
		return map;
	}
	public boolean isIllegalMove(int x, int y){
		int currentColor = getXY(x, y);
		if(currentColor != 0){ // the position is already occupied by B or W
			return true;
		}else{
			return false;
		}
	}
	
	
	
	
	
	
	
}
