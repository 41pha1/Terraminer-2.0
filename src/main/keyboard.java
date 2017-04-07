package main;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.SwingUtilities;

public class keyboard implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
	public static boolean a, w, s, d, space, shift, e, esc, lbutton, mbutton,rbutton, plus, minus;
	public static boolean k1,k2,k3,k4,k5,k6,k7,k8,k9;
	public static int mx, my;
	public static double sa;
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_W) {
			w = true; s = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_A) {
			a = true; d = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_S) {
			s = true; w = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_D) {
			d = true; a = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
			esc = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_P) {
			plus = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_M) {
			minus = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_E) {
			this.e = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_1) {
			k1 = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_2) {
			k2 = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_3) {
			k3 = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_4) {
			k4 = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_5) {
			k5 = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_6) {
			k6 = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_7) {
			k7 = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_8) {
			k8 = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_9) {
			k9 = true;
		}
	}

	public static boolean isPlus() {
		return plus;
	}

	public static void setPlus(boolean plus) {
		keyboard.plus = plus;
	}

	public static boolean isMinus() {
		return minus;
	}

	public static void setMinus(boolean minus) {
		keyboard.minus = minus;
	}

	public static boolean isEsc() {
		return esc;
	}

	public static void setEsc(boolean esc) {
		keyboard.esc = esc;
	}

	public static boolean isA() {
		return a;
	}

	public static void setA(boolean a) {
		keyboard.a = a;
	}

	public static boolean isW() {
		return w;
	}

	public static void setW(boolean w) {
		keyboard.w = w;
	}

	public static boolean isS() {
		return s;
	}

	public static void setS(boolean s) {
		keyboard.s = s;
	}

	public static boolean isD() {
		return d;
	}

	public static void setD(boolean d) {
		keyboard.d = d;
	}

	public static boolean isSpace() {
		return space;
	}

	public static void setSpace(boolean space) {
		keyboard.space = space;
	}

	public static boolean isShift() {
		return shift;
	}

	public static void setShift(boolean shift) {
		keyboard.shift = shift;
	}

	public static boolean isE() {
		return e;
	}

	public static void setE(boolean e) {
		keyboard.e = e;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_W) {
			w = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_A) {
			a = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_S) {
			s = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_D) {
			d = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
			esc = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_P) {
			plus = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_M) {
			minus = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_E) {
			this.e = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_1) {
			k1 = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_2) {
			k2 = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_3) {
			k3 = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_4) {
			k4 = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_5) {
			k5 = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_6) {
			k6 = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_7) {
			k7 = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_8) {
			k8 = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_9) {
			k9 = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {

		
	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {
        int modifiers = mouseEvent.getModifiers();
        if ((modifiers & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
        	lbutton=true;
        }
        if ((modifiers & InputEvent.BUTTON2_MASK) == InputEvent.BUTTON2_MASK) {
        	mbutton=true;
        }
        if ((modifiers & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
        	rbutton=true;
        }
      }

	@Override
      public void mouseReleased(MouseEvent mouseEvent) {
        if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
          lbutton=false;
        }
        if (SwingUtilities.isMiddleMouseButton(mouseEvent)) {
        	mbutton=false;
        }
        if (SwingUtilities.isRightMouseButton(mouseEvent)) {
        	rbutton=false;
        }
      }
	public static boolean isLbutton() {
		return lbutton;
	}

	public static void setLbutton(boolean lbutton) {
		keyboard.lbutton = lbutton;
	}

	public static boolean isMbutton() {
		return mbutton;
	}

	public static void setMbutton(boolean mbutton) {
		keyboard.mbutton = mbutton;
	}

	public static boolean isRbutton() {
		return rbutton;
	}

	public static void setRbutton(boolean rbutton) {
		keyboard.rbutton = rbutton;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mx=e.getX();
		my=e.getY();
		
	}

	public static int getMx() {
		return mx;
	}

	public static void setMx(int mx) {
		keyboard.mx = mx;
	}

	public static int getMy() {
		return my;
	}

	public static void setMy(int my) {
		keyboard.my = my;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) 
	{
		if(e.getWheelRotation()==1)
		{
			sa+=e.getScrollAmount();
		}else sa-=e.getScrollAmount();
	}

	public static double getSa() {
		return sa;
	}

	public static void setSa(int sa) {
		keyboard.sa = sa;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mx=e.getX();
		my=e.getY();
	}
}
