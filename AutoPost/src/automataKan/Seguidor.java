package automataKan;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Seguidor {
	Robot robot;
		private static final long serialVersionUID = 1L;
		JLabel marca = new JLabel("X");
		JFrame jframe = new JFrame();
	Seguidor(){
		System.out.println("Seguidor tomado");
		marca.setBounds(0,0,5,5);
		jframe.add(marca);
		jframe.setBounds(0,0,5,5);
		jframe.setUndecorated(true);
		jframe.setLayout(null);
		jframe.setVisible(true);
	
		jframe.setTitle("Seguidor");
		jframe.setResizable(false);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new tomarPosicion().start();
		jframe.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			
			}

			public void tomarTecla() throws AWTException {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				try {
					
					robot = new Robot();
					jframe.setExtendedState(JFrame.ICONIFIED);
					Thread.sleep(100);	
					robot.keyPress(e.getKeyCode());
					robot.keyRelease(e.getKeyCode());
					
					
					Thread.sleep(100);	
					jframe.setExtendedState(JFrame.NORMAL);
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}});
		jframe.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
			
			
				try {
					robot= new Robot();
				
				
				jframe.setExtendedState(JFrame.ICONIFIED);
				Thread.sleep(50);			
				robot.mousePress(e.getModifiersEx());
				Thread.sleep(20);
				robot.mouseRelease(e.getModifiersEx());
			
				
					
				jframe.setExtendedState(JFrame.NORMAL);
				} catch (AWTException | InterruptedException a) {
					
				}
	
				
				

			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
			
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}});
		
		
	}
		
	
		
	
		class tomarPosicion extends Thread{
			tomarPosicion(){
				
			}
			@Override
			public void run() {
				while(true) {
					PointerInfo inf = MouseInfo.getPointerInfo();
					Point p = inf.getLocation();
					jframe.setBounds(p.x-3,p.y-3, 10,10);
	}
			}
			
		}
		
		
}
		





