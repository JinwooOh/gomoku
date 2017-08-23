import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	public JTextArea textArea;
	public JScrollPane scrollPanel;
	public String player1;
	public String player2;
	private Container c;
	MapSize size = new MapSize();
	
	public GUI(String player1, String player2){
		//display game info
		System.out.println(player1 +" vs "+player2);
		
		c = getContentPane();
		c.setLayout(null);
		Map map = new Map(size);
		int boundSize = size.getSize() * size.getCell() + size.getCell();
		setBounds(200,100,boundSize,boundSize);
		setLocationRelativeTo(null);
		MyPanel d = new MyPanel(size, map);
		setContentPane(d);
		this.addMouseListener(new MouseEventHandler(map, size, d, this));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
