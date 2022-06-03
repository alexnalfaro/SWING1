package EJERCICIO1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GestorVisual extends JFrame implements ActionListener
{
	JTextField texto_id;
	JTextField texto_nombre;
	JTextField texto_ciudad;
	JTextField texto_telefono;
	JTextField texto_fecha;
	JLabel label_texto;
	JComboBox combo;
	public GestorVisual()
	{
		this.setTitle("STUDENT MANAGER");
		this.setSize(500,300);
		this.setLayout(new BorderLayout());
		
		JPanel panelnorte = new JPanel();
		JPanel panelcentro = new JPanel();
		JPanel paneloeste = new JPanel();
		JPanel panelsur = new JPanel();
		
		// PANEL NORTE
		añadirelementosNorte(panelnorte);
		this.add(panelnorte,BorderLayout.NORTH);
		
		// PANEL ESTE
		añadirelementosCentro(panelcentro);
		this.add(panelcentro,BorderLayout.CENTER);
		
		// PANEL OESTE
		añadirelementosOeste(paneloeste);
		this.add(paneloeste,BorderLayout.WEST);
		
		// PANEL SUR 
		añadirelementosSur(panelsur);
		this.add(panelsur,BorderLayout.SOUTH);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void añadirelementosNorte (Container a)
	{
		JLabel labeltitulo = new JLabel ("STUDENTS MANAGER");
		labeltitulo.setFont(new Font ("Arial",Font.BOLD,15));
		a.add(labeltitulo);
	}
	
	public void añadirelementosOeste(Container a)
	{
		JPanel panelinterno = new JPanel();
		panelinterno.setLayout(new BoxLayout(panelinterno, BoxLayout.Y_AXIS));
		panelinterno.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
		JLabel label_id = new JLabel ("ID:");
		JLabel label_nombre = new JLabel ("Nombre:");
		JLabel label_ciudad = new JLabel ("Ciudad:");
		JLabel label_tfno = new JLabel ("Telefono:");
		JLabel label_fecha = new JLabel ("Fecha de nacimiento:");
		panelinterno.add(label_id);
		panelinterno.add(label_nombre);
		panelinterno.add(label_ciudad);
		panelinterno.add(label_tfno);
		panelinterno.add(label_fecha);
		panelinterno.setBackground(Color.RED);
		a.add(panelinterno);
	}
	
	public void añadirelementosCentro(Container a)
	{
		
		JPanel panelinterno = new JPanel();
		panelinterno.setBackground(Color.CYAN);
		panelinterno.setLayout(new BoxLayout(panelinterno, BoxLayout.Y_AXIS));
		texto_id = new JTextField ();
		JTextField texto_nombre = new JTextField ();
		texto_nombre.setColumns(25);
		JTextField texto_ciudad = new JTextField ();
		JTextField texto_tfno = new JTextField ();
		JTextField texto_fecha = new JTextField ();
		panelinterno.add(texto_id);
		panelinterno.add(texto_nombre);
		panelinterno.add(texto_ciudad);
		panelinterno.add(texto_tfno);
		panelinterno.add(texto_fecha);
		a.add(panelinterno);
		
	}
	
	
	public void añadirelementosSur (Container a)
	{
		a.setLayout(new BorderLayout());
		JPanel panelArriba = new JPanel ();
		panelArriba.setBackground(Color.GREEN);
		//PANEL ARRIBA 
		String [] b = {"ASIR","DAW"};
		JLabel label_curso = new JLabel ("Curso");
		combo = new JComboBox ();
		for (int i=0;i<b.length;i++)
		{
			combo.addItem(b[i]);
		}
		panelArriba.add(label_curso);
		panelArriba.add(combo);
		
		JPanel panelCentro = new JPanel ();
		panelCentro.setBackground(Color.BLUE);
		//PANEL CENTRO
		JButton boton_buscar = new JButton ("Buscar");
		boton_buscar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id_texto = texto_id.getText();
				GestorEstudiantes G1 = new GestorEstudiantes();
				Estudiante E1 = G1.buscarEstudiante(id_texto);
				String nombreestudiante = E1.getNombre();
				label_texto.setText("Nombre: "+nombreestudiante);
			}
			
		});
		JButton boton_insertar = new JButton ("Insertar");
		JButton boton_modificar = new JButton ("Modificar");
		JButton boton_eliminar = new JButton ("Eliminar");
		
		panelCentro.add(boton_buscar);
		panelCentro.add(boton_insertar);
		panelCentro.add(boton_modificar);
		panelCentro.add(boton_eliminar);
		
		JPanel panelAbajo = new JPanel();
		panelAbajo.setBackground(Color.YELLOW);
		//PANEL ABAJO
		label_texto = new JLabel();
		panelAbajo.add(label_texto);
		a.add(panelArriba,BorderLayout.NORTH);
		a.add(panelCentro,BorderLayout.CENTER);
		a.add(panelAbajo,BorderLayout.SOUTH);
	}
	
	public static void main (String [] args)
	{
		GestorVisual G1 = new GestorVisual();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
