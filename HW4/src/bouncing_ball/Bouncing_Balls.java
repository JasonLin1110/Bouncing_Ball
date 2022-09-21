package bouncing_ball;

import java.awt.*;
import java.lang.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JPanel;

public class Bouncing_Balls{
	private int width,height; 
	private JFrame frame;
	private Mypanel panels;
	private Screen screen;
	private ArrayList<Ball> balls;
	private int ball_num=0;
	
	class WindowMonitor extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	
	class Mypanel extends JPanel implements MouseListener {
		Mypanel(){
			setSize(width, height);
			setLocation(0, 0);
			setLayout(null);
			addMouseListener(this);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if(ball_num==0) {
				Ball a=new Ball(screen);
				a.set_position(e.getX(),e.getY());
				balls.add(a);
			}
			else {
				Random ran1 = new Random(),ran2 = new Random(),ran3 = new Random();
				Color color = new Color(ran1.nextInt(256), ran2.nextInt(256), ran3.nextInt(256));
				Ball a=new Ball(screen,color);
				a.set_position(e.getX(),e.getY());
				balls.add(a);
			}
			ball_num++;
		}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			screen.draw(g);
			for(int i=0; i<ball_num; i++)
				balls.get(i).draw(g);
		}
	}
	public Bouncing_Balls(int w,int h) {
		width=w;
		height=h;
		if(height<100 || width<100) {
			width=1280;
			height=720;
		}
		frame = new JFrame("Bouncing Balls");
		frame.addWindowListener(new WindowMonitor());
		frame.setSize(width, height);
		frame.setLayout(null);
		frame.setVisible(true);
		panels=new Mypanel();
		screen=new Screen(w,h);
		balls=new ArrayList<Ball>();
		frame.add(panels);
		Thread thread = new Thread() {
			public void run() {
				while(true) {
					for(int i=0;i<ball_num;i++) {
						balls.get(i).move(screen);
					}
					panels.repaint();
					try {
						Thread.sleep(500);
					} catch(Exception ex) {}
				}
			}
		};
		thread.start();
	}
}