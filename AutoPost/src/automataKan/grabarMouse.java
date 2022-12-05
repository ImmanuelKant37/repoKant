package automataKan;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class grabarMouse extends Thread implements MouseListener, MouseMotionListener{
	int clicks;
	int posicionX;
	int posicionY;
public grabarMouse() {
	System.out.println(clicks);
}

@Override
public void mouseClicked(MouseEvent e) {
	clicks=e.getButton();
	System.out.println(e.getButton());
}

@Override
public void mousePressed(MouseEvent e) {
	System.out.println(e.getSource());
	
}

@Override
public void mouseReleased(MouseEvent e) {
	System.out.println(e.getSource());
	
}

@Override
public void mouseEntered(MouseEvent e) {
	System.out.println(e.getSource());
	
}

@Override
public void mouseExited(MouseEvent e) {
	System.out.println(e.getSource());
	
}

@Override
public void mouseDragged(MouseEvent e) {
	System.out.println(e.getSource());
	
}

@Override
public void mouseMoved(MouseEvent e) {
	System.out.println(e.getXOnScreen());
	
}
public int getClick() {
	return clicks;
}
public int getX() {
	return posicionX;
}


@Override 
public void run() {
	getClick();
}
}
