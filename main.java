import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class main {
	public static void main(String[] args) {
		draw c = new draw();
		c.setDefaultCloseOperation(draw.EXIT_ON_CLOSE);
		c.setVisible(true);
		board board = new board();
		board.print();
		board.initialBoard();
	}
}


