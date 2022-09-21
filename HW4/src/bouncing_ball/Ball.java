package bouncing_ball;

import java.awt.*;
import java.lang.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Ball{
	public Color ball_color = Color.BLUE;
	private int p_x=0,p_y=0,r=10,m_x=0,m_y=0;
	public Ball(Screen screen) {
			Random ranx = new Random(),rany = new Random();
			m_x=ranx.nextInt(20)+1;
			m_y=rany.nextInt(20)+1;
			if(m_x>10) m_x=-1*(m_x-10);
			if(m_y>10) m_y=-1*(m_y-10);
			System.out.println("m_x= "+m_x+" m_y= "+m_y);
	}
	public Ball(Screen screen, Color c) {
		ball_color=c;
		Random ranx = new Random(),rany = new Random();
		m_x=ranx.nextInt(20)+1;
		m_y=rany.nextInt(20)+1;
		if(m_x>10) m_x=-1*(m_x-10);
		if(m_y>10) m_y=-1*(m_y-10);
		System.out.println("m_x= "+m_x+" m_y= "+m_y);
	}
	public void set_position(int x,int y) {
		p_x=x;
		p_y=y;
	}
	public void draw(Graphics g) {
		g.setColor(ball_color);
		g.fillOval((int)(p_x), (int)(p_y), (int)(2 * r), (int)(2 * r));
	}
	public void move(Screen screen) {
		p_x=p_x+m_x;
		p_y=p_y+m_y;
		if(p_x<0) {
			m_x=-m_x;
		}
		else if(p_x>screen.getwidth()-25) {
			m_x=-m_x;
		}
		if(p_y<0) {
			m_y=-m_y;
		}
		else if(p_y>screen.getheight()-60) {
			m_y=-m_y;
		}
	}
}