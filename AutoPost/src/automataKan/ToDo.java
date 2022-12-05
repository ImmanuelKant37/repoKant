package automataKan;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
public class ToDo {
public String palabra;
boolean ShiftON=false;

ArrayList<String> letras = new ArrayList<String>();
int cantidadLetras=0;
public int LetraNumero=0;
	public ToDo(String palabra){
		
		this.palabra= palabra;
		analizaPalabra();
		
	}
	public void analizaPalabra(){
		cantidadLetras=palabra.length();
		for (int i = 0; i < cantidadLetras; i++) {
			String x=palabra.substring(i,i+1);			
			char tcaracter =x.charAt(0);
			if(Character.isUpperCase(tcaracter)) {
			x=x.toLowerCase();
			ShiftON=true;
			}
			letras.add(x);
	
		}
		for (int i = 0; i < cantidadLetras; i++) {

		}
	}
	public void analizaAccion(String p) throws AWTException{
		Robot robot = new Robot();
		LetrasRobot ana = new LetrasRobot();
		System.out.println("Analizando accion...");
		System.out.println("Palabra a analizar: "+palabra);
		
		if(p=="->ShiftON")
		{
			robot.keyPress(ana.Shift);
			System.out.println("Shift Activo");
		}
		if(p=="->ShiftOFF")
		{
			robot.keyRelease(ana.Shift);
		}
		if(p=="->EnterON")
		{
			robot.keyPress(ana.Enter);
		}
		
		if(p=="->EnterOFF")
		{
			robot.keyRelease(ana.Enter);
		}
		if(p=="->CtrlON")
		{
			robot.keyPress(ana.Ctrl);
		}
		
		if(p=="->CtrlOFF")
		{
			robot.keyRelease(ana.Ctrl);
		}
		///1
		if(p=="->EspacioON")
		{
			robot.keyPress(ana.espacio);
		}
		
		if(p=="->EspacioOFF")
		{
			robot.keyRelease(ana.espacio);
		}
		
		///2
		if(p=="->TabON")
		{
			robot.keyPress(ana.Tab);
		}
		
		if(p=="->TabOFF")
		{
			robot.keyRelease(ana.Tab);
		}
		
		///3
		if(p=="->Esperar")
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}

		///4
		if(p=="->WindowsON")
		{
			robot.keyPress(ana.Windows);
		}
		
		if(p=="->WindowsOFF")
		{
			robot.keyRelease(ana.Windows);
		}
		///5
		if(p=="->SuprimirON")
		{
			robot.keyPress(ana.Suprimir);
		}
		
		if(p=="->SuprimirOFF")
		{
			robot.keyRelease(ana.Suprimir);
		}
		///6
		if(p=="->BorrarON")
		{
			System.out.println("BorrarONText");
			robot.keyPress(ana.Borrar);
		}
		
		if(p=="->BorrarOFF")
		{
			robot.keyRelease(ana.Borrar);
		}
		///7
		if(p=="->EscapeON")
		{
			robot.keyPress(ana.Escape);
		}
		
		if(p=="->EscapeOFF")
		{
			robot.keyRelease(ana.Escape);
		}
		///8
		if(p=="->AltON")
		{
			robot.keyPress(ana.Alt);
		}
		
		if(p=="->AltOFF")
		{
			robot.keyRelease(ana.Alt);
		}
		///9
		if(p=="->ClickIzqON")
		{
			robot.mousePress(ana.Click1);
		}
		
		if(p=="->ClickIzqOFF")
		{
			robot.mouseRelease(ana.Click1);
		}
		///10
		
		if(p=="->ClickDerON")
		{
			robot.mousePress(ana.Click2);
		}
		
		if(p=="->ClickDerOFF")
		{
			robot.mouseRelease(ana.Click2);
		}
		///11

		if(p=="->ClickCenON")
		{
			robot.mousePress(ana.Click3);
		}
		
		if(p=="->ClickCenOFF")
		{
			robot.mouseRelease(ana.Click3);
		}
		///12
		if(p=="->RuedaON")
		{
			robot.mouseWheel(100);;
		}
		
		if(p=="->RuedaOFF")
		{
			robot.mouseWheel(-100);;
		}
		///13
		///14
		
	}
	 

	public  void comparaLetras() throws AWTException{
		Robot robot= new Robot();
		LetrasRobot ana = new LetrasRobot();
		for(int i=0; i<cantidadLetras;i++){
		
			
				
				ana.letraT(letras.get(i).intern());
				LetraNumero=ana.letra;
				if(ShiftON) {
				robot.keyPress(ana.Shift);
				}
				robot.keyPress(LetraNumero);
				robot.keyRelease(LetraNumero);
				if(ShiftON) {
				robot.keyRelease(ana.Shift);
				ShiftON=false;
				}
			
			}
		try{
			
			
		}
			catch(Exception e){
				System.out.println(e.getLocalizedMessage());
			}
			
		}
		public void moverMouse(String[] puntos) throws AWTException, InterruptedException {
			ArrayList<Integer> NuevoPuntox=new ArrayList<Integer>();
			ArrayList<Integer> NuevoPuntoy=new ArrayList<Integer>();
			int i=0;
			java.util.List<String> lista= Arrays.asList(puntos);
			
		
			for (i = 1; i <lista.size();) {
			
				
				int pxn= Integer.parseInt(lista.get(i));
				NuevoPuntox.add(pxn);
			
				i++;
				i++;
			}
			for (i = 2; i <lista.size();) {
			
				
				int pyn= Integer.parseInt(lista.get(i));
			
				NuevoPuntoy.add(pyn);
				i++;
				i++;
				
			}
				
			Robot robot = new Robot();
			LetrasRobot ana = new LetrasRobot();
			ArrayList<Point> NuevoPunto=new ArrayList<Point>();
			
			
			for (int j = 0; j < NuevoPuntox.size(); j++) {
				int px= NuevoPuntox.get(j);
				int py= NuevoPuntoy.get(j);
				robot.mouseMove(px, py);
			
				Thread.sleep(15);
			}
			
			
		};

}
