
public class GameState {
	public static final int GAME_NOT_OVER = Integer.MIN_VALUE;
	public static final int GAME_OVER_BlACKWIN = 1;
	public static final int GAME_OVER_TIE = 0;
	public static final int GAME_OVER_WHITEWIN = -1;
	public Map map;
	public int[][] mapStatus; 
	//initiate new setting
	
	public GameState(Map map){
		this.map = map;
		this.mapStatus = map.getMapinfo();
	}
	
	public int status(){
		for(int y = 0; y < mapStatus.length; y++){
			for(int x = 0; x <mapStatus[y].length; x++){
				if(map.getXY(y, x)!=0){
					if(map.winCheck(x, y)){
						if(map.getXY(y, x) == GAME_OVER_BlACKWIN){
							return GAME_OVER_BlACKWIN;
						}else{
							return GAME_OVER_WHITEWIN;
						}
					}
				}
			}
		}
		return GAME_NOT_OVER;
	}
	
	public boolean gameOver(){
		return status() != GAME_NOT_OVER;
	}
	public void applyMove(int x, int y){
		//todo 
		map.setMap(y, x);
	}
	
	public String toString(){
		String result = "";
		for(int y = 0; y < mapStatus.length; y++){
			for(int x = 0; x <mapStatus[y].length; x++){
				if(this.map.getXY(y, x) == 1){
					result += "B ";
				}
				else if(this.map.getXY(y, x)== -1){
					result += "W ";
				}
				else{
					result += "0 ";
				}
			}
			result+="\n";
		}
		return result;
	}
	
}
