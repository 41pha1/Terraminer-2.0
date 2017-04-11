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
	public static boolean a, w, s, d, q, space, shift, e, esc, lbutton, mbutton,rbutton, plus, minus;
	public static boolean ar, wr, sr, dr, qr, spacer, shiftr, er, escr, lbuttonr, mbuttonr,rbuttonr, plusr, minusr;
	public static boolean k1,k2,k3,k4,k5,k6,k7,k8,k9;
	public static int mx, my;
	public static double sa;
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_Q) {
			q = true;
		}
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
		if(e.getKeyCode()==KeyEvent.VK_SHIFT) {
			shift = true;
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
		if(e.getKeyCode()==KeyEvent.VK_Q) {
			q = false;qr=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_W) {
			w = false;wr=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_A) {
			a = false;ar=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_S) {
			s = false;sr=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_D) {
			d = false;dr=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
			esc = false;escr=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_SHIFT) {
			shift = false;shiftr=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_P) {
			plus = false;plusr=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_M) {
			minus = false;minusr=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_E) {
			this.e = false;er=true;
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

	public static boolean isAr() {
		return ar;
	}

	public static void setAr(boolean ar) {
		keyboard.ar = ar;
	}

	public static boolean isWr() {
		return wr;
	}

	public static void setWr(boolean wr) {
		keyboard.wr = wr;
	}

	public static boolean isSr() {
		return sr;
	}

	public static void setSr(boolean sr) {
		keyboard.sr = sr;
	}

	public static boolean isDr() {
		return dr;
	}

	public static void setDr(boolean dr) {
		keyboard.dr = dr;
	}

	public static boolean isQr() {
		return qr;
	}

	public static void setQr(boolean qr) {
		keyboard.qr = qr;
	}

	public static boolean isSpacer() {
		return spacer;
	}

	public static void setSpacer(boolean spacer) {
		keyboard.spacer = spacer;
	}

	public static boolean isShiftr() {
		return shiftr;
	}

	public static void setShiftr(boolean shiftr) {
		keyboard.shiftr = shiftr;
	}

	public static boolean isEr() {
		return er;
	}

	public static void setEr(boolean er) {
		keyboard.er = er;
	}

	public static boolean isEscr() {
		return escr;
	}

	public static void setEscr(boolean escr) {
		keyboard.escr = escr;
	}

	public static boolean isLbuttonr() {
		return lbuttonr;
	}

	public static void setLbuttonr(boolean lbuttonr) {
		keyboard.lbuttonr = lbuttonr;
	}

	public static boolean isMbuttonr() {
		return mbuttonr;
	}

	public static void setMbuttonr(boolean mbuttonr) {
		keyboard.mbuttonr = mbuttonr;
	}

	public static boolean isRbuttonr() {
		return rbuttonr;
	}

	public static void setRbuttonr(boolean rbuttonr) {
		keyboard.rbuttonr = rbuttonr;
	}

	public static boolean isPlusr() {
		return plusr;
	}

	public static void setPlusr(boolean plusr) {
		keyboard.plusr = plusr;
	}

	public static boolean isMinusr() {
		return minusr;
	}

	public static void setMinusr(boolean minusr) {
		keyboard.minusr = minusr;
	}

	public static boolean isQ() {
		return q;
	}

	public static void setQ(boolean q) {
		keyboard.q = q;
	}

	public static boolean isK1() {
		return k1;
	}

	public static void setK1(boolean k1) {
		keyboard.k1 = k1;
	}

	public static boolean isK2() {
		return k2;
	}

	public static void setK2(boolean k2) {
		keyboard.k2 = k2;
	}

	public static boolean isK3() {
		return k3;
	}

	public static void setK3(boolean k3) {
		keyboard.k3 = k3;
	}

	public static boolean isK4() {
		return k4;
	}

	public static void setK4(boolean k4) {
		keyboard.k4 = k4;
	}

	public static boolean isK5() {
		return k5;
	}

	public static void setK5(boolean k5) {
		keyboard.k5 = k5;
	}

	public static boolean isK6() {
		return k6;
	}

	public static void setK6(boolean k6) {
		keyboard.k6 = k6;
	}

	public static boolean isK7() {
		return k7;
	}

	public static void setK7(boolean k7) {
		keyboard.k7 = k7;
	}

	public static boolean isK8() {
		return k8;
	}

	public static void setK8(boolean k8) {
		keyboard.k8 = k8;
	}

	public static boolean isK9() {
		return k9;
	}

	public static void setK9(boolean k9) {
		keyboard.k9 = k9;
	}

	public static void setSa(double sa) {
		keyboard.sa = sa;
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
          lbutton=false; lbuttonr=true;
        }
        if (SwingUtilities.isMiddleMouseButton(mouseEvent)) {
        	mbutton=false;
        }
        if (SwingUtilities.isRightMouseButton(mouseEvent)) {
        	rbutton=false; rbuttonr=true;
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
