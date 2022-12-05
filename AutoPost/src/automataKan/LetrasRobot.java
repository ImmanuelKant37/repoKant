package automataKan;


import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class LetrasRobot {
	public int letra=0;
	ArrayList<Integer> LetrasINT= new ArrayList<Integer>();
	ArrayList<String> LetrasCHAR= new ArrayList<String>();
	////////////////////////////////LETRAS /////////////////
	public int a=KeyEvent.VK_A;
	public int b=KeyEvent.VK_B;
	public int c=KeyEvent.VK_C;
	public int d=KeyEvent.VK_D;
	public int e=KeyEvent.VK_E;
	public int f=KeyEvent.VK_F;
	public int g=KeyEvent.VK_G;
	public int h=KeyEvent.VK_H;
	public int i=KeyEvent.VK_I;
	public int j=KeyEvent.VK_J;
	public int k=KeyEvent.VK_K;
	public int l=KeyEvent.VK_L;
	public int m=KeyEvent.VK_M;
	public int n=KeyEvent.VK_N;
	public int alt=KeyEvent.VK_ALT;
	/////AGREGAR Ñ!!!//////
	public int o=KeyEvent.VK_O;
	public int p=KeyEvent.VK_P;
	public int q= KeyEvent.VK_Q;
	public int r=KeyEvent.VK_R;
	public int s=KeyEvent.VK_S;
	public int t=KeyEvent.VK_T;
	public int u=KeyEvent.VK_U;
	public int v=KeyEvent.VK_V;
	public int w=KeyEvent.VK_W;
	public int x=KeyEvent.VK_X;
	public int y=KeyEvent.VK_Y;
	public int z=KeyEvent.VK_Z;
	public int espacio= KeyEvent.VK_SPACE;
	////////////////////////////////LETRAS /////////////////
	////////////////////////////////ACCIONES /////////////////
	public int Shift = KeyEvent.VK_SHIFT;
	public int Windows = KeyEvent.VK_WINDOWS;
	public int Enter = KeyEvent.VK_ENTER;
	public int Alt = KeyEvent.VK_ALT;
	public int Ctrl = KeyEvent.CTRL_DOWN_MASK;
	public int Tab = KeyEvent.VK_TAB;
	public int Suprimir = KeyEvent.VK_DELETE;
	public int Borrar = KeyEvent.VK_BACK_SPACE;
	public int Escape = KeyEvent.VK_ESCAPE;
	public int Click1= MouseEvent.BUTTON1_MASK;
	public int Click2= MouseEvent.BUTTON2_MASK;
	public int Click3= MouseEvent.BUTTON3_MASK;
public LetrasRobot(){
	LetrasINT.add(a);
	LetrasINT.add(b);
	LetrasINT.add(c);
	LetrasINT.add(d);
	LetrasINT.add(e);
	LetrasINT.add(f);
	LetrasINT.add(g);
	LetrasINT.add(h);
	LetrasINT.add(i);
	LetrasINT.add(j);
	LetrasINT.add(k);
	LetrasINT.add(l);
	LetrasINT.add(m);
	LetrasINT.add(n);
	
	LetrasINT.add(o);
	LetrasINT.add(p);
	LetrasINT.add(q);
	LetrasINT.add(r);
	LetrasINT.add(s);
	LetrasINT.add(t);
	LetrasINT.add(u);
	LetrasINT.add(v);
	LetrasINT.add(w);
	LetrasINT.add(x);
	LetrasINT.add(y);
	LetrasINT.add(z);
	LetrasINT.add(espacio);
	
	LetrasCHAR.add("a");
	LetrasCHAR.add("b");
	LetrasCHAR.add("c");
	LetrasCHAR.add("d");
	LetrasCHAR.add("e");
	LetrasCHAR.add("f");
	LetrasCHAR.add("g");
	LetrasCHAR.add("h");
	LetrasCHAR.add("i");
	LetrasCHAR.add("j");
	LetrasCHAR.add("k");
	LetrasCHAR.add("l");
	LetrasCHAR.add("m");
	LetrasCHAR.add("n");
	
	LetrasCHAR.add("o");
	LetrasCHAR.add("p");
	LetrasCHAR.add("q");
	LetrasCHAR.add("r");
	LetrasCHAR.add("s");
	LetrasCHAR.add("t");
	LetrasCHAR.add("u");
	LetrasCHAR.add("v");
	LetrasCHAR.add("w");
	LetrasCHAR.add("x");
	LetrasCHAR.add("y");
	LetrasCHAR.add("z");
	LetrasCHAR.add(" ");
	
}


public void letraT(String Letra){
	
	String caracter = Letra;

	for (int i = 0; i < LetrasCHAR.size(); i++) {
	
		if(Letra==LetrasCHAR.get(i).intern()){
	
			letra= LetrasINT.get(i);
		}
		
	}

}
}
