import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	private MapSize size;
	private Map map;
	private final int STONE_SIZE=28; //stone size
	public MyPanel(MapSize m,Map map) {
		// TODO Auto-generated constructor stub
		setBackground(new Color(206,168,60)); //background color
		size=m;
		setLayout(null);
		this.map=map;
	}
	@Override
	public void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintComponent(arg0);
		arg0.setColor(Color.BLACK); 
		board(arg0); //draw board
		drawStone(arg0); //draw stone
	}
	public void board(Graphics arg0) {
		for(int i=1;i<=size.getSize();i++){
			arg0.drawLine(size.getCell(), i*size.getCell(), size.getCell()*size.getSize(), i*size.getCell()); 
			arg0.drawLine(i*size.getCell(), size.getCell(), i*size.getCell() , size.getCell()*size.getSize()); 
			
		}
	}
	public void drawStone(Graphics arg0) {
		for(int y=0;y<size.getSize();y++){
			for(int x=0;x<size.getSize();x++){
				if(map.getXY(y, x)==map.getBlack())
					drawBlack(arg0,x,y);
				else if(map.getXY(y, x)==map.getWhite())
					drawWhite(arg0, x, y);
			}
		
		}
		
	}
	public void drawBlack(Graphics arg0,int x,int y){
		arg0.setColor(Color.BLACK);
		arg0.fillOval((x+1)*size.getCell()-15, (y)*size.getCell()+15, STONE_SIZE, STONE_SIZE);

	}
	public void drawWhite(Graphics arg0,int x,int y){
		arg0.setColor(Color.WHITE);
		arg0.fillOval(x*size.getCell()+15, y*size.getCell()+15, STONE_SIZE, STONE_SIZE);
		
	}



}