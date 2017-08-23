
public class Match {
	public String player1ClassName, player2ClassName;
	private Player player1, player2;
	private GameState gameContext;
	private int thinkTime;
	private int player1score, player2score;
	public static boolean player1Move;
	
	public Match(String player1, String player2, int thinkTime) throws Exception{
		this.player1ClassName = player1;
		this.player2ClassName = player2;
		this.thinkTime = thinkTime;
		player1score = player2score = -1;
		
	}

	public void loadPlayers() throws Exception{
		player1 = (Player)Class.forName(player1ClassName).newInstance();
		player2 = (Player)Class.forName(player2ClassName).newInstance();
	}
	public int play(){
		//todo
		player1Move = false;
		Player currentMover = player2;

		//boolean playAgain = false;
//		while(!gameContext.gameOver()){
//			
//			System.out.println();
//			if(player1Move){
//				currentMover = player1;
//				System.out.println("Player 1 to move");
//			}else{
//				currentMover = player2;
//				System.out.println("Player 2 to move");
//			}
//			
//		}
		return 0;
		
	}
	
}
