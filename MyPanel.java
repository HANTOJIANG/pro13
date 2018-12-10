
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class MyPanel extends Panel implements Runnable,KeyListener{
	int x[] = new int[10];
	int y[] = new int[10];
	char c[] = new char[10];
	int integral = 1000;
	int count = 0;
	public MyPanel() {
		for (int i = 0; i < 10; i++) {
			x[i]=(int)(Math.random()*300);
			y[i]=(int)(Math.random()*50);
			c[i]=(char)(Math.random()*26+97);
		}
	}

	public void paint(Graphics g) {
		if (integral>0) {
			for (int i = 0; i < 10; i++) {
				g.setFont(new Font("宋体",Font.PLAIN, 33));
				g.drawString(new Character(c[i]).toString().toUpperCase(),x[i],y[i]);
			}   
			g.setColor(Color.red);
			g.setFont(new Font("宋体",Font.PLAIN, 33)); 
		}else {
			g.setColor(Color.red);
			g.setFont(new Font("宋体",Font.PLAIN, 33)); 
			g.drawString("GAME OVER",120, 100);
			g.drawString("你的成绩是："+count+"次",120,250);
		}
	}
	public void run() {
		while (integral>0) {
			for (int i = 0; i < 10; i++) {
				y[i]++;
				if (y[i]>470) {
					y[i]=0;
					x[i]=(int)(Math.random()*300);
					c[i]=(char)(Math.random()*26+97);
					integral-=1000000;
				}
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {}
				repaint();
			}
		}
	}
	
	
	public void speedup(KeyEvent e) 
	{
		 char up = e.getKeyChar();
		 //实现不了。。。
	}
	public void keyPressed(KeyEvent e) {
		char keyC = e.getKeyChar();
		int stat=-1;
		int nowIndex=-1;
		for (int i = 0; i < 10; i++) {
			if (keyC==c[i]) {
				if (y[i]>stat) {
					stat=y[i];
					nowIndex=i;
				}
			}
		}
		if (nowIndex!=-1) {
			y[nowIndex]=0;
			x[nowIndex]=(int)(Math.random()*300);
			c[nowIndex]=(char)(Math.random()*26+97);
			integral+=100;
			count+=1;
		}else {
			integral-=100;
		}
		
	}
 
	public static Color getRandColorCode(){  
		 int r,b,g;
		 r=(int)(Math.random()*250);
		 b=(int)(Math.random()*250);
		 g=(int)(Math.random()*250);
		  Color c =new Color(r, b, g);
	  return c;  
	 }
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	
}
