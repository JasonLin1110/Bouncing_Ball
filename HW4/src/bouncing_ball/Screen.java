package bouncing_ball;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Screen {
	private Color c=Color.gray;
	private int width=0,height=0;
	public Screen(int w, int h) {
		width=w-10;
		height=h;
	}
	public int getheight() {
		return height;
	}
	public int getwidth() {
		return width;
	}
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillRect(0, 0, width, height);
	}
}