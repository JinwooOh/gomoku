
public class Omok {
	public static GUI gui;
	public static final int TIME_LIMIT = 10;
	
	public static void main(String[] args) throws Exception{
		String player1 = null;
		String player2 = null;
		switch(args.length){
		case 1: player2 = args[0];
				player1 = new String("HumanPlayer");
				break;
		case 2: player1 = args[0];
				player2 = args[1];
				break;
		case 0: 
		default:
				player1 = new String("HumanPlayer");
				player2 = new String("HumanPlayer");
				break;
				
		}
		gui = new GUI(player1, player2);
		Match match = new Match(player1, player2, TIME_LIMIT);
		match.loadPlayers();
		int winner = match.play();
	}
}
