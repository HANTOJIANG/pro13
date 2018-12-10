import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class MyTyping {
	public static void main(String[] args) {
		Frame f = new Frame();//创建一个窗体
		f.setLocationRelativeTo(null);//窗体置中
		f.setSize(500,500);//设置窗体大小
		f.setTitle("alphabet game");
		MyPanel p = new MyPanel();
		f.add(p);//将元素放入窗体中
		f.addKeyListener(p);//注册键盘事件
		p.addKeyListener(p);//注册键盘事件
		Thread t = new Thread(p);
		t.start();
		f.setVisible(true);//显示窗体
		f.addWindowListener(new WindowAdapter()  //为了关闭窗口
				  {
				   public void windowClosing(WindowEvent e)
				   {
				       System.exit(0);
				   }
				  });
		
		
	}
	
}

