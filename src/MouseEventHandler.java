import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseEventHandler extends MouseAdapter{
	private Map map;
	private MapSize ms;
	private MyPanel d;
	private GUI main;
	
	public MouseEventHandler(Map m, MapSize ms, MyPanel d, GUI main){
		map = m;
		this.ms = ms;
		this.d = d;
		this.main = main;
	}
	public void mousePressed(MouseEvent event){
		super.mousePressed(event);
		
		int x = (int) Math.round(event.getX() / (double)ms.getCell()) - 1;
		int y = (int) Math.round(event.getY() / (double)ms.getCell()) - 2;
		if(x < 0 || x > 19 || y < 0 || y > 19){
			return;
		}
		if(map.getXY(y, x) == map.getBlack() || map.getXY(y, x) == map.getWhite()){
			return;
		}
		map.setMap(y, x);
		map.changeTurn();
		
		//TEST: win condition
		if(map.winCheck(x, y)){
			System.out.println("WIN!");
		}
		System.out.println(map.isIllegalMove(1, 1));
		GameState state = new GameState(map);
		//System.out.println(state.toString());
		d.repaint();
	}
}
