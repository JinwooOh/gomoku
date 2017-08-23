
public abstract class Player {
	protected int[][] move; //store current best move for the player
	private String screenName;
	private int whichPlayer;
	
	Player(){
		screenName = new String("");
		whichPlayer = 1;
		
	}
	
	public abstract void move(GameState context);
	public void initialize(String screenName, int whichPlayer){
		this.screenName = screenName;
		if(whichPlayer > 2 || whichPlayer < 1){
			this.whichPlayer = 1;
		}else{
			this.whichPlayer = whichPlayer;
		}
	}
	public String getDisplayName(){
		return screenName;
	}
	public int[][] getMove(){
		return move;
	}
}
