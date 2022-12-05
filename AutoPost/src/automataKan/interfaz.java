package automataKan;

import javax.swing.JFrame;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class interfaz{

	JFrame Jframe;
	JTextField CampoTexto;
	JTextField repetirTexto=new JTextField();
	JTextField CampoEspera=new JTextField();
	
	JTextField tiempoTexto=new JTextField();
	JLabel textoT = new JLabel("Tiempo");
	JLabel tiempoSegundosTexto=new JLabel("Segundos");
	
	JButton agregarTarea= new JButton("Escribir");
	JButton agregarAccion= new JButton("Accion");
	
	JButton Remover= new JButton("Remover");
	JButton Guardar= new JButton("Guardar");
	JButton Cargar= new JButton("Cargar");
	
	JLabel textoR = new JLabel("Repetir: ");
	JLabel textoE = new JLabel("Esperar: ");
	
	JLabel nAccion = new JLabel("Accion");
	JLabel nRepeticion = new JLabel("X");
	JLabel nEspera = new JLabel("Espera");
	

	DefaultListModel<String> lista= new DefaultListModel<String>();
	DefaultListModel<String> listaAcciones= new DefaultListModel<String>();
	DefaultListModel<String> listaAccionesMas= new DefaultListModel<String>();
	DefaultListModel<Integer> Repeticiones= new DefaultListModel<Integer>();
	DefaultListModel<Integer> Espera= new DefaultListModel<Integer>();
	
	JList Tareas = new JList(lista);
	JList Acciones = new JList(listaAcciones);
	
	ArrayList<Point> puntos = new ArrayList<Point>();

	JFileChooser GuardarArchivo = new JFileChooser();
	JFileChooser CargarArchivo = new JFileChooser();
	
	JList AccionesMas = new JList(listaAccionesMas);
	JList iterar = new JList(Repeticiones);
	JList listaEsperas = new JList(Espera);
	
	JScrollPane ScrollTareas =new JScrollPane(Tareas);
	JScrollPane ScrollAcciones =new JScrollPane(Acciones);
	JScrollPane ScrollAccionesMas =new JScrollPane(AccionesMas);
	JScrollPane ScrollIterar = new JScrollPane(iterar);
	JScrollPane ScrollEspera= new JScrollPane(listaEsperas);
	
	boolean esPalabra=false;
	boolean esAccion=false;
	int accionSeleccionada=0;
	int detalleSelect=0;
	
	JMenu menu= new JMenu();
	JMenuItem item = new JMenuItem();
	JMenuBar barraMenu = new JMenuBar();
	

	/*@Override
	public void run() {
		try{
			KAN kan = new KAN(0,1);
		}
		catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}*/

	public interfaz(){
	
	}	public static void main(String[] args) {
		try{
			
			KAN kan = new KAN(0,1);
		}
		catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	
	}
}
