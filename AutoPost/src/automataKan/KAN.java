package automataKan;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JTextField;


public class KAN extends interfaz {
	int posIniciarY=0;
	int posMouseY=0;
	int posVerifY=0;
	  public int contador=1;
	public KAN(int parametroY,int proceso) throws InterruptedException{
		Jframe	= new JFrame();
		contador=proceso;
		posIniciarY=600-parametroY;
		posMouseY=555-parametroY;
		posVerifY=320-parametroY;

	
		
		  Jframe.setLayout(null);
		  Jframe.setVisible(true);
		    //Tamaño de la ventana
		  Jframe.setBounds(10,10,500,500);

		    //Título
		  Jframe.setTitle("Automata v1.0");

		    //No redimensionable
		  Jframe.setResizable(true);

		    //Cerrar proceso al cerrar la ventana
		  Jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		    setearInicio();
		    listaDeAcciones(); 
	}
	
	public void iniciarNuevo() throws InterruptedException {
		contador++;
		KAN n = new KAN(150,contador);
	}
	public void setearInicio() throws InterruptedException{
		
		JButton nuevo =new JButton("Nuevo");
		nuevo.setBounds(410,0,70,25);
		Jframe.add(nuevo);
		
		Jframe.setJMenuBar(barraMenu);
		menu = new JMenu("Menu");
		barraMenu.add(menu);
		
		item= new JMenu("Nuevo");
		menu.add(item);
		nuevo.addActionListener(e->{
			try {
				
				iniciarNuevo();
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
				
			
	);
		
		CampoTexto = new JTextField();
		CampoTexto.setBounds(0,0,250,25);
		 Jframe.add(CampoTexto);
		
		CampoEspera = new JTextField();
		CampoEspera.setBounds(100,260,60,30);
		 Jframe.add(CampoEspera);
		
		textoE.setBounds(50,260,70,30);
		 Jframe.add(textoE);
		
		
		agregarTarea.setBounds(260,0, 80,25);
		 Jframe.add(agregarTarea);
		
		repetirTexto.setBounds(100,230,60,30);
		 Jframe.add(repetirTexto);
		
		textoR.setBounds(50,230,70,30);
		 Jframe.add(textoR);
		
		agregarAccion.setBounds(0,80, 80,60);
		 Jframe.add(agregarAccion);
		
		nAccion.setBounds(290,20,50,30);
		 Jframe.add(nAccion);
		
		nRepeticion.setBounds(375,20,50,30);
		 Jframe.add(nRepeticion);
		
		nEspera.setBounds(420,20,50,30);
		 Jframe.add(nEspera);
		

		Remover.setBounds(270, 250,90, 30);
		 Jframe.add(Remover);
		
		tiempoTexto.setBounds(155, 30, 40, 40);
		 Jframe.add(tiempoTexto);
		
		Guardar.setBounds(270, 280, 90, 30);
		 Jframe.add(Guardar);
		
		Cargar.setBounds(270, 310,90, 30);
		 Jframe.add(Cargar);
			
		Cargar.addActionListener(e->{
			cargarArchivo();
		});
		Guardar.addActionListener(e->guardarArchivo("Hola"));
		
		textoT.setBounds(205,25,80,30);
		tiempoSegundosTexto.setBounds(205,45,80,30);
		 Jframe.add(tiempoSegundosTexto);
		 Jframe.add(textoT);
		ScrollTareas.setViewportView(Tareas);
		ScrollTareas.setBounds(270,50,100,200);
		 Jframe.add(ScrollTareas);
		
		
		ScrollAcciones.setViewportView(Acciones);
		ScrollAcciones.setBounds(100,80,80,150);
		
		ScrollIterar.setViewportView(iterar);
		ScrollIterar.setBounds(370,50, 40,185);
		 Jframe.add(ScrollIterar);
		
		ScrollEspera.setViewportView(listaEsperas);
		ScrollEspera.setBounds(410,50, 80,185);
		 Jframe.add(ScrollEspera);
		 
		 //Seguidor s= new Seguidor();
		agregarAccion.addActionListener(e->tomarAccion());
		
		Remover.addActionListener(e->RemoverDeLista());
		Acciones.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			listaAccionesMas.clear();
			System.out.println(Acciones.getSelectedIndex());
			expandirLista();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
		});
		 Jframe.add(ScrollAcciones);
		
		
		agregarTarea.addActionListener(e->agregarALista());
		 iniciarBtn btnIniciar= new iniciarBtn(posIniciarY);
		 
		   grabarMouse mouse=new grabarMouse(posMouseY);
		textoEsperado verificador = new textoEsperado(posVerifY);
		
		try {
			conexionRemota CR = new conexionRemota();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		 btnIniciar.iniciar.setText("Iniciar: " +Integer.toString(contador));
			mouse.GrabarMouse.setText("Grabar: "+Integer.toString(contador));
			
			
	}
	public void RemoverDeLista() {
		try {
		int index= Tareas.getSelectedIndex();
		if(index!=-1) {
	
		lista.remove(index);
		Repeticiones.remove(index);
		Espera.remove(index);
		}
		int index2= iterar.getSelectedIndex();
		if(index2!=-1) {
	
		lista.remove(index2);
		Repeticiones.remove(index2);
		Espera.remove(index2);
		}
		int index3= listaEsperas.getSelectedIndex();
		if(index3!=-1) {
	
		lista.remove(index3);
		Repeticiones.remove(index3);
		Espera.remove(index3);
		}}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void tomarAccion() {
		agregarRepeticion();
		agregarEspera();
		
		try {
			int index = Tareas.getSelectedIndex();

			String accion = listaAcciones.get(accionSeleccionada).intern();
			String extra = listaAccionesMas.get(AccionesMas.getSelectedIndex());
			if (index == -1) {
				System.out.println("+1");
				lista.add(lista.size(), "->" + accion + extra);
			} else {
				System.out.println("2");
				lista.add(index, "->" + accion + extra);
			}
		} catch (Exception e) {

			int index = Tareas.getSelectedIndex();

			if (index == -1) {
				lista.add(lista.size(), "->Esperar");
				System.out.println(e.getMessage()+"3");
			}else {
				System.out.println(e.getMessage()+"4");
			lista.add(index,"->Esperar");
			}
		}
		
	}

	public void listaDeAcciones() {
		listaAcciones.add(listaAcciones.getSize(), "Shift");
		listaAcciones.add(listaAcciones.getSize(), "Enter");
		listaAcciones.add(listaAcciones.getSize(), "Ctrl");
		listaAcciones.add(listaAcciones.getSize(), "Espacio");

		listaAcciones.add(listaAcciones.getSize(), "Tab");
		listaAcciones.add(listaAcciones.getSize(), "Windows");
		listaAcciones.add(listaAcciones.getSize(), "Alt");
		listaAcciones.add(listaAcciones.getSize(), "Suprimir");
		listaAcciones.add(listaAcciones.getSize(), "Borrar");
		listaAcciones.add(listaAcciones.getSize(), "Escape");
		listaAcciones.add(listaAcciones.getSize(), "ClickIzq");
		listaAcciones.add(listaAcciones.getSize(), "ClickDer");
		listaAcciones.add(listaAcciones.getSize(), "ClickCen");
		listaAcciones.add(listaAcciones.getSize(), "Rueda");

		ScrollAccionesMas.setViewportView(AccionesMas);
		ScrollAccionesMas.setBounds(185, 80, 50, 70);
		Jframe.add(ScrollAccionesMas);
		ScrollAccionesMas.setVisible(false);
	}

	public void agregarMoveMouse() {
		int cantidad = puntos.size();
		int index = Tareas.getSelectedIndex();
		String total = "|";
		for (int j = 0; j < cantidad; j++) {
			String x = Integer.toString(puntos.get(j).x);
			String y = Integer.toString(puntos.get(j).y);
			String punto = x + "|" + y + "|";
			total += punto;
		}

		int posicion = lista.size();
		if (index != -1) {
			posicion = index;
		}
		lista.add(posicion, total);

		puntos.clear();
		agregarRepeticion();
		agregarEspera();
	}

	public void grabando(int tiempo, int precicion) {

		int tiempox = tiempo;
		int precisionx = precicion;
		int tiempoExtra = 0;
		try {

			if (tiempoTexto.getText() != "") {
				tiempox = Integer.parseInt(tiempoTexto.getText());
				tiempoExtra = tiempox * 60;
			}
		} catch (Exception e) {
			System.out.println(e.getCause());
		}

		try {
			contando c = new contando(2, tiempox);
			c.start();
			Thread.sleep(1700);
			ArrayList<PointerInfo> info = new ArrayList<PointerInfo>();

			for (int i = 0; tiempox + tiempoExtra > i; i++) {

				PointerInfo inf = MouseInfo.getPointerInfo();
				info.add(inf);

				Point p = inf.getLocation();
				puntos.add(p);
				int posX = p.x;
				int posY = p.y;

				Thread.sleep(15);
			}
			agregarMoveMouse();
		}

		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void guardarArchivo(String nombre) {

		JFileChooser guardar = new JFileChooser();
		guardar.showSaveDialog(null);
		guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		File archivo = guardar.getSelectedFile();

		guardarFichero(archivo);

	}

	public void guardarFichero(File archivo) {

		try {
			BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo));

			for (int i = 0; i < lista.size(); i++) {

				escribir.write(lista.get(i) + "\n");
			}

			for (int i = 0; i < Repeticiones.size(); i++) {

				escribir.write(Repeticiones.get(i) + "\n");
			}

			for (int i = 0; i < Espera.size(); i++) {

				escribir.write(Espera.get(i) + "\n");
			}
			escribir.close();

		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void cargarArchivo() {
		try {

			JFileChooser cargar = new JFileChooser();
			cargar.showOpenDialog(null);
			cargar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			File archivo = cargar.getSelectedFile();
			CargarFichero(archivo);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void CargarFichero(File arch) {
		lista.clear();
		Repeticiones.clear();
		Espera.clear();
		BufferedReader lector;
		try {
			lector = new BufferedReader(new FileReader(arch));

			BufferedReader lectorDeNuevo;

			lectorDeNuevo = new BufferedReader(new FileReader(arch));

			ArrayList<String> listaCargada = new ArrayList<String>();
			ArrayList<Integer> listaTiempo = new ArrayList<Integer>();

			int cantidadDeLineas = 0;
			try {
				while (lector.readLine() != null) {
					cantidadDeLineas++;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			int elementosTotal = cantidadDeLineas / 3;

			for (int i = 0; i < elementosTotal; i++) {
				try {
					lista.add(i, lectorDeNuevo.readLine());
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
			for (int i = 0; i < elementosTotal; i++) {
				Repeticiones.add(i, Integer.parseInt(lectorDeNuevo.readLine()));
			}
			for (int i = 0; i < elementosTotal; i++) {
				Espera.add(i, Integer.parseInt(lectorDeNuevo.readLine()));
			}
			System.out.println(cantidadDeLineas);
			lector.close();
			lectorDeNuevo.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void mostrar(boolean mostrar) {
		ScrollAccionesMas.setVisible(mostrar);
	}

	public void agregarEspera() {
		String tomaR = CampoEspera.getText();
		int index = Tareas.getSelectedIndex();

		int numero = 1000;
		try {
			numero = Integer.parseInt(tomaR);
		} catch (Exception e) {
			numero = 1000;
		}
		int posicion = Espera.size();
		if (index != -1) {
			posicion = index;
		}
		Espera.add(posicion, numero);

	};

	public void agregarRepeticion() {
		String tomaR = repetirTexto.getText();
		int index = Tareas.getSelectedIndex();
		int numero = 1;
		try {
			numero = Integer.parseInt(tomaR);
		} catch (Exception e) {
			numero = 1;
		}
		int posicion = Repeticiones.size();
		if (index != -1) {
			posicion = index;
		}
		Repeticiones.add(posicion, numero);

	};

	public void masAcciones() {
		listaAccionesMas.clear();
		listaAccionesMas.add(0, "ON");
		listaAccionesMas.add(1, "OFF");
	}

	public void expandirLista() {
		accionSeleccionada = Acciones.getSelectedIndex();

		if (accionSeleccionada != -1) {
			String seleccion = listaAcciones.get(accionSeleccionada).intern();
			if (seleccion == "Shift") {
				mostrar(true);
				masAcciones();
			}

			if (seleccion == "Enter") {
				mostrar(true);
				masAcciones();
			}
			if (seleccion == "Ctrl") {
				mostrar(true);
				masAcciones();
			}
			if (seleccion == "Espacio") {
				mostrar(true);
				masAcciones();
			}

			if (seleccion == "Tab") {
				mostrar(true);
				masAcciones();
			}
			if (seleccion == "Windows") {
				mostrar(true);
				masAcciones();
			}
			if (seleccion == "Suprimir") {
				mostrar(true);
				masAcciones();
			}
			if (seleccion == "Borrar") {
				mostrar(true);
				masAcciones();
			}
			if (seleccion == "Escape") {
				mostrar(true);
				masAcciones();
			}
			if (seleccion == "ClickIzq") {
				mostrar(true);
				masAcciones();
			}
			if (seleccion == "ClickDer") {
				mostrar(true);
				masAcciones();
			}
			if (seleccion == "ClickCen") {
				mostrar(true);
				masAcciones();
			}
			if (seleccion == "Rueda") {
				mostrar(true);
				masAcciones();
			}

		}
	}

	private void agregarALista() {
		int index = Tareas.getSelectedIndex();
		int posicion = Espera.size();
		if (index != -1) {
			posicion = index;
		}

		String TextoActual = CampoTexto.getText();
		lista.add(posicion, TextoActual);
		agregarRepeticion();
		agregarEspera();
	}

	public void iniciarRobot() {
		nuevaTarea tarea1 = new nuevaTarea();
		tarea1.run();
	}

/*	@Override
	public void run() {
		try {


		} catch (InterruptedException e) {
			// TODO Auto-generated catch block

		}
	}
*/
	class nuevaTarea extends Thread {

		public nuevaTarea() {

		}

		@Override
		public void run() {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < lista.size(); i++) {

				String TextoActual = lista.get(i).intern();
				ToDo Analiza = new ToDo(TextoActual);

				if (!TextoActual.contains("->") && !TextoActual.startsWith("|")) {
					System.out.println("Escribiendo...: " + Analiza.palabra);
					try {
						Analiza.comparaLetras();
					} catch (AWTException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						sleep(Espera.get(i));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				if (TextoActual.contains("->")) {
					for (int j = 0; j < Repeticiones.get(i); j++) {
						System.out.println("Funcion...: " + Analiza.palabra + " " + j);

						try {
							Analiza.analizaAccion(TextoActual);
						} catch (AWTException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						try {
							sleep(Espera.get(i));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if (TextoActual.startsWith("|")) {
					System.out.println("Moviendo a...: " + Analiza.palabra + " ");
					try {
						String separador = Pattern.quote("|");
						String[] cortex = Analiza.palabra.split(separador);
						Analiza.moverMouse(cortex);
					} catch (AWTException | InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	}

	class contando extends Thread {
	public int segundos1=0;
	public int segundosEsperados1=0;
	public int segundos2=0;
	public int segundosEsperados2=0;
	contando (int segundosAntes,int segundosDespues){
		this.segundos1=segundosAntes;
		this.segundosEsperados1=segundosAntes;
		
		this.segundos2=segundosDespues;
		this.segundosEsperados2=segundosDespues;
	}
	@Override 
	public void run() {
		for (int i = 1; i <= segundosEsperados1; i++) {
			try {
				System.out.println(segundos1);
				String seg= String.valueOf(segundos1);
				 Jframe.setTitle("Iniciando en: "+seg);
			
				sleep(1000);
				segundos1--;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	
		
		for (int i = 1; i <= segundosEsperados2; i++) {
			try {
				System.out.println(segundos2);
				String seg= String.valueOf(segundos2);
				 Jframe.setTitle("Finalizando en: "+seg);
			
				sleep(1000);
				segundos2--;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		 Jframe.setTitle("Automata v1.0");
	}
	
	
}	

	class grabarMouse extends JFrame {

	public int posY = 555;
	
	JButton GrabarMouse = new JButton("Mouse: 1");

	public grabarMouse(int posY) {
		this.posY = posY;
		setUndecorated(true);
		setLayout(null);
		setVisible(true);

		setBounds(930, posY, 100, 40);

		setTitle("Automata v1.0");

		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GrabarMouse.setBounds(0, 0, 100, 40);
		add(GrabarMouse);

		GrabarMouse.addActionListener(e -> grabando(10, 100));

	}
}

	class conexionRemota {

	JFrame modoRemoto = new JFrame();
	JLabel textoRecibido = new JLabel();
	JLabel miIp = new JLabel();
	JLabel puertoText = new JLabel("Puerto");
	JTextField miPuerto = new JTextField();
	int puerto=0;
	String ip="";
	JButton aceptar = new JButton("Iniciar");
	public InetAddress getIP() throws UnknownHostException {
		return InetAddress.getLocalHost();
	}

	public conexionRemota() throws InterruptedException, UnknownHostException {
		Thread.sleep(500);
		modoRemoto.setLayout(null);
		modoRemoto.setVisible(true);
		// Tamaño de la ventana
		modoRemoto.setBounds(500, 400,250, 250);

		// Título
		modoRemoto.setTitle("Servidor");

		// No redimensionable
		modoRemoto.setResizable(false);

		// Cerrar proceso al cerrar la ventana
		modoRemoto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		aceptar.setBounds(0,100,100,30);
		miIp.setBounds(0,-5,250,30);
		miPuerto.setBounds(55,40,70,30);
		textoRecibido.setBounds(0,150,50,30);
		puertoText.setBounds(0,40,50,30);
		modoRemoto.add(puertoText);
		modoRemoto.add(miIp);
		modoRemoto.add(miPuerto);
		modoRemoto.add(textoRecibido);
		modoRemoto.add(aceptar);
		miIp.setText(getIP().toString());
		aceptar.addActionListener(e->iniciar());
	
	}

	
	
	public void iniciar() {
		puerto = Integer.valueOf(miPuerto.getText());
		con c=new con(puerto);
		c.start();
	}
	}
	class con extends Thread{
		ServerSocket Servidor;
		Socket SocketEsperado;
		int puerto=0;
		con(int puerto){
			this.puerto=puerto;
		}

		@Override
		public void run() {
		try {
			
			
			Servidor = new ServerSocket(puerto);
			int puertoActual = Servidor.getLocalPort();
			System.out.println("Servidor activo en puerto: " + puertoActual);
			DataInputStream entrada;
			DataOutputStream salida;
			
			while (true) {
			

				SocketEsperado = Servidor.accept();
			
				entrada = new DataInputStream(SocketEsperado.getInputStream());
				salida = new DataOutputStream(SocketEsperado.getOutputStream());

				String ConexionExitosa = entrada.readUTF();
				
				System.out.println(ConexionExitosa);
				salida.writeUTF("Exito");

				SocketEsperado.close();
				
			}

		} catch (IOException e) {

		}
	}}

	

	class iniciarBtn extends JFrame {
	private static final long serialVersionUID = 1L;
	public int posY = 600;
	JButton iniciar = new JButton("Iniciar: 1");

	iniciarBtn(int posY) {
		this.posY = posY;
		setUndecorated(true);

		setLayout(null);
		setVisible(true);
		// Tamaño de la ventana
		setBounds(930, posY, 100, 40);

		// Título
		setTitle("Automata v1.0");

		// No redimensionable
		setResizable(false);

		// Cerrar proceso al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciar.setBounds(0, 0, 100, 40);
		add(iniciar);
		iniciar.addActionListener(e -> iniciar());

	}

}
	
	
	public void iniciar() {
	nuevaTarea n = new nuevaTarea();
	n.start();
}

	class textoEsperado extends JFrame {
	private static final long serialVersionUID = 1L;
	public int posY = 500;
	JButton iniciar = new JButton("Verificar");
	JComboBox esperado = new JComboBox();
	JTextField texto = new JTextField("HOLA");
	JLabel esperadoTexto = new JLabel();

	textoEsperado(int posY) {
		this.posY = posY;
		setUndecorated(true);

		setLayout(null);
		setVisible(true);
		// Tamaño de la ventana
		setBounds(800, posY, 100, 150);

		// Título
		setTitle("Verificador");

		// No redimensionable
		setResizable(false);

		// Cerrar proceso al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		texto.setBounds(0, 0, 100, 40);
		esperado.setBounds(0, 40, 100, 40);
		add(texto);
		add(esperado);

		esperadoTexto.setText("Texto");
		esperadoTexto.setBounds(30, 125, 70, 20);
		add(esperadoTexto);
		esperado.addItem("Texto");
		esperado.addItem("Texto2");
		iniciar.setBounds(0, 80, 100, 40);
		add(iniciar);
		iniciar.addActionListener(e -> verificar());
		esperado.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) {
					System.out.println(e.getItem().toString());
					esperadoTexto.setText(e.getItem().toString());

				}

			}
		});
	}

	public void verificar() {
		if (texto.getText().intern() == esperadoTexto.getText().intern()) {
			System.out.println("Verificado");
		}
	}
}

	public void esperarTexto() {
	nuevaTarea n = new nuevaTarea();
	n.start();
}

	
}
